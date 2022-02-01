import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class amcf
  implements View.OnTouchListener
{
  amcf(amce paramamce) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      amce.a(this.a).x = ((int)paramMotionEvent.getRawX());
      amce.a(this.a).y = ((int)paramMotionEvent.getRawY());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amcf
 * JD-Core Version:    0.7.0.1
 */