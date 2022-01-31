import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.richmedia.capture.view.SimpleEffectsCaptureView;
import dov.com.qq.im.ptv.LightWeightCameraCaptureUnit.10;

public class bmbd
  implements DialogInterface.OnCancelListener
{
  public bmbd(LightWeightCameraCaptureUnit.10 param10) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.this$0.a.setCameraPermissionResult(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmbd
 * JD-Core Version:    0.7.0.1
 */