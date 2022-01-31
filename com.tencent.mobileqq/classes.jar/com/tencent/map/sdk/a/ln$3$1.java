package com.tencent.map.sdk.a;

import com.tencent.map.lib.basemap.data.GeoPoint;

final class ln$3$1
  implements Runnable
{
  ln$3$1(ln.3 param3, float paramFloat, GeoPoint paramGeoPoint) {}
  
  public final void run()
  {
    double d1 = 0.0D;
    if (this.c.d.b == null) {
      return;
    }
    double d2;
    if (this.c.a)
    {
      d2 = (int)this.c.d.b() - Math.log(1.0F / this.a) / Math.log(2.0D) - 2.0D;
      if (d2 >= 0.0D) {
        break label224;
      }
    }
    for (;;)
    {
      Object localObject = new pd();
      ((pd)localObject).b(this.b.getLatitudeE6(), this.b.getLongitudeE6());
      ((pd)localObject).a((float)d1);
      ((pd)localObject).a = this.c.d.h;
      ((pd)localObject).d = this.c.b;
      ((pd)localObject).a(this.c.c);
      this.c.d.b.az.a((nv)localObject);
      return;
      localObject = this.c.d.b.az;
      GeoPoint localGeoPoint = this.b;
      ((pm)localObject).b.c.a(localGeoPoint.getLatitudeE6(), localGeoPoint.getLongitudeE6(), 1);
      this.c.d.b.az.c(this.a);
      return;
      label224:
      d1 = d2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.ln.3.1
 * JD-Core Version:    0.7.0.1
 */