import java.util.HashMap;

public class baxi
{
  public static long a;
  public static Object a;
  public static HashMap<Long, baxj> a;
  public static long b;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static baxj a(long paramLong)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      baxj localbaxj2 = (baxj)jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      baxj localbaxj1 = localbaxj2;
      if (localbaxj2 == null) {
        localbaxj1 = new baxj();
      }
      jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), localbaxj1);
      return localbaxj1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baxi
 * JD-Core Version:    0.7.0.1
 */