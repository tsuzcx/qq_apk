package androidx.viewpager2.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;

final class FakeDrag
{
  private int mActualDraggedDistance;
  private long mFakeDragBeginTime;
  private int mMaximumVelocity;
  private final RecyclerView mRecyclerView;
  private float mRequestedDragDistance;
  private final ScrollEventAdapter mScrollEventAdapter;
  private VelocityTracker mVelocityTracker;
  private final ViewPager2 mViewPager;
  
  FakeDrag(ViewPager2 paramViewPager2, ScrollEventAdapter paramScrollEventAdapter, RecyclerView paramRecyclerView)
  {
    this.mViewPager = paramViewPager2;
    this.mScrollEventAdapter = paramScrollEventAdapter;
    this.mRecyclerView = paramRecyclerView;
  }
  
  private void addFakeMotionEvent(long paramLong, int paramInt, float paramFloat1, float paramFloat2)
  {
    MotionEvent localMotionEvent = MotionEvent.obtain(this.mFakeDragBeginTime, paramLong, paramInt, paramFloat1, paramFloat2, 0);
    this.mVelocityTracker.addMovement(localMotionEvent);
    localMotionEvent.recycle();
  }
  
  private void beginFakeVelocityTracker()
  {
    VelocityTracker localVelocityTracker = this.mVelocityTracker;
    if (localVelocityTracker == null)
    {
      this.mVelocityTracker = VelocityTracker.obtain();
      this.mMaximumVelocity = ViewConfiguration.get(this.mViewPager.getContext()).getScaledMaximumFlingVelocity();
      return;
    }
    localVelocityTracker.clear();
  }
  
  @UiThread
  boolean beginFakeDrag()
  {
    if (this.mScrollEventAdapter.isDragging()) {
      return false;
    }
    this.mActualDraggedDistance = 0;
    this.mRequestedDragDistance = 0;
    this.mFakeDragBeginTime = SystemClock.uptimeMillis();
    beginFakeVelocityTracker();
    this.mScrollEventAdapter.notifyBeginFakeDrag();
    if (!this.mScrollEventAdapter.isIdle()) {
      this.mRecyclerView.stopScroll();
    }
    addFakeMotionEvent(this.mFakeDragBeginTime, 0, 0.0F, 0.0F);
    return true;
  }
  
  @UiThread
  boolean endFakeDrag()
  {
    if (!this.mScrollEventAdapter.isFakeDragging()) {
      return false;
    }
    this.mScrollEventAdapter.notifyEndFakeDrag();
    VelocityTracker localVelocityTracker = this.mVelocityTracker;
    localVelocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
    int i = (int)localVelocityTracker.getXVelocity();
    int j = (int)localVelocityTracker.getYVelocity();
    if (!this.mRecyclerView.fling(i, j)) {
      this.mViewPager.snapToPage();
    }
    return true;
  }
  
  @UiThread
  boolean fakeDragBy(float paramFloat)
  {
    if (!this.mScrollEventAdapter.isFakeDragging()) {
      return false;
    }
    this.mRequestedDragDistance -= paramFloat;
    int i = Math.round(this.mRequestedDragDistance - this.mActualDraggedDistance);
    this.mActualDraggedDistance += i;
    long l = SystemClock.uptimeMillis();
    int j;
    if (this.mViewPager.getOrientation() == 0) {
      j = 1;
    } else {
      j = 0;
    }
    int k;
    if (j != 0) {
      k = i;
    } else {
      k = 0;
    }
    if (j != 0) {
      i = 0;
    }
    if (j != 0) {
      paramFloat = this.mRequestedDragDistance;
    } else {
      paramFloat = 0.0F;
    }
    float f;
    if (j != 0) {
      f = 0.0F;
    } else {
      f = this.mRequestedDragDistance;
    }
    this.mRecyclerView.scrollBy(k, i);
    addFakeMotionEvent(l, 2, paramFloat, f);
    return true;
  }
  
  boolean isFakeDragging()
  {
    return this.mScrollEventAdapter.isFakeDragging();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.viewpager2.widget.FakeDrag
 * JD-Core Version:    0.7.0.1
 */