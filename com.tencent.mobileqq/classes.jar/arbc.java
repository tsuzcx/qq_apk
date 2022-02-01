import com.tencent.TMG.utils.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arbc
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  public static arbc a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg == null) || (paramArrayOfaqlg.length <= 0)) {
      return null;
    }
    arbc localarbc = new arbc();
    try
    {
      paramArrayOfaqlg = new JSONObject(paramArrayOfaqlg[0].jdField_a_of_type_JavaLangString);
      localarbc.jdField_a_of_type_Boolean = paramArrayOfaqlg.getBoolean("enable");
      localarbc.jdField_a_of_type_JavaLangString = paramArrayOfaqlg.getString("content");
      return localarbc;
    }
    catch (JSONException paramArrayOfaqlg)
    {
      QLog.e("TencentDocMiniProgramGrayTipsBean", 1, paramArrayOfaqlg.getLocalizedMessage(), paramArrayOfaqlg);
    }
    return localarbc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arbc
 * JD-Core Version:    0.7.0.1
 */