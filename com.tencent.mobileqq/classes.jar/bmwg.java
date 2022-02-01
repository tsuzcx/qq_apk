import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class bmwg
  implements View.OnTouchListener
{
  bmwg(bmwe parambmwe) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getAction() == 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmwg
 * JD-Core Version:    0.7.0.1
 */