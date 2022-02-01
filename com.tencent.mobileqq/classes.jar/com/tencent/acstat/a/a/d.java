package com.tencent.acstat.a.a;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class d
{
  public String a = null;
  public String b = null;
  public String c = "0";
  public long d = 0L;
  
  static d a(String paramString)
  {
    d locald = new d();
    if (i.b(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        if (!paramString.isNull("ui")) {
          locald.a = paramString.getString("ui");
        }
        if (!paramString.isNull("mc")) {
          locald.b = paramString.getString("mc");
        }
        if (!paramString.isNull("mid")) {
          locald.c = paramString.getString("mid");
        }
        if (!paramString.isNull("ts"))
        {
          locald.d = paramString.getLong("ts");
          return locald;
        }
      }
      catch (JSONException paramString)
      {
        Log.w("MID", "", paramString);
      }
    }
    return locald;
  }
  
  boolean a()
  {
    return i.c(this.c);
  }
  
  JSONObject b()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      i.a(localJSONObject, "ui", this.a);
      i.a(localJSONObject, "mc", this.b);
      i.a(localJSONObject, "mid", this.c);
      localJSONObject.put("ts", this.d);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      i.a(localJSONException);
    }
    return localJSONObject;
  }
  
  public String toString()
  {
    return b().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.acstat.a.a.d
 * JD-Core Version:    0.7.0.1
 */