import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import dov.com.qq.im.ae.AEPituCameraUnit.29;

public class bofs
  implements DialogInterface.OnClickListener
{
  public bofs(AEPituCameraUnit.29 param29) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bpam.b("AEPituCameraUnit", "PermissionDialog--onClick which=" + paramInt);
    Activity localActivity = bofh.a(this.a.this$0).a();
    if (paramInt == 1)
    {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bofs
 * JD-Core Version:    0.7.0.1
 */