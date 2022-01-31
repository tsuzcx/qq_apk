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
    Object localObject = new int[2];
    this.mEGL10.eglInitialize(this.mEGL10Display, (int[])localObject);
    localObject = new EGLConfig[1];
    int[] arrayOfInt = new int[1];
    this.mEGL10.eglChooseConfig(this.mEGL10Display, new int[] { 12351, 12430, 12329, 0, 12339, 1, 12344 }, (EGLConfig[])localObject, 1, arrayOfInt);
    if (arrayOfInt[0] == 0) {
      Log.e("EGL10Context", "TROUBLE! No config found.");
    }
    localObject = localObject[0];
    this.mEGL10Surface = this.mEGL10.eglCreatePbufferSurface(this.mEGL10Display, (EGLConfig)localObject, new int[] { 12375, 64, 12374, 64, 12344 });
    this.mEGL10Context = this.mEGL10.eglCreateContext(this.mEGL10Display, (EGLConfig)localObject, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
    this.mEGL10.eglMakeCurrent(this.mEGL10Display, this.mEGL10Surface, this.mEGL10Surface, this.mEGL10Context);
  }
  
  public void unbind()
  {
    if ((this.mEGL10 != null) && (this.mEGL10Display != null) && (this.mEGL10Surface != null) && (this.mEGL10Context != null))
    {
      this.mEGL10.eglMakeCurrent(this.mEGL10Display, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
      this.mEGL10.eglDestroySurface(this.mEGL10Display, this.mEGL10Surface);
      this.mEGL10.eglDestroyContext(this.mEGL10Display, this.mEGL10Context);
      this.mEGL10.eglTerminate(this.mEGL10Display);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.camera.opengl.EGL10Context
 * JD-Core Version:    0.7.0.1
 */