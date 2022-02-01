package com.tencent.luggage.wxa.dq;

import com.tencent.luggage.wxa.dz.a;
import com.tencent.luggage.wxa.jx.f.d;
import com.tencent.luggage.wxa.ov.b;

class c$2
  implements f.d
{
  c$2(c paramc) {}
  
  public void c()
  {
    if ((this.a.b() instanceof com.tencent.luggage.wxa.ov.d))
    {
      com.tencent.luggage.wxa.ov.d locald = (com.tencent.luggage.wxa.ov.d)this.a.b();
      String str;
      if (this.a.f().aJ()) {
        str = this.a.f().as();
      } else {
        str = this.a.f().k().getCurrentUrl();
      }
      locald.a(str);
      return;
    }
    this.a.b().g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dq.c.2
 * JD-Core Version:    0.7.0.1
 */