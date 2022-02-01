import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.widget.bounce.BounceViewPager;

public class bivc
  extends GestureDetector.SimpleOnGestureListener
{
  public bivc(BounceViewPager paramBounceViewPager) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1) > Math.abs(paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bivc
 * JD-Core Version:    0.7.0.1
 */