import android.view.View;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager.LayoutParams;
import com.tencent.widget.BubblePopupWindow;
import java.lang.ref.WeakReference;

public class blai
  implements ViewTreeObserver.OnScrollChangedListener
{
  public blai(BubblePopupWindow paramBubblePopupWindow) {}
  
  public void onScrollChanged()
  {
    if (BubblePopupWindow.a(this.a) != null) {}
    WindowManager.LayoutParams localLayoutParams;
    for (View localView = (View)BubblePopupWindow.a(this.a).get();; localView = null)
    {
      if ((localView != null) && (BubblePopupWindow.a(this.a) != null))
      {
        localLayoutParams = (WindowManager.LayoutParams)BubblePopupWindow.a(this.a).getLayoutParams();
        if (localLayoutParams != null) {
          break;
        }
      }
      return;
    }
    BubblePopupWindow.a(this.a, localView, localLayoutParams, BubblePopupWindow.a(this.a), BubblePopupWindow.b(this.a));
    this.a.a(localLayoutParams.x, localLayoutParams.y, -1, -1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blai
 * JD-Core Version:    0.7.0.1
 */