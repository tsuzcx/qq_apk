package com.tencent.biz.subscribe;

import org.json.JSONObject;

public class SubscribeJsPlugin$SafeJsonObject
  extends JSONObject
{
  public SubscribeJsPlugin$SafeJsonObject(SubscribeJsPlugin paramSubscribeJsPlugin, String paramString)
  {
    super(paramString);
  }
  
  public int getInt(String paramString)
  {
    if (!has(paramString)) {
      return 0;
    }
    return super.getInt(paramString);
  }
  
  public String getString(String paramString)
  {
    if (!has(paramString)) {
      return "";
    }
    return super.getString(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.SubscribeJsPlugin.SafeJsonObject
 * JD-Core Version:    0.7.0.1
 */