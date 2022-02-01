import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqer
{
  private int a;
  
  public aqer()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public static aqer a(aptx paramaptx)
  {
    aqer localaqer = new aqer();
    if (paramaptx != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SysSuspiciousConfBean", 2, "parse taskid->" + paramaptx.jdField_a_of_type_Int + " content->" + paramaptx.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      localaqer.jdField_a_of_type_Int = new JSONObject(paramaptx.jdField_a_of_type_JavaLangString).optInt("suspiciousSwitch", 1);
      return localaqer;
    }
    catch (JSONException paramaptx)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SysSuspiciousConfBean", 2, "parse error->" + paramaptx.toString());
    }
    return localaqer;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqer
 * JD-Core Version:    0.7.0.1
 */