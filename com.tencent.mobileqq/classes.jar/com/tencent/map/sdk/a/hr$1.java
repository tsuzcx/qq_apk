package com.tencent.map.sdk.a;

import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.tencentmap.mapsdk.maps.model.MapPoi;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class hr$1
  implements Runnable
{
  hr$1(hr paramhr) {}
  
  public final void run()
  {
    hr.a(this.a).clear();
    hr.b(this.a).clear();
    hr.c(this.a).clear();
    if (hr.d(this.a) != null)
    {
      Object localObject1 = hr.d(this.a);
      ((pn)localObject1).aw.clear();
      Object localObject2 = kd.b(((pt)localObject1).az.b.h.a(new DoublePoint(0.0D, 0.0D)));
      Object localObject3 = kd.b(((pt)localObject1).az.b.h.a(new DoublePoint(((pn)localObject1).getWidth(), ((pn)localObject1).getHeight())));
      Object localObject4 = ((pn)localObject1).i.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (mu)((Iterator)localObject4).next();
        if ((localObject5 instanceof ms))
        {
          localObject5 = (ms)localObject5;
          if (pn.a(((ms)localObject5).G.getPosition(), new fw[] { localObject2, localObject3 })) {
            ((pn)localObject1).aw.add(localObject5);
          }
        }
      }
      localObject4 = ((pn)localObject1).aw;
      Object localObject5 = hr.d(this.a);
      ((pn)localObject5).ax.clear();
      localObject1 = ((pt)localObject5).az;
      lw locallw = ((pm)localObject1).b;
      localObject3 = null;
      localObject2 = null;
      if (locallw == null) {}
      do
      {
        localObject1 = null;
        break;
        localObject1 = ((pm)localObject1).b;
      } while (((lw)localObject1).a == null);
      localObject1 = ((lw)localObject1).a.w();
      ((pn)localObject5).ax = ((List)localObject1);
      localObject5 = ((pn)localObject5).ax;
      localObject1 = localObject3;
      if (localObject4 != null)
      {
        localObject3 = ((List)localObject4).iterator();
        localObject1 = localObject2;
        while (((Iterator)localObject3).hasNext())
        {
          localObject2 = (ms)((Iterator)localObject3).next();
          localObject4 = ((ms)localObject2).k();
          if (!nl.a((String)localObject4)) {
            if (((String)localObject4).startsWith("我的位置")) {
              localObject1 = localObject2;
            } else {
              hr.b(this.a).add(new hs(hr.d(this.a), (ms)localObject2));
            }
          }
        }
        Collections.sort(hr.b(this.a));
        hr.a(this.a).addAll(hr.b(this.a));
      }
      if (localObject5 != null)
      {
        localObject2 = ((List)localObject5).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (MapPoi)((Iterator)localObject2).next();
          if (!nl.a(((MapPoi)localObject3).getName())) {
            hr.c(this.a).add(new ht(hr.d(this.a), (MapPoi)localObject3));
          }
        }
        Collections.sort(hr.c(this.a));
        hr.a(this.a).addAll(hr.c(this.a));
      }
      if (localObject1 != null) {
        hr.a(this.a).add(new hs(hr.d(this.a), (ms)localObject1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.hr.1
 * JD-Core Version:    0.7.0.1
 */