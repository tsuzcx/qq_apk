import android.os.Build.VERSION;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;

class bcpd
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  bcpd(bcpc parambcpc) {}
  
  public void onGlobalLayout()
  {
    if (bcpc.a(this.a) != null)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        bcpc.a(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
      ViewGroup.LayoutParams localLayoutParams = bcpc.a(this.a).getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.height = ((int)(bcpc.a(this.a).getWidth() / 2.3F));
        bcpc.a(this.a).requestLayout();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcpd
 * JD-Core Version:    0.7.0.1
 */