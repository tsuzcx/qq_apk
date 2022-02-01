package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.jsonconverter.Alias;
import com.tencent.mobileqq.jsonconverter.JSONConverter;
import org.json.JSONObject;

public class AIOConfigData
{
  @Alias(a="structmsg_switch")
  public int a;
  @Alias(a="msf_http_monitor_ban")
  public boolean a;
  @Alias(a="structmsg_sampling")
  public int b;
  @Alias(a="structmsg_filternumber")
  public int c;
  @Alias(a="switch_background_start_activity")
  public int d;
  @Alias(a="switch_open_third_app")
  public int e;
  @Alias(a="switch_imei")
  public int f;
  @Alias(a="switch_msg_separate")
  public int g;
  
  public JSONObject a()
  {
    return JSONConverter.a(this);
  }
  
  public String toString()
  {
    return a().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOConfigData
 * JD-Core Version:    0.7.0.1
 */