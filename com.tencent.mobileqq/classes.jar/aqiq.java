import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aqiq
{
  private int jdField_a_of_type_Int = 1;
  private String jdField_a_of_type_JavaLangString = "";
  
  public static aqiq a()
  {
    return (aqiq)apub.a().a(460);
  }
  
  public static aqiq a(aptx paramaptx)
  {
    aqiq localaqiq = new aqiq();
    if (paramaptx != null) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopRobotConfBean", 2, "parse taskid->" + paramaptx.jdField_a_of_type_Int + " content->" + paramaptx.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramaptx = new JSONObject(paramaptx.jdField_a_of_type_JavaLangString);
      int i = paramaptx.optInt("robotswitch", 0);
      paramaptx = paramaptx.optString("c2cwarning", "");
      localaqiq.a(i);
      localaqiq.a(paramaptx);
      return localaqiq;
    }
    catch (JSONException paramaptx)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TroopRobotConfBean", 2, "parse error->" + paramaptx.toString());
    }
    return localaqiq;
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
 * Qualified Name:     aqiq
 * JD-Core Version:    0.7.0.1
 */