package c.t.m.g;

import android.location.Location;
import java.util.LinkedList;

public final class ef
{
  private static ef a = new ef();
  private int b = ef.a.a;
  private LinkedList<er> c = new LinkedList();
  
  public static ef a()
  {
    return a;
  }
  
  public final int a(er paramer)
  {
    if (paramer != null)
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
        localer = (er)this.c.getFirst();
        long l1 = paramer.b;
        long l2 = localer.b;
        double d = fm.a(localer.a.getLatitude(), localer.a.getLongitude(), paramer.a.getLatitude(), paramer.a.getLongitude());
        if ((l1 - l2 <= 180000L) || (d <= 500.0D)) {
          break;
        }
        this.c.remove(0);
      }
      label136:
      er localer = new er(paramer);
      this.c.add(localer);
      paramer.a.getSpeed();
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
        er localer2;
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
            localer1 = (er)this.c.get(i);
            localer2 = (er)this.c.get(i - 1);
            double d3 = fm.a(localer2.a.getLatitude(), localer2.a.getLongitude(), localer1.a.getLatitude(), localer1.a.getLongitude());
            l = localer1.b - localer2.b + l;
            d2 += d3;
            i += 1;
            continue;
          }
        }
        else
        {
          i = this.c.size() - 1;
          localer1 = (er)this.c.get(i);
          localer2 = (er)this.c.get(i - 1);
          if (localer1.b == localer2.b) {
            break label515;
          }
          l = localer1.b - localer2.b;
          d1 = fm.a(localer2.a.getLatitude(), localer2.a.getLongitude(), localer1.a.getLatitude(), localer1.a.getLongitude()) / l * 1000.0D;
          continue;
        }
        if (l > 0L)
        {
          d2 = 1000.0D * (d2 / l);
          if ((ei.b() != null) && (this.c.size() > 0)) {
            ei.b().a(2, d2, d1, ((er)this.c.getLast()).b);
          }
          if (this.c.size() < 2)
          {
            l = 0L;
            i = this.c.size();
            if (i >= 2) {
              continue;
            }
            this.b = ef.a.a;
            i = this.b;
            j = ef.a.c;
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
        er localer1 = (er)this.c.getFirst();
        l = ((er)this.c.getLast()).b - localer1.b;
        continue;
        if ((i > 6) && (d1 < 3.0D) && (d2 < 6.0D))
        {
          this.b = ef.a.c;
          continue;
        }
        if (l <= 60000L) {
          break label497;
        }
      }
      finally {}
      if ((d1 < 3.0D) && (d2 < 3.0D))
      {
        this.b = ef.a.c;
      }
      else
      {
        label497:
        this.b = ef.a.b;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.ef
 * JD-Core Version:    0.7.0.1
 */