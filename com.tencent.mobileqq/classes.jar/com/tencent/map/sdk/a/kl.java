package com.tencent.map.sdk.a;

import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Handler;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;

public final class kl
  implements he, mc, mj, nw
{
  private static int s = 116307503;
  private static int t = 39984186;
  private final byte[] A = new byte[0];
  private List<gx> B;
  private List<gz> C;
  private WeakReference<lf> D;
  private kd E;
  private Handler F = null;
  private float G = 0.5F;
  private float H = 0.5F;
  private Runnable I;
  public kf a;
  public ie b;
  public List<mm> c;
  public List<gv> d;
  public List<hb> e;
  public List<hd> f;
  public Stack<kc> g = new Stack();
  public lg h;
  public kc i;
  public Rect j;
  public Rect k;
  public kl.a l = null;
  public boolean m = false;
  public int n = 0;
  public int o = 0;
  public int p = 0;
  public int q = 0;
  public boolean r = false;
  private List<gy> u;
  private List<gu> v;
  private final byte[] w = new byte[0];
  private List<ha> x;
  private List<he> y;
  private List<lh> z;
  
  public kl(lg paramlg)
  {
    this.h = paramlg;
    this.D = paramlg.c();
    this.i = paramlg.f();
    this.E = ((kd)paramlg.e());
    this.j = paramlg.h();
    this.a = new kf(this);
    this.a.f = this;
    a(this.a);
    this.b = new ie(paramlg);
    this.e = new CopyOnWriteArrayList();
    this.x = new CopyOnWriteArrayList();
    this.u = new CopyOnWriteArrayList();
    this.v = new CopyOnWriteArrayList();
    this.c = new CopyOnWriteArrayList();
    this.B = new CopyOnWriteArrayList();
    this.C = new CopyOnWriteArrayList();
    this.f = new CopyOnWriteArrayList();
    this.y = new CopyOnWriteArrayList();
    paramlg = fs.a;
    if (c())
    {
      Object localObject = this.j;
      GeoPoint localGeoPoint1 = new GeoPoint(paramlg.top, paramlg.left);
      GeoPoint localGeoPoint2 = new GeoPoint(paramlg.bottom, paramlg.right);
      Rect localRect = new Rect();
      localRect.left = Math.min(localGeoPoint1.getLongitudeE6(), localGeoPoint2.getLongitudeE6());
      localRect.right = Math.max(localGeoPoint1.getLongitudeE6(), localGeoPoint2.getLongitudeE6());
      localRect.top = Math.min(localGeoPoint1.getLatitudeE6(), localGeoPoint2.getLatitudeE6());
      localRect.bottom = Math.max(localGeoPoint1.getLatitudeE6(), localGeoPoint2.getLatitudeE6());
      float f1 = (float)this.h.g().a(localRect, (Rect)localObject);
      this.i.c.set(paramlg);
      paramlg = this.i.b;
      localObject = new kc.a();
      paramlg.c = ((kc.a)localObject).f;
      paramlg.a = (f1 / ((kc.a)localObject).a());
    }
    this.F = new Handler();
  }
  
  private void a(double paramDouble1, double paramDouble2)
  {
    this.h.g().c((float)paramDouble1, (float)paramDouble2);
    n();
    d();
  }
  
  private void d(double paramDouble)
  {
    if (paramDouble == 0.0D) {
      return;
    }
    this.i.a(this.i.p.q() + (float)paramDouble);
    d();
    q();
  }
  
  private void e(double paramDouble)
  {
    a((float)(this.i.b.e * (float)paramDouble));
  }
  
  private void q()
  {
    Iterator localIterator = this.C.iterator();
    while (localIterator.hasNext()) {
      if ((gz)localIterator.next() != null) {}
    }
  }
  
  private void r()
  {
    or.a("skew notifySkew");
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      hd localhd = (hd)localIterator.next();
      if (localhd != null) {
        try
        {
          localhd.a();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  private boolean s()
  {
    return this.i.b.f > this.i.b.c;
  }
  
  private void t()
  {
    Iterator localIterator = this.u.iterator();
    while (localIterator.hasNext()) {
      if ((gy)localIterator.next() != null) {}
    }
    d();
  }
  
  public final void a()
  {
    Iterator localIterator = this.y.iterator();
    while (localIterator.hasNext())
    {
      he localhe = (he)localIterator.next();
      if (localhe != null) {
        try
        {
          localhe.a();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public final void a(double paramDouble)
  {
    if (paramDouble == this.i.p.p()) {
      return;
    }
    this.i.b((float)paramDouble);
    d();
    r();
  }
  
  public final void a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, Runnable paramRunnable)
  {
    this.a.c();
    float f1 = this.h.h().width() / 2.0F;
    float f2 = this.h.h().height() / 2.0F;
    kc.b localb = this.i.r;
    double d2;
    double d1;
    if (this.r) {
      if (localb != null)
      {
        paramDouble3 = f1 + localb.a * f1 * 2.0F;
        paramDouble2 = localb.b * f2 * 2.0F + f2;
        d2 = paramDouble2;
        d1 = paramDouble3;
        paramDouble5 = paramDouble3;
        paramDouble4 = paramDouble2;
      }
    }
    for (;;)
    {
      a(new nv(101, new double[] { paramDouble1, d1, d2, paramDouble5, paramDouble4 }));
      paramRunnable = new nv(paramRunnable);
      paramRunnable.m = false;
      paramRunnable.k = 0L;
      a(paramRunnable);
      return;
      paramDouble3 = f1;
      paramDouble2 = f2;
      break;
      d1 = paramDouble4;
      paramDouble4 = paramDouble5;
      paramDouble5 = d1;
      d1 = paramDouble2;
      d2 = paramDouble3;
    }
  }
  
  public final void a(float paramFloat)
  {
    c(this.i.c(paramFloat));
  }
  
  public final void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    this.i.a(paramFloat1 - 0.5F, paramFloat2 - 0.5F, paramBoolean);
    if (paramBoolean) {
      d();
    }
  }
  
  public final void a(int paramInt)
  {
    if (this.i.b(paramInt)) {
      c(kc.c.c);
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.i.a(paramInt1, paramInt2);
    if (paramInt3 == 1)
    {
      n();
      d();
    }
  }
  
  public final void a(hb paramhb)
  {
    if (paramhb == null) {
      return;
    }
    synchronized (this.e)
    {
      if (!this.e.contains(paramhb)) {
        this.e.add(paramhb);
      }
      return;
    }
  }
  
  public final void a(he paramhe)
  {
    if (paramhe == null) {
      return;
    }
    synchronized (this.y)
    {
      if (!this.y.contains(paramhe)) {
        this.y.add(paramhe);
      }
      return;
    }
  }
  
  public final void a(lh paramlh)
  {
    if (paramlh == null) {
      return;
    }
    if (this.z == null) {
      this.z = new CopyOnWriteArrayList();
    }
    synchronized (this.A)
    {
      if (!this.z.contains(paramlh)) {
        this.z.add(paramlh);
      }
      return;
    }
  }
  
  public final void a(nv paramnv)
  {
    this.a.a(paramnv);
  }
  
  public final void a(Runnable paramRunnable)
  {
    if (!l()) {}
    do
    {
      return;
      float f1 = this.h.h().width() / 2.0F;
      float f2 = this.h.h().height() / 2.0F;
      this.h.g().d(f1, f2);
    } while (paramRunnable == null);
    paramRunnable.run();
  }
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.I != null)
      {
        this.I.run();
        this.I = null;
      }
      d();
    }
  }
  
  public final PointF b()
  {
    int i1 = 0;
    int i2;
    if (this.j != null)
    {
      i2 = this.j.width();
      i1 = this.j.height();
    }
    for (;;)
    {
      int i3 = this.n;
      int i4 = (i2 - i3 - this.p) / 2;
      int i5 = this.o;
      int i6 = (i1 - i5 - this.q) / 2;
      if ((i2 != 0) && (i1 != 0)) {
        return new PointF((i4 + i3) * 1.0F / i2, (i6 + i5) * 1.0F / i1);
      }
      return new PointF(0.5F, 0.5F);
      i2 = 0;
    }
  }
  
  public final void b(double paramDouble)
  {
    double d2 = (paramDouble - this.i.p.q()) % 360.0D;
    double d1;
    if (d2 > 180.0D) {
      d1 = d2 - 360.0D;
    }
    while (d1 == 0.0D)
    {
      return;
      d1 = d2;
      if (d2 < -180.0D) {
        d1 = d2 + 360.0D;
      }
    }
    this.i.a((float)paramDouble);
    d();
    q();
  }
  
  public final void b(int paramInt)
  {
    if (this.i.a(paramInt))
    {
      Iterator localIterator = this.B.iterator();
      while (localIterator.hasNext()) {
        if ((gx)localIterator.next() != null) {}
      }
      d();
    }
  }
  
  public final void b(he paramhe)
  {
    synchronized (this.y)
    {
      this.y.remove(paramhe);
      return;
    }
  }
  
  public final void b(nv paramnv)
  {
    if (paramnv != null) {
      switch (paramnv.i)
      {
      }
    }
    do
    {
      do
      {
        double d1;
        do
        {
          do
          {
            return;
          } while ((this.D == null) || (this.D.get() == null));
          ((lf)this.D.get()).onRedraw();
          return;
          a(paramnv.j[0], paramnv.j[1]);
          return;
          e(paramnv.j[0]);
          return;
          a((float)paramnv.j[0]);
          return;
          int i6 = this.h.h().width();
          int i5 = this.h.h().height();
          int i4 = i6 / 2;
          int i3 = i5 / 2;
          kc.b localb = this.i.r;
          i2 = i3;
          i1 = i4;
          if (localb != null)
          {
            f1 = i4;
            float f2 = localb.a;
            i1 = (int)(f1 + i6 * f2);
            i2 = (int)(i3 + localb.b * i5);
          }
          d1 = i1;
          double d2 = paramnv.j[1];
          double d3 = i2;
          double d4 = paramnv.j[2];
          double d5 = paramnv.j[3];
          double d6 = i1;
          double d7 = paramnv.j[4];
          double d8 = i2;
          a(d1 - d2, d3 - d4);
          e(paramnv.j[0]);
          a(d5 - d6, d7 - d8);
          return;
          d(paramnv.j[0]);
          d1 = paramnv.j[1];
        } while (d1 == 0.0D);
        paramnv = this.i;
        float f1 = this.i.p.p();
        paramnv.b((float)d1 + f1);
        d();
        r();
        return;
        int i1 = this.h.h().width() / 2;
        int i2 = this.h.h().height() / 2;
        a(i1 - paramnv.j[1], i2 - paramnv.j[2]);
        d(paramnv.j[0]);
        a(paramnv.j[3] - i1, paramnv.j[4] - i2);
        return;
        b(paramnv.j[0]);
        return;
        a(paramnv.j[0]);
        return;
        this.i.a(0.0F);
        this.i.b(0.0F);
        q();
        r();
        d();
        return;
        if (paramnv.j.length > 2) {}
        for (i1 = (int)paramnv.j[2];; i1 = 1)
        {
          a((int)paramnv.j[0], (int)paramnv.j[1], i1);
          return;
        }
        a((float)paramnv.j[0]);
        a((int)paramnv.j[1], (int)paramnv.j[2], 1);
        return;
      } while (paramnv.n == null);
      paramnv.n.run();
      return;
    } while (this.l == null);
    this.l.a(paramnv);
  }
  
  public final void b(Runnable paramRunnable)
  {
    if (!s()) {}
    do
    {
      return;
      this.h.g().n();
    } while (paramRunnable == null);
    paramRunnable.run();
  }
  
  public final void c(double paramDouble)
  {
    this.a.c();
    a(new nv(108, new double[] { paramDouble }));
  }
  
  public final void c(int paramInt)
  {
    if (paramInt == kc.c.a) {}
    while (this.F == null) {
      return;
    }
    this.F.post(new kl.3(this, paramInt));
  }
  
  public final boolean c()
  {
    return (this.j != null) && (this.j.width() > 0) && (this.j.height() > 0);
  }
  
  public final void d()
  {
    if (this.z == null) {
      return;
    }
    Iterator localIterator = this.z.iterator();
    while (localIterator.hasNext())
    {
      lh locallh = (lh)localIterator.next();
      if (locallh != null) {
        try
        {
          locallh.a(this.i);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    this.a.b();
  }
  
  public final void e()
  {
    try
    {
      kc localkc1 = (kc)this.g.pop();
      if (localkc1.b.f != this.i.b.f) {
        c(kc.c.c);
      }
      for (;;)
      {
        if (localkc1.p.q() != this.i.p.q())
        {
          localkc1.p.q();
          q();
        }
        if (localkc1.p.p() != this.i.p.p())
        {
          localkc1.p.p();
          r();
        }
        kc localkc2 = this.i;
        localkc2.a = localkc1.a;
        kc.a locala1 = localkc2.b;
        kc.a locala2 = localkc1.b;
        locala1.a = locala2.a;
        locala1.b = locala2.b;
        locala1.c = locala2.c;
        locala1.d = locala2.d;
        locala1.e = locala2.e;
        locala1.f = locala2.f;
        localkc2.c.set(localkc1.c);
        localkc2.d = localkc1.d;
        localkc2.e = localkc1.e;
        localkc2.f = localkc1.f;
        localkc2.g = localkc1.g;
        localkc2.h = localkc1.h;
        localkc2.i = localkc1.i;
        localkc2.j = localkc1.j;
        localkc2.k = localkc1.k;
        localkc2.l = localkc1.l;
        localkc2.m.setGeoPoint(localkc1.m);
        localkc2.q.set(localkc1.q.x, localkc1.q.y);
        localkc2.n = localkc1.n;
        d();
        return;
        if (localkc1.b.e != this.i.b.e) {
          c(kc.c.b);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public final kc f()
  {
    try
    {
      kc localkc = (kc)this.i.clone();
      return localkc;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public final void g()
  {
    GeoPoint localGeoPoint = new GeoPoint(t, s);
    kc localkc = this.i;
    Rect localRect = this.h.h();
    int i1 = localGeoPoint.getLatitudeE6();
    int i2 = localGeoPoint.getLongitudeE6();
    localkc.n = localRect;
    localkc.c = hm.a;
    localkc.b(13);
    localkc.a(0);
    localkc.a(i1, i2);
    d();
    this.h.g().b(this.m);
  }
  
  public final float h()
  {
    return this.i.p.q();
  }
  
  public final float i()
  {
    return this.i.p.p();
  }
  
  public final float j()
  {
    return this.i.b.a();
  }
  
  public final boolean k()
  {
    return (Math.abs(i()) > 1.0E-006D) || (Math.abs(h()) > 1.0F);
  }
  
  public final boolean l()
  {
    return this.i.b.f < this.i.b.d;
  }
  
  public final int m()
  {
    kc localkc = this.i;
    if (localkc.p == null) {
      return localkc.a;
    }
    return localkc.p.r();
  }
  
  public final void n()
  {
    Iterator localIterator = this.v.iterator();
    while (localIterator.hasNext()) {
      if ((gu)localIterator.next() != null) {}
    }
    t();
  }
  
  public final void o()
  {
    Iterator localIterator = this.x.iterator();
    while (localIterator.hasNext()) {
      if ((ha)localIterator.next() != null) {}
    }
  }
  
  public final Rect p()
  {
    Object localObject = new DoublePoint(this.h.h().width(), this.h.h().height());
    GeoPoint localGeoPoint = this.E.a((DoublePoint)localObject);
    ((DoublePoint)localObject).set(0.0D, 0.0D);
    localObject = this.E.a((DoublePoint)localObject);
    return new Rect(Math.min(((GeoPoint)localObject).getLongitudeE6(), localGeoPoint.getLongitudeE6()), Math.min(((GeoPoint)localObject).getLatitudeE6(), localGeoPoint.getLatitudeE6()), Math.max(((GeoPoint)localObject).getLongitudeE6(), localGeoPoint.getLongitudeE6()), Math.max(((GeoPoint)localObject).getLatitudeE6(), localGeoPoint.getLatitudeE6()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.kl
 * JD-Core Version:    0.7.0.1
 */