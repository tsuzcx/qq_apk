import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;
import dov.com.qq.im.ae.mode.AECaptureMode;

class bndh
  implements Observer<bnpr>
{
  bndh(bnda parambnda) {}
  
  public void a(@Nullable bnpr parambnpr)
  {
    if (parambnpr == null) {}
    do
    {
      return;
      this.a.jdField_a_of_type_Bmxa.e();
      bnda.a(this.a, parambnpr.b);
      if (bnda.a(this.a) == AECaptureMode.NORMAL)
      {
        bnda.a(this.a);
        return;
      }
      if (bnda.a(this.a) == AECaptureMode.GIF)
      {
        this.a.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setVisibility(8);
        return;
      }
    } while (bnda.a(this.a) != AECaptureMode.PLAY);
    this.a.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bndh
 * JD-Core Version:    0.7.0.1
 */