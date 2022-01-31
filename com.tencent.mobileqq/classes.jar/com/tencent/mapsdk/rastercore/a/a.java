package com.tencent.mapsdk.rastercore.a;

import android.os.Handler;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import com.tencent.mapsdk.rastercore.d.b;
import com.tencent.mapsdk.rastercore.d.e;
import com.tencent.mapsdk.rastercore.d.f;
import com.tencent.tencentmap.mapsdk.map.CancelableCallback;

public abstract class a
{
  protected e a;
  protected b b;
  protected CancelableCallback c;
  private a d = a.c;
  private Handler e = new Handler();
  private Scroller f;
  private long g;
  private float h = 0.0F;
  private boolean i = false;
  private Runnable j = new Runnable()
  {
    public final void run()
    {
      if (a.a(a.this).computeScrollOffset())
      {
        float f = a.a(a.this).getCurrX() * 1.0F / 10000.0F;
        a.this.a(f - a.b(a.this));
        a.a(a.this, f);
        if (a.c(a.this)) {
          a.e(a.this).postDelayed(a.d(a.this), 5L);
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
  
  public a(e parame, long paramLong, CancelableCallback paramCancelableCallback)
  {
    this.a = parame;
    this.b = parame.c();
    this.g = paramLong;
    this.c = paramCancelableCallback;
  }
  
  public final void a()
  {
    switch (2.a[this.d.ordinal()])
    {
    default: 
      this.f = new Scroller(e.a());
    }
    for (;;)
    {
      c();
      this.i = true;
      this.f.startScroll(0, 0, 10000, 0, (int)this.g);
      this.e.postDelayed(this.j, 5L);
      this.a.a(false, false);
      return;
      this.f = new Scroller(e.a(), new AccelerateInterpolator());
      continue;
      this.f = new Scroller(e.a(), new DecelerateInterpolator());
      continue;
      this.f = new Scroller(e.a(), new AccelerateDecelerateInterpolator());
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