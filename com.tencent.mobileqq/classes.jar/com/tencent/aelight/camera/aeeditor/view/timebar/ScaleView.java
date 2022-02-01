package com.tencent.aelight.camera.aeeditor.view.timebar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import androidx.annotation.RequiresApi;
import com.tencent.aelight.camera.aeeditor.view.timebar.scale.ScaleAdapter;

public class ScaleView
  extends View
{
  protected ScaleAdapter a;
  private int b = 0;
  private ScaleView.MotionModel c = ScaleView.MotionModel.None;
  private Scroller d;
  private VelocityTracker e;
  private int f;
  private int g;
  private long h;
  private ScaleView.OnBarMoveListener i;
  private ScaleGestureDetector.OnScaleGestureListener j = new ScaleView.1(this);
  private ScaleView.onMoveByUserListener k;
  private ScaleGestureDetector l;
  
  public ScaleView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public ScaleView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public ScaleView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.e.computeCurrentVelocity(500);
    int m = (int)this.e.getXVelocity();
    if ((Math.abs(m) > this.f) && (Math.abs(m) < this.g))
    {
      this.c = ScaleView.MotionModel.FlingScroll;
      this.d.fling(paramInt1, paramInt2, -m, 0, 0, a(), 0, getHeight());
      awakenScrollBars(this.d.getDuration());
      invalidate();
      return;
    }
    Object localObject = this.a;
    if (localObject != null) {
      ((ScaleAdapter)localObject).g();
    }
    localObject = this.i;
    if (localObject != null) {
      ((ScaleView.OnBarMoveListener)localObject).b(getScrollX());
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    this.c = ScaleView.MotionModel.Down;
    this.b = ((int)paramMotionEvent.getX());
  }
  
  private int b(int paramInt1, int paramInt2)
  {
    paramInt1 -= paramInt2;
    if (paramInt1 > 0)
    {
      paramInt2 = a();
      if (getScrollX() + paramInt1 - paramInt2 <= 0) {
        return paramInt1;
      }
      return 0;
    }
    if (getScrollX() + paramInt1 >= 0) {
      return paramInt1;
    }
    return 0;
  }
  
  private int b(long paramLong)
  {
    return (int)(this.a.f() * this.a.b(paramLong));
  }
  
  private void b()
  {
    this.d = new Scroller(getContext());
    this.l = new ScaleGestureDetector(getContext(), this.j);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    this.f = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.g = localViewConfiguration.getScaledMaximumFlingVelocity();
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    if ((this.c != ScaleView.MotionModel.Zoom) && ((this.c == ScaleView.MotionModel.Down) || (this.c == ScaleView.MotionModel.Move)))
    {
      this.c = ScaleView.MotionModel.Move;
      int m = (int)paramMotionEvent.getX();
      scrollBy(b(this.b, m), 0);
      this.b = m;
    }
  }
  
  private void c()
  {
    this.c = ScaleView.MotionModel.Zoom;
    this.h = getDeviationTime();
  }
  
  private void c(MotionEvent paramMotionEvent)
  {
    if (this.e == null) {
      this.e = VelocityTracker.obtain();
    }
    this.e.addMovement(paramMotionEvent);
  }
  
  private void d()
  {
    ScaleView.onMoveByUserListener localonMoveByUserListener = this.k;
    if (localonMoveByUserListener != null) {
      localonMoveByUserListener.a();
    }
    this.c = ScaleView.MotionModel.None;
    int m = getScrollX();
    int n = getScrollY();
    if (m < 0)
    {
      this.c = ScaleView.MotionModel.ComputeScroll;
      this.d.startScroll(m, n, -m, -n);
      return;
    }
    if (m > a())
    {
      this.c = ScaleView.MotionModel.ComputeScroll;
      this.d.startScroll(m, n, a() - m, -n);
      return;
    }
    a(m, n);
  }
  
  private void e()
  {
    scrollTo(b(this.h), this.d.getCurrY());
  }
  
  private long getDeviationTime()
  {
    if (a() == getScrollX()) {
      return this.a.c();
    }
    return this.a.d();
  }
  
  public int a()
  {
    ScaleAdapter localScaleAdapter = this.a;
    return localScaleAdapter.c(localScaleAdapter.c());
  }
  
  public void a(long paramLong)
  {
    int m = this.a.c(paramLong);
    int n = getScrollX();
    int i1 = getScrollY();
    this.d.startScroll(n, i1, m - n, -i1, 0);
    postInvalidate();
  }
  
  @RequiresApi(api=16)
  public void a(long paramLong, int paramInt)
  {
    int m = this.a.c(paramLong);
    int n = getScrollX();
    int i1 = getScrollY();
    this.d.startScroll(n, i1, m - n, -i1, paramInt);
    postInvalidateOnAnimation();
  }
  
  public void a(ScaleAdapter paramScaleAdapter)
  {
    setScaleAdapter(paramScaleAdapter, getDeviationTime());
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    if (this.d.computeScrollOffset())
    {
      scrollTo(this.d.getCurrX(), this.d.getCurrY());
      postInvalidate();
    }
    else if ((this.c == ScaleView.MotionModel.ComputeScroll) || (this.c == ScaleView.MotionModel.FlingScroll))
    {
      this.c = ScaleView.MotionModel.None;
    }
    ScaleAdapter localScaleAdapter = this.a;
    if (localScaleAdapter == null) {
      return;
    }
    localScaleAdapter.g();
    if (this.i != null)
    {
      if (this.c == ScaleView.MotionModel.None)
      {
        this.i.b(getScrollX());
        return;
      }
      if ((this.c == ScaleView.MotionModel.Move) || (this.c == ScaleView.MotionModel.FlingScroll)) {
        this.i.a(getScrollX());
      }
    }
  }
  
  public int getFinalScrollX()
  {
    return this.d.getFinalX();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    VelocityTracker localVelocityTracker = this.e;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.e = null;
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.l.onTouchEvent(paramMotionEvent);
    if (this.l.isInProgress()) {
      return true;
    }
    c(paramMotionEvent);
    int m = paramMotionEvent.getActionMasked();
    if (m != 0)
    {
      if (m != 1)
      {
        if (m != 2)
        {
          if (m != 5)
          {
            this.c = ScaleView.MotionModel.None;
            return true;
          }
          c();
          return true;
        }
        b(paramMotionEvent);
        return true;
      }
      if (this.c == ScaleView.MotionModel.Zoom)
      {
        this.c = ScaleView.MotionModel.None;
        return true;
      }
      d();
      return true;
    }
    a(paramMotionEvent);
    return true;
  }
  
  public void setCurrTime(long paramLong)
  {
    if (paramLong < this.a.b()) {
      return;
    }
    if (paramLong > this.a.c()) {
      return;
    }
    this.h = paramLong;
    e();
    this.a.g();
    postInvalidate();
  }
  
  public void setMoveByUserListener(ScaleView.onMoveByUserListener paramonMoveByUserListener)
  {
    this.k = paramonMoveByUserListener;
  }
  
  public void setOnBarMoveListener(ScaleView.OnBarMoveListener paramOnBarMoveListener)
  {
    this.i = paramOnBarMoveListener;
  }
  
  public void setScaleAdapter(ScaleAdapter paramScaleAdapter)
  {
    this.a = paramScaleAdapter;
    this.a.a(this);
    this.h = this.a.b();
  }
  
  public void setScaleAdapter(ScaleAdapter paramScaleAdapter, long paramLong)
  {
    this.a = paramScaleAdapter;
    this.a.a(this);
    this.h = this.a.b();
    setCurrTime(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.timebar.ScaleView
 * JD-Core Version:    0.7.0.1
 */