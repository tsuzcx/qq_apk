import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.richmedia.capture.view.SimpleEffectsCaptureView;
import dov.com.qq.im.ptv.LightWeightCameraCaptureUnit.10;

public class bmfp
  implements DialogInterface.OnCancelListener
{
  public bmfp(LightWeightCameraCaptureUnit.10 param10) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.this$0.a.setCameraPermissionResult(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmfp
 * JD-Core Version:    0.7.0.1
 */