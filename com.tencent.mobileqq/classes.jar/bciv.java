import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import java.lang.ref.WeakReference;

class bciv
  implements View.OnTouchListener
{
  bciv(bcit parambcit) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.a.a != null)
    {
      afce localafce = (afce)this.a.a.get();
      if (localafce != null) {
        return localafce.onTouch(paramView, paramMotionEvent);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bciv
 * JD-Core Version:    0.7.0.1
 */