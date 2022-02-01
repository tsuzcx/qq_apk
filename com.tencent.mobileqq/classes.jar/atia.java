public class atia
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private atib jdField_a_of_type_Atib;
  private Object jdField_a_of_type_JavaLangObject;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private byte[] c;
  
  atia(atht paramatht)
  {
    a(false, 0L, null, null, 0);
  }
  
  atia(atht paramatht, long paramLong, atib paramatib)
  {
    a(false, paramLong, null, paramatib, 0);
  }
  
  atia(atht paramatht, atib paramatib)
  {
    a(false, 0L, null, paramatib, 0);
  }
  
  atia(atht paramatht, String paramString)
  {
    a(false, 0L, paramString, null, 0);
  }
  
  atia(atht paramatht, boolean paramBoolean, long paramLong)
  {
    a(paramBoolean, paramLong, null, null, 0);
  }
  
  atia(atht paramatht, boolean paramBoolean, long paramLong, atib paramatib, int paramInt)
  {
    a(paramBoolean, paramLong, null, paramatib, paramInt);
  }
  
  atia(atht paramatht, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, atib paramatib)
  {
    a(false, 0L, null, paramatib, 0);
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte1;
    this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte2;
    this.c = paramArrayOfByte3;
  }
  
  private void a(boolean paramBoolean, long paramLong, String paramString, atib paramatib, int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Atib = paramatib;
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
  
  atib a()
  {
    return this.jdField_a_of_type_Atib;
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
 * Qualified Name:     atia
 * JD-Core Version:    0.7.0.1
 */