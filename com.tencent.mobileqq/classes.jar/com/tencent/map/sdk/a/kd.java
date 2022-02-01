package com.tencent.map.sdk.a;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.location.Location;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;

public final class kd
  implements fu
{
  private kc a;
  private pf b;
  private lw c;
  
  public kd(kc paramkc, lg paramlg)
  {
    this.a = paramkc;
    this.b = paramlg.g();
    this.c = ((lw)paramlg);
  }
  
  public static DoublePoint a(kc paramkc, GeoPoint paramGeoPoint)
  {
    if (paramGeoPoint == null) {
      return null;
    }
    int i = paramkc.d;
    double d2 = paramkc.e;
    double d3 = paramkc.f;
    double d1 = 0.0D;
    if (paramGeoPoint != null)
    {
      d1 = paramGeoPoint.getLatitudeE6();
      Double.isNaN(d1);
      double d4 = Math.min(Math.max(Math.sin(d1 / 1000000.0D * 0.0174532925199433D), -0.9999D), 0.9999D);
      d1 = i >> 1;
      double d5 = paramGeoPoint.getLongitudeE6();
      Double.isNaN(d5);
      d5 /= 1000000.0D;
      Double.isNaN(d1);
      d2 = d5 * d2 + d1;
      d4 = Math.log((d4 + 1.0D) / (1.0D - d4));
      Double.isNaN(d1);
      d1 += d4 * d3 * 0.5D;
    }
    else
    {
      d2 = 0.0D;
    }
    return new DoublePoint(d2, d1);
  }
  
  public static fw b(GeoPoint paramGeoPoint)
  {
    if (paramGeoPoint == null) {
      return null;
    }
    double d1 = paramGeoPoint.getLatitudeE6();
    Double.isNaN(d1);
    d1 /= 1000000.0D;
    double d2 = paramGeoPoint.getLongitudeE6();
    Double.isNaN(d2);
    return new fw(d2 / 1000000.0D * 20037508.34D / 180.0D, Math.log(Math.tan((d1 + 90.0D) * 3.141592653589793D / 360.0D)) / 0.0174532925199433D * 20037508.34D / 180.0D);
  }
  
  public final double a(double paramDouble)
  {
    float f = this.a.b.f;
    double d2 = this.a.b.a();
    double d1 = f;
    d2 = Math.log(d2) / Math.log(2.0D);
    Double.isNaN(d1);
    d1 = Math.pow(2.0D, (float)(d1 + d2));
    d2 = fz.v;
    Double.isNaN(d2);
    return 40076000.0D / (d1 * 256.0D * d2) * Math.cos(paramDouble * 3.141592653589793D / 180.0D);
  }
  
  public final double a(Point paramPoint1, Point paramPoint2)
  {
    GeoPoint localGeoPoint1 = a(new DoublePoint(paramPoint1.x, paramPoint1.y));
    GeoPoint localGeoPoint2 = a(new DoublePoint(paramPoint2.x, paramPoint2.y));
    float[] arrayOfFloat = new float[1];
    double d1 = localGeoPoint1.getLatitudeE6();
    Double.isNaN(d1);
    d1 /= 1000000.0D;
    double d2 = localGeoPoint1.getLongitudeE6();
    Double.isNaN(d2);
    d2 /= 1000000.0D;
    double d3 = localGeoPoint2.getLatitudeE6();
    Double.isNaN(d3);
    d3 /= 1000000.0D;
    double d4 = localGeoPoint2.getLongitudeE6();
    Double.isNaN(d4);
    Location.distanceBetween(d1, d2, d3, d4 / 1000000.0D, arrayOfFloat);
    int i = (int)Math.sqrt(Math.pow(paramPoint1.x - paramPoint2.x, 2.0D) + Math.pow(paramPoint1.y - paramPoint2.y, 2.0D));
    return arrayOfFloat[0] / i;
  }
  
  public final DoublePoint a(GeoPoint paramGeoPoint)
  {
    if (paramGeoPoint == null) {
      return null;
    }
    double d1 = paramGeoPoint.getLatitudeE6();
    Double.isNaN(d1);
    d1 /= 1000000.0D;
    double d2 = paramGeoPoint.getLongitudeE6();
    Double.isNaN(d2);
    d2 /= 1000000.0D;
    paramGeoPoint = this.b.a(d1, d2);
    float f4 = paramGeoPoint.x;
    float f3 = paramGeoPoint.y;
    paramGeoPoint = this.c;
    float f2 = f4;
    float f1 = f3;
    if (paramGeoPoint != null)
    {
      paramGeoPoint = paramGeoPoint.A;
      f2 = f4;
      f1 = f3;
      if (paramGeoPoint != null)
      {
        f2 = f4 + paramGeoPoint.left;
        f1 = f3 + paramGeoPoint.top;
      }
    }
    return new DoublePoint(f2, f1);
  }
  
  public final GeoPoint a(DoublePoint paramDoublePoint)
  {
    if (paramDoublePoint == null) {
      return null;
    }
    float f4 = (float)paramDoublePoint.x;
    float f3 = (float)paramDoublePoint.y;
    paramDoublePoint = this.c;
    float f2 = f4;
    float f1 = f3;
    if (paramDoublePoint != null)
    {
      paramDoublePoint = paramDoublePoint.A;
      f2 = f4;
      f1 = f3;
      if (paramDoublePoint != null)
      {
        f2 = f4 - paramDoublePoint.left;
        f1 = f3 - paramDoublePoint.top;
      }
    }
    return this.b.a(f2, f1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.kd
 * JD-Core Version:    0.7.0.1
 */