import java.util.HashMap;

public class ayva
{
  public static long a;
  public static Object a;
  public static HashMap<Long, ayvb> a;
  public static long b;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static ayvb a(long paramLong)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      ayvb localayvb2 = (ayvb)jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      ayvb localayvb1 = localayvb2;
      if (localayvb2 == null) {
        localayvb1 = new ayvb();
      }
      jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), localayvb1);
      return localayvb1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayva
 * JD-Core Version:    0.7.0.1
 */