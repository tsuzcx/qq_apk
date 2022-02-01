import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.widget.ImageView;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.mode.AECaptureModeSelectPager;

class bowf
  implements Observer<bowc>
{
  bowf(bowd parambowd) {}
  
  public void a(@Nullable bowc parambowc)
  {
    boolean bool = false;
    if (parambowc == null) {
      return;
    }
    parambowc = parambowc.b;
    bowd.a(this.a, parambowc);
    if (parambowc != AECaptureMode.NORMAL) {
      bowd.a(this.a).a(196616, new Object[0]);
    }
    int i;
    if (bowd.a(this.a) != null)
    {
      i = 0;
      if (i < bowd.a(this.a).length) {
        if (parambowc != bowd.a(this.a)[i]) {}
      }
    }
    for (;;)
    {
      if (i != -1) {
        bowd.a(this.a).setCurrentItem(i, true);
      }
      bowd localbowd = this.a;
      if (parambowc == AECaptureMode.GIF) {
        bool = true;
      }
      bowd.a(localbowd, bool);
      bowd.a(this.a).notifyDataSetChanged();
      parambowc = bowd.a(this.a);
      if (bowd.a(this.a)) {}
      for (i = 2130837610;; i = 2130837611)
      {
        parambowc.setImageResource(i);
        return;
        i += 1;
        break;
      }
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bowf
 * JD-Core Version:    0.7.0.1
 */