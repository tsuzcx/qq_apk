import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arku
{
  private int a;
  
  public arku()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public static arku a(araj paramaraj)
  {
    arku localarku = new arku();
    if (paramaraj != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SysSuspiciousConfBean", 2, "parse taskid->" + paramaraj.jdField_a_of_type_Int + " content->" + paramaraj.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      localarku.jdField_a_of_type_Int = new JSONObject(paramaraj.jdField_a_of_type_JavaLangString).optInt("suspiciousSwitch", 1);
      return localarku;
    }
    catch (JSONException paramaraj)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SysSuspiciousConfBean", 2, "parse error->" + paramaraj.toString());
    }
    return localarku;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arku
 * JD-Core Version:    0.7.0.1
 */