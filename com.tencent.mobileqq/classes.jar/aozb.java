import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aozb
{
  private int a;
  
  public static aozb a(aoko paramaoko)
  {
    localaozb = new aozb();
    if (paramaoko != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SuspiciousTroopConfBean", 2, "parse taskid->" + paramaoko.jdField_a_of_type_Int + " content->" + paramaoko.jdField_a_of_type_JavaLangString);
      }
      try
      {
        if (paramaoko.jdField_a_of_type_JavaLangString == null) {}
        for (paramaoko = "";; paramaoko = paramaoko.jdField_a_of_type_JavaLangString)
        {
          localaozb.jdField_a_of_type_Int = new JSONObject(paramaoko).optInt("suspiciousSwitch", 0);
          return localaozb;
        }
        return localaozb;
      }
      catch (JSONException paramaoko)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SuspiciousTroopConfBean", 2, "parse error->" + paramaoko.toString());
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
 * Qualified Name:     aozb
 * JD-Core Version:    0.7.0.1
 */