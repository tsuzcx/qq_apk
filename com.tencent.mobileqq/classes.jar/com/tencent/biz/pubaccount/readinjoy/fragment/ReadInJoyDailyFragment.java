package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.DailyDynamicHeaderViewController;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyDailyViewController;
import com.tencent.biz.pubaccount.readinjoy.common.KandianDailyReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.common.TimeSliceHelper;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.daily.DailyTipsFoldUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJPushNotification;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJDtParamBuilder;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.BasePopupStep;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.RIJPopupAutomator;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJADSuperMaskPopupStep;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJDailyFloatingPopupStep;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJDailyPopupStep;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJLockScreenPopupStep;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJMsgBoxPopupStep;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJSkinOperationPopupStep;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJUGCAccountPopupStep;
import com.tencent.biz.pubaccount.readinjoy.qnreading.PreLoader;
import com.tencent.biz.pubaccount.readinjoy.report.UserActionCollector;
import com.tencent.biz.pubaccount.readinjoy.view.RecommendFeedsDiandianEntranceManager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdExposeFreshManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.AdReqFreshManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.AdMaterialResManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskUIMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.util.GifHelper;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import cooperation.readinjoy.ReadInjoyFloatingWindowHelper;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class ReadInJoyDailyFragment
  extends PublicBaseFragment
{
  private static TimeSliceHelper jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper = new TimeSliceHelper();
  public static List<String> a;
  private int jdField_a_of_type_Int = 5;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ReadInJoyDailyFragment.3(this);
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ReadInJoyDailyFragment.2(this);
  private View jdField_a_of_type_AndroidViewView;
  private DailyDynamicHeaderViewController jdField_a_of_type_ComTencentBizPubaccountReadinjoyDailyDynamicHeaderViewController;
  private ReadInJoyDailyViewController jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyDailyViewController;
  private RIJPopupAutomator jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupRIJPopupAutomator = new RIJPopupAutomator();
  private RIJDailyFloatingPopupStep jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupStepsRIJDailyFloatingPopupStep;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ReadInJoyDailyFragment.1(this);
  private boolean jdField_a_of_type_Boolean = false;
  private View b;
  
  static
  {
    jdField_a_of_type_JavaUtilList = new ArrayList(1);
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      do
      {
        return;
        KandianDailyReportUtils.a(paramIntent);
      } while (!b());
      paramIntent = RIJQQAppInterfaceUtil.a();
    } while (paramIntent == null);
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)paramIntent.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    localKandianMergeManager.d();
    localKandianMergeManager.r();
    RIJKanDianFolderStatus.a(paramIntent);
  }
  
  private void a(String paramString)
  {
    if (DailyModeConfigHandler.b(DailyModeConfigHandler.b())) {}
    for (String str = "0X80089D1";; str = "0X80098B0")
    {
      ThreadManager.executeOnSubThread(new ReadInJoyDailyFragment.4(this, paramString, str));
      return;
    }
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_JavaUtilList.size() > 0;
  }
  
  public static void b()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper != null)
    {
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper.b();
      QLog.d("ReadInJoyDailyFragment", 2, "stopTimeCalculateWhenInBackground");
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_Int == 6) || (this.jdField_a_of_type_Int == 9);
  }
  
  public static void c()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper != null)
    {
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper.a();
      QLog.d("ReadInJoyDailyFragment", 2, "wakeUpTimeCalculateWhenInForeground");
    }
  }
  
  private void d()
  {
    if (RIJQQAppInterfaceUtil.a() == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupStepsRIJDailyFloatingPopupStep == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupStepsRIJDailyFloatingPopupStep = new RIJDailyFloatingPopupStep(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupRIJPopupAutomator, getActivity());
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupRIJPopupAutomator.a(new BasePopupStep[] { new RIJLockScreenPopupStep(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupRIJPopupAutomator, getActivity()), new RIJDailyPopupStep(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupRIJPopupAutomator, getActivity()), new RIJMsgBoxPopupStep(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupRIJPopupAutomator, getActivity()), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupStepsRIJDailyFloatingPopupStep, new RIJADSuperMaskPopupStep(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupRIJPopupAutomator, getActivity()), new RIJUGCAccountPopupStep(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupRIJPopupAutomator, getActivity()), new RIJSkinOperationPopupStep(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupRIJPopupAutomator, getActivity()) });
  }
  
  private void e()
  {
    if (getActivity() != null)
    {
      IntentFilter localIntentFilter = new IntentFilter("float_layer_finsh_action");
      getActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  private void f()
  {
    if (getActivity() != null) {
      getActivity().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
  }
  
  private void g()
  {
    ThreadManager.executeOnSubThread(new ReadInJoyDailyFragment.5(this));
  }
  
  private void h()
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper.c();
    QLog.d("ReadInJoyDailyFragment", 2, "resetTime when create");
  }
  
  public void a()
  {
    if (ThemeUtil.isNowThemeIsNight(ReadInJoyUtils.a(), false, null))
    {
      if (this.b == null) {
        this.b = ((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131365525)).inflate();
      }
      if (this.b != null) {
        this.b.setVisibility(0);
      }
    }
    while (this.b == null) {
      return;
    }
    this.b.setVisibility(8);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.getWindow().setBackgroundDrawable(new ColorDrawable(0));
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyDailyViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyDailyViewController.a(paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    if ((getActivity() != null) && (getActivity().getIntent() != null) && (getActivity().getIntent().hasExtra("launch_from")))
    {
      int i = getActivity().getIntent().getIntExtra("launch_from", 0);
      if ((i == 9) || (i == 6))
      {
        Intent localIntent = new Intent(getActivity(), SplashActivity.class);
        localIntent.putExtra("fragment_id", 1);
        localIntent.putExtra("tab_index", FrameControllerUtil.jdField_a_of_type_Int);
        localIntent.putExtra("open_kandian_tab_fragment", true);
        localIntent.putExtra("arg_channel_cover_id", 0);
        localIntent.setFlags(335544320);
        getActivity().startActivity(localIntent);
      }
    }
    return super.onBackEvent();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = getResources().getDisplayMetrics();
    float f2 = FontSettingManager.getFontLevel() / 16.0F;
    float f1 = f2;
    if (f2 == 0.0F) {
      f1 = 1.0F;
    }
    f1 = paramConfiguration.density / f1;
    QLog.d("ReadInJoyDailyFragment", 1, "onConfigurationChanged densityNoScale : " + f1 + ", screenWidth : " + paramConfiguration.widthPixels);
    Utils.init(f1, paramConfiguration.widthPixels);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    DailyModeConfigHandler.b();
    KandianDailyReportUtils.a(getActivity().app);
    KandianDailyReportUtils.c();
    jdField_a_of_type_JavaUtilList.add(String.valueOf(hashCode()));
    UserActionCollector.a().a(UserActionCollector.d, 1);
    GifHelper.a();
    paramBundle = getActivity();
    if (paramBundle != null)
    {
      localObject = paramBundle.getIntent();
      if (localObject != null) {
        this.jdField_a_of_type_Int = ((Intent)localObject).getIntExtra("launch_from", 5);
      }
      a((Intent)localObject);
    }
    ThreadManager.getFileThreadHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 20000L);
    PreLoader.a().a();
    g();
    Object localObject = getArguments();
    if (this.jdField_a_of_type_Int == 15)
    {
      com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.jdField_a_of_type_Boolean = true;
      QLog.d("ReadInJoyDailyFragment", 1, "from aio share");
    }
    for (int i = 1;; i = 0)
    {
      if ((localObject != null) && (paramBundle != null))
      {
        if (((Bundle)localObject).getBoolean("open_floating_window", false)) {
          i = 1;
        }
        if (i != 0)
        {
          QLog.d("ReadInJoyDailyFragment", 1, "openFloatingWindow is true");
          i = ((Bundle)localObject).getInt("floating_window_business");
          int j = ((Bundle)localObject).getInt("floating_window_scene");
          ReadInjoyFloatingWindowHelper.a(paramBundle, j, i, (Bundle)localObject, DailyModeConfigHandler.b());
          if ((j == 1) && ((i != 1) || (ReadInjoyFloatingWindowHelper.a((Bundle)localObject)))) {
            KandianDailyReportUtils.a(32);
          }
        }
      }
      e();
      RIJPushNotification.a();
      h();
      d();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupRIJPopupAutomator.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupStepsRIJDailyFloatingPopupStep.i();
      paramBundle = RIJQQAppInterfaceUtil.a();
      if (paramBundle != null)
      {
        AdMaterialResManager.a(paramBundle).b();
        AdMaterialResManager.a(paramBundle);
      }
      SuperMaskUIMgr.a.b(41697);
      ReadInJoyAdLog.a("ReadInJoySuperMaskAd", "setSuperMaskChannelId 41697 notifyShowSelf ");
      SuperMaskUIMgr.a.a(0);
      return;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    DailyTipsFoldUtils.a();
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560276, paramViewGroup, false);
    ReadinjoySPEventReport.b(0, KandianDailyReportUtils.a(), 0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyDailyViewController = new ReadInJoyDailyViewController(getActivity());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyDailyViewController.a(DailyModeConfigHandler.b());
    paramLayoutInflater = (ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131376619);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyDailyViewController.a(paramLayoutInflater);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyDailyViewController.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDailyDynamicHeaderViewController = new DailyDynamicHeaderViewController(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyDailyViewController.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDailyDynamicHeaderViewController.a(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDailyDynamicHeaderViewController.a(this.jdField_a_of_type_AndroidViewView);
    a();
    VideoReport.addToDetectionWhitelist(getActivity());
    VideoReport.setPageId(this.jdField_a_of_type_AndroidViewView, "14");
    VideoReport.setPageParams(this.jdField_a_of_type_AndroidViewView, new RIJDtParamBuilder().a(Integer.valueOf(DailyModeConfigHandler.b())).a());
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    jdField_a_of_type_JavaUtilList.remove(String.valueOf(hashCode()));
    GifHelper.b();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyDailyViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyDailyViewController.d();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupRIJPopupAutomator != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupRIJPopupAutomator.b();
    }
    ThreadManager.getFileThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    PreLoader.a().b();
    f();
  }
  
  public void onDestroyView()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDailyDynamicHeaderViewController.a();
    AdReqFreshManager.a().a("RIJAdRefreshSceneDaily");
    AdExposeFreshManager.a().a("RIJAdRefreshSceneDaily");
    super.onDestroyView();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    getActivity().setIntent(paramIntent);
    if (paramIntent != null) {
      this.jdField_a_of_type_Int = paramIntent.getIntExtra("launch_from", 5);
    }
    a(paramIntent);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyDailyViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyDailyViewController.j();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyDailyViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyDailyViewController.g();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupRIJPopupAutomator != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupRIJPopupAutomator.d();
    }
    ApngImage.pauseByTag(31);
    SuperMaskUIMgr.a.b(-1);
    ReadInJoyAdLog.a("ReadInJoySuperMaskAd", "onPause: setSuperMaskChannelId = -1");
    SuperMaskUIMgr.a.c();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyDailyViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyDailyViewController.h();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupRIJPopupAutomator != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupRIJPopupAutomator.c();
    }
    RecommendFeedsDiandianEntranceManager.a().b();
    ApngImage.playByTag(31);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009940", "0X8009940", 0, 0, "", "", "", "", false);
    SuperMaskUIMgr.a.b(DailyModeConfigHandler.b());
    ReadInJoyAdLog.a("ReadInJoySuperMaskAd", "onResume: setSuperMaskChannelId = " + DailyModeConfigHandler.b());
    SuperMaskUIMgr.a.b();
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyDailyViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyDailyViewController.e();
    }
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper != null) {
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper.a();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyDailyViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyDailyViewController.f();
    }
    if ((!BaseActivity.mAppForground) && (jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper != null)) {
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonTimeSliceHelper.b();
    }
    if (getActivity().isFinishing())
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyDailyViewController != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyDailyViewController.c();
      }
      UserActionCollector.a().c();
      ReadinjoySPEventReport.b(1, KandianDailyReportUtils.a(), KandianDailyReportUtils.b());
      if (!this.jdField_a_of_type_Boolean) {
        a(KandianDailyReportUtils.a());
      }
      KandianDailyReportUtils.b();
      com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.jdField_a_of_type_Boolean = false;
      DailyModeConfigHandler.c();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupRIJPopupAutomator != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupRIJPopupAutomator.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyFragment
 * JD-Core Version:    0.7.0.1
 */