import android.view.View;
import android.view.View.OnClickListener;
import dov.com.qq.im.ae.mode.AECaptureMode;

class blfo
  implements View.OnClickListener
{
  blfo(blfn paramblfn, AECaptureMode paramAECaptureMode, int paramInt) {}
  
  public void onClick(View paramView)
  {
    blfj.a(this.jdField_a_of_type_Blfn.a, this.jdField_a_of_type_DovComQqImAeModeAECaptureMode);
    if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.GIF) {
      bliu.a().v();
    }
    for (;;)
    {
      bljn.b("AEVideoStoryCaptureModePart", "【AE_CAPTURE_MODE】:" + this.jdField_a_of_type_Int);
      return;
      if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.NORMAL) {
        bliu.a().u();
      } else if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.PLAY) {
        bliu.a().C();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blfo
 * JD-Core Version:    0.7.0.1
 */