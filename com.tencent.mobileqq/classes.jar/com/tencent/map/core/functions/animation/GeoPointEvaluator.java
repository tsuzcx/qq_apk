package com.tencent.map.core.functions.animation;

import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.sdk.a.nt;

public class GeoPointEvaluator
  implements nt<GeoPoint>
{
  public GeoPoint evaluate(float paramFloat, GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    int i = paramGeoPoint2.getLatitudeE6();
    int j = paramGeoPoint1.getLatitudeE6();
    int k = paramGeoPoint2.getLongitudeE6();
    int m = paramGeoPoint1.getLongitudeE6();
    return new GeoPoint(paramGeoPoint1.getLatitudeE6() + (int)((i - j) * paramFloat), paramGeoPoint1.getLongitudeE6() + (int)(paramFloat * (k - m)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.core.functions.animation.GeoPointEvaluator
 * JD-Core Version:    0.7.0.1
 */