package com.tencent.mobileqq.activity.contacts.topentry;

import org.json.JSONObject;

public class CTEntryMng$EntryUserSetting
{
  public int a;
  public short b;
  public short c;
  
  public JSONObject a()
  {
    JSONObject localJSONObject;
    try
    {
      localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("entryId", this.a);
        localJSONObject.put("flagId", this.b);
        localJSONObject.put("flagValue", this.c);
        return localJSONObject;
      }
      catch (Exception localException1) {}
      localException2.printStackTrace();
    }
    catch (Exception localException2)
    {
      localJSONObject = null;
    }
    return localJSONObject;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.a = paramJSONObject.optInt("entryId");
      this.b = ((short)paramJSONObject.optInt("flagId"));
      this.c = ((short)paramJSONObject.optInt("flagValue"));
    }
  }
  
  boolean b()
  {
    return (this.b != 0) && (this.c == 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng.EntryUserSetting
 * JD-Core Version:    0.7.0.1
 */