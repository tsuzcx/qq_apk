import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;

class bomr
  implements View.OnTouchListener
{
  bomr(bomp parambomp) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((bomp.a(this.a) != null) && (bomp.b(this.a) != null)) {
      GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, false, bomp.b(this.a), bomp.a(this.a));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bomr
 * JD-Core Version:    0.7.0.1
 */