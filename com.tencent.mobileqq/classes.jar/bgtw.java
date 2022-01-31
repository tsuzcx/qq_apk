import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.triton.sdk.callback.DialogCallback;

class bgtw
  implements DialogInterface.OnClickListener
{
  bgtw(bgtt parambgtt, DialogCallback paramDialogCallback) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkCallbackDialogCallback.onCancel();
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgtw
 * JD-Core Version:    0.7.0.1
 */