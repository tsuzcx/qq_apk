import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aooj
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
  
  public static aooj a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf == null) || (paramArrayOfaogf.length <= 0)) {
      return null;
    }
    aooj localaooj = new aooj();
    try
    {
      paramArrayOfaogf = new JSONObject(paramArrayOfaogf[0].jdField_a_of_type_JavaLangString);
      localaooj.jdField_a_of_type_Int = paramArrayOfaogf.getInt("check_day");
      localaooj.jdField_b_of_type_Int = paramArrayOfaogf.getInt("check_time");
      localaooj.jdField_c_of_type_Int = paramArrayOfaogf.getInt("album_days");
      localaooj.jdField_d_of_type_Int = paramArrayOfaogf.getInt("photos_limit");
      localaooj.jdField_a_of_type_JavaLangString = paramArrayOfaogf.getString("tips");
      localaooj.jdField_b_of_type_JavaLangString = paramArrayOfaogf.getString("jump_text");
      localaooj.jdField_c_of_type_JavaLangString = paramArrayOfaogf.getString("t_show");
      localaooj.jdField_d_of_type_JavaLangString = paramArrayOfaogf.getString("t_click");
      localaooj.e = paramArrayOfaogf.getString("t_close");
      localaooj.jdField_a_of_type_Boolean = true;
      return localaooj;
    }
    catch (JSONException paramArrayOfaogf)
    {
      QLog.e("WeiyunCheckAlbumConfigBean", 1, "wy check album config parse failed", paramArrayOfaogf);
    }
    return localaooj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aooj
 * JD-Core Version:    0.7.0.1
 */