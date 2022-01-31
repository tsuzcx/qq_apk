public class amkv
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  boolean jdField_a_of_type_Boolean;
  long b;
  long c;
  long d;
  
  public amkv(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean)
  {
    this.b = paramLong1;
    this.jdField_a_of_type_Long = paramLong2;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof amkv))
    {
      paramObject = (amkv)paramObject;
      bool1 = bool2;
      if (paramObject.jdField_a_of_type_Long == this.jdField_a_of_type_Long)
      {
        bool1 = bool2;
        if (paramObject.b == this.b) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amkv
 * JD-Core Version:    0.7.0.1
 */