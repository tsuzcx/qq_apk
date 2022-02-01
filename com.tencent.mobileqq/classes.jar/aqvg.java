import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqvg
{
  private int a;
  
  public aqvg()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public static aqvg a(aqlg paramaqlg)
  {
    aqvg localaqvg = new aqvg();
    if (paramaqlg != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SysSuspiciousConfBean", 2, "parse taskid->" + paramaqlg.jdField_a_of_type_Int + " content->" + paramaqlg.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      localaqvg.jdField_a_of_type_Int = new JSONObject(paramaqlg.jdField_a_of_type_JavaLangString).optInt("suspiciousSwitch", 1);
      return localaqvg;
    }
    catch (JSONException paramaqlg)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SysSuspiciousConfBean", 2, "parse error->" + paramaqlg.toString());
    }
    return localaqvg;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqvg
 * JD-Core Version:    0.7.0.1
 */