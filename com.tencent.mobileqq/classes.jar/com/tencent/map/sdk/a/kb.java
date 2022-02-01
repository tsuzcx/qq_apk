package com.tencent.map.sdk.a;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.location.Location;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.sdk.engine.jni.JNI;
import java.util.List;

public final class kb
  implements fu
{
  kc a;
  lw b;
  private pf c;
  
  public kb(lg paramlg)
  {
    this.b = ((lw)paramlg);
    this.a = paramlg.b().f();
    this.c = paramlg.g();
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
    double d1 = paramGeoPoint.getLatitudeE6();
    Double.isNaN(d1);
    d1 /= 1000000.0D;
    double d2 = paramGeoPoint.getLongitudeE6();
    Double.isNaN(d2);
    d2 /= 1000000.0D;
    paramGeoPoint = this.c.a(d1, d2);
    return new DoublePoint(paramGeoPoint.x, paramGeoPoint.y);
  }
  
  public final GeoPoint a(DoublePoint paramDoublePoint)
  {
    float f1 = (float)paramDoublePoint.x;
    float f2 = (float)paramDoublePoint.y;
    return this.c.a(f1, f2);
  }
  
  public final void a(float paramFloat)
  {
    kc localkc = this.a;
    if (localkc.p != null)
    {
      pf localpf = localkc.p;
      double d = paramFloat;
      try
      {
        localpf.y();
        if ((0L != localpf.b) && (localpf.f != null)) {
          localpf.a.nativeSetScale(localpf.b, d, false);
        }
      }
      finally
      {
        localpf.z();
      }
    }
    localObject.b.e = paramFloat;
    int i = kc.c.c;
  }
  
  public final void a(List<? extends gg> paramList, List<GeoPoint> paramList1, Rect paramRect, kb.a parama)
  {
    if ((paramList.isEmpty()) && ((paramList1 == null) || (paramList1.isEmpty()))) {
      return;
    }
    Object localObject = new Rect(this.b.i);
    ((Rect)localObject).left += paramRect.left;
    ((Rect)localObject).right -= paramRect.right;
    ((Rect)localObject).top += paramRect.top;
    ((Rect)localObject).bottom -= paramRect.bottom;
    int i = ((Rect)localObject).width();
    int j = ((Rect)localObject).height();
    localObject = this.b.c.a;
    int k = ((kf)localObject).b;
    this.b.a(new kb.1(this, paramList, paramList1, i, j, paramRect, k, (kf)localObject, parama));
    if (k != 60) {
      ((kf)localObject).b = 60;
    }
  }
  
  public final void b(GeoPoint paramGeoPoint)
  {
    Object localObject = this.a;
    int m = paramGeoPoint.getLatitudeE6();
    int k = paramGeoPoint.getLongitudeE6();
    int i = 1 << 20 - ((kc)localObject).b.f;
    if (131072 > i)
    {
      j = (((kc)localObject).n.width() * 131072 - ((kc)localObject).n.width() * i) / 2;
      i = (((kc)localObject).n.height() * 131072 - ((kc)localObject).n.height() * i) / 2;
    }
    else
    {
      i = 0;
      j = 0;
    }
    int i1 = ((kc)localObject).c.left - j;
    int n = ((kc)localObject).c.right + j;
    int j = ((kc)localObject).c.top - i;
    int i2 = ((kc)localObject).c.bottom + i;
    i = m;
    if (m < j) {
      i = j;
    }
    j = i;
    if (i > i2) {
      j = i2;
    }
    i = k;
    if (k < i1) {
      i = i1;
    }
    k = i;
    if (i > n) {
      k = n;
    }
    paramGeoPoint = new GeoPoint(j, k);
    localObject = ((kc)localObject).p;
    try
    {
      ((pf)localObject).y();
      if ((0L != ((pf)localObject).b) && (((pf)localObject).f != null))
      {
        ((pf)localObject).a.nativeSetCenter(((pf)localObject).b, paramGeoPoint, false);
        return;
      }
      return;
    }
    finally
    {
      ((pf)localObject).z();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.kb
 * JD-Core Version:    0.7.0.1
 */