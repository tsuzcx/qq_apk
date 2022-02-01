package com.tencent.biz.videostory.config.processor;

import org.json.JSONObject;

public class VSEntranceWidgetBean
{
  private String a = "";
  private String b = "";
  private String c = "";
  
  public static VSEntranceWidgetBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      VSEntranceWidgetBean localVSEntranceWidgetBean = new VSEntranceWidgetBean();
      paramString = new JSONObject(paramString);
      localVSEntranceWidgetBean.a = paramString.optString("icon_image_url", "");
      localVSEntranceWidgetBean.b = paramString.optString("md5", "");
      localVSEntranceWidgetBean.c = paramString.optString("widget_id", "");
      return localVSEntranceWidgetBean;
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
  
  public String b()
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
    localStringBuilder.append("\n k = md5, value = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("\n k = widget_id, value = ");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.config.processor.VSEntranceWidgetBean
 * JD-Core Version:    0.7.0.1
 */