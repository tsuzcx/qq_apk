package c.t.m.g;

import android.location.Location;
import java.util.LinkedList;

public final class ei
{
  private static ei a = new ei();
  private int b = ei.a.a;
  private LinkedList<eu> c = new LinkedList();
  
  public static ei a()
  {
    return a;
  }
  
  public final int a(eu parameu)
  {
    if (parameu != null)
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
        localeu = (eu)this.c.getFirst();
        long l1 = parameu.b;
        long l2 = localeu.b;
        double d = fp.a(localeu.a.getLatitude(), localeu.a.getLongitude(), parameu.a.getLatitude(), parameu.a.getLongitude());
        if ((l1 - l2 <= 180000L) || (d <= 500.0D)) {
          break;
        }
        this.c.remove(0);
      }
      label136:
      eu localeu = new eu(parameu);
      this.c.add(localeu);
      parameu.a.getSpeed();
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
        eu localeu2;
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
            localeu1 = (eu)this.c.get(i);
            localeu2 = (eu)this.c.get(i - 1);
            double d3 = fp.a(localeu2.a.getLatitude(), localeu2.a.getLongitude(), localeu1.a.getLatitude(), localeu1.a.getLongitude());
            l = localeu1.b - localeu2.b + l;
            d2 += d3;
            i += 1;
            continue;
          }
        }
        else
        {
          i = this.c.size() - 1;
          localeu1 = (eu)this.c.get(i);
          localeu2 = (eu)this.c.get(i - 1);
          if (localeu1.b == localeu2.b) {
            break label515;
          }
          l = localeu1.b - localeu2.b;
          d1 = fp.a(localeu2.a.getLatitude(), localeu2.a.getLongitude(), localeu1.a.getLatitude(), localeu1.a.getLongitude()) / l * 1000.0D;
          continue;
        }
        if (l > 0L)
        {
          d2 = 1000.0D * (d2 / l);
          if ((el.b() != null) && (this.c.size() > 0)) {
            el.b().a(2, d2, d1, ((eu)this.c.getLast()).b);
          }
          if (this.c.size() < 2)
          {
            l = 0L;
            i = this.c.size();
            if (i >= 2) {
              continue;
            }
            this.b = ei.a.a;
            i = this.b;
            j = ei.a.c;
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
        eu localeu1 = (eu)this.c.getFirst();
        l = ((eu)this.c.getLast()).b - localeu1.b;
        continue;
        if ((i > 6) && (d1 < 3.0D) && (d2 < 6.0D))
        {
          this.b = ei.a.c;
          continue;
        }
        if (l <= 60000L) {
          break label497;
        }
      }
      finally {}
      if ((d1 < 3.0D) && (d2 < 3.0D))
      {
        this.b = ei.a.c;
      }
      else
      {
        label497:
        this.b = ei.a.b;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     c.t.m.g.ei
 * JD-Core Version:    0.7.0.1
 */