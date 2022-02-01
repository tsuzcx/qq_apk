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
  protected long b = 0L;
  protected long c = 0L;
  protected long d = 0L;
  protected long e = 0L;
  protected long f = 0L;
  protected long g = 0L;
  protected int h = 0;
  protected ScaleAdapter i;
  protected IValueChangeListener j;
  protected IStateChangeListener k;
  protected TimeLineViewListener l;
  private PointF q;
  private boolean r = false;
  private boolean s = false;
  private long t = -1L;
  private long u = -1L;
  private float v = 0.0F;
  private long w = 0L;
  
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
    setTimelineListener(this);
  }
  
  public void a()
  {
    long l1 = this.c;
    long l2 = this.w;
    this.e = (l1 - l2);
    this.d = (this.b - l2);
  }
  
  protected void a(float paramFloat)
  {
    super.a(paramFloat);
    this.s = true;
    if (this.j != null)
    {
      localObject = this.i;
      if (localObject != null)
      {
        this.w = ((ScaleAdapter)localObject).b(paramFloat);
        long l1 = this.d + this.w;
        if ((paramFloat < this.v) && (this.j.b()))
        {
          this.j.a();
          this.e = (this.c - this.w);
        }
        else if ((paramFloat > this.v) && (this.j.c()))
        {
          this.j.a();
          this.e = (this.c - this.w);
        }
        else
        {
          long l2 = this.j.a(this, l1);
          if (l2 >= 0L)
          {
            this.b = l2;
            this.j.a(this);
          }
        }
        this.v = paramFloat;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleLeftSliderMove. moveX:");
        ((StringBuilder)localObject).append(paramFloat);
        ((StringBuilder)localObject).append(". scrollValue:");
        ((StringBuilder)localObject).append(this.w);
        ((StringBuilder)localObject).append(". raw startValue:");
        ((StringBuilder)localObject).append(l1);
        ((StringBuilder)localObject).append(". adjusted value:");
        ((StringBuilder)localObject).append(this.b);
        Log.i("miles", ((StringBuilder)localObject).toString());
      }
    }
    Object localObject = this.l;
    if (localObject != null)
    {
      ScaleAdapter localScaleAdapter = this.i;
      if (localScaleAdapter != null) {
        ((TimeLineViewListener)localObject).a(this, this.b, localScaleAdapter.b(paramFloat));
      }
    }
  }
  
  public void a(float paramFloat, boolean paramBoolean) {}
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.j;
    if (localObject != null)
    {
      ((IValueChangeListener)localObject).a();
      long l1 = this.b;
      long l2 = this.w;
      this.d = (l1 - l2);
      this.e = (this.c - l2);
    }
    localObject = this.l;
    if (localObject != null) {
      ((TimeLineViewListener)localObject).a(this, this.b, this.c, this.h, paramBoolean);
    }
    if (c()) {
      bringToFront();
    }
    this.s = false;
  }
  
  public void b()
  {
    this.d = this.b;
    this.e = this.c;
  }
  
  protected void b(float paramFloat)
  {
    super.b(paramFloat);
    this.s = true;
    if (this.j != null)
    {
      this.w = this.i.b(paramFloat);
      long l1 = this.e + this.w;
      if ((paramFloat < this.v) && (this.j.b()))
      {
        this.j.a();
        this.e = (this.c - this.w);
      }
      else if ((paramFloat > this.v) && (this.j.c()))
      {
        this.j.a();
        this.e = (this.c - this.w);
      }
      else
      {
        long l2 = this.j.b(this, l1);
        if (l2 >= 0L)
        {
          this.c = l2;
          this.j.a(this);
        }
      }
      this.v = paramFloat;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleRightSliderMove. moveX:");
      ((StringBuilder)localObject).append(paramFloat);
      ((StringBuilder)localObject).append(". scrollValue:");
      ((StringBuilder)localObject).append(this.w);
      ((StringBuilder)localObject).append(". raw endValue:");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(". adjusted value:");
      ((StringBuilder)localObject).append(this.c);
      Log.i("miles", ((StringBuilder)localObject).toString());
    }
    Object localObject = this.l;
    if (localObject != null) {
      ((TimeLineViewListener)localObject).b(this, this.c, this.i.b(paramFloat));
    }
  }
  
  protected boolean c()
  {
    return true;
  }
  
  public int getBottomSpace()
  {
    return 0;
  }
  
  public int getContentType()
  {
    return 0;
  }
  
  public long getEndValue()
  {
    return this.c;
  }
  
  public int getHorizontalScrollOffset()
  {
    return 0;
  }
  
  public int getLeftSpace()
  {
    return getContentMargin();
  }
  
  public long getLength()
  {
    return this.c - this.b;
  }
  
  public long getMaxEndValue()
  {
    return this.u;
  }
  
  public long getMinStartValue()
  {
    return this.t;
  }
  
  public long getMinValue()
  {
    return a;
  }
  
  public int getRightSpace()
  {
    return getContentMargin();
  }
  
  public PointF getStartTouchPoint()
  {
    return this.q;
  }
  
  public long getStartValue()
  {
    return this.b;
  }
  
  public int getTopSpace()
  {
    return 0;
  }
  
  public int getTrackIndex()
  {
    return this.h;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onTouchEvent >> ");
    localStringBuilder.append(paramMotionEvent);
    Log.i("EffectTimelineView", localStringBuilder.toString());
    if (paramMotionEvent.getAction() == 0) {
      this.q = new PointF(paramMotionEvent.getX(), paramMotionEvent.getY());
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setEndValue(long paramLong)
  {
    this.c = paramLong;
  }
  
  public void setMaxEndValue(long paramLong)
  {
    this.u = paramLong;
  }
  
  public void setMinBlockDuration(long paramLong)
  {
    a = paramLong;
  }
  
  public void setMinStartValue(long paramLong)
  {
    this.t = paramLong;
  }
  
  public void setScaleModel(ScaleAdapter paramScaleAdapter)
  {
    this.i = paramScaleAdapter;
  }
  
  public void setSelected(boolean paramBoolean)
  {
    super.setSelected(paramBoolean);
    if ((paramBoolean) && (c())) {
      bringToFront();
    }
    if (this.r == paramBoolean) {
      return;
    }
    this.r = paramBoolean;
    Object localObject = this.k;
    if (localObject != null) {
      ((IStateChangeListener)localObject).a(this, paramBoolean);
    }
    localObject = this.l;
    if (localObject != null) {
      ((TimeLineViewListener)localObject).a(paramBoolean, this);
    }
  }
  
  public void setStartValue(long paramLong)
  {
    this.b = paramLong;
  }
  
  public void setStateChangeListener(IStateChangeListener paramIStateChangeListener)
  {
    this.k = paramIStateChangeListener;
  }
  
  public void setTimeLineViewListener(TimeLineViewListener paramTimeLineViewListener)
  {
    this.l = paramTimeLineViewListener;
  }
  
  public void setTrackIndex(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setValueChangeListener(IValueChangeListener paramIValueChangeListener)
  {
    this.j = paramIValueChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.timeline.EffectTimelineView
 * JD-Core Version:    0.7.0.1
 */