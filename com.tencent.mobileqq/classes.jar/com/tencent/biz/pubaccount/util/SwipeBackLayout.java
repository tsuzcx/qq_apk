package com.tencent.biz.pubaccount.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.view.ViewPager;
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
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import shv;
import sir;
import sis;

public class SwipeBackLayout
  extends RelativeLayout
{
  protected int a;
  public Context a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  final Handler jdField_a_of_type_AndroidOsHandler = new sir(this);
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  protected View a;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  public WebViewFragment a;
  protected List<ViewPager> a;
  public shv a;
  protected boolean a;
  protected int b;
  protected boolean b;
  protected int c;
  public volatile boolean c;
  protected int d;
  public boolean d;
  protected int e;
  protected boolean e;
  protected int f;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  
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
    this.jdField_a_of_type_Shv = new shv();
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130842140);
    this.jdField_f_of_type_Int = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
  }
  
  public SwipeBackLayout(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, null);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_e_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new sis(this, paramContext));
  }
  
  private void a(List<ViewPager> paramList, ViewGroup paramViewGroup)
  {
    int k = paramViewGroup.getChildCount();
    int j = 0;
    if (j < k)
    {
      View localView = paramViewGroup.getChildAt(j);
      if ((localView instanceof ViewPager)) {
        paramList.add((ViewPager)localView);
      }
      for (;;)
      {
        j += 1;
        break;
        if ((localView instanceof ViewGroup)) {
          a(paramList, (ViewGroup)localView);
        }
      }
    }
  }
  
  protected ViewPager a(List<ViewPager> paramList, MotionEvent paramMotionEvent)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
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
    return null;
  }
  
  public void a()
  {
    if (this.h) {
      return;
    }
    this.h = true;
    int j = this.jdField_e_of_type_Int + this.jdField_a_of_type_AndroidViewView.getScrollX();
    int k = (int)(j * 1.0D / this.jdField_e_of_type_Int * 700.0D);
    try
    {
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(this.jdField_a_of_type_AndroidViewView.getScrollX(), 0, -j + 1, 0, Math.abs(k));
      label66:
      if (QLog.isColorLevel()) {
        QLog.i("WebLog_SwipeBackLayout", 2, "SwipeBackLayout scrollRight viewwithd=" + this.jdField_e_of_type_Int + "  startx+ " + this.jdField_a_of_type_AndroidViewView.getScrollX() + "  left width = " + -j + "  duration=" + k);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 800L);
      postInvalidate();
      return;
    }
    catch (Exception localException)
    {
      break label66;
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment;
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((WebViewFragment)localObject).getWebView() != null)
        {
          localObject = ((WebViewFragment)localObject).getWebView();
          ((CustomWebView)localObject).getContentHeight();
          ((CustomWebView)localObject).getView().getHeight();
          ((CustomWebView)localObject).getWebScrollY();
          float f1 = ((CustomWebView)localObject).getScale();
          bool1 = bool2;
          if (f1 > 0.0F)
          {
            int j = (int)((paramMotionEvent.getX() + ((CustomWebView)localObject).getWebScrollX()) / f1);
            float f2 = paramMotionEvent.getY();
            int k = (int)((((CustomWebView)localObject).getWebScrollY() + f2) / f1);
            bool1 = this.jdField_a_of_type_Shv.a(new Point(j, k));
          }
        }
      }
    }
    return bool1;
  }
  
  public void b()
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
      if ((this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) && (this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.G();
        a();
      }
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!this.g) || (!this.jdField_f_of_type_Boolean)) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    ViewPager localViewPager = a(this.jdField_a_of_type_JavaUtilList, paramMotionEvent);
    if ((localViewPager != null) && (localViewPager.getCurrentItem() != 0)) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      for (;;)
      {
        return this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
        this.jdField_d_of_type_Boolean = false;
        int j = (int)paramMotionEvent.getRawX();
        this.jdField_d_of_type_Int = j;
        this.jdField_b_of_type_Int = j;
        this.c = ((int)paramMotionEvent.getRawY());
        if ((this.jdField_b_of_type_Int < this.jdField_e_of_type_Int / 3) && ((this.jdField_a_of_type_Shv.a()) || (!a(paramMotionEvent))) && (this.jdField_e_of_type_Boolean)) {
          this.jdField_d_of_type_Boolean = true;
        }
      }
    } while ((!this.jdField_d_of_type_Boolean) || ((int)paramMotionEvent.getRawX() - this.jdField_b_of_type_Int <= this.jdField_a_of_type_Int) || (Math.abs((int)paramMotionEvent.getRawY() - this.c) >= this.jdField_a_of_type_Int));
    return true;
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
    if ((!this.jdField_f_of_type_Boolean) || (!this.g)) {
      return super.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
      if (this.jdField_d_of_type_Boolean)
      {
        int j = (int)paramMotionEvent.getRawX();
        int k = this.jdField_d_of_type_Int - j;
        this.jdField_d_of_type_Int = j;
        if ((j - this.jdField_b_of_type_Int > this.jdField_a_of_type_Int) && (Math.abs((int)paramMotionEvent.getRawY() - this.c) < this.jdField_a_of_type_Int)) {
          this.jdField_a_of_type_Boolean = true;
        }
        if ((j - this.jdField_b_of_type_Int > 0) && (this.jdField_a_of_type_Boolean))
        {
          if (QLog.isColorLevel()) {
            QLog.i("WebLog_SwipeBackLayout", 2, "moveX:" + j + "downX:" + this.jdField_b_of_type_Int + "deltaX:" + k);
          }
          this.jdField_a_of_type_AndroidViewView.scrollBy(k, 0);
          continue;
          if (this.jdField_d_of_type_Boolean)
          {
            this.jdField_a_of_type_Boolean = false;
            if (QLog.isColorLevel()) {
              QLog.i("WebLog_SwipeBackLayout", 2, "event.getRawX():" + paramMotionEvent.getRawX() + "screenWidth:" + this.jdField_f_of_type_Int + "viewWidth:" + this.jdField_e_of_type_Int);
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
        }
      }
    }
  }
  
  public void setWebViewFragment(WebViewFragment paramWebViewFragment)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment = paramWebViewFragment;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.SwipeBackLayout
 * JD-Core Version:    0.7.0.1
 */