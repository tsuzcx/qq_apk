import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.widget.ImageView;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.mode.AECaptureModeSelectPager;

class blbe
  implements bmac<blbb>
{
  blbe(blbc paramblbc) {}
  
  public void a(@Nullable blbb paramblbb)
  {
    boolean bool = false;
    if (paramblbb == null) {
      return;
    }
    paramblbb = paramblbb.a;
    blbc.a(this.a, paramblbb);
    if (paramblbb != AECaptureMode.NORMAL) {
      blbc.a(this.a).a(196616, new Object[0]);
    }
    int i;
    if (blbc.a(this.a) != null)
    {
      i = 0;
      if (i < blbc.a(this.a).length) {
        if (paramblbb != blbc.a(this.a)[i]) {}
      }
    }
    for (;;)
    {
      if (i != -1) {
        blbc.a(this.a).setCurrentItem(i, true);
      }
      blbc localblbc = this.a;
      if (paramblbb == AECaptureMode.GIF) {
        bool = true;
      }
      blbc.a(localblbc, bool);
      blbc.a(this.a).notifyDataSetChanged();
      paramblbb = blbc.a(this.a);
      if (blbc.a(this.a)) {}
      for (i = 2130837595;; i = 2130837596)
      {
        paramblbb.setImageResource(i);
        return;
        i += 1;
        break;
      }
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blbe
 * JD-Core Version:    0.7.0.1
 */