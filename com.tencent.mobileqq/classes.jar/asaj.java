import java.util.HashMap;
import java.util.Map;

public class asaj
{
  private static asaj jdField_a_of_type_Asaj;
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public static asaj a()
  {
    if (jdField_a_of_type_Asaj == null) {
      jdField_a_of_type_Asaj = new asaj();
    }
    return jdField_a_of_type_Asaj;
  }
  
  public static String a(String paramString)
  {
    if (jdField_a_of_type_Asaj == null) {
      paramString = null;
    }
    String str;
    do
    {
      return paramString;
      str = (String)jdField_a_of_type_Asaj.jdField_a_of_type_JavaUtilMap.remove(paramString);
      paramString = str;
    } while (!jdField_a_of_type_Asaj.jdField_a_of_type_JavaUtilMap.isEmpty());
    jdField_a_of_type_Asaj = null;
    return str;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asaj
 * JD-Core Version:    0.7.0.1
 */