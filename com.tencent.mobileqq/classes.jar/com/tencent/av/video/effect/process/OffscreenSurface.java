package com.tencent.av.video.effect.process;

import android.annotation.SuppressLint;
import android.opengl.EGL14;
import android.os.Build.VERSION;
import com.tencent.av.video.effect.utils.Log;
import javax.microedition.khronos.egl.EGL10;

public class OffscreenSurface
{
  private static final String TAG = "OffscreenSurface";
  private EGL10 mEGL10 = null;
  private javax.microedition.khronos.egl.EGLContext mEGL10Context = null;
  private javax.microedition.khronos.egl.EGLDisplay mEGL10Display = null;
  private javax.microedition.khronos.egl.EGLSurface mEGL10Surface = null;
  private android.opengl.EGLContext mEGL14Context = null;
  private android.opengl.EGLDisplay mEGL14Display = null;
  private android.opengl.EGLSurface mEGL14Surface = null;
  
  public OffscreenSurface()
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      createEGL14Context();
      return;
    }
    createEGL10Context();
  }
  
  private void createEGL10Context()
  {
    this.mEGL10 = ((EGL10)javax.microedition.khronos.egl.EGLContext.getEGL());
    this.mEGL10Display = this.mEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    Object localObject1 = new int[2];
    this.mEGL10.eglInitialize(this.mEGL10Display, (int[])localObject1);
    localObject1 = new javax.microedition.khronos.egl.EGLConfig[1];
    Object localObject2 = new int[1];
    this.mEGL10.eglChooseConfig(this.mEGL10Display, new int[] { 12351, 12430, 12329, 0, 12339, 1, 12344 }, (javax.microedition.khronos.egl.EGLConfig[])localObject1, 1, (int[])localObject2);
    if (localObject2[0] == 0) {
      Log.e("OffscreenSurface", "TROUBLE! No config found.");
    }
    localObject1 = localObject1[0];
    this.mEGL10Surface = this.mEGL10.eglCreatePbufferSurface(this.mEGL10Display, (javax.microedition.khronos.egl.EGLConfig)localObject1, new int[] { 12375, 64, 12374, 64, 12344 });
    this.mEGL10Context = this.mEGL10.eglCreateContext(this.mEGL10Display, (javax.microedition.khronos.egl.EGLConfig)localObject1, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
    localObject1 = this.mEGL10;
    localObject2 = this.mEGL10Display;
    javax.microedition.khronos.egl.EGLSurface localEGLSurface = this.mEGL10Surface;
    ((EGL10)localObject1).eglMakeCurrent((javax.microedition.khronos.egl.EGLDisplay)localObject2, localEGLSurface, localEGLSurface, this.mEGL10Context);
  }
  
  @SuppressLint({"NewApi"})
  private void createEGL14Context()
  {
    this.mEGL14Display = EGL14.eglGetDisplay(0);
    Object localObject1 = new int[2];
    EGL14.eglInitialize(this.mEGL14Display, (int[])localObject1, 0, (int[])localObject1, 1);
    localObject1 = new android.opengl.EGLConfig[1];
    Object localObject2 = new int[1];
    EGL14.eglChooseConfig(this.mEGL14Display, new int[] { 12351, 12430, 12329, 0, 12352, 4, 12339, 1, 12344 }, 0, (android.opengl.EGLConfig[])localObject1, 0, 1, (int[])localObject2, 0);
    if (localObject2[0] == 0) {
      Log.e("OffscreenSurface", "TROUBLE! No config found.");
    }
    localObject1 = localObject1[0];
    this.mEGL14Surface = EGL14.eglCreatePbufferSurface(this.mEGL14Display, (android.opengl.EGLConfig)localObject1, new int[] { 12375, 64, 12374, 64, 12344 }, 0);
    this.mEGL14Context = EGL14.eglCreateContext(this.mEGL14Display, (android.opengl.EGLConfig)localObject1, EGL14.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 }, 0);
    localObject1 = this.mEGL14Display;
    localObject2 = this.mEGL14Surface;
    EGL14.eglMakeCurrent((android.opengl.EGLDisplay)localObject1, (android.opengl.EGLSurface)localObject2, (android.opengl.EGLSurface)localObject2, this.mEGL14Context);
  }
  
  private void destroyEGL10Context()
  {
    EGL10 localEGL10 = this.mEGL10;
    if (localEGL10 != null)
    {
      javax.microedition.khronos.egl.EGLDisplay localEGLDisplay = this.mEGL10Display;
      if ((localEGLDisplay != null) && (this.mEGL10Surface != null) && (this.mEGL10Context != null))
      {
        localEGL10.eglMakeCurrent(localEGLDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
        this.mEGL10.eglDestroySurface(this.mEGL10Display, this.mEGL10Surface);
        this.mEGL10.eglDestroyContext(this.mEGL10Display, this.mEGL10Context);
        this.mEGL10.eglTerminate(this.mEGL10Display);
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  private void destroyEGL14Context()
  {
    android.opengl.EGLDisplay localEGLDisplay = this.mEGL14Display;
    if ((localEGLDisplay != null) && (this.mEGL14Surface != null) && (this.mEGL14Context != null))
    {
      EGL14.eglMakeCurrent(localEGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
      EGL14.eglDestroySurface(this.mEGL14Display, this.mEGL14Surface);
      EGL14.eglDestroyContext(this.mEGL14Display, this.mEGL14Context);
      EGL14.eglTerminate(this.mEGL14Display);
    }
  }
  
  public void release()
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      destroyEGL14Context();
      return;
    }
    destroyEGL10Context();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.video.effect.process.OffscreenSurface
 * JD-Core Version:    0.7.0.1
 */