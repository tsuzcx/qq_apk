package com.tencent.luggage.wxa.ln;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.jx.bd;
import com.tencent.mm.plugin.appbrand.page.u;
import org.json.JSONObject;

class j$1
  implements Runnable
{
  j$1(j paramj, b paramb, int paramInt, JSONObject paramJSONObject) {}
  
  public void run()
  {
    u localu = bd.a(this.a);
    if (localu == null)
    {
      this.a.a(this.b, this.d.b("fail:page don't exist"));
      return;
    }
    Object localObject = localu.d(j.a(this.d));
    if (localObject != null)
    {
      this.d.a(this.a, this.c, this.b, localObject);
      return;
    }
    if (!localu.d())
    {
      this.a.a(this.b, this.d.b("fail:interrupted"));
      return;
    }
    if (!localu.L())
    {
      this.a.a(this.b, this.d.b("fail:not supported"));
      return;
    }
    throw new IllegalAccessError(String.format("%s Not Found", new Object[] { j.a(this.d).getName() }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ln.j.1
 * JD-Core Version:    0.7.0.1
 */