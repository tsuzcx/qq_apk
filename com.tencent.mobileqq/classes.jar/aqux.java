import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqux
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
  
  public static aqux a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg == null) || (paramArrayOfaqlg.length <= 0)) {
      return null;
    }
    aqux localaqux = new aqux();
    try
    {
      paramArrayOfaqlg = new JSONObject(paramArrayOfaqlg[0].jdField_a_of_type_JavaLangString);
      localaqux.jdField_a_of_type_Int = paramArrayOfaqlg.getInt("check_day");
      localaqux.jdField_b_of_type_Int = paramArrayOfaqlg.getInt("check_time");
      localaqux.jdField_c_of_type_Int = paramArrayOfaqlg.getInt("album_days");
      localaqux.jdField_d_of_type_Int = paramArrayOfaqlg.getInt("photos_limit");
      localaqux.jdField_a_of_type_JavaLangString = paramArrayOfaqlg.getString("tips");
      localaqux.jdField_b_of_type_JavaLangString = paramArrayOfaqlg.getString("jump_text");
      localaqux.jdField_c_of_type_JavaLangString = paramArrayOfaqlg.getString("t_show");
      localaqux.jdField_d_of_type_JavaLangString = paramArrayOfaqlg.getString("t_click");
      localaqux.e = paramArrayOfaqlg.getString("t_close");
      localaqux.jdField_a_of_type_Boolean = true;
      return localaqux;
    }
    catch (JSONException paramArrayOfaqlg)
    {
      QLog.e("WeiyunCheckAlbumConfigBean", 1, "wy check album config parse failed", paramArrayOfaqlg);
    }
    return localaqux;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqux
 * JD-Core Version:    0.7.0.1
 */