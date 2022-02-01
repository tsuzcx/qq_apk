import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.ViewGroup;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.play.PlayViewPagerAdapter;

class bnvu
  implements Observer<bnuq>
{
  bnvu(bnvr parambnvr) {}
  
  public void a(@Nullable bnuq parambnuq)
  {
    if (parambnuq == null) {}
    do
    {
      do
      {
        do
        {
          return;
          parambnuq = parambnuq.b;
          if (parambnuq != AECaptureMode.NORMAL) {
            break;
          }
          if ((bnvh.a == null) || (bnvh.a != bnpc.a())) {
            bnyl.a().g("none");
          }
        } while (!this.a.a());
        bnvr.a(this.a).setVisibility(8);
        return;
        if (parambnuq != AECaptureMode.GIF) {
          break;
        }
      } while (!this.a.a());
      bnvr.a(this.a).setVisibility(8);
      return;
    } while (parambnuq != AECaptureMode.PLAY);
    bnvr.c(this.a);
    if (bnvr.a(this.a) != null)
    {
      parambnuq = bnvr.a(this.a).a();
      if ((!TextUtils.isEmpty(parambnuq)) && (!"-1".equals(parambnuq))) {
        bnyl.a().g(parambnuq);
      }
    }
    bnvr.a(this.a).setVisibility(0);
    bnvr.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnvu
 * JD-Core Version:    0.7.0.1
 */