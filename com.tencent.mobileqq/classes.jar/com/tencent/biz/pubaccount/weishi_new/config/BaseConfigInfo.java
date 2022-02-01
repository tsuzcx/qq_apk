package com.tencent.biz.pubaccount.weishi_new.config;

import org.json.JSONObject;

public abstract class BaseConfigInfo
{
  public BaseConfigInfo(JSONObject paramJSONObject)
  {
    a(paramJSONObject);
  }
  
  public abstract void a(JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.config.BaseConfigInfo
 * JD-Core Version:    0.7.0.1
 */