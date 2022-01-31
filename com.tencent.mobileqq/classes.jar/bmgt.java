import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureSegmentView;
import dov.com.qq.im.ptv.LightWeightSoDownloadUnit.4;

public class bmgt
  implements DialogInterface.OnClickListener
{
  public bmgt(LightWeightSoDownloadUnit.4 param4) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = bmgs.a(this.a.this$0).a();
    if (paramInt == 1)
    {
      this.a.this$0.a.setCameraPermissionResult(false);
      Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      localIntent.setData(Uri.fromParts("package", paramDialogInterface.getPackageName(), null));
      paramDialogInterface.startActivity(localIntent);
      return;
    }
    paramDialogInterface.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmgt
 * JD-Core Version:    0.7.0.1
 */