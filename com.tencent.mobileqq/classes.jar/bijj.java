public class bijj
  extends bijh
{
  private static bijj jdField_a_of_type_Bijj;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  
  public static bijj a()
  {
    if (jdField_a_of_type_Bijj == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Bijj == null) {
        jdField_a_of_type_Bijj = new bijj();
      }
      return jdField_a_of_type_Bijj;
    }
  }
  
  public void a()
  {
    super.a();
    jdField_a_of_type_Bijj = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bijj
 * JD-Core Version:    0.7.0.1
 */