import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

class aury
  implements TextWatcher
{
  aury(aurs paramaurs, int paramInt) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((aurs.a(this.jdField_a_of_type_Aurs).getText().length() == this.jdField_a_of_type_Int) && (paramCharSequence.charAt(this.jdField_a_of_type_Int - 1) == '\024'))
    {
      aurs.a(this.jdField_a_of_type_Aurs).setText(paramCharSequence.subSequence(0, this.jdField_a_of_type_Int - 1));
      aurs.a(this.jdField_a_of_type_Aurs).setSelection(this.jdField_a_of_type_Int - 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aury
 * JD-Core Version:    0.7.0.1
 */