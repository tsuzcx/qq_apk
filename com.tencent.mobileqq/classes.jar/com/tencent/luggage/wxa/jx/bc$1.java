package com.tencent.luggage.wxa.jx;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.ix.c.a;
import com.tencent.luggage.wxa.ld.e;
import com.tencent.luggage.wxa.nz.k.a;
import java.util.Map;

final class bc$1
  implements k.a
{
  public void a(c paramc, String paramString, e parame)
  {
    parame = new bc.1.1(this, paramc, paramString, parame);
    bc.a.put(paramString, parame);
    ((h)paramc).q().al().a(parame);
  }
  
  public void b(c paramc, String paramString, e parame)
  {
    paramString = (c.a)bc.a.get(paramString);
    if (paramString != null)
    {
      paramc = ((h)paramc).q();
      if (paramc != null) {
        paramc.al().b(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.bc.1
 * JD-Core Version:    0.7.0.1
 */