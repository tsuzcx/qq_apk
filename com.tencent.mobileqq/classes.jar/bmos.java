public class bmos
  extends bmau
{
  public final bmat a;
  private String d;
  
  public bmos(bmor parambmor, int paramInt, String paramString)
  {
    this.jdField_d_of_type_JavaLangString = "noreason";
    this.jdField_a_of_type_JavaLangString = "com.tencent.mobileqq:tool";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = "qqreaderplugin.apk";
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_JavaLangString = "qqreaderplugin.apk";
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_Bmat = new bmat(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_Bmat.a = new avsk(paramString, "com.tencent.mobileqq:tool", "qqreaderplugin.apk");
  }
  
  protected void a()
  {
    this.jdField_d_of_type_JavaLangString = "preload:ok:common";
    bmor.a(this.jdField_a_of_type_Bmor, this.jdField_a_of_type_Bmat, this.jdField_d_of_type_JavaLangString, this.jdField_d_of_type_Int);
  }
  
  protected boolean a(bmba parambmba)
  {
    boolean bool = bmor.a(this.jdField_a_of_type_Bmor);
    if (bool) {}
    for (String str = "preload:ok:dpc";; str = "preload:fail:dpc")
    {
      this.jdField_d_of_type_JavaLangString = str;
      if (parambmba != null)
      {
        parambmba.jdField_a_of_type_Int = 2;
        parambmba.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      }
      return bool;
    }
  }
  
  protected boolean b(bmba parambmba)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmos
 * JD-Core Version:    0.7.0.1
 */