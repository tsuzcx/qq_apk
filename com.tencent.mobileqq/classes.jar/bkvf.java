import android.support.annotation.Nullable;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;
import dov.com.qq.im.ae.mode.AECaptureMode;

class bkvf
  implements bmeo<blfi>
{
  bkvf(bkuy parambkuy) {}
  
  public void a(@Nullable blfi paramblfi)
  {
    if (paramblfi == null) {}
    do
    {
      return;
      bkuy.a(this.a).q();
      paramblfi = paramblfi.a;
      if (paramblfi == AECaptureMode.NORMAL)
      {
        bkuy.a(this.a);
        return;
      }
      if (paramblfi == AECaptureMode.GIF)
      {
        bkuy.a(this.a).setVisibility(8);
        return;
      }
    } while (paramblfi != AECaptureMode.PLAY);
    bkuy.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkvf
 * JD-Core Version:    0.7.0.1
 */