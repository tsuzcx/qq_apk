package c.t.m.g;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationUtils;
import java.util.LinkedList;
import java.util.ListIterator;

public final class dv
{
  private int a = 10;
  private int b = 4;
  private LinkedList<a> c = new LinkedList();
  private dj d = new dj();
  
  private boolean a(a parama, da paramda)
  {
    if (paramda != null) {}
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
        if ((parama.d == 1) && (!es.a(paramda)) && (!es.b(paramda)))
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
          break label333;
        }
        i = 1;
        if (i != 0)
        {
          i = 0;
          int j = 0;
          double d2 = 0.0D;
          double d1 = 0.0D;
          paramda = this.c.listIterator(this.c.size());
          if (paramda.hasPrevious())
          {
            a locala = (a)paramda.previous();
            d1 = f.a.a(locala.a, locala.b, parama.a, parama.b) / ((Math.abs(locala.c - parama.c) + 1L) / 1000.0D);
            d2 += d1;
            if (d1 <= 50.0D) {
              break label330;
            }
            i += 1;
            j += 1;
            if (j <= this.b) {
              break label327;
            }
            if (i > 1)
            {
              f.a.b("TxTrace", "badPoints=" + i);
              bool = false;
              continue;
            }
            dp.b().a(1, d2 / j, d1, parama.c);
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
      label327:
      continue;
      label330:
      continue;
      label333:
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
  
  public final void a(em paramem)
  {
    label1222:
    for (;;)
    {
      dj localdj;
      double d2;
      double d3;
      double d1;
      long l3;
      try
      {
        if (paramem.getProvider().equalsIgnoreCase("gps"))
        {
          boolean bool = cy.a().d("gps_kalman");
          if (!bool) {
            return;
          }
        }
        if ((this.c == null) || ((this.c != null) && (this.c.size() == 0))) {
          continue;
        }
        localdj = this.d;
        d2 = paramem.getLatitude();
        d3 = paramem.getLongitude();
        d1 = paramem.getAccuracy();
        l3 = paramem.getTime();
        if (d1 >= 1.0D) {
          break label1222;
        }
        d1 = 1.0D;
        f.a.b("a", "lat_me:" + d2 + ",lng_me:" + d3 + ",accuracy:" + d1 + ",time:" + l3 + ",lat:" + localdj.d + ",lng:" + localdj.e);
        if (l3 - localdj.c >= 20000L)
        {
          localdj.a();
          f.a.b("a", "Time:" + l3 + ",last_time:" + localdj.c);
        }
        localdj.a = ((float)(Math.abs(d2 - localdj.d) * 1000000.0D));
        localdj.b = ((float)(Math.abs(d3 - localdj.e) * 1000000.0D));
        f.a.b("a", "Q:" + localdj.a + ",QLng:" + localdj.b);
        if (localdj.f < 0.0D)
        {
          localdj.c = l3;
          localdj.d = d2;
          localdj.e = d3;
          localdj.f = (d1 * d1);
          paramem.a(this.d.d, this.d.e);
          continue;
        }
        l2 = l3 - localdj.c;
      }
      finally {}
      long l2;
      long l1 = l2;
      if (l2 < 1000L) {
        l1 = 1000L;
      }
      if (l1 > 0L)
      {
        localdj.f += l1;
        localdj.g += l1;
      }
      double d4 = localdj.f / (localdj.f + d1 * d1 + localdj.a * 5.0F);
      double d5 = localdj.g / (localdj.g + d1 * d1 + localdj.b * 5.0F);
      f.a.b("a", "K:" + d4 + ",KLng:" + d5);
      if ((d4 >= 0.4D) && (d5 >= 0.4D))
      {
        double d6 = localdj.d;
        if (((localdj.h > 0.0D) && (d2 - localdj.d > 0.0D)) || ((localdj.h < 0.0D) && (d2 - localdj.d < 0.0D))) {
          localdj.d += localdj.h * (l1 / 1000L);
        }
        localdj.d += (d2 - localdj.d) * d4;
        f.a.b("a", "lat:" + localdj.d + ",tmp:" + d6 + ",timeInc:" + l1);
        localdj.h = ((localdj.d - d6) / (l1 / 1000L));
        d6 = localdj.e;
        if (((localdj.i > 0.0D) && (d3 - localdj.e > 0.0D)) || ((localdj.i < 0.0D) && (d3 - localdj.e < 0.0D))) {
          localdj.e += localdj.i * (l1 / 1000L);
        }
        localdj.e += (d3 - localdj.e) * d5;
        f.a.b("a", "lng:" + localdj.e + ",tmp:" + d6 + ",timeInc:" + l1);
        localdj.i = ((localdj.e - d6) / (l1 / 1000L));
        localdj.f = ((1.0D - d4) * localdj.f);
        localdj.g = ((1.0D - d5) * localdj.g);
        localdj.c = l3;
        f.a.b("a", "last_metres_per_second:" + localdj.h + ",last_metres_per_second_lng:" + localdj.i);
      }
      for (;;)
      {
        f.a.b("a", "variance:" + localdj.f + ",vaLng:" + localdj.g);
        if ((d1 != 30.0D) || (d4 < 0.5D) || (d5 < 0.5D)) {
          break;
        }
        localdj.d = d2;
        localdj.e = d3;
        localdj.c = l3;
        localdj.h = 0.0D;
        localdj.i = 0.0D;
        localdj.f = (d1 * d1);
        break;
        if (((localdj.h > 0.0D) && (d2 - localdj.d > 0.0D)) || ((localdj.h < 0.0D) && (d2 - localdj.d < 0.0D))) {
          localdj.d += localdj.h * (l1 / 1000L);
        }
        if (((localdj.i > 0.0D) && (d3 - localdj.e > 0.0D)) || ((localdj.i < 0.0D) && (d3 - localdj.e < 0.0D))) {
          localdj.e += localdj.i * (l1 / 1000L);
        }
        localdj.f -= l1;
        localdj.g -= l1;
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
  
  public final boolean a(TencentLocation paramTencentLocation, da paramda)
  {
    try
    {
      boolean bool = a(a.a(paramTencentLocation), paramda);
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
    
    static a a(TencentLocation paramTencentLocation)
    {
      int i = 2;
      a locala = new a();
      locala.a = paramTencentLocation.getLatitude();
      locala.b = paramTencentLocation.getLongitude();
      locala.c = paramTencentLocation.getTime();
      paramTencentLocation.getSpeed();
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
 * Qualified Name:     c.t.m.g.dv
 * JD-Core Version:    0.7.0.1
 */