public class atsf
{
  int jdField_a_of_type_Int;
  int[] jdField_a_of_type_ArrayOfInt;
  
  private atsf(int[] paramArrayOfInt, int paramInt)
  {
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  static atsf a(int[] paramArrayOfInt, int paramInt)
  {
    return new atsf(paramArrayOfInt, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     atsf
 * JD-Core Version:    0.7.0.1
 */