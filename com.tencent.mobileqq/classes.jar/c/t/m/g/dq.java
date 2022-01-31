package c.t.m.g;

import android.location.Location;
import java.util.LinkedList;

public final class dq
{
  private static dq a = new dq();
  private int b = a.a;
  private LinkedList<ef> c = new LinkedList();
  
  public static dq a()
  {
    return a;
  }
  
  public final int a(ef paramef)
  {
    if (paramef != null)
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
        localef = (ef)this.c.getFirst();
        long l1 = paramef.b;
        long l2 = localef.b;
        double d = ev.a(localef.a.getLatitude(), localef.a.getLongitude(), paramef.a.getLatitude(), paramef.a.getLongitude());
        if ((l1 - l2 <= 180000L) || (d <= 500.0D)) {
          break;
        }
        this.c.remove(0);
      }
      label136:
      ef localef = new ef(paramef);
      this.c.add(localef);
      paramef.a.getSpeed();
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
        ef localef2;
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
            localef1 = (ef)this.c.get(i);
            localef2 = (ef)this.c.get(i - 1);
            double d3 = ev.a(localef2.a.getLatitude(), localef2.a.getLongitude(), localef1.a.getLatitude(), localef1.a.getLongitude());
            l = localef1.b - localef2.b + l;
            d2 += d3;
            i += 1;
            continue;
          }
        }
        else
        {
          i = this.c.size() - 1;
          localef1 = (ef)this.c.get(i);
          localef2 = (ef)this.c.get(i - 1);
          if (localef1.b == localef2.b) {
            break label515;
          }
          l = localef1.b - localef2.b;
          d1 = ev.a(localef2.a.getLatitude(), localef2.a.getLongitude(), localef1.a.getLatitude(), localef1.a.getLongitude()) / l * 1000.0D;
          continue;
        }
        if (l > 0L)
        {
          d2 = 1000.0D * (d2 / l);
          if ((dt.b() != null) && (this.c.size() > 0)) {
            dt.b().a(2, d2, d1, ((ef)this.c.getLast()).b);
          }
          if (this.c.size() < 2)
          {
            l = 0L;
            i = this.c.size();
            if (i >= 2) {
              continue;
            }
            this.b = a.a;
            i = this.b;
            j = a.c;
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
        ef localef1 = (ef)this.c.getFirst();
        l = ((ef)this.c.getLast()).b - localef1.b;
        continue;
        if ((i > 6) && (d1 < 3.0D) && (d2 < 6.0D))
        {
          this.b = a.c;
          continue;
        }
        if (l <= 60000L) {
          break label497;
        }
      }
      finally {}
      if ((d1 < 3.0D) && (d2 < 3.0D))
      {
        this.b = a.c;
      }
      else
      {
        label497:
        this.b = a.b;
        continue;
        label507:
        l = 30000L;
        continue;
        label515:
        l = 500L;
      }
    }
  }
  
  static enum a
  {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.dq
 * JD-Core Version:    0.7.0.1
 */