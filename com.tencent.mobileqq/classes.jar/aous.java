import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aous
{
  private int a;
  
  public static aous a(aogf paramaogf)
  {
    localaous = new aous();
    if (paramaogf != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SuspiciousTroopConfBean", 2, "parse taskid->" + paramaogf.jdField_a_of_type_Int + " content->" + paramaogf.jdField_a_of_type_JavaLangString);
      }
      try
      {
        if (paramaogf.jdField_a_of_type_JavaLangString == null) {}
        for (paramaogf = "";; paramaogf = paramaogf.jdField_a_of_type_JavaLangString)
        {
          localaous.jdField_a_of_type_Int = new JSONObject(paramaogf).optInt("suspiciousSwitch", 0);
          return localaous;
        }
        return localaous;
      }
      catch (JSONException paramaogf)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SuspiciousTroopConfBean", 2, "parse error->" + paramaogf.toString());
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
 * Qualified Name:     aous
 * JD-Core Version:    0.7.0.1
 */