package c.t.m.g;

import com.tencent.map.geolocation.TencentLocation;
import java.util.LinkedList;
import java.util.ListIterator;

public final class eq
{
  private int a = 10;
  private int b = 4;
  private LinkedList<eq.a> c = new LinkedList();
  private dw d = new dw();
  
  private boolean a(eq.a parama, ea paramea)
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
        if (parama.c - ((eq.a)this.c.getLast()).c > 120000L)
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
            eq.a locala = (eq.a)paramea.previous();
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
            el.b().a(1, d2 / j, d1, parama.c);
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
      dw localdw;
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
        localdw = this.d;
        d2 = paramfi.getLatitude();
        d3 = paramfi.getLongitude();
        d1 = paramfi.getAccuracy();
        l3 = paramfi.getTime();
        if (d1 >= 1.0D) {
          break label1206;
        }
        d1 = 1.0D;
        new StringBuilder("lat_me:").append(d2).append(",lng_me:").append(d3).append(",accuracy:").append(d1).append(",time:").append(l3).append(",lat:").append(localdw.d).append(",lng:").append(localdw.e);
        if (l3 - localdw.c >= 20000L)
        {
          localdw.a();
          new StringBuilder("Time:").append(l3).append(",last_time:").append(localdw.c);
        }
        localdw.a = ((float)(Math.abs(d2 - localdw.d) * 1000000.0D));
        localdw.b = ((float)(Math.abs(d3 - localdw.e) * 1000000.0D));
        new StringBuilder("Q:").append(localdw.a).append(",QLng:").append(localdw.b);
        if (localdw.f < 0.0D)
        {
          localdw.c = l3;
          localdw.d = d2;
          localdw.e = d3;
          localdw.f = (d1 * d1);
          d1 = this.d.d;
          d2 = this.d.e;
          paramfi.b.a = (Math.round(d1 * 1000000.0D) / 1000000.0D);
          paramfi.b.b = (Math.round(d2 * 1000000.0D) / 1000000.0D);
          continue;
        }
        l2 = l3 - localdw.c;
      }
      finally {}
      long l2;
      long l1 = l2;
      if (l2 < 1000L) {
        l1 = 1000L;
      }
      if (l1 > 0L)
      {
        localdw.f += l1;
        localdw.g += l1;
      }
      double d4 = localdw.f / (localdw.f + d1 * d1 + localdw.a * 5.0F);
      double d5 = localdw.g / (localdw.g + d1 * d1 + localdw.b * 5.0F);
      new StringBuilder("K:").append(d4).append(",KLng:").append(d5);
      if ((d4 >= 0.4D) && (d5 >= 0.4D))
      {
        double d6 = localdw.d;
        if (((localdw.h > 0.0D) && (d2 - localdw.d > 0.0D)) || ((localdw.h < 0.0D) && (d2 - localdw.d < 0.0D))) {
          localdw.d += localdw.h * (l1 / 1000L);
        }
        localdw.d += (d2 - localdw.d) * d4;
        new StringBuilder("lat:").append(localdw.d).append(",tmp:").append(d6).append(",timeInc:").append(l1);
        localdw.h = ((localdw.d - d6) / (l1 / 1000L));
        d6 = localdw.e;
        if (((localdw.i > 0.0D) && (d3 - localdw.e > 0.0D)) || ((localdw.i < 0.0D) && (d3 - localdw.e < 0.0D))) {
          localdw.e += localdw.i * (l1 / 1000L);
        }
        localdw.e += (d3 - localdw.e) * d5;
        new StringBuilder("lng:").append(localdw.e).append(",tmp:").append(d6).append(",timeInc:").append(l1);
        localdw.i = ((localdw.e - d6) / (l1 / 1000L));
        localdw.f = ((1.0D - d4) * localdw.f);
        localdw.g = ((1.0D - d5) * localdw.g);
        localdw.c = l3;
        new StringBuilder("last_metres_per_second:").append(localdw.h).append(",last_metres_per_second_lng:").append(localdw.i);
      }
      for (;;)
      {
        new StringBuilder("variance:").append(localdw.f).append(",vaLng:").append(localdw.g);
        if ((d1 != 30.0D) || (d4 < 0.5D) || (d5 < 0.5D)) {
          break;
        }
        localdw.d = d2;
        localdw.e = d3;
        localdw.c = l3;
        localdw.h = 0.0D;
        localdw.i = 0.0D;
        localdw.f = (d1 * d1);
        break;
        if (((localdw.h > 0.0D) && (d2 - localdw.d > 0.0D)) || ((localdw.h < 0.0D) && (d2 - localdw.d < 0.0D))) {
          localdw.d += localdw.h * (l1 / 1000L);
        }
        if (((localdw.i > 0.0D) && (d3 - localdw.e > 0.0D)) || ((localdw.i < 0.0D) && (d3 - localdw.e < 0.0D))) {
          localdw.e += localdw.i * (l1 / 1000L);
        }
        localdw.f -= l1;
        localdw.g -= l1;
      }
    }
  }
  
  public final void a(TencentLocation paramTencentLocation)
  {
    try
    {
      this.c.add(eq.a.a(paramTencentLocation));
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
      boolean bool = a(eq.a.a(paramTencentLocation), paramea);
      return bool;
    }
    finally
    {
      paramTencentLocation = finally;
      throw paramTencentLocation;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     c.t.m.g.eq
 * JD-Core Version:    0.7.0.1
 */