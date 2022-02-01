package com.tencent.mobileqq.apollo.view.opengl;

import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class ApolloOffscreenSurfaceFactory
  implements EGLWindowSurfaceFactory
{
  private int a;
  private int b;
  
  public ApolloOffscreenSurfaceFactory(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public EGLSurface a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject)
  {
    try
    {
      paramEGL10 = paramEGL10.eglCreatePbufferSurface(paramEGLDisplay, paramEGLConfig, new int[] { 12375, this.a, 12374, this.b, 12344 });
      return paramEGL10;
    }
    catch (Throwable paramEGL10)
    {
      QLog.e("ApolloOffscreenSurfaceFactory", 2, "eglCreatePbufferSurface", paramEGL10);
    }
    return null;
  }
  
  public void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
  {
    paramEGL10.eglDestroySurface(paramEGLDisplay, paramEGLSurface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.opengl.ApolloOffscreenSurfaceFactory
 * JD-Core Version:    0.7.0.1
 */