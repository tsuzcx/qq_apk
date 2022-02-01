import com.tencent.TMG.utils.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aroa
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  public static aroa a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length <= 0)) {
      return null;
    }
    aroa localaroa = new aroa();
    try
    {
      paramArrayOfaqxa = new JSONObject(paramArrayOfaqxa[0].jdField_a_of_type_JavaLangString);
      localaroa.jdField_a_of_type_Boolean = paramArrayOfaqxa.getBoolean("enable");
      localaroa.jdField_a_of_type_JavaLangString = paramArrayOfaqxa.getString("content");
      return localaroa;
    }
    catch (JSONException paramArrayOfaqxa)
    {
      QLog.e("TencentDocMiniProgramGrayTipsBean", 1, paramArrayOfaqxa.getLocalizedMessage(), paramArrayOfaqxa);
    }
    return localaroa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aroa
 * JD-Core Version:    0.7.0.1
 */