import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aojo
{
  public int a;
  public boolean a;
  
  public aojo()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 3;
  }
  
  public static aojo a(aogf paramaogf)
  {
    boolean bool = true;
    aojo localaojo = new aojo();
    if (paramaogf != null) {
      if (QLog.isColorLevel()) {
        QLog.d("GroupIntimateRelationshipBean", 2, "parse taskid->" + paramaogf.jdField_a_of_type_Int + " content->" + paramaogf.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      try
      {
        paramaogf = new JSONObject(paramaogf.jdField_a_of_type_JavaLangString);
        if (paramaogf.optInt("isTroopCardOpen", 1) != 1) {
          continue;
        }
        localaojo.jdField_a_of_type_Boolean = bool;
        localaojo.jdField_a_of_type_Int = paramaogf.optInt("prepareCount", 3);
      }
      catch (Exception paramaogf)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("GroupIntimateRelationshipBean", 2, "parse error->" + paramaogf.toString());
      }
      return localaojo;
      bool = false;
    }
    return localaojo;
  }
  
  public String toString()
  {
    return "isTroopCardOpen:" + this.jdField_a_of_type_Boolean + " prepareCount:" + this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aojo
 * JD-Core Version:    0.7.0.1
 */