import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aooq
{
  private int a;
  
  public aooq()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public static aooq a(aogf paramaogf)
  {
    aooq localaooq = new aooq();
    if (paramaogf != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SysSuspiciousConfBean", 2, "parse taskid->" + paramaogf.jdField_a_of_type_Int + " content->" + paramaogf.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      localaooq.jdField_a_of_type_Int = new JSONObject(paramaogf.jdField_a_of_type_JavaLangString).optInt("suspiciousSwitch", 1);
      return localaooq;
    }
    catch (JSONException paramaogf)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SysSuspiciousConfBean", 2, "parse error->" + paramaogf.toString());
    }
    return localaooq;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aooq
 * JD-Core Version:    0.7.0.1
 */