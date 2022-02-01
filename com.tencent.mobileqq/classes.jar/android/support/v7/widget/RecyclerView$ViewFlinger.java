package android.support.v7.widget;

import android.support.v4.os.TraceCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ScrollerCompat;
import android.view.animation.Interpolator;
import java.util.ArrayList;

class RecyclerView$ViewFlinger
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
  
  private void disableRunOnAnimationRequests()
  {
    this.mReSchedulePostAnimationCallback = false;
    this.mEatRunOnAnimationRequest = true;
  }
  
  private float distanceInfluenceForSnapDuration(float paramFloat)
  {
    double d = paramFloat - 0.5F;
    Double.isNaN(d);
    return (float)Math.sin((float)(d * 0.47123891676382D));
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
    if (localScrollerCompat.computeScrollOffset())
    {
      int i6 = localScrollerCompat.getCurrX();
      int i7 = localScrollerCompat.getCurrY();
      int i4 = i6 - this.mLastFlingX;
      int i5 = i7 - this.mLastFlingY;
      this.mLastFlingX = i6;
      this.mLastFlingY = i7;
      int i;
      int j;
      int n;
      int i3;
      int i2;
      int i1;
      if (RecyclerView.access$3100(this.this$0) != null)
      {
        this.this$0.eatRequestLayout();
        RecyclerView.access$3200(this.this$0);
        TraceCompat.beginSection("RV Scroll");
        if (i4 != 0)
        {
          i = this.this$0.mLayout.scrollHorizontallyBy(i4, this.this$0.mRecycler, this.this$0.mState);
          j = i4 - i;
        }
        else
        {
          i = 0;
          j = 0;
        }
        int k;
        int m;
        if (i5 != 0)
        {
          k = this.this$0.mLayout.scrollVerticallyBy(i5, this.this$0.mRecycler, this.this$0.mState);
          m = i5 - k;
        }
        else
        {
          k = 0;
          m = 0;
        }
        TraceCompat.endSection();
        RecyclerView.access$3300(this.this$0);
        RecyclerView.access$3400(this.this$0);
        this.this$0.resumeRequestLayout(false);
        n = i;
        i3 = j;
        i2 = k;
        i1 = m;
        if (localSmoothScroller != null)
        {
          n = i;
          i3 = j;
          i2 = k;
          i1 = m;
          if (!localSmoothScroller.isPendingInitialRun())
          {
            n = i;
            i3 = j;
            i2 = k;
            i1 = m;
            if (localSmoothScroller.isRunning())
            {
              n = this.this$0.mState.getItemCount();
              if (n == 0)
              {
                localSmoothScroller.stop();
                n = i;
                i3 = j;
                i2 = k;
                i1 = m;
              }
              else if (localSmoothScroller.getTargetPosition() >= n)
              {
                localSmoothScroller.setTargetPosition(n - 1);
                RecyclerView.SmoothScroller.access$3500(localSmoothScroller, i4 - j, i5 - m);
                n = i;
                i3 = j;
                i2 = k;
                i1 = m;
              }
              else
              {
                RecyclerView.SmoothScroller.access$3500(localSmoothScroller, i4 - j, i5 - m);
                n = i;
                i3 = j;
                i2 = k;
                i1 = m;
              }
            }
          }
        }
      }
      else
      {
        n = 0;
        i3 = 0;
        i2 = 0;
        i1 = 0;
      }
      if (!RecyclerView.access$3600(this.this$0).isEmpty()) {
        this.this$0.invalidate();
      }
      if (ViewCompat.getOverScrollMode(this.this$0) != 2) {
        RecyclerView.access$3700(this.this$0, i4, i5);
      }
      if ((i3 != 0) || (i1 != 0))
      {
        j = (int)localScrollerCompat.getCurrVelocity();
        if (i3 != i6)
        {
          if (i3 < 0)
          {
            i = -j;
            break label518;
          }
          if (i3 > 0)
          {
            i = j;
            break label518;
          }
        }
        i = 0;
        label518:
        if (i1 != i7)
        {
          if (i1 < 0) {
            j = -j;
          } else if (i1 > 0) {}
        }
        else {
          j = 0;
        }
        if (ViewCompat.getOverScrollMode(this.this$0) != 2) {
          this.this$0.absorbGlows(i, j);
        }
        if (((i != 0) || (i3 == i6) || (localScrollerCompat.getFinalX() == 0)) && ((j != 0) || (i1 == i7) || (localScrollerCompat.getFinalY() == 0))) {
          localScrollerCompat.abortAnimation();
        }
      }
      if ((n != 0) || (i2 != 0)) {
        this.this$0.dispatchOnScrolled(n, i2);
      }
      if (!RecyclerView.access$3800(this.this$0)) {
        this.this$0.invalidate();
      }
      if ((i5 != 0) && (this.this$0.mLayout.canScrollVertically()) && (i2 == i5)) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i4 != 0) && (this.this$0.mLayout.canScrollHorizontally()) && (n == i4)) {
        j = 1;
      } else {
        j = 0;
      }
      if (((i4 != 0) || (i5 != 0)) && (j == 0) && (i == 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if ((!localScrollerCompat.isFinished()) && (i != 0)) {
        postOnAnimation();
      } else {
        RecyclerView.access$3900(this.this$0, 0);
      }
    }
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