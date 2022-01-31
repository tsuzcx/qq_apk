class aowh
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private aowi jdField_a_of_type_Aowi;
  private Object jdField_a_of_type_JavaLangObject;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private byte[] c;
  
  aowh(aowc paramaowc)
  {
    a(false, 0L, null, null, 0);
  }
  
  aowh(aowc paramaowc, long paramLong, aowi paramaowi)
  {
    a(false, paramLong, null, paramaowi, 0);
  }
  
  aowh(aowc paramaowc, aowi paramaowi)
  {
    a(false, 0L, null, paramaowi, 0);
  }
  
  aowh(aowc paramaowc, String paramString)
  {
    a(false, 0L, paramString, null, 0);
  }
  
  aowh(aowc paramaowc, boolean paramBoolean, long paramLong)
  {
    a(paramBoolean, paramLong, null, null, 0);
  }
  
  aowh(aowc paramaowc, boolean paramBoolean, long paramLong, aowi paramaowi, int paramInt)
  {
    a(paramBoolean, paramLong, null, paramaowi, paramInt);
  }
  
  aowh(aowc paramaowc, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, aowi paramaowi)
  {
    a(false, 0L, null, paramaowi, 0);
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte1;
    this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte2;
    this.c = paramArrayOfByte3;
  }
  
  private void a(boolean paramBoolean, long paramLong, String paramString, aowi paramaowi, int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Aowi = paramaowi;
    this.jdField_a_of_type_JavaLangObject = null;
  }
  
  int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  aowi a()
  {
    return this.jdField_a_of_type_Aowi;
  }
  
  Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  void a()
  {
    this.jdField_a_of_type_Int += 1;
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  int b()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aowh
 * JD-Core Version:    0.7.0.1
 */