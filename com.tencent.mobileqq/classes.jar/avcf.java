import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.forward.ForwardSendHongBaoOption;

public class avcf
  implements DialogInterface.OnClickListener
{
  public avcf(ForwardSendHongBaoOption paramForwardSendHongBaoOption, bhpc parambhpc) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Bhpc.dismiss();
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardSendHongBaoOption.a.setResult(-1);
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardSendHongBaoOption.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avcf
 * JD-Core Version:    0.7.0.1
 */