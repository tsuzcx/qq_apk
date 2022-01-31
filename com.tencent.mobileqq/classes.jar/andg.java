import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class andg
{
  private int a;
  
  public static andg a(ampi paramampi)
  {
    localandg = new andg();
    if (paramampi != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SuspiciousTroopConfBean", 2, "parse taskid->" + paramampi.jdField_a_of_type_Int + " content->" + paramampi.jdField_a_of_type_JavaLangString);
      }
      try
      {
        if (paramampi.jdField_a_of_type_JavaLangString == null) {}
        for (paramampi = "";; paramampi = paramampi.jdField_a_of_type_JavaLangString)
        {
          localandg.jdField_a_of_type_Int = new JSONObject(paramampi).optInt("suspiciousSwitch", 0);
          return localandg;
        }
        return localandg;
      }
      catch (JSONException paramampi)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SuspiciousTroopConfBean", 2, "parse error->" + paramampi.toString());
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
 * Qualified Name:     andg
 * JD-Core Version:    0.7.0.1
 */