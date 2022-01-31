import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import dov.com.qq.im.AECamera.View.AECameraGLSurfaceView;
import dov.com.qq.im.AEPituCameraUnit.25;

public class bhdd
  implements DialogInterface.OnClickListener
{
  public bhdd(AEPituCameraUnit.25 param25) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Activity localActivity = bhcw.a(this.a.this$0).a();
    if (paramInt == 1)
    {
      bhcw.a(this.a.this$0).setCameraPermissionFinish(true);
      Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      localIntent.setData(Uri.fromParts("package", localActivity.getPackageName(), null));
      localActivity.startActivity(localIntent);
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      return;
      localActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhdd
 * JD-Core Version:    0.7.0.1
 */