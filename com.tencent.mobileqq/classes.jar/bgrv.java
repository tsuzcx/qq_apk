import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class bgrv
  implements View.OnTouchListener
{
  bgrv(bgrr parambgrr) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.a.d();
      return true;
    }
    if (paramMotionEvent.getAction() == 4)
    {
      this.a.d();
      return true;
    }
    return paramView.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgrv
 * JD-Core Version:    0.7.0.1
 */