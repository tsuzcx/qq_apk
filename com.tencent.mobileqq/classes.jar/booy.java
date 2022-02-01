import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.view.AECompoundButton;

class booy
  implements Observer<bowc>
{
  booy(boow paramboow) {}
  
  public void a(@Nullable bowc parambowc)
  {
    if (parambowc == null) {}
    do
    {
      return;
      parambowc = parambowc.b;
      if (parambowc == AECaptureMode.NORMAL)
      {
        if (!born.j(boow.a(this.a).getIntent())) {
          boow.a(this.a).a().setImageResource(2130844544);
        }
        boow.a(this.a).setVisibility(0);
        if (!born.j(boow.b(this.a).getIntent())) {
          boow.b(this.a).a().setImageResource(2130837944);
        }
        boow.c(this.a).setVisibility(0);
        if (parambowc.getHasCountDown())
        {
          boow.d(this.a).setVisibility(8);
          boow.e(this.a).a().setImageResource(2130837937);
          boow.e(this.a).setVisibility(0);
          boow.a(this.a, 10);
        }
        for (;;)
        {
          boow.f(this.a).setVisibility(8);
          return;
          if (!born.j(boow.c(this.a).getIntent())) {
            boow.d(this.a).a().setImageResource(2130837674);
          }
          boow.d(this.a).setVisibility(0);
          boow.e(this.a).setVisibility(8);
        }
      }
      if (parambowc == AECaptureMode.GIF)
      {
        boow.a(this.a).a().setImageResource(2130844543);
        boow.a(this.a).setVisibility(0);
        boow.b(this.a).a().setImageResource(2130837943);
        boow.d(this.a).a().setImageResource(2130837673);
        boow.c(this.a).setVisibility(8);
        boow.e(this.a).a().setImageResource(2130837675);
        boow.e(this.a).setVisibility(0);
        boow.a(this.a, 3);
        boow.f(this.a).setVisibility(0);
        return;
      }
    } while (parambowc != AECaptureMode.PLAY);
    boow.a(this.a).a().setImageResource(2130844544);
    boow.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     booy
 * JD-Core Version:    0.7.0.1
 */