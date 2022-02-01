import android.widget.EditText;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.forward.ForwardFileOption;

public class auyz
  implements PopupWindow.OnDismissListener
{
  public auyz(ForwardFileOption paramForwardFileOption, EditText paramEditText) {}
  
  public void onDismiss()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqForwardForwardFileOption.l) {
      ForwardFileOption.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardFileOption, -8);
    }
    if (this.jdField_a_of_type_AndroidWidgetEditText != null)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
      this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auyz
 * JD-Core Version:    0.7.0.1
 */