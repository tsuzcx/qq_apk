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
    GeoPoint localGeoPoint = this.i.a.m;
    float f2 = this.i.a.b.e;
    float f3 = this.i.a.b.a;
    float f1 = 4.0F;
    Object localObject1 = null;
    Object localObject3;
    Object localObject2;
    int n;
    int m;
    int k;
    int j;
    label122:
    Object localObject4;
    int i1;
    if (f1 >= f3)
    {
      this.i.a(f1);
      localObject1 = this.i;
      localObject3 = this.a;
      localObject2 = this.b;
      n = 0;
      m = 0;
      k = 0;
      j = 0;
      if (localObject3 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        n = 0;
        m = 0;
        k = 0;
        j = 0;
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (gg)((Iterator)localObject3).next();
          if (localObject4 != null)
          {
            localObject4 = ((gg)localObject4).b((fu)localObject1);
            if (localObject4 != null)
            {
              i1 = n;
              if (n == 0) {
                i1 = ((Rect)localObject4).left;
              }
              if (m != 0) {
                break label1309;
              }
              m = ((Rect)localObject4).right;
            }
          }
        }
      }
    }
    label923:
    label1309:
    for (;;)
    {
      if (k == 0) {
        k = ((Rect)localObject4).top;
      }
      for (;;)
      {
        if (j == 0) {
          j = ((Rect)localObject4).bottom;
        }
        for (;;)
        {
          if (((Rect)localObject4).left < i1) {}
          for (n = ((Rect)localObject4).left;; n = i1)
          {
            if (((Rect)localObject4).right > m) {
              m = ((Rect)localObject4).right;
            }
            for (;;)
            {
              if (((Rect)localObject4).top > k) {
                k = ((Rect)localObject4).top;
              }
              for (;;)
              {
                i1 = j;
                if (((Rect)localObject4).bottom < j) {
                  i1 = ((Rect)localObject4).bottom;
                }
                j = i1;
                break label122;
                label310:
                int i4;
                int i3;
                int i2;
                if (localObject2 != null)
                {
                  localObject1 = ((List)localObject2).iterator();
                  do
                  {
                    i4 = j;
                    i3 = k;
                    i2 = m;
                    i1 = n;
                    if (!((Iterator)localObject1).hasNext()) {
                      break;
                    }
                    localObject2 = (GeoPoint)((Iterator)localObject1).next();
                  } while (localObject2 == null);
                  if (n != 0) {
                    break label1287;
                  }
                  n = ((GeoPoint)localObject2).getLongitudeE6();
                }
                for (;;)
                {
                  if (m == 0) {
                    m = ((GeoPoint)localObject2).getLongitudeE6();
                  }
                  for (;;)
                  {
                    if (k == 0) {
                      k = ((GeoPoint)localObject2).getLatitudeE6();
                    }
                    for (;;)
                    {
                      if (j == 0) {
                        j = ((GeoPoint)localObject2).getLatitudeE6();
                      }
                      for (;;)
                      {
                        if (((GeoPoint)localObject2).getLongitudeE6() < n) {
                          n = ((GeoPoint)localObject2).getLongitudeE6();
                        }
                        for (;;)
                        {
                          if (((GeoPoint)localObject2).getLongitudeE6() > m) {
                            m = ((GeoPoint)localObject2).getLongitudeE6();
                          }
                          for (;;)
                          {
                            if (((GeoPoint)localObject2).getLatitudeE6() > k) {
                              k = ((GeoPoint)localObject2).getLatitudeE6();
                            }
                            for (;;)
                            {
                              if (((GeoPoint)localObject2).getLatitudeE6() < j) {
                                j = ((GeoPoint)localObject2).getLatitudeE6();
                              }
                              for (;;)
                              {
                                break label310;
                                i1 = n;
                                i2 = m;
                                i3 = k;
                                i4 = j;
                                localObject3 = new Rect(i1, i3, i2, i4);
                                localObject2 = new GeoPoint(((Rect)localObject3).centerY(), ((Rect)localObject3).centerX());
                                this.i.b((GeoPoint)localObject2);
                                localObject1 = new GeoPoint(((Rect)localObject3).top, ((Rect)localObject3).left);
                                localObject3 = new GeoPoint(((Rect)localObject3).bottom, ((Rect)localObject3).right);
                                localObject1 = this.i.a((GeoPoint)localObject1);
                                localObject3 = this.i.a((GeoPoint)localObject3);
                                localObject4 = new Rect();
                                ((Rect)localObject4).left = ((int)Math.min(((DoublePoint)localObject1).x, ((DoublePoint)localObject3).x));
                                ((Rect)localObject4).right = ((int)Math.max(((DoublePoint)localObject1).x, ((DoublePoint)localObject3).x));
                                ((Rect)localObject4).top = ((int)Math.min(((DoublePoint)localObject1).y, ((DoublePoint)localObject3).y));
                                ((Rect)localObject4).bottom = ((int)Math.max(((DoublePoint)localObject1).y, ((DoublePoint)localObject3).y));
                                if ((this.c >= ((Rect)localObject4).width()) && (this.d >= ((Rect)localObject4).height()))
                                {
                                  localObject1 = this.i.a.r;
                                  if ((localObject1 != null) && ((((kc.b)localObject1).a != 0.0F) || (((kc.b)localObject1).b != 0.0F)))
                                  {
                                    j = 1;
                                    if (j != 0) {
                                      break label929;
                                    }
                                    localObject1 = this.i;
                                    localObject3 = this.e;
                                    localObject2 = ((kb)localObject1).a((GeoPoint)localObject2);
                                    if ((localObject2 == null) || (localObject3 == null)) {
                                      break label923;
                                    }
                                    localObject1 = ((kb)localObject1).a(new DoublePoint(((DoublePoint)localObject2).x - (((Rect)localObject3).left - ((Rect)localObject3).right) * 0.5D, ((DoublePoint)localObject2).y - (((Rect)localObject3).top - ((Rect)localObject3).bottom) * 0.5D));
                                  }
                                  for (;;)
                                  {
                                    f1 = Math.max(f3, f1);
                                    if (this.f != 60)
                                    {
                                      localObject2 = this.g;
                                      j = this.f;
                                      if (j > 0) {
                                        ((kf)localObject2).b = j;
                                      }
                                    }
                                    this.i.b(localGeoPoint);
                                    this.i.a(f2);
                                    if (this.h != null) {}
                                    try
                                    {
                                      this.h.a(f1, (GeoPoint)localObject1);
                                      return;
                                    }
                                    catch (Exception localException)
                                    {
                                      double d2;
                                      double d3;
                                      float f4;
                                      float f5;
                                      double d1;
                                      localException.printStackTrace();
                                      return;
                                    }
                                    j = 0;
                                    break;
                                    localObject1 = null;
                                    continue;
                                    label929:
                                    localObject1 = this.i.a.r;
                                    if ((localObject1 != null) && ((Math.abs(((kc.b)localObject1).a) > 0.25D) || (Math.abs(((kc.b)localObject1).b) > 0.25D)))
                                    {
                                      j = 1;
                                      label981:
                                      localObject1 = localObject2;
                                      if (j == 0) {
                                        continue;
                                      }
                                      localObject3 = this.i.a.r;
                                      localObject1 = localObject2;
                                      if (localObject3 == null) {
                                        continue;
                                      }
                                      localObject1 = this.i;
                                      localObject2 = ((kb)localObject1).a((GeoPoint)localObject2);
                                      if ((localObject2 == null) || (localObject3 == null)) {
                                        break label1238;
                                      }
                                      d2 = ((DoublePoint)localObject2).x;
                                      d3 = ((DoublePoint)localObject2).y;
                                      localObject2 = new Rect(((kb)localObject1).b.i);
                                      j = ((Rect)localObject2).width();
                                      k = ((Rect)localObject2).height();
                                      f4 = ((kc.b)localObject3).a + 0.5F;
                                      f5 = ((kc.b)localObject3).b + 0.5F;
                                      if (f4 >= 0.25D) {
                                        break label1176;
                                      }
                                      d1 = d2 + (0.25D - f4) * j;
                                      label1124:
                                      if (f5 >= 0.25D) {
                                        break label1205;
                                      }
                                      d2 = f5;
                                      d2 = d3 + k * (0.25D - d2);
                                    }
                                    for (;;)
                                    {
                                      localObject1 = ((kb)localObject1).a(new DoublePoint(d1, d2));
                                      break;
                                      j = 0;
                                      break label981;
                                      d1 = d2;
                                      if (f4 <= 0.75D) {
                                        break label1124;
                                      }
                                      d1 = d2 - (f4 - 0.75D) * j;
                                      break label1124;
                                      label1205:
                                      d2 = d3;
                                      if (f5 > 0.75D)
                                      {
                                        d2 = f5;
                                        d2 = d3 - k * (d2 - 0.75D);
                                      }
                                    }
                                    label1238:
                                    localObject1 = null;
                                  }
                                }
                                f1 /= 1.01F;
                                localObject1 = localObject2;
                                break;
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.kb.1
 * JD-Core Version:    0.7.0.1
 */