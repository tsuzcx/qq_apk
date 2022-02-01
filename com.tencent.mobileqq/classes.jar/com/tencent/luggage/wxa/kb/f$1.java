package com.tencent.luggage.wxa.kb;

import com.tencent.luggage.wxa.qw.aa;
import com.tencent.luggage.wxa.qw.hm;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rl.b;
import com.tencent.mm.plugin.appbrand.page.u;

class f$1
  implements b<Object, hm>
{
  f$1(f paramf, u paramu, int paramInt) {}
  
  public Object a(hm paramhm)
  {
    if (paramhm == null)
    {
      o.b("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData SaveUserAutoFillInfo cgi failed, null response");
      this.a.a(this.b, this.c.b("fail:cgi fail"));
      return null;
    }
    if (paramhm.z.a != 0)
    {
      o.b("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData SaveUserAutoFillInfo cgi failed, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramhm.z.a), paramhm.z.b });
      this.a.a(this.b, this.c.b("fail:cgi fail"));
      return null;
    }
    o.d("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData success");
    this.a.a(this.b, this.c.b("ok"));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kb.f.1
 * JD-Core Version:    0.7.0.1
 */