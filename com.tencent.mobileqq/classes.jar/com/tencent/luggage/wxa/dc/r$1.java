package com.tencent.luggage.wxa.dc;

import com.tencent.luggage.wxa.qw.gt;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.h;
import com.tencent.luggage.wxa.rr.c;

final class r$1
  implements com.tencent.luggage.wxa.rl.b<RES, c<Boolean, Boolean>>
{
  r$1(String paramString1, String paramString2, gt paramgt, Class paramClass) {}
  
  public RES a(c<Boolean, Boolean> paramc)
  {
    Object localObject = (Boolean)paramc.b();
    o.f("Luggage.WxaRuntimeCgiProxy", "isActivate:%b isAuthorize:%b", new Object[] { localObject, (Boolean)paramc.c() });
    paramc = h.b();
    if (!((Boolean)localObject).booleanValue())
    {
      paramc.a("device not activate");
      return null;
    }
    try
    {
      localObject = r.b(this.a, this.b, this.c, this.d);
      return localObject;
    }
    catch (Exception localException)
    {
      paramc.a(localException);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.r.1
 * JD-Core Version:    0.7.0.1
 */