package com.tencent.av.videoeffect;

import android.annotation.SuppressLint;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGL10;

public class VideoEffectTest
  implements Runnable
{
  Thread a = null;
  VideoEffectTest.TestResultCallback b = null;
  private EGL10 c = null;
  private javax.microedition.khronos.egl.EGLDisplay d = null;
  private javax.microedition.khronos.egl.EGLSurface e = null;
  private javax.microedition.khronos.egl.EGLContext f = null;
  private android.opengl.EGLDisplay g = null;
  private android.opengl.EGLSurface h = null;
  private android.opengl.EGLContext i = null;
  
  public VideoEffectTest(VideoEffectTest.TestResultCallback paramTestResultCallback)
  {
    this.b = paramTestResultCallback;
  }
  
  private void c()
  {
    this.c = ((EGL10)javax.microedition.khronos.egl.EGLContext.getEGL());
    this.d = this.c.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    Object localObject1 = new int[2];
    this.c.eglInitialize(this.d, (int[])localObject1);
    localObject1 = new javax.microedition.khronos.egl.EGLConfig[1];
    Object localObject2 = new int[1];
    this.c.eglChooseConfig(this.d, new int[] { 12351, 12430, 12329, 0, 12339, 1, 12344 }, (javax.microedition.khronos.egl.EGLConfig[])localObject1, 1, (int[])localObject2);
    if ((localObject2[0] == 0) && (QLog.isColorLevel())) {
      QLog.d("VideoEffectTest", 2, "TROUBLE! No config found.");
    }
    localObject1 = localObject1[0];
    this.e = this.c.eglCreatePbufferSurface(this.d, (javax.microedition.khronos.egl.EGLConfig)localObject1, new int[] { 12375, 64, 12374, 64, 12344 });
    this.f = this.c.eglCreateContext(this.d, (javax.microedition.khronos.egl.EGLConfig)localObject1, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
    localObject1 = this.c;
    localObject2 = this.d;
    javax.microedition.khronos.egl.EGLSurface localEGLSurface = this.e;
    ((EGL10)localObject1).eglMakeCurrent((javax.microedition.khronos.egl.EGLDisplay)localObject2, localEGLSurface, localEGLSurface, this.f);
  }
  
  private void d()
  {
    EGL10 localEGL10 = this.c;
    if (localEGL10 != null)
    {
      javax.microedition.khronos.egl.EGLDisplay localEGLDisplay = this.d;
      if ((localEGLDisplay != null) && (this.e != null) && (this.f != null))
      {
        localEGL10.eglMakeCurrent(localEGLDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
        this.c.eglDestroySurface(this.d, this.e);
        this.c.eglDestroyContext(this.d, this.f);
        this.c.eglTerminate(this.d);
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  private void e()
  {
    this.g = EGL14.eglGetDisplay(0);
    Object localObject1 = new int[2];
    EGL14.eglInitialize(this.g, (int[])localObject1, 0, (int[])localObject1, 1);
    localObject1 = new android.opengl.EGLConfig[1];
    Object localObject2 = new int[1];
    EGL14.eglChooseConfig(this.g, new int[] { 12351, 12430, 12329, 0, 12352, 4, 12339, 1, 12344 }, 0, (android.opengl.EGLConfig[])localObject1, 0, 1, (int[])localObject2, 0);
    if ((localObject2[0] == 0) && (QLog.isColorLevel())) {
      QLog.d("VideoEffectTest", 2, "TROUBLE! No config found.");
    }
    localObject1 = localObject1[0];
    this.h = EGL14.eglCreatePbufferSurface(this.g, (android.opengl.EGLConfig)localObject1, new int[] { 12375, 64, 12374, 64, 12344 }, 0);
    this.i = EGL14.eglCreateContext(this.g, (android.opengl.EGLConfig)localObject1, EGL14.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 }, 0);
    localObject1 = this.g;
    localObject2 = this.h;
    EGL14.eglMakeCurrent((android.opengl.EGLDisplay)localObject1, (android.opengl.EGLSurface)localObject2, (android.opengl.EGLSurface)localObject2, this.i);
  }
  
  @SuppressLint({"NewApi"})
  private void f()
  {
    android.opengl.EGLDisplay localEGLDisplay = this.g;
    if ((localEGLDisplay != null) && (this.h != null) && (this.i != null))
    {
      EGL14.eglMakeCurrent(localEGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
      EGL14.eglDestroySurface(this.g, this.h);
      EGL14.eglDestroyContext(this.g, this.i);
      EGL14.eglTerminate(this.g);
    }
  }
  
  public void a()
  {
    Thread localThread = this.a;
    if ((localThread == null) || (!localThread.isAlive()))
    {
      this.a = new Thread(this, "VideoEffectTest");
      this.a.start();
    }
  }
  
  void b()
  {
    Object localObject = new byte[921600];
    int k = 0;
    int j = 0;
    while (k < 480)
    {
      int m = 0;
      while (m < 640)
      {
        localObject[j] = ((byte)(k % 255));
        localObject[(j + 1)] = ((byte)((640 - m) % 255));
        localObject[(j + 2)] = ((byte)((k + m) % 255));
        j += 3;
        m += 1;
      }
      k += 1;
    }
    long l1 = 0L;
    try
    {
      localObject = new FilterProcess((byte[])localObject, 480, 640);
      ((FilterProcess)localObject).b();
      long l2 = (((FilterProcess)localObject).b() + 0L + ((FilterProcess)localObject).b()) / 2L;
      ((FilterProcess)localObject).c();
      if (l2 <= 0L)
      {
        j = (int)l2;
      }
      else
      {
        l1 = l2;
        j = 1;
      }
    }
    catch (Throwable localThrowable)
    {
      label157:
      break label157;
    }
    l1 = 0L;
    j = 0;
    localObject = this.b;
    if (localObject != null) {
      ((VideoEffectTest.TestResultCallback)localObject).a(j, l1, GLES20.glGetString(7936), GLES20.glGetString(7937));
    }
  }
  
  public void run()
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 17) {
        e();
      } else {
        c();
      }
      b();
      if (Build.VERSION.SDK_INT >= 17)
      {
        f();
        return;
      }
      d();
      return;
    }
    catch (Throwable localThrowable)
    {
      label41:
      VideoEffectTest.TestResultCallback localTestResultCallback;
      break label41;
    }
    localTestResultCallback = this.b;
    if (localTestResultCallback != null) {
      localTestResultCallback.a(0, 0L, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.videoeffect.VideoEffectTest
 * JD-Core Version:    0.7.0.1
 */