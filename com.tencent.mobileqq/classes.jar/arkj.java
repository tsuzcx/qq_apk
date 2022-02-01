import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arkj
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
  
  public static arkj a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length <= 0)) {
      return null;
    }
    arkj localarkj = new arkj();
    try
    {
      paramArrayOfaraj = new JSONObject(paramArrayOfaraj[0].jdField_a_of_type_JavaLangString);
      localarkj.jdField_a_of_type_Int = paramArrayOfaraj.getInt("check_day");
      localarkj.jdField_b_of_type_Int = paramArrayOfaraj.getInt("check_time");
      localarkj.jdField_c_of_type_Int = paramArrayOfaraj.getInt("album_days");
      localarkj.jdField_d_of_type_Int = paramArrayOfaraj.getInt("photos_limit");
      localarkj.jdField_a_of_type_JavaLangString = paramArrayOfaraj.getString("tips");
      localarkj.jdField_b_of_type_JavaLangString = paramArrayOfaraj.getString("jump_text");
      localarkj.jdField_c_of_type_JavaLangString = paramArrayOfaraj.getString("t_show");
      localarkj.jdField_d_of_type_JavaLangString = paramArrayOfaraj.getString("t_click");
      localarkj.e = paramArrayOfaraj.getString("t_close");
      localarkj.jdField_a_of_type_Boolean = true;
      return localarkj;
    }
    catch (JSONException paramArrayOfaraj)
    {
      QLog.e("WeiyunCheckAlbumConfigBean", 1, "wy check album config parse failed", paramArrayOfaraj);
    }
    return localarkj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arkj
 * JD-Core Version:    0.7.0.1
 */