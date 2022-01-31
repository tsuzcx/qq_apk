public class bekn
  implements bekl<String>
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public static bekn a(String paramString1, String paramString2, int paramInt)
  {
    bekn localbekn = new bekn();
    localbekn.jdField_a_of_type_JavaLangString = paramString1;
    localbekn.b = paramString2;
    localbekn.jdField_a_of_type_Int = paramInt;
    return localbekn;
  }
  
  public String a(behn parambehn)
  {
    betc.a("RuntimeMessage", "SubscribeEvent " + "eventName = " + this.jdField_a_of_type_JavaLangString + "sourceWebViewId = " + this.jdField_a_of_type_Int);
    parambehn = parambehn.a();
    if (parambehn != null) {
      parambehn.a(this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bekn
 * JD-Core Version:    0.7.0.1
 */