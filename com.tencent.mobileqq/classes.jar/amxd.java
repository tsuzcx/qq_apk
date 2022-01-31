import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amxd
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
  
  public static amxd a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi == null) || (paramArrayOfampi.length <= 0)) {
      return null;
    }
    amxd localamxd = new amxd();
    try
    {
      paramArrayOfampi = new JSONObject(paramArrayOfampi[0].jdField_a_of_type_JavaLangString);
      localamxd.jdField_a_of_type_Int = paramArrayOfampi.getInt("check_day");
      localamxd.jdField_b_of_type_Int = paramArrayOfampi.getInt("check_time");
      localamxd.jdField_c_of_type_Int = paramArrayOfampi.getInt("album_days");
      localamxd.jdField_d_of_type_Int = paramArrayOfampi.getInt("photos_limit");
      localamxd.jdField_a_of_type_JavaLangString = paramArrayOfampi.getString("tips");
      localamxd.jdField_b_of_type_JavaLangString = paramArrayOfampi.getString("jump_text");
      localamxd.jdField_c_of_type_JavaLangString = paramArrayOfampi.getString("t_show");
      localamxd.jdField_d_of_type_JavaLangString = paramArrayOfampi.getString("t_click");
      localamxd.e = paramArrayOfampi.getString("t_close");
      localamxd.jdField_a_of_type_Boolean = true;
      return localamxd;
    }
    catch (JSONException paramArrayOfampi)
    {
      QLog.e("WeiyunCheckAlbumConfigBean", 1, "wy check album config parse failed", paramArrayOfampi);
    }
    return localamxd;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public int d()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public String d()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String e()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amxd
 * JD-Core Version:    0.7.0.1
 */