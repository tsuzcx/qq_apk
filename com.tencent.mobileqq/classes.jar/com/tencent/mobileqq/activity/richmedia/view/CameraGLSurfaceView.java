package com.tencent.mobileqq.activity.richmedia.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.opengl.GLES20;
import android.opengl.GLException;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoClipSpec;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext.VFrameData;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import mqq.os.MqqHandler;

public class CameraGLSurfaceView
  extends GLSurfaceView
  implements GLSurfaceView.Renderer, Handler.Callback
{
  CameraGLSurfaceView.CaptureListener a;
  public GLSurfaceUtil b;
  public boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  private volatile boolean g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o = 270;
  private PreviewContext p = null;
  private AtomicInteger q = new AtomicInteger(0);
  private AtomicInteger r = new AtomicInteger(0);
  private boolean s = false;
  private String t = null;
  private int u = 90;
  private boolean v;
  private HandlerThread w;
  private Handler x;
  
  public CameraGLSurfaceView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public CameraGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  private Bitmap a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, GL10 paramGL10)
  {
    int i1 = paramInt3 * paramInt4;
    int[] arrayOfInt1 = new int[i1];
    int[] arrayOfInt2 = new int[i1];
    IntBuffer localIntBuffer = IntBuffer.wrap(arrayOfInt1);
    localIntBuffer.position(0);
    for (;;)
    {
      try
      {
        paramGL10.glReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, 6408, 5121, localIntBuffer);
        paramInt1 = 0;
      }
      catch (GLException paramGL10)
      {
        continue;
        if (paramInt1 >= paramInt4) {
          continue;
        }
        paramInt2 = 0;
        continue;
      }
      if (paramInt2 >= paramInt3) {
        continue;
      }
      i1 = arrayOfInt1[(paramInt1 * paramInt3 + paramInt2)];
      arrayOfInt2[((paramInt4 - paramInt1 - 1) * paramInt3 + paramInt2)] = (i1 & 0xFF00FF00 | i1 << 16 & 0xFF0000 | i1 >> 16 & 0xFF);
      paramInt2 += 1;
    }
    paramInt1 += 1;
    break label142;
    return Bitmap.createBitmap(arrayOfInt2, paramInt3, paramInt4, Bitmap.Config.ARGB_8888);
    return null;
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraGLSurfaceView", 2, paramString);
    }
  }
  
  public static native ByteBuffer allocate(int paramInt1, int paramInt2);
  
  private void b()
  {
    setEGLContextClientVersion(2);
    super.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
    super.setRenderer(this);
    super.setRenderMode(0);
    super.getHolder().setFormat(1);
    this.d = true;
    this.e = false;
    this.g = false;
    this.v = false;
    this.w = null;
    this.x = null;
    this.b = new GLSurfaceUtil();
  }
  
  private void c()
  {
    if (this.w != null)
    {
      PreviewContext localPreviewContext = this.p;
      if (localPreviewContext != null) {
        localPreviewContext.mMsghandler = null;
      }
      this.x.removeCallbacksAndMessages(null);
      this.w.quit();
      this.w = null;
      this.x = null;
    }
  }
  
  private void d()
  {
    this.b.c = 0;
    this.e = false;
  }
  
  private void e()
  {
    this.r.set(1);
    Object localObject = this.b;
    this.f = ((GLSurfaceUtil)localObject).a(this.f, this.h, this.i, ((GLSurfaceUtil)localObject).i, this.b.j, this.b.k);
    int i1 = GLES20.glGetError();
    if (i1 != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("glDrawFrame:err=");
      ((StringBuilder)localObject).append(i1);
      a(((StringBuilder)localObject).toString());
    }
    this.r.set(0);
  }
  
  private int f()
  {
    if (this.r.getAndAdd(0) != 0)
    {
      a("beginRenderFileCacheData: lost frame");
      return -1;
    }
    if (this.b.i != null)
    {
      this.b.i.position(0);
      this.b.j.position(0);
      this.b.k.position(0);
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleMessage:beginRenderFileCacheData:panelY=");
    localStringBuilder.append(this.b.i);
    a(localStringBuilder.toString());
    return -2;
  }
  
  public static native int getBitmap(Bitmap paramBitmap, ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, ByteBuffer paramByteBuffer3, int paramInt);
  
  public static native void initTotalBufferSize(int paramInt1, int paramInt2, int paramInt3);
  
  public static native int processVideoFrame(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, ByteBuffer paramByteBuffer3, boolean paramBoolean2);
  
  public static native int writeVideoFrame(int paramInt1, int paramInt2, AVIOStruct paramAVIOStruct);
  
  public void a()
  {
    if (this.w == null)
    {
      this.w = new HandlerThread("glProcess");
      this.w.start();
      this.x = new Handler(this.w.getLooper(), this);
      PreviewContext localPreviewContext = this.p;
      if (localPreviewContext != null) {
        localPreviewContext.mMsghandler = this.x;
      }
      this.r.set(0);
    }
  }
  
  public boolean getIsNativeShareBuffer()
  {
    return GLSurfaceUtil.g;
  }
  
  public Handler getMsgHandler()
  {
    if (this.w != null)
    {
      Handler localHandler = this.x;
      if (localHandler != null) {
        return localHandler;
      }
    }
    return null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject;
    long l1;
    if (paramMessage.what == -16716526)
    {
      i1 = this.q.get();
      if (i1 != 0)
      {
        paramMessage = new StringBuilder();
        paramMessage.append("handleMessage:[RenderModeCheck-Recorder][May Lost Frame] mode=");
        paramMessage.append(i1);
        a(paramMessage.toString());
        return true;
      }
      if (paramMessage.obj == null) {
        break label496;
      }
      if (paramMessage.arg1 == 0) {
        localObject = (byte[])paramMessage.obj;
      } else if (paramMessage.arg1 == 1) {
        localObject = ((PreviewContext.VFrameData)paramMessage.obj).a;
      } else {
        localObject = null;
      }
      i1 = this.b.a(this.n, this.h, this.i, this.j, this.k, this.o, (byte[])localObject);
      if (paramMessage.arg2 == 1)
      {
        PreviewContext localPreviewContext = this.p;
        if (localPreviewContext != null) {
          localPreviewContext.addUserBufferRecycle((byte[])localObject);
        }
      }
      if (i1 == 0)
      {
        requestRender();
        l1 = SystemClock.elapsedRealtime();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleMessage:requestRender  renderTime=");
        ((StringBuilder)localObject).append(l1);
        a(((StringBuilder)localObject).toString());
        localObject = this.p;
        if ((localObject != null) && (((PreviewContext)localObject).notifyFirstFrame)) {
          ThreadManager.getUIHandler().post(new CameraGLSurfaceView.2(this));
        }
        if (paramMessage.arg1 != 1) {
          break label496;
        }
      }
    }
    try
    {
      paramMessage = ((PreviewContext.VFrameData)paramMessage.obj).b;
      if (l1 != 0L)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleMessage:writeVideoFrame  renderTime=");
        ((StringBuilder)localObject).append(l1);
        ((StringBuilder)localObject).append(" oldtime=");
        ((StringBuilder)localObject).append(paramMessage.vFrameTime);
        ((StringBuilder)localObject).append(" diff=");
        ((StringBuilder)localObject).append(l1 - paramMessage.vFrameTime);
        a(((StringBuilder)localObject).toString());
        paramMessage.vFrameTime = l1;
      }
      i1 = writeVideoFrame(this.h, this.i, paramMessage);
    }
    catch (UnsatisfiedLinkError paramMessage)
    {
      label366:
      break label366;
    }
    int i1 = -15;
    paramMessage = new StringBuilder();
    paramMessage.append("handleMessage:writeVideoFrame  error=");
    paramMessage.append(i1);
    a(paramMessage.toString());
    return true;
    paramMessage = new StringBuilder();
    paramMessage.append("handleMessage:byteBufferProcessFrame  error=");
    paramMessage.append(i1);
    a(paramMessage.toString());
    return true;
    if (paramMessage.what == -16716525)
    {
      i1 = this.q.get();
      if (i1 != 1)
      {
        paramMessage = new StringBuilder();
        paramMessage.append("handleMessage:[RenderModeCheck-Preview] mode=");
        paramMessage.append(i1);
        a(paramMessage.toString());
        return true;
      }
      if (f() == 0) {
        requestRender();
      }
    }
    label496:
    return true;
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    GLES20.glClear(16384);
    if ((this.g) && (this.d) && (this.e))
    {
      e();
      if ((this.s) && (this.t != null))
      {
        paramGL10 = a(0, 0, getWidth(), getHeight(), paramGL10);
        CameraGLSurfaceView.CaptureListener localCaptureListener = this.a;
        if (localCaptureListener != null) {
          localCaptureListener.a(paramGL10);
        }
        this.s = false;
        this.t = null;
      }
    }
  }
  
  public void onPause()
  {
    if (this.v)
    {
      super.onPause();
      this.v = false;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    a();
    this.v = true;
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (this.c) {
      this.b.d = true;
    }
    if (!this.b.a(getContext())) {
      this.d = false;
    }
    this.e = true;
    this.f = false;
  }
  
  public void setCaptureListener(CameraGLSurfaceView.CaptureListener paramCaptureListener)
  {
    queueEvent(new CameraGLSurfaceView.1(this, paramCaptureListener));
  }
  
  public void setPreviewSize(int paramInt1, int paramInt2, RMVideoClipSpec paramRMVideoClipSpec)
  {
    this.j = paramInt1;
    this.k = paramInt2;
    this.h = paramRMVideoClipSpec.c;
    this.i = paramRMVideoClipSpec.d;
    this.l = paramRMVideoClipSpec.e;
    this.m = paramRMVideoClipSpec.f;
    paramInt1 = this.h;
    if (paramInt1 % 2 != 0) {
      this.h = (paramInt1 - 1);
    }
    paramInt1 = this.i;
    if (paramInt1 % 2 != 0) {
      this.i = (paramInt1 - 1);
    }
    paramInt1 = this.l;
    if (paramInt1 % 2 != 0) {
      this.l = (paramInt1 - 1);
    }
    paramInt1 = this.m;
    if (paramInt1 % 2 != 0) {
      this.m = (paramInt1 - 1);
    }
    this.n = CameraControl.a().f();
    paramInt1 = CameraControl.a().o();
    if (paramInt1 <= 0) {
      this.o = 270;
    } else {
      this.o = paramInt1;
    }
    if (QLog.isColorLevel())
    {
      paramRMVideoClipSpec = new StringBuilder();
      paramRMVideoClipSpec.append("setPreviewSize:mVideoClipDegree=");
      paramRMVideoClipSpec.append(this.o);
      QLog.d("CameraGLSurfaceView", 2, paramRMVideoClipSpec.toString());
    }
    GLSurfaceUtil.h = false;
    try
    {
      initTotalBufferSize(this.j, this.k, this.n);
      GLSurfaceUtil.h = true;
    }
    catch (UnsatisfiedLinkError paramRMVideoClipSpec)
    {
      label217:
      break label217;
    }
    GLSurfaceUtil.h = false;
    this.b.a(this.h, this.i);
    this.b.l = false;
    this.g = true;
  }
  
  public void setVideoContext(PreviewContext paramPreviewContext)
  {
    this.p = paramPreviewContext;
    paramPreviewContext = this.p;
    if (paramPreviewContext != null)
    {
      paramPreviewContext.mMsghandler = this.x;
      paramPreviewContext.mPTVRealBeauty = true;
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    super.surfaceDestroyed(paramSurfaceHolder);
    d();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.CameraGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */