import com.tencent.TMG.utils.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class anch
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  public static anch a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi == null) || (paramArrayOfampi.length <= 0)) {
      return null;
    }
    anch localanch = new anch();
    try
    {
      paramArrayOfampi = new JSONObject(paramArrayOfampi[0].jdField_a_of_type_JavaLangString);
      localanch.jdField_a_of_type_Boolean = paramArrayOfampi.getBoolean("enable");
      localanch.jdField_a_of_type_JavaLangString = paramArrayOfampi.getString("content");
      return localanch;
    }
    catch (JSONException paramArrayOfampi)
    {
      QLog.e("TencentDocMiniProgramGrayTipsBean", 1, paramArrayOfampi.getLocalizedMessage(), paramArrayOfampi);
    }
    return localanch;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anch
 * JD-Core Version:    0.7.0.1
 */