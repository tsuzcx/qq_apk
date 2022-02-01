import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqlo
{
  private int a;
  
  public static aqlo a(aptx paramaptx)
  {
    localaqlo = new aqlo();
    if (paramaptx != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SuspiciousTroopConfBean", 2, "parse taskid->" + paramaptx.jdField_a_of_type_Int + " content->" + paramaptx.jdField_a_of_type_JavaLangString);
      }
      try
      {
        if (paramaptx.jdField_a_of_type_JavaLangString == null) {}
        for (paramaptx = "";; paramaptx = paramaptx.jdField_a_of_type_JavaLangString)
        {
          localaqlo.jdField_a_of_type_Int = new JSONObject(paramaptx).optInt("suspiciousSwitch", 0);
          return localaqlo;
        }
        return localaqlo;
      }
      catch (JSONException paramaptx)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SuspiciousTroopConfBean", 2, "parse error->" + paramaptx.toString());
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
 * Qualified Name:     aqlo
 * JD-Core Version:    0.7.0.1
 */