package com.tencent.aelight.camera.aeeditor.view.timeline;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.aelight.camera.aeeditor.view.dragdrop.IDragDropScrollListener;
import com.tencent.aelight.camera.aeeditor.view.dragdrop.IDragView;
import com.tencent.aelight.camera.aeeditor.view.dragdrop.IStateChangeListener;
import com.tencent.aelight.camera.aeeditor.view.dragdrop.IValueChangeListener;
import com.tencent.aelight.camera.aeeditor.view.timebar.scale.ScaleAdapter;

public class EffectTimelineView
  extends TimelineView
  implements IDragDropScrollListener, IDragView, TimelineListener
{
  public static long a = 1000L;
  private float jdField_a_of_type_Float = 0.0F;
  protected int a;
  private PointF jdField_a_of_type_AndroidGraphicsPointF;
  protected IStateChangeListener a;
  protected IValueChangeListener a;
  protected ScaleAdapter a;
  protected TimeLineViewListener a;
  private boolean jdField_a_of_type_Boolean = false;
  protected long b;
  private boolean b;
  protected long c = 0L;
  protected long d = 0L;
  protected long e = 0L;
  protected long f = 0L;
  protected long g = 0L;
  private long h = -1L;
  private long i = -1L;
  private long j = 0L;
  
  public EffectTimelineView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public EffectTimelineView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EffectTimelineView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    setTimelineListener(this);
  }
  
  public int a()
  {
    return d();
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public void a()
  {
    long l1 = this.c;
    long l2 = this.j;
    this.e = (l1 - l2);
    this.d = (this.jdField_b_of_type_Long - l2);
  }
  
  protected void a(float paramFloat)
  {
    super.a(paramFloat);
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewDragdropIValueChangeListener != null)
    {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter;
      if (localObject != null)
      {
        this.j = ((ScaleAdapter)localObject).a(paramFloat);
        long l1 = this.d + this.j;
        if ((paramFloat < this.jdField_a_of_type_Float) && (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewDragdropIValueChangeListener.a()))
        {
          this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewDragdropIValueChangeListener.a();
          this.e = (this.c - this.j);
        }
        else if ((paramFloat > this.jdField_a_of_type_Float) && (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewDragdropIValueChangeListener.b()))
        {
          this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewDragdropIValueChangeListener.a();
          this.e = (this.c - this.j);
        }
        else
        {
          long l2 = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewDragdropIValueChangeListener.a(this, l1);
          if (l2 >= 0L)
          {
            this.jdField_b_of_type_Long = l2;
            this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewDragdropIValueChangeListener.a(this);
          }
        }
        this.jdField_a_of_type_Float = paramFloat;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleLeftSliderMove. moveX:");
        ((StringBuilder)localObject).append(paramFloat);
        ((StringBuilder)localObject).append(". scrollValue:");
        ((StringBuilder)localObject).append(this.j);
        ((StringBuilder)localObject).append(". raw startValue:");
        ((StringBuilder)localObject).append(l1);
        ((StringBuilder)localObject).append(". adjusted value:");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_Long);
        Log.i("miles", ((StringBuilder)localObject).toString());
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimelineTimeLineViewListener;
    if (localObject != null)
    {
      ScaleAdapter localScaleAdapter = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter;
      if (localScaleAdapter != null) {
        ((TimeLineViewListener)localObject).a(this, this.jdField_b_of_type_Long, localScaleAdapter.a(paramFloat));
      }
    }
  }
  
  public void a(float paramFloat, boolean paramBoolean) {}
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewDragdropIValueChangeListener;
    if (localObject != null)
    {
      ((IValueChangeListener)localObject).a();
      long l1 = this.jdField_b_of_type_Long;
      long l2 = this.j;
      this.d = (l1 - l2);
      this.e = (this.c - l2);
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimelineTimeLineViewListener;
    if (localObject != null) {
      ((TimeLineViewListener)localObject).a(this, this.jdField_b_of_type_Long, this.c, this.jdField_a_of_type_Int, paramBoolean);
    }
    if (a()) {
      bringToFront();
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public int b()
  {
    return d();
  }
  
  public long b()
  {
    return this.c;
  }
  
  public void b()
  {
    this.d = this.jdField_b_of_type_Long;
    this.e = this.c;
  }
  
  protected void b(float paramFloat)
  {
    super.b(paramFloat);
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewDragdropIValueChangeListener != null)
    {
      this.j = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a(paramFloat);
      long l1 = this.e + this.j;
      if ((paramFloat < this.jdField_a_of_type_Float) && (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewDragdropIValueChangeListener.a()))
      {
        this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewDragdropIValueChangeListener.a();
        this.e = (this.c - this.j);
      }
      else if ((paramFloat > this.jdField_a_of_type_Float) && (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewDragdropIValueChangeListener.b()))
      {
        this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewDragdropIValueChangeListener.a();
        this.e = (this.c - this.j);
      }
      else
      {
        long l2 = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewDragdropIValueChangeListener.b(this, l1);
        if (l2 >= 0L)
        {
          this.c = l2;
          this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewDragdropIValueChangeListener.a(this);
        }
      }
      this.jdField_a_of_type_Float = paramFloat;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleRightSliderMove. moveX:");
      ((StringBuilder)localObject).append(paramFloat);
      ((StringBuilder)localObject).append(". scrollValue:");
      ((StringBuilder)localObject).append(this.j);
      ((StringBuilder)localObject).append(". raw endValue:");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(". adjusted value:");
      ((StringBuilder)localObject).append(this.c);
      Log.i("miles", ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimelineTimeLineViewListener;
    if (localObject != null) {
      ((TimeLineViewListener)localObject).b(this, this.c, this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter.a(paramFloat));
    }
  }
  
  public long c()
  {
    return jdField_a_of_type_Long;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onTouchEvent >> ");
    localStringBuilder.append(paramMotionEvent);
    Log.i("EffectTimelineView", localStringBuilder.toString());
    if (paramMotionEvent.getAction() == 0) {
      this.jdField_a_of_type_AndroidGraphicsPointF = new PointF(paramMotionEvent.getX(), paramMotionEvent.getY());
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setEndValue(long paramLong)
  {
    this.c = paramLong;
  }
  
  public void setMaxEndValue(long paramLong)
  {
    this.i = paramLong;
  }
  
  public void setMinBlockDuration(long paramLong)
  {
    jdField_a_of_type_Long = paramLong;
  }
  
  public void setMinStartValue(long paramLong)
  {
    this.h = paramLong;
  }
  
  public void setScaleModel(ScaleAdapter paramScaleAdapter)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimebarScaleScaleAdapter = paramScaleAdapter;
  }
  
  public void setSelected(boolean paramBoolean)
  {
    super.setSelected(paramBoolean);
    if ((paramBoolean) && (a())) {
      bringToFront();
    }
    if (this.jdField_a_of_type_Boolean == paramBoolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewDragdropIStateChangeListener;
    if (localObject != null) {
      ((IStateChangeListener)localObject).a(this, paramBoolean);
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimelineTimeLineViewListener;
    if (localObject != null) {
      ((TimeLineViewListener)localObject).a(paramBoolean, this);
    }
  }
  
  public void setStartValue(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void setStateChangeListener(IStateChangeListener paramIStateChangeListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewDragdropIStateChangeListener = paramIStateChangeListener;
  }
  
  public void setTimeLineViewListener(TimeLineViewListener paramTimeLineViewListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimelineTimeLineViewListener = paramTimeLineViewListener;
  }
  
  public void setTrackIndex(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setValueChangeListener(IValueChangeListener paramIValueChangeListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewDragdropIValueChangeListener = paramIValueChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.timeline.EffectTimelineView
 * JD-Core Version:    0.7.0.1
 */