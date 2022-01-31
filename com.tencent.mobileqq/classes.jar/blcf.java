import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.ViewGroup;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.play.PlayViewPagerAdapter;

class blcf
  implements bmac<blbb>
{
  blcf(blcc paramblcc) {}
  
  public void a(@Nullable blbb paramblbb)
  {
    if (paramblbb == null) {}
    do
    {
      do
      {
        do
        {
          return;
          paramblbb = paramblbb.a;
          if (paramblbb != AECaptureMode.NORMAL) {
            break;
          }
          if ((blbs.a == null) || (blbs.a != bkvr.a())) {
            bler.a().g("none");
          }
        } while (!this.a.a());
        blcc.a(this.a).setVisibility(8);
        return;
        if (paramblbb != AECaptureMode.GIF) {
          break;
        }
      } while (!this.a.a());
      blcc.a(this.a).setVisibility(8);
      return;
    } while (paramblbb != AECaptureMode.PLAY);
    blcc.c(this.a);
    if (blcc.a(this.a) != null)
    {
      paramblbb = blcc.a(this.a).a();
      if ((!TextUtils.isEmpty(paramblbb)) && (!"-1".equals(paramblbb))) {
        bler.a().g(paramblbb);
      }
    }
    blcc.a(this.a).setVisibility(0);
    blcc.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blcf
 * JD-Core Version:    0.7.0.1
 */