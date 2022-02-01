import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import java.lang.ref.WeakReference;

class bdpt
  implements View.OnTouchListener
{
  bdpt(bdpr parambdpr) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.a != null)
    {
      aftk localaftk = (aftk)this.a.a.get();
      if (localaftk != null) {
        return localaftk.onTouch(paramView, paramMotionEvent);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdpt
 * JD-Core Version:    0.7.0.1
 */