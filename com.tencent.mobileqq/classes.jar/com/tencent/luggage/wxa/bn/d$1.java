package com.tencent.luggage.wxa.bn;

import com.tencent.luggage.wxa.bs.c;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.ku.f.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.u;
import org.json.JSONObject;

class d$1
  implements Runnable
{
  d$1(d paramd, h paramh, int paramInt, JSONObject paramJSONObject) {}
  
  public void run()
  {
    if (!this.a.d())
    {
      o.c("MicroMsg.WAGameJsApiCanvasToTempFilePath", "invoke JsApi insertView failed, current page view is null.");
      this.a.a(this.b, this.d.b("fail"));
      return;
    }
    Object localObject = this.a.v();
    if ((c)((u)localObject).d(c.class) == null)
    {
      this.a.a(this.b, this.d.b("fail"));
      return;
    }
    localObject = d.a((u)localObject, this.c, false);
    this.a.a(this.b, this.d.a(((f.a)localObject).b, ((f.a)localObject).a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bn.d.1
 * JD-Core Version:    0.7.0.1
 */