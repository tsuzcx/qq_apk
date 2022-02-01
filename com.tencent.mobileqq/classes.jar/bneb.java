import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import dov.com.qq.im.ae.mode.AECaptureMode;

class bneb
  implements Observer<AEVideoStoryTopBarViewModel.Ratio>
{
  bneb(bndy parambndy) {}
  
  public void a(@Nullable AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    bnzb.b("AEPituCameraUnit", "mCurrentRatio---onChanged: ratio=" + paramRatio);
    if (paramRatio == null) {}
    do
    {
      do
      {
        return;
      } while (bndy.a(this.a) == paramRatio);
      bndy.a(this.a, paramRatio);
      bnyp.a().a("sp_key_ae_camera_ratio", paramRatio.code, 0);
    } while (bndy.b(this.a) != AECaptureMode.NORMAL);
    bndy.f(this.a);
    bndy.g(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bneb
 * JD-Core Version:    0.7.0.1
 */