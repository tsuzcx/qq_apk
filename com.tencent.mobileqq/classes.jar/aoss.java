import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aoss
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
  
  public static aoss a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko == null) || (paramArrayOfaoko.length <= 0)) {
      return null;
    }
    aoss localaoss = new aoss();
    try
    {
      paramArrayOfaoko = new JSONObject(paramArrayOfaoko[0].jdField_a_of_type_JavaLangString);
      localaoss.jdField_a_of_type_Int = paramArrayOfaoko.getInt("check_day");
      localaoss.jdField_b_of_type_Int = paramArrayOfaoko.getInt("check_time");
      localaoss.jdField_c_of_type_Int = paramArrayOfaoko.getInt("album_days");
      localaoss.jdField_d_of_type_Int = paramArrayOfaoko.getInt("photos_limit");
      localaoss.jdField_a_of_type_JavaLangString = paramArrayOfaoko.getString("tips");
      localaoss.jdField_b_of_type_JavaLangString = paramArrayOfaoko.getString("jump_text");
      localaoss.jdField_c_of_type_JavaLangString = paramArrayOfaoko.getString("t_show");
      localaoss.jdField_d_of_type_JavaLangString = paramArrayOfaoko.getString("t_click");
      localaoss.e = paramArrayOfaoko.getString("t_close");
      localaoss.jdField_a_of_type_Boolean = true;
      return localaoss;
    }
    catch (JSONException paramArrayOfaoko)
    {
      QLog.e("WeiyunCheckAlbumConfigBean", 1, "wy check album config parse failed", paramArrayOfaoko);
    }
    return localaoss;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoss
 * JD-Core Version:    0.7.0.1
 */