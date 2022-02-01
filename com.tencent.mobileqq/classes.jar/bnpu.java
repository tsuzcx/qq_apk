import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.widget.ImageView;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.mode.AECaptureModeSelectPager;

class bnpu
  implements Observer<bnpr>
{
  bnpu(bnps parambnps) {}
  
  public void a(@Nullable bnpr parambnpr)
  {
    boolean bool = false;
    if (parambnpr == null) {
      return;
    }
    parambnpr = parambnpr.b;
    bnps.a(this.a, parambnpr);
    if (parambnpr != AECaptureMode.NORMAL) {
      bnps.a(this.a).a(196616, new Object[0]);
    }
    int i;
    if (bnps.a(this.a) != null)
    {
      i = 0;
      if (i < bnps.a(this.a).length) {
        if (parambnpr != bnps.a(this.a)[i]) {}
      }
    }
    for (;;)
    {
      if (i != -1) {
        bnps.a(this.a).setCurrentItem(i, true);
      }
      bnps localbnps = this.a;
      if (parambnpr == AECaptureMode.GIF) {
        bool = true;
      }
      bnps.a(localbnps, bool);
      bnps.a(this.a).notifyDataSetChanged();
      parambnpr = bnps.a(this.a);
      if (bnps.a(this.a)) {}
      for (i = 2130837611;; i = 2130837612)
      {
        parambnpr.setImageResource(i);
        return;
        i += 1;
        break;
      }
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnpu
 * JD-Core Version:    0.7.0.1
 */