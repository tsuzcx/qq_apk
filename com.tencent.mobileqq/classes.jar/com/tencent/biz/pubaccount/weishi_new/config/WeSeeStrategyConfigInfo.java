package com.tencent.biz.pubaccount.weishi_new.config;

import org.json.JSONObject;

public class WeSeeStrategyConfigInfo
  extends BaseConfigInfo
{
  public String a;
  
  public WeSeeStrategyConfigInfo(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
  }
  
  public static WeSeeStrategyConfigInfo b(JSONObject paramJSONObject)
  {
    return new WeSeeStrategyConfigInfo(paramJSONObject);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      this.a = paramJSONObject.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.config.WeSeeStrategyConfigInfo
 * JD-Core Version:    0.7.0.1
 */