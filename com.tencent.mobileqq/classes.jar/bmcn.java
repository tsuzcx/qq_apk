public class bmcn
{
  public int a;
  private bmco jdField_a_of_type_Bmco;
  private bmcr jdField_a_of_type_Bmcr;
  public int b = 100;
  public int c = 2;
  private int d;
  
  public bmcn(int paramInt1, int paramInt2, int paramInt3)
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
  
  public bmco a()
  {
    return this.jdField_a_of_type_Bmco;
  }
  
  public bmcr a()
  {
    return this.jdField_a_of_type_Bmcr;
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(bmco parambmco)
  {
    this.jdField_a_of_type_Bmco = parambmco;
    if (parambmco.a() != null) {
      this.b = parambmco.b();
    }
  }
  
  public void a(bmcr parambmcr)
  {
    this.jdField_a_of_type_Bmcr = parambmcr;
  }
  
  public int b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmcn
 * JD-Core Version:    0.7.0.1
 */