package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;

public abstract class RecyclerView$SmoothScroller
{
  private RecyclerView.LayoutManager mLayoutManager;
  private boolean mPendingInitialRun;
  private RecyclerView mRecyclerView;
  private final RecyclerView.SmoothScroller.Action mRecyclingAction = new RecyclerView.SmoothScroller.Action(0, 0);
  private boolean mRunning;
  private boolean mStarted;
  private int mTargetPosition = -1;
  private View mTargetView;
  
  @Nullable
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    Object localObject = getLayoutManager();
    if ((localObject instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
      return ((RecyclerView.SmoothScroller.ScrollVectorProvider)localObject).computeScrollVectorForPosition(paramInt);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("You should override computeScrollVectorForPosition when the LayoutManager does not implement ");
    ((StringBuilder)localObject).append(RecyclerView.SmoothScroller.ScrollVectorProvider.class.getCanonicalName());
    Log.w("RecyclerView", ((StringBuilder)localObject).toString());
    return null;
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
  
  protected void normalize(@NonNull PointF paramPointF)
  {
    float f = (float)Math.sqrt(paramPointF.x * paramPointF.x + paramPointF.y * paramPointF.y);
    paramPointF.x /= f;
    paramPointF.y /= f;
  }
  
  void onAnimation(int paramInt1, int paramInt2)
  {
    RecyclerView localRecyclerView = this.mRecyclerView;
    if ((this.mTargetPosition == -1) || (localRecyclerView == null)) {
      stop();
    }
    if ((this.mPendingInitialRun) && (this.mTargetView == null) && (this.mLayoutManager != null))
    {
      localObject = computeScrollVectorForPosition(this.mTargetPosition);
      if ((localObject != null) && ((((PointF)localObject).x != 0.0F) || (((PointF)localObject).y != 0.0F))) {
        localRecyclerView.scrollStep((int)Math.signum(((PointF)localObject).x), (int)Math.signum(((PointF)localObject).y), null);
      }
    }
    this.mPendingInitialRun = false;
    Object localObject = this.mTargetView;
    if (localObject != null) {
      if (getChildPosition((View)localObject) == this.mTargetPosition)
      {
        onTargetFound(this.mTargetView, localRecyclerView.mState, this.mRecyclingAction);
        this.mRecyclingAction.runIfNecessary(localRecyclerView);
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
      this.mRecyclingAction.runIfNecessary(localRecyclerView);
      if ((bool) && (this.mRunning))
      {
        this.mPendingInitialRun = true;
        localRecyclerView.mViewFlinger.postOnAnimation();
      }
    }
  }
  
  protected void onChildAttachedToWindow(View paramView)
  {
    if (getChildPosition(paramView) == getTargetPosition()) {
      this.mTargetView = paramView;
    }
  }
  
  protected abstract void onSeekTargetStep(@Px int paramInt1, @Px int paramInt2, @NonNull RecyclerView.State paramState, @NonNull RecyclerView.SmoothScroller.Action paramAction);
  
  protected abstract void onStart();
  
  protected abstract void onStop();
  
  protected abstract void onTargetFound(@NonNull View paramView, @NonNull RecyclerView.State paramState, @NonNull RecyclerView.SmoothScroller.Action paramAction);
  
  public void setTargetPosition(int paramInt)
  {
    this.mTargetPosition = paramInt;
  }
  
  void start(RecyclerView paramRecyclerView, RecyclerView.LayoutManager paramLayoutManager)
  {
    paramRecyclerView.mViewFlinger.stop();
    if (this.mStarted)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("An instance of ");
      localStringBuilder.append(getClass().getSimpleName());
      localStringBuilder.append(" was started more than once. Each instance of");
      localStringBuilder.append(getClass().getSimpleName());
      localStringBuilder.append(" is intended to only be used once. You should create a new instance for each use.");
      Log.w("RecyclerView", localStringBuilder.toString());
    }
    this.mRecyclerView = paramRecyclerView;
    this.mLayoutManager = paramLayoutManager;
    if (this.mTargetPosition != -1)
    {
      this.mRecyclerView.mState.mTargetPosition = this.mTargetPosition;
      this.mRunning = true;
      this.mPendingInitialRun = true;
      this.mTargetView = findViewByPosition(getTargetPosition());
      onStart();
      this.mRecyclerView.mViewFlinger.postOnAnimation();
      this.mStarted = true;
      return;
    }
    throw new IllegalArgumentException("Invalid target position");
  }
  
  protected final void stop()
  {
    if (!this.mRunning) {
      return;
    }
    this.mRunning = false;
    onStop();
    this.mRecyclerView.mState.mTargetPosition = -1;
    this.mTargetView = null;
    this.mTargetPosition = -1;
    this.mPendingInitialRun = false;
    this.mLayoutManager.onSmoothScrollerStopped(this);
    this.mLayoutManager = null;
    this.mRecyclerView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.SmoothScroller
 * JD-Core Version:    0.7.0.1
 */