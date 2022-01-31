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
import biep;
import bier;
import biez;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoySkinAnimManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.pull2refresh.XLoadMoreLayout;
import rvy;
import rvz;
import rwa;
import rwb;
import rwc;
import rwd;
import sgm;

public class ReadInjoyXRecyclerView
  extends AbsPullToRefreshViewFix
  implements bier, biez
{
  public static int b = 1001;
  private Handler jdField_a_of_type_AndroidOsHandler = new rvy(this, Looper.getMainLooper());
  private biep jdField_a_of_type_Biep;
  protected RecyclerViewWithHeaderFooterFix a;
  private XLoadMoreLayout jdField_a_of_type_ComTencentWidgetPull2refreshXLoadMoreLayout;
  private ThreadLocal<Boolean> jdField_a_of_type_JavaLangThreadLocal = new rvz(this);
  private rwc jdField_a_of_type_Rwc;
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
    if ((paramView instanceof rwd)) {
      return ((rwd)paramView).a(paramMotionEvent);
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecyclerViewWithHeaderFooterFix = new rwa(this, getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecyclerViewWithHeaderFooterFix, localLayoutParams);
    this.jdField_a_of_type_Biep = new biep(this.jdField_a_of_type_ComTencentWidgetPull2refreshXLoadMoreLayout, getContext());
    this.jdField_a_of_type_Biep.a(true);
    this.jdField_a_of_type_Biep.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecyclerViewWithHeaderFooterFix.b(this.jdField_a_of_type_ComTencentWidgetPull2refreshXLoadMoreLayout);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecyclerViewWithHeaderFooterFix.addOnScrollListener(new rwb(this));
  }
  
  protected int a()
  {
    return this.jdField_a_of_type_Sgm.a();
  }
  
  protected View a()
  {
    View localView = this.jdField_a_of_type_Sgm.a(this);
    if ((this.jdField_a_of_type_Sgm instanceof ReadInJoySkinAnimManager))
    {
      setPullHeaderBgDrawable(new ColorDrawable(Color.parseColor("#F7F7F7")));
      return localView;
    }
    setPullHeaderBgDrawable(getResources().getDrawable(2130839220));
    return localView;
  }
  
  public RecyclerViewWithHeaderFooterFix a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRecyclerViewWithHeaderFooterFix;
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt) {}
  
  public void a(View paramView)
  {
    if ((this.jdField_a_of_type_Sgm != null) && (paramView == this.jdField_a_of_type_Sgm.a(this))) {
      this.jdField_a_of_type_Sgm.a(100, this.jdField_a_of_type_Boolean);
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_Sgm != null) && (paramView == this.jdField_a_of_type_Sgm.a(this))) {
      this.jdField_a_of_type_Sgm.a(paramInt, this.jdField_a_of_type_Boolean);
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
    if (this.jdField_a_of_type_Sgm != null)
    {
      f();
      this.jdField_a_of_type_Sgm.a(paramBoolean, paramString);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("XRecyclerView", 2, "loadMoreComplete(): hasMoreData=" + paramBoolean2);
    }
    this.jdField_a_of_type_Biep.a(paramBoolean1, paramBoolean2);
    this.jdField_a_of_type_Biep.a(paramBoolean2);
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
    if ((this.jdField_a_of_type_Sgm != null) && (paramView == this.jdField_a_of_type_Sgm.a(this)))
    {
      this.jdField_a_of_type_Sgm.a(bool);
      if (this.jdField_a_of_type_Rwc != null) {
        this.jdField_a_of_type_Rwc.a(this, bool);
      }
    }
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Rwc != null) {
      this.jdField_a_of_type_Rwc.a(this, 0);
    }
    return true;
  }
  
  protected View b()
  {
    return null;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Sgm != null) {
      this.jdField_a_of_type_Sgm.b();
    }
    b(true);
  }
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (this.jdField_a_of_type_Rwc != null) {
      this.jdField_a_of_type_Rwc.m();
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
  
  public void setRefreshCallback(rwc paramrwc)
  {
    this.jdField_a_of_type_Rwc = paramrwc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyXRecyclerView
 * JD-Core Version:    0.7.0.1
 */