import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amxj
{
  private int a;
  
  public amxj()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public static amxj a(amph paramamph)
  {
    amxj localamxj = new amxj();
    if (paramamph != null) {
      if (QLog.isColorLevel()) {
        QLog.d("SysSuspiciousConfBean", 2, "parse taskid->" + paramamph.jdField_a_of_type_Int + " content->" + paramamph.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      localamxj.jdField_a_of_type_Int = new JSONObject(paramamph.jdField_a_of_type_JavaLangString).optInt("suspiciousSwitch", 1);
      return localamxj;
    }
    catch (JSONException paramamph)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SysSuspiciousConfBean", 2, "parse error->" + paramamph.toString());
    }
    return localamxj;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amxj
 * JD-Core Version:    0.7.0.1
 */