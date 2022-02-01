package com.tencent.luggage.wxa.nf;

import com.tencent.luggage.wxa.gd.d;
import com.tencent.luggage.wxa.ix.b;
import com.tencent.luggage.wxa.ix.c.a;
import com.tencent.luggage.wxa.qz.o;

class c$4
  implements c.a
{
  c$4(c paramc) {}
  
  public void a(String paramString, b paramb)
  {
    if (paramString.equalsIgnoreCase(c.b(this.a)))
    {
      paramString = new StringBuilder();
      paramString.append("onRunningStateChanged, state: ");
      paramString.append(paramb);
      o.d("MicroMsg.SameLayer.AppBrandVideoCustomHandler", paramString.toString());
      if (paramb == b.b)
      {
        if (c.c(this.a) != null) {
          c.c(this.a).f();
        }
      }
      else if ((paramb == b.a) && (c.c(this.a) != null)) {
        c.c(this.a).e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nf.c.4
 * JD-Core Version:    0.7.0.1
 */