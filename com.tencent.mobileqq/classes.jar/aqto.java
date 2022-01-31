class aqto
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private aqtp jdField_a_of_type_Aqtp;
  private Object jdField_a_of_type_JavaLangObject;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private byte[] c;
  
  aqto(aqtj paramaqtj)
  {
    a(false, 0L, null, null, 0);
  }
  
  aqto(aqtj paramaqtj, long paramLong, aqtp paramaqtp)
  {
    a(false, paramLong, null, paramaqtp, 0);
  }
  
  aqto(aqtj paramaqtj, aqtp paramaqtp)
  {
    a(false, 0L, null, paramaqtp, 0);
  }
  
  aqto(aqtj paramaqtj, String paramString)
  {
    a(false, 0L, paramString, null, 0);
  }
  
  aqto(aqtj paramaqtj, boolean paramBoolean, long paramLong)
  {
    a(paramBoolean, paramLong, null, null, 0);
  }
  
  aqto(aqtj paramaqtj, boolean paramBoolean, long paramLong, aqtp paramaqtp, int paramInt)
  {
    a(paramBoolean, paramLong, null, paramaqtp, paramInt);
  }
  
  aqto(aqtj paramaqtj, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, aqtp paramaqtp)
  {
    a(false, 0L, null, paramaqtp, 0);
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte1;
    this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte2;
    this.c = paramArrayOfByte3;
  }
  
  private void a(boolean paramBoolean, long paramLong, String paramString, aqtp paramaqtp, int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Aqtp = paramaqtp;
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
  
  aqtp a()
  {
    return this.jdField_a_of_type_Aqtp;
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
 * Qualified Name:     aqto
 * JD-Core Version:    0.7.0.1
 */