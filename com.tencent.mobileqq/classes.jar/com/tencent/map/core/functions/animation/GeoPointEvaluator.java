package com.tencent.map.core.functions.animation;

import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.sdk.a.nt;

public class GeoPointEvaluator
  implements nt<GeoPoint>
{
  public GeoPoint evaluate(float paramFloat, GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    int m = paramGeoPoint2.getLatitudeE6();
    int n = paramGeoPoint1.getLatitudeE6();
    int i = paramGeoPoint2.getLongitudeE6();
    int j = paramGeoPoint1.getLongitudeE6();
    int k = paramGeoPoint1.getLatitudeE6();
    m = (int)((m - n) * paramFloat);
    n = paramGeoPoint1.getLongitudeE6();
    return new GeoPoint(m + k, (int)((i - j) * paramFloat) + n);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.core.functions.animation.GeoPointEvaluator
 * JD-Core Version:    0.7.0.1
 */