package com.tencent.aelight.camera.aioeditor.takevideo.localmedia.opengl;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.util.Log;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.TimeoutException;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

@TargetApi(14)
public class CodecOutputSurface
  implements SurfaceTexture.OnFrameAvailableListener
{
  int jdField_a_of_type_Int;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private STextureRender jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoLocalmediaOpenglSTextureRender;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ByteBuffer jdField_a_of_type_JavaNioByteBuffer;
  private EGL10 jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10;
  private EGLContext jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = EGL10.EGL_NO_CONTEXT;
  private EGLDisplay jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay = EGL10.EGL_NO_DISPLAY;
  private EGLSurface jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface = EGL10.EGL_NO_SURFACE;
  private boolean jdField_a_of_type_Boolean;
  int b;
  
  public CodecOutputSurface(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10 = ((EGL10)EGLContext.getEGL());
      this.jdField_a_of_type_Int = paramInt1;
      this.b = paramInt2;
      f();
      b();
      e();
      return;
    }
    throw new IllegalArgumentException();
  }
  
  private void a(String paramString)
  {
    int i = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetError();
    if (i == 12288) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(": EGL error: 0x");
    localStringBuilder.append(Integer.toHexString(i));
    throw new RuntimeException(localStringBuilder.toString());
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoLocalmediaOpenglSTextureRender = new STextureRender();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoLocalmediaOpenglSTextureRender.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("textureID=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoLocalmediaOpenglSTextureRender.a());
    Log.d("CodecOutputSurface", localStringBuilder.toString());
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoLocalmediaOpenglSTextureRender.a());
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
    this.jdField_a_of_type_AndroidViewSurface = new Surface(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
    this.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocateDirect(this.jdField_a_of_type_Int * this.b * 4);
    this.jdField_a_of_type_JavaNioByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
  }
  
  private void f()
  {
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay != EGL10.EGL_NO_DISPLAY)
    {
      Object localObject = new int[2];
      if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglInitialize(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, (int[])localObject))
      {
        localObject = new EGLConfig[1];
        int[] arrayOfInt = new int[1];
        EGL10 localEGL10 = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10;
        EGLDisplay localEGLDisplay = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay;
        int i = localObject.length;
        if (localEGL10.eglChooseConfig(localEGLDisplay, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344 }, (EGLConfig[])localObject, i, arrayOfInt))
        {
          this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglCreateContext(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, localObject[0], EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
          a("eglCreateContext");
          if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext != null)
          {
            i = this.jdField_a_of_type_Int;
            int j = this.b;
            this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglCreatePbufferSurface(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, localObject[0], new int[] { 12375, i, 12374, j, 12344 });
            a("eglCreatePbufferSurface");
            if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface != null) {
              return;
            }
            throw new RuntimeException("surface was null");
          }
          throw new RuntimeException("null context");
        }
        throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
      }
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay = null;
      throw new RuntimeException("unable to initialize EGL14");
    }
    throw new RuntimeException("unable to get EGL14 display");
  }
  
  public Bitmap a()
  {
    this.jdField_a_of_type_JavaNioByteBuffer.rewind();
    GLES20.glReadPixels(0, 0, this.jdField_a_of_type_Int, this.b, 6408, 5121, this.jdField_a_of_type_JavaNioByteBuffer);
    Bitmap localBitmap = Bitmap.createBitmap(this.jdField_a_of_type_Int, this.b, Bitmap.Config.ARGB_8888);
    this.jdField_a_of_type_JavaNioByteBuffer.rewind();
    localBitmap.copyPixelsFromBuffer(this.jdField_a_of_type_JavaNioByteBuffer);
    Log.d("CodecOutputSurface", "getFrameBitmap() finish...");
    return localBitmap;
  }
  
  public Surface a()
  {
    return this.jdField_a_of_type_AndroidViewSurface;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay != EGL10.EGL_NO_DISPLAY)
    {
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglDestroySurface(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface);
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglDestroyContext(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext);
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglMakeCurrent(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglTerminate(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay);
    }
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay = EGL10.EGL_NO_DISPLAY;
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = EGL10.EGL_NO_CONTEXT;
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface = EGL10.EGL_NO_SURFACE;
    this.jdField_a_of_type_AndroidViewSurface.release();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoLocalmediaOpenglSTextureRender = null;
    this.jdField_a_of_type_AndroidViewSurface = null;
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoLocalmediaOpenglSTextureRender.a(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture, paramBoolean);
  }
  
  public void b()
  {
    EGL10 localEGL10 = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10;
    EGLDisplay localEGLDisplay = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay;
    EGLSurface localEGLSurface = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface;
    if (localEGL10.eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext)) {
      return;
    }
    throw new RuntimeException("eglMakeCurrent failed");
  }
  
  public void c()
  {
    Log.e("CodecOutputSurface", "awaitNewImage");
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      for (;;)
      {
        boolean bool = this.jdField_a_of_type_Boolean;
        if (!bool) {
          try
          {
            this.jdField_a_of_type_JavaLangObject.wait(1L);
            if (!this.jdField_a_of_type_Boolean) {
              throw new TimeoutException("frame wait timed out");
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            throw new RuntimeException(localInterruptedException);
          }
        }
      }
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoLocalmediaOpenglSTextureRender.a("before updateTexImage");
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.updateTexImage();
  }
  
  public void onFrameAvailable(SurfaceTexture arg1)
  {
    Log.e("CodecOutputSurface", "onFrameAvailable new frame available");
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_JavaLangObject.notifyAll();
        return;
      }
      throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.localmedia.opengl.CodecOutputSurface
 * JD-Core Version:    0.7.0.1
 */