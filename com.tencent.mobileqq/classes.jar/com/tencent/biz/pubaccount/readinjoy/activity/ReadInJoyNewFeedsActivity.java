package com.tencent.biz.pubaccount.readinjoy.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailTopGestureLayout;
import com.tencent.biz.pubaccount.AccountDetail.view.ReadInJoyNewFeedsTopGestureLayout;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyNaviController;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJThreadHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ugc.RIJUGCDianDian;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAladdinUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJWebSearchUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.msgbox.RIJMsgBoxUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJLockScreenPushReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJPushNotification;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.MessageObserver;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.OnTabRedNumsChangeListenner;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyWebRenderEngine;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyFragmentFactory;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyRecommendFeedsFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySubChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.model.FreeNetFlowInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.report.UserActionCollector;
import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.biz.pubaccount.readinjoy.skin.BaseSkinRes;
import com.tencent.biz.pubaccount.readinjoy.skin.CommonSkinRes;
import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyBaseResManager;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyRefreshManager;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager.OnSkinChangedListener;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInjoySkinAndRefreshFacade;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo;
import com.tencent.biz.pubaccount.readinjoy.video.CodecReuseHelper;
import com.tencent.biz.pubaccount.readinjoy.video.CodecReuseHelper.Companion;
import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.biz.pubaccount.readinjoy.view.BaseTabbar.OnTabChangeListener;
import com.tencent.biz.pubaccount.readinjoy.view.BaseTabbar.TabHolder;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDialogUtil;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyScreenShotReporter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinGuideView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabbar;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabbar.Tab;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ReadInJoyGlobalReporter;
import com.tencent.biz.pubaccount.readinjoy.viola.so.ViolaSoLoaderManager;
import com.tencent.biz.pubaccount.readinjoy.viola.so.ViolaSoLoaderManager.Companion;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.ReadInjoyADExposureManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountConfigUtilImpl;
import com.tencent.biz.pubaccount.util.monitor.FPSMonitor;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyNewFeedsActivity
  extends ReadInJoyNewBaseActivity
  implements View.OnClickListener, KandianMergeManager.MessageObserver, KandianMergeManager.OnTabRedNumsChangeListenner, ReadInJoySkinManager.OnSkinChangedListener, TopGestureLayout.OnGestureListener, Observer
{
  public static List<String> a;
  public static ConcurrentHashMap<Integer, ReadInJoyNewFeedsActivity.TabInfo> a;
  public static int c;
  private static final int jdField_d_of_type_Int = Color.parseColor("#dedfe0");
  private long jdField_a_of_type_Long = 0L;
  private FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  protected FrameLayout a;
  protected AccountDetailTopGestureLayout a;
  public ReadInJoyNaviController a;
  private KandianMergeManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = null;
  protected ReadInJoyObserver a;
  private ReadInJoyBaseFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment;
  private GuideData jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData;
  protected ReadInjoySkinAndRefreshFacade a;
  private ChannelCoverInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo;
  BaseTabbar.OnTabChangeListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBaseTabbar$OnTabChangeListener = new ReadInJoyNewFeedsActivity.9(this);
  protected ReadInJoySkinGuideView a;
  private ReadinjoyTabbar jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ReadInJoyNewFeedsActivity.1(this);
  protected String a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler();
  int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = 0L;
  private ConcurrentHashMap<Integer, ReadInJoySubChannelFragment> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public boolean b;
  private long jdField_c_of_type_Long = 0L;
  private View jdField_c_of_type_AndroidViewView;
  boolean jdField_c_of_type_Boolean = true;
  private long jdField_d_of_type_Long = 0L;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 0;
  private long jdField_e_of_type_Long = 0L;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean = false;
  private int jdField_g_of_type_Int = 0;
  private boolean jdField_g_of_type_Boolean = false;
  private int jdField_h_of_type_Int = 0;
  private boolean jdField_h_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_JavaUtilList = new ArrayList(1);
    jdField_c_of_type_Int = 0;
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(0), new ReadInJoyNewFeedsActivity.TabInfo(HardCodeUtil.a(2131693569), 1, 0, -1, -857808928));
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(1), new ReadInJoyNewFeedsActivity.TabInfo(HardCodeUtil.a(2131712857), 2, 0, -1, -857808928));
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(2), new ReadInJoyNewFeedsActivity.TabInfo(HardCodeUtil.a(2131713006), 2, 0, -1, -857808928));
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(3), new ReadInJoyNewFeedsActivity.TabInfo(HardCodeUtil.a(2131712763), 2, 0, -1, -857808928));
  }
  
  public ReadInJoyNewFeedsActivity()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new ReadInJoyNewFeedsActivity.17(this);
  }
  
  private void a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.setSelection(paramInt1, this.jdField_e_of_type_Int, this.jdField_a_of_type_AndroidSupportV4AppFragmentManager, getIntent(), paramInt2, paramBundle);
    paramBundle = (ReadInJoySkinManager)this.app.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
    if (paramBundle.a() != 0)
    {
      paramBundle = paramBundle.a(paramInt1 + 4);
      if (paramBundle != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(paramInt1).a.c.setImageDrawable(paramBundle.a());
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(this.jdField_e_of_type_Int).a.c.setSelected(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(paramInt1).a.c.setSelected(true);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(this.jdField_e_of_type_Int, paramInt1)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(paramInt1);
    }
    paramInt1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.b();
    if (paramInt1 == 3) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.b(paramInt1);
    }
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
    localReportR5Builder.b().e().f();
    int i;
    Object localObject;
    if (paramBoolean2)
    {
      i = 1;
      localReportR5Builder.b("button_state", i);
      if (paramInt2 <= 0) {
        break label252;
      }
      localObject = "2";
      label48:
      localReportR5Builder.b("reddot", (String)localObject);
      localObject = (ReadInJoySkinManager)this.app.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
      if ((((ReadInJoySkinManager)localObject).a() != 1) || (TextUtils.isEmpty(((ReadInJoySkinManager)localObject).a()))) {
        break label260;
      }
      localObject = ((ReadInJoySkinManager)localObject).a();
      label101:
      localReportR5Builder.b("skin_id", (String)localObject);
      if (a().a() == 0)
      {
        localObject = ReadInJoyRefreshManager.b(getActivity(), 0);
        if ((localObject == null) || (!((RefreshData)localObject).isAD)) {
          break label268;
        }
        paramInt2 = 1;
        label147:
        localReportR5Builder.b("ad_page", paramInt2);
      }
      if (paramBoolean1) {
        break label273;
      }
      localObject = "";
      str = "";
      if (paramInt1 == 2)
      {
        localObject = String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a());
        str = String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b());
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(this.app, (String)localObject, "0X8007DB0", "0X8007DB0", 0, 0, String.valueOf(paramInt1 + 1), "", str, localReportR5Builder.a(), false);
    }
    label252:
    while (this.jdField_c_of_type_Boolean)
    {
      String str;
      return;
      i = 0;
      break;
      localObject = "1";
      break label48;
      localObject = "0";
      break label101;
      paramInt2 = 0;
      break label147;
    }
    label260:
    label268:
    label273:
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(this.app, "", "0X80081C5", "0X80081C5", 0, 0, String.valueOf(paramInt1 + 1), "", "", localReportR5Builder.a(), false);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
    localReportR5Builder.b("has_redpoint", paramInt);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007C40", "0X8007C40", 0, 0, "", "", "", VideoReporter.a(localReportR5Builder.a()), false);
    ReadInJoyScreenShotReporter.a(this).a(3, 56);
    if (paramBoolean) {
      PublicTracker.a(null, "video_tab_cost");
    }
  }
  
  private void a(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
    }
    long l;
    if ((paramBundle != null) && (paramBundle.getInt("BID_TYPE", 0) == 2))
    {
      QLog.d("ReadInJoyNewFeedsActivity", 2, "reportSubscribeTabRedInfo.");
      l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a();
      if (l == 0L) {}
    }
    try
    {
      paramBundle = RIJTransMergeKanDianReport.a();
      paramBundle.put("kandian_mode", RIJAppSetting.a());
      paramBundle.put("tab_source", 3);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", String.valueOf(l), "0X80081C6", "0X80081C6", 0, 1, null, null, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b()), paramBundle.toString(), false);
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  private void a(String paramString)
  {
    getWindow().getDecorView().post(new ReadInJoyNewFeedsActivity.11(this, paramString));
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_JavaUtilList.size() > 0;
  }
  
  private int b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a().get(3);
  }
  
  private void e(boolean paramBoolean)
  {
    a(0);
    q();
    ReadInJoyScreenShotReporter.a(this).a(0, 0);
    if (paramBoolean) {
      PublicTracker.a(null, "recommend_tab_cost");
    }
  }
  
  private void f(boolean paramBoolean)
  {
    i(jdField_d_of_type_Int);
    if (RIJUGCDianDian.a()) {
      d(2130843060);
    }
    ReadInJoyScreenShotReporter.a(this).a();
    if (paramBoolean) {
      PublicTracker.a(null, "subscribe_tab_cost");
    }
  }
  
  public static void h(int paramInt)
  {
    if (paramInt == 7)
    {
      RIJAppSetting.a(2);
      return;
    }
    if (paramInt == 5)
    {
      RIJAppSetting.a(1);
      return;
    }
    if (paramInt == 1)
    {
      RIJAppSetting.a(4);
      return;
    }
    if ((paramInt == 6) || (paramInt == 9))
    {
      RIJAppSetting.a(7);
      return;
    }
    RIJAppSetting.a(5);
  }
  
  private void i(int paramInt)
  {
    if (this.jdField_d_of_type_AndroidViewView != null) {
      this.jdField_d_of_type_AndroidViewView.setBackgroundColor(paramInt);
    }
  }
  
  private void j(int paramInt)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool6 = true;
    boolean bool7 = true;
    boolean bool8 = true;
    boolean bool1 = true;
    switch (paramInt)
    {
    case 8: 
    default: 
      return;
    case 0: 
      localObject = getAppRuntime();
      if (!ReadInJoyHelper.d(getAppRuntime())) {}
      for (;;)
      {
        ReadInJoyHelper.b((AppRuntime)localObject, bool1);
        ReadInJoyLogicEngineEventDispatcher.a().c();
        return;
        bool1 = false;
      }
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 7: 
      k(paramInt);
      return;
    case 5: 
      localObject = getAppRuntime();
      if (!ReadInJoyHelper.f(getAppRuntime())) {}
      for (bool1 = bool2;; bool1 = false)
      {
        ReadInJoyHelper.e((AppRuntime)localObject, bool1);
        return;
      }
    case 6: 
      localObject = getAppRuntime();
      if (!ReadInJoyHelper.i(getAppRuntime())) {}
      for (bool1 = bool3;; bool1 = false)
      {
        ReadInJoyHelper.h((AppRuntime)localObject, bool1);
        return;
      }
    case 9: 
      localObject = getAppRuntime();
      if (!ReadInJoyHelper.j(getAppRuntime())) {}
      for (bool1 = bool4;; bool1 = false)
      {
        ReadInJoyHelper.i((AppRuntime)localObject, bool1);
        QQToast.a(getApplicationContext(), HardCodeUtil.a(2131713083), 0).a();
        return;
      }
    case 10: 
      ReadInJoyHelper.a(getAppRuntime(), "debug_kd_tab_type", "1");
      QQToast.a(getApplicationContext(), HardCodeUtil.a(2131712892), 0).a();
      return;
    case 11: 
      ReadInJoyHelper.a(getAppRuntime(), "debug_kd_tab_type", "2");
      QQToast.a(getApplicationContext(), HardCodeUtil.a(2131712969), 0).a();
      return;
    case 12: 
      ReadInJoyHelper.a(getAppRuntime(), "debug_kd_tab_type", "3");
      QQToast.a(getApplicationContext(), HardCodeUtil.a(2131713053), 0).a();
      return;
    case 13: 
      ReadInJoyHelper.a(getAppRuntime(), "debug_kd_tab_type", "0");
      QQToast.a(getApplicationContext(), HardCodeUtil.a(2131712806), 0).a();
      return;
    case 14: 
      localObject = FPSMonitor.a();
      if (!FPSMonitor.a().a()) {}
      for (bool1 = bool5;; bool1 = false)
      {
        ((FPSMonitor)localObject).a(bool1);
        if (!FPSMonitor.a().a()) {
          break;
        }
        FPSMonitor.a().a(this);
        return;
      }
      FPSMonitor.a().a(this);
      return;
    case 15: 
      localObject = getAppRuntime();
      if (!ReadInJoyHelper.g(getAppRuntime())) {}
      for (bool1 = bool6;; bool1 = false)
      {
        ReadInJoyHelper.f((AppRuntime)localObject, bool1);
        return;
      }
    case 16: 
      localObject = getAppRuntime();
      if (!ReadInJoyHelper.x(getAppRuntime())) {}
      for (bool1 = bool7;; bool1 = false)
      {
        ReadInJoyHelper.n((AppRuntime)localObject, bool1);
        return;
      }
    }
    Object localObject = getAppRuntime();
    if (!ReadInJoyHelper.h(getAppRuntime())) {}
    for (bool1 = bool8;; bool1 = false)
    {
      ReadInJoyHelper.g((AppRuntime)localObject, bool1);
      return;
    }
  }
  
  private void k(int paramInt)
  {
    if (paramInt == 1) {
      ReadInJoyUtils.jdField_a_of_type_Int = -2;
    }
    do
    {
      for (;;)
      {
        QLog.d("ReadInJoyNewFeedsActivity", 1, "readinjoy setting feeds type:" + ReadInJoyUtils.jdField_a_of_type_Int);
        return;
        if (paramInt == 2)
        {
          ReadInJoyUtils.jdField_a_of_type_Int = -1;
        }
        else if (paramInt == 3)
        {
          ReadInJoyUtils.jdField_a_of_type_Int = 1;
        }
        else
        {
          if (paramInt != 4) {
            break;
          }
          ReadInJoyUtils.jdField_a_of_type_Int = 0;
        }
      }
    } while (paramInt != 7);
    boolean bool = ReadInJoyHelper.C(getAppRuntime());
    AppRuntime localAppRuntime = getAppRuntime();
    if (!bool) {}
    for (bool = true;; bool = false)
    {
      ReadInJoyHelper.r(localAppRuntime, bool);
      QQToast.a(getApplicationContext(), HardCodeUtil.a(2131712693), 0).a();
      break;
    }
  }
  
  private void m()
  {
    Object localObject = this.app;
    if (localObject != null)
    {
      localObject = (ReadInJoySkinManager)((AppInterface)localObject).getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
      if (localObject != null) {
        ((ReadInJoySkinManager)localObject).a(this);
      }
    }
  }
  
  private void n()
  {
    Object localObject = this.app;
    if (localObject != null)
    {
      localObject = (ReadInJoySkinManager)((AppInterface)localObject).getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
      ((ReadInJoySkinManager)localObject).b(this);
      ((ReadInJoySkinManager)localObject).b();
    }
  }
  
  private void o()
  {
    QLog.d("ReadInJoyNewFeedsActivity", 2, "reportKandianTabRedInfo.");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
    }
    SparseIntArray localSparseIntArray = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a();
    if (localSparseIntArray.get(0) <= 0) {
      localSparseIntArray.put(0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.e());
    }
    localSparseIntArray.put(3, 0);
    int i = 0;
    if (i < 4)
    {
      if (localSparseIntArray.get(i) <= 0) {}
      for (;;)
      {
        i += 1;
        break;
        try
        {
          JSONObject localJSONObject = RIJTransMergeKanDianReport.a();
          localJSONObject.put("kandian_mode", RIJAppSetting.a());
          localJSONObject.put("tab_source", i + 1);
          String str3 = "";
          String str4 = "";
          String str2 = str3;
          String str1 = str4;
          if (i == 2)
          {
            long l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a();
            str2 = str3;
            str1 = str4;
            if (l != 0L)
            {
              str2 = String.valueOf(l);
              str1 = String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b());
            }
          }
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", str2, "0X80081C6", "0X80081C6", 0, 1, null, null, str1, localJSONObject.toString(), false);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  private void p()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo = new ChannelCoverInfo();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mChannelCoverId = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mChannelCoverName = HardCodeUtil.a(2131712939);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mChannelType = 0;
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData != null)
    {
      GuideData localGuideData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData = null;
      ThreadManager.post(new ReadInJoyNewFeedsActivity.8(this, localGuideData), 8, null, true);
    }
  }
  
  private void r()
  {
    if (this.jdField_e_of_type_Int == 3) {}
    for (;;)
    {
      return;
      boolean bool;
      if (this.jdField_e_of_type_Int == 0) {
        bool = ReadInJoyUtils.jdField_a_of_type_Boolean;
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ReadInJoyNewFeedsActivity", 2, "onTabRedNumsChange on" + this.jdField_e_of_type_Int + "and rednums is" + b());
        return;
        if (this.jdField_e_of_type_Int == 1) {
          bool = ReadInJoyUtils.jdField_a_of_type_Boolean;
        }
      }
    }
  }
  
  public int a()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_e_of_type_Long;
  }
  
  public ReadInJoyBaseFragment a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment;
  }
  
  public ReadinjoyTabbar a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar;
  }
  
  public void a(int paramInt1, int paramInt2, Bundle paramBundle, boolean paramBoolean)
  {
    int i;
    boolean bool1;
    if ((paramInt1 < 0) || (paramInt1 >= 4))
    {
      i = 0;
      this.jdField_g_of_type_Int = this.jdField_e_of_type_Int;
      boolean bool2 = a(paramInt1);
      paramInt1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(i);
      a(i, paramInt2, paramBundle);
      setTitle(((ReadInJoyNewFeedsActivity.TabInfo)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i))).jdField_a_of_type_JavaLangString);
      a(8);
      e(i);
      i(-1);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNewFeedsActivity", 2, "setSelection from tab " + this.jdField_e_of_type_Int + " to tab " + i + ", jumpType:" + paramInt2);
      }
      if (this.jdField_e_of_type_Int != i) {
        break label238;
      }
      bool1 = true;
      label152:
      this.jdField_e_of_type_Int = i;
      jdField_c_of_type_Int = this.jdField_e_of_type_Int;
      k();
      if (paramBoolean) {
        a(i, paramInt1, bool1, bool2);
      }
      switch (i)
      {
      }
    }
    for (;;)
    {
      ReadInJoyGlobalReporter.c(a().a());
      this.jdField_c_of_type_Boolean = false;
      return;
      i = paramInt1;
      break;
      label238:
      bool1 = false;
      break label152;
      e(paramBoolean);
      continue;
      a(paramInt1, paramBoolean);
      continue;
      f(paramBoolean);
      continue;
      PublicTracker.a(null, "self_tab_cost");
      ReadInJoyScreenShotReporter.a(this).a();
    }
  }
  
  protected void a(int paramInt, String paramString, BaseResData paramBaseResData)
  {
    ReadInJoyBaseResManager localReadInJoyBaseResManager = (ReadInJoyBaseResManager)this.app.getManager(paramInt);
    String str;
    if (localReadInJoyBaseResManager.b(paramString, paramBaseResData))
    {
      str = localReadInJoyBaseResManager.a(paramString, paramBaseResData.id);
      if (!localReadInJoyBaseResManager.c(paramString, paramBaseResData)) {
        break label158;
      }
      if ((QQManagerFactory.READ_INJOY_SKIN_MANAGER != paramInt) || (SharedPreUtils.g(this, paramBaseResData.id) == paramBaseResData.seq)) {
        break label82;
      }
      FileUtils.a(str);
      localReadInJoyBaseResManager.a(paramString, paramBaseResData);
    }
    label82:
    do
    {
      return;
      localReadInJoyBaseResManager.b(paramString, paramBaseResData);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNewFeedsActivity", 2, "showSkinGuide：real: " + paramBaseResData.id);
      }
    } while (!(paramBaseResData instanceof GuideData));
    paramString = (GuideData)paramBaseResData;
    this.jdField_a_of_type_MqqOsMqqHandler.post(new ReadInJoyNewFeedsActivity.5(this, paramString, str, paramInt));
    return;
    label158:
    localReadInJoyBaseResManager.a(paramString, paramBaseResData);
  }
  
  public void a(ReadInJoyBaseFragment paramReadInJoyBaseFragment)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment = paramReadInJoyBaseFragment;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNewFeedsActivity", 2, "onKandianMsgNotification.");
    }
    i();
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle)
  {
    if (paramInt == KandianOx210MsgInfo.k) {
      if (this.mIsResume)
      {
        r();
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.i())) {
          ReadInJoyWebDataManager.a().a(this.app.getCurrentAccountUin(), 1);
        }
      }
    }
    while (paramInt != KandianOx210MsgInfo.l) {
      for (;;)
      {
        return;
        this.jdField_h_of_type_Boolean = true;
      }
    }
    a(paramBundle);
  }
  
  @TargetApi(23)
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      getWindow().getDecorView().setSystemUiVisibility(9216);
      return;
    }
    getWindow().getDecorView().setSystemUiVisibility(0);
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(paramInt).jdField_b_of_type_Boolean;
  }
  
  public void ai_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNewFeedsActivity", 2, "onTabRedNumsChange.");
    }
    h();
    i();
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void b(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout.a(paramView);
    }
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNewFeedsActivity", 2, "onSubscribeMsgNotification.");
    }
    i();
  }
  
  public boolean b()
  {
    return this.jdField_h_of_type_Int != 0;
  }
  
  public void c()
  {
    PublicTracker.a(null, "KANDIAN_NEW_FEEDS_INIT_UI");
    this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = getSupportFragmentManager();
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout = new ReadInJoyNewFeedsTopGestureLayout(this);
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout.setOnFlingGesture(this);
    }
    setContentView(2131560097);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar = ((ReadinjoyTabbar)findViewById(2131378856));
    this.jdField_c_of_type_AndroidViewView = findViewById(2131378832);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131379661);
    p();
    g();
    f();
    if (ThemeUtil.isInNightMode(this.app)) {
      a();
    }
    ReadInJoyFragmentFactory.a().a(this);
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_f_of_type_Int != 5)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131690778));
    }
    QQMessageFacade localQQMessageFacade = this.app.getMessageFacade();
    if (localQQMessageFacade != null) {
      f(localQQMessageFacade.b());
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131366895));
    PublicTracker.a("KANDIAN_NEW_FEEDS_INIT_UI", null);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController = new ReadInJoyNaviController(this.jdField_a_of_type_AndroidWidgetFrameLayout, new ReadInJoyNavigationGridview(this, new ReadInJoyNewFeedsActivity.NaviMaskTouchListenerImpl(this)), this.jdField_b_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController.jdField_a_of_type_Int = getTitleBarHeight();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("ReadInJoyNewFeedsActivity", 1, "init ReadInJoyNavigationGridView Exception or Error.");
      localThrowable.printStackTrace();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_e_of_type_Int == 0) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.setTabState(0, paramBoolean);
    }
  }
  
  public void d()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      ImmersiveUtils.clearCoverForStatus(getWindow(), this.isClearCoverLayer);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      this.mSystemBarComp.init();
      if (!ThemeUtil.isInNightMode(this.app)) {
        break label135;
      }
      if ((!SystemUtil.b()) && (!SystemUtil.d()))
      {
        this.mSystemBarComp.setStatusBarColor(-7829368);
        this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-7829368);
      }
    }
    else
    {
      return;
    }
    this.mSystemBarComp.setStatusBarColor(-7829368);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-7829368);
    this.mSystemBarComp.setStatusBarDarkMode(true);
    return;
    label135:
    if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
    {
      a(true);
      this.mSystemBarComp.setStatusBarColor(-1);
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-1);
      return;
    }
    if (!SystemUtil.d())
    {
      this.mSystemBarComp.setStatusBarColor(-2368549);
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-2368549);
      return;
    }
    this.mSystemBarComp.setStatusBarColor(-1);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-1);
    this.mSystemBarComp.setStatusBarDarkMode(true);
  }
  
  protected void d(int paramInt)
  {
    super.c(paramInt);
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
    }
    SparseIntArray localSparseIntArray = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a();
    int i;
    label71:
    ReadinjoyTabbar localReadinjoyTabbar;
    if (!paramBoolean)
    {
      if (localSparseIntArray.get(0) > 0) {
        localSparseIntArray.put(0, 10);
      }
      localSparseIntArray.put(0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.e());
      localSparseIntArray.put(3, 0);
      i = 0;
      if (i >= 4) {
        return;
      }
      localReadinjoyTabbar = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar;
      if (((ReadInJoyNewFeedsActivity.TabInfo)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i))).jdField_a_of_type_Int != 1) {
        break label132;
      }
    }
    label132:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localReadinjoyTabbar.a(i, paramBoolean, localSparseIntArray.get(i));
      i += 1;
      break label71;
      localSparseIntArray.put(0, 0);
      break;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    if (paramInt1 == 9992)
    {
      if ((paramIntent != null) && (paramIntent.getBooleanExtra("isNeedFinish", false))) {
        finish();
      }
    }
    else
    {
      if (paramInt1 != 103) {
        break label240;
      }
      switch (paramInt2)
      {
      }
    }
    Object localObject;
    label240:
    do
    {
      do
      {
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(this.jdField_e_of_type_Int).a() != null) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(this.jdField_e_of_type_Int).a().a(paramInt1, paramInt2, paramIntent);
          }
          super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
          return;
          if (!paramIntent.getBooleanExtra("bFailed", false)) {
            i = 1;
          }
          localObject = new QQToast(this);
          ((QQToast)localObject).d(2000);
          if (i != 0)
          {
            ((QQToast)localObject).a(QQToast.a(2));
            ((QQToast)localObject).c(2131692259);
            ((QQToast)localObject).b(getApplicationContext().getResources().getDimensionPixelSize(2131299166) - (int)DisplayUtils.a(getApplicationContext(), 5.0F));
          }
          else
          {
            ((QQToast)localObject).a(QQToast.a(1));
            ((QQToast)localObject).c(2131692260);
            ((QQToast)localObject).b(getApplicationContext().getResources().getDimensionPixelSize(2131299166) - (int)DisplayUtils.a(getApplicationContext(), 5.0F));
          }
        }
      } while (paramInt1 != 9991);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNewFeedsActivity", 2, "back from article detail");
      }
    } while (!RIJWebSearchUtils.a());
    if (!TextUtils.isEmpty(PublicAccountConfigUtilImpl.readInJoyReleaseWebServiceConfig)) {}
    for (;;)
    {
      try
      {
        for (;;)
        {
          i = new JSONObject(PublicAccountConfigUtilImpl.readInJoyReleaseWebServiceConfig).optInt("releaseServiceMinMem", 80);
          long l = DeviceInfoUtil.e();
          if (l >>> 20 > i) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyNewFeedsActivity", 2, "back from article detail, release web core service");
          }
          ((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).stopWebCoreService();
          try
          {
            localObject = new HashMap();
            ((HashMap)localObject).put("param_osVer", String.valueOf(Build.VERSION.SDK_INT));
            ((HashMap)localObject).put("param_totalMem", String.valueOf(DeviceInfoUtil.a()));
            ((HashMap)localObject).put("param_availableMem", String.valueOf(l));
            ((HashMap)localObject).put("param_cpuNum", String.valueOf(DeviceInfoUtil.b()));
            ((HashMap)localObject).put("param_cpuFreq", String.valueOf(DeviceInfoUtil.b()));
            ((HashMap)localObject).put("param_releaseType", String.valueOf(0));
            if (QLog.isColorLevel()) {
              QLog.d("ReadInJoyNewFeedsActivity", 2, "releaseWebCoreServiceReport:" + ((HashMap)localObject).toString());
            }
            StatisticCollector.getInstance(this).collectPerformance(this.app.getCurrentAccountUin(), "actReadInJoyReleaseWebService", true, 0L, 0L, (HashMap)localObject, "");
          }
          catch (Exception localException1) {}
        }
      }
      catch (Exception localException2)
      {
        i = 80;
        continue;
      }
      i = 80;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    PublicTracker.a("KANDIAN_NEW_FEEDS_ACTIVITY_MANAGER", null);
    PublicTracker.a(null, "KANDIAN_NEW_FEEDS_CREATE");
    VideoVolumeControl.a().a(this);
    VideoReport.addToDetectionWhitelist(this);
    super.doOnCreate(paramBundle);
    jdField_a_of_type_JavaUtilList.add(String.valueOf(hashCode()));
    ReadInJoyRefreshManager.jdField_b_of_type_Boolean = false;
    ReadinjoyReportUtils.a(this.app);
    ReadInJoyHelper.c(this.app);
    ReadInJoyHelper.d(this.app);
    ViolaSoLoaderManager.a.a().a();
    ReadInJoyWebRenderEngine.c();
    CodecReuseHelper.a.a();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    paramBundle = getIntent();
    Bundle localBundle = paramBundle.getExtras();
    if ((localBundle != null) && (localBundle.getBoolean("key_notification_click_action", false))) {
      ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).h();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(this);
    this.jdField_d_of_type_Boolean = paramBundle.getBooleanExtra("from_search", false);
    this.jdField_e_of_type_Boolean = paramBundle.getBooleanExtra("from_javascript", false);
    this.jdField_f_of_type_Int = paramBundle.getIntExtra("launch_from", 5);
    h(this.jdField_f_of_type_Int);
    if (6 == this.jdField_f_of_type_Int)
    {
      RIJKanDianFolderStatus.a(3);
      RIJLockScreenPushReport.a();
    }
    for (;;)
    {
      ReadInJoyLogicEngineEventDispatcher.a().a();
      if (Build.VERSION.SDK_INT >= 11) {
        getWindow().setFlags(16777216, 16777216);
      }
      int i = NetworkUtil.a(getApplication());
      if ((i == 4) || (i == 1)) {
        ThreadManager.post(new ReadInJoyNewFeedsActivity.2(this), 5, null, true);
      }
      ThreadManager.executeOnSubThread(new ReadInJoyNewFeedsActivity.MyRunnable(this, this));
      c();
      getWindow().setBackgroundDrawable(null);
      paramBundle = (ReadInJoyLogicManager)this.app.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
      ReadInJoyLogicEngine.a().h();
      ReadInJoyLogicEngine.a().d();
      if (this.app.getMessageFacade() != null) {
        this.app.getMessageFacade().addObserver(this);
      }
      if (ReadInJoyHelper.a(this.app)) {
        TroopBarAssistantManager.a().c(this.app);
      }
      ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
      ReadInJoyHelper.a(this.app);
      this.jdField_b_of_type_Int = RIJKanDianFolderStatus.jdField_a_of_type_Int;
      ReadinjoyReportUtils.a(ReadinjoyReportUtils.a(), true, 0L, this.jdField_b_of_type_Int, 0);
      RIJThreadHandler.a(this.app);
      r();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.i()) {
        ReadInJoyWebDataManager.a().a(this.app.getCurrentAccountUin(), 1);
      }
      PublicTracker.a("KANDIAN_NEW_FEEDS_CREATE", null);
      PublicTracker.a(null, "KANDIAN_NEW_FEEDS_CREATE_TO_RESUME");
      long l = NetConnInfoCenter.getServerTimeMillis();
      i = RIJAppSetting.a();
      int j = RIJKanDianFolderStatus.jdField_a_of_type_Int;
      ReadInJoyGlobalReporter.a().a(this.app, l, i, j);
      ThreadManager.executeOnSubThread(new ReadInJoyNewFeedsActivity.3(this, l, i, j));
      m();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInjoySkinAndRefreshFacade = new ReadInjoySkinAndRefreshFacade(this.app, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInjoySkinAndRefreshFacade.a(new ReadInJoyNewFeedsActivity.4(this));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInjoySkinAndRefreshFacade.a();
      d();
      ThreadManager.getFileThreadHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 20000L);
      ReadInJoyGlobalReporter.c(0);
      RIJPushNotification.a();
      return true;
      if (9 == this.jdField_f_of_type_Int) {
        RIJKanDianFolderStatus.a(3);
      } else if (1 == this.jdField_f_of_type_Int) {
        RIJKanDianFolderStatus.a(8);
      } else if (2 == this.jdField_f_of_type_Int) {
        RIJKanDianFolderStatus.a(8);
      } else if (11 == this.jdField_f_of_type_Int) {
        ReadInJoyLogicEngineEventDispatcher.a().c("onConversationJumpRestoreStack");
      }
    }
  }
  
  public void doOnDestroy()
  {
    long l = System.currentTimeMillis();
    try
    {
      int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a();
      ((ReadInJoyLogicManager)this.app.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).a().h(i);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNewFeedsActivity", 2, new Object[] { "saveLeaveKanDianTab time cost: ", Long.valueOf(System.currentTimeMillis() - l) });
      }
      ((ReadInjoyADExposureManager)this.app.getManager(QQManagerFactory.KANDIAN_AD_EXPOSURE_MANAGER)).a(getActivity());
      ReadInJoyScreenShotReporter.a(this).b();
      ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
      ReadInJoyFragmentFactory.a().a();
      ((AudioManager)getSystemService("audio")).abandonAudioFocus(null);
      n();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView.a();
      }
      jdField_a_of_type_JavaUtilList.remove(String.valueOf(hashCode()));
      super.doOnDestroy();
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      l = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long;
      if (l > 0L) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80066F7", "0X80066F7", 0, 0, Long.toString(l / 1000L), "", "", RIJTransMergeKanDianReport.b(), false);
      }
      if (this.app.getMessageFacade() != null) {
        this.app.getMessageFacade().deleteObserver(this);
      }
      Object localObject = (ReadInJoyLogicManager)this.app.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
      if ((localObject != null) && (((ReadInJoyLogicManager)localObject).a() != null))
      {
        localObject = ((ReadInJoyLogicManager)localObject).a().a();
        if (localObject != null) {
          ((ReadInJoyUserInfoModule)localObject).b();
        }
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.p();
      ReadInJoyLogicEngine.a().i();
      VideoVolumeControl.a().b(this);
      PreloadManager.a().b();
      PreloadManager.a().e();
      ReadinjoyReportUtils.a(ReadinjoyReportUtils.a(), false, this.jdField_a_of_type_Long, this.jdField_b_of_type_Int, this.jdField_h_of_type_Int);
      PublicTracker.a();
      ((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).stopWebCoreService();
      ((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).releaseLightWebProcess();
      ReadInJoyWebDataManager.a();
      ReadInJoyWebDataManager.a().b();
      j();
      ((ReadInJoySkinManager)this.app.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).b(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInjoySkinAndRefreshFacade.b();
      if (this.jdField_a_of_type_JavaLangString != null)
      {
        FileUtils.a(CommonSkinRes.a(this.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_JavaLangString = null;
      }
      ReadInJoyGlobalReporter.a().a();
      ThreadManager.executeOnSubThread(new ReadInJoyNewFeedsActivity.12(this));
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController.b();
      }
      localObject = ReadInJoyLogicEngine.a().a();
      if (localObject != null) {
        ((FreeNetFlowInfoModule)localObject).a(false);
      }
      ThreadManager.getFileThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      UserActionCollector.a().c();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("ReadInJoyNewFeedsActivity", 1, "saveLeaveKanDianTab throw Exception.");
        localException.printStackTrace();
      }
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.jdField_d_of_type_Boolean = paramIntent.getBooleanExtra("from_search", false);
    this.jdField_e_of_type_Boolean = paramIntent.getBooleanExtra("from_javascript", false);
    this.jdField_f_of_type_Int = paramIntent.getIntExtra("launch_from", 5);
    h(this.jdField_f_of_type_Int);
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_f_of_type_Int != 5)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131690778));
    }
    a(paramIntent.getIntExtra("target_fragment", 0), 258, paramIntent.getExtras(), false);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    AbstractGifImage.pauseAll();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.b(3);
    ReadInJoyScreenShotReporter.a(this).a();
    ReadInJoyLogicEngine.n();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView.b();
    }
  }
  
  public void doOnResume()
  {
    PublicTracker.a("KANDIAN_NEW_FEEDS_CREATE_TO_RESUME", null);
    PublicTracker.a(null, "KANDIAN_NEW_FEEDS_RESUME");
    ReadInJoyFragmentFactory.a().a(this);
    super.doOnResume();
    if (this.jdField_f_of_type_Boolean)
    {
      a(this.jdField_g_of_type_Int, 257, null, false);
      this.jdField_f_of_type_Boolean = false;
    }
    boolean bool;
    if (this.jdField_e_of_type_Int == 0)
    {
      a(0);
      if ((getIntent() != null) && (getIntent().getExtras() != null) && (getIntent().hasExtra("notification_message_id")))
      {
        String str = getIntent().getExtras().getString("notification_message_id", "");
        if ((!str.isEmpty()) && (RIJMsgBoxUtils.b() == 2) && (RIJAladdinUtils.c() == 2)) {
          ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(2, str);
        }
        getIntent().removeExtra("notification_message_id");
        if ((RIJAladdinUtils.c() == 1) || (RIJMsgBoxUtils.b() != 2)) {
          a(str);
        }
      }
      e();
      if (this.jdField_b_of_type_Boolean) {
        break label300;
      }
      bool = true;
      label190:
      d(bool);
      i();
      o();
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = true;
        PublicTracker.a("KANDIAN_FEEDS_STAGE_1_COST", null);
      }
      AbstractGifImage.resumeAll();
      if (this.jdField_h_of_type_Boolean) {
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new ReadInJoyNewFeedsActivity.10(this), 1000L);
      }
      switch (this.jdField_e_of_type_Int)
      {
      default: 
        ReadInJoyScreenShotReporter.a(this).a();
      }
    }
    for (;;)
    {
      PublicTracker.a("KANDIAN_NEW_FEEDS_RESUME", null);
      return;
      a(8);
      break;
      label300:
      bool = false;
      break label190;
      ReadInJoyScreenShotReporter.a(this).a(0, 0);
      continue;
      ReadInJoyScreenShotReporter.a(this).a(3, 56);
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    ReadInJoyLogicEngine.a().j();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    VideoVolumeControl.a().a(false, "readinjoy tab doOnStop");
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    this.jdField_e_of_type_Long += this.jdField_d_of_type_Long - this.jdField_c_of_type_Long;
    ReadInJoyLogicEngine.a().k();
  }
  
  protected void e()
  {
    e(this.jdField_e_of_type_Int);
    ReadInJoySkinManager localReadInJoySkinManager = (ReadInJoySkinManager)this.app.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
    int i = 0;
    while (i < 4)
    {
      BaseSkinRes localBaseSkinRes = localReadInJoySkinManager.a(i + 4);
      if (localBaseSkinRes != null)
      {
        BaseTabbar.TabHolder localTabHolder = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(i).a;
        localTabHolder.c.setImageDrawable(localBaseSkinRes.a());
        if (i == this.jdField_e_of_type_Int)
        {
          localTabHolder.c.setSelected(true);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(i, i);
        }
      }
      if (localReadInJoySkinManager.a() == 1) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.setTabState(i, false);
      }
      i += 1;
    }
  }
  
  public void e(int paramInt)
  {
    if (SystemUtil.c())
    {
      b(((ReadInJoyNewFeedsActivity.TabInfo)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt))).jdField_b_of_type_Int);
      BaseSkinRes localBaseSkinRes = ((ReadInJoySkinManager)this.app.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).a(8);
      if (localBaseSkinRes != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.setSelectColor(localBaseSkinRes.a());
      }
      return;
    }
    ThreadManager.post(new ReadInJoyNewFeedsActivity.13(this, paramInt), 5, null, false);
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131712968));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    findViewById(2131377161).setOnClickListener(this);
  }
  
  void f(int paramInt)
  {
    Boolean localBoolean = Boolean.valueOf(true);
    if ((this.jdField_f_of_type_Int != 5) || (this.jdField_d_of_type_Boolean)) {
      localBoolean = Boolean.valueOf(false);
    }
    if (localBoolean.booleanValue()) {
      runOnUiThread(new ReadInJoyNewFeedsActivity.16(this, paramInt));
    }
  }
  
  public void finish()
  {
    super.finish();
  }
  
  public void flingLToR()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment.e())) {
      onBackPressed();
    }
  }
  
  public void flingRToL() {}
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.setEnableRepeatedClick(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.setCurrentActivity(this);
    ReadInJoySkinManager localReadInJoySkinManager = (ReadInJoySkinManager)this.app.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
    i = 0;
    while (i < 4)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(i, ((ReadInJoyNewFeedsActivity.TabInfo)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i))).jdField_a_of_type_JavaLangString);
      if (localReadInJoySkinManager.a() != 0)
      {
        BaseSkinRes localBaseSkinRes = localReadInJoySkinManager.a(i + 4);
        if (localBaseSkinRes != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(i).a.c.setImageDrawable(localBaseSkinRes.a());
        }
      }
      i += 1;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.setOnTabChangeListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBaseTabbar$OnTabChangeListener);
    i = getIntent().getIntExtra("tab_tab_index", 0);
    if (i > 0) {
      this.jdField_e_of_type_Int = i;
    }
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b()) || (System.currentTimeMillis() - ReadInJoyHelper.a(this.app) > 600000L) || (this.jdField_f_of_type_Int == 1)) {
          continue;
        }
        if (this.jdField_f_of_type_Int != 9) {
          continue;
        }
      }
      catch (Exception localException)
      {
        QLog.d("ReadInJoyNewFeedsActivity", 1, "restoreHistoryKanDianTab throw Exception.");
        localException.printStackTrace();
        continue;
        i = 1;
        continue;
      }
      if ((i == 0) && (RIJAppSetting.a(b()))) {
        this.jdField_e_of_type_Int = ((ReadInJoyLogicManager)this.app.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).a().d();
      }
      jdField_c_of_type_Int = this.jdField_e_of_type_Int;
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.setSelectedTab(this.jdField_e_of_type_Int, false);
      return;
      this.jdField_e_of_type_Int = 0;
      continue;
      i = 0;
    }
  }
  
  public void g(int paramInt)
  {
    this.jdField_h_of_type_Int |= paramInt;
  }
  
  public void h()
  {
    d(false);
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNewFeedsActivity", 2, "setRecommendRedDotInfo.");
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mChannelCoverId == 0)) {
      for (;;)
      {
        try
        {
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
          }
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.i()) {
            return;
          }
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b())
          {
            i = 1;
            RIJThreadHandler.b().post(new ReadInJoyNewFeedsActivity.7(this, i));
            return;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return;
        }
        int i = 0;
      }
    }
  }
  
  public void j()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Integer)localIterator.next();
      localObject = (ReadInJoySubChannelFragment)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
      if (localObject != null) {
        ((ReadInJoySubChannelFragment)localObject).onDestroy();
      }
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  protected void k()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(this.jdField_e_of_type_Int).a() != null) {
      super.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(this.jdField_e_of_type_Int).a().d());
    }
  }
  
  void l()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      ThreadManager.post(new ReadInJoyNewFeedsActivity.15(this), 5, null, true);
    }
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_e_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController.a()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController.a(null);
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(this.jdField_e_of_type_Int) != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(this.jdField_e_of_type_Int).a();
      if ((localObject instanceof ReadInJoyVideoChannelFragment))
      {
        localObject = ((ReadInJoyVideoChannelFragment)localObject).a();
        if ((localObject != null) && (((VideoPlayManager)localObject).a() != null) && (((VideoPlayManager)localObject).a().a()))
        {
          ((VideoPlayManager)localObject).a().j();
          return true;
        }
      }
      else if (((localObject instanceof ReadInJoyRecommendFeedsFragment)) && (((ReadInJoyRecommendFeedsFragment)localObject).f()))
      {
        return true;
      }
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment.onBackEvent())) {
      return true;
    }
    if ((!ReadInJoyHelper.m()) && (getIntent() != null) && (getIntent().getBooleanExtra("from_lock_screen", false)))
    {
      ReadInJoyDialogUtil.a(this);
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_e_of_type_Int == 2) && (RIJUGCDianDian.a()))
      {
        RIJUGCDianDian.a(this, this.jdField_a_of_type_AndroidViewViewGroup);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008C5F", "0X8008C5F", 0, 0, "", "", "", RIJTransMergeKanDianReport.c(), false);
      }
      else
      {
        RIJWebSearchUtils.a(this);
        UniteSearchReportController.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), new ReportModelDC02528().opername("Kdian_inner_search").module("kd_web_search").action("clk_search"));
        continue;
        if ((this.jdField_e_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController != null))
        {
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController.a()) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController.a(null);
          } else if ((a() instanceof ReadInJoySubChannelFragment)) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController.a(a().a());
          } else {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyNaviController.a(0);
          }
        }
        else
        {
          try
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabbar.a(this.jdField_e_of_type_Int).a().e();
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
            QLog.d("ReadInJoyNewFeedsActivity", 1, "notifyTitleClick failed.");
          }
          continue;
          a().f();
          ThreadManager.executeOnSubThread(new ReadInJoyNewFeedsActivity.14(this));
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((!this.jdField_d_of_type_Boolean) && (!this.jdField_e_of_type_Boolean) && ((paramObject instanceof MessageRecord)) && (KandianMergeManager.a((MessageRecord)paramObject, this.app) == -1) && (((MessageRecord)paramObject).extInt != 5) && (!((MessageRecord)paramObject).isSendFromLocal())) {
      l();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity
 * JD-Core Version:    0.7.0.1
 */