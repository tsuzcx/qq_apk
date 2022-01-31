class aqpf
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private aqpg jdField_a_of_type_Aqpg;
  private Object jdField_a_of_type_JavaLangObject;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private byte[] c;
  
  aqpf(aqpa paramaqpa)
  {
    a(false, 0L, null, null, 0);
  }
  
  aqpf(aqpa paramaqpa, long paramLong, aqpg paramaqpg)
  {
    a(false, paramLong, null, paramaqpg, 0);
  }
  
  aqpf(aqpa paramaqpa, aqpg paramaqpg)
  {
    a(false, 0L, null, paramaqpg, 0);
  }
  
  aqpf(aqpa paramaqpa, String paramString)
  {
    a(false, 0L, paramString, null, 0);
  }
  
  aqpf(aqpa paramaqpa, boolean paramBoolean, long paramLong)
  {
    a(paramBoolean, paramLong, null, null, 0);
  }
  
  aqpf(aqpa paramaqpa, boolean paramBoolean, long paramLong, aqpg paramaqpg, int paramInt)
  {
    a(paramBoolean, paramLong, null, paramaqpg, paramInt);
  }
  
  aqpf(aqpa paramaqpa, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, aqpg paramaqpg)
  {
    a(false, 0L, null, paramaqpg, 0);
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte1;
    this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte2;
    this.c = paramArrayOfByte3;
  }
  
  private void a(boolean paramBoolean, long paramLong, String paramString, aqpg paramaqpg, int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Aqpg = paramaqpg;
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
  
  aqpg a()
  {
    return this.jdField_a_of_type_Aqpg;
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
 * Qualified Name:     aqpf
 * JD-Core Version:    0.7.0.1
 */