package com.huawei.hms.stats;

import org.json.JSONObject;

public class bl
  extends t
{
  protected String b = "";
  private String c = "";
  private String d = "";
  private String e = "";
  private String f = "";
  private String g;
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public JSONObject c()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("androidid", this.a);
    localJSONObject.put("oaid", this.g);
    localJSONObject.put("uuid", this.b);
    localJSONObject.put("upid", this.f);
    localJSONObject.put("imei", this.c);
    localJSONObject.put("sn", this.d);
    localJSONObject.put("udid", this.e);
    return localJSONObject;
  }
  
  public void c(String paramString)
  {
    this.d = paramString;
  }
  
  public void d(String paramString)
  {
    this.f = paramString;
  }
  
  public void e(String paramString)
  {
    this.e = paramString;
  }
  
  public void f(String paramString)
  {
    this.b = paramString;
  }
  
  public void g(String paramString)
  {
    this.g = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.stats.bl
 * JD-Core Version:    0.7.0.1
 */