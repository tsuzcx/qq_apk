package com.tencent.mobileqq.activity.home;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Context;
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
import com.tencent.mobileqq.activity.flashshow.FlashShowFrame;
import com.tencent.mobileqq.activity.fling.ScreenCapture;
import com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabUIHelper;
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
import com.tencent.mobileqq.app.FrameFragment;
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
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport;
import com.tencent.mobileqq.kandian.biz.tab.api.IRIJTabInject;
import com.tencent.mobileqq.kandian.biz.xtab.api.IRIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.repo.tab.KandianFrameStatus;
import com.tencent.mobileqq.logic.TabDataObserver;
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
  private static SparseArray<Animation> aC = new SparseArray(2);
  public static boolean b = false;
  private int aA = -1;
  private Dialog aB;
  private long av = 0L;
  private String aw = null;
  private String ax = null;
  private boolean ay = true;
  private boolean az = false;
  public String c;
  public QCircleThirdTabConfig.INotifyTabRefresh d;
  public MainAssistObserver e;
  public KandianFrameStatus f = new KandianFrameStatus();
  public TabDragListener g = new TabDragListener(null);
  public QQTabWidget.onTabWidgetTouchMoveListener h = new MainFragment.1(this);
  public QzoneConfig.QzoneConfigChangeListener i;
  public TabDataObserver j = new MainFragment.2(this);
  Dialog k;
  boolean l = true;
  
  private void L()
  {
    this.A = C().getAppRuntime();
    this.c = this.A.getAccount();
    this.e = new MainAssistObserver((SplashActivity)C());
    QCircleInjectImpl.a(this);
    QLog.i("MainFragment", 1, "init: addObserver");
    ((QQAppInterface)this.A).addObserver(this.j);
  }
  
  private void M()
  {
    FrameHelperActivity.c(true);
    if (DrawerFrame.b > 0)
    {
      if ((DrawerFrame.b == 3) && (QLog.isColorLevel())) {
        QLog.d("MainFragment", 2, String.format(Locale.getDefault(), "maybe back from campus notice cur tab: %d", new Object[] { Integer.valueOf(w()) }));
      }
      MqqHandler localMqqHandler = c().getHandler(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.removeMessages(1031);
      }
      I();
    }
  }
  
  private void N()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "showActionSheet");
    }
    h();
    ArrayList localArrayList = new ArrayList();
    Object localObject = new MainFragment.OverallMenuInfo();
    ((MainFragment.OverallMenuInfo)localObject).a = getResources().getString(2131917822);
    localArrayList.add(new Pair(Integer.valueOf(2131439738), localObject));
    localObject = c().getAboutConfig().a("com.tencent.Feedback_5_8");
    if ((localObject != null) && (((ResourcePluginInfo)localObject).cLocalState != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "feedback plugin is add overmenu");
      }
      MainFragment.OverallMenuInfo localOverallMenuInfo = new MainFragment.OverallMenuInfo();
      localOverallMenuInfo.a = ((ResourcePluginInfo)localObject).strResName;
      localOverallMenuInfo.b = ((ResourcePluginInfo)localObject);
      localArrayList.add(new Pair(Integer.valueOf(2131439737), localOverallMenuInfo));
    }
    localObject = new MainFragment.OverallMenuInfo();
    ((MainFragment.OverallMenuInfo)localObject).a = getResources().getString(2131891526);
    localArrayList.add(new Pair(Integer.valueOf(2131439736), localObject));
    localObject = new MainFragment.OverallMenuInfo();
    ((MainFragment.OverallMenuInfo)localObject).a = getResources().getString(2131887626);
    localArrayList.add(new Pair(Integer.valueOf(2131439735), localObject));
    localObject = ActionSheet.createMenuSheet(C());
    int m = 0;
    while (m < localArrayList.size())
    {
      if (2131439735 == ((Integer)((Pair)localArrayList.get(m)).first).intValue()) {
        ((ActionSheet)localObject).addCancelButton(((MainFragment.OverallMenuInfo)((Pair)localArrayList.get(m)).second).a);
      } else {
        ((ActionSheet)localObject).addButton(((MainFragment.OverallMenuInfo)((Pair)localArrayList.get(m)).second).a);
      }
      m += 1;
    }
    ((ActionSheet)localObject).setOnButtonClickListener(new MainFragment.6(this, localArrayList, (ActionSheet)localObject));
    ((ActionSheet)localObject).setOnDismissListener(new MainFragment.7(this));
    ((ActionSheet)localObject).setCanceledOnTouchOutside(true);
    this.aB = ((Dialog)localObject);
    try
    {
      this.aB.show();
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
      localStringBuilder.append(paramOverallMenuInfo.a);
      localStringBuilder.append(" is execute");
      QLog.d("MainFragment", 2, localStringBuilder.toString());
    }
    if (paramInt == 2131439738)
    {
      paramOverallMenuInfo = this.e.j();
      if ((paramOverallMenuInfo != null) && (paramOverallMenuInfo.b != null))
      {
        if (paramOverallMenuInfo.b.iUpgradeType == 0) {
          QQToast.makeText(this.A.getApp(), 0, HardCodeUtil.a(2131904335), 0).show(getResources().getDimensionPixelSize(2131299920));
        } else if ((paramOverallMenuInfo != null) && (paramOverallMenuInfo.b != null)) {
          UpgradeDetailActivity.a(C(), UpgradeController.a().d(), false, false, true);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.w("MainFragment", 2, "mWrapper is null");
        }
        QQToast.makeText(this.A.getApp(), 0, HardCodeUtil.a(2131904339), 0).show(getResources().getDimensionPixelSize(2131299920));
      }
      ReportController.b(this.A, "CliOper", "", "", "0X80041C1", "0X80041C1", 0, 0, "", "", "", "");
      return;
    }
    if (paramInt == 2131439736)
    {
      ReportController.b(this.A, "CliOper", "", "", "0X80041C3", "0X80041C3", 0, 0, "", "", "", "");
      if (PwdSetUtil.a(c(), C())) {
        return;
      }
      i();
      return;
    }
    if (paramInt == 2131439735)
    {
      h();
      return;
    }
    if (paramOverallMenuInfo.b != null)
    {
      AboutConfig.a(c(), C(), paramOverallMenuInfo.b);
      if ("com.tencent.Feedback_5_8".equals(paramOverallMenuInfo.b.strPkgName)) {
        ReportController.b(this.A, "CliOper", "", "", "0X80041C2", "0X80041C2", 0, 0, "", "", "", "");
      }
    }
  }
  
  public Dialog a(String paramString1, String paramString2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    ReportDialog localReportDialog = new ReportDialog(C(), 2131953338);
    localReportDialog.setContentView(2131624755);
    TextView localTextView = (TextView)localReportDialog.findViewById(2131431880);
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
    paramString1 = (TextView)localReportDialog.findViewById(2131431876);
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
    paramString1 = (TextView)localReportDialog.findViewById(2131431864);
    if (paramString1 != null) {
      paramString1.setText(2131887648);
    }
    paramString1 = (TextView)localReportDialog.findViewById(2131431870);
    if (paramString1 != null) {
      paramString1.setText(2131892267);
    }
    localReportDialog.setOnDismissListener(paramOnDismissListener);
    return localReportDialog;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).onFragmentDrawerClosed(this, paramInt1, paramInt2);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onTabDataChange type=");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(",isSuccess=");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.i("MainFragment", 1, ((StringBuilder)localObject).toString());
    if ((paramBoolean) && (isAdded()))
    {
      a(this, false);
      localObject = C();
      if (localObject == null) {
        return;
      }
      String str = ((QBaseActivity)localObject).getCurrentAccountUinFromRuntime();
      if (TextUtils.isEmpty(str)) {
        return;
      }
      if (!this.ap) {
        a((Context)localObject, str);
      }
    }
  }
  
  public void a(Context paramContext, String paramString)
  {
    TabUIHelper.c(paramContext, paramString);
  }
  
  public void a(FrameFragment paramFrameFragment, boolean paramBoolean)
  {
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).setFrames(paramFrameFragment, paramBoolean);
  }
  
  public void a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, IRedTouchManager paramIRedTouchManager)
  {
    if ((this.ad == null) && (this.ab != null)) {
      this.ad = new RedTouch(C(), this.ab).c(53).a();
    }
    if (this.ad != null) {
      this.ad.a(paramRedTypeInfo);
    }
    paramIRedTouchManager.reportLevelZeroRedInfo(1, 30);
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "MainActivity:onLogout");
    }
    SharedPreUtils.a(this.A.getApp(), "");
    if (TroopAssistantManager.a().f()) {
      TroopAssistantManager.a().a(false);
    }
    TroopAssistantManager.a().e(c());
    LoadingStateManager.b().a(1);
    this.az = true;
    QIMNewFriend.a();
    UserguideActivity.a();
    ThreadManager.getUIHandler().post(new MainFragment.11(this));
    super.a(paramLogoutReason);
  }
  
  protected void a(boolean paramBoolean)
  {
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).onFragmentDrawerInit(paramBoolean);
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 82)
    {
      N();
      return true;
    }
    if (paramInt == 4)
    {
      paramKeyEvent = v();
      if ((paramKeyEvent != null) && (paramKeyEvent.h())) {
        return true;
      }
      try
      {
        paramKeyEvent = (PendingIntent)C().getIntent().getParcelableExtra("activity_finish_run_pendingIntent");
        if ((paramKeyEvent != null) && ((paramKeyEvent instanceof PendingIntent)) && (!C().getIntent().getBooleanExtra("share_from_aio", false)))
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
        C().moveTaskToBack(true);
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
  
  public void b()
  {
    if (C() != null)
    {
      View localView = C().findViewById(2131446243);
      if (localView != null)
      {
        ViewParent localViewParent = localView.getParent();
        if (localViewParent != null) {
          ((ViewGroup)localViewParent).removeView(localView);
        }
      }
    }
    SetSplash.c();
  }
  
  public QQAppInterface c()
  {
    return (QQAppInterface)this.A;
  }
  
  public void d()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDrawComplete[");
      localStringBuilder.append(((ITabFrameController)QRoute.api(ITabFrameController.class)).getCurrentTabTag(this.s));
      localStringBuilder.append("]");
      QLog.d("MainFragment", 2, localStringBuilder.toString());
    }
    super.d();
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "onAccountChanged");
    }
    o = false;
    QQAppInterface localQQAppInterface = c();
    super.e();
    this.A = C().getAppRuntime();
    com.tencent.mobileqq.app.FriendListHandler.getSpecialRecommendStat = -1;
    this.P = false;
    ThreadManager.post(new MainFragment.5(this), 2, null, true);
    Object localObject;
    if (this.A != null)
    {
      localObject = this.e;
      if (localObject != null)
      {
        ((MainAssistObserver)localObject).e = false;
        ((MainAssistObserver)localObject).a();
        if (QLog.isColorLevel()) {
          QLog.d("MainFragment", 2, "onAccountChange.check.new....");
        }
        if ((!TextUtils.isEmpty(this.c)) && (this.c.equals(this.A.getAccount()))) {}
      }
    }
    try
    {
      localObject = QQNotificationManager.getInstance();
      ((QQNotificationManager)localObject).cancel("MainFragment", 241);
      ((QQNotificationManager)localObject).cancel("MainFragment", 243);
      QZoneManagerImp localQZoneManagerImp = (QZoneManagerImp)this.A.getManager(QQManagerFactory.QZONE_MANAGER);
      if (localQZoneManagerImp != null) {
        localQZoneManagerImp.a(1, 0);
      }
      ((QQNotificationManager)localObject).cancel("MainFragment", 265);
      NotifyIdManager.a(c()).c();
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
    this.e.i();
    this.e.a(localQQAppInterface);
    if (this.A != null)
    {
      ((QIMNewFriendManager)this.A.getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER)).a(this.as);
      this.A.registObserver(this.at);
      this.A.registObserver(this.au);
      QLog.i("MainFragment", 1, "onAccountChange: addObserver");
      ((QQAppInterface)this.A).addObserver(this.j);
    }
    if (this.aj != null) {
      this.aj.df_();
    }
    if (this.az) {
      this.az = false;
    }
    if ((this.A != null) && (this.z != null) && (this.G != null)) {
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
    localMainAssistObserver = this.e;
    if (localMainAssistObserver != null) {
      localMainAssistObserver.u = false;
    }
    C().getIntent().removeExtra("if_check_account_same");
    if (this.A != null) {
      this.c = this.A.getAccount();
    }
    UserguideActivity.a();
    ThemeFontAdapter.a(true);
  }
  
  public void f()
  {
    if (this.aj != null) {
      this.aj.l();
    }
  }
  
  public String g()
  {
    if ((w() == FrameControllerUtil.a) && ((v() instanceof Conversation)))
    {
      QQSettingMe localQQSettingMe = ((Conversation)v()).Z;
      if (QQSettingMe.i()) {
        return "QQSettingMe";
      }
    }
    return z();
  }
  
  void h()
  {
    Dialog localDialog = this.aB;
    if ((localDialog == null) || (localDialog.isShowing())) {}
    try
    {
      this.aB.dismiss();
      label23:
      this.aB = null;
      return;
    }
    catch (Exception localException)
    {
      break label23;
    }
  }
  
  void i()
  {
    j();
    Dialog localDialog = a("你确定退出QQ？", null, new MainFragment.8(this));
    Object localObject = (TextView)localDialog.findViewById(2131431870);
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new MainFragment.9(this, localDialog));
    }
    localObject = (TextView)localDialog.findViewById(2131431864);
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new MainFragment.10(this));
    }
    localObject = getString(2131915612);
    boolean bool = SettingCloneUtil.isContainValue(C(), this.A.getCurrentAccountUin(), (String)localObject, "qqsetting_receivemsg_whenexit_key");
    this.l = SettingCloneUtil.readValue(C(), this.A.getCurrentAccountUin(), (String)localObject, "qqsetting_receivemsg_whenexit_key", true);
    localObject = (CheckBox)localDialog.findViewById(2131430666);
    if ((bool) && (this.l)) {
      ((CheckBox)localObject).setVisibility(8);
    }
    ((CheckBox)localObject).setChecked(this.l);
    this.k = localDialog;
    this.k.show();
  }
  
  void j()
  {
    Dialog localDialog = this.k;
    if ((localDialog == null) || (localDialog.isShowing())) {}
    try
    {
      this.k.dismiss();
      label23:
      this.k = null;
      return;
    }
    catch (Exception localException)
    {
      break label23;
    }
  }
  
  public void k()
  {
    super.k();
  }
  
  public String l()
  {
    if (G()) {
      return getString(2131887440);
    }
    return super.l();
  }
  
  public void m()
  {
    Object localObject = a(Conversation.class);
    if ((localObject != null) && (((Conversation)localObject).z()))
    {
      localObject = (VipGiftManager)this.A.getManager(QQManagerFactory.VIP_GIF_MANAGER);
      if (localObject != null)
      {
        VipGiftDownloadInfo localVipGiftDownloadInfo = ((VipGiftManager)localObject).e();
        if ((localVipGiftDownloadInfo != null) && (isResumed()) && (localVipGiftDownloadInfo.f == 2L)) {
          ((VipGiftManager)localObject).a(localVipGiftDownloadInfo, (BaseActivity)C());
        }
      }
    }
  }
  
  public void n() {}
  
  protected void o()
  {
    if (w() == FrameControllerUtil.a)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DynimiIcon", 2, "onFragmentDrawerOpened");
      }
      ((ITabFrameController)QRoute.api(ITabFrameController.class)).revertTabIconChange(this);
    }
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
    Object localObject = (Animation)aC.get(paramInt2);
    if (localObject == null)
    {
      if (paramInt2 == 2130772114)
      {
        localObject = new MainEnterOutAni();
        ((Animation)localObject).setDuration(C().getResources().getInteger(2131492874));
        ((Animation)localObject).setInterpolator(C(), 17432580);
      }
      else
      {
        localObject = AnimationUtils.loadAnimation(C(), paramInt2);
      }
      aC.put(paramInt2, localObject);
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
      localStringBuilder.append(this.W);
      QLog.d("MainFragment", 2, localStringBuilder.toString());
    }
    L();
    if (this.W == null)
    {
      if (SetSplash.e()) {
        paramViewGroup.postDelayed(new MainFragment.3(this), 3000L);
      } else {
        b();
      }
      paramViewGroup = (SplashActivity)C();
      if (paramViewGroup.mPreloadMainViews != null) {
        this.W = paramViewGroup.mPreloadMainViews[0];
      } else {
        this.W = super.onCreateView(paramLayoutInflater, null, paramBundle);
      }
    }
    else if (this.W.getParent() != null)
    {
      ((ViewGroup)this.W.getParent()).removeView(this.W);
    }
    paramLayoutInflater = new MainFragment.4(this);
    if (StartService.a) {
      paramLayoutInflater.run();
    } else {
      ThreadManager.getSubThreadHandler().postDelayed(paramLayoutInflater, 2000L);
    }
    paramLayoutInflater = C().getIntent();
    if (paramLayoutInflater != null) {
      this.aA = paramLayoutInflater.getIntExtra("current_tab_tag", -1);
    }
    SubscribeAdDeviceInfoHelper.a().b();
    paramLayoutInflater = this.W;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "AutoMonitor_fragment MainFragment onDestroy");
    }
    super.onDestroy();
    aC.clear();
    if (this.A != null)
    {
      MainAssistObserver localMainAssistObserver = this.e;
      if (localMainAssistObserver != null)
      {
        if (!this.ay)
        {
          localMainAssistObserver.b();
          this.ay = true;
        }
        this.e.d();
      }
    }
    if (this.A != null)
    {
      ((QIMNewFriendManager)this.A.getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER)).a();
      this.A.unRegistObserver(this.at);
      this.A.unRegistObserver(this.au);
    }
    ScreenCapture.clearSnapCacheFile(C());
    if (C().isFinishing())
    {
      try
      {
        ((IUniformDownloadMgr)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IUniformDownloadMgr.class, "")).onQQProcessExit();
        if (QLog.isColorLevel()) {
          QLog.d("MainFragment", 2, "MainActivity.onDestory");
        }
        if (DownloadManager.c()) {
          DownloadManager.b().j();
        }
        TMAssistantDownloadManager.closeAllService(BaseApplication.getContext());
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      a = b ^ true;
      b = false;
      if (this.A != null)
      {
        Object localObject = this.A;
        boolean bool = a;
        ((AppRuntime)localObject).isClearTaskBySystem = bool;
        if (bool)
        {
          this.A.isBackgroundStop = true;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("mqq.intent.action.EXIT");
          ((StringBuilder)localObject).append(C().getPackageName());
          localObject = new Intent(((StringBuilder)localObject).toString());
          C().sendBroadcast((Intent)localObject);
        }
        else if (SettingCloneUtil.readValue(this.A.getApplication(), this.A.getAccount(), null, "pcactive_config", false))
        {
          this.A.startPCActivePolling(this.A.getAccount(), "exitApp");
          c().exit(true);
        }
        else
        {
          c().exit(false);
        }
      }
    }
    s();
    QCircleThirdTabConfig.a().b();
    QzoneConfig.getInstance().removeListener(QCircleInjectImpl.i(this));
  }
  
  public void onDestroyView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "AutoMonitor_fragment MainFragment onDestroyView");
    }
    this.e.b();
    if (this.A != null)
    {
      ((QIMNewFriendManager)this.A.getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER)).a();
      this.A.unRegistObserver(this.at);
      this.A.unRegistObserver(this.au);
    }
    this.ay = true;
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
      this.X = true;
      onPause();
      onStop();
      this.X = false;
    }
    else
    {
      if (Build.VERSION.SDK_INT < 18) {
        this.W.requestFocus();
      }
      if (C().getIntent().getBooleanExtra("isFromAioFragment", false))
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
    if ((SplashActivity.currentFragment != 1) && (!this.X))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "onPause return");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "AutoMonitor_fragment MainFragment onPause");
    }
    if ((this.av != 0L) && (this.O != null) && (UnifiedMonitor.a().whetherReportThisTime(8))) {
      UnifiedMonitor.a().addEvent(8, this.O, (int)(SystemClock.uptimeMillis() - this.av), 0, null);
    }
    this.av = 0L;
    h();
    com.tencent.mobileqq.activity.recent.RecentUtil.d = false;
    if (DrawerFrame.b == 2) {
      I();
    }
    FrameHelperActivity.c(false);
    LebaTabRedTouch.g();
    r();
  }
  
  public void onResume()
  {
    ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).adjustTab(getQBaseActivity());
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
    this.av = SystemClock.uptimeMillis();
    M();
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).setFrames(this, false);
    if (GuardManager.sInstance != null) {
      GuardManager.sInstance.onEvent(6, null);
    }
    com.tencent.mobileqq.activity.recent.RecentUtil.d = true;
    if (this.r != null)
    {
      localObject = this.r;
      this.r = null;
      ((SplashActivity)C()).openMainFragment((Intent)localObject);
    }
    t();
    this.e.i();
    StartupTracker.a("Main_OnResume", null);
    Object localObject = (TroopRedTouchHandler)c().getBusinessHandler(BusinessHandlerFactory.GET_RED_POINT_EX_HANDLER);
    if ((localObject != null) && (((TroopRedTouchHandler)localObject).a()) && (QLog.isColorLevel())) {
      QLog.d("Q.qqstory.redPoint", 2, "MainFragment onResume, getRedPointInfo");
    }
    ((IReadInJoySPEventReport)QRoute.api(IReadInJoySPEventReport.class)).reportTabExposure();
    if (SplashActivity.sExitAIOCode != 0)
    {
      HardCoderManager.getInstance().stop(SplashActivity.sExitAIOCode);
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
    if ((this.K != null) && (!this.L)) {
      this.K.a();
    }
    int m = this.aA;
    if (m != -1)
    {
      a(m);
      this.aA = -1;
    }
    o = false;
    this.e.a(C().getIntent());
    this.e.b(C().getIntent());
    ForwardDialogMgr.a(C(), C().getIntent());
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
    Object localObject = this.aw;
    if ((localObject != null) && (((String)localObject).length() > 0) && ("pakage_from_h5".equalsIgnoreCase(this.ax)))
    {
      localObject = JumpParser.a(c(), C(), this.aw);
      ((JumpAction)localObject).d(this.ax);
      ((JumpAction)localObject).a();
      this.aw = null;
      this.ax = null;
    }
    if (!c().mAutomator.g()) {
      ((IRIJTabInject)QRoute.api(IRIJTabInject.class)).kanDianTabExposure(this.G, this.z);
    }
    ((AppGuideTipsManager)this.A.getManager(QQManagerFactory.APP_GUIDE_TIPS_MANAGER)).f();
  }
  
  public void onStop()
  {
    super.onStop();
    if ((SplashActivity.currentFragment != 1) && (!this.X))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainFragment", 2, "onStop return");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MainFragment", 2, "AutoMonitor_fragment MainFragment onStop");
    }
    if (DrawerFrame.b > 0) {
      I();
    }
  }
  
  public void onTabChanged(String paramString)
  {
    if ((this.av != 0L) && (this.O != null) && (UnifiedMonitor.a().whetherReportThisTime(8))) {
      UnifiedMonitor.a().addEvent(8, this.O, (int)(SystemClock.uptimeMillis() - this.av), 0, null);
    }
    if (this.O != null) {
      SceneTracker.a().b(this.O);
    }
    SceneTracker.a().a(this.O);
    this.av = SystemClock.uptimeMillis();
    if (this.ae != null)
    {
      this.ae.setVisibility(0);
      e(false);
    }
    super.onTabChanged(paramString);
    com.tencent.mobileqq.activity.recent.RecentUtil.d = true;
    if ((!((IRIJXTabFrameUtils)QRoute.api(IRIJXTabFrameUtils.class)).isKandianTabFrame(this.O)) && (!QzoneFrame.class.getName().equals(this.O)) && (!QCircleFrame.class.getName().equals(this.O)) && (!FlashShowFrame.class.getName().equals(this.O)) && (!((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).getGuildMainFrameClass().getName().equals(this.O)))
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
    if (this.z == null)
    {
      ((ITabFrameController)QRoute.api(ITabFrameController.class)).initTabs(this, this.W);
      ((ITabFrameController)QRoute.api(ITabFrameController.class)).setFrames(this, true);
      this.s.setOnDrawCompleteListener(this);
    }
  }
  
  protected void p()
  {
    if (w() == FrameControllerUtil.a)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FDynimiIcon", 2, "onFragmentDrawerOpened");
      }
      ((ITabFrameController)QRoute.api(ITabFrameController.class)).revertTabIconChange(this);
    }
  }
  
  protected void q()
  {
    if (w() == FrameControllerUtil.a)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DynimiIcon", 2, "onFragmentDrawerOpened");
      }
      ((ITabFrameController)QRoute.api(ITabFrameController.class)).revertTabIconChange(this);
    }
    ThreadManager.getSubThreadHandler().post(new MainFragment.12(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.MainFragment
 * JD-Core Version:    0.7.0.1
 */