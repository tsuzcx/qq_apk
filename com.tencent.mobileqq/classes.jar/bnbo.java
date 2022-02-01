public class bnbo
  extends bojn
{
  public int a;
  private boolean jdField_a_of_type_Boolean;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[2];
  private int jdField_b_of_type_Int = 1;
  private String[] jdField_b_of_type_ArrayOfJavaLangString = new String[2];
  private int c;
  
  public bnbo()
  {
    this.jdField_a_of_type_Int = 2;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString[this.c] = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt == 1) || ((this.jdField_b_of_type_Int & paramInt) != 0);
  }
  
  public String[] a()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_ArrayOfJavaLangString[this.c] = paramString;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Int == 14;
  }
  
  public String[] b()
  {
    return this.jdField_b_of_type_ArrayOfJavaLangString;
  }
  
  public void c(int paramInt)
  {
    if ((paramInt > -1) && (paramInt < 2)) {
      this.c = paramInt;
    }
  }
  
  public void d(int paramInt)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString[paramInt] = null;
    this.jdField_b_of_type_ArrayOfJavaLangString[paramInt] = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnbo
 * JD-Core Version:    0.7.0.1
 */