package com.tencent.luggage.wxa.jz;

import com.tencent.luggage.wxa.id.a.b;
import com.tencent.luggage.wxa.iu.c.c;
import com.tencent.luggage.wxa.jx.c;
import org.json.JSONException;
import org.json.JSONObject;

class o$1
  extends c.c
{
  o$1(o paramo, a.b paramb, c paramc, int paramInt) {}
  
  public void c()
  {
    String str = this.a.b("appId", "");
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.Music.JsApiSetBackgroundAudioState", "onDestroy, appId:%s", new Object[] { str });
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("operationType", "stop");
      label44:
      o.b localb = new o.b(this.d, this.b, this.c);
      localb.e = localJSONObject.toString();
      localb.c = str;
      localb.f();
      return;
    }
    catch (JSONException localJSONException)
    {
      break label44;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jz.o.1
 * JD-Core Version:    0.7.0.1
 */