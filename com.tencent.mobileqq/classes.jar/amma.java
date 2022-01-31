import com.tencent.TMG.utils.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amma
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  public static amma a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs == null) || (paramArrayOfalzs.length <= 0)) {
      return null;
    }
    amma localamma = new amma();
    try
    {
      paramArrayOfalzs = new JSONObject(paramArrayOfalzs[0].jdField_a_of_type_JavaLangString);
      localamma.jdField_a_of_type_Boolean = paramArrayOfalzs.getBoolean("enable");
      localamma.jdField_a_of_type_JavaLangString = paramArrayOfalzs.getString("content");
      return localamma;
    }
    catch (JSONException paramArrayOfalzs)
    {
      QLog.e("TencentDocMiniProgramGrayTipsBean", 1, paramArrayOfalzs.getLocalizedMessage(), paramArrayOfalzs);
    }
    return localamma;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amma
 * JD-Core Version:    0.7.0.1
 */