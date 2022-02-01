import android.support.annotation.NonNull;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class aqhr
{
  private static String jdField_a_of_type_JavaLangString = "https://club.vip.qq.com/official?_wv=16778247&_wwv=68&_nav_alpha=0&pay_src=10&_wvx=10&_proxy=1";
  private boolean jdField_a_of_type_Boolean;
  
  @NonNull
  public static aqhr a(String paramString)
  {
    aqhr localaqhr = new aqhr();
    if (TextUtils.isEmpty(paramString))
    {
      localaqhr.jdField_a_of_type_Boolean = false;
      return localaqhr;
    }
    a(paramString);
    localaqhr.jdField_a_of_type_Boolean = true;
    return localaqhr;
  }
  
  public static String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  private static void a(String paramString)
  {
    try
    {
      jdField_a_of_type_JavaLangString = new JSONObject(paramString).getString("qqvip_vip_account");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public Boolean a()
  {
    return Boolean.valueOf(this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqhr
 * JD-Core Version:    0.7.0.1
 */