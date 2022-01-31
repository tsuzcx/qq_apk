import android.os.Build.VERSION;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;

class ayxh
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ayxh(ayxg paramayxg) {}
  
  public void onGlobalLayout()
  {
    if (ayxg.a(this.a) != null)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        ayxg.a(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
      ViewGroup.LayoutParams localLayoutParams = ayxg.a(this.a).getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.height = ((int)(ayxg.a(this.a).getWidth() / 2.3F));
        ayxg.a(this.a).requestLayout();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayxh
 * JD-Core Version:    0.7.0.1
 */