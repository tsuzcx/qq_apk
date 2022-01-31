import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amlp
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private String b = "";
  private String c = "";
  
  public static amlp a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs == null) || (paramArrayOfalzs.length <= 0)) {
      return null;
    }
    amlp localamlp = new amlp();
    try
    {
      paramArrayOfalzs = new JSONObject(paramArrayOfalzs[0].jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("TencentDocGrayTipsBean", 2, "handleTencentDocGrayTipsConfig call after " + paramArrayOfalzs.toString());
      }
      a(localamlp, paramArrayOfalzs);
      return localamlp;
    }
    catch (JSONException paramArrayOfalzs)
    {
      paramArrayOfalzs.printStackTrace();
    }
    return localamlp;
  }
  
  public static void a(amlp paramamlp, JSONObject paramJSONObject)
  {
    if ((paramamlp == null) || (paramJSONObject == null)) {}
    for (;;)
    {
      return;
      if ((AudioHelper.d()) && (AudioHelper.a(10) == 1)) {
        AudioHelper.a(ajjy.a(2131649040));
      }
      try
      {
        paramJSONObject.put("tencentDocAIOGrayTipsEnable", true);
        paramJSONObject.put("plainContent", ajjy.a(2131649033));
        paramJSONObject.put("hightLightContent", ajjy.a(2131649036));
        paramJSONObject.put("showTimes", 3);
        paramJSONObject.put("linkUrl", "https://docs.qq.com/desktop");
        label81:
        if (paramJSONObject.has("tencentDocAIOGrayTipsEnable")) {
          paramamlp.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("tencentDocAIOGrayTipsEnable");
        }
        if (paramJSONObject.has("plainContent")) {
          paramamlp.jdField_a_of_type_JavaLangString = paramJSONObject.optString("plainContent");
        }
        if (paramJSONObject.has("hightLightContent")) {
          paramamlp.b = paramJSONObject.optString("hightLightContent");
        }
        if (paramJSONObject.has("showTimes")) {
          paramamlp.jdField_a_of_type_Int = paramJSONObject.optInt("showTimes");
        }
        if (!paramJSONObject.has("linkUrl")) {
          continue;
        }
        paramamlp.c = paramJSONObject.optString("linkUrl");
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
 * Qualified Name:     amlp
 * JD-Core Version:    0.7.0.1
 */