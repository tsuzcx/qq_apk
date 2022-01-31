public class bgtz
  extends bggz
{
  public final bggy a;
  private String d;
  
  public bgtz(bgty parambgty, int paramInt, String paramString)
  {
    this.jdField_d_of_type_JavaLangString = "noreason";
    this.jdField_a_of_type_JavaLangString = "com.tencent.mobileqq:tool";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = "qqreaderplugin.apk";
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_JavaLangString = "qqreaderplugin.apk";
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_Bggy = new bggy(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_Bggy.a = new aqyd(paramString, "com.tencent.mobileqq:tool", "qqreaderplugin.apk");
  }
  
  protected void a()
  {
    this.jdField_d_of_type_JavaLangString = "preload:ok:common";
    bgty.a(this.jdField_a_of_type_Bgty, this.jdField_a_of_type_Bggy, this.jdField_d_of_type_JavaLangString, this.jdField_d_of_type_Int);
  }
  
  protected boolean a(bghf parambghf)
  {
    boolean bool = bgty.a(this.jdField_a_of_type_Bgty);
    if (bool) {}
    for (String str = "preload:ok:dpc";; str = "preload:fail:dpc")
    {
      this.jdField_d_of_type_JavaLangString = str;
      if (parambghf != null)
      {
        parambghf.jdField_a_of_type_Int = 2;
        parambghf.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      }
      return bool;
    }
  }
  
  protected boolean b(bghf parambghf)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgtz
 * JD-Core Version:    0.7.0.1
 */