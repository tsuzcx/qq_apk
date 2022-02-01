import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;
import dov.com.qq.im.ae.mode.AECaptureMode;

class bols
  implements Observer<bowc>
{
  bols(boll paramboll) {}
  
  public void a(@Nullable bowc parambowc)
  {
    if (parambowc == null) {}
    do
    {
      return;
      this.a.jdField_a_of_type_Bofh.o();
      boll.a(this.a, parambowc.b);
      if (boll.a(this.a) == AECaptureMode.NORMAL)
      {
        boll.a(this.a);
        return;
      }
      if (boll.a(this.a) == AECaptureMode.GIF)
      {
        this.a.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setVisibility(8);
        return;
      }
    } while (boll.a(this.a) != AECaptureMode.PLAY);
    this.a.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bols
 * JD-Core Version:    0.7.0.1
 */