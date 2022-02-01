import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;
import dov.com.qq.im.ae.mode.AECaptureMode;

class blpy
  implements Observer<bmah>
{
  blpy(blpr paramblpr) {}
  
  public void a(@Nullable bmah parambmah)
  {
    if (parambmah == null) {}
    do
    {
      return;
      this.a.jdField_a_of_type_Bljy.J();
      blpr.a(this.a, parambmah.b);
      if (blpr.a(this.a) == AECaptureMode.NORMAL)
      {
        blpr.a(this.a);
        return;
      }
      if (blpr.a(this.a) == AECaptureMode.GIF)
      {
        this.a.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setVisibility(8);
        return;
      }
    } while (blpr.a(this.a) != AECaptureMode.PLAY);
    this.a.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blpy
 * JD-Core Version:    0.7.0.1
 */