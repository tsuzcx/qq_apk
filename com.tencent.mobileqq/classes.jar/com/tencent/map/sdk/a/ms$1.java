package com.tencent.map.sdk.a;

import com.tencent.map.core.functions.animation.GlAnimation.SetAnimatePropertyListener;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;

final class ms$1
  implements GlAnimation.SetAnimatePropertyListener
{
  ms$1(ms paramms) {}
  
  public final void setAlpha(float paramFloat)
  {
    ms localms = this.a;
    localms.x = paramFloat;
    if (ms.a(localms) != null)
    {
      ms.a(this.a).a(this.a.x);
      this.a.s.alpha(this.a.x);
    }
    if (this.a.J != null) {
      this.a.J.a(this.a.s);
    }
  }
  
  public final void setPosition(int paramInt1, int paramInt2)
  {
    if ((ms.b(this.a) != null) && (this.a.u != null))
    {
      Object localObject = new GeoPoint();
      if ((ms.c(this.a)) && (ms.d(this.a) != null) && (ms.b(this.a).az != null))
      {
        GeoPoint localGeoPoint = ms.b(this.a).az.b.h.a(new DoublePoint(ms.e(this.a), ms.f(this.a)));
        int i = localGeoPoint.getLatitudeE6();
        int j = ms.d(this.a).getLatitudeE6();
        int k = localGeoPoint.getLongitudeE6();
        int m = ms.d(this.a).getLongitudeE6();
        ((GeoPoint)localObject).setLatitudeE6(paramInt1 + (i - j));
        ((GeoPoint)localObject).setLongitudeE6(paramInt2 + (k - m));
        localObject = ms.b(this.a).az.b.h.a((GeoPoint)localObject);
        this.a.u.setLatitudeE6((int)((DoublePoint)localObject).y);
        this.a.u.setLongitudeE6((int)((DoublePoint)localObject).x);
      }
      else
      {
        this.a.u.setLatitudeE6(paramInt1 + 0);
        this.a.u.setLongitudeE6(paramInt2 + 0);
      }
      if (this.a.s != null) {
        this.a.s.position(fz.a(this.a.u));
      }
      if (ms.a(this.a) != null) {
        ms.a(this.a).a(this.a.u);
      }
      if (this.a.J != null) {
        this.a.J.a(fz.a(this.a.u));
      }
    }
  }
  
  public final void setRatio(float paramFloat) {}
  
  public final void setRotate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    ms localms = this.a;
    localms.n = paramFloat1;
    localms.p = paramFloat2;
    localms.q = paramFloat3;
    localms.r = paramFloat4;
    localms.o = true;
    if (ms.a(localms) != null) {
      ms.a(this.a).b((int)this.a.n);
    }
  }
  
  public final void setScale(float paramFloat1, float paramFloat2)
  {
    ms localms = this.a;
    localms.y = paramFloat1;
    localms.z = paramFloat2;
    if (ms.a(localms) != null) {
      ms.a(this.a).c(this.a.y, this.a.z);
    }
    if (this.a.J != null) {
      this.a.G.refreshInfoWindow();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.ms.1
 * JD-Core Version:    0.7.0.1
 */