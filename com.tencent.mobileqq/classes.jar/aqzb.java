import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqzb
{
  private int jdField_a_of_type_Int = 1;
  private String jdField_a_of_type_JavaLangString = "";
  
  public static aqzb a()
  {
    return (aqzb)aqlk.a().a(460);
  }
  
  public static aqzb a(aqlg paramaqlg)
  {
    aqzb localaqzb = new aqzb();
    if (paramaqlg != null) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRobotConfBean", 2, "parse taskid->" + paramaqlg.jdField_a_of_type_Int + " content->" + paramaqlg.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramaqlg = new JSONObject(paramaqlg.jdField_a_of_type_JavaLangString);
      int i = paramaqlg.optInt("robotswitch", 0);
      paramaqlg = paramaqlg.optString("c2cwarning", "");
      localaqzb.a(i);
      localaqzb.a(paramaqlg);
      return localaqzb;
    }
    catch (JSONException paramaqlg)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TroopRobotConfBean", 2, "parse error->" + paramaqlg.toString());
    }
    return localaqzb;
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
 * Qualified Name:     aqzb
 * JD-Core Version:    0.7.0.1
 */