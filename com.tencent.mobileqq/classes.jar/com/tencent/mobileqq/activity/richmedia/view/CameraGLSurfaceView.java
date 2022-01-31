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
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext.VFrameData;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import xug;
import xuh;

public class CameraGLSurfaceView
  extends GLSurfaceView
  implements GLSurfaceView.Renderer, Handler.Callback
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public CameraGLSurfaceView.CaptureListener a;
  public GLSurfaceUtil a;
  private PreviewContext jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext;
  private String jdField_a_of_type_JavaLangString;
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
  private boolean jdField_f_of_type_Boolean;
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
    a("handleMessage:beginRenderFileCacheData:panelY=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.jdField_a_of_type_JavaNioByteBuffer);
    return -2;
  }
  
  private Bitmap a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, GL10 paramGL10)
  {
    int[] arrayOfInt1 = new int[paramInt3 * paramInt4];
    int[] arrayOfInt2 = new int[paramInt3 * paramInt4];
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
        int j;
        return null;
      }
      if (paramInt2 < paramInt3)
      {
        j = arrayOfInt1[(paramInt1 * paramInt3 + paramInt2)];
        arrayOfInt2[((paramInt4 - paramInt1 - 1) * paramInt3 + paramInt2)] = (j & 0xFF00FF00 | j << 16 & 0xFF0000 | j >> 16 & 0xFF);
        paramInt2 += 1;
      }
      else
      {
        paramInt1 += 1;
        while (paramInt1 >= paramInt4) {
          return Bitmap.createBitmap(arrayOfInt2, paramInt3, paramInt4, Bitmap.Config.ARGB_8888);
        }
        paramInt2 = 0;
      }
    }
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
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mMsghandler = null;
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
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.a(this.jdField_d_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.jdField_a_of_type_JavaNioByteBuffer, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.b, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.jdField_c_of_type_JavaNioByteBuffer);
    int j = GLES20.glGetError();
    if (j != 0) {
      a("glDrawFrame:err=" + j);
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
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mMsghandler = this.jdField_a_of_type_AndroidOsHandler;
      }
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    byte[] arrayOfByte = null;
    int j;
    if (paramMessage.what == -16716526)
    {
      j = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
      if (j != 0) {
        a("handleMessage:[RenderModeCheck-Recorder][May Lost Frame] mode=" + j);
      }
    }
    label339:
    do
    {
      do
      {
        do
        {
          return true;
        } while (paramMessage.obj == null);
        if (paramMessage.arg1 == 0) {
          arrayOfByte = (byte[])paramMessage.obj;
        }
        for (;;)
        {
          j = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.a(this.jdField_g_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.h, arrayOfByte);
          if ((paramMessage.arg2 == 1) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null)) {
            this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.addUserBufferRecycle(arrayOfByte);
          }
          if (j != 0) {
            break label339;
          }
          requestRender();
          long l = SystemClock.elapsedRealtime();
          a("handleMessage:requestRender  renderTime=" + l);
          if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.notifyFirstFrame)) {
            post(new xuh(this));
          }
          if (paramMessage.arg1 != 1) {
            break;
          }
          try
          {
            paramMessage = ((PreviewContext.VFrameData)paramMessage.obj).jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct;
            if (l != 0L)
            {
              a("handleMessage:writeVideoFrame  renderTime=" + l + " oldtime=" + paramMessage.vFrameTime + " diff=" + (l - paramMessage.vFrameTime));
              paramMessage.vFrameTime = l;
            }
            j = writeVideoFrame(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramMessage);
          }
          catch (UnsatisfiedLinkError paramMessage)
          {
            for (;;)
            {
              j = -15;
            }
          }
          a("handleMessage:writeVideoFrame  error=" + j);
          return true;
          if (paramMessage.arg1 == 1) {
            arrayOfByte = ((PreviewContext.VFrameData)paramMessage.obj).jdField_a_of_type_ArrayOfByte;
          }
        }
        a("handleMessage:byteBufferProcessFrame  error=" + j);
        return true;
      } while (paramMessage.what != -16716525);
      j = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
      if (j != 1)
      {
        a("handleMessage:[RenderModeCheck-Preview] mode=" + j);
        return true;
      }
    } while (a() != 0);
    requestRender();
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
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView$CaptureListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView$CaptureListener.a(paramGL10);
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
    queueEvent(new xug(this, paramCaptureListener));
  }
  
  public void setPreviewSize(int paramInt1, int paramInt2, RMVideoClipSpec paramRMVideoClipSpec)
  {
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    this.jdField_a_of_type_Int = paramRMVideoClipSpec.jdField_c_of_type_Int;
    this.jdField_b_of_type_Int = paramRMVideoClipSpec.jdField_d_of_type_Int;
    this.jdField_e_of_type_Int = paramRMVideoClipSpec.jdField_e_of_type_Int;
    this.jdField_f_of_type_Int = paramRMVideoClipSpec.jdField_f_of_type_Int;
    if (this.jdField_a_of_type_Int % 2 != 0) {
      this.jdField_a_of_type_Int -= 1;
    }
    if (this.jdField_b_of_type_Int % 2 != 0) {
      this.jdField_b_of_type_Int -= 1;
    }
    if (this.jdField_e_of_type_Int % 2 != 0) {
      this.jdField_e_of_type_Int -= 1;
    }
    if (this.jdField_f_of_type_Int % 2 != 0) {
      this.jdField_f_of_type_Int -= 1;
    }
    this.jdField_g_of_type_Int = CameraControl.a().a();
    paramInt1 = CameraControl.a().b();
    if (paramInt1 <= 0) {
      this.h = 270;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraGLSurfaceView", 2, "setPreviewSize:mVideoClipDegree=" + this.h);
      }
      GLSurfaceUtil.jdField_c_of_type_Boolean = false;
      try
      {
        initTotalBufferSize(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_g_of_type_Int);
        GLSurfaceUtil.jdField_c_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewGLSurfaceUtil.jdField_d_of_type_Boolean = false;
        this.jdField_e_of_type_Boolean = true;
        return;
        this.h = paramInt1;
      }
      catch (UnsatisfiedLinkError paramRMVideoClipSpec)
      {
        for (;;)
        {
          GLSurfaceUtil.jdField_c_of_type_Boolean = false;
        }
      }
    }
  }
  
  public void setVideoContext(PreviewContext paramPreviewContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext = paramPreviewContext;
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mMsghandler = this.jdField_a_of_type_AndroidOsHandler;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mPTVRealBeauty = true;
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    super.surfaceDestroyed(paramSurfaceHolder);
    d();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.CameraGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */