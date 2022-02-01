import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import dov.com.qq.im.capture.view.CountDownView;
import dov.com.tencent.mobileqq.richmedia.capture.view.AbsAECaptureButton;

class blop
  implements Observer<bltn>
{
  blop(bloe parambloe) {}
  
  public void a(@Nullable bltn parambltn)
  {
    if (parambltn == null) {
      return;
    }
    boolean bool = parambltn.a();
    if (bool) {
      bloe.c(this.a);
    }
    for (;;)
    {
      bloe.a(this.a).a(bool, new bloq(this, parambltn));
      return;
      if (bloe.a(this.a) != null) {
        bloe.a(this.a).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blop
 * JD-Core Version:    0.7.0.1
 */