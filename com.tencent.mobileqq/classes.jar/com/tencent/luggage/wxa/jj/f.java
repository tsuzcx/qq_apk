package com.tencent.luggage.wxa.jj;

import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

class f
{
  static JSONObject a(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString1);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      o.b("Luggage.AppBrandConfigParser", "parse by string, USE_MINIMAL:%b, length:%d, reason:%s, exception:%s", new Object[] { Boolean.valueOf(false), Integer.valueOf(af.b(paramString1).length()), paramString2, localException });
    }
    return new JSONObject();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jj.f
 * JD-Core Version:    0.7.0.1
 */