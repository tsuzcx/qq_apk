import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.richmedia.capture.view.SimpleEffectsCaptureView;
import dov.com.qq.im.ptv.LightWeightCameraCaptureUnit.10;

public class bmbc
  implements DialogInterface.OnClickListener
{
  public bmbc(LightWeightCameraCaptureUnit.10 param10) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a.this$0.jdField_a_of_type_Bmcv.a();
    if (paramInt == 1)
    {
      this.a.this$0.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewSimpleEffectsCaptureView.setCameraPermissionResult(false);
      Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      localIntent.setData(Uri.fromParts("package", paramDialogInterface.getPackageName(), null));
      paramDialogInterface.startActivity(localIntent);
      return;
    }
    paramDialogInterface.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmbc
 * JD-Core Version:    0.7.0.1
 */