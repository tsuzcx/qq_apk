import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.view.AECompoundButton;

class bnhh
  implements Observer<bnpr>
{
  bnhh(bnhf parambnhf) {}
  
  public void a(@Nullable bnpr parambnpr)
  {
    if (parambnpr == null) {}
    label407:
    for (;;)
    {
      return;
      parambnpr = parambnpr.b;
      if (parambnpr == AECaptureMode.NORMAL)
      {
        if (!bnlb.j(bnhf.a(this.a).getIntent())) {
          bnhf.a(this.a).a().setImageResource(2130844482);
        }
        bnhf.a(this.a).setVisibility(0);
        if (!bnlb.j(bnhf.b(this.a).getIntent())) {
          bnhf.b(this.a).a().setImageResource(2130837983);
        }
        bnhf.c(this.a).setVisibility(0);
        if (parambnpr.getHasCountDown())
        {
          bnhf.d(this.a).setVisibility(8);
          bnhf.e(this.a).a().setImageResource(2130837976);
          bnhf.e(this.a).setVisibility(0);
          bnhf.a(this.a, 10);
          bnhf.f(this.a).setVisibility(8);
        }
      }
      for (;;)
      {
        if (!this.a.a()) {
          break label407;
        }
        bnhf.d(this.a).setVisibility(8);
        return;
        if (!bnlb.j(bnhf.c(this.a).getIntent())) {
          bnhf.d(this.a).a().setImageResource(2130837691);
        }
        bnhf.d(this.a).setVisibility(0);
        bnhf.e(this.a).setVisibility(8);
        break;
        if (parambnpr == AECaptureMode.GIF)
        {
          bnhf.a(this.a).a().setImageResource(2130844481);
          bnhf.a(this.a).setVisibility(0);
          bnhf.b(this.a).a().setImageResource(2130837982);
          bnhf.d(this.a).a().setImageResource(2130837690);
          bnhf.c(this.a).setVisibility(8);
          bnhf.e(this.a).a().setImageResource(2130837692);
          bnhf.e(this.a).setVisibility(0);
          bnhf.a(this.a, 3);
          bnhf.f(this.a).setVisibility(0);
        }
        else if (parambnpr == AECaptureMode.PLAY)
        {
          bnhf.a(this.a).a().setImageResource(2130844482);
          bnhf.a(this.a).setVisibility(8);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnhh
 * JD-Core Version:    0.7.0.1
 */