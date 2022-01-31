import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amgz
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
  
  public static amgz a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs == null) || (paramArrayOfalzs.length <= 0)) {
      return null;
    }
    amgz localamgz = new amgz();
    try
    {
      paramArrayOfalzs = new JSONObject(paramArrayOfalzs[0].jdField_a_of_type_JavaLangString);
      localamgz.jdField_a_of_type_Int = paramArrayOfalzs.getInt("check_day");
      localamgz.jdField_b_of_type_Int = paramArrayOfalzs.getInt("check_time");
      localamgz.jdField_c_of_type_Int = paramArrayOfalzs.getInt("album_days");
      localamgz.jdField_d_of_type_Int = paramArrayOfalzs.getInt("photos_limit");
      localamgz.jdField_a_of_type_JavaLangString = paramArrayOfalzs.getString("tips");
      localamgz.jdField_b_of_type_JavaLangString = paramArrayOfalzs.getString("jump_text");
      localamgz.jdField_c_of_type_JavaLangString = paramArrayOfalzs.getString("t_show");
      localamgz.jdField_d_of_type_JavaLangString = paramArrayOfalzs.getString("t_click");
      localamgz.e = paramArrayOfalzs.getString("t_close");
      localamgz.jdField_a_of_type_Boolean = true;
      return localamgz;
    }
    catch (JSONException paramArrayOfalzs)
    {
      QLog.e("WeiyunCheckAlbumConfigBean", 1, "wy check album config parse failed", paramArrayOfalzs);
    }
    return localamgz;
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
 * Qualified Name:     amgz
 * JD-Core Version:    0.7.0.1
 */