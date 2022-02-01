import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;

class boms
  implements View.OnTouchListener
{
  boms(bomp parambomp) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((bomp.a(this.a) != null) && (bomp.c(this.a) != null)) {
      GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, false, bomp.c(this.a), bomp.a(this.a));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boms
 * JD-Core Version:    0.7.0.1
 */