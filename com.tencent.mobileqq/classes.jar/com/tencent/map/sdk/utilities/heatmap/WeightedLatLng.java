package com.tencent.map.sdk.utilities.heatmap;

import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.sdk.a.fx;
import com.tencent.map.sdk.a.hl.a;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class WeightedLatLng
  implements hl.a
{
  public static final double DEFAULT_INTENSITY = 1.0D;
  private static final fx a = new fx();
  private DoublePoint b;
  private double c;
  
  public WeightedLatLng(LatLng paramLatLng)
  {
    this(paramLatLng, 1.0D);
  }
  
  public WeightedLatLng(LatLng paramLatLng, double paramDouble)
  {
    setItemPoint(paramLatLng);
    setIntensity(paramDouble);
  }
  
  public double getIntensity()
  {
    return this.c;
  }
  
  public LatLng getItemLatLng()
  {
    fx localfx = a;
    DoublePoint localDoublePoint = this.b;
    double d = localDoublePoint.x / localfx.a;
    return new LatLng(90.0D - Math.toDegrees(Math.atan(Math.exp(-(0.5D - localDoublePoint.y / localfx.a) * 2.0D * 3.141592653589793D)) * 2.0D), (d - 0.5D) * 360.0D);
  }
  
  public DoublePoint getItemPoint()
  {
    return this.b;
  }
  
  public void setIntensity(double paramDouble)
  {
    if (paramDouble >= 0.0D)
    {
      this.c = paramDouble;
      return;
    }
    this.c = 1.0D;
  }
  
  public void setItemPoint(LatLng paramLatLng)
  {
    fx localfx = a;
    double d1 = paramLatLng.longitude / 360.0D;
    double d2 = Math.sin(Math.toRadians(paramLatLng.latitude));
    d2 = Math.log((1.0D + d2) / (1.0D - d2)) * 0.5D / -6.283185307179586D;
    this.b = new DoublePoint((d1 + 0.5D) * localfx.a, (d2 + 0.5D) * localfx.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.utilities.heatmap.WeightedLatLng
 * JD-Core Version:    0.7.0.1
 */