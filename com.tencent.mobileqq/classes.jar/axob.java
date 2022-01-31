import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import mqq.app.AppActivity;

public final class axob
  implements DialogInterface.OnClickListener
{
  public axob(AppActivity paramAppActivity, axof paramaxof) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      paramDialogInterface = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      paramDialogInterface.setData(Uri.fromParts("package", this.jdField_a_of_type_MqqAppAppActivity.getPackageName(), null));
      this.jdField_a_of_type_MqqAppAppActivity.startActivity(paramDialogInterface);
    }
    while (this.jdField_a_of_type_Axof == null) {
      return;
    }
    this.jdField_a_of_type_Axof.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     axob
 * JD-Core Version:    0.7.0.1
 */