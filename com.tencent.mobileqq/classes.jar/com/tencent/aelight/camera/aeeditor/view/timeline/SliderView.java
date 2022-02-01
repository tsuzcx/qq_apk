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
  private SliderListener a;
  private boolean b;
  private int c = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  private float d;
  private boolean e;
  
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
    SliderListener localSliderListener = this.a;
    if (localSliderListener != null) {
      localSliderListener.a(paramFloat);
    }
  }
  
  private boolean a(@NonNull MotionEvent paramMotionEvent)
  {
    return (paramMotionEvent.getX() >= 0.0F) && (paramMotionEvent.getX() <= getWidth());
  }
  
  private void b()
  {
    this.b = false;
    this.d = 0.0F;
    getParent().requestDisallowInterceptTouchEvent(false);
    d();
    this.e = true;
  }
  
  private void b(@NonNull MotionEvent paramMotionEvent)
  {
    if (a(paramMotionEvent))
    {
      getParent().requestDisallowInterceptTouchEvent(true);
      c();
      this.d = paramMotionEvent.getRawX();
      this.e = true;
    }
  }
  
  private void c()
  {
    SliderListener localSliderListener = this.a;
    if (localSliderListener != null) {
      localSliderListener.a();
    }
  }
  
  private void c(@NonNull MotionEvent paramMotionEvent)
  {
    float f = (int)paramMotionEvent.getRawX();
    getParent().requestDisallowInterceptTouchEvent(true);
    this.b = true;
    if (this.b) {
      a(f - this.d);
    }
  }
  
  private void d()
  {
    SliderListener localSliderListener = this.a;
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
    this.e = false;
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
          c(paramMotionEvent);
          break label58;
        }
      }
      b();
    }
    else
    {
      b(paramMotionEvent);
    }
    label58:
    return this.e;
  }
  
  public void setSliderListener(SliderListener paramSliderListener)
  {
    this.a = paramSliderListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.timeline.SliderView
 * JD-Core Version:    0.7.0.1
 */