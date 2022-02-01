import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.forward.ForwardFileOption;

public class atmb
  implements TextWatcher
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  
  public atmb(ForwardFileOption paramForwardFileOption) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangString = paramCharSequence.toString();
    this.jdField_a_of_type_Int = paramInt1;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence.toString().length() > 36)
    {
      ForwardFileOption.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardFileOption, -4);
      if ((paramInt3 > 0) && (paramInt2 < paramInt3))
      {
        paramInt1 = this.jdField_a_of_type_Int;
        if (!this.jdField_a_of_type_JavaLangString.equals(""))
        {
          ForwardFileOption.b(this.jdField_a_of_type_ComTencentMobileqqForwardForwardFileOption).setText(this.jdField_a_of_type_JavaLangString);
          ForwardFileOption.b(this.jdField_a_of_type_ComTencentMobileqqForwardForwardFileOption).setSelection(paramInt1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atmb
 * JD-Core Version:    0.7.0.1
 */