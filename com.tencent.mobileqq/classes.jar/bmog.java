import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;

class bmog
  implements View.OnSystemUiVisibilityChangeListener
{
  bmog(bmnw parambmnw) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if ((paramInt & 0x4) == 0)
    {
      wsv.b("EditTextDialog", "onStatusBarShow");
      this.a.getWindow().getDecorView().removeCallbacks(bmnw.a(this.a));
      this.a.getWindow().getDecorView().postDelayed(bmnw.a(this.a), 1500L);
      return;
    }
    wsv.b("EditTextDialog", "onStatusBarHide");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmog
 * JD-Core Version:    0.7.0.1
 */