package com.tencent.a.a.a.a;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  long T = 0L;
  String a = null;
  String b = null;
  String c = "0";
  
  static c e(String paramString)
  {
    c localc = new c();
    if (h.b(paramString)) {}
    try
    {
      paramString = new JSONObject(paramString);
      if (!paramString.isNull("ui")) {
        localc.a = paramString.getString("ui");
      }
      if (!paramString.isNull("mc")) {
        localc.b = paramString.getString("mc");
      }
      if (!paramString.isNull("mid")) {
        localc.c = paramString.getString("mid");
      }
      if (!paramString.isNull("ts")) {
        localc.T = paramString.getLong("ts");
      }
      return localc;
    }
    catch (JSONException paramString)
    {
      Log.w("MID", paramString);
    }
    return localc;
  }
  
  private JSONObject n()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      h.a(localJSONObject, "ui", this.a);
      h.a(localJSONObject, "mc", this.b);
      h.a(localJSONObject, "mid", this.c);
      localJSONObject.put("ts", this.T);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      Log.w("MID", localJSONException);
    }
    return localJSONObject;
  }
  
  public final String a()
  {
    return this.c;
  }
  
  public final String toString()
  {
    return n().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.a.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */