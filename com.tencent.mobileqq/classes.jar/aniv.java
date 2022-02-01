import android.text.TextUtils;

public class aniv
{
  int jdField_a_of_type_Int;
  private anjf jdField_a_of_type_Anjf;
  private anjg jdField_a_of_type_Anjg;
  private anji jdField_a_of_type_Anji;
  String jdField_a_of_type_JavaLangString;
  int b = 30000;
  
  public anit a()
  {
    if (this.jdField_a_of_type_Anji == null) {
      this.jdField_a_of_type_Anji = new anje();
    }
    if (this.jdField_a_of_type_Anjg == null) {
      this.jdField_a_of_type_Anjg = new anjd();
    }
    if (this.jdField_a_of_type_Anjf == null) {
      this.jdField_a_of_type_Anjf = new anir();
    }
    if (this.jdField_a_of_type_Int == 0) {
      throw new IllegalArgumentException("appId required.");
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      throw new IllegalArgumentException("current account uid is required.");
    }
    return new anit(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Anji, this.jdField_a_of_type_Anjg, this.jdField_a_of_type_Anjf, null);
  }
  
  public aniv a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public aniv a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aniv
 * JD-Core Version:    0.7.0.1
 */