package com.tencent.liteav.renderer;

import com.tencent.liteav.basic.log.TXCLog;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

class TXCGLSurfaceViewBase$c
  implements TXCGLSurfaceViewBase.f
{
  private int b = 12440;
  
  private TXCGLSurfaceViewBase$c(TXCGLSurfaceViewBase paramTXCGLSurfaceViewBase) {}
  
  public EGLContext a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = this.b;
    arrayOfInt[1] = TXCGLSurfaceViewBase.h(this.a);
    arrayOfInt[2] = 12344;
    EGLContext localEGLContext = EGL10.EGL_NO_CONTEXT;
    if (TXCGLSurfaceViewBase.h(this.a) == 0) {
      arrayOfInt = null;
    }
    return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, localEGLContext, arrayOfInt);
  }
  
  public void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("display:");
      localStringBuilder.append(paramEGLDisplay);
      localStringBuilder.append(" context: ");
      localStringBuilder.append(paramEGLContext);
      TXCLog.e("DefaultContextFactory", localStringBuilder.toString());
      TXCGLSurfaceViewBase.h.a("eglDestroyContex", paramEGL10.eglGetError());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.renderer.TXCGLSurfaceViewBase.c
 * JD-Core Version:    0.7.0.1
 */