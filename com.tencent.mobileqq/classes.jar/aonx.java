import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aonx
{
  public int a;
  public boolean a;
  
  public aonx()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 3;
  }
  
  public static aonx a(aoko paramaoko)
  {
    boolean bool = true;
    aonx localaonx = new aonx();
    if (paramaoko != null) {
      if (QLog.isColorLevel()) {
        QLog.d("GroupIntimateRelationshipBean", 2, "parse taskid->" + paramaoko.jdField_a_of_type_Int + " content->" + paramaoko.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      try
      {
        paramaoko = new JSONObject(paramaoko.jdField_a_of_type_JavaLangString);
        if (paramaoko.optInt("isTroopCardOpen", 1) != 1) {
          continue;
        }
        localaonx.jdField_a_of_type_Boolean = bool;
        localaonx.jdField_a_of_type_Int = paramaoko.optInt("prepareCount", 3);
      }
      catch (Exception paramaoko)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("GroupIntimateRelationshipBean", 2, "parse error->" + paramaoko.toString());
      }
      return localaonx;
      bool = false;
    }
    return localaonx;
  }
  
  public String toString()
  {
    return "isTroopCardOpen:" + this.jdField_a_of_type_Boolean + " prepareCount:" + this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aonx
 * JD-Core Version:    0.7.0.1
 */