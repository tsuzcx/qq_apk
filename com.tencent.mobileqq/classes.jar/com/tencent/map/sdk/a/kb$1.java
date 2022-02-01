package com.tencent.map.sdk.a;

import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import java.util.Iterator;
import java.util.List;

final class kb$1
  implements lw.a
{
  kb$1(kb paramkb, List paramList1, List paramList2, int paramInt1, int paramInt2, Rect paramRect, int paramInt3, kf paramkf, kb.a parama) {}
  
  public final void a()
  {
    Object localObject1 = this;
    Object localObject2 = ((1)localObject1).i.a.m;
    float f2 = ((1)localObject1).i.a.b.e;
    float f3 = ((1)localObject1).i.a.b.a;
    kb localkb = null;
    Object localObject3 = null;
    float f1 = 4.0F;
    localObject1 = null;
    for (;;)
    {
      Object localObject4 = this;
      if (f1 < f3) {
        break;
      }
      ((1)localObject4).i.a(f1);
      localObject1 = ((1)localObject4).i;
      Object localObject6 = ((1)localObject4).a;
      Object localObject5 = ((1)localObject4).b;
      int m;
      int k;
      if (localObject6 != null)
      {
        localObject6 = ((List)localObject6).iterator();
        i4 = 0;
        m = 0;
        k = 0;
        j = 0;
        for (;;)
        {
          n = i4;
          i1 = m;
          i2 = k;
          i3 = j;
          if (!((Iterator)localObject6).hasNext()) {
            break;
          }
          localObject7 = (gg)((Iterator)localObject6).next();
          if (localObject7 != null)
          {
            localObject7 = ((gg)localObject7).b((fu)localObject1);
            if (localObject7 != null)
            {
              i1 = i4;
              if (i4 == 0) {
                i1 = ((Rect)localObject7).left;
              }
              i2 = m;
              if (m == 0) {
                i2 = ((Rect)localObject7).right;
              }
              m = k;
              if (k == 0) {
                m = ((Rect)localObject7).top;
              }
              i3 = j;
              if (j == 0) {
                i3 = ((Rect)localObject7).bottom;
              }
              n = i1;
              if (((Rect)localObject7).left < i1) {
                n = ((Rect)localObject7).left;
              }
              i1 = i2;
              if (((Rect)localObject7).right > i2) {
                i1 = ((Rect)localObject7).right;
              }
              i2 = m;
              if (((Rect)localObject7).top > m) {
                i2 = ((Rect)localObject7).top;
              }
              i4 = n;
              m = i1;
              k = i2;
              j = i3;
              if (((Rect)localObject7).bottom < i3)
              {
                j = ((Rect)localObject7).bottom;
                i4 = n;
                m = i1;
                k = i2;
              }
            }
          }
        }
      }
      int n = 0;
      int i1 = 0;
      int i2 = 0;
      int i3 = 0;
      int i4 = n;
      int i5 = i1;
      int i6 = i2;
      int i7 = i3;
      if (localObject5 != null)
      {
        localObject1 = ((List)localObject5).iterator();
        j = i3;
        k = i2;
        m = i1;
        for (;;)
        {
          i4 = n;
          i5 = m;
          i6 = k;
          i7 = j;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject5 = (GeoPoint)((Iterator)localObject1).next();
          if (localObject5 != null)
          {
            i2 = n;
            if (n == 0) {
              i2 = ((GeoPoint)localObject5).getLongitudeE6();
            }
            n = m;
            if (m == 0) {
              n = ((GeoPoint)localObject5).getLongitudeE6();
            }
            m = k;
            if (k == 0) {
              m = ((GeoPoint)localObject5).getLatitudeE6();
            }
            i4 = j;
            if (j == 0) {
              i4 = ((GeoPoint)localObject5).getLatitudeE6();
            }
            i1 = i2;
            if (((GeoPoint)localObject5).getLongitudeE6() < i2) {
              i1 = ((GeoPoint)localObject5).getLongitudeE6();
            }
            i2 = n;
            if (((GeoPoint)localObject5).getLongitudeE6() > n) {
              i2 = ((GeoPoint)localObject5).getLongitudeE6();
            }
            i3 = m;
            if (((GeoPoint)localObject5).getLatitudeE6() > m) {
              i3 = ((GeoPoint)localObject5).getLatitudeE6();
            }
            n = i1;
            m = i2;
            k = i3;
            j = i4;
            if (((GeoPoint)localObject5).getLatitudeE6() < i4)
            {
              j = ((GeoPoint)localObject5).getLatitudeE6();
              n = i1;
              m = i2;
              k = i3;
            }
          }
        }
      }
      localObject6 = new Rect(i4, i6, i5, i7);
      localObject1 = new GeoPoint(((Rect)localObject6).centerY(), ((Rect)localObject6).centerX());
      ((1)localObject4).i.b((GeoPoint)localObject1);
      localObject5 = new GeoPoint(((Rect)localObject6).top, ((Rect)localObject6).left);
      localObject6 = new GeoPoint(((Rect)localObject6).bottom, ((Rect)localObject6).right);
      localObject5 = ((1)localObject4).i.a((GeoPoint)localObject5);
      localObject6 = ((1)localObject4).i.a((GeoPoint)localObject6);
      Object localObject7 = new Rect();
      ((Rect)localObject7).left = ((int)Math.min(((DoublePoint)localObject5).x, ((DoublePoint)localObject6).x));
      ((Rect)localObject7).right = ((int)Math.max(((DoublePoint)localObject5).x, ((DoublePoint)localObject6).x));
      ((Rect)localObject7).top = ((int)Math.min(((DoublePoint)localObject5).y, ((DoublePoint)localObject6).y));
      ((Rect)localObject7).bottom = ((int)Math.max(((DoublePoint)localObject5).y, ((DoublePoint)localObject6).y));
      if ((((1)localObject4).c >= ((Rect)localObject7).width()) && (((1)localObject4).d >= ((Rect)localObject7).height()))
      {
        localObject5 = ((1)localObject4).i.a.r;
        k = 1;
        if ((localObject5 != null) && ((((kc.b)localObject5).a != 0.0F) || (((kc.b)localObject5).b != 0.0F))) {
          j = 1;
        } else {
          j = 0;
        }
        double d1;
        double d2;
        double d3;
        double d4;
        if (j == 0)
        {
          localkb = ((1)localObject4).i;
          localObject4 = ((1)localObject4).e;
          localObject5 = localkb.a((GeoPoint)localObject1);
          localObject1 = localObject3;
          if (localObject5 != null)
          {
            localObject1 = localObject3;
            if (localObject4 != null)
            {
              d1 = ((DoublePoint)localObject5).x;
              d2 = ((Rect)localObject4).left - ((Rect)localObject4).right;
              Double.isNaN(d2);
              d3 = ((DoublePoint)localObject5).y;
              d4 = ((Rect)localObject4).top - ((Rect)localObject4).bottom;
              Double.isNaN(d4);
              localObject1 = localkb.a(new DoublePoint(d1 - d2 * 0.5D, d3 - d4 * 0.5D));
            }
          }
          break;
        }
        localObject3 = ((1)localObject4).i.a.r;
        if (localObject3 != null)
        {
          j = k;
          if (Math.abs(((kc.b)localObject3).a) > 0.25D) {
            break label1098;
          }
          if (Math.abs(((kc.b)localObject3).b) > 0.25D)
          {
            j = k;
            break label1098;
          }
        }
        j = 0;
        label1098:
        if (j != 0)
        {
          localObject3 = ((1)localObject4).i.a.r;
          if (localObject3 != null)
          {
            localObject4 = ((1)localObject4).i;
            localObject1 = ((kb)localObject4).a((GeoPoint)localObject1);
            if ((localObject1 != null) && (localObject3 != null))
            {
              d2 = ((DoublePoint)localObject1).x;
              d3 = ((DoublePoint)localObject1).y;
              localObject1 = new Rect(((kb)localObject4).b.i);
              j = ((Rect)localObject1).width();
              k = ((Rect)localObject1).height();
              float f4 = ((kc.b)localObject3).a;
              float f5 = ((kc.b)localObject3).b;
              d4 = f4 + 0.5F;
              if (d4 < 0.25D)
              {
                Double.isNaN(d4);
                d1 = j;
                Double.isNaN(d1);
                d1 = d2 + (0.25D - d4) * d1;
              }
              else
              {
                d1 = d2;
                if (d4 > 0.75D)
                {
                  Double.isNaN(d4);
                  d1 = j;
                  Double.isNaN(d1);
                  d1 = d2 - (d4 - 0.75D) * d1;
                }
              }
              d4 = f5 + 0.5F;
              if (d4 < 0.25D)
              {
                Double.isNaN(d4);
                d2 = k;
                Double.isNaN(d2);
                d2 = d3 + (0.25D - d4) * d2;
              }
              else
              {
                d2 = d3;
                if (d4 > 0.75D)
                {
                  Double.isNaN(d4);
                  d2 = k;
                  Double.isNaN(d2);
                  d2 = d3 - (d4 - 0.75D) * d2;
                }
              }
              localObject1 = ((kb)localObject4).a(new DoublePoint(d1, d2));
            }
            else
            {
              localObject1 = localkb;
            }
            break;
          }
        }
        break;
      }
      f1 /= 1.01F;
    }
    f1 = Math.max(f3, f1);
    int j = this.f;
    if (j != 60)
    {
      localObject3 = this.g;
      if (j > 0) {
        ((kf)localObject3).b = j;
      }
    }
    this.i.b((GeoPoint)localObject2);
    this.i.a(f2);
    localObject2 = this.h;
    if (localObject2 != null) {
      try
      {
        ((kb.a)localObject2).a(f1, (GeoPoint)localObject1);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.kb.1
 * JD-Core Version:    0.7.0.1
 */