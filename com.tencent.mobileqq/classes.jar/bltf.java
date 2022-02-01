import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.view.AECompoundButton;

class bltf
  implements Observer<bmah>
{
  bltf(bltd parambltd) {}
  
  public void a(@Nullable bmah parambmah)
  {
    if (parambmah == null) {}
    label407:
    for (;;)
    {
      return;
      parambmah = parambmah.b;
      if (parambmah == AECaptureMode.NORMAL)
      {
        if (!blvr.j(bltd.a(this.a).getIntent())) {
          bltd.a(this.a).a().setImageResource(2130844415);
        }
        bltd.a(this.a).setVisibility(0);
        if (!blvr.j(bltd.b(this.a).getIntent())) {
          bltd.b(this.a).a().setImageResource(2130837969);
        }
        bltd.c(this.a).setVisibility(0);
        if (parambmah.getHasCountDown())
        {
          bltd.d(this.a).setVisibility(8);
          bltd.e(this.a).a().setImageResource(2130837962);
          bltd.e(this.a).setVisibility(0);
          bltd.a(this.a, 10);
          bltd.f(this.a).setVisibility(8);
        }
      }
      for (;;)
      {
        if (!this.a.a()) {
          break label407;
        }
        bltd.d(this.a).setVisibility(8);
        return;
        if (!blvr.j(bltd.c(this.a).getIntent())) {
          bltd.d(this.a).a().setImageResource(2130837676);
        }
        bltd.d(this.a).setVisibility(0);
        bltd.e(this.a).setVisibility(8);
        break;
        if (parambmah == AECaptureMode.GIF)
        {
          bltd.a(this.a).a().setImageResource(2130844414);
          bltd.a(this.a).setVisibility(0);
          bltd.b(this.a).a().setImageResource(2130837968);
          bltd.d(this.a).a().setImageResource(2130837675);
          bltd.c(this.a).setVisibility(8);
          bltd.e(this.a).a().setImageResource(2130837677);
          bltd.e(this.a).setVisibility(0);
          bltd.a(this.a, 3);
          bltd.f(this.a).setVisibility(0);
        }
        else if (parambmah == AECaptureMode.PLAY)
        {
          bltd.a(this.a).a().setImageResource(2130844415);
          bltd.a(this.a).setVisibility(8);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bltf
 * JD-Core Version:    0.7.0.1
 */