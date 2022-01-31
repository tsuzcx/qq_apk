package com.tencent.map.sdk.a;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ZoomControls;
import com.tencent.map.sdk.basemap.interfaces.IMapRenderView;
import com.tencent.tencentmap.mapsdk.maps.BaseMapView;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class lu
  implements gw, hc, ld
{
  public BaseMapView a = null;
  public pn b;
  public js c;
  public jr d;
  hu e;
  public hv.a f;
  List<gh> g = new ArrayList();
  public Handler h = new lu.1(this, Looper.getMainLooper());
  private TencentMapOptions i;
  private ij j;
  private int k;
  private boolean l = false;
  
  public lu(BaseMapView paramBaseMapView, IMapRenderView paramIMapRenderView)
  {
    this.a = paramBaseMapView;
    if (paramIMapRenderView == null) {
      return;
    }
    this.b = ((pn)paramIMapRenderView.getVectorMapDelegate());
    this.i = this.b.aG;
    if ((paramIMapRenderView instanceof View))
    {
      paramBaseMapView = (View)paramIMapRenderView;
      if (this.a.indexOfChild(paramBaseMapView) < 0)
      {
        paramIMapRenderView = new FrameLayout.LayoutParams(-1, -1);
        this.a.addView(paramBaseMapView, 0, paramIMapRenderView);
        this.a.requestLayout();
      }
    }
    int n = 4;
    int m = 20;
    if (this.b.az != null)
    {
      n = this.b.az.d;
      m = this.b.az.c;
    }
    this.d = new jr(this.a.getContext().getApplicationContext(), n, m);
    paramBaseMapView = this.b;
    paramIMapRenderView = this.d;
    paramBaseMapView.m = paramIMapRenderView;
    paramBaseMapView.a(new pn.2(paramBaseMapView, paramIMapRenderView));
    this.j = new ij(this.a);
    this.b.n = this.j;
    this.c = new js(this.a.getContext(), this.b);
    this.g.add(this.d);
    this.g.add(this.c);
    this.b.r = this;
    this.b.a(this);
  }
  
  public final void a(float paramFloat)
  {
    float f2 = 1.3F;
    float f1 = 0.7F;
    jr localjr;
    if (this.d != null)
    {
      localjr = this.d;
      if (paramFloat <= 1.3F) {
        break label58;
      }
      paramFloat = f2;
    }
    label58:
    for (;;)
    {
      if (paramFloat < 0.7F) {
        paramFloat = f1;
      }
      for (;;)
      {
        localjr.g = 0;
        localjr.p = paramFloat;
        localjr.e();
        return;
      }
    }
  }
  
  public final void a(int paramInt)
  {
    if (this.d != null)
    {
      this.d.a(gh.b.a(paramInt));
      j();
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.k = paramInt2;
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
    {
      gh localgh = (gh)localIterator.next();
      localgh.a(paramInt1, paramInt2);
      localgh.a(this.a);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.d != null)
    {
      this.d.a(gh.b.a(paramInt1));
      this.d.a(gh.a.d, paramInt2);
      this.d.a(gh.a.c, paramInt3);
      this.d.a(gh.a.a, paramInt4);
      this.d.a(gh.a.b, paramInt5);
      this.d.e();
      j();
    }
  }
  
  public final void a(int paramInt, int[] paramArrayOfInt)
  {
    if (this.d != null)
    {
      gh.b localb = gh.b.a(paramInt);
      this.d.a(localb);
      switch (lu.2.a[localb.ordinal()])
      {
      }
    }
    for (;;)
    {
      this.d.e();
      j();
      return;
      this.d.a(gh.a.d, paramArrayOfInt[0]);
      this.d.a(gh.a.a, paramArrayOfInt[1]);
      continue;
      this.d.a(gh.a.c, paramArrayOfInt[0]);
      this.d.a(gh.a.a, paramArrayOfInt[1]);
      continue;
      this.d.a(gh.a.c, paramArrayOfInt[0]);
      this.d.a(gh.a.b, paramArrayOfInt[1]);
      continue;
      this.d.a(gh.a.d, paramArrayOfInt[0]);
      this.d.a(gh.a.b, paramArrayOfInt[1]);
    }
  }
  
  public final void a(hj paramhj)
  {
    if (paramhj.a != -1)
    {
      paramhj = this.h.obtainMessage(paramhj.a, paramhj);
      this.h.sendMessage(paramhj);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    Object localObject = this.c;
    if (((js)localObject).a != null)
    {
      localObject = ((js)localObject).a;
      if (!paramBoolean) {
        break label29;
      }
    }
    label29:
    for (int m = 0;; m = 4)
    {
      ((ZoomControls)localObject).setVisibility(m);
      return;
    }
  }
  
  public final boolean a()
  {
    js localjs = this.c;
    return (localjs.a != null) && (localjs.a.getVisibility() == 0);
  }
  
  public final void b(int paramInt)
  {
    if (this.d != null)
    {
      this.d.b(gh.b.a(paramInt));
      j();
    }
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    if (this.b != null) {
      this.b.b(paramInt1, paramInt2);
    }
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.d != null)
    {
      this.d.b(gh.b.a(paramInt1));
      this.d.b(gh.a.d, paramInt2);
      this.d.b(gh.a.c, paramInt3);
      this.d.b(gh.a.a, paramInt4);
      this.d.b(gh.a.b, paramInt5);
      this.d.f();
      j();
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    pn localpn = this.b;
    localpn.S = paramBoolean;
    kl localkl = localpn.az.b.c;
    localkl.m = paramBoolean;
    localkl.h.g().b(localkl.m);
    localpn.az.b.k();
  }
  
  public final boolean b()
  {
    return this.b.S;
  }
  
  public final void c(int paramInt)
  {
    if (this.b != null)
    {
      pn localpn = this.b;
      localpn.U = paramInt;
      localpn.b(localpn.T, paramInt);
      localpn.s();
    }
  }
  
  public final void c(boolean paramBoolean)
  {
    this.l = paramBoolean;
    jt localjt = this.c.b;
    if (paramBoolean) {}
    for (int m = 0;; m = 8)
    {
      localjt.setVisibility(m);
      return;
    }
  }
  
  public final boolean c()
  {
    return this.l;
  }
  
  public final void d(int paramInt)
  {
    if (this.d != null)
    {
      jr localjr = this.d;
      localjr.g = paramInt;
      localjr.p = 1.4E-45F;
      localjr.e();
    }
  }
  
  public final void d(boolean paramBoolean)
  {
    this.b.a(paramBoolean);
  }
  
  public final boolean d()
  {
    return this.b.i();
  }
  
  public final void e(int paramInt)
  {
    if (this.c != null)
    {
      js localjs = this.c;
      gh.b localb = gh.b.a(paramInt);
      if (localjs.d != localb)
      {
        localjs.d = localb;
        localjs.a(localjs.c);
      }
    }
  }
  
  public final void e(boolean paramBoolean)
  {
    this.b.b(paramBoolean);
  }
  
  public final boolean e()
  {
    return this.b.j();
  }
  
  public final void f(boolean paramBoolean)
  {
    this.b.c(paramBoolean);
  }
  
  public final boolean f()
  {
    return this.b.k();
  }
  
  public final void g(boolean paramBoolean)
  {
    this.b.d(paramBoolean);
  }
  
  public final boolean g()
  {
    return this.b.l();
  }
  
  public final void h(boolean paramBoolean)
  {
    this.b.e(paramBoolean);
  }
  
  public final boolean h()
  {
    if (this.j != null) {
      return this.j.b;
    }
    return false;
  }
  
  public final void i(boolean paramBoolean)
  {
    this.b.f(paramBoolean);
    d(paramBoolean);
    f(paramBoolean);
    g(paramBoolean);
    h(paramBoolean);
  }
  
  public final boolean i()
  {
    if (this.d != null) {
      return this.d.n;
    }
    return false;
  }
  
  protected final void j()
  {
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext()) {
      ((gh)localIterator.next()).a(this.a);
    }
  }
  
  public final void j(boolean paramBoolean)
  {
    if (this.d != null)
    {
      jr localjr = this.d;
      localjr.n = paramBoolean;
      if ((localjr.m != null) && (!paramBoolean)) {
        localjr.o.setVisibility(8);
      }
      if (localjr.r != null)
      {
        Iterator localIterator = localjr.r.iterator();
        while (localIterator.hasNext()) {
          ((gs)localIterator.next()).b(localjr.o, new Rect(localjr.s, localjr.t, 0, 0), localjr.n);
        }
      }
    }
  }
  
  public final void k(boolean paramBoolean)
  {
    Object localObject;
    if (this.d != null)
    {
      localObject = this.d;
      ((jr)localObject).c = paramBoolean;
      if (((jr)localObject).b != null)
      {
        localObject = ((jr)localObject).b;
        if (!paramBoolean) {
          break label41;
        }
      }
    }
    label41:
    for (int m = 0;; m = 4)
    {
      ((ImageView)localObject).setVisibility(m);
      return;
    }
  }
  
  public final void l(boolean paramBoolean)
  {
    Object localObject;
    if (this.d != null)
    {
      localObject = this.d;
      if (((jr)localObject).m != null)
      {
        localObject = ((jr)localObject).o;
        if (!paramBoolean) {
          break label36;
        }
      }
    }
    label36:
    for (int m = 0;; m = 8)
    {
      ((LinearLayout)localObject).setVisibility(m);
      return;
    }
  }
  
  public final void m(boolean paramBoolean)
  {
    if ((this.b != null) && (this.b.az != null))
    {
      Object localObject = this.b.az;
      if (((pm)localObject).b != null)
      {
        localObject = ((pm)localObject).b;
        if (((lw)localObject).c != null) {
          ((lw)localObject).c.r = paramBoolean;
        }
      }
    }
  }
  
  public final void n(boolean paramBoolean)
  {
    ij localij = this.j;
    if ((localij.a == null) || (localij.a.getMap() == null)) {
      return;
    }
    if (paramBoolean) {}
    for (localij.b = true;; localij.b = false)
    {
      localij.a(localij.b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.lu
 * JD-Core Version:    0.7.0.1
 */