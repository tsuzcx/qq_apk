import android.os.Handler;
import java.util.concurrent.ConcurrentHashMap;

public class bjvz
  implements bjvy
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static ConcurrentHashMap<String, bjvz> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private int jdField_a_of_type_Int = -1;
  private bjvy jdField_a_of_type_Bjvy;
  private String jdField_a_of_type_JavaLangString;
  
  private bjvz(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Bjvy = bjwe.a(this.jdField_a_of_type_JavaLangString);
  }
  
  public static bjvz a(String paramString)
  {
    Object localObject1 = (bjvz)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject1 == null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        bjvz localbjvz = (bjvz)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        localObject1 = localbjvz;
        if (localbjvz == null)
        {
          localObject1 = new bjvz(paramString);
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject1);
        }
        return localObject1;
      }
    }
    return localObject1;
  }
  
  public void a(Handler paramHandler)
  {
    this.jdField_a_of_type_Bjvy.a(paramHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjvz
 * JD-Core Version:    0.7.0.1
 */