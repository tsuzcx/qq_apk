class bhkv
{
  static final int[] jdField_a_of_type_ArrayOfInt = new int[0];
  static final long[] jdField_a_of_type_ArrayOfLong = new long[0];
  static final Object[] jdField_a_of_type_ArrayOfJavaLangObject = new Object[0];
  
  static int a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = paramInt1 - 1;
    paramInt1 = i;
    i = j;
    while (paramInt1 <= i)
    {
      j = paramInt1 + i >>> 1;
      int k = paramArrayOfInt[j];
      if (k < paramInt2) {
        paramInt1 = j + 1;
      } else if (k > paramInt2) {
        i = j - 1;
      } else {
        return j;
      }
    }
    return paramInt1 ^ 0xFFFFFFFF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhkv
 * JD-Core Version:    0.7.0.1
 */