import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aroz
{
  private int a;
  
  public static aroz a(aqxa paramaqxa)
  {
    localaroz = new aroz();
    if (paramaqxa != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SuspiciousTroopConfBean", 2, "parse taskid->" + paramaqxa.jdField_a_of_type_Int + " content->" + paramaqxa.jdField_a_of_type_JavaLangString);
      }
      try
      {
        if (paramaqxa.jdField_a_of_type_JavaLangString == null) {}
        for (paramaqxa = "";; paramaqxa = paramaqxa.jdField_a_of_type_JavaLangString)
        {
          localaroz.jdField_a_of_type_Int = new JSONObject(paramaqxa).optInt("suspiciousSwitch", 0);
          return localaroz;
        }
        return localaroz;
      }
      catch (JSONException paramaqxa)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SuspiciousTroopConfBean", 2, "parse error->" + paramaqxa.toString());
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
 * Qualified Name:     aroz
 * JD-Core Version:    0.7.0.1
 */