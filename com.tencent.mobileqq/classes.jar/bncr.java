import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.mode.AECaptureMode;

class bncr
  implements Observer<bnpr>
{
  bncr(bncm parambncm) {}
  
  public void a(@Nullable bnpr parambnpr)
  {
    if (parambnpr == null) {}
    while (parambnpr.b != AECaptureMode.PLAY) {
      return;
    }
    bncm.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bncr
 * JD-Core Version:    0.7.0.1
 */