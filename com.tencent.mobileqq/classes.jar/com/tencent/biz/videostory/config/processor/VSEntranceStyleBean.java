package com.tencent.biz.videostory.config.processor;

import org.json.JSONObject;

public class VSEntranceStyleBean
{
  private String a = "";
  private JSONObject b = new JSONObject();
  private String c = "";
  
  public static VSEntranceStyleBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      VSEntranceStyleBean localVSEntranceStyleBean = new VSEntranceStyleBean();
      paramString = new JSONObject(paramString);
      localVSEntranceStyleBean.a = paramString.optString("icon_image_url", "");
      localVSEntranceStyleBean.b = paramString.optJSONObject("config");
      localVSEntranceStyleBean.c = paramString.optString("md5", "");
      return localVSEntranceStyleBean;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public JSONObject b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("k = icon_image_url, value = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\n k = config, value = ");
    localStringBuilder.append(this.b.toString());
    localStringBuilder.append("\n k = md5, value = ");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.config.processor.VSEntranceStyleBean
 * JD-Core Version:    0.7.0.1
 */