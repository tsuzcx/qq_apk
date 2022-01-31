package com.tencent.biz.pubaccount.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
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
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Scroller;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mww;
import mwx;

public class SwipeBackLayout
  extends FrameLayout
{
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  final Handler jdField_a_of_type_AndroidOsHandler = new mww(this);
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private View jdField_a_of_type_AndroidViewView;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private ReadinjoyH5ElementManager jdField_a_of_type_ComTencentBizPubaccountUtilReadinjoyH5ElementManager = new ReadinjoyH5ElementManager();
  private WebViewFragment jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment;
  private List jdField_a_of_type_JavaUtilList = new LinkedList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private volatile boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = true;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private boolean g;
  private boolean h;
  
  public SwipeBackLayout(Context paramContext)
  {
    this(paramContext, null);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new SwipeBackLayout.KandianGestureDetector(this, paramContext));
  }
  
  public SwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130840684);
    this.jdField_f_of_type_Int = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
  }
  
  private ViewPager a(List paramList, MotionEvent paramMotionEvent)
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
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = ((View)paramView.getParent());
  }
  
  private void a(List paramList, ViewGroup paramViewGroup)
  {
    int j = paramViewGroup.getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof ViewPager)) {
        paramList.add((ViewPager)localView);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localView instanceof ViewGroup)) {
          a(paramList, (ViewGroup)localView);
        }
      }
    }
  }
  
  private boolean a(MotionEvent paramMotionEvent)
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
        if (((WebViewFragment)localObject).a() != null)
        {
          localObject = ((WebViewFragment)localObject).a();
          ((CustomWebView)localObject).getContentHeight();
          ((CustomWebView)localObject).getView().getHeight();
          ((CustomWebView)localObject).getWebScrollY();
          float f1 = ((CustomWebView)localObject).getScale();
          bool1 = bool2;
          if (f1 > 0.0F)
          {
            int i = (int)((paramMotionEvent.getX() + ((CustomWebView)localObject).getWebScrollX()) / f1);
            float f2 = paramMotionEvent.getY();
            int j = (int)((((CustomWebView)localObject).getWebScrollY() + f2) / f1);
            bool1 = this.jdField_a_of_type_ComTencentBizPubaccountUtilReadinjoyH5ElementManager.a(new Point(i, j));
          }
        }
      }
    }
    return bool1;
  }
  
  private void b()
  {
    if (this.g) {
      return;
    }
    this.g = true;
    int i = this.jdField_e_of_type_Int + this.jdField_a_of_type_AndroidViewView.getScrollX();
    int j = (int)(i * 1.0D / this.jdField_e_of_type_Int * 700.0D);
    try
    {
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(this.jdField_a_of_type_AndroidViewView.getScrollX(), 0, -i + 1, 0, Math.abs(j));
      label66:
      if (QLog.isColorLevel()) {
        QLog.i("WebLog_SwipeBackLayout", 2, "SwipeBackLayout scrollRight viewwithd=" + this.jdField_e_of_type_Int + "  startx+ " + this.jdField_a_of_type_AndroidViewView.getScrollX() + "  left width = " + -i + "  duration=" + j);
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
  
  private void c()
  {
    try
    {
      int i = this.jdField_a_of_type_AndroidViewView.getScrollX();
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(this.jdField_a_of_type_AndroidViewView.getScrollX(), 0, -i, 0, Math.abs(i));
      postInvalidate();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_SwipeBackLayout", 2, "SwipeBackLayout destroy()");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    Object localObject = paramActivity.getTheme().obtainStyledAttributes(new int[] { 16842836 });
    int i = ((TypedArray)localObject).getResourceId(0, 0);
    ((TypedArray)localObject).recycle();
    paramActivity = (ViewGroup)paramActivity.getWindow().getDecorView();
    localObject = (ViewGroup)paramActivity.getChildAt(0);
    ((ViewGroup)localObject).setBackgroundResource(i);
    paramActivity.removeView((View)localObject);
    addView((View)localObject);
    a((View)localObject);
    paramActivity.addView(this);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountUtilReadinjoyH5ElementManager.a(paramString);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountUtilReadinjoyH5ElementManager.a(paramString, new Rect(paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void computeScroll()
  {
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      this.jdField_a_of_type_AndroidViewView.scrollTo(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX(), this.jdField_a_of_type_AndroidWidgetScroller.getCurrY());
      postInvalidate();
      if ((this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) && (this.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.A();
        b();
      }
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!this.jdField_e_of_type_Boolean) || (!this.jdField_d_of_type_Boolean)) {
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
        this.jdField_f_of_type_Boolean = false;
        int i = (int)paramMotionEvent.getRawX();
        this.jdField_d_of_type_Int = i;
        this.jdField_b_of_type_Int = i;
        this.jdField_c_of_type_Int = ((int)paramMotionEvent.getRawY());
        if ((this.jdField_b_of_type_Int < this.jdField_e_of_type_Int / 3) && ((this.jdField_a_of_type_ComTencentBizPubaccountUtilReadinjoyH5ElementManager.a()) || (!a(paramMotionEvent)))) {
          this.jdField_f_of_type_Boolean = true;
        }
      }
    } while ((!this.jdField_f_of_type_Boolean) || ((int)paramMotionEvent.getRawX() - this.jdField_b_of_type_Int <= this.jdField_a_of_type_Int) || (Math.abs((int)paramMotionEvent.getRawY() - this.jdField_c_of_type_Int) >= this.jdField_a_of_type_Int));
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
    if ((!this.jdField_d_of_type_Boolean) || (!this.jdField_e_of_type_Boolean)) {
      return super.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
      if (this.jdField_f_of_type_Boolean)
      {
        int i = (int)paramMotionEvent.getRawX();
        int j = this.jdField_d_of_type_Int - i;
        this.jdField_d_of_type_Int = i;
        if ((i - this.jdField_b_of_type_Int > this.jdField_a_of_type_Int) && (Math.abs((int)paramMotionEvent.getRawY() - this.jdField_c_of_type_Int) < this.jdField_a_of_type_Int)) {
          this.jdField_a_of_type_Boolean = true;
        }
        if ((i - this.jdField_b_of_type_Int > 0) && (this.jdField_a_of_type_Boolean))
        {
          if (QLog.isColorLevel()) {
            QLog.i("WebLog_SwipeBackLayout", 2, "moveX:" + i + "downX:" + this.jdField_b_of_type_Int + "deltaX:" + j);
          }
          this.jdField_a_of_type_AndroidViewView.scrollBy(j, 0);
          continue;
          if (this.jdField_f_of_type_Boolean)
          {
            this.jdField_a_of_type_Boolean = false;
            if (QLog.isColorLevel()) {
              QLog.i("WebLog_SwipeBackLayout", 2, "event.getRawX():" + paramMotionEvent.getRawX() + "screenWidth:" + this.jdField_f_of_type_Int + "viewWidth:" + this.jdField_e_of_type_Int);
            }
            if (paramMotionEvent.getRawX() - this.jdField_b_of_type_Int >= this.jdField_f_of_type_Int / 2)
            {
              this.jdField_b_of_type_Boolean = true;
              b();
            }
            else
            {
              postDelayed(new mwx(this), 100L);
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