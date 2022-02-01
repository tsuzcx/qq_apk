import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class blcu
  implements View.OnTouchListener
{
  blcu(blcs paramblcs) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getAction() == 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blcu
 * JD-Core Version:    0.7.0.1
 */