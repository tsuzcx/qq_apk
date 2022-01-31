public class bejs
  extends beka
  implements beju<String>
{
  public int a;
  private begy b;
  
  public bejs()
  {
    this.jdField_a_of_type_Int = 2;
  }
  
  public static bejs a(beka parambeka, int paramInt)
  {
    bejs localbejs = new bejs();
    localbejs.jdField_a_of_type_JavaLangString = parambeka.jdField_a_of_type_JavaLangString;
    localbejs.jdField_b_of_type_JavaLangString = parambeka.jdField_b_of_type_JavaLangString;
    localbejs.jdField_a_of_type_Begy = parambeka.jdField_a_of_type_Begy;
    localbejs.jdField_b_of_type_Int = parambeka.jdField_b_of_type_Int;
    localbejs.jdField_a_of_type_Int = paramInt;
    return localbejs;
  }
  
  public String a(begw parambegw)
  {
    besl.a("RuntimeMessage", "sendNativeViewEvent " + "eventName = " + this.jdField_a_of_type_JavaLangString + " " + "jsService = " + this.jdField_a_of_type_Begy + " " + "callbackId = " + this.jdField_b_of_type_Int + " " + "target = " + this.jdField_a_of_type_Int);
    this.jdField_b_of_type_Begy = parambegw.a();
    return parambegw.a().a(this);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (this.jdField_b_of_type_Begy != null) {
      this.jdField_b_of_type_Begy.a(paramString1, paramString2, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bejs
 * JD-Core Version:    0.7.0.1
 */