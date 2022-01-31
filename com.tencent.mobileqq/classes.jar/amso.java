import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amso
{
  public int a;
  public boolean a;
  
  public amso()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 3;
  }
  
  public static amso a(amph paramamph)
  {
    boolean bool = true;
    amso localamso = new amso();
    if (paramamph != null) {
      if (QLog.isColorLevel()) {
        QLog.d("GroupIntimateRelationshipBean", 2, "parse taskid->" + paramamph.jdField_a_of_type_Int + " content->" + paramamph.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      try
      {
        paramamph = new JSONObject(paramamph.jdField_a_of_type_JavaLangString);
        if (paramamph.optInt("isTroopCardOpen", 1) != 1) {
          continue;
        }
        localamso.jdField_a_of_type_Boolean = bool;
        localamso.jdField_a_of_type_Int = paramamph.optInt("prepareCount", 3);
      }
      catch (Exception paramamph)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("GroupIntimateRelationshipBean", 2, "parse error->" + paramamph.toString());
      }
      return localamso;
      bool = false;
    }
    return localamso;
  }
  
  public String toString()
  {
    return "isTroopCardOpen:" + this.jdField_a_of_type_Boolean + " prepareCount:" + this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amso
 * JD-Core Version:    0.7.0.1
 */