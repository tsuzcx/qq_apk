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
  private View jdField_a_of_type_AndroidViewView;
  protected ViewGroup a;
  protected SliderView a;
  private TimelineListener jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimelineTimelineListener;
  private View[] jdField_a_of_type_ArrayOfAndroidViewView;
  protected int b;
  private View b;
  protected SliderView b;
  
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
    this.jdField_b_of_type_Int = 0;
    a();
  }
  
  private void a()
  {
    b();
    h();
    g();
  }
  
  private void a(boolean paramBoolean)
  {
    getParent().requestDisallowInterceptTouchEvent(false);
    TimelineListener localTimelineListener = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimelineTimelineListener;
    if (localTimelineListener != null) {
      localTimelineListener.a(paramBoolean);
    }
  }
  
  private void b()
  {
    d();
    e();
    f();
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = a();
    this.jdField_a_of_type_AndroidViewViewGroup.setId(c());
    addView(this.jdField_a_of_type_AndroidViewViewGroup);
  }
  
  private void e()
  {
    n();
    o();
  }
  
  private void f()
  {
    p();
    q();
  }
  
  private void g()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimelineSliderView;
    int i = 0;
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[] { localObject1, this.jdField_b_of_type_ComTencentAelightCameraAeeditorViewTimelineSliderView, this.jdField_a_of_type_AndroidViewView, this.jdField_b_of_type_AndroidViewView };
    localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView;
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
  
  private void h()
  {
    i();
    j();
    k();
    l();
    m();
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidViewViewGroup.setPadding(e(), 0, e(), 0);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    localLayoutParams.addRule(9, -1);
    localLayoutParams.addRule(10, -1);
    localLayoutParams.addRule(11, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.leftMargin = h();
    localLayoutParams.rightMargin = h();
    this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
  }
  
  private void j()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimelineSliderView.getLayoutParams();
    localLayoutParams.addRule(10, -1);
    localLayoutParams.addRule(9, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.width = h();
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimelineSliderView.setLayoutParams(localLayoutParams);
  }
  
  private void k()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentAelightCameraAeeditorViewTimelineSliderView.getLayoutParams();
    localLayoutParams.addRule(10, -1);
    localLayoutParams.addRule(11, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.width = h();
    this.jdField_b_of_type_ComTencentAelightCameraAeeditorViewTimelineSliderView.setLayoutParams(localLayoutParams);
  }
  
  private void l()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.addRule(5, this.jdField_a_of_type_AndroidViewViewGroup.getId());
    localLayoutParams.addRule(6, this.jdField_a_of_type_AndroidViewViewGroup.getId());
    localLayoutParams.addRule(7, this.jdField_a_of_type_AndroidViewViewGroup.getId());
    localLayoutParams.height = k();
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  private void m()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.addRule(5, this.jdField_a_of_type_AndroidViewViewGroup.getId());
    localLayoutParams.addRule(7, this.jdField_a_of_type_AndroidViewViewGroup.getId());
    localLayoutParams.addRule(8, this.jdField_a_of_type_AndroidViewViewGroup.getId());
    localLayoutParams.height = k();
    this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimelineSliderView = a();
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimelineSliderView.setId(f());
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimelineSliderView.setSliderListener(new TimelineView.1(this));
    addView(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimelineSliderView);
  }
  
  private void o()
  {
    this.jdField_b_of_type_ComTencentAelightCameraAeeditorViewTimelineSliderView = b();
    this.jdField_b_of_type_ComTencentAelightCameraAeeditorViewTimelineSliderView.setId(g());
    this.jdField_b_of_type_ComTencentAelightCameraAeeditorViewTimelineSliderView.setSliderListener(new TimelineView.2(this));
    addView(this.jdField_b_of_type_ComTencentAelightCameraAeeditorViewTimelineSliderView);
  }
  
  private void p()
  {
    this.jdField_a_of_type_AndroidViewView = a();
    this.jdField_a_of_type_AndroidViewView.setId(i());
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2064056498);
    addView(this.jdField_a_of_type_AndroidViewView);
  }
  
  private void q()
  {
    this.jdField_b_of_type_AndroidViewView = b();
    this.jdField_b_of_type_AndroidViewView.setId(j());
    this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2064056497);
    addView(this.jdField_b_of_type_AndroidViewView);
  }
  
  protected View a()
  {
    return new FrameView(getContext());
  }
  
  @MainThread
  protected ViewGroup a()
  {
    return new ContentView(getContext());
  }
  
  @MainThread
  protected SliderView a()
  {
    SliderView localSliderView = new SliderView(getContext());
    localSliderView.setImageResource(2064056476);
    return localSliderView;
  }
  
  protected void a(float paramFloat)
  {
    TimelineListener localTimelineListener = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimelineTimelineListener;
    if (localTimelineListener != null) {
      localTimelineListener.a(paramFloat, true);
    }
  }
  
  @MainThread
  protected View b()
  {
    return new FrameView(getContext());
  }
  
  @MainThread
  protected SliderView b()
  {
    SliderView localSliderView = new SliderView(getContext());
    localSliderView.setImageResource(2064056477);
    return localSliderView;
  }
  
  protected void b(float paramFloat)
  {
    TimelineListener localTimelineListener = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimelineTimelineListener;
    if (localTimelineListener != null) {
      localTimelineListener.a(paramFloat, false);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    int j = this.jdField_b_of_type_Int;
    int i = 0;
    View[] arrayOfView;
    View localView;
    if (j == 0)
    {
      arrayOfView = this.jdField_a_of_type_ArrayOfAndroidViewView;
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
      arrayOfView = this.jdField_a_of_type_ArrayOfAndroidViewView;
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
  
  @IdRes
  protected int c()
  {
    return 2064121888;
  }
  
  protected void c()
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    TimelineListener localTimelineListener = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimelineTimelineListener;
    if (localTimelineListener != null) {
      localTimelineListener.b();
    }
  }
  
  protected int d()
  {
    return getResources().getDimensionPixelOffset(2063990843);
  }
  
  protected int e()
  {
    return getResources().getDimensionPixelOffset(2063990806);
  }
  
  @IdRes
  protected int f()
  {
    return 2064121889;
  }
  
  @IdRes
  protected int g()
  {
    return 2064121890;
  }
  
  protected int h()
  {
    return getResources().getDimensionPixelOffset(2063990845);
  }
  
  @IdRes
  protected int i()
  {
    return 2064121891;
  }
  
  @IdRes
  protected int j()
  {
    return 2064121887;
  }
  
  protected int k()
  {
    return getResources().getDimensionPixelOffset(2063990807);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    super.setSelected(paramBoolean);
    b(paramBoolean);
  }
  
  public void setSelectedStyle(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setTimelineListener(TimelineListener paramTimelineListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimelineTimelineListener = paramTimelineListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.timeline.TimelineView
 * JD-Core Version:    0.7.0.1
 */