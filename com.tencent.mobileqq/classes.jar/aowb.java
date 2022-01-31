import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aowb
{
  private int jdField_a_of_type_Int = 1;
  private String jdField_a_of_type_JavaLangString = "";
  
  public static aowb a()
  {
    return (aowb)aoks.a().a(460);
  }
  
  public static aowb a(aoko paramaoko)
  {
    aowb localaowb = new aowb();
    if (paramaoko != null) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRobotConfBean", 2, "parse taskid->" + paramaoko.jdField_a_of_type_Int + " content->" + paramaoko.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramaoko = new JSONObject(paramaoko.jdField_a_of_type_JavaLangString);
      int i = paramaoko.optInt("robotswitch", 0);
      paramaoko = paramaoko.optString("c2cwarning", "");
      localaowb.a(i);
      localaowb.a(paramaoko);
      return localaowb;
    }
    catch (JSONException paramaoko)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TroopRobotConfBean", 2, "parse error->" + paramaoko.toString());
    }
    return localaowb;
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
 * Qualified Name:     aowb
 * JD-Core Version:    0.7.0.1
 */