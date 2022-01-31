public class bejw
  implements beju<String>
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public static bejw a(String paramString1, String paramString2, int paramInt)
  {
    bejw localbejw = new bejw();
    localbejw.jdField_a_of_type_JavaLangString = paramString1;
    localbejw.b = paramString2;
    localbejw.jdField_a_of_type_Int = paramInt;
    return localbejw;
  }
  
  public String a(begw parambegw)
  {
    besl.a("RuntimeMessage", "SubscribeEvent " + "eventName = " + this.jdField_a_of_type_JavaLangString + "sourceWebViewId = " + this.jdField_a_of_type_Int);
    parambegw = parambegw.a();
    if (parambegw != null) {
      parambegw.a(this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bejw
 * JD-Core Version:    0.7.0.1
 */