package com.tencent.luggage.wxa.ky;

import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class d$12
  implements b.b
{
  d$12(d paramd, int paramInt, e parame) {}
  
  public void a(int paramInt, String paramString, HashMap<String, Object> paramHashMap)
  {
    o.d("MicroMsg.JsApiInsertLivePusher", "onError, error:%s", new Object[] { Integer.valueOf(paramInt) });
    d.a locala = new d.a(null);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("errCode", paramInt);
      localJSONObject.put("errMsg", af.b(paramString));
      localJSONObject.put("livePusherId", this.a);
      if ((paramHashMap != null) && (!paramHashMap.isEmpty())) {
        localJSONObject.put("data", new JSONObject(paramHashMap));
      }
    }
    catch (JSONException paramString)
    {
      o.b("MicroMsg.JsApiInsertLivePusher", "onError fail", new Object[] { paramString });
    }
    this.b.a(locala.b(localJSONObject.toString()), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ky.d.12
 * JD-Core Version:    0.7.0.1
 */