package com.tencent.biz.richframework.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.core.view.ViewConfigurationCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.qphone.base.util.QLog;

public class MultiPicViewPager
  extends ViewPager
{
  private int a;
  private float b;
  private float c;
  
  public MultiPicViewPager(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public MultiPicViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  private void b()
  {
    this.a = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
  }
  
  private int getCount()
  {
    if (getAdapter() == null) {
      return 0;
    }
    return getAdapter().getCount();
  }
  
  public boolean a()
  {
    return getCount() > 1;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i == 2)
      {
        float f2 = paramMotionEvent.getRawY();
        float f1 = Math.abs(paramMotionEvent.getRawX() - this.b);
        f2 = Math.abs(f2 - this.c);
        i = this.a;
        if ((f1 <= i) && (f2 <= i))
        {
          paramMotionEvent = new StringBuilder();
          paramMotionEvent.append("onInterceptTouchEvent move false mTouchSlop: ");
          paramMotionEvent.append(this.a);
          paramMotionEvent.append(" distanceX");
          paramMotionEvent.append(f1);
          paramMotionEvent.append(" distanceY:");
          paramMotionEvent.append(f2);
          QLog.d("MultiPicViewPager", 4, paramMotionEvent.toString());
          return false;
        }
        paramMotionEvent = new StringBuilder();
        paramMotionEvent.append("onInterceptTouchEvent move true mTouchSlop: ");
        paramMotionEvent.append(this.a);
        paramMotionEvent.append(" distanceX");
        paramMotionEvent.append(f1);
        paramMotionEvent.append(" distanceY:");
        paramMotionEvent.append(f2);
        QLog.d("MultiPicViewPager", 4, paramMotionEvent.toString());
        return true;
      }
    }
    else
    {
      this.c = paramMotionEvent.getRawY();
      this.b = paramMotionEvent.getRawX();
      QLog.d("MultiPicViewPager", 4, "onInterceptTouchEvent down");
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.widget.MultiPicViewPager
 * JD-Core Version:    0.7.0.1
 */