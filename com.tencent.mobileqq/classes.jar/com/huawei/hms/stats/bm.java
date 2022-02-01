package com.huawei.hms.stats;

import org.json.JSONObject;

public class bm
  extends u
{
  private String g = "";
  
  public JSONObject c()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("protocol_version", "1");
    localJSONObject.put("compress_mode", "1");
    localJSONObject.put("serviceid", this.d);
    localJSONObject.put("appid", this.a);
    localJSONObject.put("hmac", this.g);
    localJSONObject.put("chifer", this.f);
    localJSONObject.put("timestamp", this.b);
    localJSONObject.put("servicetag", this.c);
    localJSONObject.put("requestid", this.e);
    return localJSONObject;
  }
  
  public void g(String paramString)
  {
    this.g = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.stats.bm
 * JD-Core Version:    0.7.0.1
 */