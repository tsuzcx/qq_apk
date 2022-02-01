public class bjcz
  extends bjcx
{
  private static bjcz jdField_a_of_type_Bjcz;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  
  public static bjcz a()
  {
    if (jdField_a_of_type_Bjcz == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Bjcz == null) {
        jdField_a_of_type_Bjcz = new bjcz();
      }
      return jdField_a_of_type_Bjcz;
    }
  }
  
  public void a()
  {
    super.a();
    jdField_a_of_type_Bjcz = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjcz
 * JD-Core Version:    0.7.0.1
 */