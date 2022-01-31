import java.util.HashMap;
import java.util.Map;

public class arwa
{
  private static arwa jdField_a_of_type_Arwa;
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public static arwa a()
  {
    if (jdField_a_of_type_Arwa == null) {
      jdField_a_of_type_Arwa = new arwa();
    }
    return jdField_a_of_type_Arwa;
  }
  
  public static String a(String paramString)
  {
    if (jdField_a_of_type_Arwa == null) {
      paramString = null;
    }
    String str;
    do
    {
      return paramString;
      str = (String)jdField_a_of_type_Arwa.jdField_a_of_type_JavaUtilMap.remove(paramString);
      paramString = str;
    } while (!jdField_a_of_type_Arwa.jdField_a_of_type_JavaUtilMap.isEmpty());
    jdField_a_of_type_Arwa = null;
    return str;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arwa
 * JD-Core Version:    0.7.0.1
 */