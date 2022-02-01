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
import com.tencent.biz.subscribe.utils.SubscribeAdDeviceInfoHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mm.hardcoder.HardCoderManager;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AppGuideTipsManager;
import com.tencent.mobileqq.activity.aio.anim.MainEnterOutAni;
import com.tencent.mobileqq.activity.fling.ScreenCapture;
import com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.activity.main.LebaTabRedTouch;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.activity.qcircle.QCircleFrame;
import com.tencent.mobileqq.activity.qcircle.QCircleThirdTabConfig;
import com.tencent.mobileqq.activity.qcircle.QCircleThirdTabConfig.INotifyTabRefresh;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.recent.cur.TabDragListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QIMNewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.qim.QIMNewFriend;
import com.tencent.mobileqq.config.AboutConfig;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.forward.ForwardDialogMgr;
import com.tencent.mobileqq.kandian.biz.common.api.IRIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport;
import com.tencent.mobileqq.kandian.biz.tab.api.IRIJTabInject;
import com.tencent.mobileqq.kandian.repo.tab.KandianFrameStatus;
import com.tencent.mobileqq.login.PwdSetUtil;
import com.tencent.mobileqq.managers.LoadingStateManager;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.onlinestatus.IAccountPanel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.startup.step.SetSplash;
import com.tencent.mobileqq.startup.step.StartService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
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
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
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
  public static boolean a = false;
  public static boolean b = false;
  private static SparseArray<Animation> jdField_c_of_type_AndroidUtilSparseArray = new SparseArray(2);
  Dialog a;
  public MainAssistObserver a;
  public QCircleThirdTabConfig.INotifyTabRefresh a;
  public TabDragListener a;
  public KandianFrameStatus a;
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
  
  public MainFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoTabKandianFrameStatus = new KandianFrameStatus();
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurTabDragListener = new TabDragListener(null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabWidget$onTabWidgetTouchMoveListener = new MainFragment.1(this);
  }
  
  private void A()
  {
    FrameHelperActivity.b(true);
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
  
  private void B()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "showActionSheet");
    }
    e();
    ArrayList localArrayList = new ArrayList();
    Object localObject = new MainFragment.OverallMenuInfo();
    ((MainFragment.OverallMenuInfo)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131720192);
    localArrayList.add(new Pair(Integer.valueOf(2131372233), localObject));
    localObject = a().getAboutConfig().a("com.tencent.Feedback_5_8");
    if ((localObject != null) && (((ResourcePluginInfo)localObject).cLocalState != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "feedback plugin is add overmenu");
      }
      MainFragment.OverallMenuInfo localOverallMenuInfo = new MainFragment.OverallMenuInfo();
      localOverallMenuInfo.jdField_a_of_type_JavaLangString = ((ResourcePluginInfo)localObject).strResName;
      localOverallMenuInfo.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo = ((ResourcePluginInfo)localObject);
      localArrayList.add(new Pair(Integer.valueOf(2131372232), localOverallMenuInfo));
    }
    localObject = new MainFragment.OverallMenuInfo();
    ((MainFragment.OverallMenuInfo)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131693902);
    localArrayList.add(new Pair(Integer.valueOf(2131372231), localObject));
    localObject = new MainFragment.OverallMenuInfo();
    ((MainFragment.OverallMenuInfo)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131690707);
    localArrayList.add(new Pair(Integer.valueOf(2131372230), localObject));
    localObject = ActionSheet.createMenuSheet(a());
    int i = 0;
    while (i < localArrayList.size())
    {
      if (2131372230 == ((Integer)((Pair)localArrayList.get(i)).first).intValue()) {
        ((ActionSheet)localObject).addCancelButton(((MainFragment.OverallMenuInfo)((Pair)localArrayList.get(i)).second).jdField_a_of_type_JavaLangString);
      } else {
        ((ActionSheet)localObject).addButton(((MainFragment.OverallMenuInfo)((Pair)localArrayList.get(i)).second).jdField_a_of_type_JavaLangString);
      }
      i += 1;
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
    if (paramOverallMenuInfo == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramOverallMenuInfo.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" is execute");
      QLog.d("MainFragment", 2, localStringBuilder.toString());
    }
    if (paramInt == 2131372233)
    {
      paramOverallMenuInfo = this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a();
      if ((paramOverallMenuInfo != null) && (paramOverallMenuInfo.a != null))
      {
        if (paramOverallMenuInfo.a.iUpgradeType == 0) {
          QQToast.a(this.jdField_a_of_type_MqqAppAppRuntime.getApp(), 0, HardCodeUtil.a(2131706476), 0).b(getResources().getDimensionPixelSize(2131299168));
        } else if ((paramOverallMenuInfo != null) && (paramOverallMenuInfo.a != null)) {
          UpgradeDetailActivity.a(a(), UpgradeController.a().a(), false, false, true);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.w("MainFragment", 2, "mWrapper is null");
        }
        QQToast.a(this.jdField_a_of_type_MqqAppAppRuntime.getApp(), 0, HardCodeUtil.a(2131706480), 0).b(getResources().getDimensionPixelSize(2131299168));
      }
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X80041C1", "0X80041C1", 0, 0, "", "", "", "");
      return;
    }
    if (paramInt == 2131372231)
    {
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X80041C3", "0X80041C3", 0, 0, "", "", "", "");
      if (PwdSetUtil.a(a(), a())) {
        return;
      }
      f();
      return;
    }
    if (paramInt == 2131372230)
    {
      e();
      return;
    }
    if (paramOverallMenuInfo.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null)
    {
      AboutConfig.a(a(), a(), paramOverallMenuInfo.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo);
      if ("com.tencent.Feedback_5_8".equals(paramOverallMenuInfo.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName)) {
        ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X80041C2", "0X80041C2", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void z()
  {
    this.jdField_a_of_type_MqqAppAppRuntime = a().getAppRuntime();
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_MqqAppAppRuntime.getAccount();
    this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver = new MainAssistObserver((SplashActivity)a());
    QCircleInjectImpl.a(this);
  }
  
  public Dialog a(String paramString1, String paramString2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    ReportDialog localReportDialog = new ReportDialog(a(), 2131756189);
    localReportDialog.setContentView(2131559094);
    TextView localTextView = (TextView)localReportDialog.findViewById(2131365648);
    if (localTextView != null) {
      if (paramString1 == null)
      {
        localTextView.setVisibility(8);
      }
      else
      {
        localTextView.setVisibility(0);
        localTextView.setText(paramString1);
      }
    }
    paramString1 = (TextView)localReportDialog.findViewById(2131365644);
    if (paramString1 != null) {
      if (paramString2 == null)
      {
        paramString1.setVisibility(8);
      }
      else
      {
        paramString1.setVisibility(0);
        paramString1.setText(paramString2);
      }
    }
    paramString1 = (TextView)localReportDialog.findViewById(2131365633);
    if (paramString1 != null) {
      paramString1.setText(2131690728);
    }
    paramString1 = (TextView)localReportDialog.findViewById(2131365639);
    if (paramString1 != null) {
      paramString1.setText(2131694583);
    }
    localReportDialog.setOnDismissListener(paramOnDismissListener);
    return localReportDialog;
  }
  
  public QQAppInterface a()
  {
    return (QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime;
  }
  
  public String a()
  {
    if ((a() == FrameControllerUtil.a) && ((a() instanceof Conversation)))
    {
      QQSettingMe localQQSettingMe = ((Conversation)a()).a;
      if (QQSettingMe.a()) {
        return "QQSettingMe";
      }
    }
    return c();
  }
  
  public void a()
  {
    if (a() != null)
    {
      View localView = a().findViewById(2131377782);
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
  
  protected void a(int paramInt1, int paramInt2)
  {
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).onFragmentDrawerClosed(this, paramInt1, paramInt2);
  }
  
  public void a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, IRedTouchManager paramIRedTouchManager)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch == null) && (this.jdField_a_of_type_AndroidWidgetImageView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(a(), this.jdField_a_of_type_AndroidWidgetImageView).b(53).a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch != null) {
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.a(paramRedTypeInfo);
    }
    paramIRedTouchManager.reportLevelZeroRedInfo(1, 30);
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
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 82)
    {
      B();
      return true;
    }
    if (paramInt == 4)
    {
      paramKeyEvent = a();
      if ((paramKeyEvent != null) && (paramKeyEvent.a())) {
        return true;
      }
      try
      {
        paramKeyEvent = (PendingIntent)a().getIntent().getParcelableExtra("activity_finish_run_pendingIntent");
        if ((paramKeyEvent != null) && ((paramKeyEvent instanceof PendingIntent)) && (!a().getIntent().getBooleanExtra("share_from_aio", false)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MainFragment", 2, "-->finish--send callback using PendingIntent");
          }
          try
          {
            paramKeyEvent.send();
          }
          catch (PendingIntent.CanceledException paramKeyEvent)
          {
            QLog.e("MainFragment", 2, "failed to send PendingIntent", paramKeyEvent);
          }
        }
        a().moveTaskToBack(true);
        return true;
      }
      catch (Throwable paramKeyEvent)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MainFragment", 2, "", paramKeyEvent);
        }
        return true;
      }
    }
    return false;
  }
  
  public String b()
  {
    if (b()) {
      return getString(2131690529);
    }
    return super.b();
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDrawComplete[");
      localStringBuilder.append(((ITabFrameController)QRoute.api(ITabFrameController.class)).getCurrentTabTag(this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost));
      localStringBuilder.append("]");
      QLog.d("MainFragment", 2, localStringBuilder.toString());
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
    this.jdField_a_of_type_MqqAppAppRuntime = a().getAppRuntime();
    com.tencent.mobileqq.app.FriendListHandler.getSpecialRecommendStat = -1;
    this.k = false;
    ThreadManager.post(new MainFragment.4(this), 2, null, true);
    Object localObject;
    if (this.jdField_a_of_type_MqqAppAppRuntime != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver;
      if (localObject != null)
      {
        ((MainAssistObserver)localObject).jdField_a_of_type_Boolean = false;
        ((MainAssistObserver)localObject).a();
        if (QLog.isColorLevel()) {
          QLog.d("MainFragment", 2, "onAccountChange.check.new....");
        }
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_MqqAppAppRuntime.getAccount()))) {}
      }
    }
    try
    {
      localObject = QQNotificationManager.getInstance();
      ((QQNotificationManager)localObject).cancel("MainFragment", 241);
      ((QQNotificationManager)localObject).cancel("MainFragment", 243);
      QZoneManagerImp localQZoneManagerImp = (QZoneManagerImp)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.QZONE_MANAGER);
      if (localQZoneManagerImp != null) {
        localQZoneManagerImp.a(1, 0);
      }
      ((QQNotificationManager)localObject).cancel("MainFragment", 265);
      NotifyIdManager.a(a()).a();
      ((QQNotificationManager)localObject).cancel("MainFragment", 267);
      ((QQNotificationManager)localObject).cancel("MainFragment", 274);
      ((QQNotificationManager)localObject).cancel("MainFragment", 236);
      ((QQNotificationManager)localObject).cancel("MainFragment", 271);
      ((QQNotificationManager)localObject).cancel("MainFragment", 273);
      ((QQNotificationManager)localObject).cancel("MainFragment", 239);
      ((QQNotificationManager)localObject).cancel("MainFragment", 527);
    }
    catch (Exception localException2)
    {
      label257:
      MainAssistObserver localMainAssistObserver;
      break label257;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.h();
    this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a(localQQAppInterface);
    if (this.jdField_a_of_type_MqqAppAppRuntime != null)
    {
      ((QIMNewFriendManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQIMNewFriendManager$IQIMNotifyNewFriendListener);
      this.jdField_a_of_type_MqqAppAppRuntime.registObserver(this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatObserver);
      this.jdField_a_of_type_MqqAppAppRuntime.registObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnBatteryChangeObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel.i();
    }
    if (this.q) {
      this.q = false;
    }
    if ((this.jdField_a_of_type_MqqAppAppRuntime != null) && (this.jdField_a_of_type_ArrayOfAndroidViewView != null) && (this.jdField_a_of_type_JavaUtilHashMap != null)) {
      try
      {
        ((ITabFrameController)QRoute.api(ITabFrameController.class)).setFrames(this, false);
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onAccountChange setFrame has error : ");
        ((StringBuilder)localObject).append(localException1);
        QLog.d("MainFragment", 2, ((StringBuilder)localObject).toString());
      }
    }
    QIMNewFriend.a();
    localMainAssistObserver = this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver;
    if (localMainAssistObserver != null) {
      localMainAssistObserver.d = false;
    }
    a().getIntent().removeExtra("if_check_account_same");
    if (this.jdField_a_of_type_MqqAppAppRuntime != null) {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_MqqAppAppRuntime.getAccount();
    }
    UserguideActivity.a();
    ThemeFontAdapter.a(true);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusIAccountPanel.j();
    }
  }
  
  void e()
  {
    Dialog localDialog = this.jdField_b_of_type_AndroidAppDialog;
    if ((localDialog == null) || (localDialog.isShowing())) {}
    try
    {
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
      label23:
      this.jdField_b_of_type_AndroidAppDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label23;
    }
  }
  
  void f()
  {
    g();
    Dialog localDialog = a("你确定退出QQ？", null, new MainFragment.7(this));
    Object localObject = (TextView)localDialog.findViewById(2131365639);
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new MainFragment.8(this, localDialog));
    }
    localObject = (TextView)localDialog.findViewById(2131365633);
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new MainFragment.9(this));
    }
    localObject = getString(2131718135);
    boolean bool = SettingCloneUtil.isContainValue(a(), this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin(), (String)localObject, "qqsetting_receivemsg_whenexit_key");
    this.jdField_c_of_type_Boolean = SettingCloneUtil.readValue(a(), this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin(), (String)localObject, "qqsetting_receivemsg_whenexit_key", true);
    localObject = (CheckBox)localDialog.findViewById(2131364597);
    if ((bool) && (this.jdField_c_of_type_Boolean)) {
      ((CheckBox)localObject).setVisibility(8);
    }
    ((CheckBox)localObject).setChecked(this.jdField_c_of_type_Boolean);
    this.jdField_a_of_type_AndroidAppDialog = localDialog;
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  void g()
  {
    Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
    if ((localDialog == null) || (localDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      label23:
      this.jdField_a_of_type_AndroidAppDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label23;
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
          ((VipGiftManager)localObject).a(localVipGiftDownloadInfo, (BaseActivity)a());
        }
      }
    }
  }
  
  public void j() {}
  
  protected void k()
  {
    if (a() == FrameControllerUtil.a)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DynimiIcon", 2, "onFragmentDrawerOpened");
      }
      ((ITabFrameController)QRoute.api(ITabFrameController.class)).revertTabIconChange(this);
    }
  }
  
  protected void l()
  {
    if (a() == FrameControllerUtil.a)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FDynimiIcon", 2, "onFragmentDrawerOpened");
      }
      ((ITabFrameController)QRoute.api(ITabFrameController.class)).revertTabIconChange(this);
    }
  }
  
  protected void m()
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
  }
  
  public Animation onCreateAnimation(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramInt2 == 0) {
      return null;
    }
    Object localObject = (Animation)jdField_c_of_type_AndroidUtilSparseArray.get(paramInt2);
    if (localObject == null)
    {
      if (paramInt2 == 2130772084)
      {
        localObject = new MainEnterOutAni();
        ((Animation)localObject).setDuration(a().getResources().getInteger(2131427333));
        ((Animation)localObject).setInterpolator(a(), 17432580);
      }
      else
      {
        localObject = AnimationUtils.loadAnimation(a(), paramInt2);
      }
      jdField_c_of_type_AndroidUtilSparseArray.put(paramInt2, localObject);
      return localObject;
    }
    ((Animation)localObject).reset();
    return localObject;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AutoMonitor_fragment MainFragment onCreateView + rootView =  ");
      localStringBuilder.append(this.jdField_a_of_type_AndroidViewView);
      QLog.d("MainFragment", 2, localStringBuilder.toString());
    }
    z();
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      if (SetSplash.c()) {
        paramViewGroup.postDelayed(new MainFragment.2(this), 3000L);
      } else {
        a();
      }
      paramViewGroup = (SplashActivity)a();
      if (paramViewGroup.mPreloadMainViews != null) {
        this.jdField_a_of_type_AndroidViewView = paramViewGroup.mPreloadMainViews[0];
      } else {
        this.jdField_a_of_type_AndroidViewView = super.onCreateView(paramLayoutInflater, null, paramBundle);
      }
    }
    else if (this.jdField_a_of_type_AndroidViewView.getParent() != null)
    {
      ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.jdField_a_of_type_AndroidViewView);
    }
    paramLayoutInflater = new MainFragment.3(this);
    if (StartService.jdField_a_of_type_Boolean) {
      paramLayoutInflater.run();
    } else {
      ThreadManager.getSubThreadHandler().postDelayed(paramLayoutInflater, 2000L);
    }
    paramLayoutInflater = a().getIntent();
    if (paramLayoutInflater != null) {
      this.jdField_b_of_type_Int = paramLayoutInflater.getIntExtra("current_tab_tag", -1);
    }
    SubscribeAdDeviceInfoHelper.a().a();
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "AutoMonitor_fragment MainFragment onDestroy");
    }
    super.onDestroy();
    jdField_c_of_type_AndroidUtilSparseArray.clear();
    if (this.jdField_a_of_type_MqqAppAppRuntime != null)
    {
      MainAssistObserver localMainAssistObserver = this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver;
      if (localMainAssistObserver != null)
      {
        if (!this.p)
        {
          localMainAssistObserver.b();
          this.p = true;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.d();
      }
    }
    if (this.jdField_a_of_type_MqqAppAppRuntime != null)
    {
      ((QIMNewFriendManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER)).a();
      this.jdField_a_of_type_MqqAppAppRuntime.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatObserver);
      this.jdField_a_of_type_MqqAppAppRuntime.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnBatteryChangeObserver);
    }
    ScreenCapture.clearSnapCacheFile(a());
    if (a().isFinishing())
    {
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
        localThrowable.printStackTrace();
      }
      jdField_a_of_type_Boolean = jdField_b_of_type_Boolean ^ true;
      jdField_b_of_type_Boolean = false;
      if (this.jdField_a_of_type_MqqAppAppRuntime != null)
      {
        Object localObject = this.jdField_a_of_type_MqqAppAppRuntime;
        boolean bool = jdField_a_of_type_Boolean;
        ((AppRuntime)localObject).isClearTaskBySystem = bool;
        if (bool)
        {
          this.jdField_a_of_type_MqqAppAppRuntime.isBackgroundStop = true;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("mqq.intent.action.EXIT");
          ((StringBuilder)localObject).append(a().getPackageName());
          localObject = new Intent(((StringBuilder)localObject).toString());
          a().sendBroadcast((Intent)localObject);
        }
        else if (SettingCloneUtil.readValue(this.jdField_a_of_type_MqqAppAppRuntime.getApplication(), this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), null, "pcactive_config", false))
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
    o();
    QCircleThirdTabConfig.a().a();
    QzoneConfig.getInstance().removeListener(QCircleInjectImpl.a(this));
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
    StringBuilder localStringBuilder = AIOUtils.a();
    localStringBuilder.append("onHiddenChanged");
    localStringBuilder.append(paramBoolean);
    QLog.d("MainFragment", 1, localStringBuilder.toString());
    if (paramBoolean)
    {
      this.l = true;
      onPause();
      onStop();
      this.l = false;
    }
    else
    {
      if (Build.VERSION.SDK_INT < 18) {
        this.jdField_a_of_type_AndroidViewView.requestFocus();
      }
      if (a().getIntent().getBooleanExtra("isFromAioFragment", false))
      {
        onStart();
        onResume();
      }
    }
    super.onHiddenChanged(paramBoolean);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).setCurrentIntentParams(this);
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
    FrameHelperActivity.b(false);
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
    A();
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).setFrames(this, false);
    if (GuardManager.a != null) {
      GuardManager.a.b(6, null);
    }
    com.tencent.mobileqq.activity.recent.RecentUtil.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_AndroidContentIntent != null)
    {
      localObject = this.jdField_a_of_type_AndroidContentIntent;
      this.jdField_a_of_type_AndroidContentIntent = null;
      ((SplashActivity)a()).openMainFragment((Intent)localObject);
    }
    p();
    this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.h();
    StartupTracker.a("Main_OnResume", null);
    Object localObject = (TroopRedTouchHandler)a().getBusinessHandler(BusinessHandlerFactory.GET_RED_POINT_EX_HANDLER);
    if ((localObject != null) && (((TroopRedTouchHandler)localObject).a()) && (QLog.isColorLevel())) {
      QLog.d("Q.qqstory.redPoint", 2, "MainFragment onResume, getRedPointInfo");
    }
    ((IReadInJoySPEventReport)QRoute.api(IReadInJoySPEventReport.class)).reportTabExposure();
    if (SplashActivity.sExitAIOCode != 0)
    {
      HardCoderManager.a().a(SplashActivity.sExitAIOCode);
      SplashActivity.sExitAIOCode = 0;
    }
    if (SplashActivity.sExitAIOTime != 0L)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("exit aio cost = ");
        ((StringBuilder)localObject).append(SystemClock.uptimeMillis() - SplashActivity.sExitAIOTime);
        QLog.d("AIOExit", 2, ((StringBuilder)localObject).toString());
      }
      SplashActivity.sExitAIOTime = 0L;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null) && (!this.i)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
    }
    int i = this.jdField_b_of_type_Int;
    if (i != -1)
    {
      a(i);
      this.jdField_b_of_type_Int = -1;
    }
    jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.b(a().getIntent());
    ForwardDialogMgr.a(a(), a().getIntent());
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).onResumeAfter(this);
  }
  
  public void onStart()
  {
    super.onStart();
    if (SplashActivity.currentFragment != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "onStart return");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "onStart");
    }
    Object localObject = this.f;
    if ((localObject != null) && (((String)localObject).length() > 0) && ("pakage_from_h5".equalsIgnoreCase(this.g)))
    {
      localObject = JumpParser.a(a(), a(), this.f);
      ((JumpAction)localObject).c(this.g);
      ((JumpAction)localObject).a();
      this.f = null;
      this.g = null;
    }
    if (!a().mAutomator.b()) {
      ((IRIJTabInject)QRoute.api(IRIJTabInject.class)).kanDianTabExposure(this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_ArrayOfAndroidViewView);
    }
    ((AppGuideTipsManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.APP_GUIDE_TIPS_MANAGER)).e();
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver;
    if (localObject != null) {
      ((MainAssistObserver)localObject).a(a().getIntent());
    }
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
      d(false);
    }
    super.onTabChanged(paramString);
    com.tencent.mobileqq.activity.recent.RecentUtil.jdField_b_of_type_Boolean = true;
    if ((!((IRIJXTabFrameUtils)QRoute.api(IRIJXTabFrameUtils.class)).isKandianTabFrame(this.jdField_e_of_type_JavaLangString)) && (!QzoneFrame.class.getName().equals(this.jdField_e_of_type_JavaLangString)) && (!QCircleFrame.class.getName().equals(this.jdField_e_of_type_JavaLangString)))
    {
      b(0);
      return;
    }
    b(8);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.MainFragment
 * JD-Core Version:    0.7.0.1
 */