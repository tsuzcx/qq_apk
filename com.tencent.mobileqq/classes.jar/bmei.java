public class bmei
  extends blqa
{
  public final blpz a;
  private String d;
  
  public bmei(bmeh parambmeh, int paramInt, String paramString)
  {
    this.jdField_d_of_type_JavaLangString = "noreason";
    this.jdField_a_of_type_JavaLangString = "com.tencent.mobileqq:tool";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = "qqreaderplugin.apk";
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_JavaLangString = "qqreaderplugin.apk";
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_Blpz = new blpz(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_Blpz.a = new avlg(paramString, "com.tencent.mobileqq:tool", "qqreaderplugin.apk");
  }
  
  protected void a()
  {
    this.jdField_d_of_type_JavaLangString = "preload:ok:common";
    bmeh.a(this.jdField_a_of_type_Bmeh, this.jdField_a_of_type_Blpz, this.jdField_d_of_type_JavaLangString, this.jdField_d_of_type_Int);
  }
  
  protected boolean a(blqg paramblqg)
  {
    boolean bool = bmeh.a(this.jdField_a_of_type_Bmeh);
    if (bool) {}
    for (String str = "preload:ok:dpc";; str = "preload:fail:dpc")
    {
      this.jdField_d_of_type_JavaLangString = str;
      if (paramblqg != null)
      {
        paramblqg.jdField_a_of_type_Int = 2;
        paramblqg.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      }
      return bool;
    }
  }
  
  protected boolean b(blqg paramblqg)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmei
 * JD-Core Version:    0.7.0.1
 */