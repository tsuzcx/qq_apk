package com.tencent.map.sdk.a;

import com.tencent.map.lib.basemap.data.GeoPoint;

public final class gb
{
  public static GeoPoint a(int paramInt1, int paramInt2)
  {
    double d = paramInt1 / 42722829.723526977D;
    return new GeoPoint((int)(Math.toDegrees((Math.atan(Math.exp(3.141592653589793D - paramInt2 / 42722829.723526977D)) - 0.7853981633974483D) * 2.0D) * 1000000.0D), (int)(Math.toDegrees(d - 3.141592653589793D) * 1000000.0D));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.gb
 * JD-Core Version:    0.7.0.1
 */