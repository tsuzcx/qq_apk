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
    if (parampn != null)
    {
      if (parampn.az == null) {
        return;
      }
      this.h = new Polygon2D();
      this.h.polygonId = -1;
      this.t = paramPolygonOptions;
      this.q = parampn.az;
      if ((paramPolygonOptions != null) && (!nl.a(paramPolygonOptions.getText()))) {
        this.q.a(this);
      }
    }
  }
  
  private static DoublePoint[] a(DoublePoint[] paramArrayOfDoublePoint)
  {
    double d7 = paramArrayOfDoublePoint[0].x;
    double d2 = paramArrayOfDoublePoint[0].y;
    double d5 = paramArrayOfDoublePoint[0].x;
    double d1 = paramArrayOfDoublePoint[0].y;
    int i1 = 1;
    while (i1 < 4)
    {
      double d8 = paramArrayOfDoublePoint[i1].x;
      double d3 = paramArrayOfDoublePoint[i1].y;
      double d4 = d7;
      if (d8 < d7) {
        d4 = d8;
      }
      double d6 = d5;
      if (d8 > d5) {
        d6 = d8;
      }
      d5 = d2;
      if (d3 < d2) {
        d5 = d3;
      }
      d8 = d1;
      if (d3 > d1) {
        d8 = d3;
      }
      i1 += 1;
      d7 = d4;
      d2 = d5;
      d5 = d6;
      d1 = d8;
    }
    return new DoublePoint[] { new DoublePoint(d7, d2), new DoublePoint(d5, d1) };
  }
  
  private void e()
  {
    if (this.q == null) {
      return;
    }
    if ((this.h.polygonId >= 0) && (!this.f)) {
      return;
    }
    Object localObject = this.i;
    if (localObject != null)
    {
      if (((List)localObject).size() <= 2) {
        return;
      }
      this.h.color = e(this.b);
      this.h.borderColor = e(this.c);
      this.h.borderWidth = this.a;
      localObject = this.h;
      ((Polygon2D)localObject).polygonMode = 1;
      ((Polygon2D)localObject).zIndex = i();
      this.h.level = j();
      int i2 = this.i.size();
      this.h.points = new Point[i2];
      int i1 = 0;
      while (i1 < i2)
      {
        localObject = (GeoPoint)this.i.get(i1);
        this.h.points[i1] = new Point(((GeoPoint)localObject).getLongitudeE6(), ((GeoPoint)localObject).getLatitudeE6());
        i1 += 1;
      }
      if (-1 == this.h.polygonId)
      {
        localObject = this.h;
        ((Polygon2D)localObject).polygonId = this.q.a((Polygon2D)localObject);
      }
      else if (this.f)
      {
        this.q.b(this.h);
      }
      this.q.b.k();
      this.f = false;
    }
  }
  
  private static int[] e(int paramInt)
  {
    return new int[] { Color.red(paramInt), Color.green(paramInt), Color.blue(paramInt), Color.alpha(paramInt) };
  }
  
  private Rect f()
  {
    Object localObject = this.j;
    if (localObject != null) {
      return localObject;
    }
    localObject = this.i;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = (GeoPoint)this.i.get(0);
      int i3 = ((GeoPoint)localObject).getLatitudeE6();
      int i5 = ((GeoPoint)localObject).getLongitudeE6();
      int i6 = this.i.size();
      int i2 = 1;
      int i4 = i5;
      int i1 = i3;
      while (i2 < i6)
      {
        localObject = (GeoPoint)this.i.get(i2);
        int i7 = ((GeoPoint)localObject).getLatitudeE6();
        int i8 = ((GeoPoint)localObject).getLongitudeE6();
        i5 = Math.min(i5, i8);
        i4 = Math.max(i4, i8);
        i3 = Math.max(i3, i7);
        i1 = Math.min(i1, i7);
        i2 += 1;
      }
      this.j = new Rect(i5, i3, i4, i1);
      return this.j;
    }
    return null;
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
    if (paramInt == kc.c.a) {
      return;
    }
    Object localObject1 = this.q;
    if (localObject1 != null)
    {
      localObject1 = ((pm)localObject1).b.h;
      if ((this.q != null) && (!nl.a(this.t.getText()))) {
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
    }
  }
  
  public final void a(fu paramfu, GL10 paramGL10)
  {
    try
    {
      Object localObject1 = this.q;
      if (localObject1 == null) {
        return;
      }
      boolean bool = this.e;
      int i2 = -1;
      if (!bool)
      {
        this.q.c(this.h.polygonId);
        this.h.polygonId = -1;
        return;
      }
      if (nl.a(this.t.getText()))
      {
        e();
        return;
      }
      localObject1 = this.h;
      int i3 = 0;
      int i1 = i3;
      if (localObject1 != null)
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
        i1 = i3;
        if (Math.abs(paramfu.width()) > 5)
        {
          int i4 = Math.abs(paramfu.height());
          i1 = i3;
          if (i4 > 5) {
            i1 = 1;
          }
        }
      }
      if (i1 == 0) {
        return;
      }
      a(paramGL10);
      if (this.k != null)
      {
        this.k.a(paramGL10);
        paramfu = new StringBuilder();
        paramfu.append(this.k.a());
        this.n = paramfu.toString();
        if (!this.s)
        {
          paramfu = this.q;
          i3 = this.k.a();
          if (this.h == null) {
            i1 = i2;
          } else {
            i1 = this.h.polygonId;
          }
          paramfu = paramfu.b;
          if (paramfu.a != null)
          {
            paramfu = paramfu.a;
            try
            {
              paramfu.y();
              long l1 = paramfu.b;
              if (l1 == 0L) {}
              for (;;)
              {
                paramfu.z();
                break;
                paramfu.a.nativeBringElementAbove(paramfu.b, i3, i1);
              }
              this.s = true;
            }
            finally
            {
              paramfu.z();
            }
          }
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramfu;
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
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      Object localObject = this.i;
      if (localObject == null) {
        this.i = new ArrayList();
      } else {
        ((List)localObject).clear();
      }
      int i3 = paramList.size();
      int i1 = 0;
      while (i1 < i3)
      {
        localObject = (GeoPoint)paramList.get(i1);
        if (localObject != null)
        {
          int i2 = 0;
          while (i2 < i1)
          {
            if (((GeoPoint)localObject).equals((GeoPoint)paramList.get(i2)))
            {
              i2 = 1;
              break label118;
            }
            i2 += 1;
          }
          i2 = 0;
          label118:
          if (i2 == 0)
          {
            this.f = true;
            this.i.add(localObject);
          }
        }
        i1 += 1;
      }
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
    ir localir = this.k;
    if (localir != null)
    {
      paramfu = localir.b(paramfu);
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
    pm localpm = this.q;
    if (localpm == null) {
      return;
    }
    this.e = paramBoolean;
    localpm.b.k();
  }
  
  public final void d()
  {
    e();
  }
  
  public final void h()
  {
    ??? = this.q;
    if (??? == null) {
      return;
    }
    Object localObject2 = ((pm)???).b.c;
    synchronized (((kl)localObject2).e)
    {
      ((kl)localObject2).e.remove(this);
      ??? = this.h;
      if (??? != null) {
        this.q.c(((Polygon2D)???).polygonId);
      }
      ??? = this.i;
      if (??? != null)
      {
        ((List)???).clear();
        this.i = null;
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
        ??? = this.k;
        if (??? != null)
        {
          this.q.b((go)???);
          this.k = null;
        }
        this.r = false;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.mv
 * JD-Core Version:    0.7.0.1
 */