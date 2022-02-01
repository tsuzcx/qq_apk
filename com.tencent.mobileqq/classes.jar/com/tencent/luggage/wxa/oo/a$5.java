package com.tencent.luggage.wxa.oo;

import com.tencent.luggage.wxa.qw.en;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.h;

class a$5
  implements com.tencent.luggage.wxa.rl.b<Void, en>
{
  a$5(a parama, String paramString) {}
  
  public Void a(en paramen)
  {
    try
    {
      a.a(this.b, paramen);
    }
    catch (Exception paramen)
    {
      o.b("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth appId = %s, e = %s", new Object[] { this.a, paramen });
      h.b().a(paramen);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.oo.a.5
 * JD-Core Version:    0.7.0.1
 */