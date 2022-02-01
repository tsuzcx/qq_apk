package com.tencent.luggage.wxa.lq;

import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

class c$1
  implements Runnable
{
  c$1(c paramc, h paramh, int paramInt, JSONObject paramJSONObject) {}
  
  public void run()
  {
    o.d("MicroMsg.JsApiShowModal", "invoke after runtime initialized appId[%s] callbackId[%d]", new Object[] { this.a.getAppId(), Integer.valueOf(this.b) });
    this.d.a(this.a, this.c, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lq.c.1
 * JD-Core Version:    0.7.0.1
 */