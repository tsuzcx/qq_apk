import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import dov.com.qq.im.QIMCameraCaptureUnit.13;

public class bkip
  implements DialogInterface.OnCancelListener
{
  public bkip(QIMCameraCaptureUnit.13 param13) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.this$0.a.setCameraPermissionResult(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkip
 * JD-Core Version:    0.7.0.1
 */