import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import dov.com.qq.im.ae.mode.AECaptureMode;

class bkyk
  implements bmeo<blfi>
{
  bkyk(bkyj parambkyj) {}
  
  public void a(@Nullable blfi paramblfi)
  {
    if (paramblfi == null) {}
    label159:
    do
    {
      return;
      paramblfi = paramblfi.a;
      if (paramblfi == AECaptureMode.NORMAL)
      {
        if (blat.i(bkyj.a(this.a).getIntent()))
        {
          bkyj.a(this.a).setImageResource(2130839785);
          bkyj.a(this.a).setVisibility(0);
          bkyj.a(this.a).setBackgroundResource(2130837709);
          bkyj.b(this.a).setVisibility(0);
          if (!paramblfi.getHasCountDown()) {
            break label159;
          }
          bkyj.c(this.a).setVisibility(8);
          bkyj.d(this.a).setBackgroundResource(2130837610);
          bkyj.d(this.a).setVisibility(0);
          bkyj.a(this.a, 10);
        }
        for (;;)
        {
          bkyj.e(this.a).setVisibility(8);
          return;
          bkyj.a(this.a).setImageResource(2130844133);
          break;
          bkyj.c(this.a).setBackgroundResource(2130837609);
          bkyj.c(this.a).setVisibility(0);
          bkyj.d(this.a).setVisibility(8);
        }
      }
      if (paramblfi == AECaptureMode.GIF)
      {
        bkyj.a(this.a).setImageResource(2130844132);
        bkyj.a(this.a).setVisibility(0);
        bkyj.a(this.a).setBackgroundResource(2130837708);
        bkyj.c(this.a).setBackgroundResource(2130837608);
        bkyj.b(this.a).setVisibility(8);
        bkyj.d(this.a).setBackgroundResource(2130837611);
        bkyj.d(this.a).setVisibility(0);
        bkyj.a(this.a, 3);
        bkyj.e(this.a).setVisibility(0);
        return;
      }
    } while (paramblfi != AECaptureMode.PLAY);
    bkyj.a(this.a).setImageResource(2130844133);
    bkyj.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkyk
 * JD-Core Version:    0.7.0.1
 */