package com.tencent.luggage.wxa.hp;

import com.tencent.luggage.wxa.hj.e;
import com.tencent.luggage.wxa.ho.a;

class f$b
  implements e, a
{
  e<f.c> a;
  a b;
  
  f$b(e<f.c> parame)
  {
    this.a = parame;
    if ((parame instanceof a)) {
      this.b = ((a)parame);
    }
  }
  
  public void a(Object paramObject)
  {
    e locale = this.a;
    if (locale != null) {
      locale.a(new f.c(null, paramObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hp.f.b
 * JD-Core Version:    0.7.0.1
 */