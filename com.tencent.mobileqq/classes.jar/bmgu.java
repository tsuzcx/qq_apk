import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureSegmentView;
import dov.com.qq.im.ptv.LightWeightSoDownloadUnit.4;

public class bmgu
  implements DialogInterface.OnCancelListener
{
  public bmgu(LightWeightSoDownloadUnit.4 param4) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.this$0.a.setCameraPermissionResult(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmgu
 * JD-Core Version:    0.7.0.1
 */