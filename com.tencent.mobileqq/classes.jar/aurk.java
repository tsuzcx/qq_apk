import java.util.HashMap;
import java.util.Map;

public class aurk
{
  private static aurk jdField_a_of_type_Aurk;
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public static aurk a()
  {
    if (jdField_a_of_type_Aurk == null) {
      jdField_a_of_type_Aurk = new aurk();
    }
    return jdField_a_of_type_Aurk;
  }
  
  public static String a(String paramString)
  {
    if (jdField_a_of_type_Aurk == null) {
      paramString = null;
    }
    String str;
    do
    {
      return paramString;
      str = (String)jdField_a_of_type_Aurk.jdField_a_of_type_JavaUtilMap.remove(paramString);
      paramString = str;
    } while (!jdField_a_of_type_Aurk.jdField_a_of_type_JavaUtilMap.isEmpty());
    jdField_a_of_type_Aurk = null;
    return str;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aurk
 * JD-Core Version:    0.7.0.1
 */