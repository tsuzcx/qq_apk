package com.tencent.biz.pubaccount.weishi_new.config;

import org.json.JSONObject;

public class WeSeeVideoPluginConfigInfo
  extends BaseConfigInfo
{
  public boolean a;
  public long b;
  
  public WeSeeVideoPluginConfigInfo(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
  }
  
  public static WeSeeVideoPluginConfigInfo b(JSONObject paramJSONObject)
  {
    return new WeSeeVideoPluginConfigInfo(paramJSONObject);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.a = paramJSONObject.optBoolean("isPreloadVideoPlugin");
      this.b = paramJSONObject.optLong("queryPluginTimeInterval");
      return;
    }
    this.a = true;
    this.b = 3600L;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WeSeeVideoPluginConfigInfo{mIsPreloadPluginInWsRecommend=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mQueryPluginTimeInterval=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.config.WeSeeVideoPluginConfigInfo
 * JD-Core Version:    0.7.0.1
 */