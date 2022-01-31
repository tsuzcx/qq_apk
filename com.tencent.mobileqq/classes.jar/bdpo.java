import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.triton.sdk.callback.DialogCallback;

class bdpo
  implements DialogInterface.OnClickListener
{
  bdpo(bdpl parambdpl, DialogCallback paramDialogCallback) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkCallbackDialogCallback.onCancel();
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdpo
 * JD-Core Version:    0.7.0.1
 */