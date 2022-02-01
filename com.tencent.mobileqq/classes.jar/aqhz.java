import android.support.annotation.NonNull;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class aqhz
{
  private static String a = "https://h5.vip.qq.com/p/pay/index?_wv=17301507&_wwv=8192&aid=mvip.g.a.zh_jjms&month=1&type=vip";
  
  @NonNull
  public static aqhz a(String paramString)
  {
    aqhz localaqhz = new aqhz();
    if (TextUtils.isEmpty(paramString)) {
      return localaqhz;
    }
    a(paramString);
    return localaqhz;
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
 * Qualified Name:     aqhz
 * JD-Core Version:    0.7.0.1
 */