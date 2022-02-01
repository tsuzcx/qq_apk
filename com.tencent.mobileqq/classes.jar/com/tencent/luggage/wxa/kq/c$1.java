package com.tencent.luggage.wxa.kq;

import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.kd.g;
import com.tencent.luggage.wxa.kd.j;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

class c$1
  implements Runnable
{
  c$1(c paramc, com.tencent.luggage.wxa.jx.c paramc1, int paramInt, JSONObject paramJSONObject) {}
  
  public void run()
  {
    if (!this.a.d())
    {
      o.c("MicroMsg.JsApiCanvasToTempFilePath", "invoke JsApi insertView failed, current page view is null.");
      this.a.a(this.b, this.d.b("fail"));
      return;
    }
    e locale = ((g)this.a.a(g.class)).a(this.a, this.c);
    if (locale == null)
    {
      o.c("MicroMsg.JsApiCanvasToTempFilePath", "invoke JsApi canvasToTempFilePath failed, component view is null.");
      this.a.a(this.b, this.d.b("fail:page is null"));
      return;
    }
    c.a(this.d, locale, this.c, new j(this.a, this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kq.c.1
 * JD-Core Version:    0.7.0.1
 */