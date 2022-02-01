final class bnzw
{
  public static int d = 16;
  int jdField_a_of_type_Int = 538116905;
  short jdField_a_of_type_Short = 1;
  int jdField_b_of_type_Int;
  short jdField_b_of_type_Short = 0;
  int c;
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[4];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 4);
    this.jdField_a_of_type_Int = bhgs.a(arrayOfByte);
    arrayOfByte = new byte[2];
    System.arraycopy(paramArrayOfByte, 4, arrayOfByte, 0, 2);
    this.jdField_a_of_type_Short = bhgs.a(arrayOfByte);
    arrayOfByte = new byte[4];
    System.arraycopy(paramArrayOfByte, 6, arrayOfByte, 0, 4);
    this.jdField_b_of_type_Int = bhgs.a(arrayOfByte);
    arrayOfByte = new byte[4];
    System.arraycopy(paramArrayOfByte, 10, arrayOfByte, 0, 4);
    this.c = bhgs.a(arrayOfByte);
    arrayOfByte = new byte[2];
    System.arraycopy(paramArrayOfByte, 14, arrayOfByte, 0, 2);
    this.jdField_b_of_type_Short = bhgs.a(arrayOfByte);
  }
  
  public byte[] a()
  {
    byte[] arrayOfByte = new byte[16];
    System.arraycopy(bhgs.a(this.jdField_a_of_type_Int), 0, arrayOfByte, 0, 4);
    System.arraycopy(bhgs.a(this.jdField_a_of_type_Short), 0, arrayOfByte, 4, 2);
    System.arraycopy(bhgs.a(this.jdField_b_of_type_Int), 0, arrayOfByte, 6, 4);
    System.arraycopy(bhgs.a(this.c), 0, arrayOfByte, 10, 4);
    System.arraycopy(bhgs.a(this.jdField_b_of_type_Short), 0, arrayOfByte, 14, 2);
    return arrayOfByte;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public void b(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnzw
 * JD-Core Version:    0.7.0.1
 */