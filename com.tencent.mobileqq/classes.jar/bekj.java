public class bekj
  extends bekr
  implements bekl<String>
{
  public int a;
  private behp b;
  
  public bekj()
  {
    this.jdField_a_of_type_Int = 2;
  }
  
  public static bekj a(bekr parambekr, int paramInt)
  {
    bekj localbekj = new bekj();
    localbekj.jdField_a_of_type_JavaLangString = parambekr.jdField_a_of_type_JavaLangString;
    localbekj.jdField_b_of_type_JavaLangString = parambekr.jdField_b_of_type_JavaLangString;
    localbekj.jdField_a_of_type_Behp = parambekr.jdField_a_of_type_Behp;
    localbekj.jdField_b_of_type_Int = parambekr.jdField_b_of_type_Int;
    localbekj.jdField_a_of_type_Int = paramInt;
    return localbekj;
  }
  
  public String a(behn parambehn)
  {
    betc.a("RuntimeMessage", "sendNativeViewEvent " + "eventName = " + this.jdField_a_of_type_JavaLangString + " " + "jsService = " + this.jdField_a_of_type_Behp + " " + "callbackId = " + this.jdField_b_of_type_Int + " " + "target = " + this.jdField_a_of_type_Int);
    this.jdField_b_of_type_Behp = parambehn.a();
    return parambehn.a().a(this);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (this.jdField_b_of_type_Behp != null) {
      this.jdField_b_of_type_Behp.a(paramString1, paramString2, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bekj
 * JD-Core Version:    0.7.0.1
 */