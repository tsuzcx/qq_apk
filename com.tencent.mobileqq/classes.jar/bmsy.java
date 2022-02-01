import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.Log;
import dov.com.qq.im.capture.mode.CaptureModeController;

class bmsy
  implements DialogInterface.OnClickListener
{
  bmsy(bmsw parambmsw) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a(false);
    if ((this.a.jdField_a_of_type_Blhu instanceof blht)) {
      ((blht)this.a.jdField_a_of_type_Blhu).a(false);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().onBackPressed();
      babk.e();
      babc.b();
      return;
      Log.e("SegmentMode", "mCameraCaptureUnit should implement ISegmentVideoController!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmsy
 * JD-Core Version:    0.7.0.1
 */