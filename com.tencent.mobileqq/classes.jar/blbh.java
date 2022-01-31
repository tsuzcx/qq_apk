import android.view.View;
import android.view.View.OnClickListener;
import dov.com.qq.im.ae.mode.AECaptureMode;

class blbh
  implements View.OnClickListener
{
  blbh(blbg paramblbg, AECaptureMode paramAECaptureMode, int paramInt) {}
  
  public void onClick(View paramView)
  {
    blbc.a(this.jdField_a_of_type_Blbg.a, this.jdField_a_of_type_DovComQqImAeModeAECaptureMode);
    if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.GIF) {
      blen.a().v();
    }
    for (;;)
    {
      blfg.b("AEVideoStoryCaptureModePart", "【AE_CAPTURE_MODE】:" + this.jdField_a_of_type_Int);
      return;
      if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.NORMAL) {
        blen.a().u();
      } else if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.PLAY) {
        blen.a().C();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blbh
 * JD-Core Version:    0.7.0.1
 */