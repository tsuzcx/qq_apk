package com.tencent.mobileqq.activity.contacts.topentry;

import org.json.JSONException;
import org.json.JSONObject;

public class CTEntryMng$EntryRedDotInfo
{
  public int a;
  public long a;
  public boolean a;
  public int b;
  public boolean b;
  
  public JSONObject a()
  {
    JSONObject localJSONObject;
    try
    {
      localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("entryID", this.jdField_a_of_type_Int);
        localJSONObject.put("redDotVersion", this.jdField_b_of_type_Int);
        localJSONObject.put("showRedDot", this.jdField_a_of_type_Boolean);
        localJSONObject.put("userCanceled", this.jdField_b_of_type_Boolean);
        localJSONObject.put("lastCancelTime", this.jdField_a_of_type_Long);
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
      this.jdField_a_of_type_Int = paramJSONObject.optInt("entryID");
      this.jdField_b_of_type_Int = paramJSONObject.optInt("redDotVersion");
      this.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("showRedDot");
      this.jdField_b_of_type_Boolean = paramJSONObject.optBoolean("userCanceled");
      this.jdField_a_of_type_Long = paramJSONObject.optLong("lastCancelTime");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng.EntryRedDotInfo
 * JD-Core Version:    0.7.0.1
 */