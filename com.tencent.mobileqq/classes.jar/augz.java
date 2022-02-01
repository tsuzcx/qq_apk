import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.forward.ForwardFileOption;

public class augz
  implements TextWatcher
{
  public augz(ForwardFileOption paramForwardFileOption, EditText paramEditText) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence.toString().trim().length() > 36)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramCharSequence.toString().substring(0, 36));
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(36);
      ForwardFileOption.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardFileOption, -4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     augz
 * JD-Core Version:    0.7.0.1
 */