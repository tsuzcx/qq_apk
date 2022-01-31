public class bfvy
  extends bfvw
{
  private static bfvy jdField_a_of_type_Bfvy;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  
  public static bfvy a()
  {
    if (jdField_a_of_type_Bfvy == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Bfvy == null) {
        jdField_a_of_type_Bfvy = new bfvy();
      }
      return jdField_a_of_type_Bfvy;
    }
  }
  
  public void a()
  {
    super.a();
    jdField_a_of_type_Bfvy = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfvy
 * JD-Core Version:    0.7.0.1
 */