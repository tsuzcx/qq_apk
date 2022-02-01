import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import dov.com.qq.im.ae.AEPituCameraUnit.33;

public class bmxl
  implements DialogInterface.OnClickListener
{
  public bmxl(AEPituCameraUnit.33 param33) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bnrh.b(this.a.this$0.jdField_a_of_type_JavaLangString, "PermissionDialog--onClick which=" + paramInt);
    Activity localActivity = this.a.this$0.jdField_a_of_type_Borh.a();
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
 * Qualified Name:     bmxl
 * JD-Core Version:    0.7.0.1
 */