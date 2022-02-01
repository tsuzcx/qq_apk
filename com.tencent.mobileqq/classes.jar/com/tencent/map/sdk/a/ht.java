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
    return new Rect((int)(localDoublePoint.x - fz.v * 20.0F), (int)(localDoublePoint.y - fz.v * 20.0F), (int)(localDoublePoint.x + fz.v * 20.0F), (int)(localDoublePoint.y + fz.v * 20.0F));
  }
  
  public final String b()
  {
    return this.a.getName();
  }
  
  public final void c()
  {
    if (this.b != null)
    {
      TencentMap.OnMapPoiClickListener localOnMapPoiClickListener = this.b.B;
      if (localOnMapPoiClickListener != null)
      {
        MapPoi localMapPoi = new MapPoi();
        localMapPoi.position = new LatLng(this.a.getLatitude(), this.a.getLongitude());
        localMapPoi.name = this.a.getName();
        localOnMapPoiClickListener.onClicked(localMapPoi);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.ht
 * JD-Core Version:    0.7.0.1
 */