package com.tencent.TMG.camera.opengl;

import android.util.Log;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class EGL10Context
  implements EGLContext
{
  private static final String TAG = "EGL10Context";
  private EGL10 mEGL10 = null;
  private javax.microedition.khronos.egl.EGLContext mEGL10Context = null;
  private EGLDisplay mEGL10Display = null;
  private EGLSurface mEGL10Surface = null;
  
  public void bind()
  {
    this.mEGL10 = ((EGL10)javax.microedition.khronos.egl.EGLContext.getEGL());
    this.mEGL10Display = this.mEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    Object localObject1 = new int[2];
    this.mEGL10.eglInitialize(this.mEGL10Display, (int[])localObject1);
    localObject1 = new EGLConfig[1];
    Object localObject2 = new int[1];
    this.mEGL10.eglChooseConfig(this.mEGL10Display, new int[] { 12351, 12430, 12329, 0, 12339, 1, 12344 }, (EGLConfig[])localObject1, 1, (int[])localObject2);
    if (localObject2[0] == 0) {
      Log.e("EGL10Context", "TROUBLE! No config found.");
    }
    localObject1 = localObject1[0];
    this.mEGL10Surface = this.mEGL10.eglCreatePbufferSurface(this.mEGL10Display, (EGLConfig)localObject1, new int[] { 12375, 64, 12374, 64, 12344 });
    this.mEGL10Context = this.mEGL10.eglCreateContext(this.mEGL10Display, (EGLConfig)localObject1, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
    localObject1 = this.mEGL10;
    localObject2 = this.mEGL10Display;
    EGLSurface localEGLSurface = this.mEGL10Surface;
    ((EGL10)localObject1).eglMakeCurrent((EGLDisplay)localObject2, localEGLSurface, localEGLSurface, this.mEGL10Context);
  }
  
  public void unbind()
  {
    EGL10 localEGL10 = this.mEGL10;
    if (localEGL10 != null)
    {
      EGLDisplay localEGLDisplay = this.mEGL10Display;
      if ((localEGLDisplay != null) && (this.mEGL10Surface != null) && (this.mEGL10Context != null))
      {
        localEGL10.eglMakeCurrent(localEGLDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
        this.mEGL10.eglDestroySurface(this.mEGL10Display, this.mEGL10Surface);
        this.mEGL10.eglDestroyContext(this.mEGL10Display, this.mEGL10Context);
        this.mEGL10.eglTerminate(this.mEGL10Display);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.camera.opengl.EGL10Context
 * JD-Core Version:    0.7.0.1
 */