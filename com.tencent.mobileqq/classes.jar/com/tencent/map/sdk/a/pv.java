package com.tencent.map.sdk.a;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import java.lang.ref.WeakReference;

public class pv
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  static final pv.j a = new pv.j((byte)0);
  pv.i b;
  private final WeakReference<pv> c = new WeakReference(this);
  private pv.m d;
  private boolean e;
  private pv.e f;
  private pv.f g;
  private pv.g h;
  private pv.k i;
  private int j;
  private int k;
  private boolean l;
  
  public pv(Context paramContext)
  {
    super(paramContext);
    getHolder().addCallback(this);
  }
  
  private void b()
  {
    if (this.b != null) {
      throw new IllegalStateException("setRenderer has already been called for this instance.");
    }
  }
  
  protected void finalize()
  {
    try
    {
      if (this.b != null) {
        this.b.c();
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public int getDebugFlags()
  {
    return this.j;
  }
  
  public boolean getPreserveEGLContextOnPause()
  {
    return this.l;
  }
  
  public int getRenderMode()
  {
    return this.b.b();
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.e) && (this.d != null)) {
      if (this.b == null) {
        break label74;
      }
    }
    label74:
    for (int m = this.b.b();; m = 1)
    {
      this.b = new pv.i(this.c);
      if (m != 1) {
        this.b.a(m);
      }
      this.b.start();
      this.e = false;
      return;
    }
  }
  
  public void onDetachedFromWindow()
  {
    if (this.b != null) {
      this.b.c();
    }
    this.e = true;
    super.onDetachedFromWindow();
  }
  
  public void onPause()
  {
    pv.i locali = this.b;
    synchronized (a)
    {
      locali.b = true;
      a.notifyAll();
      for (;;)
      {
        if (!locali.a)
        {
          boolean bool = locali.c;
          if (!bool) {
            try
            {
              a.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
  }
  
  public void onResume()
  {
    pv.i locali = this.b;
    synchronized (a)
    {
      locali.b = false;
      locali.l = true;
      locali.m = false;
      a.notifyAll();
      for (;;)
      {
        if ((!locali.a) && (locali.c))
        {
          boolean bool = locali.m;
          if (!bool) {
            try
            {
              a.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
  }
  
  public void setDebugFlags(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setEGLConfigChooser(pv.e parame)
  {
    b();
    this.f = parame;
  }
  
  public void setEGLConfigChooser(boolean paramBoolean)
  {
    setEGLConfigChooser(new pv.n(this, paramBoolean));
  }
  
  public void setEGLContextClientVersion(int paramInt)
  {
    b();
    this.k = paramInt;
  }
  
  public void setEGLContextFactory(pv.f paramf)
  {
    b();
    this.g = paramf;
  }
  
  public void setEGLWindowSurfaceFactory(pv.g paramg)
  {
    b();
    this.h = paramg;
  }
  
  public void setGLWrapper(pv.k paramk)
  {
    this.i = paramk;
  }
  
  public void setPreserveEGLContextOnPause(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void setRenderMode(int paramInt)
  {
    this.b.a(paramInt);
  }
  
  public void setRenderer(pv.m paramm)
  {
    b();
    if (this.f == null) {
      this.f = new pv.n(this, true);
    }
    if (this.g == null) {
      this.g = new pv.c(this, (byte)0);
    }
    if (this.h == null) {
      this.h = new pv.d((byte)0);
    }
    this.d = paramm;
    this.b = new pv.i(this.c);
    this.b.start();
  }
  
  public void surfaceChanged(SurfaceHolder arg1, int paramInt1, int paramInt2, int paramInt3)
  {
    pv.i locali = this.b;
    for (;;)
    {
      synchronized (a)
      {
        locali.j = paramInt2;
        locali.k = paramInt3;
        locali.n = true;
        locali.l = true;
        locali.m = false;
        a.notifyAll();
        if ((locali.a) || (locali.c) || (locali.m)) {
          break;
        }
        if ((locali.f) && (locali.g))
        {
          boolean bool = locali.a();
          if (bool)
          {
            paramInt1 = 1;
            if (paramInt1 == 0) {
              break;
            }
            try
            {
              a.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
      paramInt1 = 0;
    }
  }
  
  public void surfaceCreated(SurfaceHolder arg1)
  {
    pv.i locali = this.b;
    synchronized (a)
    {
      locali.d = true;
      locali.h = false;
      a.notifyAll();
      for (;;)
      {
        if ((locali.e) && (!locali.h))
        {
          boolean bool = locali.a;
          if (!bool) {
            try
            {
              a.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder arg1)
  {
    pv.i locali = this.b;
    synchronized (a)
    {
      locali.d = false;
      a.notifyAll();
      for (;;)
      {
        if (!locali.e)
        {
          boolean bool = locali.a;
          if (!bool) {
            try
            {
              a.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.pv
 * JD-Core Version:    0.7.0.1
 */