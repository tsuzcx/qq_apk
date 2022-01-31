import android.os.Build.VERSION;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;

class awxv
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  awxv(awxu paramawxu) {}
  
  public void onGlobalLayout()
  {
    if (awxu.a(this.a) != null)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        awxu.a(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
      ViewGroup.LayoutParams localLayoutParams = awxu.a(this.a).getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.height = ((int)(awxu.a(this.a).getWidth() / 2.3F));
        awxu.a(this.a).requestLayout();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awxv
 * JD-Core Version:    0.7.0.1
 */