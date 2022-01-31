public class bdss
  extends bdsq
{
  private static bdss jdField_a_of_type_Bdss;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  
  public static bdss a()
  {
    if (jdField_a_of_type_Bdss == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Bdss == null) {
        jdField_a_of_type_Bdss = new bdss();
      }
      return jdField_a_of_type_Bdss;
    }
  }
  
  public void a()
  {
    super.a();
    jdField_a_of_type_Bdss = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bdss
 * JD-Core Version:    0.7.0.1
 */