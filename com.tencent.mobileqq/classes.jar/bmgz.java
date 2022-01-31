public class bmgz
{
  public int a;
  private bmha jdField_a_of_type_Bmha;
  private bmhd jdField_a_of_type_Bmhd;
  public int b = 100;
  public int c = 2;
  private int d;
  
  public bmgz(int paramInt1, int paramInt2, int paramInt3)
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
  
  public bmha a()
  {
    return this.jdField_a_of_type_Bmha;
  }
  
  public bmhd a()
  {
    return this.jdField_a_of_type_Bmhd;
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(bmha parambmha)
  {
    this.jdField_a_of_type_Bmha = parambmha;
    if (parambmha.a() != null) {
      this.b = parambmha.b();
    }
  }
  
  public void a(bmhd parambmhd)
  {
    this.jdField_a_of_type_Bmhd = parambmhd;
  }
  
  public int b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmgz
 * JD-Core Version:    0.7.0.1
 */