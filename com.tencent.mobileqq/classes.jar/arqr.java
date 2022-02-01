import com.tencent.TMG.utils.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arqr
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  public static arqr a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length <= 0)) {
      return null;
    }
    arqr localarqr = new arqr();
    try
    {
      paramArrayOfaraj = new JSONObject(paramArrayOfaraj[0].jdField_a_of_type_JavaLangString);
      localarqr.jdField_a_of_type_Boolean = paramArrayOfaraj.getBoolean("enable");
      localarqr.jdField_a_of_type_JavaLangString = paramArrayOfaraj.getString("content");
      return localarqr;
    }
    catch (JSONException paramArrayOfaraj)
    {
      QLog.e("TencentDocMiniProgramGrayTipsBean", 1, paramArrayOfaraj.getLocalizedMessage(), paramArrayOfaraj);
    }
    return localarqr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arqr
 * JD-Core Version:    0.7.0.1
 */