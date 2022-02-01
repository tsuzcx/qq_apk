import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;
import dov.com.qq.im.ae.mode.AECaptureMode;

class bnkk
  implements Observer<bnuq>
{
  bnkk(bnkd parambnkd) {}
  
  public void a(@Nullable bnuq parambnuq)
  {
    if (parambnuq == null) {}
    do
    {
      return;
      bnkd.a(this.a).o();
      bnkd.a(this.a, parambnuq.b);
      if (bnkd.a(this.a) == AECaptureMode.NORMAL)
      {
        bnkd.a(this.a);
        return;
      }
      if (bnkd.a(this.a) == AECaptureMode.GIF)
      {
        bnkd.a(this.a).setVisibility(8);
        return;
      }
    } while (bnkd.a(this.a) != AECaptureMode.PLAY);
    bnkd.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnkk
 * JD-Core Version:    0.7.0.1
 */