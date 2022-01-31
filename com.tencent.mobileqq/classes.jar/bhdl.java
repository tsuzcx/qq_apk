import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import dov.com.qq.im.QIMCameraCaptureUnit.13;

public class bhdl
  implements DialogInterface.OnClickListener
{
  public bhdl(QIMCameraCaptureUnit.13 param13) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Activity localActivity = this.a.this$0.jdField_a_of_type_Bhzc.a();
    if (paramInt == 1)
    {
      this.a.this$0.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setCameraPermissionFinish(true);
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
 * Qualified Name:     bhdl
 * JD-Core Version:    0.7.0.1
 */