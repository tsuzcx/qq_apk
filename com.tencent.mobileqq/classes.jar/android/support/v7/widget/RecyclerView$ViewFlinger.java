package android.support.v7.widget;

import android.support.v4.os.TraceCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ScrollerCompat;
import android.view.animation.Interpolator;
import java.util.ArrayList;

public class RecyclerView$ViewFlinger
  implements Runnable
{
  private boolean mEatRunOnAnimationRequest = false;
  private Interpolator mInterpolator = RecyclerView.access$3000();
  private int mLastFlingX;
  private int mLastFlingY;
  private boolean mReSchedulePostAnimationCallback = false;
  private ScrollerCompat mScroller;
  
  public RecyclerView$ViewFlinger(RecyclerView paramRecyclerView)
  {
    this.mScroller = ScrollerCompat.create(paramRecyclerView.getContext(), RecyclerView.access$3000());
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
  
  private void disableRunOnAnimationRequests()
  {
    this.mReSchedulePostAnimationCallback = false;
    this.mEatRunOnAnimationRequest = true;
  }
  
  private float distanceInfluenceForSnapDuration(float paramFloat)
  {
    return (float)Math.sin((float)((paramFloat - 0.5F) * 0.47123891676382D));
  }
  
  private void enableRunOnAnimationRequests()
  {
    this.mEatRunOnAnimationRequest = false;
    if (this.mReSchedulePostAnimationCallback) {
      postOnAnimation();
    }
  }
  
  public void fling(int paramInt1, int paramInt2)
  {
    RecyclerView.access$3900(this.this$0, 2);
    this.mLastFlingY = 0;
    this.mLastFlingX = 0;
    this.mScroller.fling(0, 0, paramInt1, paramInt2, -2147483648, 2147483647, -2147483648, 2147483647);
    postOnAnimation();
  }
  
  void postOnAnimation()
  {
    if (this.mEatRunOnAnimationRequest)
    {
      this.mReSchedulePostAnimationCallback = true;
      return;
    }
    this.this$0.removeCallbacks(this);
    ViewCompat.postOnAnimation(this.this$0, this);
  }
  
  public void run()
  {
    if (this.this$0.mLayout == null)
    {
      stop();
      return;
    }
    disableRunOnAnimationRequests();
    RecyclerView.access$400(this.this$0);
    ScrollerCompat localScrollerCompat = this.mScroller;
    RecyclerView.SmoothScroller localSmoothScroller = this.this$0.mLayout.mSmoothScroller;
    int i6;
    int i7;
    int i4;
    int i5;
    int i1;
    int k;
    int j;
    int i3;
    int i;
    int n;
    int m;
    if (localScrollerCompat.computeScrollOffset())
    {
      i6 = localScrollerCompat.getCurrX();
      i7 = localScrollerCompat.getCurrY();
      i4 = i6 - this.mLastFlingX;
      i5 = i7 - this.mLastFlingY;
      i1 = 0;
      k = 0;
      i2 = 0;
      j = 0;
      this.mLastFlingX = i6;
      this.mLastFlingY = i7;
      i3 = 0;
      i = 0;
      n = 0;
      m = 0;
      if (RecyclerView.access$3100(this.this$0) == null) {
        break label723;
      }
      this.this$0.eatRequestLayout();
      RecyclerView.access$3200(this.this$0);
      TraceCompat.beginSection("RV Scroll");
      if (i4 != 0)
      {
        k = this.this$0.mLayout.scrollHorizontallyBy(i4, this.this$0.mRecycler, this.this$0.mState);
        i = i4 - k;
      }
      if (i5 != 0)
      {
        j = this.this$0.mLayout.scrollVerticallyBy(i5, this.this$0.mRecycler, this.this$0.mState);
        m = i5 - j;
      }
      TraceCompat.endSection();
      RecyclerView.access$3300(this.this$0);
      RecyclerView.access$3400(this.this$0);
      this.this$0.resumeRequestLayout(false);
      n = m;
      i2 = j;
      i3 = i;
      i1 = k;
      if (localSmoothScroller == null) {
        break label723;
      }
      n = m;
      i2 = j;
      i3 = i;
      i1 = k;
      if (localSmoothScroller.isPendingInitialRun()) {
        break label723;
      }
      n = m;
      i2 = j;
      i3 = i;
      i1 = k;
      if (!localSmoothScroller.isRunning()) {
        break label723;
      }
      n = this.this$0.mState.getItemCount();
      if (n != 0) {
        break label655;
      }
      localSmoothScroller.stop();
      n = j;
      j = i;
      if (!RecyclerView.access$3600(this.this$0).isEmpty()) {
        this.this$0.invalidate();
      }
      if (ViewCompat.getOverScrollMode(this.this$0) != 2) {
        RecyclerView.access$3700(this.this$0, i4, i5);
      }
      if ((j != 0) || (m != 0))
      {
        i1 = (int)localScrollerCompat.getCurrVelocity();
        if (j == i6) {
          break label795;
        }
        if (j >= 0) {
          break label740;
        }
        i = -i1;
      }
    }
    label406:
    label795:
    for (int i2 = i;; i2 = 0)
    {
      if (m != i7) {
        if (m < 0) {
          i = -i1;
        }
      }
      for (;;)
      {
        label425:
        if (ViewCompat.getOverScrollMode(this.this$0) != 2) {
          this.this$0.absorbGlows(i2, i);
        }
        if (((i2 != 0) || (j == i6) || (localScrollerCompat.getFinalX() == 0)) && ((i != 0) || (m == i7) || (localScrollerCompat.getFinalY() == 0))) {
          localScrollerCompat.abortAnimation();
        }
        if ((k != 0) || (n != 0)) {
          this.this$0.dispatchOnScrolled(k, n);
        }
        if (!RecyclerView.access$3800(this.this$0)) {
          this.this$0.invalidate();
        }
        if ((i5 != 0) && (this.this$0.mLayout.canScrollVertically()) && (n == i5))
        {
          i = 1;
          label552:
          if ((i4 == 0) || (!this.this$0.mLayout.canScrollHorizontally()) || (k != i4)) {
            break label773;
          }
          j = 1;
          label578:
          if (((i4 != 0) || (i5 != 0)) && (j == 0) && (i == 0)) {
            break label778;
          }
          i = 1;
          label598:
          if ((!localScrollerCompat.isFinished()) && (i != 0)) {
            break label783;
          }
          RecyclerView.access$3900(this.this$0, 0);
        }
        for (;;)
        {
          if (localSmoothScroller != null)
          {
            if (localSmoothScroller.isPendingInitialRun()) {
              RecyclerView.SmoothScroller.access$3500(localSmoothScroller, 0, 0);
            }
            if (!this.mReSchedulePostAnimationCallback) {
              localSmoothScroller.stop();
            }
          }
          enableRunOnAnimationRequests();
          return;
          if (localSmoothScroller.getTargetPosition() >= n)
          {
            localSmoothScroller.setTargetPosition(n - 1);
            RecyclerView.SmoothScroller.access$3500(localSmoothScroller, i4 - i, i5 - m);
            n = j;
            j = i;
            break;
          }
          RecyclerView.SmoothScroller.access$3500(localSmoothScroller, i4 - i, i5 - m);
          i1 = k;
          i3 = i;
          i2 = j;
          n = m;
          label723:
          j = i3;
          m = n;
          n = i2;
          k = i1;
          break;
          label740:
          if (j > 0)
          {
            i = i1;
            break label406;
          }
          i = 0;
          break label406;
          i = i1;
          if (m > 0) {
            break label425;
          }
          i = 0;
          break label425;
          i = 0;
          break label552;
          j = 0;
          break label578;
          i = 0;
          break label598;
          postOnAnimation();
        }
        i = 0;
      }
    }
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2)
  {
    smoothScrollBy(paramInt1, paramInt2, 0, 0);
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3)
  {
    smoothScrollBy(paramInt1, paramInt2, paramInt3, RecyclerView.access$3000());
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    smoothScrollBy(paramInt1, paramInt2, computeScrollDuration(paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
  {
    if (this.mInterpolator != paramInterpolator)
    {
      this.mInterpolator = paramInterpolator;
      this.mScroller = ScrollerCompat.create(this.this$0.getContext(), paramInterpolator);
    }
    RecyclerView.access$3900(this.this$0, 2);
    this.mLastFlingY = 0;
    this.mLastFlingX = 0;
    this.mScroller.startScroll(0, 0, paramInt1, paramInt2, paramInt3);
    postOnAnimation();
  }
  
  public void stop()
  {
    this.this$0.removeCallbacks(this);
    this.mScroller.abortAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.ViewFlinger
 * JD-Core Version:    0.7.0.1
 */