import android.text.TextUtils;

public class anaz
{
  int jdField_a_of_type_Int;
  private anbj jdField_a_of_type_Anbj;
  private anbk jdField_a_of_type_Anbk;
  private anbm jdField_a_of_type_Anbm;
  String jdField_a_of_type_JavaLangString;
  int b = 30000;
  
  public anax a()
  {
    if (this.jdField_a_of_type_Anbm == null) {
      this.jdField_a_of_type_Anbm = new anbi();
    }
    if (this.jdField_a_of_type_Anbk == null) {
      this.jdField_a_of_type_Anbk = new anbh();
    }
    if (this.jdField_a_of_type_Anbj == null) {
      this.jdField_a_of_type_Anbj = new anav();
    }
    if (this.jdField_a_of_type_Int == 0) {
      throw new IllegalArgumentException("appId required.");
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      throw new IllegalArgumentException("current account uid is required.");
    }
    return new anax(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Anbm, this.jdField_a_of_type_Anbk, this.jdField_a_of_type_Anbj, null);
  }
  
  public anaz a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public anaz a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anaz
 * JD-Core Version:    0.7.0.1
 */