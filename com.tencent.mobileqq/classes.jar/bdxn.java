public abstract class bdxn
{
  public float a;
  public int a;
  protected long a;
  private bdxo a;
  public boolean a;
  public float b;
  public int b;
  protected long b;
  public boolean b;
  public float c;
  public int c;
  public int d;
  public int e = 0;
  
  public bdxn(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_c_of_type_Float = 1.0F;
    this.jdField_a_of_type_Int = 255;
    this.jdField_c_of_type_Int = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  protected void a(int paramInt, float paramFloat)
  {
    if ((paramInt >= this.jdField_c_of_type_Int) && (this.jdField_a_of_type_Bdxo != null)) {
      this.jdField_a_of_type_Bdxo.a();
    }
  }
  
  public void a(bdxo parambdxo)
  {
    this.jdField_a_of_type_Bdxo = parambdxo;
  }
  
  public boolean a()
  {
    if (this.jdField_b_of_type_Boolean) {
      return false;
    }
    int i = (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long);
    float f = i / this.jdField_c_of_type_Int;
    if (this.e == 1) {
      f = i * i / (this.jdField_c_of_type_Int * this.jdField_c_of_type_Int);
    }
    for (;;)
    {
      a(i, f);
      if (i >= this.jdField_c_of_type_Int) {
        b();
      }
      return true;
      if (this.e == 2)
      {
        f = i / this.jdField_c_of_type_Int;
        f *= (2.0F - f);
      }
    }
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void c()
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Long += System.currentTimeMillis() - this.jdField_b_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdxn
 * JD-Core Version:    0.7.0.1
 */