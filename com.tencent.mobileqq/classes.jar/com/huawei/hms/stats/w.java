package com.huawei.hms.stats;

import android.text.TextUtils;
import org.json.JSONObject;

public class w
  implements y
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  
  public String a()
  {
    return this.a;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    this.b = paramJSONObject.optString("event");
    this.c = paramJSONObject.optString("properties");
    String str = am.a().c();
    this.c = e.a().a(e.a.a).a(str, this.c);
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
  
  public JSONObject c()
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
  
  public void c(String paramString)
  {
    this.c = paramString;
  }
  
  public JSONObject d()
  {
    JSONObject localJSONObject = c();
    String str = am.a().c();
    localJSONObject.put("properties", e.a().a(e.a.a).b(str, this.c));
    return localJSONObject;
  }
  
  public void d(String paramString)
  {
    this.d = paramString;
  }
  
  public void e(String paramString)
  {
    this.e = paramString;
  }
  
  public void f(String paramString)
  {
    this.f = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.stats.w
 * JD-Core Version:    0.7.0.1
 */