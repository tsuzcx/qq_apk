import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;

class bpjy
  implements View.OnSystemUiVisibilityChangeListener
{
  bpjy(bpjo parambpjo) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if ((paramInt & 0x4) == 0)
    {
      yqp.b("EditTextDialog", "onStatusBarShow");
      this.a.getWindow().getDecorView().removeCallbacks(bpjo.a(this.a));
      this.a.getWindow().getDecorView().postDelayed(bpjo.a(this.a), 1500L);
      return;
    }
    yqp.b("EditTextDialog", "onStatusBarHide");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpjy
 * JD-Core Version:    0.7.0.1
 */