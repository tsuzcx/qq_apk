package androidx.recyclerview.widget;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;

public class OverPullHelper
{
  public static final int OVER_PULL_DOWN_ING = 1;
  public static final int OVER_PULL_NONE = 0;
  public static final int OVER_PULL_NORMAL = 3;
  public static final int OVER_PULL_SETTLING = 4;
  public static final int OVER_PULL_UP_ING = 2;
  private int a = 0;
  private ValueAnimator b;
  private boolean c = true;
  private int d = -1;
  protected float downRawY = -1.0F;
  private boolean e = false;
  private OverPullListener f = null;
  private EasyRecyclerView g;
  protected float lastRawY = -1.0F;
  
  public OverPullHelper(EasyRecyclerView paramEasyRecyclerView)
  {
    this.g = paramEasyRecyclerView;
    this.d = paramEasyRecyclerView.getOverScrollMode();
    paramEasyRecyclerView.addOnScrollListener(new OverPullHelper.1(this));
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    g();
    this.b = ValueAnimator.ofInt(new int[] { paramInt1, paramInt2 });
    this.b.setInterpolator(new DecelerateInterpolator());
    this.b.addUpdateListener(new OverPullHelper.RollbackUpdateListener(this, paramInt1));
    this.b.addListener(new OverPullHelper.2(this));
    this.e = true;
    this.b.setDuration(150L).start();
  }
  
  private boolean c(MotionEvent paramMotionEvent)
  {
    return (this.lastRawY > 0.0F) && (Math.abs(paramMotionEvent.getRawY() - this.downRawY) > d());
  }
  
  private int d()
  {
    return ViewConfiguration.get(this.g.getContext()).getScaledTouchSlop();
  }
  
  private boolean d(MotionEvent paramMotionEvent)
  {
    if (!this.c) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 2)
      {
        h();
      }
      else
      {
        boolean bool1 = f(paramMotionEvent);
        boolean bool2 = g(paramMotionEvent);
        if ((!bool1) && (!bool2))
        {
          a(3);
        }
        else
        {
          this.g.setOverScrollMode(2);
          this.g.invalidateGlows();
          if (bool1) {
            a(1);
          } else {
            a(2);
          }
          i = (int)(paramMotionEvent.getRawY() - this.lastRawY) / 2;
          this.g.offsetChildrenVertical(i);
          OverPullListener localOverPullListener = this.f;
          if (localOverPullListener != null)
          {
            i = this.a;
            localOverPullListener.onOverPullStateChanged(i, i, f());
          }
        }
        this.lastRawY = paramMotionEvent.getRawY();
      }
    }
    else
    {
      this.lastRawY = paramMotionEvent.getRawY();
      this.downRawY = paramMotionEvent.getRawY();
    }
    i = this.a;
    if (i != 1) {
      return i == 2;
    }
    return true;
  }
  
  private void e()
  {
    int i = this.d;
    if (i != -1) {
      this.g.setOverScrollMode(i);
    }
  }
  
  private boolean e(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    boolean bool = true;
    if (i != 1)
    {
      if (paramMotionEvent.getAction() == 3) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private int f()
  {
    int i = this.a;
    if (i == 1) {
      return getOverPullDownOffset();
    }
    if (i == 2) {
      return getOverPullUpOffset();
    }
    return 0;
  }
  
  private boolean f(MotionEvent paramMotionEvent)
  {
    int i = this.g.computeVerticalScrollOffset();
    int j = Math.abs((int)(paramMotionEvent.getRawY() - this.lastRawY));
    if (Math.abs(i) + (j + 1) < this.g.getHeight()) {
      return (c(paramMotionEvent)) && (a(paramMotionEvent)) && (!b());
    }
    return false;
  }
  
  private void g()
  {
    ValueAnimator localValueAnimator = this.b;
    if (localValueAnimator != null)
    {
      localValueAnimator.removeAllListeners();
      this.b.removeAllUpdateListeners();
      this.b.end();
      this.b = null;
    }
    this.e = false;
  }
  
  private boolean g(MotionEvent paramMotionEvent)
  {
    int i = Math.abs((int)(paramMotionEvent.getRawY() - this.lastRawY));
    if (this.g.computeVerticalScrollOffset() + this.g.getHeight() - this.g.computeVerticalScrollRange() + (i + 1) < this.g.getHeight()) {
      return (c(paramMotionEvent)) && (b(paramMotionEvent)) && (!c());
    }
    return false;
  }
  
  private void h()
  {
    e();
    this.lastRawY = -1.0F;
    this.downRawY = -1.0F;
    a(0);
  }
  
  void a()
  {
    int i = this.g.computeVerticalScrollOffset();
    if (i < 0) {}
    do
    {
      a(i, 0);
      return;
      i = getOverPullUpOffset();
    } while (i != 0);
  }
  
  void a(int paramInt)
  {
    OverPullListener localOverPullListener = this.f;
    if (localOverPullListener != null) {
      localOverPullListener.onOverPullStateChanged(this.a, paramInt, f());
    }
    this.a = paramInt;
  }
  
  boolean a(MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getRawY() - this.lastRawY > 0.0F;
  }
  
  boolean b()
  {
    return this.g.canScrollVertically(-1);
  }
  
  boolean b(MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getRawY() - this.lastRawY <= 0.0F;
  }
  
  boolean c()
  {
    return this.g.canScrollVertically(1);
  }
  
  public int getOverPullDownOffset()
  {
    if (this.a == 1) {
      return this.g.computeVerticalScrollOffset();
    }
    return 0;
  }
  
  public int getOverPullState()
  {
    return this.a;
  }
  
  public int getOverPullUpOffset()
  {
    int i = this.g.computeVerticalScrollOffset();
    int j = this.g.computeVerticalScrollRange();
    j = this.g.getHeight() + i - j;
    if ((j > 0) && (i > 0)) {
      return Math.min(j, i);
    }
    return 0;
  }
  
  public void handleEventUp(MotionEvent paramMotionEvent)
  {
    if (e(paramMotionEvent))
    {
      e();
      if (this.g.getScrollState() != 2) {
        a();
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.e) {
      return true;
    }
    return d(paramMotionEvent);
  }
  
  public void setOverPullListener(OverPullListener paramOverPullListener)
  {
    this.f = paramOverPullListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.OverPullHelper
 * JD-Core Version:    0.7.0.1
 */