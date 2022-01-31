import java.util.HashMap;
import java.util.Map;

public class aqcs
{
  private static aqcs jdField_a_of_type_Aqcs;
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public static aqcs a()
  {
    if (jdField_a_of_type_Aqcs == null) {
      jdField_a_of_type_Aqcs = new aqcs();
    }
    return jdField_a_of_type_Aqcs;
  }
  
  public static String a(String paramString)
  {
    if (jdField_a_of_type_Aqcs == null) {
      paramString = null;
    }
    String str;
    do
    {
      return paramString;
      str = (String)jdField_a_of_type_Aqcs.jdField_a_of_type_JavaUtilMap.remove(paramString);
      paramString = str;
    } while (!jdField_a_of_type_Aqcs.jdField_a_of_type_JavaUtilMap.isEmpty());
    jdField_a_of_type_Aqcs = null;
    return str;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqcs
 * JD-Core Version:    0.7.0.1
 */