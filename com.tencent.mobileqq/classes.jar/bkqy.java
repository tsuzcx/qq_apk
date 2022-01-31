import android.support.annotation.Nullable;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;
import dov.com.qq.im.ae.mode.AECaptureMode;

class bkqy
  implements bmac<blbb>
{
  bkqy(bkqr parambkqr) {}
  
  public void a(@Nullable blbb paramblbb)
  {
    if (paramblbb == null) {}
    do
    {
      return;
      bkqr.a(this.a).q();
      paramblbb = paramblbb.a;
      if (paramblbb == AECaptureMode.NORMAL)
      {
        bkqr.a(this.a);
        return;
      }
      if (paramblbb == AECaptureMode.GIF)
      {
        bkqr.a(this.a).setVisibility(8);
        return;
      }
    } while (paramblbb != AECaptureMode.PLAY);
    bkqr.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkqy
 * JD-Core Version:    0.7.0.1
 */