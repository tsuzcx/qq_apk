import com.tencent.TMG.utils.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ancm
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  public static ancm a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph == null) || (paramArrayOfamph.length <= 0)) {
      return null;
    }
    ancm localancm = new ancm();
    try
    {
      paramArrayOfamph = new JSONObject(paramArrayOfamph[0].jdField_a_of_type_JavaLangString);
      localancm.jdField_a_of_type_Boolean = paramArrayOfamph.getBoolean("enable");
      localancm.jdField_a_of_type_JavaLangString = paramArrayOfamph.getString("content");
      return localancm;
    }
    catch (JSONException paramArrayOfamph)
    {
      QLog.e("TencentDocMiniProgramGrayTipsBean", 1, paramArrayOfamph.getLocalizedMessage(), paramArrayOfamph);
    }
    return localancm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ancm
 * JD-Core Version:    0.7.0.1
 */