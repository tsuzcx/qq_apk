import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;

class bmss
  implements View.OnSystemUiVisibilityChangeListener
{
  bmss(bmsi parambmsi) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if ((paramInt & 0x4) == 0)
    {
      wxe.b("EditTextDialog", "onStatusBarShow");
      this.a.getWindow().getDecorView().removeCallbacks(bmsi.a(this.a));
      this.a.getWindow().getDecorView().postDelayed(bmsi.a(this.a), 1500L);
      return;
    }
    wxe.b("EditTextDialog", "onStatusBarHide");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmss
 * JD-Core Version:    0.7.0.1
 */