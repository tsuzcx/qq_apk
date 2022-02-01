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
    Object localObject = this.c;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      ((lf)this.c.get()).a(this);
      localObject = ((lf)this.c.get()).b();
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
    boolean bool2 = this.b.d();
    boolean bool1 = false;
    if (bool2)
    {
      double d1 = paramFloat / 8.0F * 2.0F;
      kl localkl = this.h.b();
      localkl.a.c();
      bool1 = true;
      localkl.a(new nv(102, new double[] { 0.0D, d1 }));
    }
    return bool1;
  }
  
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    if (this.b.f())
    {
      kl localkl = this.h.b();
      ie.1 local1 = new ie.1(this, localkl);
      if (localkl.r)
      {
        kc.b localb = localkl.i.r;
        if (localb != null)
        {
          paramFloat1 = localkl.h.h().width();
          float f1 = localb.a;
          paramFloat2 = localkl.h.h().height();
          paramFloat2 = (localb.b + 0.5F) * paramFloat2;
          paramFloat1 *= (f1 + 0.5F);
        }
        else
        {
          localkl.a(local1);
          break label153;
        }
      }
      if (localkl.l())
      {
        localkl.h.g().d(paramFloat1, paramFloat2);
        local1.run();
      }
    }
    label153:
    return false;
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
          paramFloat1 = Math.max(Math.abs(paramFloat1), Math.abs(paramFloat2));
          paramFloat2 = this.f;
          long l1 = ((paramFloat1 - paramFloat2) / (this.g - paramFloat2) * 950.0F);
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
    
    if (this.b.f())
    {
      kl localkl = this.h.b();
      double d1 = Math.pow(2.0D, (this.j - paramFloat2) * 10.0F / this.h.h().height());
      double d2 = this.i;
      Double.isNaN(d2);
      localkl.c(d1 * d2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.ie
 * JD-Core Version:    0.7.0.1
 */