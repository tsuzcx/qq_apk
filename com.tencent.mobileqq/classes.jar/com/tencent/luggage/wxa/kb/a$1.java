package com.tencent.luggage.wxa.kb;

import com.tencent.luggage.wxa.qw.aa;
import com.tencent.luggage.wxa.qw.bc;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rl.b;
import com.tencent.mm.plugin.appbrand.page.u;

class a$1
  implements b<Object, bc>
{
  a$1(a parama, u paramu, int paramInt) {}
  
  public Object a(bc parambc)
  {
    if (parambc == null)
    {
      o.b("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData cgi failed, null response");
      this.a.a(this.b, this.c.b("fail:cgi fail"));
      return null;
    }
    if (parambc.z.a != 0)
    {
      o.b("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData cgi failed, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(parambc.z.a), parambc.z.b });
      this.a.a(this.b, this.c.b("fail:cgi fail"));
      return null;
    }
    o.d("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData success");
    this.a.a(this.b, this.c.b("ok"));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kb.a.1
 * JD-Core Version:    0.7.0.1
 */