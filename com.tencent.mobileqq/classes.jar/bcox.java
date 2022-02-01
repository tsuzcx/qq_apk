import android.os.Build.VERSION;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;

class bcox
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  bcox(bcow parambcow) {}
  
  public void onGlobalLayout()
  {
    if (bcow.a(this.a) != null)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        bcow.a(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
      ViewGroup.LayoutParams localLayoutParams = bcow.a(this.a).getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.height = ((int)(bcow.a(this.a).getWidth() / 2.3F));
        bcow.a(this.a).requestLayout();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcox
 * JD-Core Version:    0.7.0.1
 */