import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class aqpo
  implements View.OnTouchListener
{
  aqpo(aqpl paramaqpl) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return aqpl.a(this.a).onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqpo
 * JD-Core Version:    0.7.0.1
 */