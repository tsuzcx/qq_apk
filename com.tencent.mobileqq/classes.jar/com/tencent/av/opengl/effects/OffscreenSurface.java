package com.tencent.av.opengl.effects;

import android.annotation.SuppressLint;
import android.opengl.EGL14;
import android.os.Build.VERSION;
import com.tencent.avcore.util.AVCoreLog;
import javax.microedition.khronos.egl.EGL10;

public class OffscreenSurface
{
  private android.opengl.EGLContext jdField_a_of_type_AndroidOpenglEGLContext = null;
  private android.opengl.EGLDisplay jdField_a_of_type_AndroidOpenglEGLDisplay = null;
  private android.opengl.EGLSurface jdField_a_of_type_AndroidOpenglEGLSurface = null;
  private EGL10 jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10 = null;
  private javax.microedition.khronos.egl.EGLContext jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = null;
  private javax.microedition.khronos.egl.EGLDisplay jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay = null;
  private javax.microedition.khronos.egl.EGLSurface jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface = null;
  
  private void c()
  {
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10 = ((EGL10)javax.microedition.khronos.egl.EGLContext.getEGL());
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    Object localObject1 = new int[2];
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglInitialize(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, (int[])localObject1);
    localObject1 = new javax.microedition.khronos.egl.EGLConfig[1];
    Object localObject2 = new int[1];
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglChooseConfig(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, new int[] { 12351, 12430, 12329, 0, 12339, 1, 12344 }, (javax.microedition.khronos.egl.EGLConfig[])localObject1, 1, (int[])localObject2);
    if (localObject2[0] == 0) {
      AVCoreLog.e("OffscreenSurface", "TROUBLE! No config found.");
    }
    localObject1 = localObject1[0];
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglCreatePbufferSurface(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, (javax.microedition.khronos.egl.EGLConfig)localObject1, new int[] { 12375, 64, 12374, 64, 12344 });
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglCreateContext(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, (javax.microedition.khronos.egl.EGLConfig)localObject1, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
    localObject1 = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10;
    localObject2 = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay;
    javax.microedition.khronos.egl.EGLSurface localEGLSurface = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface;
    ((EGL10)localObject1).eglMakeCurrent((javax.microedition.khronos.egl.EGLDisplay)localObject2, localEGLSurface, localEGLSurface, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext);
  }
  
  private void d()
  {
    EGL10 localEGL10 = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10;
    if (localEGL10 != null)
    {
      javax.microedition.khronos.egl.EGLDisplay localEGLDisplay = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay;
      if ((localEGLDisplay != null) && (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface != null) && (this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext != null))
      {
        localEGL10.eglMakeCurrent(localEGLDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
        this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglDestroySurface(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface);
        this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglDestroyContext(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext);
        this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglTerminate(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay);
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  private void e()
  {
    this.jdField_a_of_type_AndroidOpenglEGLDisplay = EGL14.eglGetDisplay(0);
    Object localObject1 = new int[2];
    EGL14.eglInitialize(this.jdField_a_of_type_AndroidOpenglEGLDisplay, (int[])localObject1, 0, (int[])localObject1, 1);
    localObject1 = new android.opengl.EGLConfig[1];
    Object localObject2 = new int[1];
    EGL14.eglChooseConfig(this.jdField_a_of_type_AndroidOpenglEGLDisplay, new int[] { 12351, 12430, 12329, 0, 12352, 4, 12339, 1, 12344 }, 0, (android.opengl.EGLConfig[])localObject1, 0, 1, (int[])localObject2, 0);
    if ((localObject2[0] == 0) && (AVCoreLog.isColorLevel())) {
      AVCoreLog.i("OffscreenSurface", "TROUBLE! No config found.");
    }
    localObject1 = localObject1[0];
    this.jdField_a_of_type_AndroidOpenglEGLSurface = EGL14.eglCreatePbufferSurface(this.jdField_a_of_type_AndroidOpenglEGLDisplay, (android.opengl.EGLConfig)localObject1, new int[] { 12375, 64, 12374, 64, 12344 }, 0);
    this.jdField_a_of_type_AndroidOpenglEGLContext = EGL14.eglCreateContext(this.jdField_a_of_type_AndroidOpenglEGLDisplay, (android.opengl.EGLConfig)localObject1, EGL14.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 }, 0);
    localObject1 = this.jdField_a_of_type_AndroidOpenglEGLDisplay;
    localObject2 = this.jdField_a_of_type_AndroidOpenglEGLSurface;
    EGL14.eglMakeCurrent((android.opengl.EGLDisplay)localObject1, (android.opengl.EGLSurface)localObject2, (android.opengl.EGLSurface)localObject2, this.jdField_a_of_type_AndroidOpenglEGLContext);
  }
  
  @SuppressLint({"NewApi"})
  private void g()
  {
    android.opengl.EGLDisplay localEGLDisplay = this.jdField_a_of_type_AndroidOpenglEGLDisplay;
    if ((localEGLDisplay != null) && (this.jdField_a_of_type_AndroidOpenglEGLSurface != null) && (this.jdField_a_of_type_AndroidOpenglEGLContext != null))
    {
      EGL14.eglMakeCurrent(localEGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
      EGL14.eglDestroySurface(this.jdField_a_of_type_AndroidOpenglEGLDisplay, this.jdField_a_of_type_AndroidOpenglEGLSurface);
      EGL14.eglDestroyContext(this.jdField_a_of_type_AndroidOpenglEGLDisplay, this.jdField_a_of_type_AndroidOpenglEGLContext);
      EGL14.eglTerminate(this.jdField_a_of_type_AndroidOpenglEGLDisplay);
    }
  }
  
  void b()
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      e();
      return;
    }
    c();
  }
  
  public void f()
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      g();
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.OffscreenSurface
 * JD-Core Version:    0.7.0.1
 */