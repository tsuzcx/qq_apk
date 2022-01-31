import com.tencent.TMG.utils.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aott
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  public static aott a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf == null) || (paramArrayOfaogf.length <= 0)) {
      return null;
    }
    aott localaott = new aott();
    try
    {
      paramArrayOfaogf = new JSONObject(paramArrayOfaogf[0].jdField_a_of_type_JavaLangString);
      localaott.jdField_a_of_type_Boolean = paramArrayOfaogf.getBoolean("enable");
      localaott.jdField_a_of_type_JavaLangString = paramArrayOfaogf.getString("content");
      return localaott;
    }
    catch (JSONException paramArrayOfaogf)
    {
      QLog.e("TencentDocMiniProgramGrayTipsBean", 1, paramArrayOfaogf.getLocalizedMessage(), paramArrayOfaogf);
    }
    return localaott;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aott
 * JD-Core Version:    0.7.0.1
 */