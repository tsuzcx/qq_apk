package com.tencent.biz.qqcircle.publish.view.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class SlideDetectListView
  extends ListView
  implements MotionViewSetter
{
  int a = 0;
  boolean b = false;
  boolean c = false;
  View d;
  int e;
  int f = 0;
  protected int g;
  protected int h = -1;
  int i;
  protected boolean j = true;
  protected boolean k = false;
  protected GestureDetector.SimpleOnGestureListener l = new SlideDetectListView.1(this);
  protected GestureDetector m = null;
  protected boolean n = false;
  float o = 0.0F;
  private ArrayList<Integer> p = new ArrayList();
  private SlideDetectListView.OnSlideListener q = null;
  private AbsListView.OnScrollListener r = null;
  private AbsListView.OnScrollListener s = null;
  
  public SlideDetectListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setOnScrollListener(new SlideDetectListView.2(this));
    this.i = (ViewConfiguration.getTouchSlop() + 2);
  }
  
  protected int a(int paramInt)
  {
    int i2 = getChildCount();
    if (i2 > 0)
    {
      View localView;
      if (!isStackFromBottom())
      {
        i1 = 0;
        while (i1 < i2)
        {
          localView = getChildAt(i1);
          if (paramInt <= localView.getBottom())
          {
            if (this.p.contains(Integer.valueOf(localView.hashCode()))) {
              return -1;
            }
            return i1 + getFirstVisiblePosition();
          }
          i1 += 1;
        }
      }
      int i1 = i2 - 1;
      while (i1 >= 0)
      {
        localView = getChildAt(i1);
        if (paramInt >= localView.getTop())
        {
          if (this.p.contains(Integer.valueOf(localView.hashCode()))) {
            return -1;
          }
          return i1 + getFirstVisiblePosition();
        }
        i1 -= 1;
      }
    }
    return -1;
  }
  
  public void a()
  {
    this.a = 0;
    this.b = false;
    this.d = null;
    this.n = false;
  }
  
  public void addFooterView(View paramView, Object paramObject, boolean paramBoolean)
  {
    this.p.add(Integer.valueOf(paramView.hashCode()));
    super.addFooterView(paramView, paramObject, paramBoolean);
  }
  
  public void addHeaderView(View paramView, Object paramObject, boolean paramBoolean)
  {
    this.p.add(Integer.valueOf(paramView.hashCode()));
    super.addHeaderView(paramView, paramObject, paramBoolean);
  }
  
  protected View b(int paramInt)
  {
    if (paramInt != -1) {
      try
      {
        View localView = getChildAt(paramInt - getFirstVisiblePosition());
        return localView;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return null;
  }
  
  public int getScrollState()
  {
    return this.f;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.m == null)
    {
      this.m = new GestureDetector(getContext(), this.l, new Handler(Looper.getMainLooper()));
      this.m.setIsLongpressEnabled(false);
    }
    this.m.onTouchEvent(paramMotionEvent);
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if ((i1 == 1) || (i1 == 3)) {
        this.c = false;
      }
    }
    else
    {
      this.a = ((int)paramMotionEvent.getY());
      this.n = false;
      i1 = a(this.a);
      if ((this.d != null) && (b(i1) == this.d))
      {
        if (paramMotionEvent.getX() >= this.d.getWidth() - this.g)
        {
          if ((this.h > 0) && (this.d.getHeight() > 0))
          {
            i1 = this.d.getTop() + this.d.getHeight() / 2;
            int i3 = this.h;
            int i2 = i3 / 2;
            i3 /= 2;
            int i4 = this.a;
            if ((i4 > i2 + i1) || (i4 < i1 - i3))
            {
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("accurate in delete:ycenter:");
                localStringBuilder.append(i1);
                localStringBuilder.append(",motionheight:");
                localStringBuilder.append(this.d.getHeight());
                localStringBuilder.append("deleareaHeight:");
                localStringBuilder.append(this.h);
                QLog.d("SlideDetectListView", 2, localStringBuilder.toString());
              }
              i1 = 0;
              break label308;
            }
          }
          i1 = 1;
          label308:
          if (i1 != 0)
          {
            this.n = true;
            return false;
          }
        }
      }
      else if (this.b == true) {
        return true;
      }
    }
    if (this.n == true) {
      return false;
    }
    if (this.a != 0)
    {
      if (this.b == true) {
        return true;
      }
      if (this.c) {
        return false;
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.o = paramMotionEvent.getY();
      if (this.b == true)
      {
        paramMotionEvent = this.d;
        if (paramMotionEvent != null)
        {
          paramMotionEvent.setPressed(false);
          paramMotionEvent = this.q;
          if (paramMotionEvent != null) {
            paramMotionEvent.b(this, this.d, this.e - getHeaderViewsCount());
          }
        }
        this.b = false;
        this.d = null;
        return false;
      }
    }
    if ((this.a != 0) && (this.b != true)) {
      return super.onTouchEvent(paramMotionEvent);
    }
    setPressed(false);
    paramMotionEvent = this.d;
    if (paramMotionEvent != null) {
      paramMotionEvent.setPressed(false);
    }
    return true;
  }
  
  public boolean removeFooterView(View paramView)
  {
    this.p.remove(Integer.valueOf(paramView.hashCode()));
    return super.removeFooterView(paramView);
  }
  
  public boolean removeHeaderView(View paramView)
  {
    this.p.remove(Integer.valueOf(paramView.hashCode()));
    return super.removeHeaderView(paramView);
  }
  
  public void setCanSlide(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void setCheckStateWhenSlide(boolean paramBoolean)
  {
    this.k = (paramBoolean ^ true);
  }
  
  public void setDeleteAreaDim(int paramInt1, int paramInt2)
  {
    this.g = paramInt1;
    this.h = paramInt2;
  }
  
  public void setDeleteAreaWidth(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setMotionView(View paramView, int paramInt)
  {
    this.d = paramView;
    this.e = (paramInt + getHeaderViewsCount());
    if (this.d != null) {
      this.b = true;
    }
  }
  
  public void setOnScrollGroupFloatingListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.s = paramOnScrollListener;
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener) {}
  
  public void setOnScrollToTopListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.r = paramOnScrollListener;
  }
  
  public void setOnSlideListener(SlideDetectListView.OnSlideListener paramOnSlideListener)
  {
    this.q = paramOnSlideListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.view.widget.SlideDetectListView
 * JD-Core Version:    0.7.0.1
 */