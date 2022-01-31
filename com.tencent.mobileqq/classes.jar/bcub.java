public class bcub
{
  private static int jdField_a_of_type_Int = 0;
  private static long jdField_a_of_type_Long;
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    case 0: 
      return 1;
    case 1: 
      return 2;
    case 3000: 
      return 4;
    }
    return 3;
  }
  
  public static void a()
  {
    jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public static void a(int paramInt)
  {
    axqy.b(null, "dc00898", "", "", "0X800A496", "0X800A496", paramInt, 0, String.valueOf(paramInt), "", "", "");
  }
  
  public static void b()
  {
    axqy.b(null, "dc00898", "", "", "0X800A494", "0X800A494", 0, 0, "", "", "", "");
  }
  
  public static void b(int paramInt)
  {
    jdField_a_of_type_Int = paramInt;
    axqy.b(null, "dc00898", "", "", "0X800A20B", "0X800A20B", paramInt, 0, String.valueOf(paramInt), "", "", "");
  }
  
  public static void c()
  {
    axqy.b(null, "dc00898", "", "", "0X800A495", "0X800A495", 0, 0, "", "", "", "");
  }
  
  public static void c(int paramInt)
  {
    axqy.b(null, "dc00898", "", "", "0X800A87C", "0X800A87C", jdField_a_of_type_Int, 0, String.valueOf(paramInt / 1000), "", "", "");
  }
  
  public static void d()
  {
    axqy.b(null, "dc00898", "", "", "0X800A20C", "0X800A20C", 0, 0, "", "", "", "");
    d(1);
  }
  
  public static void d(int paramInt)
  {
    if (jdField_a_of_type_Long == 0L) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = jdField_a_of_type_Long;
    jdField_a_of_type_Long = 0L;
    axqy.b(null, "dc00898", "", "", "0X800A87D", "0X800A87D", paramInt, 0, String.valueOf((l1 - l2) / 1000L), "", "", "");
  }
  
  public static void e()
  {
    axqy.b(null, "dc00898", "", "", "0X800A20D", "0X800A20D", 0, 0, "", "", "", "");
    d(2);
    a();
  }
  
  public static void e(int paramInt)
  {
    if (jdField_a_of_type_Long == 0L) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = jdField_a_of_type_Long;
    jdField_a_of_type_Long = 0L;
    axqy.b(null, "dc00898", "", "", "0X800A87E", "0X800A87E", paramInt, 0, String.valueOf((l1 - l2) / 1000L), "", "", "");
  }
  
  public static void f()
  {
    axqy.b(null, "dc00898", "", "", "0X800A20E", "0X800A20E", 0, 0, "", "", "", "");
    e(2);
    a();
  }
  
  public static void g()
  {
    axqy.b(null, "dc00898", "", "", "0X800A20F", "0X800A20F", 0, 0, "", "", "", "");
    e(1);
  }
  
  public static void h()
  {
    axqy.b(null, "dc00898", "", "", "0X800A210", "0X800A210", 0, 0, "", "", "", "");
  }
  
  public static void i()
  {
    axqy.b(null, "dc00898", "", "", "0X800A87F", "0X800A87F", jdField_a_of_type_Int, 0, "", "", "", "");
  }
  
  public static void j()
  {
    axqy.b(null, "dc00898", "", "", "0X800A880", "0X800A880", jdField_a_of_type_Int, 0, "", "", "", "");
  }
  
  public static void k()
  {
    axqy.b(null, "dc00898", "", "", "0X800A881", "0X800A881", jdField_a_of_type_Int, 0, "", "", "", "");
    e(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcub
 * JD-Core Version:    0.7.0.1
 */