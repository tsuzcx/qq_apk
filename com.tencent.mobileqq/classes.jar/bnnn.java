import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.view.AECompoundButton;

class bnnn
  implements Observer<bnuq>
{
  bnnn(bnnl parambnnl) {}
  
  public void a(@Nullable bnuq parambnuq)
  {
    if (parambnuq == null) {}
    label211:
    do
    {
      return;
      parambnuq = parambnuq.b;
      if (parambnuq == AECaptureMode.NORMAL)
      {
        if (!bnqb.j(bnnl.a(this.a).getIntent())) {
          bnnl.a(this.a).a().setImageResource(2130844530);
        }
        if (bnqb.j(bnnl.b(this.a).getIntent()))
        {
          bnnl.b(this.a).setVisibility(0);
          bnnl.a(this.a).setVisibility(0);
          if (!bnqb.j(bnnl.c(this.a).getIntent())) {
            bnnl.c(this.a).a().setImageResource(2130837937);
          }
          bnnl.d(this.a).setVisibility(0);
          if (!parambnuq.getHasCountDown()) {
            break label211;
          }
          bnnl.e(this.a).setVisibility(8);
          bnnl.f(this.a).a().setImageResource(2130837930);
          bnnl.f(this.a).setVisibility(0);
          bnnl.a(this.a, 10);
        }
        for (;;)
        {
          bnnl.g(this.a).setVisibility(8);
          return;
          bnnl.b(this.a).setVisibility(8);
          break;
          if (!bnqb.j(bnnl.d(this.a).getIntent())) {
            bnnl.e(this.a).a().setImageResource(2130837668);
          }
          bnnl.e(this.a).setVisibility(0);
          bnnl.f(this.a).setVisibility(8);
        }
      }
      if (parambnuq == AECaptureMode.GIF)
      {
        bnnl.a(this.a).a().setImageResource(2130844529);
        bnnl.a(this.a).setVisibility(0);
        bnnl.c(this.a).a().setImageResource(2130837936);
        bnnl.e(this.a).a().setImageResource(2130837667);
        bnnl.d(this.a).setVisibility(8);
        bnnl.f(this.a).a().setImageResource(2130837669);
        bnnl.f(this.a).setVisibility(0);
        bnnl.a(this.a, 3);
        bnnl.g(this.a).setVisibility(0);
        return;
      }
    } while (parambnuq != AECaptureMode.PLAY);
    bnnl.a(this.a).a().setImageResource(2130844530);
    bnnl.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnnn
 * JD-Core Version:    0.7.0.1
 */