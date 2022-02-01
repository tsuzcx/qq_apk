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
    paramlq = this.b;
    if ((paramlq != null) && (paramlq.ay != null))
    {
      paramlq = null;
      paramMarker = this.a;
      if (paramMarker != null) {
        paramlq = paramMarker.e;
      }
      this.d = mr.a(this.b.ay, this, paramlq, this.c);
      paramlq = this.c;
      if (paramlq != null) {
        a(paramlq.getPosition());
      }
    }
    this.g = true;
  }
  
  private void l()
  {
    pn localpn = this.b;
    if (localpn != null)
    {
      if (localpn.az == null) {
        return;
      }
      this.b.az.a(this);
    }
  }
  
  private void m()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      if (((pt)localObject).az == null) {
        return;
      }
      localObject = this.b.az.b;
      if (!((lw)localObject).F.isEmpty()) {
        ((lw)localObject).F.remove(this);
      }
    }
  }
  
  public final Rect a(fu paramfu)
  {
    if (paramfu != null)
    {
      if (this.d == null) {
        return null;
      }
      if (this.k) {
        paramfu = this.l;
      } else {
        paramfu = paramfu.a(this.j);
      }
      if (paramfu == null) {
        return null;
      }
      Marker localMarker = this.c;
      int n = 0;
      if ((localMarker != null) && (localMarker.getOptions() != null))
      {
        n = this.c.getOptions().getInfoWindowOffsetX();
        m = this.c.getOptions().getInfowindowOffsetY();
      }
      else
      {
        m = 0;
      }
      localMarker = this.c;
      int i2 = 1;
      int i3;
      if ((localMarker != null) && (this.b.ay != null))
      {
        int i4 = this.c.getWidth(this.b.ay);
        if (this.c.getOptions() != null) {
          f1 = this.c.getOptions().getInfoWindowAnchorU();
        } else {
          f1 = 0.5F;
        }
        i3 = this.e;
        i1 = i3;
        if (i3 == 0) {
          i1 = 1;
        }
        this.h = (f1 + i4 * (this.c.getAnchorU() - 0.5F) / i1);
      }
      if ((this.c != null) && (this.b.ay != null))
      {
        i3 = (int)(this.c.getHeight(this.b.ay) * this.c.getAnchorV());
        i1 = this.f;
        if (this.c.getOptions() != null) {
          f1 = this.c.getOptions().getInfoWindowAnchorV();
        } else {
          f1 = 1.0F;
        }
        if (i1 == 0) {
          i1 = i2;
        }
        f2 = i3;
        f3 = i1;
        this.i = ((f2 + f1 * f3) / f3);
      }
      float f1 = this.h;
      float f2 = n * 1.0F / this.e;
      float f3 = this.i;
      float f4 = m * 1.0F / this.f;
      double d1 = paramfu.x;
      int m = this.e;
      double d2 = m * (f1 - f2);
      Double.isNaN(d2);
      n = (int)(d1 - d2);
      d1 = paramfu.y;
      int i1 = this.f;
      d2 = i1 * (f3 - f4);
      Double.isNaN(d2);
      i2 = (int)(d1 - d2);
      return new Rect(n, i2, m + n, i1 + i2);
    }
    return null;
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
    GeoPoint localGeoPoint = this.j;
    if (localGeoPoint == null)
    {
      this.j = fz.a(paramLatLng);
    }
    else
    {
      localGeoPoint.setLatitudeE6((int)(paramLatLng.latitude * 1000000.0D));
      this.j.setLongitudeE6((int)(paramLatLng.longitude * 1000000.0D));
    }
    k();
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
    if ((this.d != null) && (this.g))
    {
      Object localObject = this.b;
      if ((localObject != null) && (((pt)localObject).az != null))
      {
        if (this.b.az.b.h == null) {
          return false;
        }
        localObject = a(this.b.az.b.h);
        if (localObject != null)
        {
          if (((Rect)localObject).isEmpty()) {
            return false;
          }
          return ((Rect)localObject).contains((int)paramFloat1, (int)paramFloat2);
        }
      }
    }
    return false;
  }
  
  public final void a_()
  {
    k();
  }
  
  public final Rect b(fu paramfu)
  {
    Rect localRect = a(paramfu);
    if (localRect != null)
    {
      if (paramfu == null) {
        return null;
      }
      GeoPoint localGeoPoint = paramfu.a(new DoublePoint(localRect.left, localRect.top));
      paramfu = paramfu.a(new DoublePoint(localRect.right, localRect.bottom));
      if (localGeoPoint != null)
      {
        if (paramfu == null) {
          return null;
        }
        return new Rect(localGeoPoint.getLongitudeE6(), localGeoPoint.getLatitudeE6(), paramfu.getLongitudeE6(), paramfu.getLatitudeE6());
      }
    }
    return null;
  }
  
  public final void b()
  {
    View localView = this.d;
    if (localView == null) {
      return;
    }
    if ((localView.getParent() instanceof ViewGroup)) {
      ((ViewGroup)this.d.getParent()).post(new mx.3(this));
    }
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
    if (this.g)
    {
      View localView = this.d;
      if ((localView != null) && (localView.getVisibility() == 0)) {
        return true;
      }
    }
    return false;
  }
  
  public final void f()
  {
    lq locallq = this.a;
    if ((locallq != null) && (locallq.c != null)) {
      this.a.c.post(new mx.2(this));
    }
  }
  
  public final View g()
  {
    return this.d;
  }
  
  public final void i()
  {
    lq locallq = this.a;
    if (locallq != null)
    {
      if (locallq.c == null) {
        return;
      }
      this.a.c.post(new mx.4(this));
    }
  }
  
  public final void j()
  {
    lq locallq = this.a;
    if (locallq != null)
    {
      if (locallq.c == null) {
        return;
      }
      this.a.c.post(new mx.5(this));
    }
  }
  
  final void k()
  {
    lq locallq = this.a;
    if ((locallq != null) && (locallq.c != null)) {
      this.a.c.post(new mx.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.mx
 * JD-Core Version:    0.7.0.1
 */