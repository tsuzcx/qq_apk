public class bgnn
{
  private static volatile bgnn jdField_a_of_type_Bgnn;
  private static volatile byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  
  public static bgnn a()
  {
    if (jdField_a_of_type_Bgnn == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Bgnn == null) {
        jdField_a_of_type_Bgnn = new bgnn();
      }
      return jdField_a_of_type_Bgnn;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgnn
 * JD-Core Version:    0.7.0.1
 */