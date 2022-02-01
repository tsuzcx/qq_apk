import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import dov.com.qq.im.ae.mode.AECaptureMode;

class blrb
  implements Observer<bmah>
{
  blrb(blqw paramblqw) {}
  
  public void a(@Nullable bmah parambmah)
  {
    if (parambmah == null)
    {
      bmbx.d("VideoStoryCapturePart", "modeChangingEvent is null, return");
      return;
    }
    parambmah = parambmah.b;
    blqw.a(this.a, parambmah);
    if (parambmah == AECaptureMode.GIF)
    {
      blqw.a(this.a);
      blqw.a(this.a).setVisibility(0);
    }
    for (;;)
    {
      blqw.a(this.a, parambmah);
      blqw.b(this.a, parambmah);
      return;
      if (blqw.a(this.a)) {
        blqw.a(this.a).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blrb
 * JD-Core Version:    0.7.0.1
 */