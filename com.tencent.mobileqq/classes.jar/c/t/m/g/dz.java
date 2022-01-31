package c.t.m.g;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationUtils;
import java.util.LinkedList;
import java.util.ListIterator;

public final class dz
{
  private int a = 10;
  private int b = 4;
  private LinkedList<a> c = new LinkedList();
  private dm d = new dm();
  
  private boolean a(a parama, de paramde)
  {
    if (paramde != null) {}
    for (;;)
    {
      try
      {
        boolean bool;
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
        if ((parama.d == 1) && (!ex.a(paramde)) && (!ex.b(paramde)))
        {
          bool = true;
          continue;
        }
        if (parama.c - ((a)this.c.getLast()).c > 120000L)
        {
          this.c.clear();
          bool = true;
          continue;
        }
        if (this.c.size() < this.b) {
          break label328;
        }
        i = 1;
        if (i != 0)
        {
          i = 0;
          int j = 0;
          double d2 = 0.0D;
          double d1 = 0.0D;
          paramde = this.c.listIterator(this.c.size());
          if (paramde.hasPrevious())
          {
            a locala = (a)paramde.previous();
            d1 = ev.a(locala.a, locala.b, parama.a, parama.b) / ((Math.abs(locala.c - parama.c) + 1L) / 1000.0D);
            d2 += d1;
            if (d1 <= 50.0D) {
              break label325;
            }
            i += 1;
            j += 1;
            if (j <= this.b) {
              break label322;
            }
            if (i > 1)
            {
              ev.a("TxTrace", 6, "badPoints=".concat(String.valueOf(i)));
              bool = false;
              continue;
            }
            dt.b().a(1, d2 / j, d1, parama.c);
          }
        }
        else
        {
          bool = true;
          continue;
        }
        continue;
      }
      finally {}
      label322:
      continue;
      label325:
      continue;
      label328:
      int i = 0;
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
  
  public final void a(eq parameq)
  {
    label1267:
    for (;;)
    {
      dm localdm;
      double d2;
      double d3;
      double d1;
      long l3;
      try
      {
        if (parameq.getProvider().equalsIgnoreCase("gps"))
        {
          boolean bool = dc.a().d("gps_kalman");
          if (!bool) {
            return;
          }
        }
        if ((this.c == null) || ((this.c != null) && (this.c.size() == 0))) {
          continue;
        }
        localdm = this.d;
        d2 = parameq.getLatitude();
        d3 = parameq.getLongitude();
        d1 = parameq.getAccuracy();
        l3 = parameq.getTime();
        if (d1 >= 1.0D) {
          break label1267;
        }
        d1 = 1.0D;
        ev.b("a", "lat_me:" + d2 + ",lng_me:" + d3 + ",accuracy:" + d1 + ",time:" + l3 + ",lat:" + localdm.d + ",lng:" + localdm.e);
        if (l3 - localdm.c >= 20000L)
        {
          localdm.a();
          ev.b("a", "Time:" + l3 + ",last_time:" + localdm.c);
        }
        localdm.a = ((float)(Math.abs(d2 - localdm.d) * 1000000.0D));
        localdm.b = ((float)(Math.abs(d3 - localdm.e) * 1000000.0D));
        ev.b("a", "Q:" + localdm.a + ",QLng:" + localdm.b);
        if (localdm.f < 0.0D)
        {
          localdm.c = l3;
          localdm.d = d2;
          localdm.e = d3;
          localdm.f = (d1 * d1);
          d1 = this.d.d;
          d2 = this.d.e;
          parameq.b.a = (Math.round(d1 * 1000000.0D) / 1000000.0D);
          parameq.b.b = (Math.round(d2 * 1000000.0D) / 1000000.0D);
          continue;
        }
        l2 = l3 - localdm.c;
      }
      finally {}
      long l2;
      long l1 = l2;
      if (l2 < 1000L) {
        l1 = 1000L;
      }
      if (l1 > 0L)
      {
        localdm.f += l1;
        localdm.g += l1;
      }
      double d4 = localdm.f / (localdm.f + d1 * d1 + localdm.a * 5.0F);
      double d5 = localdm.g / (localdm.g + d1 * d1 + localdm.b * 5.0F);
      ev.b("a", "K:" + d4 + ",KLng:" + d5);
      if ((d4 >= 0.4D) && (d5 >= 0.4D))
      {
        double d6 = localdm.d;
        if (((localdm.h > 0.0D) && (d2 - localdm.d > 0.0D)) || ((localdm.h < 0.0D) && (d2 - localdm.d < 0.0D))) {
          localdm.d += localdm.h * (l1 / 1000L);
        }
        localdm.d += (d2 - localdm.d) * d4;
        ev.b("a", "lat:" + localdm.d + ",tmp:" + d6 + ",timeInc:" + l1);
        localdm.h = ((localdm.d - d6) / (l1 / 1000L));
        d6 = localdm.e;
        if (((localdm.i > 0.0D) && (d3 - localdm.e > 0.0D)) || ((localdm.i < 0.0D) && (d3 - localdm.e < 0.0D))) {
          localdm.e += localdm.i * (l1 / 1000L);
        }
        localdm.e += (d3 - localdm.e) * d5;
        ev.b("a", "lng:" + localdm.e + ",tmp:" + d6 + ",timeInc:" + l1);
        localdm.i = ((localdm.e - d6) / (l1 / 1000L));
        localdm.f = ((1.0D - d4) * localdm.f);
        localdm.g = ((1.0D - d5) * localdm.g);
        localdm.c = l3;
        ev.b("a", "last_metres_per_second:" + localdm.h + ",last_metres_per_second_lng:" + localdm.i);
      }
      for (;;)
      {
        ev.b("a", "variance:" + localdm.f + ",vaLng:" + localdm.g);
        if ((d1 != 30.0D) || (d4 < 0.5D) || (d5 < 0.5D)) {
          break;
        }
        localdm.d = d2;
        localdm.e = d3;
        localdm.c = l3;
        localdm.h = 0.0D;
        localdm.i = 0.0D;
        localdm.f = (d1 * d1);
        break;
        if (((localdm.h > 0.0D) && (d2 - localdm.d > 0.0D)) || ((localdm.h < 0.0D) && (d2 - localdm.d < 0.0D))) {
          localdm.d += localdm.h * (l1 / 1000L);
        }
        if (((localdm.i > 0.0D) && (d3 - localdm.e > 0.0D)) || ((localdm.i < 0.0D) && (d3 - localdm.e < 0.0D))) {
          localdm.e += localdm.i * (l1 / 1000L);
        }
        localdm.f -= l1;
        localdm.g -= l1;
      }
    }
  }
  
  public final void a(TencentLocation paramTencentLocation)
  {
    try
    {
      this.c.add(a.a(paramTencentLocation));
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
  
  public final boolean a(TencentLocation paramTencentLocation, de paramde)
  {
    try
    {
      boolean bool = a(a.a(paramTencentLocation), paramde);
      return bool;
    }
    finally
    {
      paramTencentLocation = finally;
      throw paramTencentLocation;
    }
  }
  
  static final class a
  {
    double a;
    double b;
    long c;
    int d;
    private double e;
    
    static a a(TencentLocation paramTencentLocation)
    {
      int i = 2;
      a locala = new a();
      locala.a = paramTencentLocation.getLatitude();
      locala.b = paramTencentLocation.getLongitude();
      locala.c = paramTencentLocation.getTime();
      locala.e = paramTencentLocation.getSpeed();
      if (TencentLocationUtils.isFromGps(paramTencentLocation))
      {
        if (paramTencentLocation.getAccuracy() < 100.0F) {
          i = 3;
        }
        locala.d = i;
        return locala;
      }
      if (paramTencentLocation.getAccuracy() < 500.0F) {}
      for (;;)
      {
        locala.d = i;
        return locala;
        i = 1;
      }
    }
    
    public final String toString()
    {
      return "[" + this.a + "," + this.b + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.dz
 * JD-Core Version:    0.7.0.1
 */