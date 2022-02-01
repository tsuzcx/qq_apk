public class asdu
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private asdv jdField_a_of_type_Asdv;
  private Object jdField_a_of_type_JavaLangObject;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private byte[] c;
  
  asdu(asdm paramasdm)
  {
    a(false, 0L, null, null, 0);
  }
  
  asdu(asdm paramasdm, long paramLong, asdv paramasdv)
  {
    a(false, paramLong, null, paramasdv, 0);
  }
  
  asdu(asdm paramasdm, asdv paramasdv)
  {
    a(false, 0L, null, paramasdv, 0);
  }
  
  asdu(asdm paramasdm, String paramString)
  {
    a(false, 0L, paramString, null, 0);
  }
  
  asdu(asdm paramasdm, boolean paramBoolean, long paramLong)
  {
    a(paramBoolean, paramLong, null, null, 0);
  }
  
  asdu(asdm paramasdm, boolean paramBoolean, long paramLong, asdv paramasdv, int paramInt)
  {
    a(paramBoolean, paramLong, null, paramasdv, paramInt);
  }
  
  asdu(asdm paramasdm, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, asdv paramasdv)
  {
    a(false, 0L, null, paramasdv, 0);
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte1;
    this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte2;
    this.c = paramArrayOfByte3;
  }
  
  private void a(boolean paramBoolean, long paramLong, String paramString, asdv paramasdv, int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Asdv = paramasdv;
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
  
  asdv a()
  {
    return this.jdField_a_of_type_Asdv;
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
 * Qualified Name:     asdu
 * JD-Core Version:    0.7.0.1
 */