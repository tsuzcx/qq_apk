import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import dov.com.qq.im.ae.mode.AECaptureMode;

class bnek
  implements Observer<bnpr>
{
  bnek(bnef parambnef) {}
  
  public void a(@Nullable bnpr parambnpr)
  {
    if (parambnpr == null)
    {
      bnrh.d("VideoStoryCapturePart", "modeChangingEvent is null, return");
      return;
    }
    parambnpr = parambnpr.b;
    bnef.a(this.a, parambnpr);
    if (parambnpr == AECaptureMode.GIF)
    {
      bnef.a(this.a);
      bnef.a(this.a).setVisibility(0);
    }
    for (;;)
    {
      bnef.a(this.a, parambnpr);
      bnef.b(this.a, parambnpr);
      return;
      if (bnef.a(this.a)) {
        bnef.a(this.a).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnek
 * JD-Core Version:    0.7.0.1
 */