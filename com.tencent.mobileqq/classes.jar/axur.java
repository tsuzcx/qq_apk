import java.util.HashMap;

public class axur
{
  public static long a;
  public static Object a;
  public static HashMap<Long, axus> a;
  public static long b;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static axus a(long paramLong)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      axus localaxus2 = (axus)jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      axus localaxus1 = localaxus2;
      if (localaxus2 == null) {
        localaxus1 = new axus();
      }
      jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), localaxus1);
      return localaxus1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axur
 * JD-Core Version:    0.7.0.1
 */