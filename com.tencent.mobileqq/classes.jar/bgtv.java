import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.triton.sdk.callback.DialogCallback;

class bgtv
  implements DialogInterface.OnClickListener
{
  bgtv(bgtt parambgtt, DialogCallback paramDialogCallback) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkCallbackDialogCallback.onConfirm();
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgtv
 * JD-Core Version:    0.7.0.1
 */