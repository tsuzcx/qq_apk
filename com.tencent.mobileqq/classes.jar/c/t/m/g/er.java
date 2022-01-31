package c.t.m.g;

import com.tencent.map.geolocation.TencentLocation;
import java.util.LinkedList;
import java.util.ListIterator;

public final class er
{
  private int a = 10;
  private int b = 4;
  private LinkedList<er.a> c = new LinkedList();
  private dv d = new dv();
  
  private boolean a(er.a parama, ea paramea)
  {
    if (paramea != null) {}
    for (;;)
    {
      int i;
      boolean bool;
      try
      {
        if (this.c != null)
        {
          i = this.c.size();
          if (i != 0) {}
        }
        else
        {
          bool = true;
          return bool;
        }
        if (parama.d == 3)
        {
          bool = true;
          continue;
        }
        if ((parama.d == 1) && (!fq.a(paramea)) && (!fq.b(paramea)))
        {
          bool = true;
          continue;
        }
        if (parama.c - ((er.a)this.c.getLast()).c > 120000L)
        {
          this.c.clear();
          bool = true;
          continue;
        }
        if (this.c.size() < this.b) {
          break label314;
        }
        i = 1;
        if (i != 0)
        {
          i = 0;
          int j = 0;
          double d2 = 0.0D;
          double d1 = 0.0D;
          paramea = this.c.listIterator(this.c.size());
          if (paramea.hasPrevious())
          {
            er.a locala = (er.a)paramea.previous();
            d1 = fp.a(locala.a, locala.b, parama.a, parama.b) / ((Math.abs(locala.c - parama.c) + 1L) / 1000.0D);
            d2 += d1;
            if (d1 <= 50.0D) {
              break label299;
            }
            i += 1;
            j += 1;
            if (j <= this.b) {
              break label296;
            }
            break label302;
            em.b().a(1, d2 / j, d1, parama.c);
          }
        }
        else
        {
          bool = true;
          continue;
        }
      }
      finally {}
      label296:
      continue;
      label299:
      continue;
      label302:
      if (i > 1)
      {
        bool = false;
        continue;
        label314:
        i = 0;
      }
    }
  }
  
  public final void a()
  {
    try
    {
      this.c.clear();
      this.d.a();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(fi paramfi)
  {
    label1206:
    for (;;)
    {
      dv localdv;
      double d2;
      double d3;
      double d1;
      long l3;
      try
      {
        if (paramfi.getProvider().equalsIgnoreCase("gps"))
        {
          boolean bool = da.a().d("gps_kalman");
          if (!bool) {
            return;
          }
        }
        if ((this.c == null) || ((this.c != null) && (this.c.size() == 0))) {
          continue;
        }
        localdv = this.d;
        d2 = paramfi.getLatitude();
        d3 = paramfi.getLongitude();
        d1 = paramfi.getAccuracy();
        l3 = paramfi.getTime();
        if (d1 >= 1.0D) {
          break label1206;
        }
        d1 = 1.0D;
        new StringBuilder("lat_me:").append(d2).append(",lng_me:").append(d3).append(",accuracy:").append(d1).append(",time:").append(l3).append(",lat:").append(localdv.d).append(",lng:").append(localdv.e);
        if (l3 - localdv.c >= 20000L)
        {
          localdv.a();
          new StringBuilder("Time:").append(l3).append(",last_time:").append(localdv.c);
        }
        localdv.a = ((float)(Math.abs(d2 - localdv.d) * 1000000.0D));
        localdv.b = ((float)(Math.abs(d3 - localdv.e) * 1000000.0D));
        new StringBuilder("Q:").append(localdv.a).append(",QLng:").append(localdv.b);
        if (localdv.f < 0.0D)
        {
          localdv.c = l3;
          localdv.d = d2;
          localdv.e = d3;
          localdv.f = (d1 * d1);
          d1 = this.d.d;
          d2 = this.d.e;
          paramfi.b.a = (Math.round(d1 * 1000000.0D) / 1000000.0D);
          paramfi.b.b = (Math.round(d2 * 1000000.0D) / 1000000.0D);
          continue;
        }
        l2 = l3 - localdv.c;
      }
      finally {}
      long l2;
      long l1 = l2;
      if (l2 < 1000L) {
        l1 = 1000L;
      }
      if (l1 > 0L)
      {
        localdv.f += l1;
        localdv.g += l1;
      }
      double d4 = localdv.f / (localdv.f + d1 * d1 + localdv.a * 5.0F);
      double d5 = localdv.g / (localdv.g + d1 * d1 + localdv.b * 5.0F);
      new StringBuilder("K:").append(d4).append(",KLng:").append(d5);
      if ((d4 >= 0.4D) && (d5 >= 0.4D))
      {
        double d6 = localdv.d;
        if (((localdv.h > 0.0D) && (d2 - localdv.d > 0.0D)) || ((localdv.h < 0.0D) && (d2 - localdv.d < 0.0D))) {
          localdv.d += localdv.h * (l1 / 1000L);
        }
        localdv.d += (d2 - localdv.d) * d4;
        new StringBuilder("lat:").append(localdv.d).append(",tmp:").append(d6).append(",timeInc:").append(l1);
        localdv.h = ((localdv.d - d6) / (l1 / 1000L));
        d6 = localdv.e;
        if (((localdv.i > 0.0D) && (d3 - localdv.e > 0.0D)) || ((localdv.i < 0.0D) && (d3 - localdv.e < 0.0D))) {
          localdv.e += localdv.i * (l1 / 1000L);
        }
        localdv.e += (d3 - localdv.e) * d5;
        new StringBuilder("lng:").append(localdv.e).append(",tmp:").append(d6).append(",timeInc:").append(l1);
        localdv.i = ((localdv.e - d6) / (l1 / 1000L));
        localdv.f = ((1.0D - d4) * localdv.f);
        localdv.g = ((1.0D - d5) * localdv.g);
        localdv.c = l3;
        new StringBuilder("last_metres_per_second:").append(localdv.h).append(",last_metres_per_second_lng:").append(localdv.i);
      }
      for (;;)
      {
        new StringBuilder("variance:").append(localdv.f).append(",vaLng:").append(localdv.g);
        if ((d1 != 30.0D) || (d4 < 0.5D) || (d5 < 0.5D)) {
          break;
        }
        localdv.d = d2;
        localdv.e = d3;
        localdv.c = l3;
        localdv.h = 0.0D;
        localdv.i = 0.0D;
        localdv.f = (d1 * d1);
        break;
        if (((localdv.h > 0.0D) && (d2 - localdv.d > 0.0D)) || ((localdv.h < 0.0D) && (d2 - localdv.d < 0.0D))) {
          localdv.d += localdv.h * (l1 / 1000L);
        }
        if (((localdv.i > 0.0D) && (d3 - localdv.e > 0.0D)) || ((localdv.i < 0.0D) && (d3 - localdv.e < 0.0D))) {
          localdv.e += localdv.i * (l1 / 1000L);
        }
        localdv.f -= l1;
        localdv.g -= l1;
      }
    }
  }
  
  public final void a(TencentLocation paramTencentLocation)
  {
    try
    {
      this.c.add(er.a.a(paramTencentLocation));
      if (this.c.size() > this.a) {
        this.c.removeFirst();
      }
      return;
    }
    finally
    {
      paramTencentLocation = finally;
      throw paramTencentLocation;
    }
  }
  
  public final boolean a(TencentLocation paramTencentLocation, ea paramea)
  {
    try
    {
      boolean bool = a(er.a.a(paramTencentLocation), paramea);
      return bool;
    }
    finally
    {
      paramTencentLocation = finally;
      throw paramTencentLocation;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.er
 * JD-Core Version:    0.7.0.1
 */