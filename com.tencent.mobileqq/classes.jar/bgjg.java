public class bgjg
{
  private static volatile bgjg jdField_a_of_type_Bgjg;
  private static volatile byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  
  public static bgjg a()
  {
    if (jdField_a_of_type_Bgjg == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Bgjg == null) {
        jdField_a_of_type_Bgjg = new bgjg();
      }
      return jdField_a_of_type_Bgjg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgjg
 * JD-Core Version:    0.7.0.1
 */