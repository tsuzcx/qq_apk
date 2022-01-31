import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import java.lang.ref.WeakReference;

class azwr
  implements View.OnTouchListener
{
  azwr(azwp paramazwp) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.a != null)
    {
      aetk localaetk = (aetk)this.a.a.get();
      if (localaetk != null) {
        return localaetk.onTouch(paramView, paramMotionEvent);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azwr
 * JD-Core Version:    0.7.0.1
 */