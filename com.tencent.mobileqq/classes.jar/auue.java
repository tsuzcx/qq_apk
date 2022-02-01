import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.forward.ForwardSendHongBaoOption;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class auue
  implements DialogInterface.OnClickListener
{
  public auue(ForwardSendHongBaoOption paramForwardSendHongBaoOption, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardSendHongBaoOption.a.setResult(-1);
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardSendHongBaoOption.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auue
 * JD-Core Version:    0.7.0.1
 */