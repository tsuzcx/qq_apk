import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.widget.ImageView;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.mode.AECaptureModeSelectPager;

class bmak
  implements Observer<bmah>
{
  bmak(bmai parambmai) {}
  
  public void a(@Nullable bmah parambmah)
  {
    boolean bool = false;
    if (parambmah == null) {
      return;
    }
    parambmah = parambmah.b;
    bmai.a(this.a, parambmah);
    if (parambmah != AECaptureMode.NORMAL) {
      bmai.a(this.a).a(196616, new Object[0]);
    }
    int i;
    if (bmai.a(this.a) != null)
    {
      i = 0;
      if (i < bmai.a(this.a).length) {
        if (parambmah != bmai.a(this.a)[i]) {}
      }
    }
    for (;;)
    {
      if (i != -1) {
        bmai.a(this.a).setCurrentItem(i, true);
      }
      bmai localbmai = this.a;
      if (parambmah == AECaptureMode.GIF) {
        bool = true;
      }
      bmai.a(localbmai, bool);
      bmai.a(this.a).notifyDataSetChanged();
      parambmah = bmai.a(this.a);
      if (bmai.a(this.a)) {}
      for (i = 2130837610;; i = 2130837611)
      {
        parambmah.setImageResource(i);
        return;
        i += 1;
        break;
      }
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmak
 * JD-Core Version:    0.7.0.1
 */