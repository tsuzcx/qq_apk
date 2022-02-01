package com.tencent.map.sdk.a;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.sdk.engine.jni.JNI;
import com.tencent.map.sdk.engine.jni.models.Polygon2D;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;

public class mv
  extends mu
  implements go, hb
{
  Polygon2D h;
  private List<GeoPoint> i = new ArrayList();
  private Rect j;
  private ir k;
  private byte[] l = new byte[0];
  private mv.a m = new mv.a((byte)0);
  private String n;
  private GeoPoint o = new GeoPoint();
  private Rect p = new Rect();
  private pm q;
  private boolean r = false;
  private boolean s = false;
  private PolygonOptions t;
  
  public mv(pn parampn, PolygonOptions paramPolygonOptions)
  {
    if ((parampn == null) || (parampn.az == null)) {}
    do
    {
      return;
      this.h = new Polygon2D();
      this.h.polygonId = -1;
      this.t = paramPolygonOptions;
      this.q = parampn.az;
    } while ((paramPolygonOptions == null) || (nl.a(paramPolygonOptions.getText())));
    this.q.a(this);
  }
  
  private static DoublePoint[] a(DoublePoint[] paramArrayOfDoublePoint)
  {
    double d6 = paramArrayOfDoublePoint[0].x;
    double d4 = paramArrayOfDoublePoint[0].y;
    double d2 = paramArrayOfDoublePoint[0].x;
    double d1 = paramArrayOfDoublePoint[0].y;
    int i1 = 1;
    double d5;
    double d3;
    if (i1 < 4)
    {
      double d7 = paramArrayOfDoublePoint[i1].x;
      d5 = paramArrayOfDoublePoint[i1].y;
      d3 = d6;
      if (d7 < d6) {
        d3 = d7;
      }
      if (d7 <= d2) {
        break label160;
      }
      d2 = d7;
    }
    label160:
    for (;;)
    {
      d6 = d4;
      if (d5 < d4) {
        d6 = d5;
      }
      if (d5 > d1) {
        d1 = d5;
      }
      for (;;)
      {
        i1 += 1;
        d4 = d6;
        d6 = d3;
        break;
        return new DoublePoint[] { new DoublePoint(d6, d4), new DoublePoint(d2, d1) };
      }
    }
  }
  
  private void e()
  {
    if (this.q == null) {}
    while (((this.h.polygonId >= 0) && (!this.f)) || (this.i == null) || (this.i.size() <= 2)) {
      return;
    }
    this.h.color = e(this.b);
    this.h.borderColor = e(this.c);
    this.h.borderWidth = this.a;
    this.h.polygonMode = 1;
    this.h.zIndex = i();
    this.h.level = j();
    int i2 = this.i.size();
    this.h.points = new Point[i2];
    int i1 = 0;
    while (i1 < i2)
    {
      GeoPoint localGeoPoint = (GeoPoint)this.i.get(i1);
      this.h.points[i1] = new Point(localGeoPoint.getLongitudeE6(), localGeoPoint.getLatitudeE6());
      i1 += 1;
    }
    if (-1 == this.h.polygonId) {
      this.h.polygonId = this.q.a(this.h);
    }
    for (;;)
    {
      this.q.b.k();
      this.f = false;
      return;
      if (this.f) {
        this.q.b(this.h);
      }
    }
  }
  
  private static int[] e(int paramInt)
  {
    return new int[] { Color.red(paramInt), Color.green(paramInt), Color.blue(paramInt), Color.alpha(paramInt) };
  }
  
  private Rect f()
  {
    if (this.j != null) {
      return this.j;
    }
    if ((this.i == null) || (this.i.isEmpty())) {
      return null;
    }
    GeoPoint localGeoPoint = (GeoPoint)this.i.get(0);
    int i2 = localGeoPoint.getLatitudeE6();
    int i5 = localGeoPoint.getLongitudeE6();
    int i6 = this.i.size();
    int i3 = i2;
    int i4 = i5;
    int i1 = 1;
    while (i1 < i6)
    {
      localGeoPoint = (GeoPoint)this.i.get(i1);
      int i7 = localGeoPoint.getLatitudeE6();
      int i8 = localGeoPoint.getLongitudeE6();
      i5 = Math.min(i5, i8);
      i4 = Math.max(i4, i8);
      i3 = Math.max(i3, i7);
      i2 = Math.min(i2, i7);
      i1 += 1;
    }
    this.j = new Rect(i5, i3, i4, i2);
    return this.j;
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
  
  public final void a(int paramInt)
  {
    if (paramInt == kc.c.a) {}
    Object localObject1;
    do
    {
      do
      {
        return;
      } while (this.q == null);
      localObject1 = this.q.b.h;
    } while ((this.q == null) || (nl.a(this.t.getText())));
    synchronized (this.l)
    {
      if (this.m == null) {
        this.m = new mv.a((byte)0);
      }
      ??? = new GeoPoint(this.p.top, this.p.left);
      GeoPoint localGeoPoint1 = new GeoPoint(this.p.top, this.p.right);
      GeoPoint localGeoPoint2 = new GeoPoint(this.p.bottom, this.p.right);
      GeoPoint localGeoPoint3 = new GeoPoint(this.p.bottom, this.p.left);
      localObject1 = a(new DoublePoint[] { ((fu)localObject1).a((GeoPoint)???), ((fu)localObject1).a(localGeoPoint1), ((fu)localObject1).a(localGeoPoint2), ((fu)localObject1).a(localGeoPoint3) });
      new Rect((int)localObject1[0].x, (int)localObject1[0].y, (int)localObject1[1].x, (int)localObject1[1].y);
      return;
    }
  }
  
  public final void a(fu paramfu, GL10 paramGL10)
  {
    int i2 = -1;
    int i1 = 1;
    label456:
    for (;;)
    {
      Object localObject1;
      try
      {
        localObject1 = this.q;
        if (localObject1 == null) {
          return;
        }
        if (!this.e)
        {
          this.q.c(this.h.polygonId);
          this.h.polygonId = -1;
          continue;
        }
        if (!nl.a(this.t.getText())) {
          break label78;
        }
      }
      finally {}
      e();
      continue;
      label78:
      if (this.h != null)
      {
        Object localObject2 = f();
        Object localObject4 = new GeoPoint(((Rect)localObject2).top, ((Rect)localObject2).left);
        Object localObject3 = new GeoPoint(((Rect)localObject2).bottom, ((Rect)localObject2).right);
        localObject1 = new GeoPoint(((Rect)localObject2).bottom, ((Rect)localObject2).left);
        localObject2 = new GeoPoint(((Rect)localObject2).top, ((Rect)localObject2).right);
        localObject4 = paramfu.a((GeoPoint)localObject4);
        localObject3 = paramfu.a((GeoPoint)localObject3);
        localObject1 = paramfu.a((GeoPoint)localObject1);
        paramfu = a(new DoublePoint[] { localObject4, paramfu.a((GeoPoint)localObject2), localObject3, localObject1 });
        paramfu = new Rect((int)paramfu[0].x, (int)paramfu[0].y, (int)paramfu[1].x, (int)paramfu[1].y);
        if ((Math.abs(paramfu.width()) <= 5) || (Math.abs(paramfu.height()) <= 5)) {}
      }
      for (;;)
      {
        for (;;)
        {
          if (i1 == 0) {
            break label456;
          }
          a(paramGL10);
          if (this.k == null) {
            break;
          }
          this.k.a(paramGL10);
          this.n = this.k.a();
          if (this.s) {
            break;
          }
          paramfu = this.q;
          int i3 = this.k.a();
          if (this.h == null)
          {
            i1 = i2;
            label368:
            paramfu = paramfu.b;
            if (paramfu.a != null) {
              paramfu = paramfu.a;
            }
          }
          try
          {
            paramfu.y();
            long l1 = paramfu.b;
            if (l1 == 0L) {
              paramfu.z();
            }
            for (;;)
            {
              this.s = true;
              break;
              i1 = this.h.polygonId;
              break label368;
              paramfu.a.nativeBringElementAbove(paramfu.b, i3, i1);
              paramfu.z();
            }
            i1 = 0;
          }
          finally
          {
            paramfu.z();
          }
        }
      }
    }
  }
  
  public final void a(PolygonOptions paramPolygonOptions)
  {
    if (paramPolygonOptions == null) {
      return;
    }
    c(paramPolygonOptions.getFillColor());
    b(paramPolygonOptions.getStrokeColor());
    a(paramPolygonOptions.getStrokeWidth());
    b(paramPolygonOptions.getZIndex());
    c(paramPolygonOptions.isVisible());
    d(paramPolygonOptions.getLevel());
    paramPolygonOptions = paramPolygonOptions.getPoints();
    if (paramPolygonOptions != null)
    {
      int i2 = paramPolygonOptions.size();
      if (i2 > 0)
      {
        ArrayList localArrayList = new ArrayList();
        int i1 = 0;
        while (i1 < i2)
        {
          Object localObject = (LatLng)paramPolygonOptions.get(i1);
          if (localObject != null)
          {
            localObject = fz.a((LatLng)localObject);
            if (localObject != null) {
              localArrayList.add(localObject);
            }
          }
          i1 += 1;
        }
        a(localArrayList);
      }
    }
    this.f = true;
  }
  
  public final void a(List<GeoPoint> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    label32:
    int i1;
    label42:
    GeoPoint localGeoPoint;
    if (this.i == null)
    {
      this.i = new ArrayList();
      int i3 = paramList.size();
      i1 = 0;
      if (i1 < i3)
      {
        localGeoPoint = (GeoPoint)paramList.get(i1);
        if (localGeoPoint != null)
        {
          i2 = 0;
          label67:
          if (i2 >= i1) {
            break label139;
          }
          if (!localGeoPoint.equals((GeoPoint)paramList.get(i2))) {
            break label132;
          }
        }
      }
    }
    label132:
    label139:
    for (int i2 = 1;; i2 = 0)
    {
      if (i2 == 0)
      {
        this.f = true;
        this.i.add(localGeoPoint);
      }
      i1 += 1;
      break label42;
      break;
      this.i.clear();
      break label32;
      i2 += 1;
      break label67;
    }
  }
  
  public final void a(GL10 paramGL10)
  {
    if (this.q == null) {
      return;
    }
    if (!this.e)
    {
      this.q.c(this.h.polygonId);
      this.h.polygonId = -1;
      return;
    }
    e();
  }
  
  public final boolean a()
  {
    return this.e;
  }
  
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final Rect b(fu paramfu)
  {
    Rect localRect = new Rect();
    new Rect();
    if (this.h != null) {
      localRect = f();
    }
    if (this.k != null)
    {
      paramfu = this.k.b(paramfu);
      localRect.left = Math.min(localRect.left, paramfu.left);
      localRect.top = Math.min(localRect.top, paramfu.top);
      localRect.right = Math.max(localRect.right, paramfu.right);
      localRect.bottom = Math.max(localRect.bottom, paramfu.bottom);
    }
    return localRect;
  }
  
  public final void b() {}
  
  public final void c() {}
  
  public final void c(boolean paramBoolean)
  {
    if (this.q == null) {
      return;
    }
    this.e = paramBoolean;
    this.q.b.k();
  }
  
  public final void d()
  {
    e();
  }
  
  public final void h()
  {
    if (this.q == null) {
      return;
    }
    Object localObject2 = this.q.b.c;
    synchronized (((kl)localObject2).e)
    {
      ((kl)localObject2).e.remove(this);
      if (this.h != null) {
        this.q.c(this.h.polygonId);
      }
      if (this.i != null)
      {
        this.i.clear();
        this.i = null;
      }
    }
    synchronized (this.l)
    {
      if (this.m != null)
      {
        localObject2 = this.m;
        if ((((mv.a)localObject2).a != null) && (!((mv.a)localObject2).a.isRecycled()))
        {
          ((mv.a)localObject2).a.recycle();
          ((mv.a)localObject2).a = null;
        }
        this.m = null;
      }
      if (this.k != null)
      {
        this.q.b(this.k);
        this.k = null;
      }
      this.r = false;
      return;
      localObject3 = finally;
      throw localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.mv
 * JD-Core Version:    0.7.0.1
 */