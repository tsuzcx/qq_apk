public class bbrj
{
  static
  {
    if (!bbrj.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public static byte[] a(String paramString, int paramInt)
  {
    return a(paramString.getBytes(), paramInt);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    bbrl localbbrl = new bbrl(paramInt3, new byte[paramInt2 * 3 / 4]);
    if (!localbbrl.a(paramArrayOfByte, paramInt1, paramInt2, true)) {
      throw new IllegalArgumentException("bad base-64");
    }
    if (localbbrl.jdField_a_of_type_Int == localbbrl.jdField_a_of_type_ArrayOfByte.length) {
      return localbbrl.jdField_a_of_type_ArrayOfByte;
    }
    paramArrayOfByte = new byte[localbbrl.jdField_a_of_type_Int];
    System.arraycopy(localbbrl.jdField_a_of_type_ArrayOfByte, 0, paramArrayOfByte, 0, localbbrl.jdField_a_of_type_Int);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbrj
 * JD-Core Version:    0.7.0.1
 */