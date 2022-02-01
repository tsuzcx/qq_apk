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
    if (parameu != null) {}
    try
    {
      while (this.c.size() > 9) {
        this.c.remove(0);
      }
      while (this.c.size() > 0)
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
      eu localeu = new eu(parameu);
      this.c.add(localeu);
      parameu.a.getSpeed();
      int i = this.c.size();
      return i;
    }
    finally {}
    for (;;)
    {
      throw parameu;
    }
  }
  
  public final long b()
  {
    try
    {
      int j = this.c.size();
      int i = 1;
      double d1;
      eu localeu1;
      eu localeu2;
      long l1;
      if (j < 2)
      {
        d1 = 0.0D;
      }
      else
      {
        j = this.c.size() - 1;
        localeu1 = (eu)this.c.get(j);
        localeu2 = (eu)this.c.get(j - 1);
        l1 = 500L;
        if (localeu1.b != localeu2.b) {
          l1 = localeu1.b - localeu2.b;
        }
        d1 = fp.a(localeu2.a.getLatitude(), localeu2.a.getLongitude(), localeu1.a.getLatitude(), localeu1.a.getLongitude());
        d2 = l1;
        Double.isNaN(d2);
        d1 = d1 / d2 * 1000.0D;
      }
      j = this.c.size();
      long l2 = 0L;
      if (j >= 2)
      {
        j = this.c.size();
        l1 = 0L;
        d2 = 0.0D;
        while (i < j)
        {
          localeu1 = (eu)this.c.get(i);
          localeu2 = (eu)this.c.get(i - 1);
          d2 += fp.a(localeu2.a.getLatitude(), localeu2.a.getLongitude(), localeu1.a.getLatitude(), localeu1.a.getLongitude());
          long l3 = localeu1.b;
          long l4 = localeu2.b;
          l1 += l3 - l4;
          i += 1;
        }
        if (l1 > 0L)
        {
          double d3 = l1;
          Double.isNaN(d3);
          d2 = d2 / d3 * 1000.0D;
          break label323;
        }
      }
      double d2 = 0.0D;
      label323:
      if ((el.b() != null) && (this.c.size() > 0)) {
        el.b().a(2, d2, d1, ((eu)this.c.getLast()).b);
      }
      if (this.c.size() < 2)
      {
        l1 = l2;
      }
      else
      {
        localeu1 = (eu)this.c.getFirst();
        l1 = ((eu)this.c.getLast()).b - localeu1.b;
      }
      i = this.c.size();
      if (i < 2) {
        this.b = ei.a.a;
      } else if ((i > 6) && (d1 < 3.0D) && (d2 < 6.0D)) {
        this.b = ei.a.c;
      } else if ((l1 > 60000L) && (d1 < 3.0D) && (d2 < 3.0D)) {
        this.b = ei.a.c;
      } else {
        this.b = ei.a.b;
      }
      i = this.b;
      j = ei.a.c;
      if (i == j) {
        return 90000L;
      }
      return 30000L;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.ei
 * JD-Core Version:    0.7.0.1
 */