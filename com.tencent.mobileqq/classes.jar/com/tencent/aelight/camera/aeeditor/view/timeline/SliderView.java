package com.tencent.aelight.camera.aeeditor.view.timeline;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class SliderView
  extends ImageView
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  private SliderListener jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimelineSliderListener;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public SliderView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SliderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SliderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setScaleType(ImageView.ScaleType.FIT_XY);
  }
  
  private void a(float paramFloat)
  {
    SliderListener localSliderListener = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimelineSliderListener;
    if (localSliderListener != null) {
      localSliderListener.a(paramFloat);
    }
  }
  
  private void a(@NonNull MotionEvent paramMotionEvent)
  {
    if (a(paramMotionEvent))
    {
      getParent().requestDisallowInterceptTouchEvent(true);
      c();
      this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
      this.b = true;
    }
  }
  
  private boolean a(@NonNull MotionEvent paramMotionEvent)
  {
    return (paramMotionEvent.getX() >= 0.0F) && (paramMotionEvent.getX() <= getWidth());
  }
  
  private void b()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Float = 0.0F;
    getParent().requestDisallowInterceptTouchEvent(false);
    d();
    this.b = true;
  }
  
  private void b(@NonNull MotionEvent paramMotionEvent)
  {
    float f = (int)paramMotionEvent.getRawX();
    getParent().requestDisallowInterceptTouchEvent(true);
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Boolean) {
      a(f - this.jdField_a_of_type_Float);
    }
  }
  
  private void c()
  {
    SliderListener localSliderListener = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimelineSliderListener;
    if (localSliderListener != null) {
      localSliderListener.a();
    }
  }
  
  private void d()
  {
    SliderListener localSliderListener = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimelineSliderListener;
    if (localSliderListener != null) {
      localSliderListener.b();
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent == null) {
      return false;
    }
    this.b = false;
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            break label58;
          }
        }
        else
        {
          b(paramMotionEvent);
          break label58;
        }
      }
      b();
    }
    else
    {
      a(paramMotionEvent);
    }
    label58:
    return this.b;
  }
  
  public void setSliderListener(SliderListener paramSliderListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewTimelineSliderListener = paramSliderListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.timeline.SliderView
 * JD-Core Version:    0.7.0.1
 */