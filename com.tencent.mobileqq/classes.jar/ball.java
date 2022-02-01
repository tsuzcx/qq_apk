import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.SeekBar;

class ball
  implements View.OnTouchListener
{
  ball(balk parambalk) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    float f1 = 0.0F;
    paramView = new Rect();
    this.a.a.getHitRect(paramView);
    if ((paramMotionEvent.getY() >= paramView.top - 600) && (paramMotionEvent.getY() <= paramView.bottom + 600)) {}
    for (int i = 1; i == 0; i = 0) {
      return false;
    }
    float f3 = paramView.top + (paramView.height() >> 1);
    float f2 = paramMotionEvent.getX() - paramView.left;
    if (f2 < 0.0F) {}
    for (;;)
    {
      paramView = MotionEvent.obtain(paramMotionEvent.getDownTime(), paramMotionEvent.getEventTime(), paramMotionEvent.getAction(), f1, f3, paramMotionEvent.getMetaState());
      boolean bool = this.a.a.onTouchEvent(paramView);
      paramView.recycle();
      return bool;
      if (f2 > paramView.width()) {
        f1 = paramView.width();
      } else {
        f1 = f2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ball
 * JD-Core Version:    0.7.0.1
 */