package com.tencent.TMG.camera.opengl;

import android.annotation.SuppressLint;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.util.Log;

public class EGL14Context
  implements EGLContext
{
  private static final String TAG = "EGL14Context";
  private android.opengl.EGLContext mEGL14Context = null;
  private EGLDisplay mEGL14Display = null;
  private EGLSurface mEGL14Surface = null;
  
  @SuppressLint({"NewApi"})
  public void bind()
  {
    this.mEGL14Display = EGL14.eglGetDisplay(0);
    Object localObject1 = new int[2];
    EGL14.eglInitialize(this.mEGL14Display, (int[])localObject1, 0, (int[])localObject1, 1);
    localObject1 = new EGLConfig[1];
    Object localObject2 = new int[1];
    EGL14.eglChooseConfig(this.mEGL14Display, new int[] { 12351, 12430, 12329, 0, 12352, 4, 12339, 1, 12344 }, 0, (EGLConfig[])localObject1, 0, 1, (int[])localObject2, 0);
    if (localObject2[0] == 0) {
      Log.e("EGL14Context", "TROUBLE! No config found.");
    }
    localObject1 = localObject1[0];
    this.mEGL14Surface = EGL14.eglCreatePbufferSurface(this.mEGL14Display, (EGLConfig)localObject1, new int[] { 12375, 64, 12374, 64, 12344 }, 0);
    this.mEGL14Context = EGL14.eglCreateContext(this.mEGL14Display, (EGLConfig)localObject1, EGL14.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 }, 0);
    localObject1 = this.mEGL14Display;
    localObject2 = this.mEGL14Surface;
    EGL14.eglMakeCurrent((EGLDisplay)localObject1, (EGLSurface)localObject2, (EGLSurface)localObject2, this.mEGL14Context);
  }
  
  @SuppressLint({"NewApi"})
  public void unbind()
  {
    EGLDisplay localEGLDisplay = this.mEGL14Display;
    if ((localEGLDisplay != null) && (this.mEGL14Surface != null) && (this.mEGL14Context != null))
    {
      EGL14.eglMakeCurrent(localEGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
      EGL14.eglDestroySurface(this.mEGL14Display, this.mEGL14Surface);
      EGL14.eglDestroyContext(this.mEGL14Display, this.mEGL14Context);
      EGL14.eglTerminate(this.mEGL14Display);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.camera.opengl.EGL14Context
 * JD-Core Version:    0.7.0.1
 */