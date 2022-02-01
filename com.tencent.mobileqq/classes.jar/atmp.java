import java.util.HashMap;
import java.util.Map;

public class atmp
{
  private static atmp jdField_a_of_type_Atmp;
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public static atmp a()
  {
    if (jdField_a_of_type_Atmp == null) {
      jdField_a_of_type_Atmp = new atmp();
    }
    return jdField_a_of_type_Atmp;
  }
  
  public static String a(String paramString)
  {
    if (jdField_a_of_type_Atmp == null) {
      paramString = null;
    }
    String str;
    do
    {
      return paramString;
      str = (String)jdField_a_of_type_Atmp.jdField_a_of_type_JavaUtilMap.remove(paramString);
      paramString = str;
    } while (!jdField_a_of_type_Atmp.jdField_a_of_type_JavaUtilMap.isEmpty());
    jdField_a_of_type_Atmp = null;
    return str;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atmp
 * JD-Core Version:    0.7.0.1
 */