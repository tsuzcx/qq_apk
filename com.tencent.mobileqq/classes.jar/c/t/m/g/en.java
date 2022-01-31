package c.t.m.g;

import com.tencent.map.geolocation.TencentLocation;
import java.util.LinkedList;
import java.util.ListIterator;

public final class en
{
  private int a = 10;
  private int b = 4;
  private LinkedList<en.a> c = new LinkedList();
  private dt d = new dt();
  
  private boolean a(en.a parama, dx paramdx)
  {
    if (paramdx != null) {}
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
        if ((parama.d == 1) && (!fn.a(paramdx)) && (!fn.b(paramdx)))
        {
          bool = true;
          continue;
        }
        if (parama.c - ((en.a)this.c.getLast()).c > 120000L)
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
          paramdx = this.c.listIterator(this.c.size());
          if (paramdx.hasPrevious())
          {
            en.a locala = (en.a)paramdx.previous();
            d1 = fm.a(locala.a, locala.b, parama.a, parama.b) / ((Math.abs(locala.c - parama.c) + 1L) / 1000.0D);
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
            ei.b().a(1, d2 / j, d1, parama.c);
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
  
  public final void a(ff paramff)
  {
    label1206:
    for (;;)
    {
      dt localdt;
      double d2;
      double d3;
      double d1;
      long l3;
      try
      {
        if (paramff.getProvider().equalsIgnoreCase("gps"))
        {
          boolean bool = cz.a().d("gps_kalman");
          if (!bool) {
            return;
          }
        }
        if ((this.c == null) || ((this.c != null) && (this.c.size() == 0))) {
          continue;
        }
        localdt = this.d;
        d2 = paramff.getLatitude();
        d3 = paramff.getLongitude();
        d1 = paramff.getAccuracy();
        l3 = paramff.getTime();
        if (d1 >= 1.0D) {
          break label1206;
        }
        d1 = 1.0D;
        new StringBuilder("lat_me:").append(d2).append(",lng_me:").append(d3).append(",accuracy:").append(d1).append(",time:").append(l3).append(",lat:").append(localdt.d).append(",lng:").append(localdt.e);
        if (l3 - localdt.c >= 20000L)
        {
          localdt.a();
          new StringBuilder("Time:").append(l3).append(",last_time:").append(localdt.c);
        }
        localdt.a = ((float)(Math.abs(d2 - localdt.d) * 1000000.0D));
        localdt.b = ((float)(Math.abs(d3 - localdt.e) * 1000000.0D));
        new StringBuilder("Q:").append(localdt.a).append(",QLng:").append(localdt.b);
        if (localdt.f < 0.0D)
        {
          localdt.c = l3;
          localdt.d = d2;
          localdt.e = d3;
          localdt.f = (d1 * d1);
          d1 = this.d.d;
          d2 = this.d.e;
          paramff.b.a = (Math.round(d1 * 1000000.0D) / 1000000.0D);
          paramff.b.b = (Math.round(d2 * 1000000.0D) / 1000000.0D);
          continue;
        }
        l2 = l3 - localdt.c;
      }
      finally {}
      long l2;
      long l1 = l2;
      if (l2 < 1000L) {
        l1 = 1000L;
      }
      if (l1 > 0L)
      {
        localdt.f += l1;
        localdt.g += l1;
      }
      double d4 = localdt.f / (localdt.f + d1 * d1 + localdt.a * 5.0F);
      double d5 = localdt.g / (localdt.g + d1 * d1 + localdt.b * 5.0F);
      new StringBuilder("K:").append(d4).append(",KLng:").append(d5);
      if ((d4 >= 0.4D) && (d5 >= 0.4D))
      {
        double d6 = localdt.d;
        if (((localdt.h > 0.0D) && (d2 - localdt.d > 0.0D)) || ((localdt.h < 0.0D) && (d2 - localdt.d < 0.0D))) {
          localdt.d += localdt.h * (l1 / 1000L);
        }
        localdt.d += (d2 - localdt.d) * d4;
        new StringBuilder("lat:").append(localdt.d).append(",tmp:").append(d6).append(",timeInc:").append(l1);
        localdt.h = ((localdt.d - d6) / (l1 / 1000L));
        d6 = localdt.e;
        if (((localdt.i > 0.0D) && (d3 - localdt.e > 0.0D)) || ((localdt.i < 0.0D) && (d3 - localdt.e < 0.0D))) {
          localdt.e += localdt.i * (l1 / 1000L);
        }
        localdt.e += (d3 - localdt.e) * d5;
        new StringBuilder("lng:").append(localdt.e).append(",tmp:").append(d6).append(",timeInc:").append(l1);
        localdt.i = ((localdt.e - d6) / (l1 / 1000L));
        localdt.f = ((1.0D - d4) * localdt.f);
        localdt.g = ((1.0D - d5) * localdt.g);
        localdt.c = l3;
        new StringBuilder("last_metres_per_second:").append(localdt.h).append(",last_metres_per_second_lng:").append(localdt.i);
      }
      for (;;)
      {
        new StringBuilder("variance:").append(localdt.f).append(",vaLng:").append(localdt.g);
        if ((d1 != 30.0D) || (d4 < 0.5D) || (d5 < 0.5D)) {
          break;
        }
        localdt.d = d2;
        localdt.e = d3;
        localdt.c = l3;
        localdt.h = 0.0D;
        localdt.i = 0.0D;
        localdt.f = (d1 * d1);
        break;
        if (((localdt.h > 0.0D) && (d2 - localdt.d > 0.0D)) || ((localdt.h < 0.0D) && (d2 - localdt.d < 0.0D))) {
          localdt.d += localdt.h * (l1 / 1000L);
        }
        if (((localdt.i > 0.0D) && (d3 - localdt.e > 0.0D)) || ((localdt.i < 0.0D) && (d3 - localdt.e < 0.0D))) {
          localdt.e += localdt.i * (l1 / 1000L);
        }
        localdt.f -= l1;
        localdt.g -= l1;
      }
    }
  }
  
  public final void a(TencentLocation paramTencentLocation)
  {
    try
    {
      this.c.add(en.a.a(paramTencentLocation));
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
  
  public final boolean a(TencentLocation paramTencentLocation, dx paramdx)
  {
    try
    {
      boolean bool = a(en.a.a(paramTencentLocation), paramdx);
      return bool;
    }
    finally
    {
      paramTencentLocation = finally;
      throw paramTencentLocation;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.en
 * JD-Core Version:    0.7.0.1
 */