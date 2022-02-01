package com.tencent.biz.videostory.config.processor;

import com.tencent.biz.videostory.config.VSConfigManager;
import org.json.JSONObject;

public class VSEntranceConfBean
{
  private String a = VSConfigManager.b;
  private String b = "1";
  private String c = VSConfigManager.a;
  
  public static VSEntranceConfBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      VSEntranceConfBean localVSEntranceConfBean = new VSEntranceConfBean();
      paramString = new JSONObject(paramString);
      localVSEntranceConfBean.a = paramString.optString("mine_videostory_entrance", VSConfigManager.b);
      localVSEntranceConfBean.b = paramString.optString("enable_click_take_picture", "1");
      localVSEntranceConfBean.c = paramString.optString("mine_videostory_drawer_entrance", VSConfigManager.a);
      return localVSEntranceConfBean;
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
    localStringBuilder.append("k = mine_videostory_entrance, value = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\n k = enableClickTakePicture, value = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("\n k = mine_videostory_chouti_entrance, value = ");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.videostory.config.processor.VSEntranceConfBean
 * JD-Core Version:    0.7.0.1
 */