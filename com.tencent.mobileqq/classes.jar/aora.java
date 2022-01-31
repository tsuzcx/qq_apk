import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aora
{
  private String a;
  public boolean a;
  private String b;
  public boolean b;
  private String c = "https://mc.vip.qq.com/group/create2k?_wwv=4&_wv=1027&_wvx=3";
  private String d = "https://mc.vip.qq.com/group/create3k?_wwv=4&_wv=1027&_wvx=3";
  
  public aora()
  {
    this.jdField_a_of_type_JavaLangString = "https://club.vip.qq.com/grouphaoma/home?_wv=131072&_fv=0&_proxy=1&from={from}";
    this.jdField_b_of_type_JavaLangString = "https://club.vip.qq.com/grouphaoma/mine?_wv=131072&_fv=0&_proxy=1&from={from}&groupnum={groupnum}";
  }
  
  @NonNull
  public static aora a(String paramString)
  {
    boolean bool2 = false;
    aora localaora = new aora();
    if (TextUtils.isEmpty(paramString)) {
      return localaora;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.optInt("showCreateIcon") == 1)
        {
          bool1 = true;
          localaora.jdField_b_of_type_Boolean = bool1;
          localaora.jdField_a_of_type_JavaLangString = paramString.optString("pretty_home", "https://club.vip.qq.com/grouphaoma/home?_wv=131072&_fv=0&_proxy=1&from={from}");
          localaora.jdField_b_of_type_JavaLangString = paramString.optString("pretty_mine", "https://club.vip.qq.com/grouphaoma/mine?_wv=131072&_fv=0&_proxy=1&from={from}&groupnum={groupnum}");
          localaora.c = paramString.optString("2k", "https://mc.vip.qq.com/group/create2k?_wwv=4&_wv=1027&_wvx=3");
          localaora.d = paramString.optString("3k", "https://mc.vip.qq.com/group/create3k?_wwv=4&_wv=1027&_wvx=3");
          bool1 = bool2;
          if (paramString.optInt("limit_off", 0) == 1) {
            bool1 = true;
          }
          localaora.jdField_a_of_type_Boolean = bool1;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("vip_pretty.ConfigProcessor", 1, localaora.toString());
          return localaora;
        }
      }
      catch (JSONException paramString)
      {
        QLog.e("vip_pretty.ConfigProcessor", 1, "json parse error:" + paramString);
        return localaora;
      }
      boolean bool1 = false;
    }
  }
  
  public String a()
  {
    return this.c;
  }
  
  public String a(String paramString)
  {
    return this.jdField_a_of_type_JavaLangString.replace("{from}", paramString);
  }
  
  public String a(String paramString1, String paramString2)
  {
    return this.jdField_b_of_type_JavaLangString.replace("{from}", paramString1).replace("{groupnum}", paramString2);
  }
  
  public String b()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aora
 * JD-Core Version:    0.7.0.1
 */