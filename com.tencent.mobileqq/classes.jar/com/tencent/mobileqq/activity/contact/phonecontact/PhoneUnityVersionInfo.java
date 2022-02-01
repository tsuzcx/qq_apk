package com.tencent.mobileqq.activity.contact.phonecontact;

import org.json.JSONException;
import org.json.JSONObject;

public class PhoneUnityVersionInfo
{
  public int a = -1;
  public long b;
  public int c;
  public long d;
  public long e;
  
  public static PhoneUnityVersionInfo a(String paramString)
  {
    PhoneUnityVersionInfo localPhoneUnityVersionInfo = new PhoneUnityVersionInfo();
    try
    {
      paramString = new JSONObject(paramString);
      localPhoneUnityVersionInfo.a = paramString.optInt("version", -1);
      localPhoneUnityVersionInfo.b = paramString.optLong("showDate", 0L);
      localPhoneUnityVersionInfo.d = paramString.optInt("leftShowNum", 0);
      localPhoneUnityVersionInfo.c = paramString.optInt("showCountEveryDay", 0);
      localPhoneUnityVersionInfo.e = paramString.optInt("leftLoginNum", 0);
      return localPhoneUnityVersionInfo;
    }
    catch (Exception paramString)
    {
      label76:
      break label76;
    }
    localPhoneUnityVersionInfo.a = -1;
    return localPhoneUnityVersionInfo;
  }
  
  public String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("version", this.a);
      localJSONObject.put("showDate", this.b);
      localJSONObject.put("leftShowNum", this.d);
      localJSONObject.put("showCountEveryDay", this.c);
      localJSONObject.put("leftLoginNum", this.e);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MobileUnityVersionInfo [version=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", showDate=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", leftShowNum=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", leftLoginNum = ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", showCountEveryDay=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityVersionInfo
 * JD-Core Version:    0.7.0.1
 */