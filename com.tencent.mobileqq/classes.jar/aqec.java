import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqec
{
  private int jdField_a_of_type_Int = -1;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private String jdField_b_of_type_JavaLangString = "";
  private int jdField_c_of_type_Int = -1;
  private String jdField_c_of_type_JavaLangString = "";
  private int jdField_d_of_type_Int = -1;
  private String jdField_d_of_type_JavaLangString = "";
  private String e = "";
  
  public static aqec a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx == null) || (paramArrayOfaptx.length <= 0)) {
      return null;
    }
    aqec localaqec = new aqec();
    try
    {
      paramArrayOfaptx = new JSONObject(paramArrayOfaptx[0].jdField_a_of_type_JavaLangString);
      localaqec.jdField_a_of_type_Int = paramArrayOfaptx.getInt("check_day");
      localaqec.jdField_b_of_type_Int = paramArrayOfaptx.getInt("check_time");
      localaqec.jdField_c_of_type_Int = paramArrayOfaptx.getInt("album_days");
      localaqec.jdField_d_of_type_Int = paramArrayOfaptx.getInt("photos_limit");
      localaqec.jdField_a_of_type_JavaLangString = paramArrayOfaptx.getString("tips");
      localaqec.jdField_b_of_type_JavaLangString = paramArrayOfaptx.getString("jump_text");
      localaqec.jdField_c_of_type_JavaLangString = paramArrayOfaptx.getString("t_show");
      localaqec.jdField_d_of_type_JavaLangString = paramArrayOfaptx.getString("t_click");
      localaqec.e = paramArrayOfaptx.getString("t_close");
      localaqec.jdField_a_of_type_Boolean = true;
      return localaqec;
    }
    catch (JSONException paramArrayOfaptx)
    {
      QLog.e("WeiyunCheckAlbumConfigBean", 1, "wy check album config parse failed", paramArrayOfaptx);
    }
    return localaqec;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqec
 * JD-Core Version:    0.7.0.1
 */