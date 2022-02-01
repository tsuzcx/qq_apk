import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class armb
{
  private int jdField_a_of_type_Int = 1;
  private String jdField_a_of_type_JavaLangString = "";
  
  public static armb a()
  {
    return (armb)aqxe.a().a(460);
  }
  
  public static armb a(aqxa paramaqxa)
  {
    armb localarmb = new armb();
    if (paramaqxa != null) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRobotConfBean", 2, "parse taskid->" + paramaqxa.jdField_a_of_type_Int + " content->" + paramaqxa.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramaqxa = new JSONObject(paramaqxa.jdField_a_of_type_JavaLangString);
      int i = paramaqxa.optInt("robotswitch", 0);
      paramaqxa = paramaqxa.optString("c2cwarning", "");
      localarmb.a(i);
      localarmb.a(paramaqxa);
      return localarmb;
    }
    catch (JSONException paramaqxa)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TroopRobotConfBean", 2, "parse error->" + paramaqxa.toString());
    }
    return localarmb;
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
 * Qualified Name:     armb
 * JD-Core Version:    0.7.0.1
 */