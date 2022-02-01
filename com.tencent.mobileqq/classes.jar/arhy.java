import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arhy
{
  private int a;
  
  public arhy()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public static arhy a(aqxa paramaqxa)
  {
    arhy localarhy = new arhy();
    if (paramaqxa != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SysSuspiciousConfBean", 2, "parse taskid->" + paramaqxa.jdField_a_of_type_Int + " content->" + paramaqxa.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      localarhy.jdField_a_of_type_Int = new JSONObject(paramaqxa.jdField_a_of_type_JavaLangString).optInt("suspiciousSwitch", 1);
      return localarhy;
    }
    catch (JSONException paramaqxa)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SysSuspiciousConfBean", 2, "parse error->" + paramaqxa.toString());
    }
    return localarhy;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arhy
 * JD-Core Version:    0.7.0.1
 */