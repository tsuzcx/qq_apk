import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amcp
{
  public int a;
  public boolean a;
  
  public amcp()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 3;
  }
  
  public static amcp a(alzs paramalzs)
  {
    boolean bool = true;
    amcp localamcp = new amcp();
    if (paramalzs != null) {
      if (QLog.isColorLevel()) {
        QLog.d("GroupIntimateRelationshipBean", 2, "parse taskid->" + paramalzs.jdField_a_of_type_Int + " content->" + paramalzs.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      try
      {
        paramalzs = new JSONObject(paramalzs.jdField_a_of_type_JavaLangString);
        if (paramalzs.optInt("isTroopCardOpen", 1) != 1) {
          continue;
        }
        localamcp.jdField_a_of_type_Boolean = bool;
        localamcp.jdField_a_of_type_Int = paramalzs.optInt("prepareCount", 3);
      }
      catch (Exception paramalzs)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("GroupIntimateRelationshipBean", 2, "parse error->" + paramalzs.toString());
      }
      return localamcp;
      bool = false;
    }
    return localamcp;
  }
  
  public String toString()
  {
    return "isTroopCardOpen:" + this.jdField_a_of_type_Boolean + " prepareCount:" + this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amcp
 * JD-Core Version:    0.7.0.1
 */