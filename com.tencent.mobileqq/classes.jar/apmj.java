import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class apmj
  extends GestureDetector.SimpleOnGestureListener
{
  apmj(apmh paramapmh) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    apmh.a(this.a);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apmj
 * JD-Core Version:    0.7.0.1
 */