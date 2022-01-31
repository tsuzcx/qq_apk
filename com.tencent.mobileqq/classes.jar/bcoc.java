public class bcoc
  extends bcoa
{
  private static bcoc jdField_a_of_type_Bcoc;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  
  public static bcoc a()
  {
    if (jdField_a_of_type_Bcoc == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Bcoc == null) {
        jdField_a_of_type_Bcoc = new bcoc();
      }
      return jdField_a_of_type_Bcoc;
    }
  }
  
  public void a()
  {
    super.a();
    jdField_a_of_type_Bcoc = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bcoc
 * JD-Core Version:    0.7.0.1
 */