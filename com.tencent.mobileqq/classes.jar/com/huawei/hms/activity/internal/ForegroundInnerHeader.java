package com.huawei.hms.activity.internal;

import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class ForegroundInnerHeader
{
  private int a;
  private String b;
  private String c;
  private final String d = "ForegroundInnerHeader";
  
  public void fromJson(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.a = JsonUtil.getIntValue(paramString, "apkVersion");
      this.b = JsonUtil.getStringValue(paramString, "action");
      this.c = JsonUtil.getStringValue(paramString, "responseCallbackKey");
      return;
    }
    catch (JSONException paramString)
    {
      HMSLog.e("ForegroundInnerHeader", "fromJson failed: " + paramString.getMessage());
    }
  }
  
  public String getAction()
  {
    return this.b;
  }
  
  public int getApkVersion()
  {
    return this.a;
  }
  
  public String getResponseCallbackKey()
  {
    return this.c;
  }
  
  public void setAction(String paramString)
  {
    this.b = paramString;
  }
  
  public void setApkVersion(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setResponseCallbackKey(String paramString)
  {
    this.c = paramString;
  }
  
  public String toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("apkVersion", this.a);
      localJSONObject.put("action", this.b);
      localJSONObject.put("responseCallbackKey", this.c);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        HMSLog.e("ForegroundInnerHeader", "ForegroundInnerHeader toJson failed: " + localJSONException.getMessage());
      }
    }
  }
  
  public String toString()
  {
    return "apkVersion:" + this.a + ", action:" + this.b + ", responseCallbackKey:" + this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.activity.internal.ForegroundInnerHeader
 * JD-Core Version:    0.7.0.1
 */