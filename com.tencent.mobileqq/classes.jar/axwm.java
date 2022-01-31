import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import java.lang.ref.WeakReference;

class axwm
  implements View.OnTouchListener
{
  axwm(axwk paramaxwk) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.a != null)
    {
      acxn localacxn = (acxn)this.a.a.get();
      if (localacxn != null) {
        return localacxn.onTouch(paramView, paramMotionEvent);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axwm
 * JD-Core Version:    0.7.0.1
 */