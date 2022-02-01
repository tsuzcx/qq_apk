public class bose
{
  public int a;
  long jdField_a_of_type_Long;
  volatile boolean jdField_a_of_type_Boolean = false;
  int[] jdField_a_of_type_ArrayOfInt;
  public long[] a;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long;
  int[] jdField_b_of_type_ArrayOfInt;
  int c;
  
  public bose()
  {
    this.jdField_a_of_type_ArrayOfLong = new long[4];
  }
  
  public bose(int paramInt)
  {
    this.jdField_a_of_type_ArrayOfLong = new long[4];
    this.jdField_a_of_type_ArrayOfLong = new long[paramInt];
  }
  
  public void a()
  {
    int i = 0;
    this.jdField_b_of_type_Int = 0;
    this.c = 0;
    while (i < this.jdField_a_of_type_ArrayOfLong.length)
    {
      this.jdField_a_of_type_ArrayOfLong[i] = 0L;
      i += 1;
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ArrayOfLong[paramInt] == 0L)) {
      this.jdField_a_of_type_ArrayOfLong[paramInt] = paramLong;
    }
  }
  
  public void a(Integer... paramVarArgs)
  {
    if ((paramVarArgs == null) || (this.jdField_b_of_type_Int >= 400)) {
      return;
    }
    if (paramVarArgs.length == 1)
    {
      if (this.jdField_a_of_type_ArrayOfInt == null) {
        this.jdField_a_of_type_ArrayOfInt = new int[400];
      }
      this.jdField_a_of_type_ArrayOfInt[this.jdField_b_of_type_Int] = paramVarArgs[0].intValue();
    }
    for (;;)
    {
      this.jdField_b_of_type_Int += 1;
      return;
      if (paramVarArgs.length == 2)
      {
        if (this.jdField_a_of_type_ArrayOfInt == null) {
          this.jdField_a_of_type_ArrayOfInt = new int[400];
        }
        if (this.jdField_b_of_type_ArrayOfInt == null) {
          this.jdField_b_of_type_ArrayOfInt = new int[400];
        }
        this.jdField_a_of_type_ArrayOfInt[this.jdField_b_of_type_Int] = paramVarArgs[0].intValue();
        this.jdField_b_of_type_ArrayOfInt[this.jdField_b_of_type_Int] = paramVarArgs[1].intValue();
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt)
  {
    return System.currentTimeMillis() - this.jdField_a_of_type_Long >= paramInt;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    a();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bose
 * JD-Core Version:    0.7.0.1
 */