package com.tencent.map.sdk.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.tencentmap.mapsdk.maps.BaseMapView;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;

public final class mx
  implements gj, mi
{
  lq a;
  pn b;
  Marker c;
  View d;
  int e = 0;
  int f = 0;
  boolean g;
  private float h = 0.5F;
  private float i = 0.5F;
  private GeoPoint j;
  private boolean k = false;
  private DoublePoint l = new DoublePoint();
  
  mx(lq paramlq, Marker paramMarker)
  {
    this.a = paramlq;
    this.b = paramlq.a;
    this.c = paramMarker;
    l();
    if ((this.b == null) || (this.b.ay == null)) {}
    for (;;)
    {
      this.g = true;
      return;
      paramlq = null;
      if (this.a != null) {
        paramlq = this.a.e;
      }
      this.d = mr.a(this.b.ay, this, paramlq, this.c);
      if (this.c != null) {
        a(this.c.getPosition());
      }
    }
  }
  
  private void l()
  {
    if ((this.b == null) || (this.b.az == null)) {
      return;
    }
    this.b.az.a(this);
  }
  
  private void m()
  {
    if ((this.b == null) || (this.b.az == null)) {}
    lw locallw;
    do
    {
      return;
      locallw = this.b.az.b;
    } while (locallw.F.isEmpty());
    locallw.F.remove(this);
  }
  
  public final Rect a(fu paramfu)
  {
    int i2 = 1;
    int m = 0;
    if ((paramfu == null) || (this.d == null)) {
      return null;
    }
    if (this.k) {}
    for (paramfu = this.l; paramfu == null; paramfu = paramfu.a(this.j)) {
      return null;
    }
    int n;
    if ((this.c != null) && (this.c.getOptions() != null))
    {
      n = this.c.getOptions().getInfoWindowOffsetX();
      m = this.c.getOptions().getInfowindowOffsetY();
    }
    for (;;)
    {
      float f2;
      int i1;
      int i4;
      if ((this.c == null) || (this.b.ay == null))
      {
        if ((this.c == null) || (this.b.ay == null))
        {
          f1 = this.h;
          f2 = n * 1.0F / this.e;
          float f3 = this.i;
          float f4 = m * 1.0F / this.f;
          m = (int)(paramfu.x - (f1 - f2) * this.e);
          n = this.e;
          i1 = (int)(paramfu.y - (f3 - f4) * this.f);
          return new Rect(m, i1, n + m, i1 + this.f);
        }
      }
      else
      {
        i4 = this.c.getWidth(this.b.ay);
        if (this.c.getOptions() == null) {
          break label404;
        }
      }
      label404:
      for (float f1 = this.c.getOptions().getInfoWindowAnchorU();; f1 = 0.5F)
      {
        int i3 = this.e;
        i1 = i3;
        if (i3 == 0) {
          i1 = 1;
        }
        f2 = i4;
        this.h = (f1 + (this.c.getAnchorU() - 0.5F) * f2 / i1);
        break;
        i3 = (int)(this.c.getHeight(this.b.ay) * this.c.getAnchorV());
        i1 = this.f;
        if (this.c.getOptions() != null) {}
        for (f1 = this.c.getOptions().getInfoWindowAnchorV();; f1 = 1.0F)
        {
          if (i1 == 0) {
            i1 = i2;
          }
          for (;;)
          {
            this.i = ((i3 + f1 * i1) / i1);
            break;
          }
        }
      }
      n = 0;
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    b(true);
    this.l.set(paramInt1, paramInt2);
    k();
  }
  
  public final void a(LatLng paramLatLng)
  {
    if (paramLatLng == null) {
      return;
    }
    if (this.j == null) {
      this.j = fz.a(paramLatLng);
    }
    for (;;)
    {
      k();
      return;
      this.j.setLatitudeE6((int)(paramLatLng.latitude * 1000000.0D));
      this.j.setLongitudeE6((int)(paramLatLng.longitude * 1000000.0D));
    }
  }
  
  public final void a(MarkerOptions paramMarkerOptions) {}
  
  public final void a(GL10 paramGL10) {}
  
  public final void a(boolean paramBoolean)
  {
    if (this.d == null) {
      return;
    }
    this.g = paramBoolean;
    k();
  }
  
  public final boolean a()
  {
    return false;
  }
  
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    if ((this.d == null) || (!this.g) || (this.b == null) || (this.b.az == null) || (this.b.az.b.h == null)) {}
    Rect localRect;
    do
    {
      return false;
      localRect = a(this.b.az.b.h);
    } while ((localRect == null) || (localRect.isEmpty()));
    return localRect.contains((int)paramFloat1, (int)paramFloat2);
  }
  
  public final void a_()
  {
    k();
  }
  
  public final Rect b(fu paramfu)
  {
    Rect localRect = a(paramfu);
    if ((localRect == null) || (paramfu == null)) {}
    GeoPoint localGeoPoint;
    do
    {
      return null;
      localGeoPoint = paramfu.a(new DoublePoint(localRect.left, localRect.top));
      paramfu = paramfu.a(new DoublePoint(localRect.right, localRect.bottom));
    } while ((localGeoPoint == null) || (paramfu == null));
    return new Rect(localGeoPoint.getLongitudeE6(), localGeoPoint.getLatitudeE6(), paramfu.getLongitudeE6(), paramfu.getLatitudeE6());
  }
  
  public final void b()
  {
    if (this.d == null) {}
    while (!(this.d.getParent() instanceof ViewGroup)) {
      return;
    }
    ((ViewGroup)this.d.getParent()).post(new mx.3(this));
  }
  
  public final void b(boolean paramBoolean)
  {
    this.k = paramBoolean;
    if (paramBoolean)
    {
      m();
      return;
    }
    l();
  }
  
  public final void c()
  {
    m();
    this.d = null;
    this.a = null;
    this.b = null;
    this.c = null;
  }
  
  public final void d() {}
  
  public final boolean e()
  {
    return (this.g) && (this.d != null) && (this.d.getVisibility() == 0);
  }
  
  public final void f()
  {
    if ((this.a != null) && (this.a.c != null)) {
      this.a.c.post(new mx.2(this));
    }
  }
  
  public final View g()
  {
    return this.d;
  }
  
  public final void i()
  {
    if ((this.a == null) || (this.a.c == null)) {
      return;
    }
    this.a.c.post(new mx.4(this));
  }
  
  public final void j()
  {
    if ((this.a == null) || (this.a.c == null)) {
      return;
    }
    this.a.c.post(new mx.5(this));
  }
  
  final void k()
  {
    if ((this.a != null) && (this.a.c != null)) {
      this.a.c.post(new mx.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.mx
 * JD-Core Version:    0.7.0.1
 */