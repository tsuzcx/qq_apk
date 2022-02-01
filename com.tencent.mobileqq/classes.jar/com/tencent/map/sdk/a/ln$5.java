package com.tencent.map.sdk.a;

import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.AsyncOperateCallback;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;

final class ln$5
  implements kb.a
{
  ln$5(ln paramln, TencentMap.AsyncOperateCallback paramAsyncOperateCallback) {}
  
  public final void a(float paramFloat, GeoPoint paramGeoPoint)
  {
    paramGeoPoint = fz.a(paramGeoPoint);
    double d1 = 20.0D - Math.log(1.0F / paramFloat) / Math.log(2.0D);
    double d2 = 0.0D;
    if (d1 < 0.0D) {
      d1 = d2;
    }
    ln localln = this.b;
    localln.f = new CameraPosition(paramGeoPoint, (float)d1, localln.b.az.h(), this.b.b.az.g());
    paramGeoPoint = this.a;
    if (paramGeoPoint != null) {
      paramGeoPoint.onOperateFinished(this.b.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.ln.5
 * JD-Core Version:    0.7.0.1
 */