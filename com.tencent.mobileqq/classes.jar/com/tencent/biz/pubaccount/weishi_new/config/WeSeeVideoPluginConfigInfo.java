package com.tencent.biz.pubaccount.weishi_new.config;

import org.json.JSONObject;

public class WeSeeVideoPluginConfigInfo
  extends BaseConfigInfo
{
  public long a;
  public boolean a;
  
  public WeSeeVideoPluginConfigInfo(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
  }
  
  public static WeSeeVideoPluginConfigInfo a(JSONObject paramJSONObject)
  {
    return new WeSeeVideoPluginConfigInfo(paramJSONObject);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("isPreloadVideoPlugin");
      this.jdField_a_of_type_Long = paramJSONObject.optLong("queryPluginTimeInterval");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = 3600L;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WeSeeVideoPluginConfigInfo{mIsPreloadPluginInWsRecommend=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", mQueryPluginTimeInterval=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.config.WeSeeVideoPluginConfigInfo
 * JD-Core Version:    0.7.0.1
 */