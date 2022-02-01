import android.text.TextUtils;

public class anmt
{
  int jdField_a_of_type_Int;
  private annd jdField_a_of_type_Annd;
  private anne jdField_a_of_type_Anne;
  private anng jdField_a_of_type_Anng;
  String jdField_a_of_type_JavaLangString;
  int b = 30000;
  
  public anmr a()
  {
    if (this.jdField_a_of_type_Anng == null) {
      this.jdField_a_of_type_Anng = new annc();
    }
    if (this.jdField_a_of_type_Anne == null) {
      this.jdField_a_of_type_Anne = new annb();
    }
    if (this.jdField_a_of_type_Annd == null) {
      this.jdField_a_of_type_Annd = new anmp();
    }
    if (this.jdField_a_of_type_Int == 0) {
      throw new IllegalArgumentException("appId required.");
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      throw new IllegalArgumentException("current account uid is required.");
    }
    return new anmr(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Anng, this.jdField_a_of_type_Anne, this.jdField_a_of_type_Annd, null);
  }
  
  public anmt a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public anmt a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anmt
 * JD-Core Version:    0.7.0.1
 */