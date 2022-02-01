import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arbf
{
  public int a;
  public boolean a;
  
  public arbf()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 3;
  }
  
  public static arbf a(aqxa paramaqxa)
  {
    boolean bool = true;
    arbf localarbf = new arbf();
    if (paramaqxa != null) {
      if (QLog.isColorLevel()) {
        QLog.d("GroupIntimateRelationshipBean", 2, "parse taskid->" + paramaqxa.jdField_a_of_type_Int + " content->" + paramaqxa.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      try
      {
        paramaqxa = new JSONObject(paramaqxa.jdField_a_of_type_JavaLangString);
        if (paramaqxa.optInt("isTroopCardOpen", 1) != 1) {
          continue;
        }
        localarbf.jdField_a_of_type_Boolean = bool;
        localarbf.jdField_a_of_type_Int = paramaqxa.optInt("prepareCount", 3);
      }
      catch (Exception paramaqxa)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("GroupIntimateRelationshipBean", 2, "parse error->" + paramaqxa.toString());
      }
      return localarbf;
      bool = false;
    }
    return localarbf;
  }
  
  public String toString()
  {
    return "isTroopCardOpen:" + this.jdField_a_of_type_Boolean + " prepareCount:" + this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arbf
 * JD-Core Version:    0.7.0.1
 */