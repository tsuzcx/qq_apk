package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoyAnimBaseManager;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoyAnimBaseManager.PullRefreshComplete;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoyRefreshAnimFactory;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoySkinAnimManager;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.HeaderViewListAdapter;
import com.tencent.widget.ListView;
import mie;

public class ReadInJoyXListView
  extends ReadInJoyBaseListView
  implements ReadInJoyOverScrollViewListener
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ReadInJoyAnimBaseManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager;
  private ThreadLocal jdField_a_of_type_JavaLangThreadLocal = new mie(this);
  protected boolean c;
  private boolean d;
  protected int e;
  private boolean e;
  protected int f;
  private boolean f;
  private boolean g = true;
  
  public ReadInJoyXListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyXListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ReadInJoyXListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_f_of_type_Boolean)
    {
      if (this.mFirstPosition == 0)
      {
        QLog.d("ReadInJoyXListView", 2, "scroll2Top : stop on top,refresh ! from : " + paramInt);
        f();
        this.jdField_f_of_type_Boolean = false;
      }
    }
    else {
      return;
    }
    QLog.d("ReadInJoyXListView", 2, "scroll2Top : not on top, jump to top and refresh. from : " + paramInt);
    if (paramInt != 3)
    {
      this.jdField_f_of_type_Boolean = false;
      if ((getAdapter() instanceof HeaderViewListAdapter)) {
        setAdapter(((HeaderViewListAdapter)getAdapter()).getWrappedAdapter());
      }
      for (;;)
      {
        f();
        return;
        setAdapter(getAdapter());
      }
    }
    e();
  }
  
  private void a(long paramLong)
  {
    if (this.d)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, paramLong);
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager != null)
    {
      setOverScrollHeader(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager.a(this));
      setOverScrollListener(this);
      setOverScrollHeight(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager.a());
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager instanceof ReadInJoySkinAnimManager)) {
        setOverscrollHeader(new ColorDrawable(Color.parseColor("#F7F7F7")));
      }
    }
    else
    {
      return;
    }
    setOverscrollHeader(getResources().getDrawable(2130838586));
  }
  
  public void a(int paramInt, View paramView, ListView paramListView) {}
  
  public void a(int paramInt1, View paramView, ListView paramListView, int paramInt2)
  {
    if (paramListView != this) {}
    while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager == null) || (paramView != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager.a(this)) || (this.c)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager.a(paramInt2, this.d);
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super.a(paramContext, paramAttributeSet);
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ReadInJoyXListView);
    this.jdField_e_of_type_Boolean = paramContext.getBoolean(0, false);
    paramContext.recycle();
    this.jdField_f_of_type_Int = ((int)DeviceInfoUtil.k());
  }
  
  public void a(View paramView, ListView paramListView, int paramInt)
  {
    if (paramListView != this) {}
    while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager == null) || (paramView != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager.a(this)) || (this.c)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager.a(paramInt);
  }
  
  public void a(ReadInJoyAnimBaseManager.PullRefreshComplete paramPullRefreshComplete)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager.a(paramPullRefreshComplete);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    super.a(paramAbsListView, paramInt);
    if (paramInt == 0)
    {
      a(3);
      if (!(getContext() instanceof ReadInJoyNewFeedsActivity)) {
        break label38;
      }
      ((ReadInJoyNewFeedsActivity)getContext()).g(8);
    }
    label38:
    do
    {
      do
      {
        return;
      } while (!(getContext() instanceof SplashActivity));
      paramAbsListView = ReadInJoyUtils.a(getContext());
    } while (paramAbsListView == null);
    paramAbsListView.a(8);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (paramInt1 == 0)
    {
      paramAbsListView = getChildAt(0);
      if ((paramAbsListView == null) || (paramAbsListView.getTop() < 0)) {}
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (paramListView != this) {}
    boolean bool;
    do
    {
      do
      {
        return true;
        bool = ((Boolean)this.jdField_a_of_type_JavaLangThreadLocal.get()).booleanValue();
        this.jdField_a_of_type_JavaLangThreadLocal.set(Boolean.valueOf(false));
      } while ((this.d) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager == null) || (paramView != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager.a(this)));
      if (!this.c) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager.a(bool);
      }
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$RefreshCallback == null);
    this.d = true;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$RefreshCallback.a(this, bool);
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager.b();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager = null;
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (paramListView != this) {}
    while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager == null) || (paramView != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager.a(this)) || (this.d) || (this.c)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager.a(100, false);
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      a(2);
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager instanceof ReadInJoySkinAnimManager))) {
      ((ReadInJoySkinAnimManager)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager).c();
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager instanceof ReadInJoySkinAnimManager))) {
      ((ReadInJoySkinAnimManager)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager).d();
    }
  }
  
  public void e()
  {
    if (this.d) {
      return;
    }
    smoothScrollBy(0, 0);
    View localView;
    boolean bool;
    if (this.mFirstPosition == 0)
    {
      localView = getChildAt(0);
      if (localView == null) {
        bool = false;
      }
    }
    for (;;)
    {
      if (bool)
      {
        this.jdField_f_of_type_Boolean = true;
        smoothScrollToPosition(0);
      }
      for (;;)
      {
        QLog.d("ReadInJoyXListView", 2, "scroll2TopAndRefresh needScroll : " + bool);
        return;
        if (localView.getTop() - getPaddingTop() != 0) {
          break label98;
        }
        bool = false;
        break;
        f();
      }
      label98:
      bool = true;
    }
  }
  
  public void f()
  {
    if (this.d) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaLangThreadLocal.set(Boolean.valueOf(true));
      showOverScrollHeader();
    } while ((this.c) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager == null));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager.a();
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager != null) && (this.d)) {
      a(0L);
    }
  }
  
  public void h()
  {
    this.d = false;
    springBackOverScrollHeaderView();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$RefreshCallback != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$RefreshCallback.b();
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(new ReadInJoyXListView.UICallBack(this, this));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.g)
    {
      PublicTracker.a("KANDIAN_NEW_FEEDS_LOAD_ARTICLE_FINISH_TO_MEASURE", null);
      PublicTracker.a(null, "KANDIAN_NEW_FEEDS_LIST_VIEW_GROUP_MEASURE_LAYOUT_DRAW");
      this.g = false;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_f_of_type_Boolean)
    {
      QLog.d("ReadInJoyXListView", 2, "scroll2Top catch user touch event!");
      return true;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.jdField_e_of_type_Int = ((int)paramMotionEvent.getRawY());
      continue;
      this.b = ((int)paramMotionEvent.getRawY() - this.jdField_e_of_type_Int);
      continue;
      FrameHelperActivity.b(true);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager instanceof ReadInJoySkinAnimManager))) {
        ((ReadInJoySkinAnimManager)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager).e();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (!paramBoolean) {
      a(1);
    }
  }
  
  public void setAnimType(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyXListView", 1, "setAnimType animType = " + paramInt);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager instanceof ReadInJoySkinAnimManager))) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager.b();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshReadInJoyAnimBaseManager = ReadInJoyRefreshAnimFactory.a(getContext(), paramInt);
    if (this.jdField_e_of_type_Boolean) {
      i();
    }
  }
  
  public void setNeedShowHeaderView(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
    i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView
 * JD-Core Version:    0.7.0.1
 */