import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class bmsm
  implements View.OnTouchListener
{
  bmsm(bmsl parambmsl) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      bmsl.a(this.a);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmsm
 * JD-Core Version:    0.7.0.1
 */