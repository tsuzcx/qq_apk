package com.tencent.mobileqq.apollo.view.opengl;

import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class DefaultWindowSurfaceFactory
  implements EGLWindowSurfaceFactory
{
  public EGLSurface a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject)
  {
    if (paramObject != null) {
      try
      {
        paramEGL10 = paramEGL10.eglCreateWindowSurface(paramEGLDisplay, paramEGLConfig, paramObject, null);
        return paramEGL10;
      }
      catch (Throwable paramEGL10)
      {
        QLog.e("[ApolloGL][DefWindowSurfaceFactory]", 1, "eglCreateWindowSurface exception", paramEGL10);
      }
    }
    return null;
  }
  
  public void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
  {
    paramEGL10.eglDestroySurface(paramEGLDisplay, paramEGLSurface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.opengl.DefaultWindowSurfaceFactory
 * JD-Core Version:    0.7.0.1
 */