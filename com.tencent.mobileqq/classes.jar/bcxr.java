import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import java.lang.ref.WeakReference;

class bcxr
  implements View.OnTouchListener
{
  bcxr(bcxp parambcxp) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.a != null)
    {
      afzq localafzq = (afzq)this.a.a.get();
      if (localafzq != null) {
        return localafzq.onTouch(paramView, paramMotionEvent);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcxr
 * JD-Core Version:    0.7.0.1
 */