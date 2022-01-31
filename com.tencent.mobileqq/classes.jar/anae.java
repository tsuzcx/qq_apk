import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class anae
{
  private int jdField_a_of_type_Int = 1;
  private String jdField_a_of_type_JavaLangString = "";
  
  public static anae a()
  {
    return (anae)ampm.a().a(460);
  }
  
  public static anae a(ampi paramampi)
  {
    anae localanae = new anae();
    if (paramampi != null) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRobotConfBean", 2, "parse taskid->" + paramampi.jdField_a_of_type_Int + " content->" + paramampi.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramampi = new JSONObject(paramampi.jdField_a_of_type_JavaLangString);
      int i = paramampi.optInt("robotswitch", 0);
      paramampi = paramampi.optString("c2cwarning", "");
      localanae.a(i);
      localanae.a(paramampi);
      return localanae;
    }
    catch (JSONException paramampi)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TroopRobotConfBean", 2, "parse error->" + paramampi.toString());
    }
    return localanae;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  public String toString()
  {
    return String.format("mTroopRobotSwitch:%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anae
 * JD-Core Version:    0.7.0.1
 */