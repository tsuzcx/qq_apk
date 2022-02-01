package com.huawei.hms.activity.internal;

import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class ForegroundInnerHeader
{
  private final String TAG = "ForegroundInnerHeader";
  private String action;
  private int apkVersion;
  private String responseCallbackKey;
  
  public void fromJson(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.apkVersion = JsonUtil.getIntValue(paramString, "apkVersion");
      this.action = JsonUtil.getStringValue(paramString, "action");
      this.responseCallbackKey = JsonUtil.getStringValue(paramString, "responseCallbackKey");
      return;
    }
    catch (JSONException paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fromJson failed: ");
      localStringBuilder.append(paramString.getMessage());
      HMSLog.e("ForegroundInnerHeader", localStringBuilder.toString());
    }
  }
  
  public String getAction()
  {
    return this.action;
  }
  
  public int getApkVersion()
  {
    return this.apkVersion;
  }
  
  public String getResponseCallbackKey()
  {
    return this.responseCallbackKey;
  }
  
  public void setAction(String paramString)
  {
    this.action = paramString;
  }
  
  public void setApkVersion(int paramInt)
  {
    this.apkVersion = paramInt;
  }
  
  public void setResponseCallbackKey(String paramString)
  {
    this.responseCallbackKey = paramString;
  }
  
  public String toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("apkVersion", this.apkVersion);
      localJSONObject.put("action", this.action);
      localJSONObject.put("responseCallbackKey", this.responseCallbackKey);
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ForegroundInnerHeader toJson failed: ");
      localStringBuilder.append(localJSONException.getMessage());
      HMSLog.e("ForegroundInnerHeader", localStringBuilder.toString());
    }
    return localJSONObject.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("apkVersion:");
    localStringBuilder.append(this.apkVersion);
    localStringBuilder.append(", action:");
    localStringBuilder.append(this.action);
    localStringBuilder.append(", responseCallbackKey:");
    localStringBuilder.append(this.responseCallbackKey);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.activity.internal.ForegroundInnerHeader
 * JD-Core Version:    0.7.0.1
 */