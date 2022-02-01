import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import dov.com.qq.im.capture.view.CountDownView;
import dov.com.tencent.mobileqq.richmedia.capture.view.AbsAECaptureButton;

class bnca
  implements Observer<bnhq>
{
  bnca(bnbp parambnbp) {}
  
  public void a(@Nullable bnhq parambnhq)
  {
    if (parambnhq == null) {
      return;
    }
    boolean bool = parambnhq.a();
    if (bool) {
      bnbp.c(this.a);
    }
    for (;;)
    {
      bnbp.a(this.a).a(bool, new bncb(this, parambnhq));
      return;
      if (bnbp.a(this.a) != null) {
        bnbp.a(this.a).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnca
 * JD-Core Version:    0.7.0.1
 */