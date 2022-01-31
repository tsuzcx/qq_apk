import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;

class bkcw
  implements View.OnSystemUiVisibilityChangeListener
{
  bkcw(bkcm parambkcm) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if ((paramInt & 0x4) == 0)
    {
      ved.b("EditTextDialog", "onStatusBarShow");
      this.a.getWindow().getDecorView().removeCallbacks(bkcm.a(this.a));
      this.a.getWindow().getDecorView().postDelayed(bkcm.a(this.a), 1500L);
      return;
    }
    ved.b("EditTextDialog", "onStatusBarHide");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkcw
 * JD-Core Version:    0.7.0.1
 */