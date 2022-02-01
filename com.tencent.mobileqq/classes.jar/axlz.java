import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.multiaio.widget.MultiAIOViewPager;

public class axlz
  extends GestureDetector.SimpleOnGestureListener
{
  public axlz(MultiAIOViewPager paramMultiAIOViewPager) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (MultiAIOViewPager.a(this.a) != null) {
      this.a.performClick();
    }
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axlz
 * JD-Core Version:    0.7.0.1
 */