import android.os.Build.VERSION;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;

class aqdy
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  aqdy(aqdx paramaqdx) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.a.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
    aqdx.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqdy
 * JD-Core Version:    0.7.0.1
 */