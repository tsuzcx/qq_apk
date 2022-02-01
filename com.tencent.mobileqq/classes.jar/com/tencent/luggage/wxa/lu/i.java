package com.tencent.luggage.wxa.lu;

import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.pc.l;
import com.tencent.luggage.wxa.pc.l.a;
import com.tencent.luggage.wxa.pd.h;
import com.tencent.luggage.wxa.qz.o;
import java.util.LinkedList;
import java.util.List;

public class i
{
  private static int a;
  private final List<ah> b = new LinkedList();
  private h c;
  private Runnable d;
  
  private i()
  {
    a = c();
    this.d = new i.1(this);
    this.c = new h(a, new i.2(this));
  }
  
  public static int a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 20)
      {
        if (paramInt != 60)
        {
          if (paramInt != 200) {}
          return 3;
        }
        return 2;
      }
      return 1;
    }
    return 0;
  }
  
  public static i a()
  {
    return i.a.a;
  }
  
  public static int b()
  {
    return 5;
  }
  
  public static int c()
  {
    return 20;
  }
  
  public boolean a(ah paramah, c paramc)
  {
    a locala = (a)e.a(a.class);
    if ((locala != null) && (locala.a())) {
      return b(paramah, paramc);
    }
    return c(paramah, paramc);
  }
  
  public boolean b(ah paramah, c paramc)
  {
    if (paramah != null)
    {
      if (paramc == null) {
        return false;
      }
      if (o.c() == 0) {
        o.f("MicroMsg.SensorJsEventPublisher", "post direct event(event : %s).", new Object[] { paramah.d() });
      }
      paramah.a();
      return true;
    }
    return false;
  }
  
  public boolean c(ah paramah, c arg2)
  {
    if (paramah != null)
    {
      if (??? == null) {
        return false;
      }
      synchronized (this.b)
      {
        boolean bool = this.b.isEmpty();
        if (!this.b.isEmpty())
        {
          if (((ah)this.b.get(0)).equals(paramah))
          {
            this.b.add(0, paramah);
            this.b.remove(1);
          }
          else
          {
            this.b.remove(paramah);
            this.b.add(paramah);
          }
        }
        else {
          this.b.add(paramah);
        }
        if ((bool) && (!this.c.a(new Object[0])))
        {
          o.f("MicroMsg.SensorJsEventPublisher", "post delay publish event(event : %s).", new Object[] { paramah.d() });
          l.a().a(this.d, a);
        }
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lu.i
 * JD-Core Version:    0.7.0.1
 */