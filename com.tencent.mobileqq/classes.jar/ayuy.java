import java.util.HashMap;

public class ayuy
{
  public static long a;
  public static Object a;
  public static HashMap<Long, ayuz> a;
  public static long b;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static ayuz a(long paramLong)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      ayuz localayuz2 = (ayuz)jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      ayuz localayuz1 = localayuz2;
      if (localayuz2 == null) {
        localayuz1 = new ayuz();
      }
      jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), localayuz1);
      return localayuz1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayuy
 * JD-Core Version:    0.7.0.1
 */