import android.os.Build.VERSION;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;

class aysy
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  aysy(aysx paramaysx) {}
  
  public void onGlobalLayout()
  {
    if (aysx.a(this.a) != null)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        aysx.a(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
      ViewGroup.LayoutParams localLayoutParams = aysx.a(this.a).getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.height = ((int)(aysx.a(this.a).getWidth() / 2.3F));
        aysx.a(this.a).requestLayout();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aysy
 * JD-Core Version:    0.7.0.1
 */