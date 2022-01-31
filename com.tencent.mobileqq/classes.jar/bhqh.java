import android.os.Handler;
import java.util.concurrent.ConcurrentHashMap;

public class bhqh
  implements bhqg
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static ConcurrentHashMap<String, bhqh> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private int jdField_a_of_type_Int = -1;
  private bhqg jdField_a_of_type_Bhqg;
  private String jdField_a_of_type_JavaLangString;
  
  private bhqh(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Bhqg = bhqm.a(this.jdField_a_of_type_JavaLangString);
  }
  
  public static bhqh a(String paramString)
  {
    Object localObject1 = (bhqh)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject1 == null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        bhqh localbhqh = (bhqh)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        localObject1 = localbhqh;
        if (localbhqh == null)
        {
          localObject1 = new bhqh(paramString);
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject1);
        }
        return localObject1;
      }
    }
    return localObject1;
  }
  
  public void a(Handler paramHandler)
  {
    this.jdField_a_of_type_Bhqg.a(paramHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhqh
 * JD-Core Version:    0.7.0.1
 */