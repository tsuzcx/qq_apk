import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqpe
{
  public int a;
  public boolean a;
  
  public aqpe()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 3;
  }
  
  public static aqpe a(aqlg paramaqlg)
  {
    boolean bool = true;
    aqpe localaqpe = new aqpe();
    if (paramaqlg != null) {
      if (QLog.isColorLevel()) {
        QLog.d("GroupIntimateRelationshipBean", 2, "parse taskid->" + paramaqlg.jdField_a_of_type_Int + " content->" + paramaqlg.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      try
      {
        paramaqlg = new JSONObject(paramaqlg.jdField_a_of_type_JavaLangString);
        if (paramaqlg.optInt("isTroopCardOpen", 1) != 1) {
          continue;
        }
        localaqpe.jdField_a_of_type_Boolean = bool;
        localaqpe.jdField_a_of_type_Int = paramaqlg.optInt("prepareCount", 3);
      }
      catch (Exception paramaqlg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("GroupIntimateRelationshipBean", 2, "parse error->" + paramaqlg.toString());
      }
      return localaqpe;
      bool = false;
    }
    return localaqpe;
  }
  
  public String toString()
  {
    return "isTroopCardOpen:" + this.jdField_a_of_type_Boolean + " prepareCount:" + this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqpe
 * JD-Core Version:    0.7.0.1
 */