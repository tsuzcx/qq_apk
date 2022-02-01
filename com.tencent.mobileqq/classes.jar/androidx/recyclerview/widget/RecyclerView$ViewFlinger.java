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
    if (j > k)
    {
      i = 1;
      paramInt3 = (int)Math.sqrt(paramInt3 * paramInt3 + paramInt4 * paramInt4);
      paramInt2 = (int)Math.sqrt(paramInt1 * paramInt1 + paramInt2 * paramInt2);
      if (i == 0) {
        break label140;
      }
    }
    label140:
    for (paramInt1 = this.this$0.getWidth();; paramInt1 = this.this$0.getHeight())
    {
      paramInt4 = paramInt1 / 2;
      float f3 = Math.min(1.0F, paramInt2 * 1.0F / paramInt1);
      float f1 = paramInt4;
      float f2 = paramInt4;
      f3 = distanceInfluenceForSnapDuration(f3);
      if (paramInt3 <= 0) {
        break label151;
      }
      paramInt1 = Math.round(1000.0F * Math.abs((f3 * f2 + f1) / paramInt3)) * 4;
      return Math.min(paramInt1, 2000);
      i = 0;
      break;
    }
    label151:
    if (i != 0) {}
    for (paramInt2 = j;; paramInt2 = k)
    {
      paramInt1 = (int)((paramInt2 / paramInt1 + 1.0F) * 300.0F);
      break;
    }
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
    Object localObject = this.mOverScroller;
    int j;
    int k;
    int m;
    int i;
    int n;
    RecyclerView.SmoothScroller localSmoothScroller;
    if (((OverScroller)localObject).computeScrollOffset())
    {
      j = ((OverScroller)localObject).getCurrX();
      k = ((OverScroller)localObject).getCurrY();
      m = j - this.mLastFlingX;
      i = k - this.mLastFlingY;
      this.mLastFlingX = j;
      this.mLastFlingY = k;
      this.this$0.mReusableIntPair[0] = 0;
      this.this$0.mReusableIntPair[1] = 0;
      j = m;
      k = i;
      if (this.this$0.dispatchNestedPreScroll(m, i, this.this$0.mReusableIntPair, null, 1))
      {
        j = m - this.this$0.mReusableIntPair[0];
        k = i - this.this$0.mReusableIntPair[1];
      }
      if (this.this$0.getOverScrollMode() != 2) {
        this.this$0.considerReleasingGlowsOnScroll(j, k);
      }
      if (this.this$0.mAdapter == null) {
        break label783;
      }
      this.this$0.mReusableIntPair[0] = 0;
      this.this$0.mReusableIntPair[1] = 0;
      this.this$0.scrollStep(j, k, this.this$0.mReusableIntPair);
      i = this.this$0.mReusableIntPair[0];
      m = this.this$0.mReusableIntPair[1];
      j -= i;
      n = k - m;
      localSmoothScroller = this.this$0.mLayout.mSmoothScroller;
      if ((localSmoothScroller == null) || (localSmoothScroller.isPendingInitialRun()) || (!localSmoothScroller.isRunning())) {
        break label678;
      }
      k = this.this$0.mState.getItemCount();
      if (k != 0) {
        break label637;
      }
      localSmoothScroller.stop();
      k = j;
      j = m;
    }
    for (;;)
    {
      if (!this.this$0.mItemDecorations.isEmpty()) {
        this.this$0.invalidate();
      }
      this.this$0.mReusableIntPair[0] = 0;
      this.this$0.mReusableIntPair[1] = 0;
      this.this$0.dispatchNestedScroll(i, j, k, n, null, 1, this.this$0.mReusableIntPair);
      int i1 = k - this.this$0.mReusableIntPair[0];
      n -= this.this$0.mReusableIntPair[1];
      if ((i != 0) || (j != 0)) {
        this.this$0.dispatchOnScrolled(i, j);
      }
      if (!RecyclerView.access$200(this.this$0)) {
        this.this$0.invalidate();
      }
      if (((OverScroller)localObject).getCurrX() == ((OverScroller)localObject).getFinalX())
      {
        k = 1;
        label447:
        if (((OverScroller)localObject).getCurrY() != ((OverScroller)localObject).getFinalY()) {
          break label691;
        }
        m = 1;
        label463:
        if ((!((OverScroller)localObject).isFinished()) && (((k == 0) && (i1 == 0)) || ((m == 0) && (n == 0)))) {
          break label697;
        }
        k = 1;
        label492:
        localSmoothScroller = this.this$0.mLayout.mSmoothScroller;
        if ((localSmoothScroller == null) || (!localSmoothScroller.isPendingInitialRun())) {
          break label702;
        }
        m = 1;
        label520:
        if ((m != 0) || (k == 0)) {
          break label733;
        }
        if (this.this$0.getOverScrollMode() != 2)
        {
          j = (int)((OverScroller)localObject).getCurrVelocity();
          if (i1 >= 0) {
            break label708;
          }
          i = -j;
          label555:
          if (n >= 0) {
            break label723;
          }
          j = -j;
          label563:
          this.this$0.absorbGlows(i, j);
        }
        if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
          this.this$0.mPrefetchRegistry.clearPrefetchPositions();
        }
      }
      for (;;)
      {
        localObject = this.this$0.mLayout.mSmoothScroller;
        if ((localObject != null) && (((RecyclerView.SmoothScroller)localObject).isPendingInitialRun())) {
          ((RecyclerView.SmoothScroller)localObject).onAnimation(0, 0);
        }
        this.mEatRunOnAnimationRequest = false;
        if (!this.mReSchedulePostAnimationCallback) {
          break label766;
        }
        internalPostOnAnimation();
        return;
        label637:
        if (localSmoothScroller.getTargetPosition() >= k)
        {
          localSmoothScroller.setTargetPosition(k - 1);
          localSmoothScroller.onAnimation(i, m);
          k = j;
          j = m;
          break;
        }
        localSmoothScroller.onAnimation(i, m);
        label678:
        k = j;
        j = m;
        break;
        k = 0;
        break label447;
        label691:
        m = 0;
        break label463;
        label697:
        k = 0;
        break label492;
        label702:
        m = 0;
        break label520;
        label708:
        if (i1 > 0)
        {
          i = j;
          break label555;
        }
        i = 0;
        break label555;
        label723:
        if (n > 0) {
          break label563;
        }
        j = 0;
        break label563;
        label733:
        postOnAnimation();
        if (this.this$0.mGapWorker != null) {
          this.this$0.mGapWorker.postFromTraversal(this.this$0, i, j);
        }
      }
      label766:
      this.this$0.setScrollState(0);
      this.this$0.stopNestedScroll(1);
      return;
      label783:
      n = k;
      k = j;
      j = 0;
      i = 0;
    }
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3, @Nullable Interpolator paramInterpolator)
  {
    if (paramInt3 == -2147483648) {
      paramInt3 = computeScrollDuration(paramInt1, paramInt2, 0, 0);
    }
    for (;;)
    {
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
      this.mOverScroller.startScroll(0, 0, paramInt1, paramInt2, paramInt3);
      if (Build.VERSION.SDK_INT < 23) {
        this.mOverScroller.computeScrollOffset();
      }
      postOnAnimation();
      return;
    }
  }
  
  public void stop()
  {
    this.this$0.removeCallbacks(this);
    this.mOverScroller.abortAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.ViewFlinger
 * JD-Core Version:    0.7.0.1
 */