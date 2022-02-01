import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;

class boxx
  implements View.OnSystemUiVisibilityChangeListener
{
  boxx(boxn paramboxn) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if ((paramInt & 0x4) == 0)
    {
      ykq.b("EditTextDialog", "onStatusBarShow");
      this.a.getWindow().getDecorView().removeCallbacks(boxn.a(this.a));
      this.a.getWindow().getDecorView().postDelayed(boxn.a(this.a), 1500L);
      return;
    }
    ykq.b("EditTextDialog", "onStatusBarHide");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boxx
 * JD-Core Version:    0.7.0.1
 */