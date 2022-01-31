public class biby
{
  private static bibz a;
  public static String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "WadlProxyServiceUtil";
  }
  
  public static bibz a()
  {
    if (jdField_a_of_type_Bibz == null) {
      a();
    }
    return jdField_a_of_type_Bibz;
  }
  
  public static void a()
  {
    synchronized (jdField_a_of_type_JavaLangString)
    {
      if (jdField_a_of_type_Bibz == null) {
        jdField_a_of_type_Bibz = new bibz();
      }
      jdField_a_of_type_Bibz.a();
      return;
    }
  }
  
  public static void a(bibq parambibq)
  {
    if (jdField_a_of_type_Bibz != null) {
      jdField_a_of_type_Bibz.a(parambibq);
    }
  }
  
  public static void b()
  {
    if (jdField_a_of_type_Bibz != null)
    {
      jdField_a_of_type_Bibz.d();
      jdField_a_of_type_Bibz = null;
    }
  }
  
  public static void b(bibq parambibq)
  {
    if (jdField_a_of_type_Bibz != null) {
      jdField_a_of_type_Bibz.b(parambibq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     biby
 * JD-Core Version:    0.7.0.1
 */