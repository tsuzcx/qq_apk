import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class andl
{
  private int a;
  
  public static andl a(amph paramamph)
  {
    localandl = new andl();
    if (paramamph != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SuspiciousTroopConfBean", 2, "parse taskid->" + paramamph.jdField_a_of_type_Int + " content->" + paramamph.jdField_a_of_type_JavaLangString);
      }
      try
      {
        if (paramamph.jdField_a_of_type_JavaLangString == null) {}
        for (paramamph = "";; paramamph = paramamph.jdField_a_of_type_JavaLangString)
        {
          localandl.jdField_a_of_type_Int = new JSONObject(paramamph).optInt("suspiciousSwitch", 0);
          return localandl;
        }
        return localandl;
      }
      catch (JSONException paramamph)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SuspiciousTroopConfBean", 2, "parse error->" + paramamph.toString());
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
 * Qualified Name:     andl
 * JD-Core Version:    0.7.0.1
 */