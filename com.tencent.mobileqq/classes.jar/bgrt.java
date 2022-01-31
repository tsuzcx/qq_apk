import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class bgrt
  implements View.OnTouchListener
{
  bgrt(bgrr parambgrr) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getAction() == 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgrt
 * JD-Core Version:    0.7.0.1
 */