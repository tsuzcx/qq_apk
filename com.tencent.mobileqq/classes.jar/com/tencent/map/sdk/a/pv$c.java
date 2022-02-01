package com.tencent.map.sdk.a;

import android.util.Log;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

final class pv$c
  implements pv.f
{
  private int b = 12440;
  
  private pv$c(pv parampv) {}
  
  public final EGLContext a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = this.b;
    arrayOfInt[1] = pv.a(this.a);
    arrayOfInt[2] = 12344;
    EGLContext localEGLContext = EGL10.EGL_NO_CONTEXT;
    if (pv.a(this.a) == 0) {
      arrayOfInt = null;
    }
    return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, localEGLContext, arrayOfInt);
  }
  
  public final void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext))
    {
      StringBuilder localStringBuilder = new StringBuilder("display:");
      localStringBuilder.append(paramEGLDisplay);
      localStringBuilder.append(" context: ");
      localStringBuilder.append(paramEGLContext);
      Log.e("DefaultContextFactory", localStringBuilder.toString());
      paramEGL10.eglGetError();
      pv.h.a("eglDestroyContex");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.pv.c
 * JD-Core Version:    0.7.0.1
 */