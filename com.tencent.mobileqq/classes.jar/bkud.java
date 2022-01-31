import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import dov.com.qq.im.ae.mode.AECaptureMode;

class bkud
  implements bmac<blbb>
{
  bkud(bkuc parambkuc) {}
  
  public void a(@Nullable blbb paramblbb)
  {
    if (paramblbb == null) {}
    label159:
    do
    {
      return;
      paramblbb = paramblbb.a;
      if (paramblbb == AECaptureMode.NORMAL)
      {
        if (bkwm.i(bkuc.a(this.a).getIntent()))
        {
          bkuc.a(this.a).setImageResource(2130839784);
          bkuc.a(this.a).setVisibility(0);
          bkuc.a(this.a).setBackgroundResource(2130837708);
          bkuc.b(this.a).setVisibility(0);
          if (!paramblbb.getHasCountDown()) {
            break label159;
          }
          bkuc.c(this.a).setVisibility(8);
          bkuc.d(this.a).setBackgroundResource(2130837610);
          bkuc.d(this.a).setVisibility(0);
          bkuc.a(this.a, 10);
        }
        for (;;)
        {
          bkuc.e(this.a).setVisibility(8);
          return;
          bkuc.a(this.a).setImageResource(2130844061);
          break;
          bkuc.c(this.a).setBackgroundResource(2130837609);
          bkuc.c(this.a).setVisibility(0);
          bkuc.d(this.a).setVisibility(8);
        }
      }
      if (paramblbb == AECaptureMode.GIF)
      {
        bkuc.a(this.a).setImageResource(2130844060);
        bkuc.a(this.a).setVisibility(0);
        bkuc.a(this.a).setBackgroundResource(2130837707);
        bkuc.c(this.a).setBackgroundResource(2130837608);
        bkuc.b(this.a).setVisibility(8);
        bkuc.d(this.a).setBackgroundResource(2130837611);
        bkuc.d(this.a).setVisibility(0);
        bkuc.a(this.a, 3);
        bkuc.e(this.a).setVisibility(0);
        return;
      }
    } while (paramblbb != AECaptureMode.PLAY);
    bkuc.a(this.a).setImageResource(2130844061);
    bkuc.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkud
 * JD-Core Version:    0.7.0.1
 */