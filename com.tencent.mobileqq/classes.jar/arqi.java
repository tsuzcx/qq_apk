import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arqi
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private String b = "";
  private String c = "";
  
  public static arqi a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length <= 0)) {
      return null;
    }
    arqi localarqi = new arqi();
    try
    {
      paramArrayOfaraj = new JSONObject(paramArrayOfaraj[0].jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("TencentDocGrayTipsBean", 2, "handleTencentDocGrayTipsConfig call after " + paramArrayOfaraj.toString());
      }
      a(localarqi, paramArrayOfaraj);
      return localarqi;
    }
    catch (JSONException paramArrayOfaraj)
    {
      paramArrayOfaraj.printStackTrace();
    }
    return localarqi;
  }
  
  public static void a(arqi paramarqi, JSONObject paramJSONObject)
  {
    if ((paramarqi == null) || (paramJSONObject == null)) {}
    for (;;)
    {
      return;
      if ((AudioHelper.e()) && (AudioHelper.a(10) == 1)) {
        AudioHelper.a(anzj.a(2131713633));
      }
      try
      {
        paramJSONObject.put("tencentDocAIOGrayTipsEnable", true);
        paramJSONObject.put("plainContent", anzj.a(2131713626));
        paramJSONObject.put("hightLightContent", anzj.a(2131713629));
        paramJSONObject.put("showTimes", 3);
        paramJSONObject.put("linkUrl", "https://docs.qq.com/desktop");
        label81:
        if (paramJSONObject.has("tencentDocAIOGrayTipsEnable")) {
          paramarqi.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("tencentDocAIOGrayTipsEnable");
        }
        if (paramJSONObject.has("plainContent")) {
          paramarqi.jdField_a_of_type_JavaLangString = paramJSONObject.optString("plainContent");
        }
        if (paramJSONObject.has("hightLightContent")) {
          paramarqi.b = paramJSONObject.optString("hightLightContent");
        }
        if (paramJSONObject.has("showTimes")) {
          paramarqi.jdField_a_of_type_Int = paramJSONObject.optInt("showTimes");
        }
        if (!paramJSONObject.has("linkUrl")) {
          continue;
        }
        paramarqi.c = paramJSONObject.optString("linkUrl");
        return;
      }
      catch (Exception localException)
      {
        break label81;
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arqi
 * JD-Core Version:    0.7.0.1
 */