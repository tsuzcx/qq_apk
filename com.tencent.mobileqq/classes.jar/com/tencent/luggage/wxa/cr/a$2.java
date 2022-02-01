package com.tencent.luggage.wxa.cr;

import com.tencent.luggage.wxa.qw.aa;
import com.tencent.luggage.wxa.qw.ag;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rl.b;

class a$2
  implements b<String, ag>
{
  a$2(a parama) {}
  
  public String a(ag paramag)
  {
    o.d("MicroMsg.JsApiReportSubmitForm", "resp errCode:%d", new Object[] { Integer.valueOf(paramag.z.a) });
    if (paramag.z.a == 0) {
      return "ok";
    }
    return "fail";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cr.a.2
 * JD-Core Version:    0.7.0.1
 */