package com.tencent.map.sdk.a;

import org.json.JSONException;
import org.json.JSONObject;

final class jg$b
{
  boolean a = false;
  long b = 0L;
  
  final JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("success", this.a);
      localJSONObject.put("loadBeginTime", this.b);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.jg.b
 * JD-Core Version:    0.7.0.1
 */