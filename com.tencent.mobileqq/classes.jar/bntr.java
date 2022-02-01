import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class bntr
  implements View.OnTouchListener
{
  bntr(bntq parambntq) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      bntq.a(this.a);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bntr
 * JD-Core Version:    0.7.0.1
 */