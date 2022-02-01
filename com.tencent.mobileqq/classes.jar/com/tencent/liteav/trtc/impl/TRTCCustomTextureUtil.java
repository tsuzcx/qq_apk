package com.tencent.liteav.trtc.impl;

import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.i;
import com.tencent.liteav.basic.opengl.j;
import com.tencent.liteav.basic.util.c;
import com.tencent.liteav.beauty.b.k;
import com.tencent.liteav.d;
import com.tencent.trtc.TRTCCloudDef.TRTCTexture;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoFrame;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TRTCCustomTextureUtil
{
  private static final String TAG = "TRTCCustomTextureUtil";
  private d mCaptureAndEnc;
  private long mCaptureFrameCount = 0L;
  private double mCurrentFps = 0.0D;
  private Object mEGLContext = null;
  private HandlerThread mEGLThread = null;
  private final c mFpsMeter;
  private int mGLSyncMode = 0;
  private i mGLThreadHandler = null;
  private k mI4202RGBAFilter = null;
  private long mLastCaptureCalculateTS = 0L;
  private long mLastCaptureFrameCount = 0L;
  private long mLastGLThreadId;
  private j mRotateFilter;
  
  public TRTCCustomTextureUtil(d paramd, int paramInt)
  {
    this.mCaptureAndEnc = paramd;
    this.mFpsMeter = new c("send-custom-texture", (int)TimeUnit.SECONDS.toMillis(5L));
    this.mGLSyncMode = paramInt;
    paramd = new StringBuilder();
    paramd.append("TRTCCustomTextureUtil: glMode:");
    paramd.append(paramInt);
    apiLog(paramd.toString());
  }
  
  private void apiLog(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("trtc_api ");
    localStringBuilder.append(paramString);
    TXCLog.i("TRTCCustomTextureUtil", localStringBuilder.toString());
  }
  
  private void checkEGLContext(TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame)
  {
    if (paramTRTCVideoFrame == null) {
      return;
    }
    int i = 0;
    boolean bool = false;
    if (this.mLastGLThreadId == Thread.currentThread().getId())
    {
      if (paramTRTCVideoFrame.texture != null)
      {
        i = bool;
        if (paramTRTCVideoFrame.texture.eglContext10 != null)
        {
          bool = paramTRTCVideoFrame.texture.eglContext10.equals(this.mEGLContext) ^ true;
          i = bool;
          if (bool)
          {
            apiLog("CustomCapture egl10Context change!");
            i = bool;
          }
        }
        if (paramTRTCVideoFrame.texture.eglContext14 != null)
        {
          bool = paramTRTCVideoFrame.texture.eglContext14.equals(this.mEGLContext) ^ true;
          i = bool;
          if (bool)
          {
            apiLog("CustomCapture egl14Context change!");
            i = bool;
          }
        }
      }
    }
    else
    {
      apiLog("CustomCapture eglContext's thread change!");
      i = 1;
    }
    this.mLastGLThreadId = Thread.currentThread().getId();
    if (paramTRTCVideoFrame.texture != null) {
      if (paramTRTCVideoFrame.texture.eglContext10 != null) {
        this.mEGLContext = paramTRTCVideoFrame.texture.eglContext10;
      } else {
        this.mEGLContext = paramTRTCVideoFrame.texture.eglContext14;
      }
    }
    if (i != 0)
    {
      stopThread();
      startThread(paramTRTCVideoFrame);
    }
  }
  
  private int checkRotate(int paramInt, TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame)
  {
    int i = paramInt;
    if (paramTRTCVideoFrame != null)
    {
      if (paramTRTCVideoFrame.rotation == 0) {
        return paramInt;
      }
      int j = paramTRTCVideoFrame.rotation;
      if (this.mRotateFilter == null)
      {
        localj = new j();
        localj.a();
        localj.a(true);
        localj.a(paramTRTCVideoFrame.width, paramTRTCVideoFrame.height);
        this.mRotateFilter = localj;
      }
      j localj = this.mRotateFilter;
      i = paramInt;
      if (localj != null)
      {
        GLES20.glViewport(0, 0, paramTRTCVideoFrame.width, paramTRTCVideoFrame.height);
        i = (720 - j * 90) % 360;
        localj.a(paramTRTCVideoFrame.width, paramTRTCVideoFrame.height);
        localj.a(paramTRTCVideoFrame.width, paramTRTCVideoFrame.height, i, null, paramTRTCVideoFrame.width / paramTRTCVideoFrame.height, false, false);
        localj.b(paramInt);
        j = localj.l();
        if ((i != 90) && (i != 270)) {
          paramInt = paramTRTCVideoFrame.width;
        } else {
          paramInt = paramTRTCVideoFrame.height;
        }
        if ((i != 90) && (i != 270)) {
          i = paramTRTCVideoFrame.height;
        } else {
          i = paramTRTCVideoFrame.width;
        }
        paramTRTCVideoFrame.width = paramInt;
        paramTRTCVideoFrame.height = i;
        i = j;
      }
    }
    return i;
  }
  
  private void sendCustomTextureInternal(TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame)
  {
    try
    {
      if (this.mGLThreadHandler != null)
      {
        if (this.mGLSyncMode == 0) {
          GLES20.glFinish();
        }
        i locali = this.mGLThreadHandler;
        this.mGLThreadHandler.post(new TRTCCustomTextureUtil.1(this, locali, paramTRTCVideoFrame));
      }
      return;
    }
    finally {}
  }
  
  private void startThread(TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame)
  {
    if (paramTRTCVideoFrame == null) {
      return;
    }
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    label303:
    try
    {
      if (this.mEGLThread == null)
      {
        this.mEGLThread = new HandlerThread("customCaptureGLThread");
        this.mEGLThread.start();
        this.mGLThreadHandler = new i(this.mEGLThread.getLooper());
        if (paramTRTCVideoFrame.texture == null)
        {
          apiLog("CustomCapture buffer start egl10 thread");
          this.mGLThreadHandler.d = false;
          this.mGLThreadHandler.h = null;
          this.mGLThreadHandler.a = 1280;
          this.mGLThreadHandler.b = 720;
          this.mGLThreadHandler.sendEmptyMessage(100);
        }
        else if (paramTRTCVideoFrame.texture.eglContext10 != null)
        {
          apiLog("CustomCapture texture start egl10 thread");
          this.mGLThreadHandler.d = false;
          this.mGLThreadHandler.h = paramTRTCVideoFrame.texture.eglContext10;
          this.mGLThreadHandler.a = 1280;
          this.mGLThreadHandler.b = 720;
          this.mGLThreadHandler.sendEmptyMessage(100);
        }
        else if ((paramTRTCVideoFrame.texture.eglContext14 != null) && (Build.VERSION.SDK_INT >= 17))
        {
          apiLog("CustomCapture texture start egl14 thread");
          this.mGLThreadHandler.d = true;
          this.mGLThreadHandler.f = paramTRTCVideoFrame.texture.eglContext14;
          this.mGLThreadHandler.a = 1280;
          this.mGLThreadHandler.b = 720;
          this.mGLThreadHandler.sendEmptyMessage(100);
        }
        this.mGLThreadHandler.post(new TRTCCustomTextureUtil.2(this, localCountDownLatch));
      }
      else
      {
        localCountDownLatch.countDown();
      }
    }
    finally {}
    try
    {
      localCountDownLatch.await();
      return;
    }
    catch (InterruptedException paramTRTCVideoFrame)
    {
      break label303;
    }
    Thread.currentThread().interrupt();
  }
  
  private void stopThread()
  {
    try
    {
      if (this.mGLThreadHandler != null)
      {
        j localj = this.mRotateFilter;
        this.mRotateFilter = null;
        k localk = this.mI4202RGBAFilter;
        this.mI4202RGBAFilter = null;
        this.mGLThreadHandler.post(new TRTCCustomTextureUtil.3(this, localj, localk));
        i.a(this.mGLThreadHandler, this.mEGLThread);
        apiLog("CustomCapture destroy egl thread");
      }
      this.mGLThreadHandler = null;
      this.mEGLThread = null;
      return;
    }
    finally {}
  }
  
  public double getCurrentFPS()
  {
    long l1 = SystemClock.elapsedRealtime();
    long l2 = l1 - this.mLastCaptureCalculateTS;
    if (l2 >= 1000L)
    {
      long l3 = this.mCaptureFrameCount;
      double d1 = l3 - this.mLastCaptureFrameCount;
      Double.isNaN(d1);
      double d2 = l2;
      Double.isNaN(d2);
      this.mCurrentFps = (d1 * 1000.0D / d2);
      this.mLastCaptureFrameCount = l3;
      this.mLastCaptureCalculateTS = l1;
    }
    return this.mCurrentFps;
  }
  
  public void release()
  {
    stopThread();
  }
  
  public void sendCustomTexture(TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame)
  {
    this.mFpsMeter.a();
    checkEGLContext(paramTRTCVideoFrame);
    sendCustomTextureInternal(paramTRTCVideoFrame);
    if (this.mLastCaptureCalculateTS == 0L)
    {
      this.mLastCaptureCalculateTS = SystemClock.elapsedRealtime();
      this.mLastCaptureFrameCount = 0L;
      this.mCaptureFrameCount = 0L;
      return;
    }
    this.mCaptureFrameCount += 1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCustomTextureUtil
 * JD-Core Version:    0.7.0.1
 */