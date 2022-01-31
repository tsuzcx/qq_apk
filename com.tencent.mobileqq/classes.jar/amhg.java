import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amhg
{
  private int a;
  
  public amhg()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public static amhg a(alzs paramalzs)
  {
    amhg localamhg = new amhg();
    if (paramalzs != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SysSuspiciousConfBean", 2, "parse taskid->" + paramalzs.jdField_a_of_type_Int + " content->" + paramalzs.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      localamhg.jdField_a_of_type_Int = new JSONObject(paramalzs.jdField_a_of_type_JavaLangString).optInt("suspiciousSwitch", 1);
      return localamhg;
    }
    catch (JSONException paramalzs)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SysSuspiciousConfBean", 2, "parse error->" + paramalzs.toString());
    }
    return localamhg;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amhg
 * JD-Core Version:    0.7.0.1
 */