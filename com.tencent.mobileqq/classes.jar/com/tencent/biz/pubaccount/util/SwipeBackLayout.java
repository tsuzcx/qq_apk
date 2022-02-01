package com.tencent.biz.pubaccount.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.kandian.biz.detail.web.ReadinjoyH5ElementManager;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SwipeBackLayout
  extends RelativeLayout
{
  protected View a;
  protected int b;
  protected int c;
  protected int d;
  protected int e;
  protected int f;
  protected boolean g;
  protected boolean h;
  protected List<ViewPager> i = new LinkedList();
  protected Context j;
  protected volatile boolean k;
  protected WebViewFragment l;
  protected ReadinjoyH5ElementManager m = new ReadinjoyH5ElementManager();
  protected boolean n = false;
  protected boolean o = true;
  protected int p;
  final Handler q = new SwipeBackLayout.1(this);
  private Scroller r;
  private Drawable s;
  private GestureDetector t;
  private boolean u = true;
  private boolean v = false;
  private boolean w = false;
  private boolean x = false;
  
  public SwipeBackLayout(Context paramContext)
  {
    this(paramContext, true);
  }
  
  public SwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.b = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.r = new Scroller(paramContext);
    this.s = getResources().getDrawable(2130843704);
    this.p = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
  }
  
  public SwipeBackLayout(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, null);
    this.j = paramContext;
    this.o = paramBoolean;
    this.t = new GestureDetector(paramContext, new SwipeBackLayout.KandianGestureDetector(this, paramContext));
  }
  
  private void a(List<ViewPager> paramList, ViewGroup paramViewGroup)
  {
    int i2 = paramViewGroup.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = paramViewGroup.getChildAt(i1);
      if ((localView instanceof ViewPager)) {
        paramList.add((ViewPager)localView);
      } else if ((localView instanceof ViewGroup)) {
        a(paramList, (ViewGroup)localView);
      }
      i1 += 1;
    }
  }
  
  private void setContentView(View paramView)
  {
    this.a = ((View)paramView.getParent());
  }
  
  protected ViewPager a(List<ViewPager> paramList, MotionEvent paramMotionEvent)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return null;
      }
      Rect localRect = new Rect();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ViewPager localViewPager = (ViewPager)paramList.next();
        localViewPager.getHitRect(localRect);
        if (localRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
          return localViewPager;
        }
      }
    }
    return null;
  }
  
  protected void a()
  {
    if (this.w) {
      return;
    }
    this.w = true;
    int i1 = this.f + this.a.getScrollX();
    double d1 = i1;
    Double.isNaN(d1);
    double d2 = this.f;
    Double.isNaN(d2);
    int i2 = (int)(d1 * 1.0D / d2 * 700.0D);
    try
    {
      this.r.startScroll(this.a.getScrollX(), 0, -i1 + 1, 0, Math.abs(i2));
      label85:
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("SwipeBackLayout scrollRight viewwithd=");
        localStringBuilder.append(this.f);
        localStringBuilder.append("  startx+ ");
        localStringBuilder.append(this.a.getScrollX());
        localStringBuilder.append("  left width = ");
        localStringBuilder.append(-i1);
        localStringBuilder.append("  duration=");
        localStringBuilder.append(i2);
        QLog.i("WebLog_SwipeBackLayout", 2, localStringBuilder.toString());
      }
      this.q.sendEmptyMessageDelayed(1, 800L);
      postInvalidate();
      return;
    }
    catch (Exception localException)
    {
      break label85;
    }
  }
  
  protected boolean a(MotionEvent paramMotionEvent)
  {
    Object localObject = this.l;
    if ((localObject != null) && (localObject != null) && (((WebViewFragment)localObject).getWebView() != null))
    {
      localObject = ((WebViewFragment)localObject).getWebView();
      ((CustomWebView)localObject).getContentHeight();
      ((CustomWebView)localObject).getView().getHeight();
      ((CustomWebView)localObject).getWebScrollY();
      float f1 = ((CustomWebView)localObject).getScale();
      if (f1 > 0.0F)
      {
        int i1 = (int)((paramMotionEvent.getX() + ((CustomWebView)localObject).getWebScrollX()) / f1);
        int i2 = (int)((paramMotionEvent.getY() + ((CustomWebView)localObject).getWebScrollY()) / f1);
        return this.m.a(new Point(i1, i2));
      }
    }
    return false;
  }
  
  protected void b()
  {
    try
    {
      int i1 = this.a.getScrollX();
      this.r.startScroll(this.a.getScrollX(), 0, -i1, 0, Math.abs(i1));
      postInvalidate();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void computeScroll()
  {
    if (this.r.computeScrollOffset())
    {
      this.a.scrollTo(this.r.getCurrX(), this.r.getCurrY());
      postInvalidate();
      if ((this.r.isFinished()) && (this.h))
      {
        WebViewFragment localWebViewFragment = this.l;
        if (localWebViewFragment != null)
        {
          localWebViewFragment.flingLToR();
          a();
        }
      }
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.v) && (this.u))
    {
      ViewPager localViewPager = a(this.i, paramMotionEvent);
      if ((localViewPager != null) && (localViewPager.getCurrentItem() != 0)) {
        return super.onInterceptTouchEvent(paramMotionEvent);
      }
      int i1 = paramMotionEvent.getAction();
      if (i1 != 0)
      {
        if ((i1 == 2) && (this.n) && ((int)paramMotionEvent.getRawX() - this.c > this.b) && (Math.abs((int)paramMotionEvent.getRawY() - this.d) < this.b)) {
          return true;
        }
      }
      else
      {
        this.n = false;
        i1 = (int)paramMotionEvent.getRawX();
        this.e = i1;
        this.c = i1;
        this.d = ((int)paramMotionEvent.getRawY());
        if ((this.c < this.f / 3) && ((this.m.a()) || (!a(paramMotionEvent))) && (this.o)) {
          this.n = true;
        }
      }
      return this.t.onTouchEvent(paramMotionEvent);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      this.f = getWidth();
      a(this.i, this);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.u) && (this.v))
    {
      int i1 = paramMotionEvent.getAction();
      StringBuilder localStringBuilder;
      if (i1 != 1)
      {
        if ((i1 == 2) && (this.n))
        {
          i1 = (int)paramMotionEvent.getRawX();
          int i2 = this.e - i1;
          this.e = i1;
          if ((i1 - this.c > this.b) && (Math.abs((int)paramMotionEvent.getRawY() - this.d) < this.b)) {
            this.g = true;
          }
          if ((i1 - this.c > 0) && (this.g))
          {
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("moveX:");
              localStringBuilder.append(i1);
              localStringBuilder.append("downX:");
              localStringBuilder.append(this.c);
              localStringBuilder.append("deltaX:");
              localStringBuilder.append(i2);
              QLog.i("WebLog_SwipeBackLayout", 2, localStringBuilder.toString());
            }
            this.a.scrollBy(i2, 0);
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
          QLog.i("WebLog_SwipeBackLayout", 2, localStringBuilder.toString());
        }
        if (paramMotionEvent.getRawX() - this.c >= this.p / 2)
        {
          this.h = true;
          a();
        }
        else
        {
          postDelayed(new SwipeBackLayout.2(this), 100L);
          this.h = false;
        }
      }
      return this.t.onTouchEvent(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setWebViewFragment(WebViewFragment paramWebViewFragment)
  {
    this.l = paramWebViewFragment;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.SwipeBackLayout
 * JD-Core Version:    0.7.0.1
 */