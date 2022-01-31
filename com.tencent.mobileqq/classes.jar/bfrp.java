public class bfrp
  extends bfrn
{
  private static bfrp jdField_a_of_type_Bfrp;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  
  public static bfrp a()
  {
    if (jdField_a_of_type_Bfrp == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Bfrp == null) {
        jdField_a_of_type_Bfrp = new bfrp();
      }
      return jdField_a_of_type_Bfrp;
    }
  }
  
  public void a()
  {
    super.a();
    jdField_a_of_type_Bfrp = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfrp
 * JD-Core Version:    0.7.0.1
 */