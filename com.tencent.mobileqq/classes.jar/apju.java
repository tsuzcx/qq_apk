import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

class apju
  implements TextWatcher
{
  apju(apjo paramapjo, int paramInt) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((apjo.a(this.jdField_a_of_type_Apjo).getText().length() == this.jdField_a_of_type_Int) && (paramCharSequence.charAt(this.jdField_a_of_type_Int - 1) == '\024'))
    {
      apjo.a(this.jdField_a_of_type_Apjo).setText(paramCharSequence.subSequence(0, this.jdField_a_of_type_Int - 1));
      apjo.a(this.jdField_a_of_type_Apjo).setSelection(this.jdField_a_of_type_Int - 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apju
 * JD-Core Version:    0.7.0.1
 */