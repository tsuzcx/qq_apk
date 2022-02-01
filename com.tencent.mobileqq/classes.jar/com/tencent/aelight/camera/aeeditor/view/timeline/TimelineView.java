package com.tencent.aelight.camera.aeeditor.view.timeline;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.MainThread;

public class TimelineView
  extends RelativeLayout
{
  private View a;
  private View b;
  private View[] c;
  private TimelineListener d;
  protected SliderView m;
  protected SliderView n;
  protected ViewGroup o;
  protected int p = 0;
  
  public TimelineView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TimelineView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TimelineView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    b();
    m();
    l();
  }
  
  private void a(boolean paramBoolean)
  {
    getParent().requestDisallowInterceptTouchEvent(false);
    TimelineListener localTimelineListener = this.d;
    if (localTimelineListener != null) {
      localTimelineListener.a(paramBoolean);
    }
  }
  
  private void b()
  {
    c();
    j();
    k();
  }
  
  private void c()
  {
    this.o = e();
    this.o.setId(getContentViewId());
    addView(this.o);
  }
  
  private void j()
  {
    s();
    t();
  }
  
  private void k()
  {
    u();
    v();
  }
  
  private void l()
  {
    Object localObject1 = this.m;
    int i = 0;
    this.c = new View[] { localObject1, this.n, this.a, this.b };
    localObject1 = this.c;
    int j = localObject1.length;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (localObject2 != null) {
        localObject2.setVisibility(8);
      }
      i += 1;
    }
  }
  
  private void m()
  {
    n();
    o();
    p();
    q();
    r();
  }
  
  private void n()
  {
    this.o.setPadding(getContentPadding(), 0, getContentPadding(), 0);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.o.getLayoutParams();
    localLayoutParams.addRule(9, -1);
    localLayoutParams.addRule(10, -1);
    localLayoutParams.addRule(11, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.leftMargin = getSliderWidth();
    localLayoutParams.rightMargin = getSliderWidth();
    this.o.setLayoutParams(localLayoutParams);
  }
  
  private void o()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.m.getLayoutParams();
    localLayoutParams.addRule(10, -1);
    localLayoutParams.addRule(9, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.width = getSliderWidth();
    this.m.setLayoutParams(localLayoutParams);
  }
  
  private void p()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.n.getLayoutParams();
    localLayoutParams.addRule(10, -1);
    localLayoutParams.addRule(11, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.width = getSliderWidth();
    this.n.setLayoutParams(localLayoutParams);
  }
  
  private void q()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
    localLayoutParams.addRule(5, this.o.getId());
    localLayoutParams.addRule(6, this.o.getId());
    localLayoutParams.addRule(7, this.o.getId());
    localLayoutParams.height = getFrameHeight();
    this.a.setLayoutParams(localLayoutParams);
  }
  
  private void r()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
    localLayoutParams.addRule(5, this.o.getId());
    localLayoutParams.addRule(7, this.o.getId());
    localLayoutParams.addRule(8, this.o.getId());
    localLayoutParams.height = getFrameHeight();
    this.b.setLayoutParams(localLayoutParams);
  }
  
  private void s()
  {
    this.m = f();
    this.m.setId(getLeftSliderViewId());
    this.m.setSliderListener(new TimelineView.1(this));
    addView(this.m);
  }
  
  private void t()
  {
    this.n = g();
    this.n.setId(getRightSliderViewId());
    this.n.setSliderListener(new TimelineView.2(this));
    addView(this.n);
  }
  
  private void u()
  {
    this.a = h();
    this.a.setId(getTopFrameViewId());
    this.a.setBackgroundResource(2063925462);
    addView(this.a);
  }
  
  private void v()
  {
    this.b = i();
    this.b.setId(getBottomFrameViewId());
    this.b.setBackgroundResource(2063925461);
    addView(this.b);
  }
  
  protected void a(float paramFloat)
  {
    TimelineListener localTimelineListener = this.d;
    if (localTimelineListener != null) {
      localTimelineListener.a(paramFloat, true);
    }
  }
  
  protected void b(float paramFloat)
  {
    TimelineListener localTimelineListener = this.d;
    if (localTimelineListener != null) {
      localTimelineListener.a(paramFloat, false);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    int j = this.p;
    int i = 0;
    View[] arrayOfView;
    View localView;
    if (j == 0)
    {
      arrayOfView = this.c;
      int k = arrayOfView.length;
      i = 0;
      while (i < k)
      {
        localView = arrayOfView[i];
        if (localView != null)
        {
          if (paramBoolean) {
            j = 0;
          } else {
            j = 8;
          }
          localView.setVisibility(j);
        }
        i += 1;
      }
    }
    if (j == 1)
    {
      arrayOfView = this.c;
      j = arrayOfView.length;
      while (i < j)
      {
        localView = arrayOfView[i];
        if (localView != null) {
          localView.setVisibility(8);
        }
        i += 1;
      }
    }
  }
  
  protected void d()
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    TimelineListener localTimelineListener = this.d;
    if (localTimelineListener != null) {
      localTimelineListener.b();
    }
  }
  
  @MainThread
  protected ViewGroup e()
  {
    return new ContentView(getContext());
  }
  
  @MainThread
  protected SliderView f()
  {
    SliderView localSliderView = new SliderView(getContext());
    localSliderView.setImageResource(2063925444);
    return localSliderView;
  }
  
  @MainThread
  protected SliderView g()
  {
    SliderView localSliderView = new SliderView(getContext());
    localSliderView.setImageResource(2063925445);
    return localSliderView;
  }
  
  @IdRes
  protected int getBottomFrameViewId()
  {
    return 2063990814;
  }
  
  protected int getContentHeight()
  {
    return 0;
  }
  
  protected int getContentMargin()
  {
    return getResources().getDimensionPixelOffset(2063859770);
  }
  
  protected int getContentPadding()
  {
    return getResources().getDimensionPixelOffset(2063859733);
  }
  
  @IdRes
  protected int getContentViewId()
  {
    return 2063990815;
  }
  
  protected int getContentWidth()
  {
    return 0;
  }
  
  protected int getFrameHeight()
  {
    return getResources().getDimensionPixelOffset(2063859734);
  }
  
  protected int getFrameWidth()
  {
    return 0;
  }
  
  @IdRes
  protected int getLeftSliderViewId()
  {
    return 2063990816;
  }
  
  @IdRes
  protected int getRightSliderViewId()
  {
    return 2063990817;
  }
  
  protected int getSliderHeight()
  {
    return 0;
  }
  
  protected int getSliderWidth()
  {
    return getResources().getDimensionPixelOffset(2063859772);
  }
  
  @IdRes
  protected int getTopFrameViewId()
  {
    return 2063990818;
  }
  
  protected View h()
  {
    return new FrameView(getContext());
  }
  
  @MainThread
  protected View i()
  {
    return new FrameView(getContext());
  }
  
  public void setSelected(boolean paramBoolean)
  {
    super.setSelected(paramBoolean);
    b(paramBoolean);
  }
  
  public void setSelectedStyle(int paramInt)
  {
    this.p = paramInt;
  }
  
  public void setTimelineListener(TimelineListener paramTimelineListener)
  {
    this.d = paramTimelineListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.timeline.TimelineView
 * JD-Core Version:    0.7.0.1
 */