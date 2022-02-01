package com.tencent.luggage.wxa.kf;

import com.tencent.luggage.wxa.kl.b;
import com.tencent.luggage.wxa.kl.j;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;

class k$2
  implements b
{
  k$2(k paramk, String paramString, com.tencent.luggage.wxa.jx.c paramc, int paramInt) {}
  
  public void a(j paramj)
  {
    o.d("MicroMsg.JsApiNotifyBLECharacteristicValueChanged", "appId:%s notifyBLECharacteristicValueChanged result:%s", new Object[] { this.a, paramj });
    if (paramj.u != 0)
    {
      new HashMap().put("errCode", Integer.valueOf(paramj.u));
      this.b.a(this.c, this.d.b(paramj.v));
      com.tencent.luggage.wxa.ke.c.a(43);
      return;
    }
    new HashMap().put("errCode", Integer.valueOf(0));
    this.b.a(this.c, this.d.b("ok"));
    com.tencent.luggage.wxa.ke.c.a(42);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kf.k.2
 * JD-Core Version:    0.7.0.1
 */