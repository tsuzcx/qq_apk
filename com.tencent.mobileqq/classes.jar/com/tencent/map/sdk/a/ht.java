package com.tencent.map.sdk.a;

import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapPoiClickListener;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.MapPoi;

public final class ht
  extends hq
{
  private MapPoi a;
  private pn b;
  
  public ht(pn parampn, MapPoi paramMapPoi)
  {
    this.a = paramMapPoi;
    this.b = parampn;
  }
  
  public final Rect a()
  {
    DoublePoint localDoublePoint = this.b.az.b.h.a(fz.a(new LatLng(this.a.getLatitude(), this.a.getLongitude())));
    double d1 = localDoublePoint.x;
    double d2 = fz.v * 20.0F;
    Double.isNaN(d2);
    int i = (int)(d1 - d2);
    d1 = localDoublePoint.y;
    d2 = fz.v * 20.0F;
    Double.isNaN(d2);
    int j = (int)(d1 - d2);
    d1 = localDoublePoint.x;
    d2 = fz.v * 20.0F;
    Double.isNaN(d2);
    int k = (int)(d1 + d2);
    d1 = localDoublePoint.y;
    d2 = fz.v * 20.0F;
    Double.isNaN(d2);
    return new Rect(i, j, k, (int)(d1 + d2));
  }
  
  public final String b()
  {
    return this.a.getName();
  }
  
  public final void c()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((pn)localObject).B;
      if (localObject != null)
      {
        MapPoi localMapPoi = new MapPoi();
        localMapPoi.position = new LatLng(this.a.getLatitude(), this.a.getLongitude());
        localMapPoi.name = this.a.getName();
        ((TencentMap.OnMapPoiClickListener)localObject).onClicked(localMapPoi);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.ht
 * JD-Core Version:    0.7.0.1
 */