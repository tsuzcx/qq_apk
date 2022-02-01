package com.tencent.luggage.wxa.ka;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

class d$3
  implements d.a
{
  d$3(d paramd1, b paramb, g paramg, d paramd2, JSONObject paramJSONObject, int paramInt) {}
  
  public void a()
  {
    o.d("MicroMsg.AppBrandAuthJsApiQueue", "about to call AuthInvoke, api[%s]", new Object[] { this.f.q() });
    if (!this.a.d())
    {
      o.b("MicroMsg.AppBrandAuthJsApiQueue", "doAuth but component not running, api = %s", new Object[] { this.b.d() });
      this.c.a();
      return;
    }
    this.b.a(this.a, this.d, this.e, new a(this.c));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(hashCode());
    localStringBuilder.append("|");
    localStringBuilder.append(this.b.d());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ka.d.3
 * JD-Core Version:    0.7.0.1
 */