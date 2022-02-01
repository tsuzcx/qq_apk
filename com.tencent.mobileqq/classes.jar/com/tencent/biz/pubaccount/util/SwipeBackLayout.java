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
  protected int a;
  protected Context a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  final Handler jdField_a_of_type_AndroidOsHandler = new SwipeBackLayout.1(this);
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  protected View a;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  protected ReadinjoyH5ElementManager a;
  protected WebViewFragment a;
  protected List<ViewPager> a;
  protected boolean a;
  protected int b;
  protected boolean b;
  protected int c;
  protected volatile boolean c;
  protected int d;
  protected boolean d;
  protected int e;
  protected boolean e;
  protected int f;
  private boolean f;
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  
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
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_f_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizDetailWebReadinjoyH5ElementManager = new ReadinjoyH5ElementManager();
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130842751);
    this.jdField_f_of_type_Int = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
  }
  
  public SwipeBackLayout(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, null);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_e_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new SwipeBackLayout.KandianGestureDetector(this, paramContext));
  }
  
  private void a(List<ViewPager> paramList, ViewGroup paramViewGroup)
  {
    int k = paramViewGroup.getChildCount();
    int j = 0;
    while (j < k)
    {
      View localView = paramViewGroup.getChildAt(j);
      if ((localView instanceof ViewPager)) {
        paramList.add((ViewPager)localView);
      } else if ((localView instanceof ViewGroup)) {
        a(paramList, (ViewGroup)localView);
      }
      j += 1;
    }
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
    if (this.h) {
      return;
    }
    this.h = true;
    int j = this.jdField_e_of_type_Int + this.jdField_a_of_type_AndroidViewView.getScrollX();
    double d1 = j;
    Double.isNaN(d1);
    double d2 = this.jdField_e_of_type_Int;
    Double.isNaN(d2);
    int k = (int)(d1 * 1.0D / d2 * 700.0D);
    try
    {
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(this.jdField_a_of_type_AndroidViewView.getScrollX(), 0, -j + 1, 0, Math.abs(k));
      label85:
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("SwipeBackLayout scrollRight viewwithd=");
        localStringBuilder.append(this.jdField_e_of_type_Int);
        localStringBuilder.append("  startx+ ");
        localStringBuilder.append(this.jdField_a_of_type_AndroidViewView.getScrollX());
        localStringBuilder.append("  left width = ");
        localStringBuilder.append(-j);
        localStringBuilder.append("  duration=");
        localStringBuilder.append(k);
        QLog.i("WebLog_SwipeBackLayout", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 800L);
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment;
    if ((localObject != null) && (localObject != null) && (((WebViewFragment)localObject).getWebView() != null))
    {
      localObject = ((WebViewFragment)localObject).getWebView();
      ((CustomWebView)localObject).getContentHeight();
      ((CustomWebView)localObject).getView().getHeight();
      ((CustomWebView)localObject).getWebScrollY();
      float f1 = ((CustomWebView)localObject).getScale();
      if (f1 > 0.0F)
      {
        int j = (int)((paramMotionEvent.getX() + ((CustomWebView)localObject).getWebScrollX()) / f1);
        int k = (int)((paramMotionEvent.getY() + ((CustomWebView)localObject).getWebScrollY()) / f1);
        return this.jdField_a_of_type_ComTencentMobileqqKandianBizDetailWebReadinjoyH5ElementManager.a(new Point(j, k));
      }
    }
    return false;
  }
  
  protected void b()
  {
    try
    {
      int j = this.jdField_a_of_type_AndroidViewView.getScrollX();
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(this.jdField_a_of_type_AndroidViewView.getScrollX(), 0, -j, 0, Math.abs(j));
      postInvalidate();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      this.jdField_a_of_type_AndroidViewView.scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
      postInvalidate();
      if ((this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) && (this.jdField_b_of_type_Boolean))
      {
        WebViewFragment localWebViewFragment = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment;
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
    if ((this.g) && (this.jdField_f_of_type_Boolean))
    {
      ViewPager localViewPager = a(this.jdField_a_of_type_JavaUtilList, paramMotionEvent);
      if ((localViewPager != null) && (localViewPager.getCurrentItem() != 0)) {
        return super.onInterceptTouchEvent(paramMotionEvent);
      }
      int j = paramMotionEvent.getAction();
      if (j != 0)
      {
        if ((j == 2) && (this.jdField_d_of_type_Boolean) && ((int)paramMotionEvent.getRawX() - this.jdField_b_of_type_Int > this.jdField_a_of_type_Int) && (Math.abs((int)paramMotionEvent.getRawY() - this.c) < this.jdField_a_of_type_Int)) {
          return true;
        }
      }
      else
      {
        this.jdField_d_of_type_Boolean = false;
        j = (int)paramMotionEvent.getRawX();
        this.jdField_d_of_type_Int = j;
        this.jdField_b_of_type_Int = j;
        this.c = ((int)paramMotionEvent.getRawY());
        if ((this.jdField_b_of_type_Int < this.jdField_e_of_type_Int / 3) && ((this.jdField_a_of_type_ComTencentMobileqqKandianBizDetailWebReadinjoyH5ElementManager.a()) || (!a(paramMotionEvent))) && (this.jdField_e_of_type_Boolean)) {
          this.jdField_d_of_type_Boolean = true;
        }
      }
      return this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      this.jdField_e_of_type_Int = getWidth();
      a(this.jdField_a_of_type_JavaUtilList, this);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_f_of_type_Boolean) && (this.g))
    {
      int j = paramMotionEvent.getAction();
      StringBuilder localStringBuilder;
      if (j != 1)
      {
        if ((j == 2) && (this.jdField_d_of_type_Boolean))
        {
          j = (int)paramMotionEvent.getRawX();
          int k = this.jdField_d_of_type_Int - j;
          this.jdField_d_of_type_Int = j;
          if ((j - this.jdField_b_of_type_Int > this.jdField_a_of_type_Int) && (Math.abs((int)paramMotionEvent.getRawY() - this.c) < this.jdField_a_of_type_Int)) {
            this.jdField_a_of_type_Boolean = true;
          }
          if ((j - this.jdField_b_of_type_Int > 0) && (this.jdField_a_of_type_Boolean))
          {
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("moveX:");
              localStringBuilder.append(j);
              localStringBuilder.append("downX:");
              localStringBuilder.append(this.jdField_b_of_type_Int);
              localStringBuilder.append("deltaX:");
              localStringBuilder.append(k);
              QLog.i("WebLog_SwipeBackLayout", 2, localStringBuilder.toString());
            }
            this.jdField_a_of_type_AndroidViewView.scrollBy(k, 0);
          }
        }
      }
      else if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("event.getRawX():");
          localStringBuilder.append(paramMotionEvent.getRawX());
          localStringBuilder.append("screenWidth:");
          localStringBuilder.append(this.jdField_f_of_type_Int);
          localStringBuilder.append("viewWidth:");
          localStringBuilder.append(this.jdField_e_of_type_Int);
          QLog.i("WebLog_SwipeBackLayout", 2, localStringBuilder.toString());
        }
        if (paramMotionEvent.getRawX() - this.jdField_b_of_type_Int >= this.jdField_f_of_type_Int / 2)
        {
          this.jdField_b_of_type_Boolean = true;
          a();
        }
        else
        {
          postDelayed(new SwipeBackLayout.2(this), 100L);
          this.jdField_b_of_type_Boolean = false;
        }
      }
      return this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setWebViewFragment(WebViewFragment paramWebViewFragment)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment = paramWebViewFragment;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.SwipeBackLayout
 * JD-Core Version:    0.7.0.1
 */