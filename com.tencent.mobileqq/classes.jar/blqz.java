import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;

class blqz
  implements View.OnTouchListener
{
  blqz(blqw paramblqw) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((blqw.a(this.a) != null) && (blqw.c(this.a) != null)) {
      GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, false, blqw.c(this.a), blqw.a(this.a));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blqz
 * JD-Core Version:    0.7.0.1
 */