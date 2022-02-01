import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

class auzz
  implements TextWatcher
{
  auzz(auzt paramauzt, int paramInt) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((auzt.a(this.jdField_a_of_type_Auzt).getText().length() == this.jdField_a_of_type_Int) && (paramCharSequence.charAt(this.jdField_a_of_type_Int - 1) == '\024'))
    {
      auzt.a(this.jdField_a_of_type_Auzt).setText(paramCharSequence.subSequence(0, this.jdField_a_of_type_Int - 1));
      auzt.a(this.jdField_a_of_type_Auzt).setSelection(this.jdField_a_of_type_Int - 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auzz
 * JD-Core Version:    0.7.0.1
 */