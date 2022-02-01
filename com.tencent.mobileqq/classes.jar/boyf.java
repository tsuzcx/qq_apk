public class boyf
{
  public int a;
  private boyg jdField_a_of_type_Boyg;
  private boyj jdField_a_of_type_Boyj;
  public int b = 100;
  public int c = 2;
  private int d;
  
  public boyf(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = 10000;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public boyg a()
  {
    return this.jdField_a_of_type_Boyg;
  }
  
  public boyj a()
  {
    return this.jdField_a_of_type_Boyj;
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(boyg paramboyg)
  {
    this.jdField_a_of_type_Boyg = paramboyg;
    if (paramboyg.a() != null) {
      this.b = paramboyg.b();
    }
  }
  
  public void a(boyj paramboyj)
  {
    this.jdField_a_of_type_Boyj = paramboyj;
  }
  
  public int b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boyf
 * JD-Core Version:    0.7.0.1
 */