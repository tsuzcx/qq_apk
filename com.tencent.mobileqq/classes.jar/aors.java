import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aors
{
  private int jdField_a_of_type_Int = 1;
  private String jdField_a_of_type_JavaLangString = "";
  
  public static aors a()
  {
    return (aors)aogj.a().a(460);
  }
  
  public static aors a(aogf paramaogf)
  {
    aors localaors = new aors();
    if (paramaogf != null) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRobotConfBean", 2, "parse taskid->" + paramaogf.jdField_a_of_type_Int + " content->" + paramaogf.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramaogf = new JSONObject(paramaogf.jdField_a_of_type_JavaLangString);
      int i = paramaogf.optInt("robotswitch", 0);
      paramaogf = paramaogf.optString("c2cwarning", "");
      localaors.a(i);
      localaors.a(paramaogf);
      return localaors;
    }
    catch (JSONException paramaogf)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TroopRobotConfBean", 2, "parse error->" + paramaogf.toString());
    }
    return localaors;
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
 * Qualified Name:     aors
 * JD-Core Version:    0.7.0.1
 */