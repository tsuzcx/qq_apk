package com.huawei.hms.hatool;

import android.text.TextUtils;
import org.json.JSONObject;

public class q
  implements s
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("type", this.a);
    localJSONObject.put("eventtime", this.d);
    localJSONObject.put("event", this.b);
    localJSONObject.put("event_session_name", this.e);
    localJSONObject.put("first_session_event", this.f);
    if (TextUtils.isEmpty(this.c)) {
      return null;
    }
    localJSONObject.put("properties", new JSONObject(this.c));
    return localJSONObject;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    this.b = paramJSONObject.optString("event");
    this.c = paramJSONObject.optString("properties");
    String str = d0.f().a();
    this.c = d.a(this.c, str);
    this.a = paramJSONObject.optString("type");
    this.d = paramJSONObject.optString("eventtime");
    this.e = paramJSONObject.optString("event_session_name");
    this.f = paramJSONObject.optString("first_session_event");
  }
  
  public String b()
  {
    return this.d;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public String c()
  {
    return this.a;
  }
  
  public void c(String paramString)
  {
    this.d = paramString;
  }
  
  public JSONObject d()
  {
    JSONObject localJSONObject = a();
    String str = d0.f().a();
    localJSONObject.put("properties", d.b(this.c, str));
    return localJSONObject;
  }
  
  public void d(String paramString)
  {
    this.a = paramString;
  }
  
  public void e(String paramString)
  {
    this.f = paramString;
  }
  
  public void f(String paramString)
  {
    this.e = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.hatool.q
 * JD-Core Version:    0.7.0.1
 */