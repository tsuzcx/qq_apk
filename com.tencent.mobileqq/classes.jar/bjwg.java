import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import java.util.List;

class bjwg
  implements RecyclerView.OnItemTouchListener
{
  bjwg(bjwf parambjwf) {}
  
  public boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    this.a.mGestureDetector.a(paramMotionEvent);
    int i = paramMotionEvent.getActionMasked();
    if (i == 0)
    {
      this.a.mActivePointerId = paramMotionEvent.getPointerId(0);
      this.a.mInitialTouchX = paramMotionEvent.getX();
      this.a.mInitialTouchY = paramMotionEvent.getY();
      this.a.obtainVelocityTracker();
      if (this.a.mSelected == null)
      {
        paramRecyclerView = this.a.findAnimation(paramMotionEvent);
        if (paramRecyclerView != null)
        {
          bjwf localbjwf = this.a;
          localbjwf.mInitialTouchX -= paramRecyclerView.e;
          localbjwf = this.a;
          localbjwf.mInitialTouchY -= paramRecyclerView.f;
          this.a.endRecoverAnimation(paramRecyclerView.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder, true);
          if (this.a.mPendingCleanup.remove(paramRecyclerView.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder.itemView)) {
            this.a.mCallback.clearView(this.a.mRecyclerView, paramRecyclerView.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
          }
          this.a.select(paramRecyclerView.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder, paramRecyclerView.jdField_b_of_type_Int);
          this.a.updateDxDy(paramMotionEvent, this.a.mSelectedFlags, 0);
        }
      }
    }
    for (;;)
    {
      if (this.a.mVelocityTracker != null) {
        this.a.mVelocityTracker.addMovement(paramMotionEvent);
      }
      if (this.a.mSelected == null) {
        break;
      }
      return true;
      if ((i == 3) || (i == 1))
      {
        this.a.mActivePointerId = -1;
        this.a.select(null, 0);
      }
      else if (this.a.mActivePointerId != -1)
      {
        int j = paramMotionEvent.findPointerIndex(this.a.mActivePointerId);
        if (j >= 0) {
          this.a.checkSelectForSwipe(i, paramMotionEvent, j);
        }
      }
    }
    return false;
  }
  
  public void onRequestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    this.a.select(null, 0);
  }
  
  public void onTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    int i = 0;
    this.a.mGestureDetector.a(paramMotionEvent);
    if (this.a.mVelocityTracker != null) {
      this.a.mVelocityTracker.addMovement(paramMotionEvent);
    }
    if (this.a.mActivePointerId == -1) {}
    int j;
    do
    {
      int k;
      do
      {
        return;
        j = paramMotionEvent.getActionMasked();
        k = paramMotionEvent.findPointerIndex(this.a.mActivePointerId);
        if (k >= 0) {
          this.a.checkSelectForSwipe(j, paramMotionEvent, k);
        }
        paramRecyclerView = this.a.mSelected;
      } while (paramRecyclerView == null);
      switch (j)
      {
      case 4: 
      case 5: 
      default: 
        return;
      case 1: 
      case 2: 
      case 3: 
        for (;;)
        {
          this.a.select(null, 0);
          this.a.mActivePointerId = -1;
          return;
          if (k < 0) {
            break;
          }
          this.a.updateDxDy(paramMotionEvent, this.a.mSelectedFlags, k);
          this.a.moveIfNecessary(paramRecyclerView);
          this.a.mRecyclerView.removeCallbacks(this.a.mScrollRunnable);
          this.a.mScrollRunnable.run();
          this.a.mRecyclerView.invalidate();
          return;
          if (this.a.mVelocityTracker != null) {
            this.a.mVelocityTracker.clear();
          }
        }
      }
      j = paramMotionEvent.getActionIndex();
    } while (paramMotionEvent.getPointerId(j) != this.a.mActivePointerId);
    if (j == 0) {
      i = 1;
    }
    this.a.mActivePointerId = paramMotionEvent.getPointerId(i);
    this.a.updateDxDy(paramMotionEvent, this.a.mSelectedFlags, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjwg
 * JD-Core Version:    0.7.0.1
 */