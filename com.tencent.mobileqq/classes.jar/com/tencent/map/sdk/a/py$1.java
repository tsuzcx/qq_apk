package com.tencent.map.sdk.a;

import android.util.Log;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

final class py$1
  implements pv.f
{
  py$1(py parampy) {}
  
  public final EGLContext a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
  }
  
  public final void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    Object localObject = new byte[1];
    py.a(this.a, (byte[])localObject);
    try
    {
      localObject.wait(1000L);
      py.a(this.a);
      localObject = EGL10.EGL_NO_SURFACE;
      paramEGL10.eglMakeCurrent(paramEGLDisplay, (EGLSurface)localObject, (EGLSurface)localObject, EGL10.EGL_NO_CONTEXT);
      paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        or.b(Log.getStackTraceString(localInterruptedException));
        Thread.currentThread().interrupt();
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.py.1
 * JD-Core Version:    0.7.0.1
 */