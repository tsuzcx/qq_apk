public class bejf
{
  private static volatile bejf jdField_a_of_type_Bejf;
  private static volatile byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  
  public static bejf a()
  {
    if (jdField_a_of_type_Bejf == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Bejf == null) {
        jdField_a_of_type_Bejf = new bejf();
      }
      return jdField_a_of_type_Bejf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bejf
 * JD-Core Version:    0.7.0.1
 */