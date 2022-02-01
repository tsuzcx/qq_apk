package com.tencent.luggage.wxa.kb;

import com.tencent.luggage.wxa.qw.aa;
import com.tencent.luggage.wxa.qw.p;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rl.b;

class e$9
  implements b<Object, p>
{
  e$9(e parame) {}
  
  public Object a(p paramp)
  {
    if (paramp == null)
    {
      o.b("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData cgi failed, null response");
      return null;
    }
    if (paramp.z.a != 0)
    {
      o.b("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData cgi failed, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramp.z.a), paramp.z.b });
      return null;
    }
    o.d("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData success");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kb.e.9
 * JD-Core Version:    0.7.0.1
 */