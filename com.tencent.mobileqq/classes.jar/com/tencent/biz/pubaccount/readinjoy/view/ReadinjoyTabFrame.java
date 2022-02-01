package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.EntranceDownloadInfo;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.channelbanner.RIJDianDianEntryVisibleConfig;
import com.tencent.biz.pubaccount.readinjoy.channelbanner.RIJDianDianEntryVisibleConfig.Companion;
import com.tencent.biz.pubaccount.readinjoy.comment.RIJCommentResultDispatcher;
import com.tencent.biz.pubaccount.readinjoy.common.RIJTabFrameBase;
import com.tencent.biz.pubaccount.readinjoy.common.RIJTabFrameBase.Companion;
import com.tencent.biz.pubaccount.readinjoy.common.RIJWindowUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.click.RIJListViewGroupHandlerClick;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJKanDianTabReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJMsgReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAladdinUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJStudyModeUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.msgbox.RIJMsgBoxUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJPushNotification;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJDtParamBuilder;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.MessageObserver;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.OnTabRedNumsChangeListenner;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyWebRenderEngine;
import com.tencent.biz.pubaccount.readinjoy.fragment.RIJChannelReporter;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment.OnNofityVisibleCallback;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyRecommendFeedsFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySubChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoPlayController;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoPlayController.Companion;
import com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageOptConfig;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.FreeNetFlowInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDianDianEntranceModule;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.push.RIJPushNotifyManager;
import com.tencent.biz.pubaccount.readinjoy.push.RIJPushNotifyManager.Companion;
import com.tencent.biz.pubaccount.readinjoy.report.UserActionCollector;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskLocalRepo;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyRefreshManager;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.KandianVideoUploadService;
import com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils;
import com.tencent.biz.pubaccount.readinjoy.video.FeedsChannelDataHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsFirstVideoRecommendationManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager;
import com.tencent.biz.pubaccount.readinjoy.video.discovery.BubblePopupWindow;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyTabTopSearchHeaderController;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager.CustomFragmentPagerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TwoLineContentDialog;
import com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ColorBandVideoEntranceButton;
import com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.IEntranceButtonDataSource;
import com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.RIJColumnDataSource;
import com.tencent.biz.pubaccount.readinjoy.viola.wormhole.Wormhole;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyPatchAdUtils;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.gdtad.util.GdtManager;
import com.tencent.gdtad.util.GdtManager.Params;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ReportPolicy;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import cooperation.readinjoy.ReadInJoyHelper;
import cooperation.readinjoy.content.ReadInJoyDataProviderObserver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.Constants.LogoutReason;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadinjoyTabFrame
  extends RIJTabFrameBase
  implements ViewTreeObserver.OnGlobalLayoutListener, KandianMergeManager.MessageObserver, KandianMergeManager.OnTabRedNumsChangeListenner, ReadInJoyBaseFragment.OnNofityVisibleCallback, ReadInJoyUserInfoModule.RefreshUserInfoCallBack, ReadinjoySlidingIndicator.OnIndicatorChangeListener, RecommendFeedsDiandianEntranceManager.OnEntryIconRefreshListener
{
  public static boolean a;
  public static int b;
  private static int jdField_d_of_type_Int = 0;
  private Handler jdField_a_of_type_AndroidOsHandler = new ReadinjoyTabFrame.17(this);
  private FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  private SparseArray<Bundle> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ReadinjoyTabFrame.26(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ReadInJoyChannelViewPagerController jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewPagerController;
  private ReadInJoyObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new ReadinjoyTabFrame.19(this);
  private ReadInJoyBaseFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment;
  private ChannelCoverInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo;
  private VideoFeedsFirstVideoRecommendationManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFirstVideoRecommendationManager;
  private BubblePopupWindow jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBubblePopupWindow;
  private ClipDianDianTouchAreaLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout;
  private DuplicateEventLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDuplicateEventLayout;
  private ReadinjoySlidingIndicator jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator;
  private ReadinjoyTabFrame.InitWebProcessRunnable jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$InitWebProcessRunnable = new ReadinjoyTabFrame.InitWebProcessRunnable();
  private ReadinjoyViewLayer jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer;
  protected ReadInJoyTabTopSearchHeaderController a;
  private ReadInJoyChannelViewPager.CustomFragmentPagerAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter;
  private ReadInJoyChannelViewPager jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager;
  private ColorBandVideoEntranceButton jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton;
  private FrameFragment jdField_a_of_type_ComTencentMobileqqAppFrameFragment;
  private RedTouch jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  public Runnable a;
  private ConcurrentHashMap<Integer, ReadInJoySubChannelFragment> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private int[] jdField_a_of_type_ArrayOfInt = new int[1];
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[1];
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = 0L;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean = false;
  private long jdField_d_of_type_Long = 0L;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private boolean jdField_d_of_type_Boolean = false;
  private View jdField_e_of_type_AndroidViewView;
  private boolean jdField_e_of_type_Boolean = false;
  private View f;
  private View g;
  private View h;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Int = 0;
  }
  
  public ReadinjoyTabFrame(FrameFragment paramFrameFragment)
  {
    this.jdField_a_of_type_JavaLangRunnable = new ReadinjoyTabFrame.13(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment = paramFrameFragment;
  }
  
  private void A()
  {
    if (ReadInJoyHelper.o()) {}
    while (!ReadInJoyHelper.n()) {
      try
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().clearAnimation();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().setOnClickListener(new ReadinjoyTabFrame.7(this));
        return;
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          localThrowable1.printStackTrace();
          QLog.d("ReadInJoyTabFrame", 1, "show channel entrance failed.");
        }
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().clearAnimation();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().setVisibility(4);
      try
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a().setOnClickListener(new ReadinjoyTabFrame.8(this));
        return;
      }
      catch (Throwable localThrowable2)
      {
        localThrowable2.printStackTrace();
        QLog.d("ReadInJoyTabFrame", 1, "set click listener failed.");
        return;
      }
    }
    catch (Throwable localThrowable3)
    {
      for (;;)
      {
        localThrowable3.printStackTrace();
        QLog.d("ReadInJoyTabFrame", 1, "hide channel entrance failed.");
      }
    }
  }
  
  private void B()
  {
    VideoReport.setElementId(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton, "entrance_button");
    VideoReport.setElementParams(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton, new RIJDtParamBuilder().a("14").c("click_entrance").a(Integer.valueOf(0)).a().a());
    VideoReport.setElementReportPolicy(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton, ReportPolicy.REPORT_POLICY_CLICK);
  }
  
  private void F()
  {
    QBaseActivity localQBaseActivity = a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton = new ColorBandVideoEntranceButton(localQBaseActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout = new ClipDianDianTouchAreaLayout(localQBaseActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setId(2131374200);
    B();
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 85);
    localLayoutParams.bottomMargin = a().getDimensionPixelOffset(2131297347);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setLayoutParams(localLayoutParams);
    localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 48);
    localLayoutParams.bottomMargin = a().getDimensionPixelOffset(2131296925);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setOnVideoCoverClickListener(new ReadinjoyTabFrame.10(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setTouchWidget(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton, 0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setVisibility(4);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getViewTreeObserver().addOnGlobalLayoutListener(this);
    c();
    switch (ReadInJoyHelper.f())
    {
    }
    for (;;)
    {
      RecommendFeedsDiandianEntranceManager.a().a(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFirstVideoRecommendationManager = new VideoFeedsFirstVideoRecommendationManager(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton, localQBaseActivity);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDefaultDrawable(a().getDrawable(2130849806));
      continue;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDefaultDrawable(a().getDrawable(2130849769));
      continue;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDefaultDrawable(a().getDrawable(2130842985));
    }
  }
  
  private void G()
  {
    int i = RecommendFeedsDiandianEntranceManager.c();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null)
    {
      Drawable localDrawable = a().getDrawable(i);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDefaultDrawable(localDrawable);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(null);
    }
  }
  
  private void H()
  {
    Object localObject1 = this.jdField_a_of_type_MqqAppAppRuntime.getApplication();
    int i = SharedPreUtils.e((Context)localObject1);
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout != null) {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.getVisibility() == 0) {
        bool1 = true;
      }
    }
    for (;;)
    {
      boolean bool2;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() == 0) {
          bool2 = true;
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyTabFrame", 2, "initBubblePopWindow mEntranceLayout:" + bool1 + "   btnVisible:" + bool2);
        }
        if ((SharedPreUtils.a((Context)localObject1, a().getCurrentAccountUin(), i, "key_sp_is_first_show_waist_popwindow")) && (ReadInJoyHelper.f() == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.getUserVisibleHint()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a() != null))
        {
          SharedPreUtils.a((Context)localObject1, a().getCurrentAccountUin(), i, "key_sp_is_first_show_waist_popwindow");
          localObject1 = a();
          i = DisplayUtil.a((Context)localObject1, 12.0F);
          int j = DisplayUtil.a((Context)localObject1, 9.0F);
          BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow((Context)localObject1);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBubblePopupWindow = localBubblePopupWindow;
          Object localObject2 = new TextView((Context)localObject1);
          ((TextView)localObject2).setPadding(i, j, i, j);
          localBubblePopupWindow.setContentView((View)localObject2);
          ((TextView)localObject2).setText(a().getString(2131718474));
          localBubblePopupWindow.setAnimationStyle(2131755862);
          localBubblePopupWindow.b(-16777216);
          localBubblePopupWindow.setSoftInputMode(1);
          localBubblePopupWindow.setInputMethodMode(2);
          localBubblePopupWindow.a(localBubblePopupWindow.b() / 2 - DisplayUtil.a((Context)localObject1, 43.0F), 0, 0, 0);
          localObject2 = new int[2];
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a().getLocationOnScreen((int[])localObject2);
          i = ScreenUtil.SCREEN_WIDTH;
          j = DisplayUtil.a((Context)localObject1, 15.0F);
          int k = localBubblePopupWindow.b();
          int m = localObject2[1];
          int n = localBubblePopupWindow.a();
          int i1 = localBubblePopupWindow.c();
          int i2 = DisplayUtil.a((Context)localObject1, 5.0F);
          localBubblePopupWindow.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a(), 48, i - j - k, m - n - i1 - i2);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ReadinjoyTabFrame.11(this), 3000L);
          localObject1 = new VideoR5.Builder(null, null, null, null).a().a();
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009A21", "0X8009A21", 0, 0, "0", "0", null, (String)localObject1, false);
        }
        return;
        bool1 = false;
        break;
        bool2 = false;
        continue;
        bool2 = false;
      }
      bool1 = false;
    }
  }
  
  private void I()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBubblePopupWindow != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBubblePopupWindow.dismiss();
    }
  }
  
  private void J()
  {
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_MqqAppAppRuntime);
    if (bool)
    {
      if (this.jdField_e_of_type_AndroidViewView == null) {
        this.jdField_e_of_type_AndroidViewView = ((ViewStub)a(2131376602)).inflate();
      }
      if (this.jdField_e_of_type_AndroidViewView != null) {
        this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      }
      if (this.f == null)
      {
        Object localObject = (BaseActivity)a();
        if (localObject != null)
        {
          localObject = ((BaseActivity)localObject).getLayoutInflater();
          if (localObject != null) {
            this.f = ((LayoutInflater)localObject).inflate(2131560363, null);
          }
        }
      }
      if (this.f != null)
      {
        if ((this.f.getParent() == null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout != null)) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.addView(this.f);
        }
        this.f.setVisibility(0);
      }
    }
    for (;;)
    {
      h(bool);
      return;
      if (this.jdField_e_of_type_AndroidViewView != null) {
        this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      }
      if (this.f != null) {
        this.f.setVisibility(8);
      }
    }
  }
  
  private void K()
  {
    int i = 0;
    if (i < 1)
    {
      switch (i)
      {
      }
      for (;;)
      {
        i += 1;
        break;
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = HardCodeUtil.a(2131693569);
        this.jdField_a_of_type_ArrayOfInt[i] = 2131376607;
        continue;
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = HardCodeUtil.a(2131712948);
        this.jdField_a_of_type_ArrayOfInt[i] = 2131376620;
        continue;
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = HardCodeUtil.a(2131712880);
        this.jdField_a_of_type_ArrayOfInt[i] = 2131376637;
      }
    }
  }
  
  private void L()
  {
    int i = ReadInJoyHelper.f();
    if (RecommendFeedsDiandianEntranceManager.a(i))
    {
      QLog.d("ReadInJoyTabFrame", 1, "request 0xdcb");
      RecommendFeedsDiandianEntranceManager.a().b();
    }
    if (RecommendFeedsDiandianEntranceManager.b(i))
    {
      QLog.d("ReadInJoyTabFrame", 1, "request 0x6cf coloumn");
      G_();
    }
  }
  
  private void M()
  {
    if (a().findViewById(16908305) != null) {
      a().getDimensionPixelOffset(2131297347);
    }
  }
  
  private void N()
  {
    if (!"2225164739".equals(a().getCurrentAccountUin())) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = new PopupMenuDialog.MenuItem();
    ((PopupMenuDialog.MenuItem)localObject).jdField_a_of_type_Int = 0;
    ((PopupMenuDialog.MenuItem)localObject).jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131712866);
    ((PopupMenuDialog.MenuItem)localObject).jdField_b_of_type_Int = 2130842730;
    localArrayList.add(localObject);
    localObject = new PopupMenuDialog.MenuItem();
    ((PopupMenuDialog.MenuItem)localObject).jdField_a_of_type_Int = 1;
    ((PopupMenuDialog.MenuItem)localObject).jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131713050);
    ((PopupMenuDialog.MenuItem)localObject).jdField_b_of_type_Int = 2130842730;
    localArrayList.add(localObject);
    localObject = new PopupMenuDialog.MenuItem();
    ((PopupMenuDialog.MenuItem)localObject).jdField_a_of_type_Int = 2;
    ((PopupMenuDialog.MenuItem)localObject).jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131712990);
    ((PopupMenuDialog.MenuItem)localObject).jdField_a_of_type_Float = 14.0F;
    ((PopupMenuDialog.MenuItem)localObject).jdField_b_of_type_Int = 2130842730;
    localArrayList.add(localObject);
    localObject = new PopupMenuDialog.MenuItem();
    ((PopupMenuDialog.MenuItem)localObject).jdField_a_of_type_Int = 3;
    ((PopupMenuDialog.MenuItem)localObject).jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131712919);
    ((PopupMenuDialog.MenuItem)localObject).jdField_b_of_type_Int = 2130842730;
    localArrayList.add(localObject);
    PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
    localMenuItem.jdField_a_of_type_Int = 4;
    if (!ReadInJoyUtils.c())
    {
      localObject = "打开预加载UI";
      localMenuItem.jdField_a_of_type_JavaLangString = ((String)localObject);
      localMenuItem.jdField_b_of_type_Int = 2130842730;
      localArrayList.add(localMenuItem);
      localMenuItem = new PopupMenuDialog.MenuItem();
      localMenuItem.jdField_a_of_type_Int = 5;
      if (((Boolean)ReadInJoyHelper.a("dynamicFeeds", Boolean.valueOf(false))).booleanValue()) {
        break label379;
      }
      localObject = "打开动态频道feeds";
      label263:
      localMenuItem.jdField_a_of_type_JavaLangString = ((String)localObject);
      localMenuItem.jdField_a_of_type_Float = 12.0F;
      localMenuItem.jdField_b_of_type_Int = 2130842730;
      localArrayList.add(localMenuItem);
      localMenuItem = new PopupMenuDialog.MenuItem();
      localMenuItem.jdField_a_of_type_Int = 6;
      if (ReadInJoyHelper.C(this.jdField_a_of_type_MqqAppAppRuntime)) {
        break label386;
      }
    }
    label386:
    for (localObject = HardCodeUtil.a(2131712824);; localObject = "切换到Web")
    {
      localMenuItem.jdField_a_of_type_JavaLangString = ((String)localObject);
      localMenuItem.jdField_a_of_type_Float = 12.0F;
      localMenuItem.jdField_b_of_type_Int = 2130842730;
      localArrayList.add(localMenuItem);
      PopupMenuDialog.a(a(), localArrayList, new ReadinjoyTabFrame.24(this)).showAsDropDown(this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch);
      return;
      localObject = "取消预加载UI";
      break;
      label379:
      localObject = "取消动态频道feeds";
      break label263;
    }
  }
  
  private void O()
  {
    int i = 8;
    int k = 0;
    boolean bool = StudyModeManager.a();
    if (bool == this.jdField_e_of_type_Boolean) {
      return;
    }
    this.jdField_e_of_type_Boolean = bool;
    int j;
    Object localObject;
    if (StudyModeManager.a())
    {
      j = 0;
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(i);
      }
      if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(i);
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(j);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager != null)
      {
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager;
        if (this.jdField_e_of_type_Boolean) {
          break label200;
        }
        bool = true;
        label102:
        ((ReadInJoyChannelViewPager)localObject).setSlideLeftAndRight(bool);
      }
      if (this.jdField_d_of_type_AndroidWidgetImageView != null)
      {
        localObject = this.jdField_d_of_type_AndroidWidgetImageView;
        if (!RIJStudyModeUtils.a()) {
          break label206;
        }
      }
    }
    label200:
    label206:
    for (i = k;; i = 4)
    {
      ((ImageView)localObject).setVisibility(i);
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if ((a() instanceof ReadInJoyRecommendFeedsFragment)) {
        c();
      }
      QLog.d("ReadInJoyTabFrame", 1, "updateStudyModelUI, isStudyMode= " + this.jdField_e_of_type_Boolean);
      return;
      j = 8;
      i = 0;
      break;
      bool = false;
      break label102;
    }
  }
  
  private void P()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.c();
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.d();
    ReadInJoyActivityHelper.b(a(), bool);
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = RIJTransMergeKanDianReport.a();
        localJSONObject.put("folder_status", RIJKanDianFolderStatus.jdField_a_of_type_Int);
        if (!bool) {
          continue;
        }
        i = 2;
        localJSONObject.put("reddot", i);
        localJSONObject.put("kandian_mode", RIJAppSetting.a());
        localJSONObject.put("kandian_mode_new", VideoReporter.a());
        localObject = (ReadInJoySkinManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
        if ((((ReadInJoySkinManager)localObject).a() != 1) || (TextUtils.isEmpty(((ReadInJoySkinManager)localObject).a()))) {
          continue;
        }
        localObject = ((ReadInJoySkinManager)localObject).a();
        localJSONObject.put("skin_id", localObject);
        localJSONObject.put("button_state", 0);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(a(), "", "0X8007DB0", "0X8007DB0", 0, 0, "4", "", "", localJSONObject.toString(), false);
        localObject = new HashMap();
        ((Map)localObject).put("uin", ReadInJoyUtils.a());
        UserAction.onUserAction("actRIJSelfPage", (Map)localObject, false, false);
        UserAction.onUserAction("actRIJSelfPage", (Map)localObject, false, false);
      }
      catch (Exception localException)
      {
        int i;
        Object localObject;
        localException.printStackTrace();
        continue;
      }
      PublicTracker.a(null, "self_tab_cost");
      return;
      i = 1;
      continue;
      localObject = "0";
    }
  }
  
  private int a(boolean paramBoolean)
  {
    int j = a().getDimensionPixelOffset(2131297347);
    if (paramBoolean) {}
    for (int i = ViewUtils.b(5.0F); this.jdField_a_of_type_AndroidSupportV4AppFragmentManager != null; i = 0)
    {
      Fragment localFragment = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag(MainFragment.class.getName());
      if (!(localFragment instanceof MainFragment)) {
        break;
      }
      int k = RIJWindowUtils.a.a((MainFragment)localFragment);
      if (k == 0) {
        break;
      }
      return k;
    }
    return j + i;
  }
  
  private VideoInfo a()
  {
    boolean bool1 = false;
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 7);
    int i = (int)(DeviceInfoUtil.i() * 0.4D);
    int j = (int)(DeviceInfoUtil.j() * 0.4D);
    Object localObject2 = new int[2];
    this.jdField_a_of_type_AndroidViewView.getLocationOnScreen((int[])localObject2);
    int k = localObject2[0];
    int m = this.jdField_a_of_type_AndroidViewView.getWidth();
    int n = localObject2[1];
    int i1 = this.jdField_a_of_type_AndroidViewView.getHeight();
    ((Bundle)localObject1).putInt("item_x", k + m - i);
    ((Bundle)localObject1).putInt("item_y", n + i1 - j);
    ((Bundle)localObject1).putInt("item_width", i);
    ((Bundle)localObject1).putInt("item_height", j);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null)
    {
      ((Bundle)localObject1).putInt("item_image_width", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a());
      ((Bundle)localObject1).putInt("item_image_height", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.b());
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFirstVideoRecommendationManager != null)
    {
      boolean bool2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFirstVideoRecommendationManager.a((Bundle)localObject1);
      localObject2 = (VideoInfo)((Bundle)localObject1).getParcelable("VIDEO_OBJ");
      if (ReadInJoyHelper.f() == 1)
      {
        localObject1 = FeedsChannelDataHelper.a((VideoInfo)localObject2);
        if ((localObject1 != null) && ((localObject1 instanceof ArticleInfo)))
        {
          RIJListViewGroupHandlerClick.a(a(), null, (ArticleInfo)localObject1, false, 0, 0, false, 1004);
          return localObject2;
        }
        ReadInJoyActivityHelper.a(a(), 56, a().getString(2131719348), 3, 1004);
        return localObject2;
      }
      QBaseActivity localQBaseActivity = a();
      if (!bool2) {
        bool1 = true;
      }
      VideoFeedsHelper.a(localQBaseActivity, (Bundle)localObject1, bool1, 11);
      d(3);
      return localObject2;
    }
    QLog.d("ReadInJoyTabFrame", 1, "videoManager is null, can't jump to videoPlayActivity!");
    return null;
  }
  
  private void a(int paramInt, SelectPositionModule.PositionData paramPositionData)
  {
    Object localObject = a();
    switch (paramInt)
    {
    default: 
      QLog.e("ReadInJoyTabFrame", 2, "showLocationChangedDialog invalid type = " + paramInt);
      return;
    case 1: 
      localObject = DialogUtil.a((Activity)localObject, String.format("你当前在%s，是否切换定位？", new Object[] { paramPositionData.cityGPS }));
      ((QQCustomDialog)localObject).setPositiveButton("确认", new ReadinjoyTabFrame.20(this, paramPositionData));
      ((QQCustomDialog)localObject).setNegativeButton("取消", new ReadinjoyTabFrame.21(this));
      ((QQCustomDialog)localObject).setCanceledOnTouchOutside(true);
      ((QQCustomDialog)localObject).show();
      return;
    }
    paramPositionData = ReadInJoyDialogUtil.a((Context)localObject, String.format("你当前在%s，暂无本地频道。", new Object[] { paramPositionData.cityGPS }), "是否保留原定位？");
    paramPositionData.setPositiveButton("确认", new ReadinjoyTabFrame.22(this));
    paramPositionData.setNegativeButton("取消", new ReadinjoyTabFrame.23(this));
    paramPositionData.show();
  }
  
  private void a(VideoInfo paramVideoInfo)
  {
    ThreadManager.excute(new ReadinjoyTabFrame.18(this, paramVideoInfo, (ReadInJoySkinManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)), 16, null, true);
  }
  
  private void a(String paramString)
  {
    ReadInJoyHelper.a("KEY_ENTRANCE_SCHEMA", paramString);
  }
  
  private void c(View paramView)
  {
    j = RIJColumnDataSource.jdField_b_of_type_Int;
    try
    {
      paramView = paramView.getTag();
      i = j;
      if (paramView != null) {
        i = Integer.parseInt(String.valueOf(paramView));
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        IEntranceButtonDataSource localIEntranceButtonDataSource;
        QLog.d("ReadInJoyTabFrame", 1, "parseInt error!");
        int i = j;
        continue;
        if ((localIEntranceButtonDataSource instanceof RecommendFeedsDiandianEntranceManager.EntranceIconInfo))
        {
          String str = ((RecommendFeedsDiandianEntranceManager.EntranceIconInfo)localIEntranceButtonDataSource).c;
          QLog.d("ReadInJoyTabFrame", 1, "entranceIconInfo recommendfeeds jumpSchema " + str);
          paramView = str;
          if (TextUtils.isEmpty(str)) {
            paramView = RecommendFeedsDiandianEntranceManager.a(((RecommendFeedsDiandianEntranceManager.EntranceIconInfo)localIEntranceButtonDataSource).jdField_a_of_type_Int);
          }
          if (!TextUtils.isEmpty(paramView))
          {
            ReadInJoyUtils.a(a(), paramView);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(null);
            a(paramView);
          }
          RecommendFeedsDiandianEntranceManager.a().a();
        }
        else
        {
          if ((localIEntranceButtonDataSource instanceof RIJColumnDataSource))
          {
            paramView = (RIJColumnDataSource)localIEntranceButtonDataSource;
            QLog.d("ReadInJoyTabFrame", 1, "column button jump to red source! " + paramView);
            if (paramView.a == null) {
              ReadInJoyUtils.a(a(), ReadInJoyHelper.b());
            }
            for (;;)
            {
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(null);
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a();
              RecommendFeedsDiandianEntranceManager.a().a(paramView, i, 0, a());
              break;
              VideoFeedsHelper.a(a(), paramView.a);
            }
          }
          QLog.d("ReadInJoyTabFrame", 1, "lauch videofeeds");
          a(a());
          continue;
          j = RecommendFeedsDiandianEntranceManager.a().b();
          QLog.d("ReadInJoyTabFrame", 1, "diandian button jump to default url! feedType " + j);
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.jdField_a_of_type_Boolean))
          {
            QLog.d("ReadInJoyTabFrame", 1, "isColumnDiandianBtn true");
            RecommendFeedsDiandianEntranceManager.a().a(null, i, 0, a());
            ReadInJoyUtils.a(a(), ReadInJoyHelper.b());
          }
          else if ((j == 2) || (j == 1))
          {
            QLog.d("ReadInJoyTabFrame", 1, "ENTRANCE_FEEDS_TYPE_VIDEO or ENTRANCE_FEEDS_TYPE_VIDEO_CHANNEL");
            a(a());
          }
          else
          {
            QLog.d("ReadInJoyTabFrame", 1, "jump default schema");
            ReadInJoyUtils.a(a(), RecommendFeedsDiandianEntranceManager.a(j));
          }
        }
      }
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a() != null))
    {
      QLog.d("ReadInJoyTabFrame", 1, "entrancebutton has red dot: " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a());
      localIEntranceButtonDataSource = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a();
      if (((localIEntranceButtonDataSource instanceof VideoInfo.EntranceDownloadInfo)) && (((VideoInfo.EntranceDownloadInfo)localIEntranceButtonDataSource).a != null))
      {
        QLog.d("ReadInJoyTabFrame", 1, "entrancebutton downloadinfo: " + ((VideoInfo.EntranceDownloadInfo)localIEntranceButtonDataSource).a);
        paramView = (VideoInfo.EntranceDownloadInfo)localIEntranceButtonDataSource;
        if (QLog.isColorLevel()) {
          QLog.d("VideoEntranceButton", 2, "resolveUrlJumpInfo");
        }
        VideoFeedsHelper.a(a(), paramView.a);
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFirstVideoRecommendationManager != null)
        {
          VideoFeedsFirstVideoRecommendationManager.b(paramView);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFirstVideoRecommendationManager.a();
        }
        if (RIJAladdinUtils.k()) {
          b(2);
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoEntranceButton", 2, "performVideoFeedsClick");
        }
        return;
      }
    }
  }
  
  private boolean c()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null))
    {
      int i;
      int j;
      label51:
      label71:
      StringBuilder localStringBuilder;
      if ((ReadInJoyHelper.a("sp_key_readinjoy_video_entrance_reddot_button_switch", true)) && (RIJDianDianEntryVisibleConfig.a.a(a())))
      {
        i = 1;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() != 0) {
          break label140;
        }
        j = 1;
        if (i == 0) {
          break label145;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setVisibility(0);
        localStringBuilder = new StringBuilder().append("setEntranceButton Visibility: ");
        if (i == 0) {
          break label165;
        }
      }
      label140:
      label145:
      label165:
      for (String str = "true";; str = "false")
      {
        QLog.d("ReadInJoyTabFrame", 1, str);
        if ((j == 0) && (i != 0)) {
          RecommendFeedsDiandianEntranceManager.a().a(0, a());
        }
        if (j == i) {
          break label172;
        }
        return true;
        i = 0;
        break;
        j = 0;
        break label51;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setVisibility(4);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setVisibility(8);
        break label71;
      }
      label172:
      return false;
    }
    return false;
  }
  
  private void d(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFirstVideoRecommendationManager != null) && (RecommendFeedsDiandianEntranceManager.a().a())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFirstVideoRecommendationManager.a(paramInt);
    }
  }
  
  private void h(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout != null)
    {
      int i = a(paramBoolean);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.getLayoutParams();
      localLayoutParams.bottomMargin = i;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout.setLayoutParams(localLayoutParams);
    }
  }
  
  public static void t()
  {
    RIJTabFrameDeliverPopupUtil.a("0X800AC6D", 3);
  }
  
  private void u()
  {
    c();
    G();
    RecommendFeedsDiandianEntranceManager.a().c();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFirstVideoRecommendationManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFirstVideoRecommendationManager.d();
    }
  }
  
  private void v()
  {
    a(2131379682).setBackgroundDrawable(null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyTabTopSearchHeaderController = new ReadInJoyTabTopSearchHeaderController(a(), (ViewGroup)a(2131379682));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)a(2131376547));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager = ((ReadInJoyChannelViewPager)a(2131376564));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131376544));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131378616));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)a(2131377127));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)a(2131364765));
    this.jdField_b_of_type_AndroidViewView = a(2131379451);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator = ((ReadinjoySlidingIndicator)a(2131378256));
    K();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.setTabData(this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_ArrayOfInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.setOnIndicatorChangeListener(this);
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)a(2131379533));
    this.jdField_d_of_type_AndroidViewView = a(2131378451);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131376625));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131376624));
    this.h = a(2131377625);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380586));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131380585));
    label346:
    label354:
    Object localObject;
    if (RIJAladdinUtils.g())
    {
      QLog.d("ReadInJoyTabFrame", 2, "overdraw switch open");
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(a().getColor(2131167374));
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.setBackgroundColor(a().getColor(2131167305));
      }
      if (!RIJUgcUtils.m()) {
        break label672;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (RIJMsgBoxUtils.a() != 0) {
        break label684;
      }
      i = 1;
      localObject = a(2131371968);
      if (i == 0) {
        break label689;
      }
    }
    label672:
    label684:
    label689:
    for (int i = 0;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      this.g = a(2131376594);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131371917));
      i = AIOUtils.a(3.0F, a());
      this.jdField_c_of_type_AndroidWidgetTextView.setPadding(i, 0, i, 0);
      this.g.setOnClickListener(new ReadinjoyTabFrame.1(this));
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(a().getBaseContext(), a(2131372424)).b(53).a();
      VideoReport.setElementId(this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch, "head_sculpture_button");
      VideoReport.setElementReportPolicy(this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch, ReportPolicy.REPORT_POLICY_CLICK);
      VideoReport.setElementParams(this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch, new RIJDtParamBuilder().a("14").c("click_head_sculpture").a().a());
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.setOnClickListener(new ReadinjoyTabFrame.2(this));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new ReadinjoyTabFrame.3(this));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new ReadinjoyTabFrame.4(this));
      IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
      IphoneTitleBarActivity.setLayerType(this.jdField_d_of_type_AndroidViewView);
      c();
      ai_();
      z();
      y();
      localObject = (ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer.findViewById(2131365241);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDuplicateEventLayout.setViews((ViewGroup)localObject, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewClipDianDianTouchAreaLayout);
      F();
      if ("2225164739".equals(a().getCurrentAccountUin())) {
        this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.setOnLongClickListener(new ReadinjoyTabFrame.5(this));
      }
      m();
      return;
      QLog.d("ReadInJoyTabFrame", 2, "overdraw switch close");
      break;
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      break label346;
      i = 0;
      break label354;
    }
  }
  
  private void w()
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView == null) {}
    for (;;)
    {
      return;
      boolean bool = RIJUgcUtils.m();
      if (bool) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      while ((QLog.isDebugVersion()) || (QLog.isColorLevel()))
      {
        QLog.i("ReadInJoyTabFrame", 2, "[refreshDeliverButton] needShow = " + bool);
        return;
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  private void x()
  {
    SelectPositionModule localSelectPositionModule = ReadInJoyLogicEngine.a().a();
    if (localSelectPositionModule != null) {
      localSelectPositionModule.a();
    }
  }
  
  private void y()
  {
    a(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter = new ReadInJoyChannelViewPager.CustomFragmentPagerAdapter(this.jdField_a_of_type_AndroidSupportV4AppFragmentManager);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyTabTopSearchHeaderController);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewPagerController = new ReadInJoyChannelViewPagerController(a(), this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewPagerController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyTabTopSearchHeaderController);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewPagerController.a(new ReadinjoyTabFrame.6(this));
  }
  
  private void z()
  {
    A();
  }
  
  public void A_()
  {
    ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
    if (localReadInJoyBaseFragment != null) {
      localReadInJoyBaseFragment.f();
    }
    try
    {
      RIJKanDianTabReport.a(a(), localReadInJoyBaseFragment);
      RIJKanDianTabReport.a(a(), true);
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("ReadInJoyTabFrame", 1, localJSONException, new Object[0]);
    }
  }
  
  public void B_()
  {
    w();
  }
  
  protected void G_()
  {
    if ((a() instanceof ReadInJoyRecommendFeedsFragment))
    {
      ReadInJoyDianDianEntranceModule localReadInJoyDianDianEntranceModule = ReadInJoyLogicEngine.a().a();
      if (localReadInJoyDianDianEntranceModule != null) {
        localReadInJoyDianDianEntranceModule.a();
      }
    }
    else
    {
      return;
    }
    QLog.d("ReadInJoyTabFrame", 1, "requestColumn0x6cf failed!");
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewPagerController != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewPagerController.b();
    }
    return -1;
  }
  
  public int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    return 0;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560338, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer = new ReadinjoyViewLayer(a().getBaseContext());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer.addView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDuplicateEventLayout = new DuplicateEventLayout(a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDuplicateEventLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDuplicateEventLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewDuplicateEventLayout;
  }
  
  public ReadInJoyBaseFragment a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewPagerController != null)
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewPagerController.a();
      if ((localObject instanceof ReadInJoyBaseFragment)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment = ((ReadInJoyBaseFragment)localObject);
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment;
    if ((localObject != null) && (((ReadInJoyBaseFragment)localObject).getActivity() == null))
    {
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "FragmentOnStartError", false, NetConnInfoCenter.getServerTimeMillis() - this.jdField_d_of_type_Long, 0L, null, "", true);
      ThreadManager.getSubThreadHandler().postDelayed(new ReadinjoyTabFrame.9(this, (ReadInJoyBaseFragment)localObject), 1000L);
      return null;
    }
    return localObject;
  }
  
  public ChannelCoverInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewPagerController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewPagerController.c(paramInt);
    }
  }
  
  protected void a(int paramInt, KandianMergeManager paramKandianMergeManager)
  {
    if ((paramKandianMergeManager.b()) || (paramKandianMergeManager.e() > 0))
    {
      if (paramInt != 6) {
        break label85;
      }
      paramInt = a().getIntent().getIntExtra("jump_activity_launch_channel_id", 0);
      RIJChannelReporter.a(paramInt, "304");
    }
    for (;;)
    {
      if ((paramInt == 0) || (paramInt == ChannelCoverInfoModule.a())) {
        f(false);
      }
      QLog.d("ReadInJoyTabFrame", 1, "onTabChange, has red point, switch to main fragment,channeldId;" + paramInt);
      return;
      label85:
      paramInt = 0;
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
    paramConfiguration = a().getDisplayMetrics();
    float f2 = FontSettingManager.getFontLevel() / 16.0F;
    float f1 = f2;
    if (f2 == 0.0F) {
      f1 = 1.0F;
    }
    f1 = paramConfiguration.density / f1;
    QLog.d("ReadInJoyTabFrame", 1, "onConfigurationChanged densityNoScale : " + f1 + ", screenWidth : " + paramConfiguration.widthPixels);
    Utils.init(f1, paramConfiguration.widthPixels);
  }
  
  public void a(Drawable paramDrawable)
  {
    Object localObject = Aladdin.getConfig(313);
    String str1;
    String str2;
    if (localObject != null)
    {
      this.jdField_c_of_type_Int = ((AladdinConfig)localObject).getIntegerFromString("SearchBox_TopBGType", 0);
      str1 = "#" + ((AladdinConfig)localObject).getString("SearchBox_BGColor", "f5f6fa");
      str2 = "#" + ((AladdinConfig)localObject).getString("SearchBox_BorderColor", "faf6fa");
      localObject = "#" + ((AladdinConfig)localObject).getString("SearchBox_TextColor", "737373");
      if (this.jdField_c_of_type_Int != 1) {
        break label271;
      }
      a(this.jdField_d_of_type_AndroidViewView, true);
      a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, true);
      a(this.jdField_b_of_type_AndroidViewView, true);
      this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(-1);
      this.jdField_b_of_type_AndroidWidgetImageView.setColorFilter(-1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a(2131167030, 2131167030, 2131167030);
      paramDrawable.setColorFilter(a().getColor(2131167030), PorterDuff.Mode.SRC_IN);
      ((ImageView)this.g).setImageDrawable(paramDrawable);
    }
    for (;;)
    {
      paramDrawable = (GradientDrawable)this.h.getBackground();
      paramDrawable.setStroke(ViewUtils.b(1.0F), Color.parseColor(str2));
      paramDrawable.setColor(Color.parseColor(str1));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor((String)localObject));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor((String)localObject));
      return;
      label271:
      this.jdField_a_of_type_AndroidWidgetImageView.clearColorFilter();
      this.jdField_b_of_type_AndroidWidgetImageView.clearColorFilter();
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyViewLayer.a(paramView);
  }
  
  public void a(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton == null) {}
    do
    {
      return;
      QLog.d("ReadInJoyTabFrame", 1, "onEntryIconRefresh");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(paramIEntranceButtonDataSource);
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() != 0);
    if (paramIEntranceButtonDataSource != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a(paramIEntranceButtonDataSource);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setNotMsg();
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    ai_();
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle)
  {
    ai_();
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    super.a(paramLogoutReason);
    ((ReadInJoyRefreshManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER)).a(0, "", -1L, 0);
    if (a() != null) {
      a().a(paramLogoutReason);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    RIJAppSetting.a(a(), this, true, this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, this.jdField_c_of_type_Int);
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    VideoReport.traversePage(this.jdField_a_of_type_AndroidViewView);
    if (paramBoolean)
    {
      a(this.jdField_a_of_type_Int, localKandianMergeManager);
      c(this.jdField_a_of_type_Int);
      ReadInJoyWebRenderEngine.c();
      s();
      L();
      RIJImageOptConfig.a.a();
      VideoPlayController.a.a();
      q();
      RIJMsgReport.a.a();
      h(ThemeUtil.isInNightMode(this.jdField_a_of_type_MqqAppAppRuntime));
    }
    for (;;)
    {
      g(paramBoolean);
      QLog.d("Q.readinjoy.4tab", 1, "readinjoy tab change visiable : " + paramBoolean + "， launchFrom : " + this.jdField_a_of_type_Int);
      O();
      RIJPushNotifyManager.a.a().a(false, "MATCH_ALL_UIN");
      return;
      p();
      RIJAppSetting.a(a(), this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
      o();
    }
  }
  
  public boolean a(KandianMergeManager paramKandianMergeManager)
  {
    return ((a() != null) && (a().mChannelCoverId != 0)) || (paramKandianMergeManager.e() > 0);
  }
  
  public String a_()
  {
    return HardCodeUtil.a(2131693569);
  }
  
  public void a_(boolean paramBoolean)
  {
    if (!paramBoolean) {
      I();
    }
  }
  
  public void ai_()
  {
    SparseIntArray localSparseIntArray = ((KandianMergeManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a();
    int j = 0;
    if (j < localSparseIntArray.size())
    {
      int k = localSparseIntArray.keyAt(j);
      int m = localSparseIntArray.valueAt(j);
      int i;
      switch (k)
      {
      default: 
        i = -1;
      }
      for (;;)
      {
        Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
        localMessage.arg1 = m;
        localMessage.arg2 = i;
        localMessage.obj = Integer.valueOf(k);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
        j += 1;
        break;
        i = 2131376607;
        continue;
        i = 2131376637;
        continue;
        i = 2131376620;
      }
    }
    ThreadManager.getUIHandler().post(new ReadinjoyTabFrame.15(this));
  }
  
  public int b()
  {
    return 0;
  }
  
  public void b(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton == null) {}
    do
    {
      return;
      QLog.d("ReadInJoyTabFrame", 1, "onAccountChange");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource(paramIEntranceButtonDataSource);
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() != 0);
    if (paramIEntranceButtonDataSource != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a(paramIEntranceButtonDataSource);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setNotMsg();
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    ai_();
  }
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (a() != null) {
      a().a(this);
    }
    Object localObject = a().findViewById(16908305);
    if (localObject != null) {
      SlideActiveAnimController.a((View)localObject);
    }
    jdField_a_of_type_Boolean = true;
    ApngImage.playByTag(8);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getVisibility() == 0))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.e();
      if (!paramBoolean) {
        break label246;
      }
      d(1);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        localObject = ReadInJoyLogicEngine.a().a();
        if (localObject != null) {
          ((FreeNetFlowInfoModule)localObject).a(false);
        }
        RIJPushNotification.a();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyTabTopSearchHeaderController.c();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.g();
      }
      localObject = a().getIntent();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewPagerController != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewPagerController.b();
      }
      if (!this.jdField_c_of_type_Boolean)
      {
        x();
        this.jdField_c_of_type_Boolean = true;
      }
      if (RIJTabFrameBase.a.a()) {
        RIJKanDianTabReport.a(true);
      }
      ReadInJoyLogicEngine.a().q();
      if (((Boolean)ReadInJoyHelper.a("key_sp_is_readinjoy_youngster_changed", Boolean.valueOf(false))).booleanValue())
      {
        if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment instanceof ReadInJoyRecommendFeedsFragment)) && (!((Intent)localObject).getBooleanExtra("is_watch_word_share", false))) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment.a(9);
        }
        ReadInJoyHelper.a("key_sp_is_readinjoy_youngster_changed", Boolean.valueOf(false));
      }
      O();
      return;
      label246:
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFirstVideoRecommendationManager != null) {
        VideoFeedsFirstVideoRecommendationManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a());
      }
    }
  }
  
  public boolean b()
  {
    ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
    if ((localReadInJoyBaseFragment instanceof ReadInJoyVideoChannelFragment))
    {
      VideoPlayManager localVideoPlayManager = ((ReadInJoyVideoChannelFragment)localReadInJoyBaseFragment).a();
      if ((localVideoPlayManager != null) && (localVideoPlayManager.a() != null))
      {
        if (localVideoPlayManager.a().a())
        {
          localVideoPlayManager.a().j();
          localVideoPlayManager.a().c();
          return true;
        }
        if (ReadInJoyPatchAdUtils.a(localVideoPlayManager.a())) {
          localVideoPlayManager.a().c();
        }
      }
    }
    if (((localReadInJoyBaseFragment instanceof ReadInJoyRecommendFeedsFragment)) && (((ReadInJoyRecommendFeedsFragment)localReadInJoyBaseFragment).f())) {
      return true;
    }
    return super.b();
  }
  
  public void c()
  {
    Drawable localDrawable = a().getDrawable(2130843140);
    if ((ThemeUtil.isDefaultOrDIYTheme(false)) || (ThemeUtil.isSimpleDayTheme(false)))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843056);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130843052);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a(2131166919, 2131166920, 2131166918);
      localDrawable.setColorFilter(a().getColor(2131165357), PorterDuff.Mode.SRC_IN);
      ((ImageView)this.g).setImageDrawable(localDrawable);
      a(localDrawable);
    }
    for (;;)
    {
      J();
      RIJAppSetting.a(a(), this, true, this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, this.jdField_c_of_type_Int);
      ReadInJoyLogicEngineEventDispatcher.a().g();
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850547);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840465);
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130850507);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoySlidingIndicator.a(2131167030, 2131167030, 2131167030);
      localDrawable.setColorFilter(a().getColor(2131167030), PorterDuff.Mode.SRC_IN);
      ((ImageView)this.g).setImageDrawable(localDrawable);
      a(this.jdField_d_of_type_AndroidViewView, false);
    }
  }
  
  public void c(int paramInt)
  {
    if (paramInt == 13)
    {
      ReadInJoyUtils.a(6);
      Object localObject = a().getIntent().getExtras();
      if (DailyFeedsDiandianEntranceManager.a((Bundle)localObject))
      {
        localObject = DailyFeedsDiandianEntranceManager.a((Bundle)localObject);
        if (localObject != null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.setDataSource((IEntranceButtonDataSource)localObject);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.a((IEntranceButtonDataSource)localObject);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.postDelayed(new ReadinjoyTabFrame.25(this), 1000L);
        }
      }
    }
  }
  
  public void e()
  {
    super.e();
  }
  
  public void e(boolean paramBoolean)
  {
    try
    {
      A();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewPagerController != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewPagerController.e();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        QLog.d("ReadInJoyTabFrame", 1, "init Channel Entry failed.");
      }
    }
  }
  
  public void f()
  {
    super.f();
    ReadInJoyLogicEngineEventDispatcher.a().a();
    Object localObject = (BaseActivity)a();
    if ((localObject instanceof SplashActivity)) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = ((SplashActivity)localObject).getSupportFragmentManager();
    }
    for (;;)
    {
      if (localObject != null) {
        GdtManager.a().a((Context)localObject, new GdtManager.Params());
      }
      v();
      localObject = (KandianMergeManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
      ((KandianMergeManager)localObject).a(this);
      ((KandianMergeManager)localObject).a(this);
      ((ReadInJoySkinManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
      ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
      Wormhole.a();
      RIJRewardTaskLocalRepo.b().a();
      return;
      if ((localObject instanceof FragmentActivity)) {
        this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = ((FragmentActivity)localObject).getSupportFragmentManager();
      }
    }
  }
  
  public void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewPagerController != null)
    {
      int j = 0;
      int i = j;
      if (!paramBoolean)
      {
        i = j;
        if (ChannelCoverInfoModule.a() != -1) {
          i = ChannelCoverInfoModule.a();
        }
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewPagerController.c(i);
    }
  }
  
  protected void g(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewPagerController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewPagerController.a(paramBoolean);
    }
  }
  
  public void k()
  {
    super.k();
    ((ReadInJoySkinManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyTabTopSearchHeaderController.e();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewPagerController != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewPagerController.d();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewPagerController = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFirstVideoRecommendationManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsFirstVideoRecommendationManager.c();
    }
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    localKandianMergeManager.b(this);
    localKandianMergeManager.b(this);
    RIJCommentResultDispatcher.a().a();
    ReadInJoyDataProviderObserver.a().a();
    KandianVideoUploadService.a(null);
    RecommendFeedsDiandianEntranceManager.a().b(this);
    UserActionCollector.a().c();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.i();
    }
  }
  
  public void l()
  {
    super.l();
    Object localObject = (KandianMergeManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    ((KandianMergeManager)localObject).a(this);
    ((KandianMergeManager)localObject).a(this);
    int i;
    if (RIJMsgBoxUtils.a() == 0)
    {
      i = 1;
      localObject = a(2131371968);
      if (i == 0) {
        break label115;
      }
      i = 0;
      label50:
      ((View)localObject).setVisibility(i);
      m();
      ((ReadInJoySkinManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton);
      if (!RIJUgcUtils.m()) {
        break label121;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      RIJDianDianEntryVisibleConfig.a.b();
      u();
      VideoPlayController.a.a();
      return;
      i = 0;
      break;
      label115:
      i = 8;
      break label50;
      label121:
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void m()
  {
    Object localObject = ((KandianMergeManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a();
    if (localObject != null)
    {
      int i = ((KandianMsgBoxRedPntInfo)localObject).mMsgCnt;
      localObject = i + "";
      if (i > 99) {
        localObject = "99+";
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void n()
  {
    super.n();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.a() != this) {
      M();
    }
    jdField_a_of_type_Boolean = false;
    I();
    ApngImage.pauseByTag(8);
    ReadInJoyLogicEngine.n();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyTabTopSearchHeaderController.d();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.f();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewPagerController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewPagerController.c();
    }
  }
  
  protected void o() {}
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    H();
  }
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    QLog.d("ReadInJoyTabFrame", 2, new Object[] { "onLoadUserInfoFailed, uin = ", paramString1, Character.valueOf('\n'), "errMsg = ", paramString2 });
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    QLog.d("ReadInJoyTabFrame", 2, new Object[] { "onLoadUserInfoSucceed uin = ", paramString, Character.valueOf('\n'), "userInfo = ", paramReadInJoyUserInfo });
  }
  
  protected void p()
  {
    int i = 0;
    while (i < 1)
    {
      ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
      if (localReadInJoyBaseFragment != null) {
        localReadInJoyBaseFragment.i();
      }
      i += 1;
    }
  }
  
  protected void q()
  {
    if ((StudyModeManager.a()) && (RIJStudyModeUtils.a())) {
      RIJStudyModeUtils.b("0X800AF05");
    }
  }
  
  protected void s()
  {
    boolean bool = false;
    int j = 1;
    long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    int i;
    if ((a() != null) && (!(a() instanceof ReadInJoyRecommendFeedsFragment)))
    {
      long l2 = ReadInJoyHelper.d(ReadInJoyUtils.a());
      if ((l1 >= l2) && (this.jdField_a_of_type_Long != 0L))
      {
        this.jdField_d_of_type_Boolean = true;
        ReadInJoyLogicEngineEventDispatcher.a().k();
        QLog.d("Q.readinjoy.4tab", 2, new Object[] { "auto focus on recommend channel, exitTime : " + l1, ", timeLimit = ", Long.valueOf(l2) });
        i = 1;
        if (StudyModeManager.a())
        {
          bool = true;
          i = j;
        }
      }
    }
    for (;;)
    {
      if (i != 0) {
        f(bool);
      }
      return;
      continue;
      i = 0;
      break;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame
 * JD-Core Version:    0.7.0.1
 */