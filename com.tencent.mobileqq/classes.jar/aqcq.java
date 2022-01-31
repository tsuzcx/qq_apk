import java.util.HashMap;
import java.util.Map;

public class aqcq
{
  private static aqcq jdField_a_of_type_Aqcq;
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public static aqcq a()
  {
    if (jdField_a_of_type_Aqcq == null) {
      jdField_a_of_type_Aqcq = new aqcq();
    }
    return jdField_a_of_type_Aqcq;
  }
  
  public static String a(String paramString)
  {
    if (jdField_a_of_type_Aqcq == null) {
      paramString = null;
    }
    String str;
    do
    {
      return paramString;
      str = (String)jdField_a_of_type_Aqcq.jdField_a_of_type_JavaUtilMap.remove(paramString);
      paramString = str;
    } while (!jdField_a_of_type_Aqcq.jdField_a_of_type_JavaUtilMap.isEmpty());
    jdField_a_of_type_Aqcq = null;
    return str;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqcq
 * JD-Core Version:    0.7.0.1
 */