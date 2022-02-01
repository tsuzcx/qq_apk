import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arcb
{
  private int a;
  
  public static arcb a(aqlg paramaqlg)
  {
    localarcb = new arcb();
    if (paramaqlg != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SuspiciousTroopConfBean", 2, "parse taskid->" + paramaqlg.jdField_a_of_type_Int + " content->" + paramaqlg.jdField_a_of_type_JavaLangString);
      }
      try
      {
        if (paramaqlg.jdField_a_of_type_JavaLangString == null) {}
        for (paramaqlg = "";; paramaqlg = paramaqlg.jdField_a_of_type_JavaLangString)
        {
          localarcb.jdField_a_of_type_Int = new JSONObject(paramaqlg).optInt("suspiciousSwitch", 0);
          return localarcb;
        }
        return localarcb;
      }
      catch (JSONException paramaqlg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SuspiciousTroopConfBean", 2, "parse error->" + paramaqlg.toString());
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
 * Qualified Name:     arcb
 * JD-Core Version:    0.7.0.1
 */