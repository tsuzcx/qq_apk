public class bhyu
{
  public int a;
  private bhyv jdField_a_of_type_Bhyv;
  private bhyy jdField_a_of_type_Bhyy;
  public String a;
  public int b = 100;
  public int c = 2;
  private int d;
  
  public bhyu(int paramInt1, int paramInt2, int paramInt3)
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
  
  public bhyv a()
  {
    return this.jdField_a_of_type_Bhyv;
  }
  
  public bhyy a()
  {
    return this.jdField_a_of_type_Bhyy;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(bhyv parambhyv)
  {
    this.jdField_a_of_type_Bhyv = parambhyv;
    if (parambhyv.a() != null) {
      this.b = parambhyv.b();
    }
  }
  
  public void a(bhyy parambhyy)
  {
    this.jdField_a_of_type_Bhyy = parambhyy;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public int c()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhyu
 * JD-Core Version:    0.7.0.1
 */