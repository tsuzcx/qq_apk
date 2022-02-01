import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import dov.com.qq.im.ae.mode.AECaptureMode;

class bomu
  implements Observer<bowc>
{
  bomu(bomp parambomp) {}
  
  public void a(@Nullable bowc parambowc)
  {
    if (parambowc == null) {
      return;
    }
    parambowc = parambowc.b;
    bomp.a(this.a, parambowc);
    if (parambowc == AECaptureMode.GIF)
    {
      bomp.a(this.a);
      bomp.a(this.a).setVisibility(0);
    }
    for (;;)
    {
      bomp.a(this.a, parambowc);
      bomp.b(this.a, parambowc);
      return;
      if (bomp.a(this.a)) {
        bomp.a(this.a).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bomu
 * JD-Core Version:    0.7.0.1
 */