package c.t.m.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import java.util.Map;
import org.json.JSONObject;

public final class bp
  extends bk
{
  aa a = new aa();
  
  public bp()
  {
    String str = l.a().getSharedPreferences(d(), 0).getString("halley_cloud_param_content", "");
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      this.a.a(str);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      l.a().getSharedPreferences(d(), 0).edit().putString("halley_cloud_param_content", "").commit();
    }
  }
  
  private static String d()
  {
    StringBuilder localStringBuilder = new StringBuilder("Halley_Cloud_Param_Content_").append(l.c()).append("_for_SettingsHandler");
    l.b();
    return localStringBuilder.toString();
  }
  
  public final void a(bg parambg)
  {
    String str = this.a.c();
    parambg.a.put("confVersion", str);
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
          paramJSONObject = this.a.a.toString();
          l.a().getSharedPreferences(d(), 0).edit().putString("halley_cloud_param_content", paramJSONObject).commit();
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
      l.j().post(new bq(this));
    }
  }
  
  public final void b()
  {
    l.j().post(new bq(this));
  }
  
  public final String c()
  {
    return "settings";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.bp
 * JD-Core Version:    0.7.0.1
 */