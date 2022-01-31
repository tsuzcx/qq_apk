public class bdeo
{
  private static volatile bdeo jdField_a_of_type_Bdeo;
  private static volatile byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  
  public static bdeo a()
  {
    if (jdField_a_of_type_Bdeo == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Bdeo == null) {
        jdField_a_of_type_Bdeo = new bdeo();
      }
      return jdField_a_of_type_Bdeo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdeo
 * JD-Core Version:    0.7.0.1
 */