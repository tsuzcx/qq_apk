package com.tencent.mobileqq.activity.activateFriend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import androidx.viewpager.widget.ViewPager;

public class ReminderViewPager
  extends ViewPager
{
  private int a = -1;
  private int b = -1;
  
  public ReminderViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public ReminderViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      int i = (int)paramMotionEvent.getRawX();
      int j = (int)paramMotionEvent.getRawY();
      int k = paramMotionEvent.getAction();
      if (k != 0)
      {
        if (k == 2)
        {
          if (Math.abs(i - this.a) + 0 >= Math.abs(j - this.b) + 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
          } else {
            getParent().requestDisallowInterceptTouchEvent(false);
          }
          this.a = i;
          this.b = j;
        }
      }
      else {
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Throwable paramMotionEvent)
    {
      paramMotionEvent.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderViewPager
 * JD-Core Version:    0.7.0.1
 */