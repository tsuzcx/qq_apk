package com.tencent.luggage.opensdk;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.h;
import org.json.JSONException;
import org.json.JSONObject;

final class m$4
  implements com.tencent.luggage.wxa.rl.b<JSONObject, String>
{
  m$4(com.tencent.luggage.wxa.iu.b paramb, f paramf) {}
  
  public JSONObject a(String paramString)
  {
    o.d("Luggage.QRCodeTransfer", "reqData:%s", new Object[] { paramString });
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("appid", this.a.getAppId());
      localJSONObject.put("req_data", paramString);
      return localJSONObject;
    }
    catch (JSONException paramString)
    {
      o.b("Luggage.QRCodeTransfer", "invoke, put fields api = %s, appId = %s, e = %s", new Object[] { this.b.d(), this.a.getAppId(), paramString });
      h.b().a(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.m.4
 * JD-Core Version:    0.7.0.1
 */