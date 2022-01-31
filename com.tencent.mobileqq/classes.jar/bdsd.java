public class bdsd
  extends bdsb
{
  private static bdsd jdField_a_of_type_Bdsd;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  
  public static bdsd a()
  {
    if (jdField_a_of_type_Bdsd == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Bdsd == null) {
        jdField_a_of_type_Bdsd = new bdsd();
      }
      return jdField_a_of_type_Bdsd;
    }
  }
  
  public void a()
  {
    super.a();
    jdField_a_of_type_Bdsd = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bdsd
 * JD-Core Version:    0.7.0.1
 */