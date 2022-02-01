import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arem
{
  public int a;
  public boolean a;
  
  public arem()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 3;
  }
  
  public static arem a(araj paramaraj)
  {
    boolean bool = true;
    arem localarem = new arem();
    if (paramaraj != null) {
      if (QLog.isColorLevel()) {
        QLog.d("GroupIntimateRelationshipBean", 2, "parse taskid->" + paramaraj.jdField_a_of_type_Int + " content->" + paramaraj.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      try
      {
        paramaraj = new JSONObject(paramaraj.jdField_a_of_type_JavaLangString);
        if (paramaraj.optInt("isTroopCardOpen", 1) != 1) {
          continue;
        }
        localarem.jdField_a_of_type_Boolean = bool;
        localarem.jdField_a_of_type_Int = paramaraj.optInt("prepareCount", 3);
      }
      catch (Exception paramaraj)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("GroupIntimateRelationshipBean", 2, "parse error->" + paramaraj.toString());
      }
      return localarem;
      bool = false;
    }
    return localarem;
  }
  
  public String toString()
  {
    return "isTroopCardOpen:" + this.jdField_a_of_type_Boolean + " prepareCount:" + this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arem
 * JD-Core Version:    0.7.0.1
 */