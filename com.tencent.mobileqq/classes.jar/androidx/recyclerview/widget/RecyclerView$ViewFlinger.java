package androidx.recyclerview.widget;

import android.os.Build.VERSION;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;

class RecyclerView$ViewFlinger
  implements Runnable
{
  private boolean mEatRunOnAnimationRequest = false;
  Interpolator mInterpolator = RecyclerView.sQuinticInterpolator;
  private int mLastFlingX;
  private int mLastFlingY;
  OverScroller mOverScroller;
  private boolean mReSchedulePostAnimationCallback = false;
  
  RecyclerView$ViewFlinger(RecyclerView paramRecyclerView)
  {
    this.mOverScroller = new OverScroller(paramRecyclerView.getContext(), RecyclerView.sQuinticInterpolator);
  }
  
  private int computeScrollDuration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = Math.abs(paramInt1);
    int k = Math.abs(paramInt2);
    int i;
    if (j > k) {
      i = 1;
    } else {
      i = 0;
    }
    paramInt3 = (int)Math.sqrt(paramInt3 * paramInt3 + paramInt4 * paramInt4);
    paramInt2 = (int)Math.sqrt(paramInt1 * paramInt1 + paramInt2 * paramInt2);
    if (i != 0) {
      paramInt1 = this.this$0.getWidth();
    } else {
      paramInt1 = this.this$0.getHeight();
    }
    paramInt4 = paramInt1 / 2;
    float f2 = paramInt2;
    float f1 = paramInt1;
    float f3 = Math.min(1.0F, f2 * 1.0F / f1);
    f2 = paramInt4;
    f3 = distanceInfluenceForSnapDuration(f3);
    if (paramInt3 > 0)
    {
      paramInt1 = Math.round(Math.abs((f2 + f3 * f2) / paramInt3) * 1000.0F) * 4;
    }
    else
    {
      if (i != 0) {
        paramInt1 = j;
      } else {
        paramInt1 = k;
      }
      paramInt1 = (int)((paramInt1 / f1 + 1.0F) * 300.0F);
    }
    return Math.min(paramInt1, 2000);
  }
  
  private float distanceInfluenceForSnapDuration(float paramFloat)
  {
    return (float)Math.sin((paramFloat - 0.5F) * 0.4712389F);
  }
  
  private void internalPostOnAnimation()
  {
    this.this$0.removeCallbacks(this);
    ViewCompat.postOnAnimation(this.this$0, this);
  }
  
  public void fling(int paramInt1, int paramInt2)
  {
    this.this$0.setScrollState(2);
    this.mLastFlingY = 0;
    this.mLastFlingX = 0;
    if (this.mInterpolator != RecyclerView.sQuinticInterpolator)
    {
      this.mInterpolator = RecyclerView.sQuinticInterpolator;
      this.mOverScroller = new OverScroller(this.this$0.getContext(), RecyclerView.sQuinticInterpolator);
    }
    this.mOverScroller.fling(0, 0, paramInt1, paramInt2, -2147483648, 2147483647, -2147483648, 2147483647);
    postOnAnimation();
  }
  
  void postOnAnimation()
  {
    if (this.mEatRunOnAnimationRequest)
    {
      this.mReSchedulePostAnimationCallback = true;
      return;
    }
    internalPostOnAnimation();
  }
  
  public void run()
  {
    if (this.this$0.mLayout == null)
    {
      stop();
      return;
    }
    this.mReSchedulePostAnimationCallback = false;
    this.mEatRunOnAnimationRequest = true;
    this.this$0.consumePendingUpdateOperations();
    Object localObject1 = this.mOverScroller;
    if (((OverScroller)localObject1).computeScrollOffset())
    {
      int i = ((OverScroller)localObject1).getCurrX();
      int j = ((OverScroller)localObject1).getCurrY();
      int m = i - this.mLastFlingX;
      int k = j - this.mLastFlingY;
      this.mLastFlingX = i;
      this.mLastFlingY = j;
      this.this$0.mReusableIntPair[0] = 0;
      this.this$0.mReusableIntPair[1] = 0;
      Object localObject2 = this.this$0;
      i = m;
      j = k;
      if (((RecyclerView)localObject2).dispatchNestedPreScroll(m, k, ((RecyclerView)localObject2).mReusableIntPair, null, 1))
      {
        i = m - this.this$0.mReusableIntPair[0];
        j = k - this.this$0.mReusableIntPair[1];
      }
      if (this.this$0.getOverScrollMode() != 2) {
        this.this$0.considerReleasingGlowsOnScroll(i, j);
      }
      if (this.this$0.mAdapter != null)
      {
        this.this$0.mReusableIntPair[0] = 0;
        this.this$0.mReusableIntPair[1] = 0;
        localObject2 = this.this$0;
        ((RecyclerView)localObject2).scrollStep(i, j, ((RecyclerView)localObject2).mReusableIntPair);
        n = this.this$0.mReusableIntPair[0];
        i1 = this.this$0.mReusableIntPair[1];
        int i2 = i - n;
        int i3 = j - i1;
        localObject2 = this.this$0.mLayout.mSmoothScroller;
        i = n;
        m = i2;
        j = i1;
        k = i3;
        if (localObject2 != null)
        {
          i = n;
          m = i2;
          j = i1;
          k = i3;
          if (!((RecyclerView.SmoothScroller)localObject2).isPendingInitialRun())
          {
            i = n;
            m = i2;
            j = i1;
            k = i3;
            if (((RecyclerView.SmoothScroller)localObject2).isRunning())
            {
              i = this.this$0.mState.getItemCount();
              if (i == 0)
              {
                ((RecyclerView.SmoothScroller)localObject2).stop();
                i = n;
                m = i2;
                j = i1;
                k = i3;
              }
              else if (((RecyclerView.SmoothScroller)localObject2).getTargetPosition() >= i)
              {
                ((RecyclerView.SmoothScroller)localObject2).setTargetPosition(i - 1);
                ((RecyclerView.SmoothScroller)localObject2).onAnimation(n, i1);
                i = n;
                m = i2;
                j = i1;
                k = i3;
              }
              else
              {
                ((RecyclerView.SmoothScroller)localObject2).onAnimation(n, i1);
                i = n;
                m = i2;
                j = i1;
                k = i3;
              }
            }
          }
        }
      }
      else
      {
        n = 0;
        m = 0;
        k = j;
        j = m;
        m = i;
        i = n;
      }
      if (!this.this$0.mItemDecorations.isEmpty()) {
        this.this$0.invalidate();
      }
      this.this$0.mReusableIntPair[0] = 0;
      this.this$0.mReusableIntPair[1] = 0;
      localObject2 = this.this$0;
      ((RecyclerView)localObject2).dispatchNestedScroll(i, j, m, k, null, 1, ((RecyclerView)localObject2).mReusableIntPair);
      int i1 = m - this.this$0.mReusableIntPair[0];
      int n = k - this.this$0.mReusableIntPair[1];
      if ((i != 0) || (j != 0)) {
        this.this$0.dispatchOnScrolled(i, j);
      }
      if (!RecyclerView.access$200(this.this$0)) {
        this.this$0.invalidate();
      }
      if (((OverScroller)localObject1).getCurrX() == ((OverScroller)localObject1).getFinalX()) {
        k = 1;
      } else {
        k = 0;
      }
      if (((OverScroller)localObject1).getCurrY() == ((OverScroller)localObject1).getFinalY()) {
        m = 1;
      } else {
        m = 0;
      }
      if ((!((OverScroller)localObject1).isFinished()) && (((k == 0) && (i1 == 0)) || ((m == 0) && (n == 0)))) {
        k = 0;
      } else {
        k = 1;
      }
      localObject2 = this.this$0.mLayout.mSmoothScroller;
      if ((localObject2 != null) && (((RecyclerView.SmoothScroller)localObject2).isPendingInitialRun())) {
        m = 1;
      } else {
        m = 0;
      }
      if ((m == 0) && (k != 0))
      {
        if (this.this$0.getOverScrollMode() != 2)
        {
          j = (int)((OverScroller)localObject1).getCurrVelocity();
          if (i1 < 0) {
            i = -j;
          } else if (i1 > 0) {
            i = j;
          } else {
            i = 0;
          }
          if (n < 0) {
            j = -j;
          } else if (n <= 0) {
            j = 0;
          }
          this.this$0.absorbGlows(i, j);
        }
        if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
          this.this$0.mPrefetchRegistry.clearPrefetchPositions();
        }
      }
      else
      {
        postOnAnimation();
        if (this.this$0.mGapWorker != null) {
          this.this$0.mGapWorker.postFromTraversal(this.this$0, i, j);
        }
      }
    }
    localObject1 = this.this$0.mLayout.mSmoothScroller;
    if ((localObject1 != null) && (((RecyclerView.SmoothScroller)localObject1).isPendingInitialRun())) {
      ((RecyclerView.SmoothScroller)localObject1).onAnimation(0, 0);
    }
    this.mEatRunOnAnimationRequest = false;
    if (this.mReSchedulePostAnimationCallback)
    {
      internalPostOnAnimation();
      return;
    }
    this.this$0.setScrollState(0);
    this.this$0.stopNestedScroll(1);
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3, @Nullable Interpolator paramInterpolator)
  {
    int i = paramInt3;
    if (paramInt3 == -2147483648) {
      i = computeScrollDuration(paramInt1, paramInt2, 0, 0);
    }
    Interpolator localInterpolator = paramInterpolator;
    if (paramInterpolator == null) {
      localInterpolator = RecyclerView.sQuinticInterpolator;
    }
    if (this.mInterpolator != localInterpolator)
    {
      this.mInterpolator = localInterpolator;
      this.mOverScroller = new OverScroller(this.this$0.getContext(), localInterpolator);
    }
    this.mLastFlingY = 0;
    this.mLastFlingX = 0;
    this.this$0.setScrollState(2);
    this.mOverScroller.startScroll(0, 0, paramInt1, paramInt2, i);
    if (Build.VERSION.SDK_INT < 23) {
      this.mOverScroller.computeScrollOffset();
    }
    postOnAnimation();
  }
  
  public void stop()
  {
    this.this$0.removeCallbacks(this);
    this.mOverScroller.abortAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.ViewFlinger
 * JD-Core Version:    0.7.0.1
 */