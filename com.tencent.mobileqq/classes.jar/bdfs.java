public class bdfs
  extends bdfz
  implements bdft<String>
{
  public int a;
  private bdcy b;
  
  public bdfs()
  {
    this.jdField_a_of_type_Int = 2;
  }
  
  public static bdfs a(bdfz parambdfz, int paramInt)
  {
    bdfs localbdfs = new bdfs();
    localbdfs.jdField_a_of_type_JavaLangString = parambdfz.jdField_a_of_type_JavaLangString;
    localbdfs.jdField_b_of_type_JavaLangString = parambdfz.jdField_b_of_type_JavaLangString;
    localbdfs.jdField_a_of_type_Bdcy = parambdfz.jdField_a_of_type_Bdcy;
    localbdfs.jdField_b_of_type_Int = parambdfz.jdField_b_of_type_Int;
    localbdfs.jdField_a_of_type_Int = paramInt;
    return localbdfs;
  }
  
  public String a(bdcw parambdcw)
  {
    bdnw.a("RuntimeMessage", "sendNativeViewEvent " + "eventName = " + this.jdField_a_of_type_JavaLangString + " " + "jsService = " + this.jdField_a_of_type_Bdcy + " " + "callbackId = " + this.jdField_b_of_type_Int + " " + "target = " + this.jdField_a_of_type_Int);
    this.jdField_b_of_type_Bdcy = parambdcw.a();
    return parambdcw.a().a(this);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (this.jdField_b_of_type_Bdcy != null) {
      this.jdField_b_of_type_Bdcy.a(paramString1, paramString2, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdfs
 * JD-Core Version:    0.7.0.1
 */