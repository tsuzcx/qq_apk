import android.os.Handler;
import java.util.concurrent.ConcurrentHashMap;

public class bjrs
  implements bjrr
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static ConcurrentHashMap<String, bjrs> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private int jdField_a_of_type_Int = -1;
  private bjrr jdField_a_of_type_Bjrr;
  private String jdField_a_of_type_JavaLangString;
  
  private bjrs(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Bjrr = bjrx.a(this.jdField_a_of_type_JavaLangString);
  }
  
  public static bjrs a(String paramString)
  {
    Object localObject1 = (bjrs)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject1 == null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        bjrs localbjrs = (bjrs)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        localObject1 = localbjrs;
        if (localbjrs == null)
        {
          localObject1 = new bjrs(paramString);
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject1);
        }
        return localObject1;
      }
    }
    return localObject1;
  }
  
  public void a(Handler paramHandler)
  {
    this.jdField_a_of_type_Bjrr.a(paramHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjrs
 * JD-Core Version:    0.7.0.1
 */