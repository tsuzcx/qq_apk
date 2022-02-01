import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import dov.com.qq.im.ae.mode.AECaptureMode;

class bnlh
  implements Observer<bnuq>
{
  bnlh(bnlc parambnlc) {}
  
  public void a(@Nullable bnuq parambnuq)
  {
    if (parambnuq == null) {
      return;
    }
    parambnuq = parambnuq.b;
    bnlc.a(this.a, parambnuq);
    if (parambnuq == AECaptureMode.GIF)
    {
      bnlc.a(this.a);
      bnlc.a(this.a).setVisibility(0);
    }
    for (;;)
    {
      bnlc.a(this.a, parambnuq);
      bnlc.b(this.a, parambnuq);
      return;
      if (bnlc.a(this.a)) {
        bnlc.a(this.a).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnlh
 * JD-Core Version:    0.7.0.1
 */