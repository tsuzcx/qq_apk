package com.tencent.biz.pubaccount.weishi_new.config;

import org.json.JSONObject;

public class WeSeeWnsConfigInfo
  extends BaseConfigInfo
{
  private boolean a;
  
  public WeSeeWnsConfigInfo(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
  }
  
  public static WeSeeWnsConfigInfo b(JSONObject paramJSONObject)
  {
    return new WeSeeWnsConfigInfo(paramJSONObject);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.a = paramJSONObject.optBoolean("is_remove_wns", false);
      return;
    }
    this.a = false;
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WeSeeWnsConfigInfo{mIsRemoveWns=");
    localStringBuilder.append(this.a);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.config.WeSeeWnsConfigInfo
 * JD-Core Version:    0.7.0.1
 */