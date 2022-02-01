package com.tencent.mobileqq.activity.contacts.topentry;

import org.json.JSONException;
import org.json.JSONObject;

public class CTEntryMng$EntryRedDotInfo
{
  public int a;
  public int b;
  public boolean c;
  public boolean d;
  public long e;
  
  public JSONObject a()
  {
    JSONObject localJSONObject;
    try
    {
      localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("entryID", this.a);
        localJSONObject.put("redDotVersion", this.b);
        localJSONObject.put("showRedDot", this.c);
        localJSONObject.put("userCanceled", this.d);
        localJSONObject.put("lastCancelTime", this.e);
        return localJSONObject;
      }
      catch (JSONException localJSONException1) {}
      localJSONException2.printStackTrace();
    }
    catch (JSONException localJSONException2)
    {
      localJSONObject = null;
    }
    return localJSONObject;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.a = paramJSONObject.optInt("entryID");
      this.b = paramJSONObject.optInt("redDotVersion");
      this.c = paramJSONObject.optBoolean("showRedDot");
      this.d = paramJSONObject.optBoolean("userCanceled");
      this.e = paramJSONObject.optLong("lastCancelTime");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng.EntryRedDotInfo
 * JD-Core Version:    0.7.0.1
 */