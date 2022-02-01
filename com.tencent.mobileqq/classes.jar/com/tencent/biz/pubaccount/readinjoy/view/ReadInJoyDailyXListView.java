package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyDailyViewController;
import com.tencent.biz.pubaccount.readinjoy.common.KandianDailyReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ProteusSupportUtil;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJThreadHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.TemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoyAnimBaseManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.ReadInJoyOverScrollViewListener;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

public class ReadInJoyDailyXListView
  extends ReadInJoyXListView
  implements ReadInJoyOverScrollViewListener
{
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(-1);
  private Container jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  protected List<OverScrollViewListener> a;
  private boolean f = false;
  private boolean g = false;
  
  public ReadInJoyDailyXListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyDailyXListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ReadInJoyDailyXListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private boolean b()
  {
    if (getAdapter() == null) {}
    while (getLastVisiblePosition() < getAdapter().getCount() - 1) {
      return false;
    }
    return true;
  }
  
  private void k()
  {
    if (this.g) {
      return;
    }
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = RIJTransMergeKanDianReport.a();
    String str2 = "0";
    String str1;
    if (ReadInJoyDailyViewController.a() == 1) {
      str1 = "1";
    }
    for (;;)
    {
      localReportR5Builder.b("is_jump", str1);
      localReportR5Builder.b("cmd", ReadInJoyHelper.i());
      if ("1".equals(str1)) {
        localReportR5Builder.b("jump_src", DailyModeConfigHandler.b());
      }
      this.g = true;
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009882", "0X8009882", 0, 0, "", "", "", localReportR5Builder.a(), false);
      return;
      str1 = str2;
      if (!TextUtils.isEmpty(DailyModeConfigHandler.a()))
      {
        str1 = str2;
        if (ReadInJoyDailyViewController.a() == 3) {
          str1 = "1";
        }
      }
    }
  }
  
  public int a()
  {
    return this.mTouchMode;
  }
  
  public ReadInJoyAnimBaseManager a(int paramInt)
  {
    return super.a(paramInt);
  }
  
  protected void a(int paramInt)
  {
    if (!this.f) {
      return;
    }
    if (paramInt != 4)
    {
      setFooterView(true);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$RefreshCallback != null)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718505);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        this.c = 1;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$RefreshCallback.b(this, paramInt);
      }
    }
    for (;;)
    {
      QLog.d("ReadInJoyDailyXListView", 1, new Object[] { "loadingMore mCurrentStatus = ", Integer.valueOf(this.c), ", type = ", Integer.valueOf(paramInt) });
      return;
      setFooterView(true);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718505);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$RefreshCallback != null)
      {
        this.c = 1;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListView$RefreshCallback.b(this, paramInt);
      }
    }
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super.a(paramContext, paramAttributeSet);
    setNeedShowHeaderView(true);
    a(this);
    if (ReadInJoyDailyViewController.a() != 2)
    {
      a(this);
      return;
    }
    setCanLoadMore(true);
  }
  
  public void a(OverScrollViewListener paramOverScrollViewListener)
  {
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      super.setOverScrollListener(new ReadInJoyDailyXListView.3(this));
    }
    this.jdField_a_of_type_JavaUtilList.add(paramOverScrollViewListener);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    removeFooterView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_b_of_type_Int = 0;
  }
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
  }
  
  public void c()
  {
    super.c();
  }
  
  public void d()
  {
    super.d();
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
  }
  
  public void e()
  {
    super.e();
  }
  
  public void f()
  {
    QLog.d("ReadInJoyDailyXListView", 2, "scroll2TopAndRefresh : ");
  }
  
  public void g()
  {
    TemplateBean localTemplateBean = null;
    try
    {
      TemplateFactory localTemplateFactory = TemplateFactory.a("default_feeds", true);
      if (localTemplateFactory != null) {
        localTemplateBean = localTemplateFactory.getTemplateBean(DailyModeConfigHandler.a());
      }
      if ((localTemplateBean != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer != null))
      {
        if (RIJThreadHandler.a())
        {
          ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, null, localTemplateBean);
          return;
        }
        RIJThreadHandler.b().post(new ReadInJoyDailyXListView.2(this, localTemplateBean));
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      QLog.e("ReadInJoyDailyXListView", 1, "onRefreshFooterView, e = " + localJSONException);
    }
  }
  
  public void onNotCompleteVisable(int paramInt1, View paramView, ListView paramListView, int paramInt2)
  {
    if (paramInt1 == 0) {
      super.onNotCompleteVisable(paramInt1, paramView, paramListView, paramInt2);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.f) {
      if (b()) {
        k();
      }
    }
    while ((this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_b_of_type_Int >= 0) || (this.c == 1) || (paramInt1 < paramInt3 - paramInt2 * 2) || (this.jdField_b_of_type_Boolean)) {
      return;
    }
    a(2);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      KandianDailyReportUtils.a(8);
    }
  }
  
  public void onScrollView(View paramView, ListView paramListView, int paramInt) {}
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    super.onViewCompleteVisable(paramInt, paramView, paramListView);
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if ((this.f) && (paramInt == 1))
    {
      a(2);
      return true;
    }
    if (paramInt == 0) {
      return super.onViewCompleteVisableAndReleased(paramInt, paramView, paramListView);
    }
    return false;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(paramListAdapter);
    if ((paramListAdapter != null) && ((paramListAdapter instanceof ReadInJoyBaseAdapter))) {
      ((ReadInJoyBaseAdapter)paramListAdapter).a(new ReadInJoyDailyXListView.1(this));
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    super.setBackgroundColor(-1);
  }
  
  public void setCanLoadMore(boolean paramBoolean)
  {
    this.f = paramBoolean;
    setOverScrollTouchMode(1);
    if ((paramBoolean) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)) {
      a();
    }
  }
  
  public void setChannelId(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setContentBackground(Drawable paramDrawable, boolean paramBoolean)
  {
    super.setContentBackground(this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, false);
  }
  
  public void setFooterView(boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramBoolean) {
      bool = this.f;
    }
    super.setFooterView(bool);
  }
  
  public void setNeedShowFootView(boolean paramBoolean) {}
  
  public void setNeedShowHeaderView(boolean paramBoolean)
  {
    super.setNeedShowHeaderView(paramBoolean);
  }
  
  public void setNoMoreData(boolean paramBoolean) {}
  
  public void setOverScrollListener(OverScrollViewListener paramOverScrollViewListener)
  {
    if (paramOverScrollViewListener != null) {
      this.jdField_a_of_type_JavaUtilList.add(paramOverScrollViewListener);
    }
  }
  
  public void setPTSFooterView(Container paramContainer)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = paramContainer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDailyXListView
 * JD-Core Version:    0.7.0.1
 */