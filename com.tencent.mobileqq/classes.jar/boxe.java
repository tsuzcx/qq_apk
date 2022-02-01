import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.ViewGroup;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.play.PlayViewPagerAdapter;

class boxe
  implements Observer<bowc>
{
  boxe(boxb paramboxb) {}
  
  public void a(@Nullable bowc parambowc)
  {
    if (parambowc == null) {}
    do
    {
      do
      {
        do
        {
          return;
          parambowc = parambowc.b;
          if (parambowc != AECaptureMode.NORMAL) {
            break;
          }
          if ((bowt.a == null) || (bowt.a != boqr.a())) {
            bozv.a().g("none");
          }
        } while (!this.a.b());
        boxb.a(this.a).setVisibility(8);
        return;
        if (parambowc != AECaptureMode.GIF) {
          break;
        }
      } while (!this.a.b());
      boxb.a(this.a).setVisibility(8);
      return;
    } while (parambowc != AECaptureMode.PLAY);
    boxb.c(this.a);
    if (boxb.a(this.a) != null)
    {
      parambowc = boxb.a(this.a).a();
      if ((!TextUtils.isEmpty(parambowc)) && (!"-1".equals(parambowc))) {
        bozv.a().g(parambowc);
      }
    }
    boxb.a(this.a).setVisibility(0);
    boxb.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boxe
 * JD-Core Version:    0.7.0.1
 */