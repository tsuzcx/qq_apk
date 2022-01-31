import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ammz
{
  private int a;
  
  public static ammz a(alzs paramalzs)
  {
    localammz = new ammz();
    if (paramalzs != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SuspiciousTroopConfBean", 2, "parse taskid->" + paramalzs.jdField_a_of_type_Int + " content->" + paramalzs.jdField_a_of_type_JavaLangString);
      }
      try
      {
        if (paramalzs.jdField_a_of_type_JavaLangString == null) {}
        for (paramalzs = "";; paramalzs = paramalzs.jdField_a_of_type_JavaLangString)
        {
          localammz.jdField_a_of_type_Int = new JSONObject(paramalzs).optInt("suspiciousSwitch", 0);
          return localammz;
        }
        return localammz;
      }
      catch (JSONException paramalzs)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SuspiciousTroopConfBean", 2, "parse error->" + paramalzs.toString());
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
 * Qualified Name:     ammz
 * JD-Core Version:    0.7.0.1
 */