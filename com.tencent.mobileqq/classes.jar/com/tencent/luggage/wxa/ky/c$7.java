package com.tencent.luggage.wxa.ky;

import com.tencent.luggage.wxa.jx.e;
import org.json.JSONException;
import org.json.JSONObject;

class c$7
  implements a.c
{
  c$7(c paramc, int paramInt, e parame) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    c.a locala = new c.a(null);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("fullScreen", paramBoolean);
      localJSONObject.put("direction", paramInt);
      localJSONObject.put("livePlayerId", this.a);
      label48:
      this.b.a(locala.b(localJSONObject.toString()), null);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label48;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ky.c.7
 * JD-Core Version:    0.7.0.1
 */