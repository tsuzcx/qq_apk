import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amxc
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
  
  public static amxc a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph == null) || (paramArrayOfamph.length <= 0)) {
      return null;
    }
    amxc localamxc = new amxc();
    try
    {
      paramArrayOfamph = new JSONObject(paramArrayOfamph[0].jdField_a_of_type_JavaLangString);
      localamxc.jdField_a_of_type_Int = paramArrayOfamph.getInt("check_day");
      localamxc.jdField_b_of_type_Int = paramArrayOfamph.getInt("check_time");
      localamxc.jdField_c_of_type_Int = paramArrayOfamph.getInt("album_days");
      localamxc.jdField_d_of_type_Int = paramArrayOfamph.getInt("photos_limit");
      localamxc.jdField_a_of_type_JavaLangString = paramArrayOfamph.getString("tips");
      localamxc.jdField_b_of_type_JavaLangString = paramArrayOfamph.getString("jump_text");
      localamxc.jdField_c_of_type_JavaLangString = paramArrayOfamph.getString("t_show");
      localamxc.jdField_d_of_type_JavaLangString = paramArrayOfamph.getString("t_click");
      localamxc.e = paramArrayOfamph.getString("t_close");
      localamxc.jdField_a_of_type_Boolean = true;
      return localamxc;
    }
    catch (JSONException paramArrayOfamph)
    {
      QLog.e("WeiyunCheckAlbumConfigBean", 1, "wy check album config parse failed", paramArrayOfamph);
    }
    return localamxc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amxc
 * JD-Core Version:    0.7.0.1
 */