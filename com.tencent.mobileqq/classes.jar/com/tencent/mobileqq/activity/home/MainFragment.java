package com.tencent.mobileqq.activity.home;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.biz.pubaccount.readinjoy.common.RIJTabFrameBase.KandianFrameStatus;
import com.tencent.biz.pubaccount.readinjoy.common.RIJXTabFrameUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.pubaccount.readinjoy.view.appinpush.KandianAppInPush;
import com.tencent.biz.subscribe.utils.SubscribeAdDeviceInfoHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mm.hardcoder.HardCoderManager;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.activity.aio.AppGuideTipsManager;
import com.tencent.mobileqq.activity.aio.anim.MainEnterOutAni;
import com.tencent.mobileqq.activity.fling.ScreenCapture;
import com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl;
import com.tencent.mobileqq.activity.framebusiness.RIJInjectImpl;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.activity.main.LebaTabRedTouch;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.activity.qcircle.QCircleFrame;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.recent.cur.TabDragListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QIMNewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.qim.QIMNewFriend;
import com.tencent.mobileqq.config.AboutConfig;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.forward.ForwardDialogMgr;
import com.tencent.mobileqq.login.PwdSetUtil;
import com.tencent.mobileqq.managers.LoadingStateManager;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.onlinestatus.AccountPanel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.startup.step.SetSplash;
import com.tencent.mobileqq.startup.step.StartService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;
import com.tencent.mobileqq.upgrade.UpgradeController;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.vas.adapter.ThemeFontAdapter;
import com.tencent.mobileqq.vipgift.VipGiftDownloadInfo;
import com.tencent.mobileqq.vipgift.VipGiftManager;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.mobileqq.widget.QQTabWidget.onTabWidgetTouchMoveListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.qqperf.UnifiedMonitor;
import com.tencent.qqperf.tools.SceneTracker;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import com.tencent.util.notification.NotifyIdManager;
import com.tencent.widget.ActionSheet;
import common.config.service.QzoneConfig;
import common.config.service.QzoneConfig.QzoneConfigChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.app.Constants.LogoutReason;
import mqq.os.MqqHandler;
import protocol.KQQConfig.UpgradeInfo;

public class MainFragment
  extends FrameHelperActivity
{
  public static boolean a;
  public static boolean b;
  private static SparseArray<Animation> jdField_c_of_type_AndroidUtilSparseArray = new SparseArray(2);
  Dialog a;
  public RIJTabFrameBase.KandianFrameStatus a;
  public MainAssistObserver a;
  public TabDragListener a;
  public QQTabWidget.onTabWidgetTouchMoveListener a;
  public QzoneConfig.QzoneConfigChangeListener a;
  public String a;
  private int jdField_b_of_type_Int = -1;
  private Dialog jdField_b_of_type_AndroidAppDialog;
  private long jdField_c_of_type_Long = 0L;
  boolean jdField_c_of_type_Boolean = true;
  private String f = null;
  private String g = null;
  private boolean p = true;
  private boolean q = false;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
  }
  
  public MainFragment()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonRIJTabFrameBase$KandianFrameStatus = new RIJTabFrameBase.KandianFrameStatus();
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurTabDragListener = new TabDragListener(null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabWidget$onTabWidgetTouchMoveListener = new MainFragment.1(this);
  }
  
  private void A()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "showActionSheet");
    }
    e();
    ArrayList localArrayList = new ArrayList();
    Object localObject = new MainFragment.OverallMenuInfo();
    ((MainFragment.OverallMenuInfo)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131720477);
    localArrayList.add(new Pair(Integer.valueOf(2131372655), localObject));
    localObject = a().getAboutConfig().a("com.tencent.Feedback_5_8");
    if ((localObject != null) && (((ResourcePluginInfo)localObject).cLocalState != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "feedback plugin is add overmenu");
      }
      MainFragment.OverallMenuInfo localOverallMenuInfo = new MainFragment.OverallMenuInfo();
      localOverallMenuInfo.jdField_a_of_type_JavaLangString = ((ResourcePluginInfo)localObject).strResName;
      localOverallMenuInfo.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo = ((ResourcePluginInfo)localObject);
      localArrayList.add(new Pair(Integer.valueOf(2131372654), localOverallMenuInfo));
    }
    localObject = new MainFragment.OverallMenuInfo();
    ((MainFragment.OverallMenuInfo)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131693947);
    localArrayList.add(new Pair(Integer.valueOf(2131372653), localObject));
    localObject = new MainFragment.OverallMenuInfo();
    ((MainFragment.OverallMenuInfo)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131690779);
    localArrayList.add(new Pair(Integer.valueOf(2131372652), localObject));
    localObject = ActionSheet.createMenuSheet(getActivity());
    int i = 0;
    if (i < localArrayList.size())
    {
      if (2131372652 == ((Integer)((Pair)localArrayList.get(i)).first).intValue()) {
        ((ActionSheet)localObject).addCancelButton(((MainFragment.OverallMenuInfo)((Pair)localArrayList.get(i)).second).jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        i += 1;
        break;
        ((ActionSheet)localObject).addButton(((MainFragment.OverallMenuInfo)((Pair)localArrayList.get(i)).second).jdField_a_of_type_JavaLangString);
      }
    }
    ((ActionSheet)localObject).setOnButtonClickListener(new MainFragment.5(this, localArrayList, (ActionSheet)localObject));
    ((ActionSheet)localObject).setOnDismissListener(new MainFragment.6(this));
    ((ActionSheet)localObject).setCanceledOnTouchOutside(true);
    this.jdField_b_of_type_AndroidAppDialog = ((Dialog)localObject);
    try
    {
      this.jdField_b_of_type_AndroidAppDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  public static MainFragment a()
  {
    MainFragment localMainFragment = new MainFragment();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("should_restore_from_kill", false);
    localMainFragment.setArguments(localBundle);
    return localMainFragment;
  }
  
  private void a(int paramInt, MainFragment.OverallMenuInfo paramOverallMenuInfo)
  {
    if (paramOverallMenuInfo == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("MainFragment", 2, paramOverallMenuInfo.jdField_a_of_type_JavaLangString + " is execute");
          }
          if (paramInt == 2131372655)
          {
            paramOverallMenuInfo = this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a();
            if ((paramOverallMenuInfo == null) || (paramOverallMenuInfo.a == null))
            {
              if (QLog.isColorLevel()) {
                QLog.w("MainFragment", 2, "mWrapper is null");
              }
              QQToast.a(this.jdField_a_of_type_MqqAppAppRuntime.getApp(), 0, HardCodeUtil.a(2131706433), 0).b(getResources().getDimensionPixelSize(2131299166));
            }
            for (;;)
            {
              ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X80041C1", "0X80041C1", 0, 0, "", "", "", "");
              return;
              if (paramOverallMenuInfo.a.iUpgradeType == 0) {
                QQToast.a(this.jdField_a_of_type_MqqAppAppRuntime.getApp(), 0, HardCodeUtil.a(2131706429), 0).b(getResources().getDimensionPixelSize(2131299166));
              } else if ((paramOverallMenuInfo != null) && (paramOverallMenuInfo.a != null)) {
                UpgradeDetailActivity.a(getActivity(), UpgradeController.a().a(), false, false, true);
              }
            }
          }
          if (paramInt != 2131372653) {
            break;
          }
          ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X80041C3", "0X80041C3", 0, 0, "", "", "", "");
        } while (PwdSetUtil.a(a(), getActivity()));
        f();
        return;
        if (paramInt == 2131372652)
        {
          e();
          return;
        }
      } while (paramOverallMenuInfo.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null);
      AboutConfig.a(a(), getActivity(), paramOverallMenuInfo.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo);
    } while (!"com.tencent.Feedback_5_8".equals(paramOverallMenuInfo.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName));
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X80041C2", "0X80041C2", 0, 0, "", "", "", "");
  }
  
  private void z()
  {
    FrameHelperActivity.c(true);
    if (DrawerFrame.a > 0)
    {
      if ((DrawerFrame.a == 3) && (QLog.isColorLevel())) {
        QLog.d("MainFragment", 2, String.format(Locale.getDefault(), "maybe back from campus notice cur tab: %d", new Object[] { Integer.valueOf(a()) }));
      }
      MqqHandler localMqqHandler = a().getHandler(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.removeMessages(1031);
      }
      x();
    }
  }
  
  public Dialog a(String paramString1, String paramString2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    ReportDialog localReportDialog = new ReportDialog(getActivity(), 2131755842);
    localReportDialog.setContentView(2131559216);
    TextView localTextView = (TextView)localReportDialog.findViewById(2131365811);
    if (localTextView != null)
    {
      if (paramString1 == null) {
        localTextView.setVisibility(8);
      }
    }
    else
    {
      paramString1 = (TextView)localReportDialog.findViewById(2131365807);
      if (paramString1 != null)
      {
        if (paramString2 != null) {
          break label149;
        }
        paramString1.setVisibility(8);
      }
    }
    for (;;)
    {
      paramString1 = (TextView)localReportDialog.findViewById(2131365796);
      if (paramString1 != null) {
        paramString1.setText(2131690800);
      }
      paramString1 = (TextView)localReportDialog.findViewById(2131365802);
      if (paramString1 != null) {
        paramString1.setText(2131694615);
      }
      localReportDialog.setOnDismissListener(paramOnDismissListener);
      return localReportDialog;
      localTextView.setVisibility(0);
      localTextView.setText(paramString1);
      break;
      label149:
      paramString1.setVisibility(0);
      paramString1.setText(paramString2);
    }
  }
  
  public QQAppInterface a()
  {
    return (QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime;
  }
  
  public String a()
  {
    if ((a() == FrameControllerUtil.a) && ((a() instanceof Conversation)) && (((Conversation)a()).a.a())) {
      return "QQSettingMe";
    }
    return c();
  }
  
  public void a()
  {
    if (getActivity() != null)
    {
      View localView = getActivity().findViewById(2131378373);
      if (localView != null)
      {
        ViewParent localViewParent = localView.getParent();
        if (localViewParent != null) {
          ((ViewGroup)localViewParent).removeView(localView);
        }
      }
    }
    SetSplash.a();
  }
  
  public void a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, RedTouchManager paramRedTouchManager)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch == null) && (this.jdField_a_of_type_AndroidWidgetImageView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(getActivity(), this.jdField_a_of_type_AndroidWidgetImageView).b(53).a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch != null) {
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.a(paramRedTypeInfo);
    }
    paramRedTouchManager.b(1, 30);
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "MainActivity:onLogout");
    }
    SharedPreUtils.a(this.jdField_a_of_type_MqqAppAppRuntime.getApp(), "");
    if (TroopAssistantManager.a().d()) {
      TroopAssistantManager.a().a(false);
    }
    TroopAssistantManager.a().d(a());
    LoadingStateManager.a().a(1);
    this.q = true;
    QIMNewFriend.a();
    UserguideActivity.a();
    ThreadManager.getUIHandler().post(new MainFragment.10(this));
    super.a(paramLogoutReason);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).setCurrentIntentParams(this);
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (paramInt == 82)
    {
      A();
      bool = true;
    }
    while (paramInt != 4) {
      return bool;
    }
    paramKeyEvent = a();
    if ((paramKeyEvent != null) && (paramKeyEvent.b())) {
      return true;
    }
    try
    {
      paramKeyEvent = (PendingIntent)getActivity().getIntent().getParcelableExtra("activity_finish_run_pendingIntent");
      if ((paramKeyEvent != null) && ((paramKeyEvent instanceof PendingIntent)) && (!getActivity().getIntent().getBooleanExtra("share_from_aio", false))) {
        if (QLog.isColorLevel()) {
          QLog.d("MainFragment", 2, "-->finish--send callback using PendingIntent");
        }
      }
      try
      {
        paramKeyEvent.send();
        getActivity().moveTaskToBack(true);
      }
      catch (PendingIntent.CanceledException paramKeyEvent)
      {
        for (;;)
        {
          QLog.e("MainFragment", 2, "failed to send PendingIntent", paramKeyEvent);
        }
      }
      return true;
    }
    catch (Throwable paramKeyEvent)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MainFragment", 2, "", paramKeyEvent);
      }
    }
  }
  
  public String b()
  {
    if (b()) {
      return getString(2131690601);
    }
    return super.b();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "onDrawComplete[" + ((ITabFrameController)QRoute.api(ITabFrameController.class)).getCurrentTabTag(this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost) + "]");
    }
    super.b();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "onAccountChanged");
    }
    jdField_e_of_type_Boolean = false;
    QQAppInterface localQQAppInterface = a();
    super.c();
    this.jdField_a_of_type_MqqAppAppRuntime = getActivity().app;
    com.tencent.mobileqq.app.FriendListHandler.getSpecialRecommendStat = -1;
    this.k = false;
    ThreadManager.post(new MainFragment.4(this), 2, null, true);
    if ((this.jdField_a_of_type_MqqAppAppRuntime != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a();
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "onAccountChange.check.new....");
      }
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_MqqAppAppRuntime.getAccount()))) {}
    }
    try
    {
      QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
      localQQNotificationManager.cancel("MainFragment", 241);
      localQQNotificationManager.cancel("MainFragment", 243);
      QZoneManagerImp localQZoneManagerImp = (QZoneManagerImp)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.QZONE_MANAGER);
      if (localQZoneManagerImp != null) {
        localQZoneManagerImp.a(1, 0);
      }
      localQQNotificationManager.cancel("MainFragment", 265);
      NotifyIdManager.a(a()).a();
      localQQNotificationManager.cancel("MainFragment", 267);
      localQQNotificationManager.cancel("MainFragment", 274);
      localQQNotificationManager.cancel("MainFragment", 236);
      localQQNotificationManager.cancel("MainFragment", 271);
      localQQNotificationManager.cancel("MainFragment", 273);
      localQQNotificationManager.cancel("MainFragment", 239);
      localQQNotificationManager.cancel("MainFragment", 527);
    }
    catch (Exception localException2)
    {
      label261:
      break label261;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.h();
    this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a(localQQAppInterface);
    if (this.jdField_a_of_type_MqqAppAppRuntime != null)
    {
      ((QIMNewFriendManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQIMNewFriendManager$IQIMNotifyNewFriendListener);
      this.jdField_a_of_type_MqqAppAppRuntime.registObserver(this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatObserver);
      this.jdField_a_of_type_MqqAppAppRuntime.registObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnBatteryChangeObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel.k();
    }
    for (;;)
    {
      if ((this.q) || ((this.jdField_a_of_type_MqqAppAppRuntime != null) && (this.jdField_a_of_type_ArrayOfAndroidViewView != null) && (this.jdField_a_of_type_JavaUtilHashMap != null))) {}
      try
      {
        ((ITabFrameController)QRoute.api(ITabFrameController.class)).setFrames(this, false);
        QIMNewFriend.a();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.d = false;
        }
        getActivity().getIntent().removeExtra("if_check_account_same");
        if (this.jdField_a_of_type_MqqAppAppRuntime != null) {
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_MqqAppAppRuntime.getAccount();
        }
        UserguideActivity.a();
        ThemeFontAdapter.a(true);
        return;
        this.q = false;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localException1.printStackTrace();
          QLog.d("MainFragment", 2, "onAccountChange setFrame has error : " + localException1);
        }
      }
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel.l();
    }
  }
  
  void e()
  {
    if ((this.jdField_b_of_type_AndroidAppDialog == null) || (this.jdField_b_of_type_AndroidAppDialog.isShowing())) {}
    try
    {
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
      label24:
      this.jdField_b_of_type_AndroidAppDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  void f()
  {
    g();
    Dialog localDialog = a("你确定退出QQ？", null, new MainFragment.7(this));
    Object localObject = (TextView)localDialog.findViewById(2131365802);
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new MainFragment.8(this, localDialog));
    }
    localObject = (TextView)localDialog.findViewById(2131365796);
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new MainFragment.9(this));
    }
    localObject = getString(2131718470);
    boolean bool = SettingCloneUtil.isContainValue(getActivity(), this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin(), (String)localObject, "qqsetting_receivemsg_whenexit_key");
    this.jdField_c_of_type_Boolean = SettingCloneUtil.readValue(getActivity(), this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin(), (String)localObject, "qqsetting_receivemsg_whenexit_key", true);
    localObject = (CheckBox)localDialog.findViewById(2131364710);
    if ((bool) && (this.jdField_c_of_type_Boolean)) {
      ((CheckBox)localObject).setVisibility(8);
    }
    ((CheckBox)localObject).setChecked(this.jdField_c_of_type_Boolean);
    this.jdField_a_of_type_AndroidAppDialog = localDialog;
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  void g()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog == null) || (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      label24:
      this.jdField_a_of_type_AndroidAppDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  public void h()
  {
    super.h();
  }
  
  public void i()
  {
    Object localObject = a(Conversation.class);
    if ((localObject != null) && (((Conversation)localObject).c()))
    {
      localObject = (VipGiftManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.VIP_GIF_MANAGER);
      if (localObject != null)
      {
        VipGiftDownloadInfo localVipGiftDownloadInfo = ((VipGiftManager)localObject).a();
        if ((localVipGiftDownloadInfo != null) && (isResumed()) && (localVipGiftDownloadInfo.d == 2L)) {
          ((VipGiftManager)localObject).a(localVipGiftDownloadInfo, getActivity());
        }
      }
    }
  }
  
  public void j() {}
  
  public void k()
  {
    if (a() == FrameControllerUtil.a)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DynimiIcon", 2, "onFragmentDrawerOpened");
      }
      ((ITabFrameController)QRoute.api(ITabFrameController.class)).revertTabIconChange(this);
    }
  }
  
  public void l()
  {
    if (a() == FrameControllerUtil.a)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FDynimiIcon", 2, "onFragmentDrawerOpened");
      }
      ((ITabFrameController)QRoute.api(ITabFrameController.class)).revertTabIconChange(this);
    }
  }
  
  public void m()
  {
    if (a() == FrameControllerUtil.a)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DynimiIcon", 2, "onFragmentDrawerOpened");
      }
      ((ITabFrameController)QRoute.api(ITabFrameController.class)).revertTabIconChange(this);
    }
    ThreadManager.getSubThreadHandler().post(new MainFragment.11(this));
  }
  
  public void onAttach(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "AutoMonitor_fragment MainFragment onAttach");
    }
    super.onAttach(paramActivity);
    this.jdField_a_of_type_MqqAppAppRuntime = getActivity().app;
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_MqqAppAppRuntime.getAccount();
    this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver = new MainAssistObserver((SplashActivity)getActivity());
  }
  
  public Animation onCreateAnimation(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramInt2 == 0) {
      return null;
    }
    Object localObject = (Animation)jdField_c_of_type_AndroidUtilSparseArray.get(paramInt2);
    if (localObject == null)
    {
      if (paramInt2 == 2130772062)
      {
        localObject = new MainEnterOutAni();
        ((Animation)localObject).setDuration(getActivity().getResources().getInteger(2131427330));
        ((Animation)localObject).setInterpolator(getActivity(), 17432580);
      }
      for (;;)
      {
        jdField_c_of_type_AndroidUtilSparseArray.put(paramInt2, localObject);
        return localObject;
        localObject = AnimationUtils.loadAnimation(getActivity(), paramInt2);
      }
    }
    ((Animation)localObject).reset();
    return localObject;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "AutoMonitor_fragment MainFragment onCreateView + rootView =  " + this.jdField_a_of_type_AndroidViewView);
    }
    if (this.jdField_a_of_type_AndroidViewView == null) {
      if (SetSplash.c())
      {
        paramViewGroup.postDelayed(new MainFragment.2(this), 3000L);
        paramViewGroup = (SplashActivity)getActivity();
        if (paramViewGroup.mPreloadMainViews == null) {
          break label159;
        }
        this.jdField_a_of_type_AndroidViewView = paramViewGroup.mPreloadMainViews[0];
        label89:
        paramLayoutInflater = new MainFragment.3(this);
        if (!StartService.jdField_a_of_type_Boolean) {
          break label203;
        }
        paramLayoutInflater.run();
      }
    }
    for (;;)
    {
      paramLayoutInflater = getActivity().getIntent();
      if (paramLayoutInflater != null) {
        this.jdField_b_of_type_Int = paramLayoutInflater.getIntExtra("current_tab_tag", -1);
      }
      SubscribeAdDeviceInfoHelper.a().a();
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      a();
      break;
      label159:
      this.jdField_a_of_type_AndroidViewView = super.onCreateView(paramLayoutInflater, null, paramBundle);
      break label89;
      if (this.jdField_a_of_type_AndroidViewView.getParent() == null) {
        break label89;
      }
      ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.jdField_a_of_type_AndroidViewView);
      break label89;
      label203:
      ThreadManager.getSubThreadHandler().postDelayed(paramLayoutInflater, 2000L);
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "AutoMonitor_fragment MainFragment onDestroy");
    }
    super.onDestroy();
    jdField_c_of_type_AndroidUtilSparseArray.clear();
    if ((this.jdField_a_of_type_MqqAppAppRuntime != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver != null))
    {
      if (!this.p)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.b();
        this.p = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.d();
    }
    if (this.jdField_a_of_type_MqqAppAppRuntime != null)
    {
      ((QIMNewFriendManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER)).a();
      this.jdField_a_of_type_MqqAppAppRuntime.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatObserver);
      this.jdField_a_of_type_MqqAppAppRuntime.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnBatteryChangeObserver);
    }
    ScreenCapture.clearSnapCacheFile(getActivity());
    if (getActivity().isFinishing()) {}
    try
    {
      ((IUniformDownloadMgr)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IUniformDownloadMgr.class, "")).onQQProcessExit();
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "MainActivity.onDestory");
      }
      if (DownloadManager.a()) {
        DownloadManager.a().e();
      }
      TMAssistantDownloadManager.closeAllService(BaseApplication.getContext());
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Intent localIntent;
        localThrowable.printStackTrace();
        continue;
        boolean bool = false;
        continue;
        if (SettingCloneUtil.readValue(this.jdField_a_of_type_MqqAppAppRuntime.getApplication(), this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), null, "pcactive_config", false))
        {
          this.jdField_a_of_type_MqqAppAppRuntime.startPCActivePolling(this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), "exitApp");
          a().exit(true);
        }
        else
        {
          a().exit(false);
        }
      }
    }
    if (!jdField_b_of_type_Boolean)
    {
      bool = true;
      jdField_a_of_type_Boolean = bool;
      jdField_b_of_type_Boolean = false;
      if (this.jdField_a_of_type_MqqAppAppRuntime != null)
      {
        this.jdField_a_of_type_MqqAppAppRuntime.isClearTaskBySystem = jdField_a_of_type_Boolean;
        if (!jdField_a_of_type_Boolean) {
          break label301;
        }
        this.jdField_a_of_type_MqqAppAppRuntime.isBackgroundStop = true;
        localIntent = new Intent("mqq.intent.action.EXIT" + getActivity().getPackageName());
        getActivity().sendBroadcast(localIntent);
      }
      o();
      QzoneConfig.getInstance().removeListener(QCircleInjectImpl.a(this));
    }
  }
  
  public void onDestroyView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "AutoMonitor_fragment MainFragment onDestroyView");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.b();
    if (this.jdField_a_of_type_MqqAppAppRuntime != null)
    {
      ((QIMNewFriendManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER)).a();
      this.jdField_a_of_type_MqqAppAppRuntime.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatObserver);
      this.jdField_a_of_type_MqqAppAppRuntime.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnBatteryChangeObserver);
    }
    this.p = true;
    super.onDestroyView();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    QLog.d("MainFragment", 1, "onHiddenChanged" + paramBoolean);
    if (paramBoolean)
    {
      this.l = true;
      onPause();
      onStop();
      this.l = false;
    }
    for (;;)
    {
      super.onHiddenChanged(paramBoolean);
      return;
      if (Build.VERSION.SDK_INT < 18) {
        this.jdField_a_of_type_AndroidViewView.requestFocus();
      }
      if (getActivity().getIntent().getBooleanExtra("isFromAioFragment", false))
      {
        onStart();
        onResume();
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if ((SplashActivity.currentFragment != 1) && (!this.l))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "onPause return");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "AutoMonitor_fragment MainFragment onPause");
    }
    if ((this.jdField_c_of_type_Long != 0L) && (this.jdField_e_of_type_JavaLangString != null) && (UnifiedMonitor.a().whetherReportThisTime(8))) {
      UnifiedMonitor.a().addEvent(8, this.jdField_e_of_type_JavaLangString, (int)(SystemClock.uptimeMillis() - this.jdField_c_of_type_Long), 0, null);
    }
    this.jdField_c_of_type_Long = 0L;
    e();
    com.tencent.mobileqq.activity.recent.RecentUtil.jdField_b_of_type_Boolean = false;
    if (DrawerFrame.a == 2) {
      x();
    }
    FrameHelperActivity.c(false);
    LebaTabRedTouch.c();
    n();
  }
  
  public void onResume()
  {
    super.onResume();
    if (SplashActivity.currentFragment != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "onResume return");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "AutoMonitor_fragment MainFragment onResume");
    }
    StartupTracker.a(null, "Main_OnResume");
    this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    z();
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).setFrames(this, false);
    if (GuardManager.a != null) {
      GuardManager.a.b(6, null);
    }
    com.tencent.mobileqq.activity.recent.RecentUtil.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_AndroidContentIntent != null)
    {
      localObject = this.jdField_a_of_type_AndroidContentIntent;
      this.jdField_a_of_type_AndroidContentIntent = null;
      ((SplashActivity)getActivity()).openMainFragment((Intent)localObject);
    }
    p();
    this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.h();
    StartupTracker.a("Main_OnResume", null);
    Object localObject = (TroopRedTouchHandler)a().getBusinessHandler(BusinessHandlerFactory.GET_RED_POINT_EX_HANDLER);
    if ((localObject != null) && (((TroopRedTouchHandler)localObject).a()) && (QLog.isColorLevel())) {
      QLog.d("Q.qqstory.redPoint", 2, "MainFragment onResume, getRedPointInfo");
    }
    ReadinjoySPEventReport.j();
    if (SplashActivity.sExitAIOCode != 0)
    {
      HardCoderManager.a().a(SplashActivity.sExitAIOCode);
      SplashActivity.sExitAIOCode = 0;
    }
    if (SplashActivity.sExitAIOTime != 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOExit", 2, "exit aio cost = " + (SystemClock.uptimeMillis() - SplashActivity.sExitAIOTime));
      }
      SplashActivity.sExitAIOTime = 0L;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null) && (!this.i)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
    }
    if (this.jdField_b_of_type_Int != -1)
    {
      a(this.jdField_b_of_type_Int);
      this.jdField_b_of_type_Int = -1;
    }
    jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.b(getActivity().getIntent());
    ForwardDialogMgr.a(getActivity(), getActivity().getIntent());
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).onResumeAfter(this);
  }
  
  public void onStart()
  {
    super.onStart();
    if (SplashActivity.currentFragment != 1) {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "onStart return");
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "onStart");
      }
      if ((this.f != null) && (this.f.length() > 0) && ("pakage_from_h5".equalsIgnoreCase(this.g)))
      {
        JumpAction localJumpAction = JumpParser.a(a(), getActivity(), this.f);
        localJumpAction.c(this.g);
        localJumpAction.a();
        this.f = null;
        this.g = null;
      }
      if (!a().mAutomator.b()) {
        RIJInjectImpl.a(a(), this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_ArrayOfAndroidViewView);
      }
      ((AppGuideTipsManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.APP_GUIDE_TIPS_MANAGER)).e();
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a(getActivity().getIntent());
  }
  
  public void onStop()
  {
    super.onStop();
    if ((SplashActivity.currentFragment != 1) && (!this.l))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "onStop return");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "AutoMonitor_fragment MainFragment onStop");
    }
    if (DrawerFrame.a > 0) {
      x();
    }
    KandianAppInPush.a().a(false);
  }
  
  public void onTabChanged(String paramString)
  {
    if ((this.jdField_c_of_type_Long != 0L) && (this.jdField_e_of_type_JavaLangString != null) && (UnifiedMonitor.a().whetherReportThisTime(8))) {
      UnifiedMonitor.a().addEvent(8, this.jdField_e_of_type_JavaLangString, (int)(SystemClock.uptimeMillis() - this.jdField_c_of_type_Long), 0, null);
    }
    if (this.jdField_e_of_type_JavaLangString != null) {
      SceneTracker.a().b(this.jdField_e_of_type_JavaLangString);
    }
    SceneTracker.a().a(this.jdField_e_of_type_JavaLangString);
    this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      e(false);
    }
    super.onTabChanged(paramString);
    com.tencent.mobileqq.activity.recent.RecentUtil.jdField_b_of_type_Boolean = true;
    if ((RIJXTabFrameUtils.a.a(this.jdField_e_of_type_JavaLangString)) || (QzoneFrame.class.getName().equals(this.jdField_e_of_type_JavaLangString)) || (QCircleFrame.class.getName().equals(this.jdField_e_of_type_JavaLangString)))
    {
      b(8);
      return;
    }
    b(0);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "onViewCreated");
    }
    super.onViewCreated(paramView, paramBundle);
    if (this.jdField_a_of_type_ArrayOfAndroidViewView == null)
    {
      ((ITabFrameController)QRoute.api(ITabFrameController.class)).initTabs(this, this.jdField_a_of_type_AndroidViewView);
      ((ITabFrameController)QRoute.api(ITabFrameController.class)).setFrames(this, true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.setOnDrawCompleteListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.MainFragment
 * JD-Core Version:    0.7.0.1
 */