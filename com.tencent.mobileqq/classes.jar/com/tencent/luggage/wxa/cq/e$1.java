package com.tencent.luggage.wxa.cq;

import com.tencent.luggage.opensdk.f;
import com.tencent.luggage.opensdk.g.a;
import org.json.JSONException;
import org.json.JSONObject;

class e$1
  implements com.tencent.luggage.wxa.rl.b<String, Void>
{
  e$1(e parame, JSONObject paramJSONObject, com.tencent.luggage.wxa.iu.b paramb, int paramInt) {}
  
  public String a(Void paramVoid)
  {
    try
    {
      this.a.put("sdk_isFromMenu", false);
      label11:
      return f.a(this.b, this.d.d(), this.a, this.c).toString();
    }
    catch (JSONException paramVoid)
    {
      break label11;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cq.e.1
 * JD-Core Version:    0.7.0.1
 */