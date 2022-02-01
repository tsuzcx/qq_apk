package com.huawei.hms.hatool;

import android.os.Build;
import org.json.JSONObject;

public class e1
  extends p
{
  public String f;
  public String g;
  public String h;
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("_rom_ver", this.h);
    localJSONObject.put("_emui_ver", this.a);
    localJSONObject.put("_model", Build.MODEL);
    localJSONObject.put("_mcc", this.f);
    localJSONObject.put("_mnc", this.g);
    localJSONObject.put("_package_name", this.b);
    localJSONObject.put("_app_ver", this.c);
    localJSONObject.put("_lib_ver", "2.2.0.308");
    localJSONObject.put("_channel", this.d);
    localJSONObject.put("_lib_name", "hianalytics");
    localJSONObject.put("_oaid_tracking_flag", this.e);
    return localJSONObject;
  }
  
  public void f(String paramString)
  {
    this.f = paramString;
  }
  
  public void g(String paramString)
  {
    this.g = paramString;
  }
  
  public void h(String paramString)
  {
    this.h = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.hatool.e1
 * JD-Core Version:    0.7.0.1
 */