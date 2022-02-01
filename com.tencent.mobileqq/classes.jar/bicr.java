class bicr
{
  int jdField_a_of_type_Int;
  char[] jdField_a_of_type_ArrayOfChar = new char[4];
  
  private void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_Int = bicp.a(paramArrayOfByte);
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfChar.length)
    {
      this.jdField_a_of_type_ArrayOfChar[i] = ((char)paramArrayOfByte[(i + 4)]);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bicr
 * JD-Core Version:    0.7.0.1
 */