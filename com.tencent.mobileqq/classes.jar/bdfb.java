public class bdfb
  extends bdes
{
  private bdes jdField_a_of_type_Bdes;
  private int[] jdField_a_of_type_ArrayOfInt;
  private bdes[] jdField_a_of_type_ArrayOfBdes;
  private int f;
  
  public bdfb(bdes... paramVarArgs)
  {
    super(0, 0, 0);
    this.jdField_a_of_type_ArrayOfBdes = paramVarArgs;
    this.jdField_a_of_type_ArrayOfInt = new int[paramVarArgs.length];
    int i = 0;
    int j = 0;
    if (i < paramVarArgs.length)
    {
      if (i == 0) {
        this.jdField_a_of_type_ArrayOfInt[i] = 0;
      }
      for (;;)
      {
        j += paramVarArgs[i].jdField_c_of_type_Int;
        i += 1;
        break;
        this.jdField_a_of_type_ArrayOfInt[i] = j;
      }
    }
    this.jdField_c_of_type_Int = j;
    if (paramVarArgs.length > 0) {
      this.jdField_a_of_type_Bdes = paramVarArgs[this.f];
    }
  }
  
  public void a()
  {
    super.a();
    this.f = 0;
    if (this.jdField_a_of_type_ArrayOfBdes.length > 0) {
      this.jdField_a_of_type_Bdes = this.jdField_a_of_type_ArrayOfBdes[this.f];
    }
  }
  
  protected void a(int paramInt, float paramFloat)
  {
    if ((this.f + 1 < this.jdField_a_of_type_ArrayOfBdes.length) && (paramInt > this.jdField_a_of_type_ArrayOfInt[(this.f + 1)]))
    {
      this.jdField_a_of_type_Bdes.b();
      bdes[] arrayOfbdes = this.jdField_a_of_type_ArrayOfBdes;
      i = this.f + 1;
      this.f = i;
      this.jdField_a_of_type_Bdes = arrayOfbdes[i];
    }
    this.d = this.jdField_a_of_type_Bdes.d;
    int i = paramInt - this.jdField_a_of_type_ArrayOfInt[this.f];
    float f1 = i / this.jdField_a_of_type_Bdes.jdField_c_of_type_Int;
    if (this.jdField_a_of_type_Bdes.e == 1) {
      f1 = i * i / (this.jdField_a_of_type_Bdes.jdField_c_of_type_Int * this.jdField_a_of_type_Bdes.jdField_c_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bdes.a(i, f1);
      if ((this.jdField_a_of_type_Bdes.d & 0x1) != 0)
      {
        this.jdField_a_of_type_Float = this.jdField_a_of_type_Bdes.jdField_a_of_type_Float;
        this.jdField_b_of_type_Float = this.jdField_a_of_type_Bdes.jdField_b_of_type_Float;
      }
      if ((this.jdField_a_of_type_Bdes.d & 0x10) != 0) {
        this.jdField_b_of_type_Float = this.jdField_a_of_type_Bdes.jdField_b_of_type_Float;
      }
      if ((this.jdField_a_of_type_Bdes.d & 0x2) != 0) {
        this.jdField_c_of_type_Float = this.jdField_a_of_type_Bdes.jdField_c_of_type_Float;
      }
      if ((this.jdField_a_of_type_Bdes.d & 0x4) != 0) {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_Bdes.jdField_a_of_type_Int;
      }
      if ((this.jdField_a_of_type_Bdes.d & 0x8) != 0) {
        this.jdField_b_of_type_Int = this.jdField_a_of_type_Bdes.jdField_b_of_type_Int;
      }
      super.a(paramInt, paramFloat);
      return;
      if (this.jdField_a_of_type_Bdes.e == 2)
      {
        f1 = i / this.jdField_a_of_type_Bdes.jdField_c_of_type_Int;
        f1 *= (2.0F - f1);
      }
    }
  }
  
  public void d()
  {
    super.d();
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfBdes.length)
    {
      this.jdField_a_of_type_ArrayOfInt[i] = ((int)(System.currentTimeMillis() - this.jdField_b_of_type_Long));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdfb
 * JD-Core Version:    0.7.0.1
 */