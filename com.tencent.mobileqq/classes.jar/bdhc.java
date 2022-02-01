import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import mqq.app.AppActivity;

public final class bdhc
  implements DialogInterface.OnClickListener
{
  public bdhc(AppActivity paramAppActivity, bdhi parambdhi) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      paramDialogInterface = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      paramDialogInterface.setData(Uri.fromParts("package", this.jdField_a_of_type_MqqAppAppActivity.getPackageName(), null));
      this.jdField_a_of_type_MqqAppAppActivity.startActivity(paramDialogInterface);
    }
    while (this.jdField_a_of_type_Bdhi == null) {
      return;
    }
    this.jdField_a_of_type_Bdhi.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdhc
 * JD-Core Version:    0.7.0.1
 */