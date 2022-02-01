import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import dov.com.qq.im.ae.AEPituCameraUnit.28;

public class blke
  implements DialogInterface.OnClickListener
{
  public blke(AEPituCameraUnit.28 param28) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bmbx.b(this.a.this$0.jdField_a_of_type_JavaLangString, "PermissionDialog--onClick which=" + paramInt);
    Activity localActivity = this.a.this$0.jdField_a_of_type_Bnbp.a();
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
 * Qualified Name:     blke
 * JD-Core Version:    0.7.0.1
 */