package com.tencent.map.sdk.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import java.util.Map;
import org.json.JSONObject;

public final class co
  extends cj
{
  final ax a = new ax();
  
  public co()
  {
    ac.h().post(new cp(this));
  }
  
  static String d()
  {
    StringBuilder localStringBuilder = new StringBuilder("Halley_Cloud_Param_Content_").append(ac.c()).append("_for_SettingsHandler");
    if (ac.b()) {}
    for (String str = "_test";; str = "") {
      return str;
    }
  }
  
  public final void a(cf paramcf)
  {
    String str = this.a.c();
    paramcf.a.put("confVersion", str);
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.optJSONObject("Setting");
      if (paramJSONObject != null)
      {
        paramJSONObject = paramJSONObject.optString("data");
        if (!TextUtils.isEmpty(paramJSONObject))
        {
          this.a.a(paramJSONObject);
          paramJSONObject = this.a.a();
          ac.a().getSharedPreferences(d(), 0).edit().putString("halley_cloud_param_content", paramJSONObject).commit();
        }
      }
      return;
    }
    catch (Throwable paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      return;
    }
    finally
    {
      ac.h().post(new cq(this));
    }
  }
  
  public final void b()
  {
    ac.h().post(new cq(this));
  }
  
  public final String c()
  {
    return "settings";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.co
 * JD-Core Version:    0.7.0.1
 */