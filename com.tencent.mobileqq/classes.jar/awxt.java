import android.os.Build.VERSION;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;

class awxt
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  awxt(awxs paramawxs) {}
  
  public void onGlobalLayout()
  {
    if (awxs.a(this.a) != null)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        awxs.a(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
      ViewGroup.LayoutParams localLayoutParams = awxs.a(this.a).getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.height = ((int)(awxs.a(this.a).getWidth() / 2.3F));
        awxs.a(this.a).requestLayout();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awxt
 * JD-Core Version:    0.7.0.1
 */