package com.tencent.mobileqq.ark.secure;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class ArkSecurityReporter$ReportItem
{
  public String a = "android";
  public String b;
  public String c;
  public int d;
  public int e;
  public int f;
  public String g = ArkSecurityReporter.a();
  
  public String toString()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("os", this.a);
      localJSONObject.put("app", this.b);
      localJSONObject.put("url", this.c);
      localJSONObject.put("result", this.d);
      localJSONObject.put("scene", this.e);
      localJSONObject.put("type", this.f);
      localJSONObject.put("ver", this.g);
    }
    catch (JSONException localJSONException)
    {
      QLog.e("ArkApp.ArkSecurityReporter", 1, "ArkSafe.report exception=", localJSONException);
    }
    return localJSONObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.secure.ArkSecurityReporter.ReportItem
 * JD-Core Version:    0.7.0.1
 */