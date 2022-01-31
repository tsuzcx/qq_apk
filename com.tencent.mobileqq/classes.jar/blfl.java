import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.widget.ImageView;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.mode.AECaptureModeSelectPager;

class blfl
  implements bmeo<blfi>
{
  blfl(blfj paramblfj) {}
  
  public void a(@Nullable blfi paramblfi)
  {
    boolean bool = false;
    if (paramblfi == null) {
      return;
    }
    paramblfi = paramblfi.a;
    blfj.a(this.a, paramblfi);
    if (paramblfi != AECaptureMode.NORMAL) {
      blfj.a(this.a).a(196616, new Object[0]);
    }
    int i;
    if (blfj.a(this.a) != null)
    {
      i = 0;
      if (i < blfj.a(this.a).length) {
        if (paramblfi != blfj.a(this.a)[i]) {}
      }
    }
    for (;;)
    {
      if (i != -1) {
        blfj.a(this.a).setCurrentItem(i, true);
      }
      blfj localblfj = this.a;
      if (paramblfi == AECaptureMode.GIF) {
        bool = true;
      }
      blfj.a(localblfj, bool);
      blfj.a(this.a).notifyDataSetChanged();
      paramblfi = blfj.a(this.a);
      if (blfj.a(this.a)) {}
      for (i = 2130837595;; i = 2130837596)
      {
        paramblfi.setImageResource(i);
        return;
        i += 1;
        break;
      }
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blfl
 * JD-Core Version:    0.7.0.1
 */