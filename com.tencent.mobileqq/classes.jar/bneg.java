import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;

class bneg
  implements View.OnTouchListener
{
  bneg(bnef parambnef) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((bnef.a(this.a) != null) && (bnef.a(this.a) != null)) {
      GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, false, bnef.a(this.a), bnef.a(this.a));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bneg
 * JD-Core Version:    0.7.0.1
 */