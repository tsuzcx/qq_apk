import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amsp
{
  public int a;
  public boolean a;
  
  public amsp()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 3;
  }
  
  public static amsp a(ampi paramampi)
  {
    boolean bool = true;
    amsp localamsp = new amsp();
    if (paramampi != null) {
      if (QLog.isColorLevel()) {
        QLog.d("GroupIntimateRelationshipBean", 2, "parse taskid->" + paramampi.jdField_a_of_type_Int + " content->" + paramampi.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      try
      {
        paramampi = new JSONObject(paramampi.jdField_a_of_type_JavaLangString);
        if (paramampi.optInt("isTroopCardOpen", 1) != 1) {
          continue;
        }
        localamsp.jdField_a_of_type_Boolean = bool;
        localamsp.jdField_a_of_type_Int = paramampi.optInt("prepareCount", 3);
      }
      catch (Exception paramampi)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("GroupIntimateRelationshipBean", 2, "parse error->" + paramampi.toString());
      }
      return localamsp;
      bool = false;
    }
    return localamsp;
  }
  
  public String toString()
  {
    return "isTroopCardOpen:" + this.jdField_a_of_type_Boolean + " prepareCount:" + this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amsp
 * JD-Core Version:    0.7.0.1
 */