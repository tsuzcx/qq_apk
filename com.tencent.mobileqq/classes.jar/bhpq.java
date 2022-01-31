import android.os.Handler;
import java.util.concurrent.ConcurrentHashMap;

public class bhpq
  implements bhpp
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static ConcurrentHashMap<String, bhpq> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private int jdField_a_of_type_Int = -1;
  private bhpp jdField_a_of_type_Bhpp;
  private String jdField_a_of_type_JavaLangString;
  
  private bhpq(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Bhpp = bhpv.a(this.jdField_a_of_type_JavaLangString);
  }
  
  public static bhpq a(String paramString)
  {
    Object localObject1 = (bhpq)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject1 == null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        bhpq localbhpq = (bhpq)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        localObject1 = localbhpq;
        if (localbhpq == null)
        {
          localObject1 = new bhpq(paramString);
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject1);
        }
        return localObject1;
      }
    }
    return localObject1;
  }
  
  public void a(Handler paramHandler)
  {
    this.jdField_a_of_type_Bhpp.a(paramHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhpq
 * JD-Core Version:    0.7.0.1
 */