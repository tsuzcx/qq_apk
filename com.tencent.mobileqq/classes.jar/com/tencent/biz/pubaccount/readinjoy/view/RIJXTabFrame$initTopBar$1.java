package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.RIJXTabViewPagerController;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.fragment.RIJChannelReporter;
import com.tencent.biz.pubaccount.readinjoy.fragment.RIJXTabChannelPanelFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.widget.RIJXTabBar;
import com.tencent.biz.pubaccount.readinjoy.view.widget.RIJXTabBar.OnBtnClickListener;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMShortVideoUtils;
import java.net.URLDecoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/view/RIJXTabFrame$initTopBar$1", "Lcom/tencent/biz/pubaccount/readinjoy/view/widget/RIJXTabBar$OnBtnClickListener;", "onDeliverBtnClick", "", "view", "Landroid/view/View;", "onMoreChannelBtnClick", "onSearchBtnClick", "onSelfBtnClick", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "onTopicBtnClick", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabFrame$initTopBar$1
  implements RIJXTabBar.OnBtnClickListener
{
  public void a(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    UniteSearchActivity.a((Activity)this.a.a(), null, 25);
    RIJChannelReporter.a("0X80067D3", new RIJTransMergeKanDianReport.ReportR5Builder().f().a());
  }
  
  public void a(@NotNull RedTouch paramRedTouch)
  {
    Intrinsics.checkParameterIsNotNull(paramRedTouch, "view");
    boolean bool = RIJXTabFrame.a(this.a).a().c();
    RIJXTabFrame.a(this.a).a().d();
    ReadInJoyActivityHelper.b((Context)this.a.a(), bool);
    PublicTracker.a(null, "self_tab_cost");
    paramRedTouch = this.a.a().a();
    if (paramRedTouch != null)
    {
      int i = paramRedTouch.mChannelCoverId;
      RIJChannelReporter.a("0X8007DB4", new RIJTransMergeKanDianReport.ReportR5Builder().f().a(i).a());
    }
  }
  
  public void b(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    paramView = new Intent();
    PublicTransFragmentActivity.b((Context)this.a.a(), paramView, RIJXTabChannelPanelFragment.class);
    RIJXTabFrame.a(this.a).a(false);
    RIJChannelReporter.a("0X8009497", new RIJTransMergeKanDianReport.ReportR5Builder().f().a());
  }
  
  public void c(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    RIJTabFrameDeliverPopupUtil.a((Frame)this.a, paramView, true);
    if (BaseApplicationImpl.sProcessId != 9) {
      QIMShortVideoUtils.a((Context)BaseApplicationImpl.getContext());
    }
    RIJFrameworkReportManager.a("1");
  }
  
  public void d(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    paramView = Aladdin.getConfig(440);
    if (paramView != null) {}
    for (paramView = paramView.getString("hashTag_jump_url", "");; paramView = null)
    {
      String str = URLDecoder.decode(paramView, "UTF-8");
      QLog.i(this.a.a(), 1, "[onTopicBtnClick], jumpUrl = " + paramView + ", decodeJumpUrl = " + str);
      paramView = RIJTransMergeKanDianReport.a().c().f();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800BA08", "0X800BA08", 0, 0, "", "", "", paramView.a(), false);
      RIJJumpUtils.a((Context)this.a.a(), str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.RIJXTabFrame.initTopBar.1
 * JD-Core Version:    0.7.0.1
 */