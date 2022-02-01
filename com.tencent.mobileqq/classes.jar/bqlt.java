import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;

class bqlt
  implements View.OnSystemUiVisibilityChangeListener
{
  bqlt(bqlj parambqlj) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if ((paramInt & 0x4) == 0)
    {
      yuk.b("EditTextDialog", "onStatusBarShow");
      this.a.getWindow().getDecorView().removeCallbacks(bqlj.a(this.a));
      this.a.getWindow().getDecorView().postDelayed(bqlj.a(this.a), 1500L);
      return;
    }
    yuk.b("EditTextDialog", "onStatusBarHide");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqlt
 * JD-Core Version:    0.7.0.1
 */