import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.widget.BounceScrollView;

public class bimc
  extends GestureDetector.SimpleOnGestureListener
{
  public bimc(BounceScrollView paramBounceScrollView) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat2) >= Math.abs(paramFloat1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bimc
 * JD-Core Version:    0.7.0.1
 */