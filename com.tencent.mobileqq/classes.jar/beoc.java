import android.text.Editable;
import android.text.TextWatcher;

public class beoc
  implements TextWatcher
{
  private int jdField_a_of_type_Int;
  private beod jdField_a_of_type_Beod;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  
  private void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
  }
  
  public void a(beod parambeod)
  {
    this.jdField_a_of_type_Beod = parambeod;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.jdField_a_of_type_Beod == null) {
      return;
    }
    if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean)) {
      this.jdField_c_of_type_Boolean = true;
    }
    paramEditable = paramEditable.toString();
    String str1;
    if (this.jdField_a_of_type_Boolean)
    {
      str1 = this.jdField_b_of_type_JavaLangString.substring(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + this.jdField_b_of_type_Int);
      this.jdField_a_of_type_Beod.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, str1, this.jdField_a_of_type_JavaLangString, paramEditable);
    }
    for (;;)
    {
      a();
      return;
      if (this.jdField_b_of_type_Boolean)
      {
        str1 = this.jdField_a_of_type_JavaLangString.substring(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + this.jdField_c_of_type_Int);
        this.jdField_a_of_type_Beod.b(this.jdField_a_of_type_Int, this.jdField_c_of_type_Int, str1, this.jdField_a_of_type_JavaLangString, paramEditable);
      }
      else if (this.jdField_c_of_type_Boolean)
      {
        str1 = this.jdField_a_of_type_JavaLangString.substring(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + this.jdField_c_of_type_Int);
        String str2 = this.jdField_a_of_type_JavaLangString.substring(0, this.jdField_a_of_type_Int) + this.jdField_a_of_type_JavaLangString.substring(this.jdField_a_of_type_Int + this.jdField_c_of_type_Int);
        String str3 = this.jdField_b_of_type_JavaLangString.substring(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + this.jdField_b_of_type_Int);
        this.jdField_a_of_type_Beod.b(this.jdField_a_of_type_Int, this.jdField_c_of_type_Int, str1, this.jdField_a_of_type_JavaLangString, str2);
        this.jdField_a_of_type_Beod.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, str3, this.jdField_a_of_type_JavaLangString, paramEditable);
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangString = paramCharSequence.toString();
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt3;
    if (paramInt2 == 0) {
      this.jdField_a_of_type_Boolean = true;
    }
    if (paramInt3 == 0) {
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_JavaLangString = paramCharSequence.toString();
    this.jdField_c_of_type_Int = paramInt2;
    if (paramInt2 == 0) {
      this.jdField_a_of_type_Boolean = true;
    }
    if (paramInt3 == 0) {
      this.jdField_b_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beoc
 * JD-Core Version:    0.7.0.1
 */