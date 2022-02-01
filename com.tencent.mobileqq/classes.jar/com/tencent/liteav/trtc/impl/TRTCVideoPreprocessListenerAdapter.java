package com.tencent.liteav.trtc.impl;

import android.annotation.SuppressLint;
import android.opengl.GLES20;
import com.tencent.liteav.basic.a.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.TXCOpenGlUtils;
import com.tencent.liteav.basic.opengl.e.a;
import com.tencent.liteav.basic.util.e;
import com.tencent.liteav.beauty.b.k;
import com.tencent.liteav.beauty.b.o;
import com.tencent.liteav.m;
import com.tencent.trtc.TRTCCloudDef.TRTCTexture;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoFrame;
import com.tencent.trtc.TRTCCloudListener.TRTCVideoFrameListener;
import java.nio.ByteBuffer;

public class TRTCVideoPreprocessListenerAdapter
  implements m
{
  private static final String TAG = "TRTCVideoPreprocessListenerAdapter";
  private int mBufferType;
  private final a mDelayQueue = new a();
  private int mFrameBufferId = -1;
  private boolean mHasNotifiedGLContextCreated = false;
  private final e mLastFrameSize = new e(0, 0);
  private TRTCCloudListener.TRTCVideoFrameListener mListener;
  private int mPixelFormat;
  private o mRGBAToYUVFilter;
  private final TRTCCloudDef.TRTCVideoFrame mShadowInputFrame = new TRTCCloudDef.TRTCVideoFrame();
  private final TRTCCloudDef.TRTCVideoFrame mShadowOutputFrame = new TRTCCloudDef.TRTCVideoFrame();
  private final TRTCCloudDef.TRTCVideoFrame mYUVInputFrame = new TRTCCloudDef.TRTCVideoFrame();
  private final TRTCCloudDef.TRTCVideoFrame mYUVOutputFrame = new TRTCCloudDef.TRTCVideoFrame();
  private k mYUVToRGBAFilter;
  
  private void convertTextureToYUV(int paramInt, TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame)
  {
    int i = paramTRTCVideoFrame.width;
    int j = paramTRTCVideoFrame.height;
    Object localObject = getRGBAToYUVFilter(paramTRTCVideoFrame.pixelFormat, i, j);
    GLES20.glViewport(0, 0, i, j);
    ((o)localObject).a(i, j);
    TXCOpenGlUtils.a(((o)localObject).b(paramInt), this.mFrameBufferId);
    localObject = e.a.a;
    if (paramTRTCVideoFrame.pixelFormat == 1) {
      localObject = e.a.b;
    } else if (paramTRTCVideoFrame.pixelFormat == 4) {
      localObject = e.a.c;
    }
    GLES20.glBindFramebuffer(36160, this.mFrameBufferId);
    if (paramTRTCVideoFrame.bufferType == 1) {
      TXCOpenGlUtils.a((e.a)localObject, i, j, paramTRTCVideoFrame.buffer);
    } else {
      TXCOpenGlUtils.a((e.a)localObject, i, j, paramTRTCVideoFrame.data);
    }
    TXCOpenGlUtils.d(this.mFrameBufferId);
  }
  
  private void convertYUVToTexture(TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame, int paramInt)
  {
    if ((paramTRTCVideoFrame.data == null) && (paramTRTCVideoFrame.buffer == null)) {
      return;
    }
    int i = paramTRTCVideoFrame.width;
    int j = paramTRTCVideoFrame.height;
    k localk = getYUVToRGBAFilter(paramTRTCVideoFrame.pixelFormat, i, j);
    TXCOpenGlUtils.a(paramInt, this.mFrameBufferId);
    GLES20.glViewport(0, 0, i, j);
    if (paramTRTCVideoFrame.bufferType == 2) {
      localk.a(paramTRTCVideoFrame.data);
    } else if (paramTRTCVideoFrame.bufferType == 1) {
      localk.a(paramTRTCVideoFrame.buffer);
    }
    GLES20.glBindFramebuffer(36160, this.mFrameBufferId);
    localk.a(-1, this.mFrameBufferId, paramInt);
    TXCOpenGlUtils.d(this.mFrameBufferId);
  }
  
  private o getRGBAToYUVFilter(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mRGBAToYUVFilter == null)
    {
      if (paramInt1 == 1) {
        paramInt1 = 1;
      } else {
        paramInt1 = 3;
      }
      this.mRGBAToYUVFilter = new o(paramInt1);
      this.mRGBAToYUVFilter.a(true);
      if (!this.mRGBAToYUVFilter.a()) {
        TXCLog.e("TRTCVideoPreprocessListenerAdapter", "init RGBA to YUV filter failed.");
      }
      this.mRGBAToYUVFilter.a(paramInt2, paramInt3);
    }
    return this.mRGBAToYUVFilter;
  }
  
  private k getYUVToRGBAFilter(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mYUVToRGBAFilter == null)
    {
      int i = 1;
      if (paramInt1 == 1) {
        paramInt1 = i;
      } else {
        paramInt1 = 3;
      }
      this.mYUVToRGBAFilter = new k(paramInt1);
      if (!this.mYUVToRGBAFilter.a()) {
        TXCLog.e("TRTCVideoPreprocessListenerAdapter", "init YUV to RGBA failed.");
      }
      this.mYUVToRGBAFilter.a(paramInt2, paramInt3);
    }
    return this.mYUVToRGBAFilter;
  }
  
  @SuppressLint({"NewApi"})
  private static void initVideoFrame(TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramTRTCVideoFrame.width = paramInt1;
    paramTRTCVideoFrame.height = paramInt2;
    paramTRTCVideoFrame.pixelFormat = paramInt3;
    paramTRTCVideoFrame.bufferType = paramInt4;
    if ((paramInt3 == 2) && (paramTRTCVideoFrame.texture == null))
    {
      paramTRTCVideoFrame.texture = new TRTCCloudDef.TRTCTexture();
      Object localObject = TXCOpenGlUtils.e();
      if ((localObject instanceof android.opengl.EGLContext))
      {
        paramTRTCVideoFrame.texture.eglContext14 = ((android.opengl.EGLContext)localObject);
        return;
      }
      paramTRTCVideoFrame.texture.eglContext10 = ((javax.microedition.khronos.egl.EGLContext)localObject);
      return;
    }
    if ((paramInt3 == 1) || (paramInt3 == 4))
    {
      if ((paramInt4 == 2) && (paramTRTCVideoFrame.data == null))
      {
        paramTRTCVideoFrame.data = new byte[paramInt1 * paramInt2 * 3 / 2];
        return;
      }
      if ((paramInt4 == 1) && (paramTRTCVideoFrame.buffer == null)) {
        paramTRTCVideoFrame.buffer = ByteBuffer.allocateDirect(paramInt1 * paramInt2 * 3 / 2);
      }
    }
  }
  
  private void notifyGLContextCreated()
  {
    TRTCCloudListener.TRTCVideoFrameListener localTRTCVideoFrameListener = this.mListener;
    if ((localTRTCVideoFrameListener != null) && (!this.mHasNotifiedGLContextCreated))
    {
      localTRTCVideoFrameListener.onGLContextCreated();
      this.mHasNotifiedGLContextCreated = true;
    }
  }
  
  private void notifyGLContextDestroy()
  {
    TRTCCloudListener.TRTCVideoFrameListener localTRTCVideoFrameListener = this.mListener;
    if ((localTRTCVideoFrameListener != null) && (this.mHasNotifiedGLContextCreated))
    {
      localTRTCVideoFrameListener.onGLContextDestory();
      this.mHasNotifiedGLContextCreated = false;
    }
  }
  
  private void releaseOpenGLResources()
  {
    Object localObject = this.mRGBAToYUVFilter;
    if (localObject != null)
    {
      ((o)localObject).d();
      this.mRGBAToYUVFilter = null;
    }
    localObject = this.mYUVToRGBAFilter;
    if (localObject != null)
    {
      ((k)localObject).d();
      this.mYUVToRGBAFilter = null;
    }
    TXCOpenGlUtils.b(this.mFrameBufferId);
    this.mFrameBufferId = -1;
  }
  
  private void setListenerInternal(int paramInt1, int paramInt2, TRTCCloudListener.TRTCVideoFrameListener paramTRTCVideoFrameListener)
  {
    notifyGLContextDestroy();
    this.mPixelFormat = paramInt1;
    this.mBufferType = paramInt2;
    this.mListener = paramTRTCVideoFrameListener;
    notifyGLContextCreated();
  }
  
  private void shadowCopyVideoFrame(TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame1, TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame2)
  {
    paramTRTCVideoFrame2.width = paramTRTCVideoFrame1.width;
    paramTRTCVideoFrame2.height = paramTRTCVideoFrame1.height;
    paramTRTCVideoFrame2.pixelFormat = paramTRTCVideoFrame1.pixelFormat;
    paramTRTCVideoFrame2.bufferType = paramTRTCVideoFrame1.bufferType;
    paramTRTCVideoFrame2.texture = paramTRTCVideoFrame1.texture;
    paramTRTCVideoFrame2.data = paramTRTCVideoFrame1.data;
    paramTRTCVideoFrame2.buffer = paramTRTCVideoFrame1.buffer;
  }
  
  public void onDetectFacePoints(float[] paramArrayOfFloat) {}
  
  public void onGLContextCreated()
  {
    this.mDelayQueue.a();
    notifyGLContextCreated();
  }
  
  public void onGLContextReadyToDestory()
  {
    this.mDelayQueue.a();
    notifyGLContextDestroy();
    releaseOpenGLResources();
  }
  
  public int onProcessVideoFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mDelayQueue.a();
    if (this.mListener == null) {
      return paramInt1;
    }
    if ((this.mLastFrameSize.a != paramInt2) || (this.mLastFrameSize.b != paramInt3))
    {
      releaseOpenGLResources();
      Object localObject = this.mYUVInputFrame;
      ((TRTCCloudDef.TRTCVideoFrame)localObject).data = null;
      ((TRTCCloudDef.TRTCVideoFrame)localObject).buffer = null;
      localObject = this.mYUVOutputFrame;
      ((TRTCCloudDef.TRTCVideoFrame)localObject).data = null;
      ((TRTCCloudDef.TRTCVideoFrame)localObject).buffer = null;
      localObject = this.mLastFrameSize;
      ((e)localObject).a = paramInt2;
      ((e)localObject).b = paramInt3;
    }
    initVideoFrame(this.mYUVInputFrame, paramInt2, paramInt3, this.mPixelFormat, this.mBufferType);
    initVideoFrame(this.mYUVOutputFrame, paramInt2, paramInt3, this.mPixelFormat, this.mBufferType);
    if (this.mPixelFormat == 2)
    {
      this.mYUVInputFrame.texture.textureId = paramInt1;
      this.mYUVOutputFrame.texture.textureId = paramInt4;
      this.mListener.onProcessVideoFrame(this.mYUVInputFrame, this.mYUVOutputFrame);
      return this.mYUVOutputFrame.texture.textureId;
    }
    if (this.mFrameBufferId == -1) {
      this.mFrameBufferId = TXCOpenGlUtils.d();
    }
    convertTextureToYUV(paramInt1, this.mYUVInputFrame);
    shadowCopyVideoFrame(this.mYUVInputFrame, this.mShadowInputFrame);
    shadowCopyVideoFrame(this.mYUVOutputFrame, this.mShadowOutputFrame);
    this.mListener.onProcessVideoFrame(this.mShadowInputFrame, this.mShadowOutputFrame);
    convertYUVToTexture(this.mShadowOutputFrame, paramInt4);
    return paramInt4;
  }
  
  public void setListener(int paramInt1, int paramInt2, TRTCCloudListener.TRTCVideoFrameListener paramTRTCVideoFrameListener)
  {
    this.mDelayQueue.a(new TRTCVideoPreprocessListenerAdapter.1(this, paramInt1, paramInt2, paramTRTCVideoFrameListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCVideoPreprocessListenerAdapter
 * JD-Core Version:    0.7.0.1
 */