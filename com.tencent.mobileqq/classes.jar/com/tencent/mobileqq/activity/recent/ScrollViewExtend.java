package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.widget.ScrollView;

public class ScrollViewExtend
  extends ScrollView
{
  private float a;
  private float b;
  private float c;
  private float d;
  
  public ScrollViewExtend(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ScrollViewExtend(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScrollViewExtend(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    try
    {
      setFillViewport(true);
      setFadingEdgeLength(0);
      setHorizontalFadingEdgeEnabled(false);
      setVerticalFadingEdgeEnabled(false);
      setHorizontalScrollBarEnabled(false);
      setVerticalScrollBarEnabled(false);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      for (;;)
      {
        return super.onInterceptTouchEvent(paramMotionEvent);
        this.b = 0.0F;
        this.a = 0.0F;
        this.c = paramMotionEvent.getX();
        this.d = paramMotionEvent.getY();
      }
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.a += Math.abs(f1 - this.c);
      this.b += Math.abs(f2 - this.d);
      this.c = f1;
      this.d = f2;
    } while (this.a <= this.b);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.ScrollViewExtend
 * JD-Core Version:    0.7.0.1
 */