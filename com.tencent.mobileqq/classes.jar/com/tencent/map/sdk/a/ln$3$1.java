package com.tencent.map.sdk.a;

import com.tencent.map.lib.basemap.data.GeoPoint;

final class ln$3$1
  implements Runnable
{
  ln$3$1(ln.3 param3, float paramFloat, GeoPoint paramGeoPoint) {}
  
  public final void run()
  {
    if (this.c.d.b == null) {
      return;
    }
    if (this.c.a)
    {
      double d1 = (int)this.c.d.b();
      double d2 = Math.log(1.0F / this.a) / Math.log(2.0D);
      Double.isNaN(d1);
      d2 = d1 - d2 - 2.0D;
      d1 = d2;
      if (d2 < 0.0D) {
        d1 = 0.0D;
      }
      localObject = new pd();
      ((pd)localObject).b(this.b.getLatitudeE6(), this.b.getLongitudeE6());
      ((pd)localObject).a((float)d1);
      ((pd)localObject).a = this.c.d.h;
      ((pd)localObject).d = this.c.b;
      ((pd)localObject).a(this.c.c);
      this.c.d.b.az.a((nv)localObject);
      return;
    }
    Object localObject = this.c.d.b.az;
    GeoPoint localGeoPoint = this.b;
    ((pm)localObject).b.c.a(localGeoPoint.getLatitudeE6(), localGeoPoint.getLongitudeE6(), 1);
    this.c.d.b.az.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.ln.3.1
 * JD-Core Version:    0.7.0.1
 */