public class bghk
{
  public static int a;
  private static long jdField_a_of_type_Long;
  private static boolean jdField_a_of_type_Boolean;
  public static int b;
  private static long jdField_b_of_type_Long;
  private static boolean jdField_b_of_type_Boolean;
  public static int c;
  private static long c;
  private static int d;
  private static int e;
  
  static
  {
    jdField_a_of_type_Int = 2001;
    jdField_b_of_type_Int = 2002;
    jdField_c_of_type_Int = 2003;
    d = bglq.a("qqminiapp", "MiniAppGameStartLimit", 30) * 1000;
    e = bglq.a("qqminiapp", "MiniAppLastShowLimit", 60) * 1000;
    jdField_a_of_type_Long = -1L;
    jdField_b_of_type_Long = -1L;
    jdField_c_of_type_Long = -1L;
  }
  
  public static int a()
  {
    long l = System.currentTimeMillis();
    if (l - jdField_a_of_type_Long < d) {
      return jdField_a_of_type_Int;
    }
    if ((l - jdField_b_of_type_Long < e) || (l - jdField_c_of_type_Long < e)) {
      return jdField_b_of_type_Int;
    }
    if ((jdField_a_of_type_Boolean) || (jdField_b_of_type_Boolean)) {
      return jdField_c_of_type_Int;
    }
    return 0;
  }
  
  public static void a(long paramLong)
  {
    jdField_a_of_type_Long = paramLong;
  }
  
  public static void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean) {
      jdField_b_of_type_Long = System.currentTimeMillis();
    }
  }
  
  public static void b(boolean paramBoolean)
  {
    jdField_b_of_type_Boolean = paramBoolean;
    if (paramBoolean) {
      jdField_c_of_type_Long = System.currentTimeMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bghk
 * JD-Core Version:    0.7.0.1
 */