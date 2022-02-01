package com.tencent.map.sdk.a;

import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public final class ga
{
  public static LatLng a(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    return new LatLng(paramLatLng1.latitude * 2.0D - paramLatLng2.latitude, paramLatLng1.longitude * 2.0D - paramLatLng2.longitude);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.ga
 * JD-Core Version:    0.7.0.1
 */