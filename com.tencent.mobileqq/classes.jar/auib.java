import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

class auib
  implements TextWatcher
{
  auib(auhv paramauhv, int paramInt) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((auhv.a(this.jdField_a_of_type_Auhv).getText().length() == this.jdField_a_of_type_Int) && (paramCharSequence.charAt(this.jdField_a_of_type_Int - 1) == '\024'))
    {
      auhv.a(this.jdField_a_of_type_Auhv).setText(paramCharSequence.subSequence(0, this.jdField_a_of_type_Int - 1));
      auhv.a(this.jdField_a_of_type_Auhv).setSelection(this.jdField_a_of_type_Int - 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auib
 * JD-Core Version:    0.7.0.1
 */