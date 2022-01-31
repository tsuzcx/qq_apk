import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

class arwr
  implements TextWatcher
{
  arwr(arwl paramarwl, int paramInt) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((arwl.a(this.jdField_a_of_type_Arwl).getText().length() == this.jdField_a_of_type_Int) && (paramCharSequence.charAt(this.jdField_a_of_type_Int - 1) == '\024'))
    {
      arwl.a(this.jdField_a_of_type_Arwl).setText(paramCharSequence.subSequence(0, this.jdField_a_of_type_Int - 1));
      arwl.a(this.jdField_a_of_type_Arwl).setSelection(this.jdField_a_of_type_Int - 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arwr
 * JD-Core Version:    0.7.0.1
 */