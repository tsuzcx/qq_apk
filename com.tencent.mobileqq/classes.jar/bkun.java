import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import dov.com.tencent.mobileqq.richmedia.capture.fragment.CaptureQmcfSoDownloadFragment;
import dov.com.tencent.mobileqq.richmedia.capture.fragment.CaptureQmcfSoDownloadFragment.7;

public class bkun
  implements DialogInterface.OnCancelListener
{
  public bkun(CaptureQmcfSoDownloadFragment.7 param7) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    CaptureQmcfSoDownloadFragment.a(this.a.this$0).setCameraPermissionResult(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkun
 * JD-Core Version:    0.7.0.1
 */