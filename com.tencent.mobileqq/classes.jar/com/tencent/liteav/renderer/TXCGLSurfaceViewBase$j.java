package com.tencent.liteav.renderer;

import javax.microedition.khronos.opengles.GL10;

class TXCGLSurfaceViewBase$j
{
  private static String a = "GLThreadManager";
  private boolean b;
  private int c;
  private boolean d;
  private boolean e;
  private boolean f;
  private TXCGLSurfaceViewBase.i g;
  
  private void c()
  {
    this.c = 131072;
    this.e = true;
    this.b = true;
  }
  
  public void a(TXCGLSurfaceViewBase.i parami)
  {
    try
    {
      TXCGLSurfaceViewBase.i.a(parami, true);
      if (this.g == parami) {
        this.g = null;
      }
      notifyAll();
      return;
    }
    finally {}
  }
  
  public void a(GL10 paramGL10)
  {
    for (;;)
    {
      try
      {
        if (!this.d)
        {
          c();
          paramGL10 = paramGL10.glGetString(7937);
          int i = this.c;
          boolean bool2 = false;
          if (i < 131072)
          {
            if (!paramGL10.startsWith("Q3Dimension MSM7500 "))
            {
              bool1 = true;
              this.e = bool1;
              notifyAll();
            }
          }
          else
          {
            bool1 = bool2;
            if (!this.e) {
              bool1 = true;
            }
            this.f = bool1;
            this.d = true;
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      boolean bool1 = false;
    }
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.f;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean b()
  {
    try
    {
      c();
      boolean bool = this.e;
      return bool ^ true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean b(TXCGLSurfaceViewBase.i parami)
  {
    TXCGLSurfaceViewBase.i locali = this.g;
    if ((locali != parami) && (locali != null))
    {
      c();
      if (this.e) {
        return true;
      }
      parami = this.g;
      if (parami != null) {
        parami.i();
      }
      return false;
    }
    this.g = parami;
    notifyAll();
    return true;
  }
  
  public void c(TXCGLSurfaceViewBase.i parami)
  {
    if (this.g == parami) {
      this.g = null;
    }
    notifyAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.renderer.TXCGLSurfaceViewBase.j
 * JD-Core Version:    0.7.0.1
 */