public class aztc
{
  int jdField_a_of_type_Int;
  int[] jdField_a_of_type_ArrayOfInt;
  
  private aztc(int[] paramArrayOfInt, int paramInt)
  {
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  static aztc a(int[] paramArrayOfInt, int paramInt)
  {
    return new aztc(paramArrayOfInt, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aztc
 * JD-Core Version:    0.7.0.1
 */