package com.tencent.liteav.renderer;

import android.content.Context;
import android.opengl.GLSurfaceView.Renderer;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;

public class TXCGLSurfaceViewBase
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  private static final TXCGLSurfaceViewBase.j a = new TXCGLSurfaceViewBase.j(null);
  protected boolean b = false;
  protected boolean c = false;
  protected final WeakReference<TXCGLSurfaceViewBase> d = new WeakReference(this);
  protected boolean e;
  protected boolean f;
  private TXCGLSurfaceViewBase.i g;
  private GLSurfaceView.Renderer h;
  private boolean i;
  private TXCGLSurfaceViewBase.e j;
  private TXCGLSurfaceViewBase.f k;
  private TXCGLSurfaceViewBase.g l;
  private TXCGLSurfaceViewBase.k m;
  private int n;
  private int o;
  private boolean p;
  
  public TXCGLSurfaceViewBase(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public TXCGLSurfaceViewBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    getHolder().addCallback(this);
  }
  
  private void g()
  {
    if (this.g == null) {
      return;
    }
    throw new IllegalStateException("setRenderer has already been called for this instance.");
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    setEGLConfigChooser(new TXCGLSurfaceViewBase.b(this, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6));
  }
  
  protected void b() {}
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
    if ((!this.b) && (this.c) && (this.g != null))
    {
      TXCLog.w("TXCGLSurfaceViewBase", "background capture destroy surface when not enable background run");
      this.g.a(new TXCGLSurfaceViewBase.2(this));
      this.g.g();
    }
  }
  
  protected int c()
  {
    return 0;
  }
  
  public boolean d()
  {
    return this.g.a();
  }
  
  public int e()
  {
    return this.g.b();
  }
  
  protected void finalize()
  {
    try
    {
      if (this.g != null) {
        this.g.h();
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
    return this.n;
  }
  
  public TXCGLSurfaceViewBase.h getEGLHelper()
  {
    return this.g.c();
  }
  
  public boolean getPreserveEGLContextOnPause()
  {
    return this.p;
  }
  
  public int getRenderMode()
  {
    return this.g.e();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.i) && (this.h != null))
    {
      TXCGLSurfaceViewBase.i locali = this.g;
      int i1;
      if (locali != null) {
        i1 = locali.e();
      } else {
        i1 = 1;
      }
      this.g = new TXCGLSurfaceViewBase.i(this.d);
      if (i1 != 1) {
        this.g.a(i1);
      }
      this.g.start();
    }
    this.i = false;
  }
  
  protected void onDetachedFromWindow()
  {
    if ((this.b) && (this.g != null))
    {
      TXCLog.w("TXCGLSurfaceViewBase", "background capture destroy surface when onDetachedFromWindow");
      this.g.a(new TXCGLSurfaceViewBase.3(this));
      this.g.g();
    }
    TXCGLSurfaceViewBase.i locali = this.g;
    if (locali != null) {
      locali.h();
    }
    this.i = true;
    super.onDetachedFromWindow();
  }
  
  public void setDebugFlags(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void setEGLConfigChooser(TXCGLSurfaceViewBase.e parame)
  {
    g();
    this.j = parame;
  }
  
  public void setEGLConfigChooser(boolean paramBoolean)
  {
    setEGLConfigChooser(new TXCGLSurfaceViewBase.m(this, paramBoolean));
  }
  
  public void setEGLContextClientVersion(int paramInt)
  {
    g();
    this.o = paramInt;
  }
  
  public void setEGLContextFactory(TXCGLSurfaceViewBase.f paramf)
  {
    g();
    this.k = paramf;
  }
  
  public void setEGLWindowSurfaceFactory(TXCGLSurfaceViewBase.g paramg)
  {
    g();
    this.l = paramg;
  }
  
  public void setGLWrapper(TXCGLSurfaceViewBase.k paramk)
  {
    this.m = paramk;
  }
  
  public void setPreserveEGLContextOnPause(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public void setRenderMode(int paramInt)
  {
    this.g.a(paramInt);
  }
  
  public void setRenderer(GLSurfaceView.Renderer paramRenderer)
  {
    g();
    if (this.j == null) {
      this.j = new TXCGLSurfaceViewBase.m(this, true);
    }
    if (this.k == null) {
      this.k = new TXCGLSurfaceViewBase.c(this, null);
    }
    if (this.l == null) {
      this.l = new TXCGLSurfaceViewBase.d(null);
    }
    this.h = paramRenderer;
    this.g = new TXCGLSurfaceViewBase.i(this.d);
    this.g.start();
    TXCLog.i("TXCGLSurfaceViewBase", "setRenderer-->mGLThread.start");
  }
  
  protected void setRunInBackground(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    this.g.a(paramInt2, paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.g.f();
    setRunInBackground(false);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    setRunInBackground(true);
    if (!this.b)
    {
      this.g.a(new TXCGLSurfaceViewBase.1(this));
      this.g.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.renderer.TXCGLSurfaceViewBase
 * JD-Core Version:    0.7.0.1
 */