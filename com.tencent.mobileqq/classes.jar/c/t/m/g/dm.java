package c.t.m.g;

import android.location.Location;
import java.util.LinkedList;

public final class dm
{
  private static dm a = new dm();
  private a b = a.a;
  private LinkedList<eb> c = new LinkedList();
  
  public static dm a()
  {
    return a;
  }
  
  public final int a(eb parameb)
  {
    if (parameb != null)
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
        localeb = (eb)this.c.getFirst();
        long l1 = parameb.b;
        long l2 = localeb.b;
        double d = f.a.a(localeb.a.getLatitude(), localeb.a.getLongitude(), parameb.a.getLatitude(), parameb.a.getLongitude());
        if ((l1 - l2 <= 180000L) || (d <= 500.0D)) {
          break;
        }
        this.c.remove(0);
      }
      label136:
      eb localeb = new eb(parameb);
      this.c.add(localeb);
      parameb.a.getSpeed();
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
        int i;
        Object localObject3;
        if (this.c.size() < 2)
        {
          d1 = 0.0D;
          if (this.c.size() < 2) {
            continue;
          }
          int j = this.c.size();
          l = 0L;
          d2 = 0.0D;
          i = 1;
          if (i < j)
          {
            localObject1 = (eb)this.c.get(i);
            localObject3 = (eb)this.c.get(i - 1);
            double d3 = f.a.a(((eb)localObject3).a.getLatitude(), ((eb)localObject3).a.getLongitude(), ((eb)localObject1).a.getLatitude(), ((eb)localObject1).a.getLongitude());
            l = ((eb)localObject1).b - ((eb)localObject3).b + l;
            d2 += d3;
            i += 1;
            continue;
          }
        }
        else
        {
          i = this.c.size() - 1;
          localObject1 = (eb)this.c.get(i);
          localObject3 = (eb)this.c.get(i - 1);
          if (((eb)localObject1).b == ((eb)localObject3).b) {
            break label515;
          }
          l = ((eb)localObject1).b - ((eb)localObject3).b;
          d1 = f.a.a(((eb)localObject3).a.getLatitude(), ((eb)localObject3).a.getLongitude(), ((eb)localObject1).a.getLatitude(), ((eb)localObject1).a.getLongitude()) / l * 1000.0D;
          continue;
        }
        if (l > 0L)
        {
          d2 = 1000.0D * (d2 / l);
          if ((dp.b() != null) && (this.c.size() > 0)) {
            dp.b().a(2, d2, d1, ((eb)this.c.getLast()).b);
          }
          if (this.c.size() < 2)
          {
            l = 0L;
            i = this.c.size();
            if (i >= 2) {
              continue;
            }
            this.b = a.a;
            localObject1 = this.b;
            localObject3 = a.c;
            if (localObject1 != localObject3) {
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
        Object localObject1 = (eb)this.c.getFirst();
        l = ((eb)this.c.getLast()).b - ((eb)localObject1).b;
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
    static
    {
      a locala = a;
      locala = b;
      locala = c;
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.dm
 * JD-Core Version:    0.7.0.1
 */