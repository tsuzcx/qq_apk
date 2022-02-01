package com.tencent.biz.pubaccount.weishi_new.config;

import org.json.JSONObject;

public class WeSeeBeaconReportConfigInfo
  extends BaseConfigInfo
{
  public boolean a;
  
  public WeSeeBeaconReportConfigInfo(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
  }
  
  public static WeSeeBeaconReportConfigInfo a(JSONObject paramJSONObject)
  {
    return new WeSeeBeaconReportConfigInfo(paramJSONObject);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.a = paramJSONObject.optBoolean("isImmediatelyUpload");
      return;
    }
    this.a = false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WeSeeBeaconReportConfigInfo{mIsImmediatelyUpload=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.config.WeSeeBeaconReportConfigInfo
 * JD-Core Version:    0.7.0.1
 */