package com.tencent.map.sdk.a;

import com.tencent.map.lib.basemap.data.GeoPoint;

final class mw$a
  extends GeoPoint
{
  float a = 0.0F;
  int b = 0;
  
  public mw$a() {}
  
  public mw$a(GeoPoint paramGeoPoint)
  {
    super(paramGeoPoint);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append(",");
    localStringBuilder.append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.mw.a
 * JD-Core Version:    0.7.0.1
 */