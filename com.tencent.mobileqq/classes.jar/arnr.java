import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arnr
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private String b = "";
  private String c = "";
  
  public static arnr a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length <= 0)) {
      return null;
    }
    arnr localarnr = new arnr();
    try
    {
      paramArrayOfaqxa = new JSONObject(paramArrayOfaqxa[0].jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("TencentDocGrayTipsBean", 2, "handleTencentDocGrayTipsConfig call after " + paramArrayOfaqxa.toString());
      }
      a(localarnr, paramArrayOfaqxa);
      return localarnr;
    }
    catch (JSONException paramArrayOfaqxa)
    {
      paramArrayOfaqxa.printStackTrace();
    }
    return localarnr;
  }
  
  public static void a(arnr paramarnr, JSONObject paramJSONObject)
  {
    if ((paramarnr == null) || (paramJSONObject == null)) {}
    for (;;)
    {
      return;
      if ((AudioHelper.e()) && (AudioHelper.a(10) == 1)) {
        AudioHelper.a(anvx.a(2131714212));
      }
      try
      {
        paramJSONObject.put("tencentDocAIOGrayTipsEnable", true);
        paramJSONObject.put("plainContent", anvx.a(2131714205));
        paramJSONObject.put("hightLightContent", anvx.a(2131714208));
        paramJSONObject.put("showTimes", 3);
        paramJSONObject.put("linkUrl", "https://docs.qq.com/desktop");
        label81:
        if (paramJSONObject.has("tencentDocAIOGrayTipsEnable")) {
          paramarnr.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("tencentDocAIOGrayTipsEnable");
        }
        if (paramJSONObject.has("plainContent")) {
          paramarnr.jdField_a_of_type_JavaLangString = paramJSONObject.optString("plainContent");
        }
        if (paramJSONObject.has("hightLightContent")) {
          paramarnr.b = paramJSONObject.optString("hightLightContent");
        }
        if (paramJSONObject.has("showTimes")) {
          paramarnr.jdField_a_of_type_Int = paramJSONObject.optInt("showTimes");
        }
        if (!paramJSONObject.has("linkUrl")) {
          continue;
        }
        paramarnr.c = paramJSONObject.optString("linkUrl");
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
 * Qualified Name:     arnr
 * JD-Core Version:    0.7.0.1
 */