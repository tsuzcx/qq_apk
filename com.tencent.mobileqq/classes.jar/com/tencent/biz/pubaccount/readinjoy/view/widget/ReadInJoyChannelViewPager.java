package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class ReadInJoyChannelViewPager
  extends ViewPagerCompat
{
  private boolean a = true;
  
  public ReadInJoyChannelViewPager(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ReadInJoyChannelViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    setOffscreenPageLimit(1);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a) {
      return super.onTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public void setSlideLeftAndRight(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager
 * JD-Core Version:    0.7.0.1
 */