import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class axnl
{
  public String a;
  private boolean a;
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  
  public axnl()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static axnl a(Context paramContext, String paramString, int paramInt)
  {
    try
    {
      paramString = (String)axqc.a(paramString, "cike_guide_content", "");
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString);
        if (paramInt == 0) {
          paramString = paramString.optJSONObject("publish_menu_alert_config");
        }
        for (;;)
        {
          return a(paramContext, paramString);
          if (paramInt == 1) {
            paramString = paramString.optJSONObject("sendmsg_alert_config");
          } else {
            paramString = paramString.optJSONObject("authenticated_user_alert_config");
          }
        }
      }
      QLog.e("CikeConfigData", 1, "parseManageConfig, get config failed");
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        QLog.e("CikeConfigData", 1, "parseManageConfig, exception: " + paramContext.getMessage());
      }
    }
    return null;
  }
  
  public static axnl a(Context paramContext, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      axnl localaxnl = new axnl();
      localaxnl.jdField_a_of_type_JavaLangString = paramJSONObject.optString("iconurl");
      localaxnl.b = paramJSONObject.optString("title_text");
      if (a(paramContext))
      {
        localaxnl.jdField_a_of_type_Boolean = true;
        localaxnl.c = paramJSONObject.optString("download_installapp_text");
      }
      for (localaxnl.d = paramJSONObject.optString("jump_app_scheme");; localaxnl.d = paramJSONObject.optString("download_url_android"))
      {
        localaxnl.e = paramJSONObject.optString("moreurl");
        return localaxnl;
        localaxnl.jdField_a_of_type_Boolean = false;
        localaxnl.c = paramJSONObject.optString("download_text");
      }
    }
    QLog.e("CikeConfigData", 1, "parseJson, config is null");
    return null;
  }
  
  public static boolean a(Context paramContext)
  {
    return bhfn.a(paramContext, "com.tencent.litenow");
  }
  
  public void a(long paramLong)
  {
    if ((this.jdField_a_of_type_Boolean) && (paramLong != 0L) && (!TextUtils.isEmpty(this.d)))
    {
      if (this.d.contains("?")) {
        this.d = (this.d + "&uid=" + paramLong);
      }
    }
    else {
      return;
    }
    this.d = (this.d + "?uid=" + paramLong);
  }
  
  public String toString()
  {
    return "imageUrl:" + this.jdField_a_of_type_JavaLangString + " titleTxt:" + this.b + " btnTxt:" + this.c + " btnUrl:" + this.d + " moreUrl:" + this.e + " d1:" + this.f + " toUin: " + this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axnl
 * JD-Core Version:    0.7.0.1
 */