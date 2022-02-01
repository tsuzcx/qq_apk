import android.support.annotation.NonNull;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class arnt
{
  private static String jdField_a_of_type_JavaLangString = "https://club.vip.qq.com/official?_wv=16778247&_wwv=68&_nav_alpha=0&pay_src=10&_wvx=10&_proxy=1";
  private boolean jdField_a_of_type_Boolean;
  
  @NonNull
  public static arnt a(String paramString)
  {
    arnt localarnt = new arnt();
    if (TextUtils.isEmpty(paramString))
    {
      localarnt.jdField_a_of_type_Boolean = false;
      return localarnt;
    }
    a(paramString);
    localarnt.jdField_a_of_type_Boolean = true;
    return localarnt;
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
 * Qualified Name:     arnt
 * JD-Core Version:    0.7.0.1
 */