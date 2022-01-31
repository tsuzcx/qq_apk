public class awlz
{
  int jdField_a_of_type_Int;
  int[] jdField_a_of_type_ArrayOfInt;
  
  private awlz(int[] paramArrayOfInt, int paramInt)
  {
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  static awlz a(int[] paramArrayOfInt, int paramInt)
  {
    return new awlz(paramArrayOfInt, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awlz
 * JD-Core Version:    0.7.0.1
 */