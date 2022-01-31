import android.support.v4.app.Fragment;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.multiaio.MultiAIOFragment;
import com.tencent.mobileqq.multiaio.MultiAIOItemFragment;

public class arth
  extends GestureDetector.SimpleOnGestureListener
{
  public arth(MultiAIOItemFragment paramMultiAIOItemFragment) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    Fragment localFragment = this.a.getParentFragment();
    if ((localFragment != null) && ((localFragment instanceof MultiAIOFragment))) {
      ((MultiAIOFragment)localFragment).a(this.a.getView(), paramMotionEvent);
    }
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arth
 * JD-Core Version:    0.7.0.1
 */