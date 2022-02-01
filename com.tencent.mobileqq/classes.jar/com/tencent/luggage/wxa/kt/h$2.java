package com.tencent.luggage.wxa.kt;

import com.tencent.luggage.wxa.id.a.b;
import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class h$2
  implements b.a
{
  h$2(h paramh, a.b paramb, e parame) {}
  
  public void a(String paramString1, String paramString2, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    h.b localb = new h.b();
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", paramString2);
    localHashMap.put("stage", paramString1);
    localHashMap.put("drag", paramJSONObject1);
    localHashMap.put("target", paramJSONObject2);
    localb.b(localHashMap);
    o.d("MicroMsg.JsApiInsertTextView", "callback stage:%s, drag:%s, data:%s， target:%s", new Object[] { paramString1, paramJSONObject1, paramString2, paramJSONObject2 });
    if ("webview".equals(this.a.b("sendTo", null)))
    {
      this.b.a(localb);
      return;
    }
    this.b.a(localb, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kt.h.2
 * JD-Core Version:    0.7.0.1
 */