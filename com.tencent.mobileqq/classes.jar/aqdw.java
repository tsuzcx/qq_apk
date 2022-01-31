import android.os.Build.VERSION;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;

class aqdw
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  aqdw(aqdv paramaqdv) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.a.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
    aqdv.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqdw
 * JD-Core Version:    0.7.0.1
 */