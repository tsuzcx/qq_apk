import android.os.Handler;
import java.util.concurrent.ConcurrentHashMap;

public class bnlm
  implements bnll
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static ConcurrentHashMap<String, bnlm> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private int jdField_a_of_type_Int = -1;
  private bnll jdField_a_of_type_Bnll;
  private String jdField_a_of_type_JavaLangString;
  
  private bnlm(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Bnll = bnlr.a(this.jdField_a_of_type_JavaLangString);
  }
  
  public static bnlm a(String paramString)
  {
    Object localObject1 = (bnlm)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject1 == null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        bnlm localbnlm = (bnlm)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        localObject1 = localbnlm;
        if (localbnlm == null)
        {
          localObject1 = new bnlm(paramString);
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject1);
        }
        return localObject1;
      }
    }
    return localObject1;
  }
  
  public void a(Handler paramHandler)
  {
    this.jdField_a_of_type_Bnll.a(paramHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnlm
 * JD-Core Version:    0.7.0.1
 */