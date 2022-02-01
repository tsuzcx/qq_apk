import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class apmk
  implements View.OnTouchListener
{
  apmk(apmh paramapmh) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return apmh.a(this.a).onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apmk
 * JD-Core Version:    0.7.0.1
 */