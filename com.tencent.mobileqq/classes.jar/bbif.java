import android.os.Build.VERSION;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;

class bbif
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  bbif(bbie parambbie) {}
  
  public void onGlobalLayout()
  {
    if (bbie.a(this.a) != null)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        bbie.a(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
      ViewGroup.LayoutParams localLayoutParams = bbie.a(this.a).getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.height = ((int)(bbie.a(this.a).getWidth() / 2.3F));
        bbie.a(this.a).requestLayout();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbif
 * JD-Core Version:    0.7.0.1
 */