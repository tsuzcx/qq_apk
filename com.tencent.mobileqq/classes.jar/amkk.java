import android.app.Activity;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.colornote.swipeback.SwipeBackLayout;

public class amkk
  extends GestureDetector.SimpleOnGestureListener
{
  public amkk(SwipeBackLayout paramSwipeBackLayout) {}
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    float f1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
    float f2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / f1);
    if ((!this.a.jdField_a_of_type_Boolean) || (paramFloat1 < 200.0F)) {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    if ((f1 < 0.0F) && (f2 < 0.5F))
    {
      if (!(this.a.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        break label126;
      }
      this.a.c = true;
      this.a.d();
    }
    for (;;)
    {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      label126:
      this.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amkk
 * JD-Core Version:    0.7.0.1
 */