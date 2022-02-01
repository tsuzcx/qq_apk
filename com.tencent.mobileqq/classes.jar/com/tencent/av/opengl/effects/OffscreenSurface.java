package com.tencent.av.opengl.effects;

import android.annotation.SuppressLint;
import android.opengl.EGL14;
import android.os.Build.VERSION;
import com.tencent.avcore.util.AVCoreLog;
import javax.microedition.khronos.egl.EGL10;

public class OffscreenSurface
{
  private EGL10 a = null;
  private javax.microedition.khronos.egl.EGLDisplay b = null;
  private javax.microedition.khronos.egl.EGLSurface c = null;
  private javax.microedition.khronos.egl.EGLContext d = null;
  private android.opengl.EGLDisplay e = null;
  private android.opengl.EGLSurface f = null;
  private android.opengl.EGLContext g = null;
  
  private void c()
  {
    this.a = ((EGL10)javax.microedition.khronos.egl.EGLContext.getEGL());
    this.b = this.a.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    Object localObject1 = new int[2];
    this.a.eglInitialize(this.b, (int[])localObject1);
    localObject1 = new javax.microedition.khronos.egl.EGLConfig[1];
    Object localObject2 = new int[1];
    this.a.eglChooseConfig(this.b, new int[] { 12351, 12430, 12329, 0, 12339, 1, 12344 }, (javax.microedition.khronos.egl.EGLConfig[])localObject1, 1, (int[])localObject2);
    if (localObject2[0] == 0) {
      AVCoreLog.e("OffscreenSurface", "TROUBLE! No config found.");
    }
    localObject1 = localObject1[0];
    this.c = this.a.eglCreatePbufferSurface(this.b, (javax.microedition.khronos.egl.EGLConfig)localObject1, new int[] { 12375, 64, 12374, 64, 12344 });
    this.d = this.a.eglCreateContext(this.b, (javax.microedition.khronos.egl.EGLConfig)localObject1, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
    localObject1 = this.a;
    localObject2 = this.b;
    javax.microedition.khronos.egl.EGLSurface localEGLSurface = this.c;
    ((EGL10)localObject1).eglMakeCurrent((javax.microedition.khronos.egl.EGLDisplay)localObject2, localEGLSurface, localEGLSurface, this.d);
  }
  
  private void d()
  {
    EGL10 localEGL10 = this.a;
    if (localEGL10 != null)
    {
      javax.microedition.khronos.egl.EGLDisplay localEGLDisplay = this.b;
      if ((localEGLDisplay != null) && (this.c != null) && (this.d != null))
      {
        localEGL10.eglMakeCurrent(localEGLDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
        this.a.eglDestroySurface(this.b, this.c);
        this.a.eglDestroyContext(this.b, this.d);
        this.a.eglTerminate(this.b);
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  private void e()
  {
    this.e = EGL14.eglGetDisplay(0);
    Object localObject1 = new int[2];
    EGL14.eglInitialize(this.e, (int[])localObject1, 0, (int[])localObject1, 1);
    localObject1 = new android.opengl.EGLConfig[1];
    Object localObject2 = new int[1];
    EGL14.eglChooseConfig(this.e, new int[] { 12351, 12430, 12329, 0, 12352, 4, 12339, 1, 12344 }, 0, (android.opengl.EGLConfig[])localObject1, 0, 1, (int[])localObject2, 0);
    if ((localObject2[0] == 0) && (AVCoreLog.isColorLevel())) {
      AVCoreLog.i("OffscreenSurface", "TROUBLE! No config found.");
    }
    localObject1 = localObject1[0];
    this.f = EGL14.eglCreatePbufferSurface(this.e, (android.opengl.EGLConfig)localObject1, new int[] { 12375, 64, 12374, 64, 12344 }, 0);
    this.g = EGL14.eglCreateContext(this.e, (android.opengl.EGLConfig)localObject1, EGL14.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 }, 0);
    localObject1 = this.e;
    localObject2 = this.f;
    EGL14.eglMakeCurrent((android.opengl.EGLDisplay)localObject1, (android.opengl.EGLSurface)localObject2, (android.opengl.EGLSurface)localObject2, this.g);
  }
  
  @SuppressLint({"NewApi"})
  private void f()
  {
    android.opengl.EGLDisplay localEGLDisplay = this.e;
    if ((localEGLDisplay != null) && (this.f != null) && (this.g != null))
    {
      EGL14.eglMakeCurrent(localEGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
      EGL14.eglDestroySurface(this.e, this.f);
      EGL14.eglDestroyContext(this.e, this.g);
      EGL14.eglTerminate(this.e);
    }
  }
  
  void g()
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      e();
      return;
    }
    c();
  }
  
  public void n()
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      f();
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.OffscreenSurface
 * JD-Core Version:    0.7.0.1
 */