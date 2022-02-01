package com.tencent.mobileqq.ar.ARRecord;

import android.view.Surface;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EglCore;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EglSurfaceBase;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class VideoEncoderWindowSurface
{
  private EGL10 a = (EGL10)EGLContext.getEGL();
  private EGLDisplay b = this.a.eglGetCurrentDisplay();
  private EGLContext c = this.a.eglGetCurrentContext();
  private EGLSurface d = this.a.eglGetCurrentSurface(12377);
  private EglSurfaceBase e;
  
  public VideoEncoderWindowSurface(EglCore paramEglCore, Surface paramSurface)
  {
    this.e = new EglSurfaceBase(paramEglCore);
    this.e.a(paramSurface);
  }
  
  public void a()
  {
    EGL10 localEGL10 = this.a;
    EGLDisplay localEGLDisplay = this.b;
    EGLSurface localEGLSurface = this.d;
    localEGL10.eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, this.c);
  }
  
  public void a(long paramLong)
  {
    this.e.a(paramLong);
  }
  
  public void b()
  {
    this.e.b();
  }
  
  public void c()
  {
    this.e.c();
  }
  
  public void d()
  {
    EglSurfaceBase localEglSurfaceBase = this.e;
    if (localEglSurfaceBase != null)
    {
      localEglSurfaceBase.a();
      this.e = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.VideoEncoderWindowSurface
 * JD-Core Version:    0.7.0.1
 */