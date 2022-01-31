import android.os.Build.VERSION;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;

class avya
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  avya(avxz paramavxz) {}
  
  public void onGlobalLayout()
  {
    if (avxz.a(this.a) != null)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        avxz.a(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
      ViewGroup.LayoutParams localLayoutParams = avxz.a(this.a).getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.height = ((int)(avxz.a(this.a).getWidth() / 2.3F));
        avxz.a(this.a).requestLayout();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avya
 * JD-Core Version:    0.7.0.1
 */