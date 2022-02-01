package com.tencent.liteav.beauty.a.a;

import javax.microedition.khronos.egl.EGL11;
import javax.microedition.khronos.egl.EGLSurface;

public class b
{
  protected a a;
  private EGLSurface b = EGL11.EGL_NO_SURFACE;
  private int c = -1;
  private int d = -1;
  
  protected b(a parama)
  {
    this.a = parama;
  }
  
  public void a()
  {
    this.a.a(this.b);
    this.b = EGL11.EGL_NO_SURFACE;
    this.d = -1;
    this.c = -1;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.b == EGL11.EGL_NO_SURFACE)
    {
      this.b = this.a.a(paramInt1, paramInt2);
      this.c = paramInt1;
      this.d = paramInt2;
      return;
    }
    throw new IllegalStateException("surface already created");
  }
  
  public void b()
  {
    this.a.b(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.a.a.b
 * JD-Core Version:    0.7.0.1
 */