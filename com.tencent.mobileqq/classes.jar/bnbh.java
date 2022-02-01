public class bnbh
{
  public int a;
  private bnbi jdField_a_of_type_Bnbi;
  private bnbl jdField_a_of_type_Bnbl;
  public int b;
  public int c;
  
  public bnbh(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public bnbi a()
  {
    return this.jdField_a_of_type_Bnbi;
  }
  
  public bnbl a()
  {
    return this.jdField_a_of_type_Bnbl;
  }
  
  public void a(bnbi parambnbi)
  {
    this.jdField_a_of_type_Bnbi = parambnbi;
    if (this.jdField_a_of_type_Bnbi.a() != null) {
      this.b = this.jdField_a_of_type_Bnbi.b();
    }
  }
  
  public void a(bnbl parambnbl)
  {
    this.jdField_a_of_type_Bnbl = parambnbl;
  }
  
  public int b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnbh
 * JD-Core Version:    0.7.0.1
 */