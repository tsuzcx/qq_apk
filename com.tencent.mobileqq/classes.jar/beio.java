public class beio
{
  private static volatile beio jdField_a_of_type_Beio;
  private static volatile byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  
  public static beio a()
  {
    if (jdField_a_of_type_Beio == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Beio == null) {
        jdField_a_of_type_Beio = new beio();
      }
      return jdField_a_of_type_Beio;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beio
 * JD-Core Version:    0.7.0.1
 */