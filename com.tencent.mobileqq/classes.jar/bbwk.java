import android.os.Build.VERSION;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;

class bbwk
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  bbwk(bbwj parambbwj) {}
  
  public void onGlobalLayout()
  {
    if (bbwj.a(this.a) != null)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        bbwj.a(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
      ViewGroup.LayoutParams localLayoutParams = bbwj.a(this.a).getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.height = ((int)(bbwj.a(this.a).getWidth() / 2.3F));
        bbwj.a(this.a).requestLayout();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbwk
 * JD-Core Version:    0.7.0.1
 */