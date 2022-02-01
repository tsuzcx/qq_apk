package com.huawei.hms.hatool;

import org.json.JSONObject;

public class c1
  extends n
{
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g;
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("androidid", this.a);
    localJSONObject.put("oaid", this.g);
    localJSONObject.put("uuid", this.f);
    localJSONObject.put("upid", this.e);
    localJSONObject.put("imei", this.b);
    localJSONObject.put("sn", this.c);
    localJSONObject.put("udid", this.d);
    return localJSONObject;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public void c(String paramString)
  {
    this.g = paramString;
  }
  
  public void d(String paramString)
  {
    this.c = paramString;
  }
  
  public void e(String paramString)
  {
    this.d = paramString;
  }
  
  public void f(String paramString)
  {
    this.e = paramString;
  }
  
  public void g(String paramString)
  {
    this.f = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.hatool.c1
 * JD-Core Version:    0.7.0.1
 */