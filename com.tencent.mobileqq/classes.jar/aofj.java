class aofj
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private aofk jdField_a_of_type_Aofk;
  private Object jdField_a_of_type_JavaLangObject;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private byte[] c;
  
  aofj(aofe paramaofe)
  {
    a(false, 0L, null, null, 0);
  }
  
  aofj(aofe paramaofe, long paramLong, aofk paramaofk)
  {
    a(false, paramLong, null, paramaofk, 0);
  }
  
  aofj(aofe paramaofe, aofk paramaofk)
  {
    a(false, 0L, null, paramaofk, 0);
  }
  
  aofj(aofe paramaofe, String paramString)
  {
    a(false, 0L, paramString, null, 0);
  }
  
  aofj(aofe paramaofe, boolean paramBoolean, long paramLong)
  {
    a(paramBoolean, paramLong, null, null, 0);
  }
  
  aofj(aofe paramaofe, boolean paramBoolean, long paramLong, aofk paramaofk, int paramInt)
  {
    a(paramBoolean, paramLong, null, paramaofk, paramInt);
  }
  
  aofj(aofe paramaofe, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, aofk paramaofk)
  {
    a(false, 0L, null, paramaofk, 0);
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte1;
    this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte2;
    this.c = paramArrayOfByte3;
  }
  
  private void a(boolean paramBoolean, long paramLong, String paramString, aofk paramaofk, int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Aofk = paramaofk;
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
  
  aofk a()
  {
    return this.jdField_a_of_type_Aofk;
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
 * Qualified Name:     aofj
 * JD-Core Version:    0.7.0.1
 */