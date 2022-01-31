import java.util.HashMap;

public class basz
{
  public static long a;
  public static Object a;
  public static HashMap<Long, bata> a;
  public static long b;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static bata a(long paramLong)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      bata localbata2 = (bata)jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      bata localbata1 = localbata2;
      if (localbata2 == null) {
        localbata1 = new bata();
      }
      jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), localbata1);
      return localbata1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     basz
 * JD-Core Version:    0.7.0.1
 */