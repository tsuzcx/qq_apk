public class awhq
{
  int jdField_a_of_type_Int;
  int[] jdField_a_of_type_ArrayOfInt;
  
  private awhq(int[] paramArrayOfInt, int paramInt)
  {
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  static awhq a(int[] paramArrayOfInt, int paramInt)
  {
    return new awhq(paramArrayOfInt, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awhq
 * JD-Core Version:    0.7.0.1
 */