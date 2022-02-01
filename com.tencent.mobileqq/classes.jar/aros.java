import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aros
{
  private int jdField_a_of_type_Int = 1;
  private String jdField_a_of_type_JavaLangString = "";
  
  public static aros a()
  {
    return (aros)aran.a().a(460);
  }
  
  public static aros a(araj paramaraj)
  {
    aros localaros = new aros();
    if (paramaraj != null) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRobotConfBean", 2, "parse taskid->" + paramaraj.jdField_a_of_type_Int + " content->" + paramaraj.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramaraj = new JSONObject(paramaraj.jdField_a_of_type_JavaLangString);
      int i = paramaraj.optInt("robotswitch", 0);
      paramaraj = paramaraj.optString("c2cwarning", "");
      localaros.a(i);
      localaros.a(paramaraj);
      return localaros;
    }
    catch (JSONException paramaraj)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TroopRobotConfBean", 2, "parse error->" + paramaraj.toString());
    }
    return localaros;
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
 * Qualified Name:     aros
 * JD-Core Version:    0.7.0.1
 */