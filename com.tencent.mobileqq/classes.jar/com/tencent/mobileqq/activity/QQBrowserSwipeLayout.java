package com.tencent.mobileqq.activity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.pubaccount.util.SwipeBackLayout;
import com.tencent.mobileqq.kandian.biz.detail.web.ReadinjoyH5ElementManager;
import com.tencent.qphone.base.util.QLog;

public class QQBrowserSwipeLayout
  extends SwipeBackLayout
{
  private GestureDetector r;
  
  public QQBrowserSwipeLayout(Context paramContext)
  {
    this(paramContext, true);
    setBackgroundColor(0);
  }
  
  public QQBrowserSwipeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QQBrowserSwipeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public QQBrowserSwipeLayout(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, paramBoolean);
    this.r = new GestureDetector(paramContext, new QQBrowserSwipeLayout.QQBrowserGestureDetector(this, paramContext));
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    ViewPager localViewPager = a(this.i, paramMotionEvent);
    if ((localViewPager != null) && (localViewPager.getCurrentItem() != 0)) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i == 2) && (this.n) && ((int)paramMotionEvent.getRawX() - this.c > this.b) && (Math.abs((int)paramMotionEvent.getRawY() - this.d) < this.b)) {
        return true;
      }
    }
    else
    {
      this.n = false;
      i = (int)paramMotionEvent.getRawX();
      this.e = i;
      this.c = i;
      this.d = ((int)paramMotionEvent.getRawY());
      if ((this.c < this.f / 3) && ((this.m.a()) || (!a(paramMotionEvent))) && (this.o)) {
        this.n = true;
      }
    }
    return this.r.onTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    StringBuilder localStringBuilder;
    if (i != 1)
    {
      if ((i == 2) && (this.n))
      {
        i = (int)paramMotionEvent.getRawX();
        int j = this.e - i;
        this.e = i;
        if ((i - this.c > this.b) && (Math.abs((int)paramMotionEvent.getRawY() - this.d) < this.b)) {
          this.g = true;
        }
        if ((i - this.c > 0) && (this.g))
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("moveX:");
            localStringBuilder.append(i);
            localStringBuilder.append("downX:");
            localStringBuilder.append(this.c);
            localStringBuilder.append("deltaX:");
            localStringBuilder.append(j);
            QLog.i("QQBrowserSwipeLayout", 2, localStringBuilder.toString());
          }
          this.a.scrollBy(j, 0);
        }
      }
    }
    else if (this.n)
    {
      this.g = false;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("event.getRawX():");
        localStringBuilder.append(paramMotionEvent.getRawX());
        localStringBuilder.append("screenWidth:");
        localStringBuilder.append(this.p);
        localStringBuilder.append("viewWidth:");
        localStringBuilder.append(this.f);
        QLog.i("QQBrowserSwipeLayout", 2, localStringBuilder.toString());
      }
      if (paramMotionEvent.getRawX() - this.c >= this.p / 2)
      {
        this.h = true;
        a();
      }
      else
      {
        postDelayed(new QQBrowserSwipeLayout.1(this), 100L);
        this.h = false;
      }
    }
    return this.r.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBrowserSwipeLayout
 * JD-Core Version:    0.7.0.1
 */