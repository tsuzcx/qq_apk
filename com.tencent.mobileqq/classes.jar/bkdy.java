public class bkdy
  extends bkdw
{
  private static bkdy jdField_a_of_type_Bkdy;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  
  public static bkdy a()
  {
    if (jdField_a_of_type_Bkdy == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Bkdy == null) {
        jdField_a_of_type_Bkdy = new bkdy();
      }
      return jdField_a_of_type_Bkdy;
    }
  }
  
  public void a()
  {
    super.a();
    jdField_a_of_type_Bkdy = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkdy
 * JD-Core Version:    0.7.0.1
 */