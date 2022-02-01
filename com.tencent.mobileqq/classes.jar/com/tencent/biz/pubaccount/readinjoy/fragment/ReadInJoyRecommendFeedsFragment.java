package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.KanDianViewController;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJDtParamBuilder;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.BasePopupStep;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.RIJPopupAutomator;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJADSuperMaskPopupStep;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJDailyPopupStep;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJLockScreenPopupStep;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJMsgBoxPopupStep;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJSkinOperationPopupStep;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJUGCAccountPopupStep;
import com.tencent.biz.pubaccount.readinjoy.logic.DiandianTopConfigManager;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule;
import com.tencent.biz.pubaccount.readinjoy.readinfo.UserReadUnReadInfoManager;
import com.tencent.biz.pubaccount.readinjoy.report.UserActionCollector;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdExposeFreshManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdReqFreshManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskConfigMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskUIMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.Constants.LogoutReason;

public class ReadInJoyRecommendFeedsFragment
  extends ReadInJoyBaseFragment
{
  private long jdField_a_of_type_Long;
  private KanDianViewController jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController;
  private RIJPopupAutomator jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupRIJPopupAutomator = new RIJPopupAutomator();
  boolean jdField_a_of_type_Boolean = true;
  private long jdField_b_of_type_Long;
  boolean jdField_b_of_type_Boolean = false;
  private boolean g = true;
  
  public static ReadInJoyRecommendFeedsFragment a()
  {
    ReadInJoyRecommendFeedsFragment localReadInJoyRecommendFeedsFragment = new ReadInJoyRecommendFeedsFragment();
    localReadInJoyRecommendFeedsFragment.setArguments(new Bundle());
    return localReadInJoyRecommendFeedsFragment;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupRIJPopupAutomator.a(new BasePopupStep[] { new RIJLockScreenPopupStep(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupRIJPopupAutomator, getActivity()), new RIJDailyPopupStep(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupRIJPopupAutomator, getActivity()), new RIJMsgBoxPopupStep(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupRIJPopupAutomator, getActivity()), new RIJADSuperMaskPopupStep(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupRIJPopupAutomator, getActivity()), new RIJUGCAccountPopupStep(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupRIJPopupAutomator, getActivity()), new RIJSkinOperationPopupStep(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupRIJPopupAutomator, getActivity()) });
  }
  
  private void a(Activity paramActivity)
  {
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)ReadInJoyUtils.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    if ((ReadInJoyHelper.m()) && (!(paramActivity instanceof ReadInJoyNewFeedsActivity)))
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      boolean bool = localKandianMergeManager.b();
      Intent localIntent = paramActivity.getIntent();
      int i = localIntent.getIntExtra("launch_from", 5);
      bool = a(i, localIntent, bool);
      long l = this.jdField_a_of_type_Long - ReadInJoyHelper.a((QQAppInterface)ReadInJoyUtils.a());
      bool = a(l, bool);
      if (localKandianMergeManager.j()) {
        bool = true;
      }
      bool = a(bool, l);
      if ((bool) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController != null)) {
        ReadInJoyLogicEngineEventDispatcher.a().i();
      }
      a(bool, paramActivity, localKandianMergeManager, i);
      a(bool);
      return;
    }
    a(localKandianMergeManager);
  }
  
  private void a(Activity paramActivity, int paramInt)
  {
    if (((paramActivity instanceof SplashActivity)) && (ReadInJoyHelper.m()) && (paramInt != 13))
    {
      SuperMaskConfigMgr.a.a();
      QLog.d("ReadInJoySuperMaskAd", 1, "autoRefresh reset main feeds reqNum");
    }
  }
  
  private void a(KandianMergeManager paramKandianMergeManager)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController != null) && (paramKandianMergeManager.b())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.a(true);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      UserReadUnReadInfoManager.a().a();
    }
    for (;;)
    {
      SuperMaskUIMgr.a.b();
      return;
      if (UserReadUnReadInfoManager.a().a()) {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.a(false, 8);
        } else {
          UserReadUnReadInfoManager.a().a(true);
        }
      }
    }
  }
  
  private void a(boolean paramBoolean, Activity paramActivity, KandianMergeManager paramKandianMergeManager, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController != null) && (paramBoolean))
    {
      ReadinjoySPEventReport.a().a.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.a(paramBoolean, 3);
      ReadInJoyLogicEngineEventDispatcher.a().a(3, null);
      a(paramActivity, paramInt);
    }
    do
    {
      return;
      if ((paramKandianMergeManager.d() > 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController != null))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.a(false);
        return;
      }
    } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.a()));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.a(false);
  }
  
  private boolean a(int paramInt, Intent paramIntent, boolean paramBoolean)
  {
    if (paramInt == 13)
    {
      boolean bool = paramIntent.getBooleanExtra("force_refresh", false);
      paramBoolean = bool;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController != null)
      {
        paramIntent.removeExtra("force_refresh");
        paramBoolean = bool;
      }
    }
    return paramBoolean;
  }
  
  private boolean a(long paramLong, boolean paramBoolean)
  {
    if ((paramLong >= ReadInJoyHelper.d(ReadInJoyUtils.a())) && (!this.g))
    {
      if (paramLong < 900000L) {
        ReadinjoyReportUtils.c();
      }
      QLog.d("Q.readinjoy.4tab", 2, "kandian tab auto refresh ! duration : " + paramLong);
      return true;
    }
    this.g = false;
    return paramBoolean;
  }
  
  private boolean a(boolean paramBoolean, long paramLong)
  {
    return paramBoolean;
  }
  
  private void b()
  {
    if ((!this.jdField_b_of_type_Boolean) && (getActivity() != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupRIJPopupAutomator.e();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupRIJPopupAutomator.h();
    }
  }
  
  public int a()
  {
    if (ChannelCoverInfoModule.a() != -1) {
      return ChannelCoverInfoModule.a();
    }
    return 0;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.a(true, paramInt);
      return;
    }
    ReadInJoyChannelViewPagerController.d(a());
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    if ((ReadInJoyHelper.m()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.a(paramLogoutReason);
    }
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    this.jdField_d_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.h();
    }
    if (this.g) {
      UserReadUnReadInfoManager.a().a();
    }
    b();
    this.jdField_b_of_type_Boolean = true;
    a(paramActivity);
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.a(true);
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.a(true, 4);
    }
  }
  
  public boolean f()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.b();
    }
    return false;
  }
  
  public void g()
  {
    super.g();
    this.jdField_d_of_type_Boolean = false;
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupRIJPopupAutomator.f();
    }
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.j();
    }
    if (ReadInJoyHelper.o())
    {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      ReadInJoyHelper.a(this.jdField_b_of_type_Long, (QQAppInterface)ReadInJoyUtils.a());
    }
    SuperMaskUIMgr.a.c();
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.k();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ReadInJoyLogicEngine.a().e(false);
    a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupRIJPopupAutomator.a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController = ((KanDianViewController)ReadInJoyUtils.a.remove(Integer.valueOf(0)));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController = new KanDianViewController(getActivity().getActivity());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.a();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$CallHotwordChange, this.jdField_d_of_type_Int);
    if (DiandianTopConfigManager.a()) {
      DiandianTopConfigManager.a().a(false);
    }
    VideoReport.setPageId(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.a(), "14");
    VideoReport.setPageParams(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.a(), new RIJDtParamBuilder().a(Integer.valueOf(0)).a());
    paramLayoutInflater = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.a();
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.d();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupRIJPopupAutomator.b();
  }
  
  public void onDestroyView()
  {
    AdReqFreshManager.a().a("RIJAdRefreshSceneMainFeeds");
    AdExposeFreshManager.a().a("RIJAdRefreshSceneMainFeeds");
    super.onDestroyView();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.g();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupRIJPopupAutomator.d();
    UserActionCollector.a().b();
    SuperMaskUIMgr.a.b(-1);
    SuperMaskUIMgr.a.c();
    ReadInJoyAdLog.a("ReadInJoySuperMaskAd", "onPause: setSuperMaskChannelId = -1");
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController != null) && (this.jdField_d_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.h();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupRIJPopupAutomator.c();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupRIJPopupAutomator.g();
    UserActionCollector.a().a();
    SuperMaskUIMgr.a.b();
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.e();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyKanDianViewController.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyRecommendFeedsFragment
 * JD-Core Version:    0.7.0.1
 */