package com.tencent.luggage.wxa.si;

import com.tencent.luggage.wxa.sj.i;
import java.util.concurrent.TimeUnit;

public class e
{
  private final b a;
  private final c b;
  private final f c;
  
  public e(com.tencent.luggage.wxa.rz.a parama)
  {
    this.a = new b(parama.b, parama.a);
    this.b = new c(parama.c);
    this.c = new f();
  }
  
  private d a(i<?> parami)
  {
    if (com.tencent.luggage.wxa.sc.b.a != null)
    {
      if (com.tencent.luggage.wxa.sc.b.a.a(parami.a())) {
        return this.a;
      }
      return this.b;
    }
    if (this.b.d()) {
      return this.a;
    }
    return this.b;
  }
  
  private <V> com.tencent.luggage.wxa.sj.d<V> a(i<V> parami, boolean paramBoolean, d paramd)
  {
    parami.a(paramd);
    if ((parami instanceof com.tencent.luggage.wxa.sk.e))
    {
      paramd = (com.tencent.luggage.wxa.sk.e)parami;
      com.tencent.luggage.wxa.sk.d locald = paramd.m().d();
      long l;
      if (paramBoolean) {
        l = -2147483648L;
      } else {
        l = parami.getDelay(TimeUnit.MILLISECONDS);
      }
      locald.a(l, paramd);
      return parami;
    }
    parami.b().b(parami);
    return parami;
  }
  
  public <V> com.tencent.luggage.wxa.sj.d<V> a(i<V> parami, boolean paramBoolean)
  {
    parami.a(this.c);
    if (paramBoolean)
    {
      this.c.d(parami);
      return parami;
    }
    return this.c.a(parami);
  }
  
  public <V> com.tencent.luggage.wxa.sj.d<V> b(i<V> parami, boolean paramBoolean)
  {
    return a(parami, paramBoolean, this.a);
  }
  
  public <V> com.tencent.luggage.wxa.sj.d<V> c(i<V> parami, boolean paramBoolean)
  {
    return a(parami, paramBoolean, this.b);
  }
  
  public <V> com.tencent.luggage.wxa.sj.d<V> d(i<V> parami, boolean paramBoolean)
  {
    return a(parami, paramBoolean, a(parami));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.si.e
 * JD-Core Version:    0.7.0.1
 */