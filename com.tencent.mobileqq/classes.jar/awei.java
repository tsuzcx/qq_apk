import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.onlinestatus.AutoReplyEditActivity;
import com.tencent.mobileqq.widget.QQToast;

public class awei
  implements TextWatcher
{
  private int jdField_a_of_type_Int;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private int b;
  
  public awei(AutoReplyEditActivity paramAutoReplyEditActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((this.jdField_a_of_type_JavaLangCharSequence != null) && (banh.a(String.valueOf(this.jdField_a_of_type_JavaLangCharSequence), 3) > 100))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoReplyEditActivity.getActivity(), 1, 2131690363, 0).a();
      paramEditable.delete(this.jdField_a_of_type_Int, this.b);
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoReplyEditActivity.rightViewText.setEnabled(AutoReplyEditActivity.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoReplyEditActivity, String.valueOf(AutoReplyEditActivity.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAutoReplyEditActivity).getText())));
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = (paramInt1 + paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awei
 * JD-Core Version:    0.7.0.1
 */