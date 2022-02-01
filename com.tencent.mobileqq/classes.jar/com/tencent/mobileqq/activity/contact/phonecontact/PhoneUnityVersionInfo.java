package com.tencent.mobileqq.activity.contact.phonecontact;

import org.json.JSONException;
import org.json.JSONObject;

public class PhoneUnityVersionInfo
{
  public int a;
  public long a;
  public int b;
  public long b;
  public long c;
  
  public PhoneUnityVersionInfo()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public static PhoneUnityVersionInfo a(String paramString)
  {
    PhoneUnityVersionInfo localPhoneUnityVersionInfo = new PhoneUnityVersionInfo();
    try
    {
      paramString = new JSONObject(paramString);
      localPhoneUnityVersionInfo.jdField_a_of_type_Int = paramString.optInt("version", -1);
      localPhoneUnityVersionInfo.jdField_a_of_type_Long = paramString.optLong("showDate", 0L);
      localPhoneUnityVersionInfo.jdField_b_of_type_Long = paramString.optInt("leftShowNum", 0);
      localPhoneUnityVersionInfo.jdField_b_of_type_Int = paramString.optInt("showCountEveryDay", 0);
      localPhoneUnityVersionInfo.c = paramString.optInt("leftLoginNum", 0);
      return localPhoneUnityVersionInfo;
    }
    catch (Exception paramString)
    {
      localPhoneUnityVersionInfo.jdField_a_of_type_Int = -1;
    }
    return localPhoneUnityVersionInfo;
  }
  
  public String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("version", this.jdField_a_of_type_Int);
      localJSONObject.put("showDate", this.jdField_a_of_type_Long);
      localJSONObject.put("leftShowNum", this.jdField_b_of_type_Long);
      localJSONObject.put("showCountEveryDay", this.jdField_b_of_type_Int);
      localJSONObject.put("leftLoginNum", this.c);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public String toString()
  {
    return "MobileUnityVersionInfo [version=" + this.jdField_a_of_type_Int + ", showDate=" + this.jdField_a_of_type_Long + ", leftShowNum=" + this.jdField_b_of_type_Long + ", leftLoginNum = " + this.c + ", showCountEveryDay=" + this.jdField_b_of_type_Int + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityVersionInfo
 * JD-Core Version:    0.7.0.1
 */