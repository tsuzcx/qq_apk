import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amxk
{
  private int a;
  
  public amxk()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public static amxk a(ampi paramampi)
  {
    amxk localamxk = new amxk();
    if (paramampi != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SysSuspiciousConfBean", 2, "parse taskid->" + paramampi.jdField_a_of_type_Int + " content->" + paramampi.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      localamxk.jdField_a_of_type_Int = new JSONObject(paramampi.jdField_a_of_type_JavaLangString).optInt("suspiciousSwitch", 1);
      return localamxk;
    }
    catch (JSONException paramampi)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SysSuspiciousConfBean", 2, "parse error->" + paramampi.toString());
    }
    return localamxk;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amxk
 * JD-Core Version:    0.7.0.1
 */