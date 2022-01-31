import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aosz
{
  private int a;
  
  public aosz()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public static aosz a(aoko paramaoko)
  {
    aosz localaosz = new aosz();
    if (paramaoko != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SysSuspiciousConfBean", 2, "parse taskid->" + paramaoko.jdField_a_of_type_Int + " content->" + paramaoko.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      localaosz.jdField_a_of_type_Int = new JSONObject(paramaoko.jdField_a_of_type_JavaLangString).optInt("suspiciousSwitch", 1);
      return localaosz;
    }
    catch (JSONException paramaoko)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SysSuspiciousConfBean", 2, "parse error->" + paramaoko.toString());
    }
    return localaosz;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aosz
 * JD-Core Version:    0.7.0.1
 */