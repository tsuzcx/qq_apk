package com.tencent.luggage.wxa.iu;

import com.tencent.luggage.wxa.hw.a;
import com.tencent.luggage.wxa.hw.c;
import com.tencent.luggage.wxa.hw.d.a;
import java.util.Set;

class k$1
  implements d.a
{
  k$1(k paramk) {}
  
  public void a(Class<? extends a> paramClass, a parama)
  {
    d.a locala = k.b(this.a);
    if (locala != null) {
      locala.a(paramClass, parama);
    }
  }
  
  public void a(Class<? extends a> paramClass, c paramc)
  {
    k.a(this.a).add(paramClass);
    d.a locala = k.b(this.a);
    if (locala != null) {
      locala.a(paramClass, paramc);
    }
  }
  
  public void b(Class<? extends a> paramClass, c paramc)
  {
    d.a locala = k.b(this.a);
    if (locala != null) {
      locala.b(paramClass, paramc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.k.1
 * JD-Core Version:    0.7.0.1
 */