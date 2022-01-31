public class bdfv
  implements bdft<String>
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public static bdfv a(String paramString1, String paramString2, int paramInt)
  {
    bdfv localbdfv = new bdfv();
    localbdfv.jdField_a_of_type_JavaLangString = paramString1;
    localbdfv.b = paramString2;
    localbdfv.jdField_a_of_type_Int = paramInt;
    return localbdfv;
  }
  
  public String a(bdcw parambdcw)
  {
    bdnw.a("RuntimeMessage", "SubscribeEvent " + "eventName = " + this.jdField_a_of_type_JavaLangString + "sourceWebViewId = " + this.jdField_a_of_type_Int);
    parambdcw = parambdcw.a();
    if (parambdcw != null) {
      parambdcw.a(this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdfv
 * JD-Core Version:    0.7.0.1
 */