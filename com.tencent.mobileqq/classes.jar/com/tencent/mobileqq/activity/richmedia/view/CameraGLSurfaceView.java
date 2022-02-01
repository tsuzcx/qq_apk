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
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  CameraGLSurfaceView.CaptureListener jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView$CaptureListener;
  public GLSurfaceUtil a;
  private PreviewContext jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext = null;
  private String jdField_a_of_type_JavaLangString = null;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public boolean a;
  private int jdField_b_of_type_Int;
  private AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private volatile boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean = false;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int h = 270;
  private int i = 90;
  
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
  
  private int a()
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndAdd(0) != 0)
    {
      a("beginRenderFileCacheData: lost frame");
      return -1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.jdField_a_of_type_JavaNioByteBuffer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.jdField_a_of_type_JavaNioByteBuffer.position(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.b.position(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.jdField_c_of_type_JavaNioByteBuffer.position(0);
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleMessage:beginRenderFileCacheData:panelY=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.jdField_a_of_type_JavaNioByteBuffer);
    a(localStringBuilder.toString());
    return -2;
  }
  
  private Bitmap a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, GL10 paramGL10)
  {
    int j = paramInt3 * paramInt4;
    int[] arrayOfInt1 = new int[j];
    int[] arrayOfInt2 = new int[j];
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
      j = arrayOfInt1[(paramInt1 * paramInt3 + paramInt2)];
      arrayOfInt2[((paramInt4 - paramInt1 - 1) * paramInt3 + paramInt2)] = (j & 0xFF00FF00 | j << 16 & 0xFF0000 | j >> 16 & 0xFF);
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
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandlerThread = null;
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil = new GLSurfaceUtil();
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
    {
      PreviewContext localPreviewContext = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext;
      if (localPreviewContext != null) {
        localPreviewContext.mMsghandler = null;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void e()
  {
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil;
    this.jdField_d_of_type_Boolean = ((GLSurfaceUtil)localObject).a(this.jdField_d_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, ((GLSurfaceUtil)localObject).jdField_a_of_type_JavaNioByteBuffer, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.b, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.jdField_c_of_type_JavaNioByteBuffer);
    int j = GLES20.glGetError();
    if (j != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("glDrawFrame:err=");
      ((StringBuilder)localObject).append(j);
      a(((StringBuilder)localObject).toString());
    }
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
  }
  
  public static native int getBitmap(Bitmap paramBitmap, ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, ByteBuffer paramByteBuffer3, int paramInt);
  
  public static native void initTotalBufferSize(int paramInt1, int paramInt2, int paramInt3);
  
  public static native int processVideoFrame(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, ByteBuffer paramByteBuffer3, boolean paramBoolean2);
  
  public static native int writeVideoFrame(int paramInt1, int paramInt2, AVIOStruct paramAVIOStruct);
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("glProcess");
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
      PreviewContext localPreviewContext = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext;
      if (localPreviewContext != null) {
        localPreviewContext.mMsghandler = this.jdField_a_of_type_AndroidOsHandler;
      }
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject;
    long l;
    if (paramMessage.what == -16716526)
    {
      j = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
      if (j != 0)
      {
        paramMessage = new StringBuilder();
        paramMessage.append("handleMessage:[RenderModeCheck-Recorder][May Lost Frame] mode=");
        paramMessage.append(j);
        a(paramMessage.toString());
        return true;
      }
      if (paramMessage.obj == null) {
        break label495;
      }
      if (paramMessage.arg1 == 0) {
        localObject = (byte[])paramMessage.obj;
      } else if (paramMessage.arg1 == 1) {
        localObject = ((PreviewContext.VFrameData)paramMessage.obj).jdField_a_of_type_ArrayOfByte;
      } else {
        localObject = null;
      }
      j = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.a(this.jdField_g_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.h, (byte[])localObject);
      if (paramMessage.arg2 == 1)
      {
        PreviewContext localPreviewContext = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext;
        if (localPreviewContext != null) {
          localPreviewContext.addUserBufferRecycle((byte[])localObject);
        }
      }
      if (j == 0)
      {
        requestRender();
        l = SystemClock.elapsedRealtime();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleMessage:requestRender  renderTime=");
        ((StringBuilder)localObject).append(l);
        a(((StringBuilder)localObject).toString());
        localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext;
        if ((localObject != null) && (((PreviewContext)localObject).notifyFirstFrame)) {
          ThreadManager.getUIHandler().post(new CameraGLSurfaceView.2(this));
        }
        if (paramMessage.arg1 != 1) {
          break label495;
        }
      }
    }
    try
    {
      paramMessage = ((PreviewContext.VFrameData)paramMessage.obj).jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct;
      if (l != 0L)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleMessage:writeVideoFrame  renderTime=");
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append(" oldtime=");
        ((StringBuilder)localObject).append(paramMessage.vFrameTime);
        ((StringBuilder)localObject).append(" diff=");
        ((StringBuilder)localObject).append(l - paramMessage.vFrameTime);
        a(((StringBuilder)localObject).toString());
        paramMessage.vFrameTime = l;
      }
      j = writeVideoFrame(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramMessage);
    }
    catch (UnsatisfiedLinkError paramMessage)
    {
      label365:
      break label365;
    }
    int j = -15;
    paramMessage = new StringBuilder();
    paramMessage.append("handleMessage:writeVideoFrame  error=");
    paramMessage.append(j);
    a(paramMessage.toString());
    return true;
    paramMessage = new StringBuilder();
    paramMessage.append("handleMessage:byteBufferProcessFrame  error=");
    paramMessage.append(j);
    a(paramMessage.toString());
    return true;
    if (paramMessage.what == -16716525)
    {
      j = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
      if (j != 1)
      {
        paramMessage = new StringBuilder();
        paramMessage.append("handleMessage:[RenderModeCheck-Preview] mode=");
        paramMessage.append(j);
        a(paramMessage.toString());
        return true;
      }
      if (a() == 0) {
        requestRender();
      }
    }
    label495:
    return true;
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    GLES20.glClear(16384);
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean))
    {
      e();
      if ((this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_JavaLangString != null))
      {
        paramGL10 = a(0, 0, getWidth(), getHeight(), paramGL10);
        CameraGLSurfaceView.CaptureListener localCaptureListener = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView$CaptureListener;
        if (localCaptureListener != null) {
          localCaptureListener.a(paramGL10);
        }
        this.jdField_f_of_type_Boolean = false;
        this.jdField_a_of_type_JavaLangString = null;
      }
    }
  }
  
  public void onPause()
  {
    if (this.jdField_g_of_type_Boolean)
    {
      super.onPause();
      this.jdField_g_of_type_Boolean = false;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    a();
    this.jdField_g_of_type_Boolean = true;
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.jdField_a_of_type_Boolean = true;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.a(getContext())) {
      this.jdField_b_of_type_Boolean = false;
    }
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void setCaptureListener(CameraGLSurfaceView.CaptureListener paramCaptureListener)
  {
    queueEvent(new CameraGLSurfaceView.1(this, paramCaptureListener));
  }
  
  public void setPreviewSize(int paramInt1, int paramInt2, RMVideoClipSpec paramRMVideoClipSpec)
  {
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    this.jdField_a_of_type_Int = paramRMVideoClipSpec.jdField_c_of_type_Int;
    this.jdField_b_of_type_Int = paramRMVideoClipSpec.jdField_d_of_type_Int;
    this.jdField_e_of_type_Int = paramRMVideoClipSpec.jdField_e_of_type_Int;
    this.jdField_f_of_type_Int = paramRMVideoClipSpec.jdField_f_of_type_Int;
    paramInt1 = this.jdField_a_of_type_Int;
    if (paramInt1 % 2 != 0) {
      this.jdField_a_of_type_Int = (paramInt1 - 1);
    }
    paramInt1 = this.jdField_b_of_type_Int;
    if (paramInt1 % 2 != 0) {
      this.jdField_b_of_type_Int = (paramInt1 - 1);
    }
    paramInt1 = this.jdField_e_of_type_Int;
    if (paramInt1 % 2 != 0) {
      this.jdField_e_of_type_Int = (paramInt1 - 1);
    }
    paramInt1 = this.jdField_f_of_type_Int;
    if (paramInt1 % 2 != 0) {
      this.jdField_f_of_type_Int = (paramInt1 - 1);
    }
    this.jdField_g_of_type_Int = CameraControl.a().a();
    paramInt1 = CameraControl.a().b();
    if (paramInt1 <= 0) {
      this.h = 270;
    } else {
      this.h = paramInt1;
    }
    if (QLog.isColorLevel())
    {
      paramRMVideoClipSpec = new StringBuilder();
      paramRMVideoClipSpec.append("setPreviewSize:mVideoClipDegree=");
      paramRMVideoClipSpec.append(this.h);
      QLog.d("CameraGLSurfaceView", 2, paramRMVideoClipSpec.toString());
    }
    GLSurfaceUtil.jdField_c_of_type_Boolean = false;
    try
    {
      initTotalBufferSize(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_g_of_type_Int);
      GLSurfaceUtil.jdField_c_of_type_Boolean = true;
    }
    catch (UnsatisfiedLinkError paramRMVideoClipSpec)
    {
      label217:
      break label217;
    }
    GLSurfaceUtil.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = true;
  }
  
  public void setVideoContext(PreviewContext paramPreviewContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext = paramPreviewContext;
    paramPreviewContext = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext;
    if (paramPreviewContext != null)
    {
      paramPreviewContext.mMsghandler = this.jdField_a_of_type_AndroidOsHandler;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.CameraGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */