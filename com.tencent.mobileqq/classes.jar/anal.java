import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class anal
{
  private int jdField_a_of_type_Int = 1;
  private String jdField_a_of_type_JavaLangString = "";
  
  public static anal a()
  {
    return (anal)ampl.a().a(460);
  }
  
  public static anal a(amph paramamph)
  {
    anal localanal = new anal();
    if (paramamph != null) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRobotConfBean", 2, "parse taskid->" + paramamph.jdField_a_of_type_Int + " content->" + paramamph.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramamph = new JSONObject(paramamph.jdField_a_of_type_JavaLangString);
      int i = paramamph.optInt("robotswitch", 0);
      paramamph = paramamph.optString("c2cwarning", "");
      localanal.a(i);
      localanal.a(paramamph);
      return localanal;
    }
    catch (JSONException paramamph)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TroopRobotConfBean", 2, "parse error->" + paramamph.toString());
    }
    return localanal;
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
 * Qualified Name:     anal
 * JD-Core Version:    0.7.0.1
 */