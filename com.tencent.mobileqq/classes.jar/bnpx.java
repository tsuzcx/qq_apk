import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.mode.AECaptureMode;

class bnpx
  implements View.OnClickListener
{
  bnpx(bnpw parambnpw, AECaptureMode paramAECaptureMode, int paramInt) {}
  
  public void onClick(View paramView)
  {
    bnps.a(this.jdField_a_of_type_Bnpw.a, this.jdField_a_of_type_DovComQqImAeModeAECaptureMode);
    if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.GIF) {
      bnqm.a().M();
    }
    for (;;)
    {
      bnrh.b("AEVideoStoryCaptureModePart", "【AE_CAPTURE_MODE】:" + this.jdField_a_of_type_Int);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.NORMAL) {
        bnqm.a().L();
      } else if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.PLAY) {
        bnqm.a().V();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnpx
 * JD-Core Version:    0.7.0.1
 */