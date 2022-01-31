import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aoti
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private String b = "";
  private String c = "";
  
  public static aoti a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf == null) || (paramArrayOfaogf.length <= 0)) {
      return null;
    }
    aoti localaoti = new aoti();
    try
    {
      paramArrayOfaogf = new JSONObject(paramArrayOfaogf[0].jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("TencentDocGrayTipsBean", 2, "handleTencentDocGrayTipsConfig call after " + paramArrayOfaogf.toString());
      }
      a(localaoti, paramArrayOfaogf);
      return localaoti;
    }
    catch (JSONException paramArrayOfaogf)
    {
      paramArrayOfaogf.printStackTrace();
    }
    return localaoti;
  }
  
  public static void a(aoti paramaoti, JSONObject paramJSONObject)
  {
    if ((paramaoti == null) || (paramJSONObject == null)) {}
    for (;;)
    {
      return;
      if ((AudioHelper.d()) && (AudioHelper.a(10) == 1)) {
        AudioHelper.a(alpo.a(2131715212));
      }
      try
      {
        paramJSONObject.put("tencentDocAIOGrayTipsEnable", true);
        paramJSONObject.put("plainContent", alpo.a(2131715205));
        paramJSONObject.put("hightLightContent", alpo.a(2131715208));
        paramJSONObject.put("showTimes", 3);
        paramJSONObject.put("linkUrl", "https://docs.qq.com/desktop");
        label81:
        if (paramJSONObject.has("tencentDocAIOGrayTipsEnable")) {
          paramaoti.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("tencentDocAIOGrayTipsEnable");
        }
        if (paramJSONObject.has("plainContent")) {
          paramaoti.jdField_a_of_type_JavaLangString = paramJSONObject.optString("plainContent");
        }
        if (paramJSONObject.has("hightLightContent")) {
          paramaoti.b = paramJSONObject.optString("hightLightContent");
        }
        if (paramJSONObject.has("showTimes")) {
          paramaoti.jdField_a_of_type_Int = paramJSONObject.optInt("showTimes");
        }
        if (!paramJSONObject.has("linkUrl")) {
          continue;
        }
        paramaoti.c = paramJSONObject.optString("linkUrl");
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
 * Qualified Name:     aoti
 * JD-Core Version:    0.7.0.1
 */