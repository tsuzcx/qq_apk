package com.tencent.av.videoeffect;

import android.annotation.SuppressLint;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGL10;
import muv;
import muy;

public class VideoEffectTest
  implements Runnable
{
  private android.opengl.EGLContext jdField_a_of_type_AndroidOpenglEGLContext;
  private android.opengl.EGLDisplay jdField_a_of_type_AndroidOpenglEGLDisplay;
  private android.opengl.EGLSurface jdField_a_of_type_AndroidOpenglEGLSurface;
  Thread jdField_a_of_type_JavaLangThread = null;
  private EGL10 jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10;
  private javax.microedition.khronos.egl.EGLContext jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext;
  private javax.microedition.khronos.egl.EGLDisplay jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay;
  private javax.microedition.khronos.egl.EGLSurface jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface;
  muy jdField_a_of_type_Muy = null;
  
  public VideoEffectTest(muy parammuy)
  {
    this.jdField_a_of_type_Muy = parammuy;
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10 = ((EGL10)javax.microedition.khronos.egl.EGLContext.getEGL());
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    Object localObject = new int[2];
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglInitialize(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, (int[])localObject);
    localObject = new javax.microedition.khronos.egl.EGLConfig[1];
    int[] arrayOfInt = new int[1];
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglChooseConfig(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, new int[] { 12351, 12430, 12329, 0, 12339, 1, 12344 }, (javax.microedition.khronos.egl.EGLConfig[])localObject, 1, arrayOfInt);
    if ((arrayOfInt[0] == 0) && (QLog.isColorLevel())) {
      QLog.d("VideoEffectTest", 2, "TROUBLE! No config found.");
    }
    localObject = localObject[0];
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglCreatePbufferSurface(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, (javax.microedition.khronos.egl.EGLConfig)localObject, new int[] { 12375, 64, 12374, 64, 12344 });
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglCreateContext(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, (javax.microedition.khronos.egl.EGLConfig)localObject, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglMakeCurrent(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext);
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10 != null) && (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay != null) && (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface != null) && (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext != null))
    {
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglMakeCurrent(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglDestroySurface(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface);
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglDestroyContext(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext);
      this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglTerminate(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay);
    }
  }
  
  @SuppressLint({"NewApi"})
  private void e()
  {
    this.jdField_a_of_type_AndroidOpenglEGLDisplay = EGL14.eglGetDisplay(0);
    Object localObject = new int[2];
    EGL14.eglInitialize(this.jdField_a_of_type_AndroidOpenglEGLDisplay, (int[])localObject, 0, (int[])localObject, 1);
    localObject = new android.opengl.EGLConfig[1];
    int[] arrayOfInt = new int[1];
    EGL14.eglChooseConfig(this.jdField_a_of_type_AndroidOpenglEGLDisplay, new int[] { 12351, 12430, 12329, 0, 12352, 4, 12339, 1, 12344 }, 0, (android.opengl.EGLConfig[])localObject, 0, 1, arrayOfInt, 0);
    if ((arrayOfInt[0] == 0) && (QLog.isColorLevel())) {
      QLog.d("VideoEffectTest", 2, "TROUBLE! No config found.");
    }
    localObject = localObject[0];
    this.jdField_a_of_type_AndroidOpenglEGLSurface = EGL14.eglCreatePbufferSurface(this.jdField_a_of_type_AndroidOpenglEGLDisplay, (android.opengl.EGLConfig)localObject, new int[] { 12375, 64, 12374, 64, 12344 }, 0);
    this.jdField_a_of_type_AndroidOpenglEGLContext = EGL14.eglCreateContext(this.jdField_a_of_type_AndroidOpenglEGLDisplay, (android.opengl.EGLConfig)localObject, EGL14.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 }, 0);
    EGL14.eglMakeCurrent(this.jdField_a_of_type_AndroidOpenglEGLDisplay, this.jdField_a_of_type_AndroidOpenglEGLSurface, this.jdField_a_of_type_AndroidOpenglEGLSurface, this.jdField_a_of_type_AndroidOpenglEGLContext);
  }
  
  @SuppressLint({"NewApi"})
  private void f()
  {
    if ((this.jdField_a_of_type_AndroidOpenglEGLDisplay != null) && (this.jdField_a_of_type_AndroidOpenglEGLSurface != null) && (this.jdField_a_of_type_AndroidOpenglEGLContext != null))
    {
      EGL14.eglMakeCurrent(this.jdField_a_of_type_AndroidOpenglEGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
      EGL14.eglDestroySurface(this.jdField_a_of_type_AndroidOpenglEGLDisplay, this.jdField_a_of_type_AndroidOpenglEGLSurface);
      EGL14.eglDestroyContext(this.jdField_a_of_type_AndroidOpenglEGLDisplay, this.jdField_a_of_type_AndroidOpenglEGLContext);
      EGL14.eglTerminate(this.jdField_a_of_type_AndroidOpenglEGLDisplay);
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaLangThread == null) || (!this.jdField_a_of_type_JavaLangThread.isAlive()))
    {
      this.jdField_a_of_type_JavaLangThread = new Thread(this, "VideoEffectTest");
      this.jdField_a_of_type_JavaLangThread.start();
    }
  }
  
  void b()
  {
    l1 = 0L;
    Object localObject = new byte[921600];
    int j = 0;
    i = 0;
    while (j < 480)
    {
      int k = 0;
      while (k < 640)
      {
        localObject[i] = ((byte)(j % 255));
        localObject[(i + 1)] = ((byte)((640 - k) % 255));
        localObject[(i + 2)] = ((byte)((j + k) % 255));
        i += 3;
        k += 1;
      }
      j += 1;
    }
    for (;;)
    {
      try
      {
        localObject = new muv((byte[])localObject, 480, 640);
        ((muv)localObject).a();
        l2 = (((muv)localObject).a() + 0L + ((muv)localObject).a()) / 2L;
        ((muv)localObject).b();
        if (l2 > 0L) {
          continue;
        }
        i = (int)l2;
      }
      catch (Throwable localThrowable)
      {
        long l2;
        l1 = 0L;
        i = 0;
        continue;
      }
      if (this.jdField_a_of_type_Muy != null) {
        this.jdField_a_of_type_Muy.a(i, l1, GLES20.glGetString(7936), GLES20.glGetString(7937));
      }
      return;
      i = 1;
      l1 = l2;
    }
  }
  
  public void run()
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 17) {
        e();
      }
      for (;;)
      {
        b();
        if (Build.VERSION.SDK_INT < 17) {
          break;
        }
        f();
        return;
        c();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      if (this.jdField_a_of_type_Muy != null)
      {
        this.jdField_a_of_type_Muy.a(0, 0L, null, null);
        return;
        d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.videoeffect.VideoEffectTest
 * JD-Core Version:    0.7.0.1
 */