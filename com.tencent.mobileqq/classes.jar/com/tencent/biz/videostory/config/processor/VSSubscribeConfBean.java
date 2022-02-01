package com.tencent.biz.videostory.config.processor;

import com.tencent.biz.videostory.config.VSConfigManager;
import org.json.JSONException;
import org.json.JSONObject;

public class VSSubscribeConfBean
{
  private String a = "1";
  private String b = "1";
  private String c = VSConfigManager.c;
  private String d = "1";
  private String e = "1";
  
  public static VSSubscribeConfBean a(String paramString)
  {
    VSSubscribeConfBean localVSSubscribeConfBean = new VSSubscribeConfBean();
    if (paramString != null) {}
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString != null)
      {
        localVSSubscribeConfBean.a = paramString.optString("subscribe_entrance_enable", "1");
        localVSSubscribeConfBean.b = paramString.optString("is_open_sharing", "1");
        localVSSubscribeConfBean.c = paramString.optString("subscribe_account_title", VSConfigManager.c);
        localVSSubscribeConfBean.d = paramString.optString("newfollowlist", "1");
        localVSSubscribeConfBean.e = paramString.optString("subscribe_publish_entrance_enable", "1");
      }
      return localVSSubscribeConfBean;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
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
  
  public String d()
  {
    return this.d;
  }
  
  public String e()
  {
    return this.e;
  }
  
  public String toString()
  {
    return "k =subscribe_entrance_enable , value = " + this.a + ",k =is_open_sharing , value = " + this.b + ",k =subscribe_account_title , value = " + this.c + ",k =subscribeAccountNewFollowListSwitch , value = " + this.d + ",k =subscribeAccountPublishEntranceSwitch , value = " + this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.config.processor.VSSubscribeConfBean
 * JD-Core Version:    0.7.0.1
 */