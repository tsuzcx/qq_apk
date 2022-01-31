import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.triton.sdk.callback.DialogCallback;

class bdpn
  implements DialogInterface.OnClickListener
{
  bdpn(bdpl parambdpl, DialogCallback paramDialogCallback) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkCallbackDialogCallback.onConfirm();
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdpn
 * JD-Core Version:    0.7.0.1
 */