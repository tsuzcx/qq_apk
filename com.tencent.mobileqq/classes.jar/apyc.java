import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class apyc
{
  public int a;
  public boolean a;
  
  public apyc()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 3;
  }
  
  public static apyc a(aptx paramaptx)
  {
    boolean bool = true;
    apyc localapyc = new apyc();
    if (paramaptx != null) {
      if (QLog.isColorLevel()) {
        QLog.d("GroupIntimateRelationshipBean", 2, "parse taskid->" + paramaptx.jdField_a_of_type_Int + " content->" + paramaptx.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      try
      {
        paramaptx = new JSONObject(paramaptx.jdField_a_of_type_JavaLangString);
        if (paramaptx.optInt("isTroopCardOpen", 1) != 1) {
          continue;
        }
        localapyc.jdField_a_of_type_Boolean = bool;
        localapyc.jdField_a_of_type_Int = paramaptx.optInt("prepareCount", 3);
      }
      catch (Exception paramaptx)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("GroupIntimateRelationshipBean", 2, "parse error->" + paramaptx.toString());
      }
      return localapyc;
      bool = false;
    }
    return localapyc;
  }
  
  public String toString()
  {
    return "isTroopCardOpen:" + this.jdField_a_of_type_Boolean + " prepareCount:" + this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apyc
 * JD-Core Version:    0.7.0.1
 */