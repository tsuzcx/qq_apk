public class aqss
{
  @avnm(a="isStatusBarWhite")
  public int a;
  @avnm(a="bkgURL")
  public String a;
  @avnm(a="isNavBarWhite")
  public int b;
  @avnm(a="logoColor")
  public String b;
  @avnm(a="needShowLogo")
  public int c = 1;
  
  public aqss()
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
 * Qualified Name:     aqss
 * JD-Core Version:    0.7.0.1
 */