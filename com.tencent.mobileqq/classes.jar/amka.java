import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amka
{
  private int jdField_a_of_type_Int = 1;
  private String jdField_a_of_type_JavaLangString = "";
  
  public static amka a()
  {
    return (amka)alzw.a().a(460);
  }
  
  public static amka a(alzs paramalzs)
  {
    amka localamka = new amka();
    if (paramalzs != null) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRobotConfBean", 2, "parse taskid->" + paramalzs.jdField_a_of_type_Int + " content->" + paramalzs.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramalzs = new JSONObject(paramalzs.jdField_a_of_type_JavaLangString);
      int i = paramalzs.optInt("robotswitch", 0);
      paramalzs = paramalzs.optString("c2cwarning", "");
      localamka.a(i);
      localamka.a(paramalzs);
      return localamka;
    }
    catch (JSONException paramalzs)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TroopRobotConfBean", 2, "parse error->" + paramalzs.toString());
    }
    return localamka;
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
 * Qualified Name:     amka
 * JD-Core Version:    0.7.0.1
 */