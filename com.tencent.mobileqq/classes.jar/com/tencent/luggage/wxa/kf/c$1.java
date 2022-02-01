package com.tencent.luggage.wxa.kf;

import com.tencent.luggage.wxa.kl.b;
import com.tencent.luggage.wxa.kl.j;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;

class c$1
  implements b
{
  c$1(c paramc, String paramString, com.tencent.luggage.wxa.jx.c paramc1, int paramInt) {}
  
  public void a(j paramj)
  {
    o.d("MicroMsg.JsApiCreateBLEConnection", "appId:%s createBLEConnection result:%s", new Object[] { this.a, paramj });
    if (paramj.u != 0)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("errCode", Integer.valueOf(paramj.u));
      this.b.a(this.c, this.d.a(paramj.v, localHashMap));
      com.tencent.luggage.wxa.ke.c.a(27);
      return;
    }
    paramj = new HashMap();
    paramj.put("errCode", Integer.valueOf(0));
    this.b.a(this.c, this.d.a("ok", paramj));
    com.tencent.luggage.wxa.ke.c.a(26);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kf.c.1
 * JD-Core Version:    0.7.0.1
 */