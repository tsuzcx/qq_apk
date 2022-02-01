import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.mode.AECaptureMode;

class bowi
  implements View.OnClickListener
{
  bowi(bowh parambowh, AECaptureMode paramAECaptureMode, int paramInt) {}
  
  public void onClick(View paramView)
  {
    bowd.a(this.jdField_a_of_type_Bowh.a, this.jdField_a_of_type_DovComQqImAeModeAECaptureMode);
    if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.GIF) {
      bozr.a().I();
    }
    for (;;)
    {
      bpam.b("AEVideoStoryCaptureModePart", "【AE_CAPTURE_MODE】:" + this.jdField_a_of_type_Int);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.NORMAL) {
        bozr.a().H();
      } else if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.PLAY) {
        bozr.a().R();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bowi
 * JD-Core Version:    0.7.0.1
 */