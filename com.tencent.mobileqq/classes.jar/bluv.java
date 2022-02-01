import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.manager.IliveDbManager;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class bluv
{
  public String a;
  public boolean a;
  public String b;
  public String c;
  public String d;
  
  public static bluv a()
  {
    bluv localbluv = IliveDbManager.getIliveConfigBean(1);
    if ((localbluv != null) && (!localbluv.jdField_a_of_type_Boolean) && (new File(localbluv.e()).exists()))
    {
      localbluv.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.i("IliveConfigBean", 2, "IlivePluginDownloadManager getConfig reset mIsUseAnchor = true");
      }
    }
    return localbluv;
  }
  
  public static bluv a(String paramString)
  {
    bluv localbluv = new bluv();
    if (TextUtils.isEmpty(paramString)) {
      return localbluv;
    }
    try
    {
      paramString = new JSONObject(paramString);
      localbluv.jdField_a_of_type_Boolean = paramString.optBoolean("mIsUseAnchor");
      localbluv.jdField_a_of_type_JavaLangString = paramString.optString("mWatchPluginUrl");
      localbluv.b = paramString.optString("mWatchPluginMd5");
      localbluv.c = paramString.optString("mAnchorPluginUrl");
      localbluv.d = paramString.optString("mAnchorPluginMd5");
      return localbluv;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return localbluv;
  }
  
  public static String a(bluv parambluv)
  {
    if (parambluv == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mIsUseAnchor", parambluv.jdField_a_of_type_Boolean);
      localJSONObject.put("mWatchPluginUrl", parambluv.jdField_a_of_type_JavaLangString);
      localJSONObject.put("mWatchPluginMd5", parambluv.b);
      localJSONObject.put("mAnchorPluginUrl", parambluv.c);
      localJSONObject.put("mAnchorPluginMd5", parambluv.d);
      return localJSONObject.toString();
    }
    catch (JSONException parambluv)
    {
      for (;;)
      {
        parambluv.printStackTrace();
      }
    }
  }
  
  public static boolean a()
  {
    Object localObject = IliveDbManager.getIliveConfigBean(1);
    int i = -1;
    if ((localObject != null) && (!((bluv)localObject).jdField_a_of_type_Boolean))
    {
      int j = i;
      try
      {
        localObject = Pattern.compile("\\d+").matcher(((bluv)localObject).jdField_a_of_type_JavaLangString);
        int k;
        for (;;)
        {
          j = i;
          k = i;
          if (!((Matcher)localObject).find()) {
            break;
          }
          j = i;
          i = Integer.parseInt(((Matcher)localObject).group());
        }
        return true;
      }
      catch (Exception localException)
      {
        QLog.e("IliveConfigBean", 1, "check need Preload error ");
        k = j;
        QLog.e("IliveConfigBean", 1, "number" + k);
        if (k < 145) {
          return false;
        }
      }
    }
  }
  
  private String d()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return blul.a() + File.separator + "plugin_watch_manager_" + this.jdField_a_of_type_JavaLangString.hashCode() + ".zip";
    }
    return blul.a() + File.separator + "plugin_watch_manager.zip";
  }
  
  private String e()
  {
    if (!TextUtils.isEmpty(this.c)) {
      return blul.a() + File.separator + "plugin_anchor_manager_" + this.c.hashCode() + ".zip";
    }
    return blul.a() + File.separator + "plugin_anchor_manager.zip";
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return e();
    }
    return d();
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.d;
    }
    return this.b;
  }
  
  public String c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.c;
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  @NonNull
  public String toString()
  {
    return "mIsUseAnchor = " + this.jdField_a_of_type_Boolean + " mWatchPluginMd5 =  " + this.b + " , mAnchorPluginMd5 = " + this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bluv
 * JD-Core Version:    0.7.0.1
 */