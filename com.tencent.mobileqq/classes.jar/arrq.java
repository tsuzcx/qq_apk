import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arrq
{
  private int a;
  
  public static arrq a(araj paramaraj)
  {
    localarrq = new arrq();
    if (paramaraj != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SuspiciousTroopConfBean", 2, "parse taskid->" + paramaraj.jdField_a_of_type_Int + " content->" + paramaraj.jdField_a_of_type_JavaLangString);
      }
      try
      {
        if (paramaraj.jdField_a_of_type_JavaLangString == null) {}
        for (paramaraj = "";; paramaraj = paramaraj.jdField_a_of_type_JavaLangString)
        {
          localarrq.jdField_a_of_type_Int = new JSONObject(paramaraj).optInt("suspiciousSwitch", 0);
          return localarrq;
        }
        return localarrq;
      }
      catch (JSONException paramaraj)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SuspiciousTroopConfBean", 2, "parse error->" + paramaraj.toString());
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arrq
 * JD-Core Version:    0.7.0.1
 */