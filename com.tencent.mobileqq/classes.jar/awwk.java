import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import java.lang.ref.WeakReference;

class awwk
  implements View.OnTouchListener
{
  awwk(awwi paramawwi) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.a != null)
    {
      acmv localacmv = (acmv)this.a.a.get();
      if (localacmv != null) {
        return localacmv.onTouch(paramView, paramMotionEvent);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awwk
 * JD-Core Version:    0.7.0.1
 */