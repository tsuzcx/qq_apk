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
    int m = 4;
    int n = 20;
    if (this.b.az != null)
    {
      m = this.b.az.d;
      n = this.b.az.c;
    }
    this.d = new jr(this.a.getContext().getApplicationContext(), m, n);
    paramBaseMapView = this.b;
    paramIMapRenderView = this.d;
    paramBaseMapView.m = paramIMapRenderView;
    paramBaseMapView.a(new pn.2(paramBaseMapView, paramIMapRenderView));
    this.j = new ij(this.a);
    this.b.n = this.j;
    this.c = new js(this.a.getContext(), this.b);
    this.g.add(this.d);
    this.g.add(this.c);
    paramBaseMapView = this.b;
    paramBaseMapView.r = this;
    paramBaseMapView.a(this);
  }
  
  public final void a(float paramFloat)
  {
    jr localjr = this.d;
    if (localjr != null)
    {
      float f1 = paramFloat;
      if (paramFloat > 1.3F) {
        f1 = 1.3F;
      }
      paramFloat = f1;
      if (f1 < 0.7F) {
        paramFloat = 0.7F;
      }
      localjr.g = 0;
      localjr.p = paramFloat;
      localjr.e();
    }
  }
  
  public final void a(int paramInt)
  {
    jr localjr = this.d;
    if (localjr != null)
    {
      localjr.a(gh.b.a(paramInt));
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
    jr localjr = this.d;
    if (localjr != null)
    {
      localjr.a(gh.b.a(paramInt1));
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
      paramInt = lu.2.a[localb.ordinal()];
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt == 4)
            {
              this.d.a(gh.a.d, paramArrayOfInt[0]);
              this.d.a(gh.a.b, paramArrayOfInt[1]);
            }
          }
          else
          {
            this.d.a(gh.a.c, paramArrayOfInt[0]);
            this.d.a(gh.a.b, paramArrayOfInt[1]);
          }
        }
        else
        {
          this.d.a(gh.a.c, paramArrayOfInt[0]);
          this.d.a(gh.a.a, paramArrayOfInt[1]);
        }
      }
      else
      {
        this.d.a(gh.a.d, paramArrayOfInt[0]);
        this.d.a(gh.a.a, paramArrayOfInt[1]);
      }
      this.d.e();
      j();
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
      int m;
      if (paramBoolean) {
        m = 0;
      } else {
        m = 4;
      }
      ((ZoomControls)localObject).setVisibility(m);
    }
  }
  
  public final boolean a()
  {
    js localjs = this.c;
    return (localjs.a != null) && (localjs.a.getVisibility() == 0);
  }
  
  public final void b(int paramInt)
  {
    jr localjr = this.d;
    if (localjr != null)
    {
      localjr.b(gh.b.a(paramInt));
      j();
    }
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    pn localpn = this.b;
    if (localpn != null) {
      localpn.b(paramInt1, paramInt2);
    }
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    jr localjr = this.d;
    if (localjr != null)
    {
      localjr.b(gh.b.a(paramInt1));
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
    pn localpn = this.b;
    if (localpn != null)
    {
      localpn.U = paramInt;
      localpn.b(localpn.T, paramInt);
      localpn.s();
    }
  }
  
  public final void c(boolean paramBoolean)
  {
    this.l = paramBoolean;
    jt localjt = this.c.b;
    int m;
    if (paramBoolean) {
      m = 0;
    } else {
      m = 8;
    }
    localjt.setVisibility(m);
  }
  
  public final boolean c()
  {
    return this.l;
  }
  
  public final void d(int paramInt)
  {
    jr localjr = this.d;
    if (localjr != null)
    {
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
    js localjs = this.c;
    if (localjs != null)
    {
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
    ij localij = this.j;
    if (localij != null) {
      return localij.b;
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
    jr localjr = this.d;
    if (localjr != null) {
      return localjr.n;
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
    jr localjr = this.d;
    if (localjr != null)
    {
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
    Object localObject = this.d;
    if (localObject != null)
    {
      ((jr)localObject).c = paramBoolean;
      if (((jr)localObject).b != null)
      {
        localObject = ((jr)localObject).b;
        int m;
        if (paramBoolean) {
          m = 0;
        } else {
          m = 4;
        }
        ((ImageView)localObject).setVisibility(m);
      }
    }
  }
  
  public final void l(boolean paramBoolean)
  {
    Object localObject = this.d;
    if ((localObject != null) && (((jr)localObject).m != null))
    {
      localObject = ((jr)localObject).o;
      int m;
      if (paramBoolean) {
        m = 0;
      } else {
        m = 8;
      }
      ((LinearLayout)localObject).setVisibility(m);
    }
  }
  
  public final void m(boolean paramBoolean)
  {
    Object localObject = this.b;
    if ((localObject != null) && (((pt)localObject).az != null))
    {
      localObject = this.b.az;
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
    if (localij.a != null)
    {
      if (localij.a.getMap() == null) {
        return;
      }
      if (paramBoolean) {
        localij.b = true;
      } else {
        localij.b = false;
      }
      localij.a(localij.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.lu
 * JD-Core Version:    0.7.0.1
 */