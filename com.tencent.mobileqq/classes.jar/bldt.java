public class bldt
{
  private static bldu a;
  public static String a;
  public static String b = "WadlProxyService.";
  
  static
  {
    jdField_a_of_type_JavaLangString = "WadlProxyServiceUtil";
  }
  
  public static bldu a()
  {
    if (jdField_a_of_type_Bldu == null) {
      a();
    }
    return jdField_a_of_type_Bldu;
  }
  
  public static void a()
  {
    synchronized (jdField_a_of_type_JavaLangString)
    {
      if (jdField_a_of_type_Bldu == null) {
        jdField_a_of_type_Bldu = new bldu();
      }
      jdField_a_of_type_Bldu.a();
      return;
    }
  }
  
  public static void a(bldr parambldr)
  {
    if (jdField_a_of_type_Bldu != null) {
      jdField_a_of_type_Bldu.a(parambldr);
    }
  }
  
  public static void b()
  {
    if (jdField_a_of_type_Bldu != null)
    {
      jdField_a_of_type_Bldu.d();
      jdField_a_of_type_Bldu = null;
    }
  }
  
  public static void b(bldr parambldr)
  {
    if (jdField_a_of_type_Bldu != null) {
      jdField_a_of_type_Bldu.b(parambldr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bldt
 * JD-Core Version:    0.7.0.1
 */