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
  private android.opengl.EGLContext jdField_a_of_type_AndroidOpenglEGLContext = null;
  private android.opengl.EGLDisplay jdField_a_of_type_AndroidOpenglEGLDisplay = null;
  private android.opengl.EGLSurface jdField_a_of_type_AndroidOpenglEGLSurface = null;
  VideoEffectTest.TestResultCallback jdField_a_of_type_ComTencentAvVideoeffectVideoEffectTest$TestResultCallback = null;
  Thread jdField_a_of_type_JavaLangThread = null;
  private EGL10 jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10 = null;
  private javax.microedition.khronos.egl.EGLContext jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = null;
  private javax.microedition.khronos.egl.EGLDisplay jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay = null;
  private javax.microedition.khronos.egl.EGLSurface jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface = null;
  
  public VideoEffectTest(VideoEffectTest.TestResultCallback paramTestResultCallback)
  {
    this.jdField_a_of_type_ComTencentAvVideoeffectVideoEffectTest$TestResultCallback = paramTestResultCallback;
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10 = ((EGL10)javax.microedition.khronos.egl.EGLContext.getEGL());
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    Object localObject1 = new int[2];
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglInitialize(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, (int[])localObject1);
    localObject1 = new javax.microedition.khronos.egl.EGLConfig[1];
    Object localObject2 = new int[1];
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglChooseConfig(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, new int[] { 12351, 12430, 12329, 0, 12339, 1, 12344 }, (javax.microedition.khronos.egl.EGLConfig[])localObject1, 1, (int[])localObject2);
    if ((localObject2[0] == 0) && (QLog.isColorLevel())) {
      QLog.d("VideoEffectTest", 2, "TROUBLE! No config found.");
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
    if ((localObject2[0] == 0) && (QLog.isColorLevel())) {
      QLog.d("VideoEffectTest", 2, "TROUBLE! No config found.");
    }
    localObject1 = localObject1[0];
    this.jdField_a_of_type_AndroidOpenglEGLSurface = EGL14.eglCreatePbufferSurface(this.jdField_a_of_type_AndroidOpenglEGLDisplay, (android.opengl.EGLConfig)localObject1, new int[] { 12375, 64, 12374, 64, 12344 }, 0);
    this.jdField_a_of_type_AndroidOpenglEGLContext = EGL14.eglCreateContext(this.jdField_a_of_type_AndroidOpenglEGLDisplay, (android.opengl.EGLConfig)localObject1, EGL14.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 }, 0);
    localObject1 = this.jdField_a_of_type_AndroidOpenglEGLDisplay;
    localObject2 = this.jdField_a_of_type_AndroidOpenglEGLSurface;
    EGL14.eglMakeCurrent((android.opengl.EGLDisplay)localObject1, (android.opengl.EGLSurface)localObject2, (android.opengl.EGLSurface)localObject2, this.jdField_a_of_type_AndroidOpenglEGLContext);
  }
  
  @SuppressLint({"NewApi"})
  private void f()
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
  
  public void a()
  {
    Thread localThread = this.jdField_a_of_type_JavaLangThread;
    if ((localThread == null) || (!localThread.isAlive()))
    {
      this.jdField_a_of_type_JavaLangThread = new Thread(this, "VideoEffectTest");
      this.jdField_a_of_type_JavaLangThread.start();
    }
  }
  
  void b()
  {
    Object localObject = new byte[921600];
    int j = 0;
    int i = 0;
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
    long l1 = 0L;
    try
    {
      localObject = new FilterProcess((byte[])localObject, 480, 640);
      ((FilterProcess)localObject).a();
      long l2 = (((FilterProcess)localObject).a() + 0L + ((FilterProcess)localObject).a()) / 2L;
      ((FilterProcess)localObject).b();
      if (l2 <= 0L)
      {
        i = (int)l2;
      }
      else
      {
        l1 = l2;
        i = 1;
      }
    }
    catch (Throwable localThrowable)
    {
      label157:
      break label157;
    }
    l1 = 0L;
    i = 0;
    localObject = this.jdField_a_of_type_ComTencentAvVideoeffectVideoEffectTest$TestResultCallback;
    if (localObject != null) {
      ((VideoEffectTest.TestResultCallback)localObject).a(i, l1, GLES20.glGetString(7936), GLES20.glGetString(7937));
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
    localTestResultCallback = this.jdField_a_of_type_ComTencentAvVideoeffectVideoEffectTest$TestResultCallback;
    if (localTestResultCallback != null) {
      localTestResultCallback.a(0, 0L, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.videoeffect.VideoEffectTest
 * JD-Core Version:    0.7.0.1
 */