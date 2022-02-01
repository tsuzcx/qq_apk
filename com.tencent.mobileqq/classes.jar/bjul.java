public class bjul
  extends bjuj
{
  private static bjul jdField_a_of_type_Bjul;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  
  public static bjul a()
  {
    if (jdField_a_of_type_Bjul == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Bjul == null) {
        jdField_a_of_type_Bjul = new bjul();
      }
      return jdField_a_of_type_Bjul;
    }
  }
  
  public void a()
  {
    super.a();
    jdField_a_of_type_Bjul = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjul
 * JD-Core Version:    0.7.0.1
 */