package c.t.m.g;

import android.location.Location;
import java.util.LinkedList;

public final class ej
{
  private static ej a = new ej();
  private int b = ej.a.a;
  private LinkedList<ev> c = new LinkedList();
  
  public static ej a()
  {
    return a;
  }
  
  public final int a(ev paramev)
  {
    if (paramev != null)
    {
      try
      {
        while (this.c.size() > 9) {
          this.c.remove(0);
        }
        if (this.c.size() <= 0) {
          break label136;
        }
      }
      finally {}
      for (;;)
      {
        localev = (ev)this.c.getFirst();
        long l1 = paramev.b;
        long l2 = localev.b;
        double d = fp.a(localev.a.getLatitude(), localev.a.getLongitude(), paramev.a.getLatitude(), paramev.a.getLongitude());
        if ((l1 - l2 <= 180000L) || (d <= 500.0D)) {
          break;
        }
        this.c.remove(0);
      }
      label136:
      ev localev = new ev(paramev);
      this.c.add(localev);
      paramev.a.getSpeed();
    }
    int i = this.c.size();
    return i;
  }
  
  public final long b()
  {
    for (;;)
    {
      double d1;
      long l;
      double d2;
      try
      {
        int j;
        int i;
        ev localev2;
        if (this.c.size() < 2)
        {
          d1 = 0.0D;
          if (this.c.size() < 2) {
            continue;
          }
          j = this.c.size();
          l = 0L;
          d2 = 0.0D;
          i = 1;
          if (i < j)
          {
            localev1 = (ev)this.c.get(i);
            localev2 = (ev)this.c.get(i - 1);
            double d3 = fp.a(localev2.a.getLatitude(), localev2.a.getLongitude(), localev1.a.getLatitude(), localev1.a.getLongitude());
            l = localev1.b - localev2.b + l;
            d2 += d3;
            i += 1;
            continue;
          }
        }
        else
        {
          i = this.c.size() - 1;
          localev1 = (ev)this.c.get(i);
          localev2 = (ev)this.c.get(i - 1);
          if (localev1.b == localev2.b) {
            break label515;
          }
          l = localev1.b - localev2.b;
          d1 = fp.a(localev2.a.getLatitude(), localev2.a.getLongitude(), localev1.a.getLatitude(), localev1.a.getLongitude()) / l * 1000.0D;
          continue;
        }
        if (l > 0L)
        {
          d2 = 1000.0D * (d2 / l);
          if ((em.b() != null) && (this.c.size() > 0)) {
            em.b().a(2, d2, d1, ((ev)this.c.getLast()).b);
          }
          if (this.c.size() < 2)
          {
            l = 0L;
            i = this.c.size();
            if (i >= 2) {
              continue;
            }
            this.b = ej.a.a;
            i = this.b;
            j = ej.a.c;
            if (i != j) {
              break label507;
            }
            l = 90000L;
            return l;
          }
        }
        else
        {
          d2 = 0.0D;
          continue;
        }
        ev localev1 = (ev)this.c.getFirst();
        l = ((ev)this.c.getLast()).b - localev1.b;
        continue;
        if ((i > 6) && (d1 < 3.0D) && (d2 < 6.0D))
        {
          this.b = ej.a.c;
          continue;
        }
        if (l <= 60000L) {
          break label497;
        }
      }
      finally {}
      if ((d1 < 3.0D) && (d2 < 3.0D))
      {
        this.b = ej.a.c;
      }
      else
      {
        label497:
        this.b = ej.a.b;
        continue;
        label507:
        l = 30000L;
        continue;
        label515:
        l = 500L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.ej
 * JD-Core Version:    0.7.0.1
 */