import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;

class bkcf
  implements View.OnSystemUiVisibilityChangeListener
{
  bkcf(bkbv parambkbv) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if ((paramInt & 0x4) == 0)
    {
      veg.b("EditTextDialog", "onStatusBarShow");
      this.a.getWindow().getDecorView().removeCallbacks(bkbv.a(this.a));
      this.a.getWindow().getDecorView().postDelayed(bkbv.a(this.a), 1500L);
      return;
    }
    veg.b("EditTextDialog", "onStatusBarHide");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkcf
 * JD-Core Version:    0.7.0.1
 */