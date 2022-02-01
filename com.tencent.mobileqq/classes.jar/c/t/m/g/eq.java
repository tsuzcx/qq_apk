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
      try
      {
        if ((this.c != null) && (this.c.size() != 0))
        {
          i = parama.d;
          if (i == 3) {
            return true;
          }
          if ((parama.d == 1) && (!fq.a(paramea)))
          {
            boolean bool = fq.b(paramea);
            if (!bool) {
              return true;
            }
          }
          if (parama.c - ((eq.a)this.c.getLast()).c > 120000L)
          {
            this.c.clear();
            return true;
          }
          if (this.c.size() < this.b) {
            break label354;
          }
          i = 1;
          if (i != 0)
          {
            paramea = this.c.listIterator(this.c.size());
            double d1 = 0.0D;
            double d2 = 0.0D;
            i = 0;
            int j = 0;
            if (paramea.hasPrevious())
            {
              eq.a locala = (eq.a)paramea.previous();
              d2 = fp.a(locala.a, locala.b, parama.a, parama.b);
              long l = Math.abs(locala.c - parama.c);
              d3 = l + 1L;
              Double.isNaN(d3);
              d2 /= d3 / 1000.0D;
              d1 += d2;
              int k = i;
              if (d2 > 50.0D) {
                k = i + 1;
              }
              j += 1;
              i = this.b;
              if (j > i)
              {
                i = k;
              }
              else
              {
                i = k;
                continue;
              }
            }
            if (i > 1) {
              return false;
            }
            paramea = el.b();
            double d3 = j;
            Double.isNaN(d3);
            d1 /= d3;
            paramea.a(1, d1, d2, parama.c);
          }
          return true;
        }
      }
      finally {}
      continue;
      label354:
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
  
  public final void a(fi paramfi)
  {
    Object localObject = this;
    label1630:
    for (;;)
    {
      try
      {
        if (paramfi.getProvider().equalsIgnoreCase("gps"))
        {
          boolean bool = da.a().d("gps_kalman");
          if (!bool) {
            return;
          }
        }
        if ((((eq)localObject).c != null) && ((((eq)localObject).c == null) || (((eq)localObject).c.size() != 0)))
        {
          localObject = ((eq)localObject).d;
          double d6 = paramfi.getLatitude();
          double d1 = paramfi.getLongitude();
          double d3 = paramfi.getAccuracy();
          long l3 = paramfi.getTime();
          double d2 = d3;
          if (d3 < 1.0D) {
            d2 = 1.0D;
          }
          StringBuilder localStringBuilder = new StringBuilder("lat_me:");
          localStringBuilder.append(d6);
          localStringBuilder.append(",lng_me:");
          localStringBuilder.append(d1);
          localStringBuilder.append(",accuracy:");
          localStringBuilder.append(d2);
          localStringBuilder.append(",time:");
          localStringBuilder.append(l3);
          localStringBuilder.append(",lat:");
          localStringBuilder.append(((dw)localObject).d);
          localStringBuilder.append(",lng:");
          localStringBuilder.append(((dw)localObject).e);
          if (l3 - ((dw)localObject).c >= 20000L)
          {
            ((dw)localObject).a();
            localStringBuilder = new StringBuilder("Time:");
            localStringBuilder.append(l3);
            localStringBuilder.append(",last_time:");
            localStringBuilder.append(((dw)localObject).c);
          }
          ((dw)localObject).a = ((float)(Math.abs(d6 - ((dw)localObject).d) * 1000000.0D));
          ((dw)localObject).b = ((float)(Math.abs(d1 - ((dw)localObject).e) * 1000000.0D));
          localStringBuilder = new StringBuilder("Q:");
          localStringBuilder.append(((dw)localObject).a);
          localStringBuilder.append(",QLng:");
          localStringBuilder.append(((dw)localObject).b);
          long l1;
          long l2;
          if (((dw)localObject).f < 0.0D)
          {
            ((dw)localObject).c = l3;
            ((dw)localObject).d = d6;
            ((dw)localObject).e = d1;
            ((dw)localObject).f = (d2 * d2);
          }
          else
          {
            l1 = ((dw)localObject).c;
            l2 = l3 - l1;
            l1 = l2;
            if (l2 < 1000L) {
              l1 = 1000L;
            }
            if (l1 <= 0L) {}
          }
          try
          {
            double d4 = ((dw)localObject).f;
            d3 = l1;
            Double.isNaN(d3);
            ((dw)localObject).f = (d4 + d3);
            d4 = ((dw)localObject).g;
            Double.isNaN(d3);
            ((dw)localObject).g = (d4 + d3);
            d3 = ((dw)localObject).f;
            d4 = ((dw)localObject).f;
            double d7 = d2 * d2;
            float f = ((dw)localObject).a;
            double d5 = f * 5.0F;
            Double.isNaN(d5);
            double d8 = d3 / (d4 + d7 + d5);
            d3 = ((dw)localObject).g;
            d4 = ((dw)localObject).g;
            f = ((dw)localObject).b;
            d5 = f * 5.0F;
            Double.isNaN(d5);
            d3 /= (d4 + d7 + d5);
            localStringBuilder = new StringBuilder("K:");
            localStringBuilder.append(d8);
            localStringBuilder.append(",KLng:");
            localStringBuilder.append(d3);
            double d9;
            double d10;
            if ((d8 >= 0.4D) && (d3 >= 0.4D))
            {
              d9 = ((dw)localObject).d;
              if (((((dw)localObject).h <= 0.0D) || (d6 - ((dw)localObject).d <= 0.0D)) && ((((dw)localObject).h >= 0.0D) || (d6 - ((dw)localObject).d >= 0.0D))) {
                break label1630;
              }
              d4 = ((dw)localObject).d;
              d5 = ((dw)localObject).h;
              l2 = l1 / 1000L;
              d10 = l2;
              Double.isNaN(d10);
              ((dw)localObject).d = (d4 + d5 * d10);
              d5 = d1;
              d4 = d3;
              ((dw)localObject).d += (d6 - ((dw)localObject).d) * d8;
              localStringBuilder = new StringBuilder("lat:");
              localStringBuilder.append(((dw)localObject).d);
              localStringBuilder.append(",tmp:");
              localStringBuilder.append(d9);
              localStringBuilder.append(",timeInc:");
              localStringBuilder.append(l1);
              d10 = ((dw)localObject).d;
              l2 = l1 / 1000L;
              double d11 = l2;
              Double.isNaN(d11);
              d9 = (d10 - d9) / d11;
              ((dw)localObject).h = d9;
              d9 = ((dw)localObject).e;
              if (((((dw)localObject).i > 0.0D) && (d5 - ((dw)localObject).e > 0.0D)) || ((((dw)localObject).i < 0.0D) && (d5 - ((dw)localObject).e < 0.0D)))
              {
                d10 = ((dw)localObject).e;
                d11 = ((dw)localObject).i;
                l2 = l1 / 1000L;
                double d12 = l2;
                Double.isNaN(d12);
                ((dw)localObject).e = (d10 + d11 * d12);
              }
              ((dw)localObject).e += (d5 - ((dw)localObject).e) * d4;
              localStringBuilder = new StringBuilder("lng:");
              localStringBuilder.append(((dw)localObject).e);
              localStringBuilder.append(",tmp:");
              localStringBuilder.append(d9);
              localStringBuilder.append(",timeInc:");
              localStringBuilder.append(l1);
              d5 = ((dw)localObject).e;
              l1 /= 1000L;
              d10 = l1;
              Double.isNaN(d10);
              d5 = (d5 - d9) / d10;
              ((dw)localObject).i = d5;
              ((dw)localObject).f = ((1.0D - d8) * ((dw)localObject).f);
              ((dw)localObject).g = ((1.0D - d4) * ((dw)localObject).g);
              ((dw)localObject).c = l3;
              localStringBuilder = new StringBuilder("last_metres_per_second:");
              localStringBuilder.append(((dw)localObject).h);
              localStringBuilder.append(",last_metres_per_second_lng:");
              localStringBuilder.append(((dw)localObject).i);
            }
            else
            {
              d4 = d1;
              if (((((dw)localObject).h > 0.0D) && (d6 - ((dw)localObject).d > 0.0D)) || ((((dw)localObject).h < 0.0D) && (d6 - ((dw)localObject).d < 0.0D)))
              {
                d5 = ((dw)localObject).d;
                d9 = ((dw)localObject).h;
                l2 = l1 / 1000L;
                d10 = l2;
                Double.isNaN(d10);
                ((dw)localObject).d = (d5 + d9 * d10);
              }
              if (((((dw)localObject).i > 0.0D) && (d4 - ((dw)localObject).e > 0.0D)) || ((((dw)localObject).i < 0.0D) && (d4 - ((dw)localObject).e < 0.0D)))
              {
                d4 = ((dw)localObject).e;
                d5 = ((dw)localObject).i;
                l2 = l1 / 1000L;
                d9 = l2;
                Double.isNaN(d9);
                ((dw)localObject).e = (d4 + d5 * d9);
              }
              d5 = ((dw)localObject).f;
              d4 = l1;
              Double.isNaN(d4);
              ((dw)localObject).f = (d5 - d4);
              d5 = ((dw)localObject).g;
              Double.isNaN(d4);
              ((dw)localObject).g = (d5 - d4);
            }
            localStringBuilder = new StringBuilder("variance:");
            localStringBuilder.append(((dw)localObject).f);
            localStringBuilder.append(",vaLng:");
            localStringBuilder.append(((dw)localObject).g);
            if ((d2 == 30.0D) && (d8 >= 0.5D) && (d3 >= 0.5D))
            {
              ((dw)localObject).d = d6;
              ((dw)localObject).e = d1;
              ((dw)localObject).c = l3;
              ((dw)localObject).h = 0.0D;
              ((dw)localObject).i = 0.0D;
              ((dw)localObject).f = d7;
            }
            localObject = this;
            d2 = ((eq)localObject).d.d;
            d1 = ((eq)localObject).d.e;
            localObject = paramfi.b;
            l1 = Math.round(d2 * 1000000.0D);
            d2 = l1;
            Double.isNaN(d2);
            d2 /= 1000000.0D;
            ((fe)localObject).a = d2;
            paramfi = paramfi.b;
            l1 = Math.round(d1 * 1000000.0D);
            d1 = l1;
            Double.isNaN(d1);
            d1 /= 1000000.0D;
            paramfi.b = d1;
            return;
          }
          finally
          {
            continue;
          }
        }
        else
        {
          return;
        }
      }
      finally {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.eq
 * JD-Core Version:    0.7.0.1
 */