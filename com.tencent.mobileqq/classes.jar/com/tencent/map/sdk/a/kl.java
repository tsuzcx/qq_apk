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
    Object localObject = this.a;
    ((kf)localObject).f = this;
    a((lh)localObject);
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
      localObject = this.j;
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
    kc localkc = this.i;
    localkc.a(localkc.p.q() + (float)paramDouble);
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
      gz localgz = (gz)localIterator.next();
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
      gy localgy = (gy)localIterator.next();
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
    double d1;
    if (this.r)
    {
      if (localb != null)
      {
        paramDouble2 = f1 + localb.a * f1 * 2.0F;
        paramDouble3 = f2 + localb.b * f2 * 2.0F;
      }
      else
      {
        paramDouble2 = f1;
        paramDouble3 = f2;
      }
      paramDouble4 = paramDouble3;
      paramDouble5 = paramDouble2;
      d1 = paramDouble4;
    }
    else
    {
      d1 = paramDouble5;
      paramDouble5 = paramDouble4;
    }
    a(new nv(101, new double[] { paramDouble1, paramDouble2, paramDouble3, paramDouble5, d1 }));
    paramRunnable = new nv(paramRunnable);
    paramRunnable.m = false;
    paramRunnable.k = 0L;
    a(paramRunnable);
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
    if (!l()) {
      return;
    }
    float f1 = this.h.h().width() / 2.0F;
    float f2 = this.h.h().height() / 2.0F;
    this.h.g().d(f1, f2);
    if (paramRunnable != null) {
      paramRunnable.run();
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Runnable localRunnable = this.I;
      if (localRunnable != null)
      {
        localRunnable.run();
        this.I = null;
      }
      d();
    }
  }
  
  public final PointF b()
  {
    Rect localRect = this.j;
    int i2 = 0;
    int i1;
    if (localRect != null)
    {
      i2 = localRect.width();
      i1 = this.j.height();
    }
    else
    {
      i1 = 0;
    }
    int i3 = this.n;
    int i4 = (i2 - i3 - this.p) / 2;
    int i5 = this.o;
    int i6 = (i1 - i5 - this.q) / 2;
    if ((i2 != 0) && (i1 != 0)) {
      return new PointF((i3 + i4) * 1.0F / i2, (i5 + i6) * 1.0F / i1);
    }
    return new PointF(0.5F, 0.5F);
  }
  
  public final void b(double paramDouble)
  {
    double d1 = this.i.p.q();
    Double.isNaN(d1);
    double d2 = (paramDouble - d1) % 360.0D;
    if (d2 > 180.0D)
    {
      d1 = d2 - 360.0D;
    }
    else
    {
      d1 = d2;
      if (d2 < -180.0D) {
        d1 = d2 + 360.0D;
      }
    }
    if (d1 == 0.0D) {
      return;
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
        gx localgx = (gx)localIterator.next();
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
    if (paramnv != null)
    {
      int i1 = paramnv.i;
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4)
          {
            if (i1 != 6)
            {
              if (i1 != 120)
              {
                if (i1 != 10000)
                {
                  int i2;
                  double d1;
                  double d3;
                  double d2;
                  double d4;
                  switch (i1)
                  {
                  default: 
                    switch (i1)
                    {
                    default: 
                      return;
                    case 110: 
                      a(paramnv.j[0]);
                      return;
                    case 109: 
                      b(paramnv.j[0]);
                      return;
                    }
                    a((float)paramnv.j[0]);
                    return;
                  case 104: 
                    this.i.a(0.0F);
                    this.i.b(0.0F);
                    q();
                    r();
                    d();
                    return;
                  case 103: 
                    i1 = this.h.h().width() / 2;
                    i2 = this.h.h().height() / 2;
                    d1 = i1;
                    d3 = paramnv.j[1];
                    Double.isNaN(d1);
                    d2 = i2;
                    d4 = paramnv.j[2];
                    Double.isNaN(d2);
                    a(d1 - d3, d2 - d4);
                    d(paramnv.j[0]);
                    d3 = paramnv.j[3];
                    Double.isNaN(d1);
                    d4 = paramnv.j[4];
                    Double.isNaN(d2);
                    a(d3 - d1, d4 - d2);
                    return;
                  case 102: 
                    d(paramnv.j[0]);
                    d1 = paramnv.j[1];
                    if (d1 != 0.0D)
                    {
                      paramnv = this.i;
                      paramnv.b(paramnv.p.p() + (float)d1);
                      d();
                      r();
                    }
                    return;
                  case 101: 
                    int i6 = this.h.h().width();
                    int i5 = this.h.h().height();
                    int i4 = i6 / 2;
                    int i3 = i5 / 2;
                    localObject = this.i.r;
                    i2 = i4;
                    i1 = i3;
                    if (localObject != null)
                    {
                      i2 = (int)(i4 + ((kc.b)localObject).a * i6);
                      i1 = (int)(i3 + ((kc.b)localObject).b * i5);
                    }
                    d1 = i2;
                    d2 = paramnv.j[1];
                    Double.isNaN(d1);
                    d3 = i1;
                    d4 = paramnv.j[2];
                    Double.isNaN(d3);
                    double d5 = paramnv.j[3];
                    Double.isNaN(d1);
                    double d6 = paramnv.j[4];
                    Double.isNaN(d3);
                    a(d1 - d2, d3 - d4);
                    e(paramnv.j[0]);
                    a(d5 - d1, d6 - d3);
                    return;
                  }
                  e(paramnv.j[0]);
                  return;
                }
                Object localObject = this.l;
                if (localObject != null) {
                  ((kl.a)localObject).a(paramnv);
                }
              }
              else
              {
                a((float)paramnv.j[0]);
                a((int)paramnv.j[1], (int)paramnv.j[2], 1);
              }
            }
            else if (paramnv.n != null) {
              paramnv.n.run();
            }
          }
          else
          {
            if (paramnv.j.length > 2) {
              i1 = (int)paramnv.j[2];
            } else {
              i1 = 1;
            }
            a((int)paramnv.j[0], (int)paramnv.j[1], i1);
          }
        }
        else {
          a(paramnv.j[0], paramnv.j[1]);
        }
      }
      else
      {
        paramnv = this.D;
        if ((paramnv != null) && (paramnv.get() != null)) {
          ((lf)this.D.get()).onRedraw();
        }
      }
    }
  }
  
  public final void b(Runnable paramRunnable)
  {
    if (!s()) {
      return;
    }
    this.h.g().n();
    if (paramRunnable != null) {
      paramRunnable.run();
    }
  }
  
  public final void c(double paramDouble)
  {
    this.a.c();
    a(new nv(108, new double[] { paramDouble }));
  }
  
  public final void c(int paramInt)
  {
    if (paramInt == kc.c.a) {
      return;
    }
    Handler localHandler = this.F;
    if (localHandler != null) {
      localHandler.post(new kl.3(this, paramInt));
    }
  }
  
  public final boolean c()
  {
    Rect localRect = this.j;
    return (localRect != null) && (localRect.width() > 0) && (this.j.height() > 0);
  }
  
  public final void d()
  {
    Object localObject = this.z;
    if (localObject == null) {
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      lh locallh = (lh)((Iterator)localObject).next();
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
      } else if (localkc1.b.e != this.i.b.e) {
        c(kc.c.b);
      }
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
      gu localgu = (gu)localIterator.next();
    }
    t();
  }
  
  public final void o()
  {
    Iterator localIterator = this.x.iterator();
    while (localIterator.hasNext()) {
      ha localha = (ha)localIterator.next();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.kl
 * JD-Core Version:    0.7.0.1
 */