import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.multicard.MultiCardPageIndicator;
import com.tencent.qphone.base.util.QLog;

public class aunw
  extends GestureDetector.SimpleOnGestureListener
{
  public aunw(MultiCardPageIndicator paramMultiCardPageIndicator) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TabPageIndicator", 2, "onSingleTapConfirmed() called with: e = [" + paramMotionEvent + "]");
    }
    if (MultiCardPageIndicator.a(this.a) != null) {
      this.a.performClick();
    }
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aunw
 * JD-Core Version:    0.7.0.1
 */