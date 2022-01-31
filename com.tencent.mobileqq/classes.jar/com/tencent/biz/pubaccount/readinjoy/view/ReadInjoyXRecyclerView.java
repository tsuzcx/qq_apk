package com.tencent.biz.pubaccount.readinjoy.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import bfyu;
import bfyw;
import bfze;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoySkinAnimManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.pull2refresh.XLoadMoreLayout;
import rgf;
import rgg;
import rgh;
import rgi;
import rgj;
import rgk;
import rqq;

public class ReadInjoyXRecyclerView
  extends AbsPullToRefreshViewFix
  implements bfyw, bfze
{
  public static int b = 1001;
  private Handler jdField_a_of_type_AndroidOsHandler = new rgf(this, Looper.getMainLooper());
  private bfyu jdField_a_of_type_Bfyu;
  protected RecyclerViewWithHeaderFooterFix a;
  private XLoadMoreLayout jdField_a_of_type_ComTencentWidgetPull2refreshXLoadMoreLayout;
  private ThreadLocal<Boolean> jdField_a_of_type_JavaLangThreadLocal = new rgg(this);
  private rgj jdField_a_of_type_Rgj;
  private int c = 0;
  private int d;
  private int e;
  public boolean e;
  
  public ReadInjoyXRecyclerView(Context paramContext)
  {
    super(paramContext);
    this.jdField_e_of_type_Boolean = true;
    g();
  }
  
  public ReadInjoyXRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_e_of_type_Boolean = true;
    g();
  }
  
  public ReadInjoyXRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_e_of_type_Boolean = true;
    g();
  }
  
  private boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramView instanceof rgk)) {
      return ((rgk)paramView).a(paramMotionEvent);
    }
    if ((paramView instanceof HorizontalListView))
    {
      Rect localRect = new Rect();
      paramView.getHitRect(localRect);
      return localRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
    return false;
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(b);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(b, 1500L);
  }
  
  private void g()
  {
    a(this);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXLoadMoreLayout = new XLoadMoreLayout(getContext());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecyclerViewWithHeaderFooterFix = new rgh(this, getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecyclerViewWithHeaderFooterFix, localLayoutParams);
    this.jdField_a_of_type_Bfyu = new bfyu(this.jdField_a_of_type_ComTencentWidgetPull2refreshXLoadMoreLayout, getContext());
    this.jdField_a_of_type_Bfyu.a(true);
    this.jdField_a_of_type_Bfyu.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecyclerViewWithHeaderFooterFix.b(this.jdField_a_of_type_ComTencentWidgetPull2refreshXLoadMoreLayout);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecyclerViewWithHeaderFooterFix.addOnScrollListener(new rgi(this));
  }
  
  protected int a()
  {
    return this.jdField_a_of_type_Rqq.a();
  }
  
  protected View a()
  {
    View localView = this.jdField_a_of_type_Rqq.a(this);
    if ((this.jdField_a_of_type_Rqq instanceof ReadInJoySkinAnimManager))
    {
      setPullHeaderBgDrawable(new ColorDrawable(Color.parseColor("#F7F7F7")));
      return localView;
    }
    setPullHeaderBgDrawable(getResources().getDrawable(2130839135));
    return localView;
  }
  
  public RecyclerViewWithHeaderFooterFix a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecyclerViewWithHeaderFooterFix;
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt) {}
  
  public void a(View paramView)
  {
    if ((this.jdField_a_of_type_Rqq != null) && (paramView == this.jdField_a_of_type_Rqq.a(this))) {
      this.jdField_a_of_type_Rqq.a(100, this.jdField_a_of_type_Boolean);
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_Rqq != null) && (paramView == this.jdField_a_of_type_Rqq.a(this))) {
      this.jdField_a_of_type_Rqq.a(paramInt, this.jdField_a_of_type_Boolean);
    }
  }
  
  public void a(View paramView, boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.jdField_e_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_Rqq != null)
    {
      f();
      this.jdField_a_of_type_Rqq.a(paramBoolean, paramString);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("XRecyclerView", 2, "loadMoreComplete(): hasMoreData=" + paramBoolean2);
    }
    this.jdField_a_of_type_Bfyu.a(paramBoolean1, paramBoolean2);
    this.jdField_a_of_type_Bfyu.a(paramBoolean2);
  }
  
  @TargetApi(14)
  protected boolean a()
  {
    return !this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecyclerViewWithHeaderFooterFix.canScrollVertically(-1);
  }
  
  protected boolean a(MotionEvent paramMotionEvent)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecyclerViewWithHeaderFooterFix.getLayoutManager();
    if ((localObject instanceof StaggeredGridLayoutManager))
    {
      localObject = (StaggeredGridLayoutManager)localObject;
      int[] arrayOfInt = new int[2];
      ((StaggeredGridLayoutManager)localObject).findFirstVisibleItemPositions(arrayOfInt);
      return a(((StaggeredGridLayoutManager)localObject).findViewByPosition(arrayOfInt[0]), paramMotionEvent);
    }
    if ((localObject instanceof LinearLayoutManager))
    {
      localObject = (LinearLayoutManager)localObject;
      return a(((LinearLayoutManager)localObject).findViewByPosition(((LinearLayoutManager)localObject).findFirstVisibleItemPosition()), paramMotionEvent);
    }
    return false;
  }
  
  public boolean a(View paramView)
  {
    boolean bool = ((Boolean)this.jdField_a_of_type_JavaLangThreadLocal.get()).booleanValue();
    this.jdField_a_of_type_JavaLangThreadLocal.set(Boolean.valueOf(false));
    if ((this.jdField_a_of_type_Rqq != null) && (paramView == this.jdField_a_of_type_Rqq.a(this)))
    {
      this.jdField_a_of_type_Rqq.a(bool);
      if (this.jdField_a_of_type_Rgj != null) {
        this.jdField_a_of_type_Rgj.a(this, bool);
      }
    }
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Rgj != null) {
      this.jdField_a_of_type_Rgj.a(this, 0);
    }
    return true;
  }
  
  protected View b()
  {
    return null;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Rqq != null) {
      this.jdField_a_of_type_Rqq.b();
    }
    b(true);
  }
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (this.jdField_a_of_type_Rgj != null) {
      this.jdField_a_of_type_Rgj.m();
    }
  }
  
  @TargetApi(14)
  protected boolean b()
  {
    return !this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecyclerViewWithHeaderFooterFix.canScrollVertically(1);
  }
  
  public void c() {}
  
  protected void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecyclerViewWithHeaderFooterFix.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaLangThreadLocal.set(Boolean.valueOf(true));
    a(1);
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecyclerViewWithHeaderFooterFix.stopScroll();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecyclerViewWithHeaderFooterFix.scrollToPosition(0);
  }
  
  public void setRefreshCallback(rgj paramrgj)
  {
    this.jdField_a_of_type_Rgj = paramrgj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyXRecyclerView
 * JD-Core Version:    0.7.0.1
 */