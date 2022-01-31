import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class asyr
{
  public String a;
  private boolean a;
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  
  public asyr()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static asyr a(Context paramContext, String paramString, int paramInt)
  {
    try
    {
      paramString = (String)atbg.a(paramString, "cike_guide_content", "");
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
  
  public static asyr a(Context paramContext, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      asyr localasyr = new asyr();
      localasyr.jdField_a_of_type_JavaLangString = paramJSONObject.optString("iconurl");
      localasyr.b = paramJSONObject.optString("title_text");
      if (a(paramContext))
      {
        localasyr.jdField_a_of_type_Boolean = true;
        localasyr.c = paramJSONObject.optString("download_installapp_text");
      }
      for (localasyr.d = paramJSONObject.optString("jump_app_scheme");; localasyr.d = paramJSONObject.optString("download_url_android"))
      {
        localasyr.e = paramJSONObject.optString("moreurl");
        return localasyr;
        localasyr.jdField_a_of_type_Boolean = false;
        localasyr.c = paramJSONObject.optString("download_text");
      }
    }
    QLog.e("CikeConfigData", 1, "parseJson, config is null");
    return null;
  }
  
  public static boolean a(Context paramContext)
  {
    return bbfd.a(paramContext, "com.tencent.litenow");
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
 * Qualified Name:     asyr
 * JD-Core Version:    0.7.0.1
 */