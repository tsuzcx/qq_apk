package com.tencent.map.sdk.a;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;

public final class ie
  implements gr
{
  boolean a;
  public ih b;
  public WeakReference<lf> c;
  private final long d = 250L;
  private final long e = 1200L;
  private float f = ViewConfiguration.getMinimumFlingVelocity();
  private float g = ViewConfiguration.getMaximumFlingVelocity();
  private lg h;
  private float i;
  private float j;
  private boolean k = false;
  private final float l;
  
  public ie(lg paramlg)
  {
    this.h = paramlg;
    this.c = paramlg.c();
    if ((this.c != null) && (this.c.get() != null))
    {
      ((lf)this.c.get()).a(this);
      Object localObject = ((lf)this.c.get()).b();
      if (localObject != null)
      {
        localObject = ViewConfiguration.get((Context)localObject);
        this.f = ((ViewConfiguration)localObject).getScaledMinimumFlingVelocity();
        this.g = ((ViewConfiguration)localObject).getScaledMaximumFlingVelocity();
      }
    }
    this.b = new ih();
    this.l = (paramlg.i() * 2.5F);
  }
  
  public final void a() {}
  
  public final boolean a(float paramFloat)
  {
    if (this.b.d())
    {
      double d1 = paramFloat / 8.0F * 2.0F;
      kl localkl = this.h.b();
      localkl.a.c();
      localkl.a(new nv(102, new double[] { 0.0D, d1 }));
      return true;
    }
    return false;
  }
  
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    kl localkl;
    ie.1 local1;
    if (this.b.f())
    {
      localkl = this.h.b();
      local1 = new ie.1(this, localkl);
      if (localkl.r)
      {
        kc.b localb = localkl.i.r;
        if (localb == null) {
          break label128;
        }
        paramFloat1 = localkl.h.h().width() * (localb.a + 0.5F);
        paramFloat2 = localkl.h.h().height() * (localb.b + 0.5F);
      }
      if (localkl.l())
      {
        localkl.h.g().d(paramFloat1, paramFloat2);
        local1.run();
      }
    }
    for (;;)
    {
      return false;
      label128:
      localkl.a(local1);
    }
  }
  
  public final boolean a(PointF paramPointF1, PointF paramPointF2, double paramDouble1, double paramDouble2)
  {
    if (this.b.i())
    {
      paramDouble1 = paramDouble2 / paramDouble1;
      kl localkl = this.h.b();
      localkl.a(paramDouble1, paramPointF1.x, paramPointF1.y, paramPointF2.x, paramPointF2.y, new ie.3(this, localkl));
    }
    return false;
  }
  
  public final boolean a(PointF paramPointF1, PointF paramPointF2, float paramFloat)
  {
    if (this.b.e())
    {
      kl localkl = this.h.b();
      double d1 = paramFloat;
      double d2 = paramPointF1.x;
      double d3 = paramPointF1.y;
      double d4 = paramPointF2.x;
      double d5 = paramPointF2.y;
      localkl.a.c();
      localkl.a(new nv(103, new double[] { d1, d2, d3, d4, d5 }));
    }
    return false;
  }
  
  public final boolean b()
  {
    
    if (this.b.h())
    {
      kl localkl = this.h.b();
      localkl.b(new ie.2(this, localkl));
    }
    return false;
  }
  
  public final boolean b(float paramFloat1, float paramFloat2)
  {
    if (this.b.g()) {
      return this.h.d().a(paramFloat1, paramFloat2);
    }
    return false;
  }
  
  public final boolean c()
  {
    if (this.a)
    {
      this.h.b().a.c();
      this.a = false;
    }
    return false;
  }
  
  public final boolean c(float paramFloat1, float paramFloat2)
  {
    if ((this.b.b()) && (this.b.c()))
    {
      this.k = true;
      if (!this.a)
      {
        float f1 = paramFloat1 / 64.0F;
        float f2 = paramFloat2 / 64.0F;
        if ((Math.abs(f1) >= this.l) || (Math.abs(f2) >= this.l))
        {
          long l1 = ((Math.max(Math.abs(paramFloat1), Math.abs(paramFloat2)) - this.f) / (this.g - this.f) * 950.0F);
          Object localObject = new PointF(f1, f2);
          long l2 = System.currentTimeMillis();
          this.a = true;
          localObject = new ie.4(this, new double[] { 0.0D, 0.0D }, l2, l1 + 250L, (PointF)localObject);
          kl localkl = this.h.b();
          localkl.a.c();
          localkl.a((nv)localObject);
        }
      }
    }
    return false;
  }
  
  public final boolean d()
  {
    return false;
  }
  
  public final boolean d(float paramFloat1, float paramFloat2)
  {
    if (this.b.b())
    {
      kl localkl = this.h.b();
      if (localkl.h != null)
      {
        pf localpf = localkl.h.g();
        if (localpf != null)
        {
          localpf.c(paramFloat1, paramFloat2);
          localkl.d();
        }
      }
    }
    return false;
  }
  
  public final boolean e(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final boolean f(float paramFloat1, float paramFloat2)
  {
    if (this.b.f())
    {
      this.i = this.h.b().i.b.e;
      this.j = paramFloat2;
    }
    return false;
  }
  
  public final boolean g(float paramFloat1, float paramFloat2)
  {
    
    if (this.b.f()) {
      this.h.b().c(Math.pow(2.0D, 10.0F * (this.j - paramFloat2) / this.h.h().height()) * this.i);
    }
    return true;
  }
  
  public final boolean h(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final boolean i(float paramFloat1, float paramFloat2)
  {
    this.h.b().a.c();
    return false;
  }
  
  public final boolean j(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final boolean k(float paramFloat1, float paramFloat2)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.ie
 * JD-Core Version:    0.7.0.1
 */