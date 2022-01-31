import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.multiaio.widget.MultiAIOViewPager;

public class aruo
  extends GestureDetector.SimpleOnGestureListener
{
  public aruo(MultiAIOViewPager paramMultiAIOViewPager) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (MultiAIOViewPager.a(this.a) != null) {
      this.a.performClick();
    }
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aruo
 * JD-Core Version:    0.7.0.1
 */