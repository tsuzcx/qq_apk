import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.tencent.mobileqq.fragment.MsgBackupSettingFragment;

public class apoi
  implements TextWatcher
{
  public apoi(MsgBackupSettingFragment paramMsgBackupSettingFragment, TextView paramTextView1, TextView paramTextView2) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(MsgBackupSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentMsgBackupSettingFragment), new Object[] { paramEditable }));
    this.b.setText(String.format(MsgBackupSettingFragment.b(this.jdField_a_of_type_ComTencentMobileqqFragmentMsgBackupSettingFragment), new Object[] { paramEditable }));
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apoi
 * JD-Core Version:    0.7.0.1
 */