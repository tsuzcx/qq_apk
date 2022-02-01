import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;

class blra
  implements View.OnTouchListener
{
  blra(blqw paramblqw) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((blqw.a(this.a) != null) && (blqw.d(this.a) != null)) {
      GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, false, blqw.d(this.a), blqw.a(this.a));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blra
 * JD-Core Version:    0.7.0.1
 */