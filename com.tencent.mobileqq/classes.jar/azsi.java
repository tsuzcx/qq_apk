import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import java.lang.ref.WeakReference;

class azsi
  implements View.OnTouchListener
{
  azsi(azsg paramazsg) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.a != null)
    {
      aeov localaeov = (aeov)this.a.a.get();
      if (localaeov != null) {
        return localaeov.onTouch(paramView, paramMotionEvent);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azsi
 * JD-Core Version:    0.7.0.1
 */