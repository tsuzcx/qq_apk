import android.os.Handler;
import java.util.concurrent.ConcurrentHashMap;

public class bmkj
  implements bmki
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static ConcurrentHashMap<String, bmkj> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private int jdField_a_of_type_Int = -1;
  private bmki jdField_a_of_type_Bmki;
  private String jdField_a_of_type_JavaLangString;
  
  private bmkj(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Bmki = bmko.a(this.jdField_a_of_type_JavaLangString);
  }
  
  public static bmkj a(String paramString)
  {
    Object localObject1 = (bmkj)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject1 == null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        bmkj localbmkj = (bmkj)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        localObject1 = localbmkj;
        if (localbmkj == null)
        {
          localObject1 = new bmkj(paramString);
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject1);
        }
        return localObject1;
      }
    }
    return localObject1;
  }
  
  public void a(Handler paramHandler)
  {
    this.jdField_a_of_type_Bmki.a(paramHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmkj
 * JD-Core Version:    0.7.0.1
 */