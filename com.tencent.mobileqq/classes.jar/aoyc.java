import com.tencent.TMG.utils.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aoyc
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  public static aoyc a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko == null) || (paramArrayOfaoko.length <= 0)) {
      return null;
    }
    aoyc localaoyc = new aoyc();
    try
    {
      paramArrayOfaoko = new JSONObject(paramArrayOfaoko[0].jdField_a_of_type_JavaLangString);
      localaoyc.jdField_a_of_type_Boolean = paramArrayOfaoko.getBoolean("enable");
      localaoyc.jdField_a_of_type_JavaLangString = paramArrayOfaoko.getString("content");
      return localaoyc;
    }
    catch (JSONException paramArrayOfaoko)
    {
      QLog.e("TencentDocMiniProgramGrayTipsBean", 1, paramArrayOfaoko.getLocalizedMessage(), paramArrayOfaoko);
    }
    return localaoyc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoyc
 * JD-Core Version:    0.7.0.1
 */