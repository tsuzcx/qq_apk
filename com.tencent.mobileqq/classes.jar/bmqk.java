public class bmqk
{
  private static bmql a;
  public static String a;
  public static String b = "WadlProxyService.";
  
  static
  {
    jdField_a_of_type_JavaLangString = "WadlProxyServiceUtil";
  }
  
  public static bmql a()
  {
    if (jdField_a_of_type_Bmql == null) {
      a();
    }
    return jdField_a_of_type_Bmql;
  }
  
  public static void a()
  {
    synchronized (jdField_a_of_type_JavaLangString)
    {
      if (jdField_a_of_type_Bmql == null) {
        jdField_a_of_type_Bmql = new bmql();
      }
      jdField_a_of_type_Bmql.a();
      return;
    }
  }
  
  public static void a(bmqi parambmqi)
  {
    if (jdField_a_of_type_Bmql != null) {
      jdField_a_of_type_Bmql.a(parambmqi);
    }
  }
  
  public static void b()
  {
    if (jdField_a_of_type_Bmql != null)
    {
      jdField_a_of_type_Bmql.d();
      jdField_a_of_type_Bmql = null;
    }
  }
  
  public static void b(bmqi parambmqi)
  {
    if (jdField_a_of_type_Bmql != null) {
      jdField_a_of_type_Bmql.b(parambmqi);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmqk
 * JD-Core Version:    0.7.0.1
 */