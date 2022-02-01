import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import java.lang.ref.WeakReference;

class bdqk
  implements View.OnTouchListener
{
  bdqk(bdqi parambdqi) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.a != null)
    {
      agjk localagjk = (agjk)this.a.a.get();
      if (localagjk != null) {
        return localagjk.onTouch(paramView, paramMotionEvent);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdqk
 * JD-Core Version:    0.7.0.1
 */