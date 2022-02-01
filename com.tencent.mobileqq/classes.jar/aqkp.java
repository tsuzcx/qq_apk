import com.tencent.TMG.utils.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqkp
{
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  
  public static aqkp a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx == null) || (paramArrayOfaptx.length <= 0)) {
      return null;
    }
    aqkp localaqkp = new aqkp();
    try
    {
      paramArrayOfaptx = new JSONObject(paramArrayOfaptx[0].jdField_a_of_type_JavaLangString);
      localaqkp.jdField_a_of_type_Boolean = paramArrayOfaptx.getBoolean("enable");
      localaqkp.jdField_a_of_type_JavaLangString = paramArrayOfaptx.getString("content");
      return localaqkp;
    }
    catch (JSONException paramArrayOfaptx)
    {
      QLog.e("TencentDocMiniProgramGrayTipsBean", 1, paramArrayOfaptx.getLocalizedMessage(), paramArrayOfaptx);
    }
    return localaqkp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqkp
 * JD-Core Version:    0.7.0.1
 */