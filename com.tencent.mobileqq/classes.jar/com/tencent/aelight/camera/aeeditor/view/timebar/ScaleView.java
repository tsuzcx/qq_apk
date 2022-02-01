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
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private ScaleGestureDetector.OnScaleGestureListener jdField_a_of_type_AndroidViewScaleGestureDetector$OnScaleGestureListener = new ScaleView.1(this);
  private ScaleGestureDetector jdField_a_of_type_AndroidViewScaleGestureDetector;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private ScaleView.MotionModel jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleView$MotionModel = ScaleView.MotionModel.None;
  private ScaleView.OnBarMoveListener jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleView$OnBarMoveListener;
  private ScaleView.onMoveByUserListener jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleView$onMoveByUserListener;
  protected ScaleAdapter a;
  private int b;
  private int c;
  
  public ScaleView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ScaleView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ScaleView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private int a(int paramInt1, int paramInt2)
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
  
  private int a(long paramLong)
  {
    return (int)(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a() * this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a(paramLong));
  }
  
  private long a()
  {
    if (a() == getScrollX()) {
      return this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.b();
    }
    return this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.c();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(getContext());
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(getContext(), this.jdField_a_of_type_AndroidViewScaleGestureDetector$OnScaleGestureListener);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    this.b = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.c = localViewConfiguration.getScaledMaximumFlingVelocity();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(500);
    int i = (int)this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity();
    if ((Math.abs(i) > this.b) && (Math.abs(i) < this.c))
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleView$MotionModel = ScaleView.MotionModel.FlingScroll;
      this.jdField_a_of_type_AndroidWidgetScroller.fling(paramInt1, paramInt2, -i, 0, 0, a(), 0, getHeight());
      awakenScrollBars(this.jdField_a_of_type_AndroidWidgetScroller.getDuration());
      invalidate();
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter;
    if (localObject != null) {
      ((ScaleAdapter)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleView$OnBarMoveListener;
    if (localObject != null) {
      ((ScaleView.OnBarMoveListener)localObject).b(getScrollX());
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleView$MotionModel = ScaleView.MotionModel.Down;
    this.jdField_a_of_type_Int = ((int)paramMotionEvent.getX());
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleView$MotionModel = ScaleView.MotionModel.Zoom;
    this.jdField_a_of_type_Long = a();
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleView$MotionModel != ScaleView.MotionModel.Zoom) && ((this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleView$MotionModel == ScaleView.MotionModel.Down) || (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleView$MotionModel == ScaleView.MotionModel.Move)))
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleView$MotionModel = ScaleView.MotionModel.Move;
      int i = (int)paramMotionEvent.getX();
      scrollBy(a(this.jdField_a_of_type_Int, i), 0);
      this.jdField_a_of_type_Int = i;
    }
  }
  
  private void c()
  {
    ScaleView.onMoveByUserListener localonMoveByUserListener = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleView$onMoveByUserListener;
    if (localonMoveByUserListener != null) {
      localonMoveByUserListener.a();
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleView$MotionModel = ScaleView.MotionModel.None;
    int i = getScrollX();
    int j = getScrollY();
    if (i < 0)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleView$MotionModel = ScaleView.MotionModel.ComputeScroll;
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(i, j, -i, -j);
      return;
    }
    if (i > a())
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleView$MotionModel = ScaleView.MotionModel.ComputeScroll;
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(i, j, a() - i, -j);
      return;
    }
    a(i, j);
  }
  
  private void c(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
  }
  
  private void d()
  {
    scrollTo(a(this.jdField_a_of_type_Long), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
  }
  
  public int a()
  {
    ScaleAdapter localScaleAdapter = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter;
    return localScaleAdapter.a(localScaleAdapter.b());
  }
  
  public void a(long paramLong)
  {
    int i = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a(paramLong);
    int j = getScrollX();
    int k = getScrollY();
    this.jdField_a_of_type_AndroidWidgetScroller.startScroll(j, k, i - j, -k, 0);
    postInvalidate();
  }
  
  @RequiresApi(api=16)
  public void a(long paramLong, int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a(paramLong);
    int j = getScrollX();
    int k = getScrollY();
    this.jdField_a_of_type_AndroidWidgetScroller.startScroll(j, k, i - j, -k, paramInt);
    postInvalidateOnAnimation();
  }
  
  public void a(ScaleAdapter paramScaleAdapter)
  {
    setScaleAdapter(paramScaleAdapter, a());
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
      postInvalidate();
    }
    else if ((this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleView$MotionModel == ScaleView.MotionModel.ComputeScroll) || (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleView$MotionModel == ScaleView.MotionModel.FlingScroll))
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleView$MotionModel = ScaleView.MotionModel.None;
    }
    ScaleAdapter localScaleAdapter = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter;
    if (localScaleAdapter == null) {
      return;
    }
    localScaleAdapter.a();
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleView$OnBarMoveListener != null)
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleView$MotionModel == ScaleView.MotionModel.None)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleView$OnBarMoveListener.b(getScrollX());
        return;
      }
      if ((this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleView$MotionModel == ScaleView.MotionModel.Move) || (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleView$MotionModel == ScaleView.MotionModel.FlingScroll)) {
        this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleView$OnBarMoveListener.a(getScrollX());
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    VelocityTracker localVelocityTracker = this.jdField_a_of_type_AndroidViewVelocityTracker;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_AndroidViewScaleGestureDetector.onTouchEvent(paramMotionEvent);
    if (this.jdField_a_of_type_AndroidViewScaleGestureDetector.isInProgress()) {
      return true;
    }
    c(paramMotionEvent);
    int i = paramMotionEvent.getActionMasked();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 5)
          {
            this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleView$MotionModel = ScaleView.MotionModel.None;
            return true;
          }
          b();
          return true;
        }
        b(paramMotionEvent);
        return true;
      }
      if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleView$MotionModel == ScaleView.MotionModel.Zoom)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleView$MotionModel = ScaleView.MotionModel.None;
        return true;
      }
      c();
      return true;
    }
    a(paramMotionEvent);
    return true;
  }
  
  public void setCurrTime(long paramLong)
  {
    if (paramLong < this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a()) {
      return;
    }
    if (paramLong > this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.b()) {
      return;
    }
    this.jdField_a_of_type_Long = paramLong;
    d();
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a();
    postInvalidate();
  }
  
  public void setMoveByUserListener(ScaleView.onMoveByUserListener paramonMoveByUserListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleView$onMoveByUserListener = paramonMoveByUserListener;
  }
  
  public void setOnBarMoveListener(ScaleView.OnBarMoveListener paramOnBarMoveListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleView$OnBarMoveListener = paramOnBarMoveListener;
  }
  
  public void setScaleAdapter(ScaleAdapter paramScaleAdapter)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter = paramScaleAdapter;
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a(this);
    this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a();
  }
  
  public void setScaleAdapter(ScaleAdapter paramScaleAdapter, long paramLong)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter = paramScaleAdapter;
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a(this);
    this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a();
    setCurrTime(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.timebar.ScaleView
 * JD-Core Version:    0.7.0.1
 */