import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import java.lang.ref.WeakReference;

class axwo
  implements View.OnTouchListener
{
  axwo(axwm paramaxwm) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.a != null)
    {
      acxj localacxj = (acxj)this.a.a.get();
      if (localacxj != null) {
        return localacxj.onTouch(paramView, paramMotionEvent);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axwo
 * JD-Core Version:    0.7.0.1
 */