import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class bmfl
{
  public String a;
  public boolean a;
  public String b;
  public String c;
  public String d;
  
  public static bmfl a()
  {
    bmfl localbmfl = bmfq.a(1);
    if ((localbmfl != null) && (!localbmfl.jdField_a_of_type_Boolean) && (new File(localbmfl.e()).exists()))
    {
      localbmfl.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.i("IliveConfigBean", 2, "IlivePluginDownloadManager getConfig reset mIsUseAnchor = true");
      }
    }
    return localbmfl;
  }
  
  public static bmfl a(String paramString)
  {
    bmfl localbmfl = new bmfl();
    if (TextUtils.isEmpty(paramString)) {
      return localbmfl;
    }
    try
    {
      paramString = new JSONObject(paramString);
      localbmfl.jdField_a_of_type_Boolean = paramString.optBoolean("mIsUseAnchor");
      localbmfl.jdField_a_of_type_JavaLangString = paramString.optString("mWatchPluginUrl");
      localbmfl.b = paramString.optString("mWatchPluginMd5");
      localbmfl.c = paramString.optString("mAnchorPluginUrl");
      localbmfl.d = paramString.optString("mAnchorPluginMd5");
      return localbmfl;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return localbmfl;
  }
  
  public static String a(bmfl parambmfl)
  {
    if (parambmfl == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("mIsUseAnchor", parambmfl.jdField_a_of_type_Boolean);
      localJSONObject.put("mWatchPluginUrl", parambmfl.jdField_a_of_type_JavaLangString);
      localJSONObject.put("mWatchPluginMd5", parambmfl.b);
      localJSONObject.put("mAnchorPluginUrl", parambmfl.c);
      localJSONObject.put("mAnchorPluginMd5", parambmfl.d);
      return localJSONObject.toString();
    }
    catch (JSONException parambmfl)
    {
      for (;;)
      {
        parambmfl.printStackTrace();
      }
    }
  }
  
  public static boolean a()
  {
    Object localObject = bmfq.a(1);
    int i = -1;
    if ((localObject != null) && (!((bmfl)localObject).jdField_a_of_type_Boolean))
    {
      int j = i;
      try
      {
        localObject = Pattern.compile("\\d+").matcher(((bmfl)localObject).jdField_a_of_type_JavaLangString);
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
      return bmfc.a() + File.separator + "plugin_watch_manager_" + this.jdField_a_of_type_JavaLangString.hashCode() + ".zip";
    }
    return bmfc.a() + File.separator + "plugin_watch_manager.zip";
  }
  
  private String e()
  {
    if (!TextUtils.isEmpty(this.c)) {
      return bmfc.a() + File.separator + "plugin_anchor_manager_" + this.c.hashCode() + ".zip";
    }
    return bmfc.a() + File.separator + "plugin_anchor_manager.zip";
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
 * Qualified Name:     bmfl
 * JD-Core Version:    0.7.0.1
 */