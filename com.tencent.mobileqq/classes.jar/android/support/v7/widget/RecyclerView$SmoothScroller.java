package android.support.v7.widget;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

public abstract class RecyclerView$SmoothScroller
{
  private RecyclerView.LayoutManager mLayoutManager;
  private boolean mPendingInitialRun;
  private RecyclerView mRecyclerView;
  private final RecyclerView.SmoothScroller.Action mRecyclingAction = new RecyclerView.SmoothScroller.Action(0, 0);
  private boolean mRunning;
  private int mTargetPosition = -1;
  private View mTargetView;
  
  private void onAnimation(int paramInt1, int paramInt2)
  {
    RecyclerView localRecyclerView = this.mRecyclerView;
    if ((!this.mRunning) || (this.mTargetPosition == -1) || (localRecyclerView == null)) {
      stop();
    }
    this.mPendingInitialRun = false;
    View localView = this.mTargetView;
    if (localView != null) {
      if (getChildPosition(localView) == this.mTargetPosition)
      {
        onTargetFound(this.mTargetView, localRecyclerView.mState, this.mRecyclingAction);
        RecyclerView.SmoothScroller.Action.access$6200(this.mRecyclingAction, localRecyclerView);
        stop();
      }
      else
      {
        Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
        this.mTargetView = null;
      }
    }
    if (this.mRunning)
    {
      onSeekTargetStep(paramInt1, paramInt2, localRecyclerView.mState, this.mRecyclingAction);
      boolean bool = this.mRecyclingAction.hasJumpTarget();
      RecyclerView.SmoothScroller.Action.access$6200(this.mRecyclingAction, localRecyclerView);
      if (bool)
      {
        if (this.mRunning)
        {
          this.mPendingInitialRun = true;
          RecyclerView.access$6000(localRecyclerView).postOnAnimation();
          return;
        }
        stop();
      }
    }
  }
  
  public View findViewByPosition(int paramInt)
  {
    return this.mRecyclerView.mLayout.findViewByPosition(paramInt);
  }
  
  public int getChildCount()
  {
    return this.mRecyclerView.mLayout.getChildCount();
  }
  
  public int getChildPosition(View paramView)
  {
    return this.mRecyclerView.getChildLayoutPosition(paramView);
  }
  
  @Nullable
  public RecyclerView.LayoutManager getLayoutManager()
  {
    return this.mLayoutManager;
  }
  
  public int getTargetPosition()
  {
    return this.mTargetPosition;
  }
  
  @Deprecated
  public void instantScrollToPosition(int paramInt)
  {
    this.mRecyclerView.scrollToPosition(paramInt);
  }
  
  public boolean isPendingInitialRun()
  {
    return this.mPendingInitialRun;
  }
  
  public boolean isRunning()
  {
    return this.mRunning;
  }
  
  protected void normalize(PointF paramPointF)
  {
    double d1 = Math.sqrt(paramPointF.x * paramPointF.x + paramPointF.y * paramPointF.y);
    double d2 = paramPointF.x;
    Double.isNaN(d2);
    paramPointF.x = ((float)(d2 / d1));
    d2 = paramPointF.y;
    Double.isNaN(d2);
    paramPointF.y = ((float)(d2 / d1));
  }
  
  protected void onChildAttachedToWindow(View paramView)
  {
    if (getChildPosition(paramView) == getTargetPosition()) {
      this.mTargetView = paramView;
    }
  }
  
  protected abstract void onSeekTargetStep(int paramInt1, int paramInt2, RecyclerView.State paramState, RecyclerView.SmoothScroller.Action paramAction);
  
  protected abstract void onStart();
  
  protected abstract void onStop();
  
  protected abstract void onTargetFound(View paramView, RecyclerView.State paramState, RecyclerView.SmoothScroller.Action paramAction);
  
  public void setTargetPosition(int paramInt)
  {
    this.mTargetPosition = paramInt;
  }
  
  void start(RecyclerView paramRecyclerView, RecyclerView.LayoutManager paramLayoutManager)
  {
    this.mRecyclerView = paramRecyclerView;
    this.mLayoutManager = paramLayoutManager;
    if (this.mTargetPosition != -1)
    {
      RecyclerView.State.access$5902(this.mRecyclerView.mState, this.mTargetPosition);
      this.mRunning = true;
      this.mPendingInitialRun = true;
      this.mTargetView = findViewByPosition(getTargetPosition());
      onStart();
      RecyclerView.access$6000(this.mRecyclerView).postOnAnimation();
      return;
    }
    throw new IllegalArgumentException("Invalid target position");
  }
  
  protected final void stop()
  {
    if (!this.mRunning) {
      return;
    }
    onStop();
    RecyclerView.State.access$5902(this.mRecyclerView.mState, -1);
    this.mTargetView = null;
    this.mTargetPosition = -1;
    this.mPendingInitialRun = false;
    this.mRunning = false;
    RecyclerView.LayoutManager.access$6100(this.mLayoutManager, this);
    this.mLayoutManager = null;
    this.mRecyclerView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.SmoothScroller
 * JD-Core Version:    0.7.0.1
 */