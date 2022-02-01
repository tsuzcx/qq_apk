import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.widget.ImageView;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.mode.AECaptureModeSelectPager;

class bnut
  implements Observer<bnuq>
{
  bnut(bnur parambnur) {}
  
  public void a(@Nullable bnuq parambnuq)
  {
    boolean bool = false;
    if (parambnuq == null) {
      return;
    }
    parambnuq = parambnuq.b;
    bnur.a(this.a, parambnuq);
    if (parambnuq != AECaptureMode.NORMAL) {
      bnur.a(this.a).a(196616, new Object[0]);
    }
    int i;
    if (bnur.a(this.a) != null)
    {
      i = 0;
      if (i < bnur.a(this.a).length) {
        if (parambnuq != bnur.a(this.a)[i]) {}
      }
    }
    for (;;)
    {
      if (i != -1) {
        bnur.a(this.a).setCurrentItem(i, true);
      }
      bnur localbnur = this.a;
      if (parambnuq == AECaptureMode.GIF) {
        bool = true;
      }
      bnur.a(localbnur, bool);
      bnur.a(this.a).notifyDataSetChanged();
      parambnuq = bnur.a(this.a);
      if (bnur.a(this.a)) {}
      for (i = 2130837610;; i = 2130837611)
      {
        parambnuq.setImageResource(i);
        return;
        i += 1;
        break;
      }
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnut
 * JD-Core Version:    0.7.0.1
 */