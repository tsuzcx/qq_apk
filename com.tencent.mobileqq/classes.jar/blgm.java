import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.ViewGroup;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.play.PlayViewPagerAdapter;

class blgm
  implements bmeo<blfi>
{
  blgm(blgj paramblgj) {}
  
  public void a(@Nullable blfi paramblfi)
  {
    if (paramblfi == null) {}
    do
    {
      do
      {
        do
        {
          return;
          paramblfi = paramblfi.a;
          if (paramblfi != AECaptureMode.NORMAL) {
            break;
          }
          if ((blfz.a == null) || (blfz.a != bkzy.a())) {
            bliy.a().g("none");
          }
        } while (!this.a.a());
        blgj.a(this.a).setVisibility(8);
        return;
        if (paramblfi != AECaptureMode.GIF) {
          break;
        }
      } while (!this.a.a());
      blgj.a(this.a).setVisibility(8);
      return;
    } while (paramblfi != AECaptureMode.PLAY);
    blgj.c(this.a);
    if (blgj.a(this.a) != null)
    {
      paramblfi = blgj.a(this.a).a();
      if ((!TextUtils.isEmpty(paramblfi)) && (!"-1".equals(paramblfi))) {
        bliy.a().g(paramblfi);
      }
    }
    blgj.a(this.a).setVisibility(0);
    blgj.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blgm
 * JD-Core Version:    0.7.0.1
 */