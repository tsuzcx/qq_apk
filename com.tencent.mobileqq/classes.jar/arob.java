import android.support.annotation.NonNull;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class arob
{
  private static String a = "https://h5.vip.qq.com/p/pay/index?_wv=17301507&_wwv=8192&aid=mvip.g.a.zh_jjms&month=1&type=vip";
  
  @NonNull
  public static arob a(String paramString)
  {
    arob localarob = new arob();
    if (TextUtils.isEmpty(paramString)) {
      return localarob;
    }
    a(paramString);
    return localarob;
  }
  
  public static String a()
  {
    return a;
  }
  
  private static void a(String paramString)
  {
    try
    {
      a = new JSONObject(paramString).getJSONObject("android").getString("payH5Url");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arob
 * JD-Core Version:    0.7.0.1
 */