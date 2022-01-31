public class biuy
  extends bihx
{
  public final bihw a;
  private String d;
  
  public biuy(biux parambiux, int paramInt, String paramString)
  {
    this.jdField_d_of_type_JavaLangString = "noreason";
    this.jdField_a_of_type_JavaLangString = "com.tencent.mobileqq:tool";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = "qqreaderplugin.apk";
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_JavaLangString = "qqreaderplugin.apk";
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_Bihw = new bihw(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_Bihw.a = new asor(paramString, "com.tencent.mobileqq:tool", "qqreaderplugin.apk");
  }
  
  protected void a()
  {
    this.jdField_d_of_type_JavaLangString = "preload:ok:common";
    biux.a(this.jdField_a_of_type_Biux, this.jdField_a_of_type_Bihw, this.jdField_d_of_type_JavaLangString, this.jdField_d_of_type_Int);
  }
  
  protected boolean a(biid parambiid)
  {
    boolean bool = biux.a(this.jdField_a_of_type_Biux);
    if (bool) {}
    for (String str = "preload:ok:dpc";; str = "preload:fail:dpc")
    {
      this.jdField_d_of_type_JavaLangString = str;
      if (parambiid != null)
      {
        parambiid.jdField_a_of_type_Int = 2;
        parambiid.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      }
      return bool;
    }
  }
  
  protected boolean b(biid parambiid)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biuy
 * JD-Core Version:    0.7.0.1
 */