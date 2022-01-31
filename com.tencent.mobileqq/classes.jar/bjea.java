import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import dov.com.tencent.mobileqq.richmedia.capture.fragment.CaptureQmcfSoDownloadFragment;
import dov.com.tencent.mobileqq.richmedia.capture.fragment.CaptureQmcfSoDownloadFragment.7;

public class bjea
  implements DialogInterface.OnClickListener
{
  public bjea(CaptureQmcfSoDownloadFragment.7 param7) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a.this$0.getActivity();
    if (paramInt == 1)
    {
      CaptureQmcfSoDownloadFragment.a(this.a.this$0).setCameraPermissionResult(false);
      Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      localIntent.setData(Uri.fromParts("package", paramDialogInterface.getPackageName(), null));
      paramDialogInterface.startActivity(localIntent);
      return;
    }
    paramDialogInterface.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjea
 * JD-Core Version:    0.7.0.1
 */