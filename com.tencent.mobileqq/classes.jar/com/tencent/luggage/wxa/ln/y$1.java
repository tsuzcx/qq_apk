package com.tencent.luggage.wxa.ln;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.mm.plugin.appbrand.page.o;
import com.tencent.mm.plugin.appbrand.page.u;
import org.json.JSONObject;

class y$1
  implements Runnable
{
  y$1(y paramy, JSONObject paramJSONObject, h paramh, int paramInt) {}
  
  public void run()
  {
    String str = this.a.optString("color", "");
    u localu = this.b.q().C().getPageView();
    if (localu == null)
    {
      this.b.a(this.c, this.d.b("fail:page don't exist"));
      return;
    }
    if ((str.equals("white")) || (str.equals("black"))) {
      localu.h(str);
    }
    this.b.a(this.c, this.d.b("ok"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ln.y.1
 * JD-Core Version:    0.7.0.1
 */