import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arhj
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
  
  public static arhj a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length <= 0)) {
      return null;
    }
    arhj localarhj = new arhj();
    try
    {
      paramArrayOfaqxa = new JSONObject(paramArrayOfaqxa[0].jdField_a_of_type_JavaLangString);
      localarhj.jdField_a_of_type_Int = paramArrayOfaqxa.getInt("check_day");
      localarhj.jdField_b_of_type_Int = paramArrayOfaqxa.getInt("check_time");
      localarhj.jdField_c_of_type_Int = paramArrayOfaqxa.getInt("album_days");
      localarhj.jdField_d_of_type_Int = paramArrayOfaqxa.getInt("photos_limit");
      localarhj.jdField_a_of_type_JavaLangString = paramArrayOfaqxa.getString("tips");
      localarhj.jdField_b_of_type_JavaLangString = paramArrayOfaqxa.getString("jump_text");
      localarhj.jdField_c_of_type_JavaLangString = paramArrayOfaqxa.getString("t_show");
      localarhj.jdField_d_of_type_JavaLangString = paramArrayOfaqxa.getString("t_click");
      localarhj.e = paramArrayOfaqxa.getString("t_close");
      localarhj.jdField_a_of_type_Boolean = true;
      return localarhj;
    }
    catch (JSONException paramArrayOfaqxa)
    {
      QLog.e("WeiyunCheckAlbumConfigBean", 1, "wy check album config parse failed", paramArrayOfaqxa);
    }
    return localarhj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arhj
 * JD-Core Version:    0.7.0.1
 */