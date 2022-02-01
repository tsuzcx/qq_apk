package androidx.recyclerview.widget;

import android.util.Log;
import android.view.animation.Interpolator;
import androidx.annotation.Nullable;
import androidx.annotation.Px;

public class RecyclerView$SmoothScroller$Action
{
  public static final int UNDEFINED_DURATION = -2147483648;
  private boolean mChanged = false;
  private int mConsecutiveUpdates = 0;
  private int mDuration;
  private int mDx;
  private int mDy;
  private Interpolator mInterpolator;
  private int mJumpToPosition = -1;
  
  public RecyclerView$SmoothScroller$Action(@Px int paramInt1, @Px int paramInt2)
  {
    this(paramInt1, paramInt2, -2147483648, null);
  }
  
  public RecyclerView$SmoothScroller$Action(@Px int paramInt1, @Px int paramInt2, int paramInt3)
  {
    this(paramInt1, paramInt2, paramInt3, null);
  }
  
  public RecyclerView$SmoothScroller$Action(@Px int paramInt1, @Px int paramInt2, int paramInt3, @Nullable Interpolator paramInterpolator)
  {
    this.mDx = paramInt1;
    this.mDy = paramInt2;
    this.mDuration = paramInt3;
    this.mInterpolator = paramInterpolator;
  }
  
  private void validate()
  {
    if ((this.mInterpolator != null) && (this.mDuration < 1)) {
      throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
    }
    if (this.mDuration < 1) {
      throw new IllegalStateException("Scroll duration must be a positive number");
    }
  }
  
  public int getDuration()
  {
    return this.mDuration;
  }
  
  @Px
  public int getDx()
  {
    return this.mDx;
  }
  
  @Px
  public int getDy()
  {
    return this.mDy;
  }
  
  @Nullable
  public Interpolator getInterpolator()
  {
    return this.mInterpolator;
  }
  
  boolean hasJumpTarget()
  {
    return this.mJumpToPosition >= 0;
  }
  
  public void jumpTo(int paramInt)
  {
    this.mJumpToPosition = paramInt;
  }
  
  void runIfNecessary(RecyclerView paramRecyclerView)
  {
    if (this.mJumpToPosition >= 0)
    {
      int i = this.mJumpToPosition;
      this.mJumpToPosition = -1;
      paramRecyclerView.jumpToPositionForSmoothScroller(i);
      this.mChanged = false;
      return;
    }
    if (this.mChanged)
    {
      validate();
      paramRecyclerView.mViewFlinger.smoothScrollBy(this.mDx, this.mDy, this.mDuration, this.mInterpolator);
      this.mConsecutiveUpdates += 1;
      if (this.mConsecutiveUpdates > 10) {
        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
      }
      this.mChanged = false;
      return;
    }
    this.mConsecutiveUpdates = 0;
  }
  
  public void setDuration(int paramInt)
  {
    this.mChanged = true;
    this.mDuration = paramInt;
  }
  
  public void setDx(@Px int paramInt)
  {
    this.mChanged = true;
    this.mDx = paramInt;
  }
  
  public void setDy(@Px int paramInt)
  {
    this.mChanged = true;
    this.mDy = paramInt;
  }
  
  public void setInterpolator(@Nullable Interpolator paramInterpolator)
  {
    this.mChanged = true;
    this.mInterpolator = paramInterpolator;
  }
  
  public void update(@Px int paramInt1, @Px int paramInt2, int paramInt3, @Nullable Interpolator paramInterpolator)
  {
    this.mDx = paramInt1;
    this.mDy = paramInt2;
    this.mDuration = paramInt3;
    this.mInterpolator = paramInterpolator;
    this.mChanged = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.SmoothScroller.Action
 * JD-Core Version:    0.7.0.1
 */