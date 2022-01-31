import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;

class bilk
  implements View.OnSystemUiVisibilityChangeListener
{
  bilk(bila parambila) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if ((paramInt & 0x4) == 0)
    {
      urk.b("EditTextDialog", "onStatusBarShow");
      this.a.getWindow().getDecorView().removeCallbacks(bila.a(this.a));
      this.a.getWindow().getDecorView().postDelayed(bila.a(this.a), 1500L);
      return;
    }
    urk.b("EditTextDialog", "onStatusBarHide");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bilk
 * JD-Core Version:    0.7.0.1
 */