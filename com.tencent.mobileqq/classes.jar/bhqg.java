import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

class bhqg
  implements TextWatcher
{
  bhqg(bhpy parambhpy, int paramInt) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_Bhpy.a.getText().length() == this.jdField_a_of_type_Int) && (paramCharSequence.charAt(this.jdField_a_of_type_Int - 1) == '\024'))
    {
      this.jdField_a_of_type_Bhpy.a.setText(paramCharSequence.subSequence(0, this.jdField_a_of_type_Int - 1));
      this.jdField_a_of_type_Bhpy.a.setSelection(this.jdField_a_of_type_Int - 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhqg
 * JD-Core Version:    0.7.0.1
 */