package com.tencent.luggage.wxa.on;

import com.tencent.luggage.wxa.jz.h;
import com.tencent.luggage.wxa.jz.i;
import com.tencent.luggage.wxa.jz.k;
import com.tencent.luggage.wxa.jz.n;
import com.tencent.luggage.wxa.ld.e.a;
import com.tencent.luggage.wxa.lt.c;
import com.tencent.luggage.wxa.lt.d;
import com.tencent.luggage.wxa.lu.b.a;
import com.tencent.luggage.wxa.lu.c.a;
import java.util.Collection;
import java.util.HashSet;

public class l
  implements j
{
  public static final l a = new l();
  protected Collection<Class<? extends com.tencent.luggage.wxa.jx.b>> b = new HashSet();
  protected Collection<Class<? extends com.tencent.luggage.wxa.jx.b>> c = new HashSet();
  
  protected l()
  {
    this.b.add(b.a.class);
    this.b.add(c.a.class);
    this.b.add(e.a.class);
    this.c.add(com.tencent.luggage.wxa.kq.e.class);
    this.c.add(com.tencent.luggage.wxa.ln.b.class);
    this.c.add(h.class);
    this.c.add(com.tencent.luggage.wxa.jz.j.class);
    this.c.add(i.class);
    this.c.add(com.tencent.luggage.wxa.jz.e.class);
    this.c.add(com.tencent.luggage.wxa.jz.f.class);
    this.c.add(h.class);
    this.c.add(n.class);
    this.c.add(k.class);
    this.c.add(d.class);
    this.c.add(com.tencent.luggage.wxa.lt.e.class);
    this.c.add(com.tencent.luggage.wxa.lt.f.class);
    this.c.add(c.class);
  }
  
  public boolean a(com.tencent.luggage.wxa.jx.b paramb)
  {
    if (paramb == null) {
      return false;
    }
    return a(paramb.getClass());
  }
  
  public boolean a(Class<? extends com.tencent.luggage.wxa.jx.b> paramClass)
  {
    boolean bool = false;
    if (paramClass == null) {
      return false;
    }
    if ((this.c.contains(paramClass)) || (this.b.contains(paramClass))) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.on.l
 * JD-Core Version:    0.7.0.1
 */