import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

class bjpe
  implements GestureDetector.OnGestureListener
{
  private bjpe(bjoz parambjoz) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    paramMotionEvent2.getX();
    paramMotionEvent1.getX();
    paramMotionEvent1.getX();
    paramMotionEvent2.getX();
    paramFloat1 = paramMotionEvent2.getY();
    float f = paramMotionEvent1.getY();
    paramMotionEvent1.getY();
    paramMotionEvent2.getY();
    if ((paramFloat1 - f > 120) && (Math.abs(paramFloat2) > 20)) {
      this.a.l();
    }
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjpe
 * JD-Core Version:    0.7.0.1
 */