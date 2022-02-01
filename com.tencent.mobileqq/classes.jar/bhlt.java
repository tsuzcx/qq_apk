import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;

final class bhlt
  implements DialogInterface.OnClickListener
{
  bhlt(Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      paramDialogInterface = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      paramDialogInterface.setData(Uri.fromParts("package", this.a.getPackageName(), null));
      this.a.startActivity(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhlt
 * JD-Core Version:    0.7.0.1
 */