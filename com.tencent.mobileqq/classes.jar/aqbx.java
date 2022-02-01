public class aqbx
{
  @ausx(a="isStatusBarWhite")
  public int a;
  @ausx(a="bkgURL")
  public String a;
  @ausx(a="isNavBarWhite")
  public int b;
  @ausx(a="logoColor")
  public String b;
  @ausx(a="needShowLogo")
  public int c = 1;
  
  public aqbx()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Int == 1;
  }
  
  public boolean c()
  {
    return this.c == 1;
  }
  
  public String toString()
  {
    return "QrCodeList{bkgURL = " + this.jdField_a_of_type_JavaLangString + ", isStatusBarWhite = " + this.jdField_a_of_type_Int + ", isNavBarWhite = " + this.jdField_b_of_type_Int + ", logoColor = " + this.jdField_b_of_type_JavaLangString + ", needShowLogo = " + this.c + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqbx
 * JD-Core Version:    0.7.0.1
 */