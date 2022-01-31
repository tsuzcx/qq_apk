package c.t.m.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import java.util.Map;
import org.json.JSONObject;

public final class bw
  extends br
{
  final ae a = new ae();
  
  public bw()
  {
    m.j().post(new bx(this));
  }
  
  static String d()
  {
    StringBuilder localStringBuilder = new StringBuilder("Halley_Cloud_Param_Content_").append(m.c()).append("_for_SettingsHandler");
    m.b();
    return localStringBuilder.toString();
  }
  
  public final void a(bn parambn)
  {
    String str = this.a.c();
    parambn.a.put("confVersion", str);
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
          m.a().getSharedPreferences(d(), 0).edit().putString("halley_cloud_param_content", paramJSONObject).commit();
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
      m.j().post(new by(this));
    }
  }
  
  public final void b()
  {
    m.j().post(new by(this));
  }
  
  public final String c()
  {
    return "settings";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.bw
 * JD-Core Version:    0.7.0.1
 */