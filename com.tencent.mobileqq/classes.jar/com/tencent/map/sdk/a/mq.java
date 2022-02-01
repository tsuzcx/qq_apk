package com.tencent.map.sdk.a;

import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.sdk.engine.jni.models.CircleInfo;
import com.tencent.tencentmap.mapsdk.maps.model.CircleOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import javax.microedition.khronos.opengles.GL10;

public class mq
  extends mu
  implements go
{
  private GeoPoint h = new GeoPoint(39909230, 116397428);
  private double i = 0.0D;
  private float j = 1000.0F;
  private pn k = null;
  private CircleOptions l;
  private int m = -1;
  private CircleInfo n = new CircleInfo();
  
  public mq(pn parampn)
  {
    this.k = parampn;
  }
  
  private static double a(double paramDouble1, double paramDouble2)
  {
    return paramDouble1 / Math.cos(paramDouble2 * 3.141592653589793D / 180.0D);
  }
  
  private static fw a(LatLng paramLatLng)
  {
    double d = paramLatLng.latitude;
    return new fw(paramLatLng.longitude * 20037508.34D / 180.0D, Math.log(Math.tan((d + 90.0D) * 3.141592653589793D / 360.0D)) / 0.0174532925199433D * 20037508.34D / 180.0D);
  }
  
  private static LatLng a(fw paramfw)
  {
    float f = (float)(paramfw.b * 180.0D / 20037508.34D);
    double d = (float)(paramfw.a * 180.0D / 20037508.34D);
    Double.isNaN(d);
    return new LatLng((float)((Math.atan(Math.exp(d * 3.141592653589793D / 180.0D)) * 2.0D - 1.570796326794897D) * 57.295779513082323D), f);
  }
  
  public final Rect a(fu paramfu)
  {
    Object localObject1 = b(paramfu);
    int i1 = ((Rect)localObject1).left;
    int i2 = ((Rect)localObject1).right;
    int i3 = ((Rect)localObject1).top;
    int i4 = ((Rect)localObject1).bottom;
    Object localObject2 = new GeoPoint(i3, i1);
    Object localObject4 = new GeoPoint(i4, i1);
    Object localObject3 = new GeoPoint(i4, i2);
    localObject1 = new GeoPoint(i3, i2);
    localObject2 = paramfu.a((GeoPoint)localObject2);
    localObject4 = paramfu.a((GeoPoint)localObject4);
    localObject3 = paramfu.a((GeoPoint)localObject3);
    paramfu = paramfu.a((GeoPoint)localObject1);
    return new Rect((int)Math.min(Math.min(((DoublePoint)localObject2).x, ((DoublePoint)localObject4).x), Math.min(((DoublePoint)localObject3).x, paramfu.x)), (int)Math.min(Math.min(((DoublePoint)localObject2).y, ((DoublePoint)localObject4).y), Math.min(((DoublePoint)localObject3).y, paramfu.y)), (int)Math.max(Math.max(((DoublePoint)localObject2).x, ((DoublePoint)localObject4).x), Math.max(((DoublePoint)localObject3).x, paramfu.x)), (int)Math.max(Math.max(((DoublePoint)localObject2).y, ((DoublePoint)localObject4).y), Math.max(((DoublePoint)localObject3).y, paramfu.y)));
  }
  
  public final void a(double paramDouble)
  {
    if (paramDouble < 0.0D) {
      return;
    }
    double d = paramDouble;
    if (paramDouble == 0.0D) {
      d = 1.0E-010D;
    }
    CircleOptions localCircleOptions = this.l;
    if (localCircleOptions != null)
    {
      if (localCircleOptions.getCenter() == null) {
        return;
      }
      this.i = d;
      this.j = ((float)fz.a(d, this.l.getCenter().latitude));
      this.f = true;
    }
  }
  
  public final void a(GeoPoint paramGeoPoint)
  {
    if (paramGeoPoint == null) {
      return;
    }
    GeoPoint localGeoPoint = this.h;
    if (localGeoPoint == null)
    {
      this.h = new GeoPoint(paramGeoPoint.getLatitudeE6(), paramGeoPoint.getLongitudeE6());
    }
    else
    {
      localGeoPoint.setLatitudeE6(paramGeoPoint.getLatitudeE6());
      this.h.setLongitudeE6(paramGeoPoint.getLongitudeE6());
    }
    this.f = true;
  }
  
  public final void a(CircleOptions paramCircleOptions)
  {
    if (paramCircleOptions == null) {
      return;
    }
    this.l = paramCircleOptions;
    LatLng localLatLng = paramCircleOptions.getCenter();
    if (localLatLng != null) {
      a(fz.a(localLatLng));
    }
    a(paramCircleOptions.getRadius());
    a(paramCircleOptions.getStrokeWidth());
    b(paramCircleOptions.getStrokeColor());
    c(paramCircleOptions.getFillColor());
    b(paramCircleOptions.getZIndex());
    c(paramCircleOptions.isVisible());
    d(paramCircleOptions.getLevel());
    this.l = paramCircleOptions;
    this.f = true;
  }
  
  public final void a(GL10 paramGL10)
  {
    paramGL10 = this.k;
    if (paramGL10 != null)
    {
      if (paramGL10.az == null) {
        return;
      }
      d();
    }
  }
  
  public final boolean a()
  {
    return this.e;
  }
  
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    if (this.h != null)
    {
      Object localObject = this.k;
      if (localObject != null)
      {
        if (((pt)localObject).az == null) {
          return false;
        }
        localObject = this.k.az.b.h.a(new DoublePoint(paramFloat1, paramFloat2));
        if (Math.hypot(((GeoPoint)localObject).getLatitudeE6() - this.h.getLatitudeE6(), ((GeoPoint)localObject).getLongitudeE6() - this.h.getLongitudeE6()) <= this.j) {
          return true;
        }
      }
    }
    return false;
  }
  
  public final Rect b(fu paramfu)
  {
    double d1 = this.i;
    double d2 = this.h.getLatitudeE6();
    Double.isNaN(d2);
    d1 = a(d1, d2 / 1000000.0D);
    d2 = this.h.getLatitudeE6();
    Double.isNaN(d2);
    d2 /= 1000000.0D;
    double d3 = this.h.getLongitudeE6();
    Double.isNaN(d3);
    Object localObject = a(new LatLng(d2, d3 / 1000000.0D));
    paramfu = new fw(((fw)localObject).b - d1, ((fw)localObject).a + d1);
    localObject = new fw(((fw)localObject).b + d1, ((fw)localObject).a - d1);
    paramfu = a(paramfu);
    localObject = a((fw)localObject);
    Rect localRect = new Rect();
    localRect.left = ((int)(paramfu.longitude * 1000000.0D));
    localRect.top = ((int)(paramfu.latitude * 1000000.0D));
    localRect.right = ((int)(((LatLng)localObject).longitude * 1000000.0D));
    localRect.bottom = ((int)(((LatLng)localObject).latitude * 1000000.0D));
    return localRect;
  }
  
  public final void b()
  {
    if (this.m != -1)
    {
      Object localObject = this.k;
      if ((localObject != null) && (((pt)localObject).az != null))
      {
        localObject = this.k.az;
        int i1 = this.m;
        localObject = ((pm)localObject).b;
        if ((((lw)localObject).a != null) && (i1 != -1))
        {
          localObject = ((lw)localObject).a;
          if ((((pf)localObject).b != 0L) && (i1 >= 0) && (((pf)localObject).f != null)) {
            ((pf)localObject).f.a(new pf.1((pf)localObject, i1));
          }
        }
        this.m = -1;
      }
    }
  }
  
  public final void c() {}
  
  public final void c(boolean paramBoolean)
  {
    this.e = paramBoolean;
    this.f = true;
  }
  
  public final void d()
  {
    if ((this.m <= 0) || (this.f))
    {
      Object localObject = this.k;
      if (localObject != null)
      {
        if (((pt)localObject).az == null) {
          return;
        }
        this.n.zIndex = ((int)this.d);
        this.n.borderColor = this.c;
        this.n.borderWidth = ((int)this.a);
        this.n.fillColor = this.b;
        localObject = this.n;
        ((CircleInfo)localObject).radius = ((float)this.i);
        ((CircleInfo)localObject).centerX = this.h.getLongitudeE6();
        this.n.centerY = this.h.getLatitudeE6();
        this.n.isVisible = this.e;
        this.n.level = this.g;
        if (this.m == -1) {
          this.m = this.k.az.a(this.n);
        } else if (this.f) {
          this.k.az.a(this.m, this.n);
        }
        this.f = false;
      }
    }
  }
  
  public final void h()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.mq
 * JD-Core Version:    0.7.0.1
 */