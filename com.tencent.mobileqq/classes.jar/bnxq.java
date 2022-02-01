import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class bnxq
  implements View.OnTouchListener
{
  bnxq(bnxm parambnxm) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnxq
 * JD-Core Version:    0.7.0.1
 */