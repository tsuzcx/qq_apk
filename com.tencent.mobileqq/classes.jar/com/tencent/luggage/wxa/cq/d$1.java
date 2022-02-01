package com.tencent.luggage.wxa.cq;

import com.tencent.luggage.opensdk.f;
import com.tencent.luggage.opensdk.g.a;
import com.tencent.luggage.wxa.du.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rl.b;
import org.json.JSONException;
import org.json.JSONObject;

class d$1
  implements b<String, Void>
{
  d$1(d paramd, JSONObject paramJSONObject, c paramc, int paramInt) {}
  
  public String a(Void paramVoid)
  {
    try
    {
      this.a.put("sdk_isFromMenu", true);
      label11:
      paramVoid = f.a(this.b, this.d.d(), this.a, this.c).a("shareAppMessageDirectly").toString();
      o.b("Luggage.JsApiShareAppMessage", "params:%s", new Object[] { paramVoid });
      return paramVoid;
    }
    catch (JSONException paramVoid)
    {
      break label11;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cq.d.1
 * JD-Core Version:    0.7.0.1
 */