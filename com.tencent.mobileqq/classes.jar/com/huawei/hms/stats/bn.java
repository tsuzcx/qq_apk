package com.huawei.hms.stats;

import android.os.Build;
import org.json.JSONObject;

public class bn
  extends v
{
  String f;
  String g;
  private String h;
  
  public JSONObject c()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("_rom_ver", this.h);
    localJSONObject.put("_emui_ver", this.a);
    localJSONObject.put("_model", Build.MODEL);
    localJSONObject.put("_mcc", this.f);
    localJSONObject.put("_mnc", this.g);
    localJSONObject.put("_package_name", this.b);
    localJSONObject.put("_app_ver", this.c);
    localJSONObject.put("_lib_ver", "2.2.0.305");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.stats.bn
 * JD-Core Version:    0.7.0.1
 */