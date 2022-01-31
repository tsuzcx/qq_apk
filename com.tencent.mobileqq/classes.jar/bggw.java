import android.os.Handler;
import java.util.concurrent.ConcurrentHashMap;

public class bggw
  implements bggv
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static ConcurrentHashMap<String, bggw> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private int jdField_a_of_type_Int = -1;
  private bggv jdField_a_of_type_Bggv;
  private String jdField_a_of_type_JavaLangString;
  
  private bggw(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Bggv = bghb.a(this.jdField_a_of_type_JavaLangString);
  }
  
  public static bggw a(String paramString)
  {
    Object localObject1 = (bggw)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject1 == null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        bggw localbggw = (bggw)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        localObject1 = localbggw;
        if (localbggw == null)
        {
          localObject1 = new bggw(paramString);
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject1);
        }
        return localObject1;
      }
    }
    return localObject1;
  }
  
  public void a(Handler paramHandler)
  {
    this.jdField_a_of_type_Bggv.a(paramHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bggw
 * JD-Core Version:    0.7.0.1
 */