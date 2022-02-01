package com.tencent.biz.qqcircle.richframework.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class CompatSlideViewPager
  extends ViewPager
{
  private int a;
  private int b;
  private int c;
  
  public CompatSlideViewPager(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CompatSlideViewPager(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.c = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    paramMotionEvent.getActionIndex();
    if (i != 0)
    {
      if (i == 2)
      {
        paramMotionEvent.getX();
        paramMotionEvent.getY();
        i = this.a;
        i = this.b;
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    this.a = ((int)(paramMotionEvent.getX() + 0.5F));
    this.b = ((int)(paramMotionEvent.getY() + 0.5F));
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.CompatSlideViewPager
 * JD-Core Version:    0.7.0.1
 */