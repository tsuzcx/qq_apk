import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class bkji
{
  public String a;
  public boolean a;
  public String b;
  public String c;
  public String d;
  
  public static bkji a()
  {
    bkji localbkji = bkjx.a(1);
    if ((localbkji != null) && (!localbkji.jdField_a_of_type_Boolean) && (new File(localbkji.e()).exists()))
    {
      localbkji.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.i("IliveConfigBean", 2, "IlivePluginDownloadManager getConfig reset mIsUseAnchor = true");
      }
    }
    return localbkji;
  }
  
  public static bkji a(String paramString)
  {
    bkji localbkji = new bkji();
    if (TextUtils.isEmpty(paramString)) {
      return localbkji;
    }
    try
    {
      paramString = new JSONObject(paramString);
      localbkji.jdField_a_of_type_Boolean = paramString.optBoolean("mIsUseAnchor");
      localbkji.jdField_a_of_type_JavaLangString = paramString.optString("mWatchPluginUrl");
      localbkji.b = paramString.optString("mWatchPluginMd5");
      localbkji.c = paramString.optString("mAnchorPluginUrl");
      localbkji.d = paramString.optString("mAnchorPluginMd5");
      return localbkji;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return localbkji;
  }
  
  public static String a(bkji parambkji)
  {
    if (parambkji == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mIsUseAnchor", parambkji.jdField_a_of_type_Boolean);
      localJSONObject.put("mWatchPluginUrl", parambkji.jdField_a_of_type_JavaLangString);
      localJSONObject.put("mWatchPluginMd5", parambkji.b);
      localJSONObject.put("mAnchorPluginUrl", parambkji.c);
      localJSONObject.put("mAnchorPluginMd5", parambkji.d);
      return localJSONObject.toString();
    }
    catch (JSONException parambkji)
    {
      for (;;)
      {
        parambkji.printStackTrace();
      }
    }
  }
  
  public static boolean a()
  {
    Object localObject = bkjx.a(1);
    int i = -1;
    if ((localObject != null) && (!((bkji)localObject).jdField_a_of_type_Boolean))
    {
      int j = i;
      try
      {
        localObject = Pattern.compile("\\d+").matcher(((bkji)localObject).jdField_a_of_type_JavaLangString);
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
      return bkiz.a() + File.separator + "plugin_watch_manager_" + this.jdField_a_of_type_JavaLangString.hashCode() + ".zip";
    }
    return bkiz.a() + File.separator + "plugin_watch_manager.zip";
  }
  
  private String e()
  {
    if (!TextUtils.isEmpty(this.c)) {
      return bkiz.a() + File.separator + "plugin_anchor_manager_" + this.c.hashCode() + ".zip";
    }
    return bkiz.a() + File.separator + "plugin_anchor_manager.zip";
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
 * Qualified Name:     bkji
 * JD-Core Version:    0.7.0.1
 */