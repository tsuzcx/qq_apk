import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;

class bnif
  implements View.OnSystemUiVisibilityChangeListener
{
  bnif(bnhv parambnhv) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if ((paramInt & 0x4) == 0)
    {
      xvv.b("EditTextDialog", "onStatusBarShow");
      this.a.getWindow().getDecorView().removeCallbacks(bnhv.a(this.a));
      this.a.getWindow().getDecorView().postDelayed(bnhv.a(this.a), 1500L);
      return;
    }
    xvv.b("EditTextDialog", "onStatusBarHide");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnif
 * JD-Core Version:    0.7.0.1
 */