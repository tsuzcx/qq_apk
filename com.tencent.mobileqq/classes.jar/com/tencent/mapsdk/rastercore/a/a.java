package com.tencent.mapsdk.rastercore.a;

import android.os.Handler;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import com.tencent.mapsdk.rastercore.d.b;
import com.tencent.mapsdk.rastercore.d.f;
import com.tencent.mapsdk.rastercore.d.g;
import com.tencent.tencentmap.mapsdk.map.CancelableCallback;

public abstract class a
{
  protected f a;
  protected b b;
  protected CancelableCallback c;
  private a d = a.c;
  private Handler e = new Handler();
  private Scroller f;
  private long g;
  private float h = 0.0F;
  private boolean i = false;
  private double j = 0.0D;
  private Runnable k = new Runnable()
  {
    public final void run()
    {
      if (a.a(a.this).computeScrollOffset())
      {
        float f1 = a.a(a.this).getCurrX() * 1.0F / 10000.0F;
        float f2 = f1 - a.b(a.this);
        a.a(a.this, a.c(a.this) + f2);
        if (a.c(a.this) < 1.0D) {
          a.this.a(f2);
        }
        a.a(a.this, f1);
        if (a.d(a.this)) {
          a.f(a.this).postDelayed(a.e(a.this), 5L);
        }
        a.this.a.h().a(false);
        return;
      }
      a.this.d();
      if (a.this.c != null) {
        a.this.c.onFinish();
      }
      a.a(a.this, false);
      a.this.a.h().a(true);
    }
  };
  
  public a(f paramf, long paramLong, CancelableCallback paramCancelableCallback)
  {
    this.a = paramf;
    this.b = paramf.c();
    this.g = paramLong;
    this.c = paramCancelableCallback;
  }
  
  public final void a()
  {
    switch (2.a[this.d.ordinal()])
    {
    default: 
      this.f = new Scroller(f.a());
    }
    for (;;)
    {
      c();
      this.i = true;
      this.f.startScroll(0, 0, 10000, 0, (int)this.g);
      this.e.postDelayed(this.k, 5L);
      this.a.a(false, false);
      return;
      this.f = new Scroller(f.a(), new AccelerateInterpolator());
      continue;
      this.f = new Scroller(f.a(), new DecelerateInterpolator());
      continue;
      this.f = new Scroller(f.a(), new AccelerateDecelerateInterpolator());
    }
  }
  
  protected abstract void a(float paramFloat);
  
  public final void a(a parama)
  {
    this.d = parama;
  }
  
  public final void b()
  {
    if (this.i)
    {
      this.i = false;
      if (this.c != null) {
        this.c.onCancel();
      }
      this.a.h().a(true);
    }
  }
  
  protected abstract void c();
  
  protected abstract void d();
  
  public static enum a
  {
    private a() {}
    
    public static a[] a()
    {
      return (a[])d.clone();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.a.a
 * JD-Core Version:    0.7.0.1
 */