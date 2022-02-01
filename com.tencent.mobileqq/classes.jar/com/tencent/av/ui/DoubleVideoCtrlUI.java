package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.AVLog;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.abtest.QavUIABTestUtils;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.avatar.QavUpdateAvatarViewHelper;
import com.tencent.av.business.manager.EffectOperateManager;
import com.tencent.av.business.manager.magicface.MagicDataReport;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.av.business.manager.report.VideoNodeReporter;
import com.tencent.av.chatroom.ChatRoomUtil;
import com.tencent.av.core.JniSimpleInfoMng;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.doodle.DoodleLogic;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.av.recog.AVVoiceRecog;
import com.tencent.av.report.AVReport;
import com.tencent.av.screenshare.ScreenShareCtrl;
import com.tencent.av.screenshare.ScreenShareDialogUtil;
import com.tencent.av.screenshare.ScreenShareReportHelper;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.ui.avatar.AvatarParam;
import com.tencent.av.ui.chatroom.VideoChatRoomUIContoller;
import com.tencent.av.ui.effect.menuview.QavEffectBaseMenuView;
import com.tencent.av.ui.effect.toolbar.oldversion.BeautyToolbar;
import com.tencent.av.ui.viewcontroller.OperationBtnItem;
import com.tencent.av.utils.AVTraceUtil;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.GAudioSoundUtil;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.av.utils.QAVConfigUtils.ScreenShareSafeTips;
import com.tencent.av.utils.RingAnimator;
import com.tencent.av.utils.SensorHelper;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.widget.ChildLockCircle;
import com.tencent.av.widget.ChildLockSign;
import com.tencent.av.wtogether.DavWTogetherObserver;
import com.tencent.av.wtogether.WTogetherMng;
import com.tencent.av.wtogether.WTogetherRealNameVideoProcessHelper;
import com.tencent.av.wtogether.callback.WatchTogetherUIProxy;
import com.tencent.av.wtogether.data.WTogetherRoom;
import com.tencent.av.wtogether.data.WatchTogetherInfo;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;
import com.tencent.av.wtogether.util.WTEntranceHelper;
import com.tencent.av.wtogether.util.WTogetherUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.api.ITraeMediaPlayerApi;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class DoubleVideoCtrlUI
  extends VideoControlUI
{
  public boolean a = false;
  boolean b = false;
  boolean c = false;
  boolean d = false;
  boolean e = false;
  TextView f = null;
  ImageView g = null;
  TextView h;
  RelativeLayout i = null;
  TextView j = null;
  QavInOutAnimation k = null;
  Timer l = null;
  final QavUpdateAvatarViewHelper m = new QavUpdateAvatarViewHelper();
  DavWTogetherObserver n = null;
  DoubleVideoCtrlUI.StartTimerRunnable o = new DoubleVideoCtrlUI.StartTimerRunnable(this);
  Runnable p = new DoubleVideoCtrlUI.1(this);
  Runnable q = new DoubleVideoCtrlUI.2(this);
  DoubleVideoCtrlUI.RecordInfo r = new DoubleVideoCtrlUI.RecordInfo(null);
  long s = 0L;
  Runnable t = new DoubleVideoCtrlUI.3(this);
  Runnable u = new DoubleVideoCtrlUI.4(this);
  Runnable v = new DoubleVideoCtrlUI.5(this);
  private long w = -1L;
  private int x = 0;
  
  public DoubleVideoCtrlUI(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup, ControlUIObserver paramControlUIObserver)
  {
    super(paramVideoAppInterface, paramAVActivity, paramViewGroup, paramControlUIObserver);
  }
  
  private void E()
  {
    String str = this.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setForground, mRequestPermissionIng[");
    localStringBuilder.append(this.bw);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (this.bw) {
      return;
    }
    if ((this.am != null) && (!this.b) && (!SessionMgr.a().d())) {
      this.am.p();
    }
  }
  
  private boolean F()
  {
    long l1 = System.currentTimeMillis();
    if (l1 > this.w + 200L)
    {
      this.w = l1;
      return true;
    }
    return false;
  }
  
  private ChildLockSign G()
  {
    Object localObject1;
    if ((this.ak != null) && (this.ak.get() != null))
    {
      Object localObject3 = (Activity)this.ak.get();
      Object localObject2 = (ChildLockSign)((Activity)localObject3).findViewById(2131441039);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ChildLockSign((Context)localObject3);
        localObject2 = (ViewGroup)((Activity)localObject3).findViewById(2131432075);
        Resources localResources = ((ViewGroup)localObject2).getResources();
        int i1 = localResources.getDimensionPixelOffset(2131298379);
        int i2 = localResources.getDimensionPixelOffset(2131298376);
        int i3 = ImmersiveUtils.getStatusBarHeight((Context)localObject3);
        int i4 = localResources.getDimensionPixelOffset(2131298377);
        localObject3 = new RelativeLayout.LayoutParams(i1, i2);
        ((RelativeLayout.LayoutParams)localObject3).setMargins(0, i3, i4, 0);
        ((RelativeLayout.LayoutParams)localObject3).addRule(10);
        ((RelativeLayout.LayoutParams)localObject3).addRule(11);
        ((ViewGroup)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
        ((ChildLockSign)localObject1).setVisibility(8);
        return localObject1;
      }
    }
    else
    {
      localObject1 = null;
    }
    return localObject1;
  }
  
  private void H()
  {
    Object localObject = U();
    SessionInfo localSessionInfo = this.am.k();
    WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = this.am.aA();
    if ((localWatchTogetherMediaPlayCtrl != null) && (localObject != null) && (localSessionInfo != null) && (localSessionInfo.r()))
    {
      localObject = ((AVActivity)localObject).d(localWatchTogetherMediaPlayCtrl.r());
      localSessionInfo.c(this.af ^ true);
      ((WatchTogetherUIProxy)localObject).setImmersiveStatus(this.af ^ true);
    }
  }
  
  private boolean I()
  {
    Object localObject = SessionMgr.a().b();
    boolean bool = true;
    if (localObject != null)
    {
      if (!((SessionInfo)localObject).r()) {
        return true;
      }
      localObject = U();
      if (localObject == null) {
        return true;
      }
      localObject = ((AVActivity)localObject).L;
      if (localObject == null) {
        return true;
      }
      if (((VideoLayerUI)localObject).F() == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private void J()
  {
    QavEffectBaseMenuView localQavEffectBaseMenuView = am();
    if (localQavEffectBaseMenuView == null) {
      return;
    }
    localQavEffectBaseMenuView.c(AudioHelper.c(), false);
  }
  
  private void a(long paramLong, SessionInfo paramSessionInfo)
  {
    if (V()) {
      return;
    }
    Object localObject;
    boolean bool;
    if (paramSessionInfo.r())
    {
      localObject = (WTogetherMng)this.al.c(17);
      if (localObject != null) {
        ((WTogetherMng)localObject).g(paramSessionInfo);
      }
      AVUtil.a("0X800B632", AVUtil.c(), 0, "", "", "", "");
      bool = false;
    }
    else
    {
      bool = true;
      WTEntranceHelper.a(U(), 2, paramSessionInfo.p, paramSessionInfo.s);
      AVUtil.a("0X800B61C", AVUtil.c(), 1, "", "", "", "");
    }
    this.aA.a(paramLong, 0, false);
    if (QLog.isDevelopLevel())
    {
      paramSessionInfo = this.X;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onClick_WatchTogether, open[");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append("]");
      QLog.i(paramSessionInfo, 4, ((StringBuilder)localObject).toString());
    }
  }
  
  private void a(long paramLong, String paramString)
  {
    if (this.aA == null) {
      return;
    }
    if ((this.aA.i()) && (!this.aA.j())) {
      return;
    }
    this.am.k().a("doMute", this.am.k().E ^ true);
    int i2 = this.am.k().D;
    int i1;
    if (this.am.k().E)
    {
      this.am.k().c("doMute", 1);
      i1 = 1;
    }
    else
    {
      this.am.k().c("doMute", 0);
      i1 = 0;
    }
    this.aA.a("DoubleVideoCtrl.doMute", i2, i1, false);
    g(true);
    DataReport.c(this.am);
  }
  
  static void a(Activity paramActivity, VideoAppInterface paramVideoAppInterface, boolean paramBoolean)
  {
    Object localObject = paramVideoAppInterface.b();
    SessionInfo localSessionInfo = ((VideoController)localObject).k();
    String str = localSessionInfo.s;
    int i1;
    if (paramBoolean ? ((VideoController)localObject).c(localSessionInfo) : ((VideoController)localObject).d(localSessionInfo)) {
      i1 = 1;
    } else {
      i1 = 3000;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendAddMemberBroadcast, peerUin[");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("], supportUinType[");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append("], fromDoubleMeeting[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("], activity[");
      ((StringBuilder)localObject).append(paramActivity);
      ((StringBuilder)localObject).append("]");
      QLog.i("double_2_multi", 2, ((StringBuilder)localObject).toString());
    }
    int i2;
    if (i1 == 1) {
      i2 = 1;
    } else {
      i2 = 2;
    }
    ReportController.b(null, "dc00898", "", "", "0X800A2D3", "0X800A2D3", i2, 0, "", "", "", "");
    if ((i1 == 3000) && (paramActivity != null) && (QAVConfigUtils.k()))
    {
      paramVideoAppInterface = QAVConfigUtils.l();
      DialogUtil.a(paramActivity, 230, null, paramVideoAppInterface, "", HardCodeUtil.a(2131901549), new DoubleVideoCtrlUI.6(), null).show();
      if (QLog.isColorLevel())
      {
        paramActivity = new StringBuilder();
        paramActivity.append("sendAddMemberBroadcast tip[");
        paramActivity.append(paramVideoAppInterface);
        paramActivity.append("]");
        QLog.i("double_2_multi", 2, paramActivity.toString());
      }
      ReportController.b(null, "dc00898", "", "", "0X800A2CB", "0X800A2CB", 0, 0, "", "", "", "");
      return;
    }
    paramActivity = new Intent();
    paramActivity.setAction("tencent.video.v2q.AddContactsFromC2C");
    paramActivity.putExtra("peerUin", str);
    paramActivity.putExtra("supportUinType", i1);
    paramActivity.setPackage(paramVideoAppInterface.getApp().getPackageName());
    paramVideoAppInterface.getApp().sendBroadcast(paramActivity);
  }
  
  static void a(VideoAppInterface paramVideoAppInterface)
  {
    VideoController localVideoController = paramVideoAppInterface.b();
    String str = localVideoController.k().s;
    int i2 = localVideoController.g(str);
    int i3 = localVideoController.i(str);
    int i4 = localVideoController.k().p;
    int i1 = 2131893165;
    if (i4 == 1011)
    {
      if (i3 < 45) {
        break label128;
      }
    }
    else if (!VcSystemInfo.isNormalSharp()) {
      i1 = 2131917911;
    } else if (Utils.a(localVideoController.i()) == 1) {
      i1 = 2131917839;
    } else if (i3 < 16) {
      i1 = 2131893166;
    } else if ((i2 != 4) && (i2 != 2) && (i2 != 3)) {}
    i1 = 0;
    label128:
    if (i1 != 0)
    {
      TipsUtil.a(paramVideoAppInterface, 1012, i1);
      return;
    }
    TipsUtil.b(paramVideoAppInterface, 1012);
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          paramInt = 0;
        } else {
          paramInt = 2131893709;
        }
      }
      else {
        paramInt = 2131893711;
      }
    }
    else {
      paramInt = 2131893714;
    }
    if (paramInt > 0)
    {
      TipsUtil.a(paramVideoAppInterface, 1048, paramInt);
      return;
    }
    TipsUtil.b(paramVideoAppInterface, 1048);
  }
  
  private void f(boolean paramBoolean)
  {
    Object localObject1 = this.l;
    if (localObject1 != null)
    {
      ((Timer)localObject1).cancel();
      this.l = null;
      QLog.w(this.X, 1, "StartGlassCheck, cancel old Timer");
    }
    this.l = new Timer();
    localObject1 = new DoubleVideoCtrlUI.8(this, paramBoolean);
    Object localObject2 = this.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StartGlassCheck, begin Timer, bCheck[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    QLog.w((String)localObject2, 1, localStringBuilder.toString());
    localObject2 = this.l;
    long l1;
    if (paramBoolean) {
      l1 = 1000L;
    } else {
      l1 = 10000L;
    }
    ((Timer)localObject2).schedule((TimerTask)localObject1, l1);
  }
  
  private void g(boolean paramBoolean)
  {
    if (this.am.k().E)
    {
      AVVoiceRecog.b().b(32);
      super.m(2131441023);
      this.al.a(new Object[] { Integer.valueOf(109) });
      if (paramBoolean) {
        this.am.a(true, null);
      }
      this.aA.a(2131441023, ((Context)this.ak.get()).getResources().getString(2131887103));
    }
    else
    {
      AVVoiceRecog.b().c(32);
      super.n(2131441023);
      this.al.a(new Object[] { Integer.valueOf(108) });
      if (paramBoolean) {
        this.am.a(false, null);
      }
      this.aA.a(2131441023, ((Context)this.ak.get()).getResources().getString(2131887090));
    }
    t(this.am.k().E ^ true);
  }
  
  private void n(long paramLong, View paramView)
  {
    AVActivity localAVActivity = U();
    if ((localAVActivity != null) && (!localAVActivity.isFinishing()))
    {
      if (localAVActivity.isDestroyed()) {
        return;
      }
      String str1 = localAVActivity.getString(2131916065);
      Object localObject1 = localAVActivity.getString(2131916062);
      Object localObject2 = localAVActivity.getString(2131916063);
      String str4 = localAVActivity.getString(2131916064);
      String str2 = localAVActivity.getString(2131893182);
      String str3 = localAVActivity.getString(2131893168);
      localObject1 = QAVConfigUtils.a((String)localObject1, (String)localObject2, str4);
      localObject1 = ScreenShareDialogUtil.a(localAVActivity, ((QAVConfigUtils.ScreenShareSafeTips)localObject1).a, ((QAVConfigUtils.ScreenShareSafeTips)localObject1).b, ((QAVConfigUtils.ScreenShareSafeTips)localObject1).c);
      localObject2 = PreferenceManager.getDefaultSharedPreferences(this.al.getApp());
      if (!((SharedPreferences)localObject2).contains("SCREEN_SHARE_NOTICE_DIALOG_IS_SHOWN"))
      {
        ScreenShareDialogUtil.a(localAVActivity, str1, (CharSequence)localObject1, str3, str2, true, 10, new DoubleVideoCtrlUI.17(this), new DoubleVideoCtrlUI.18(this, paramLong, paramView)).show();
        ((SharedPreferences)localObject2).edit().putBoolean("SCREEN_SHARE_NOTICE_DIALOG_IS_SHOWN", true).apply();
        return;
      }
      DialogUtil.a(localAVActivity, 230, str1, (CharSequence)localObject1, str3, str2, new DoubleVideoCtrlUI.19(this, paramLong, paramView), new DoubleVideoCtrlUI.20(this)).setMessageWithoutAutoLink((CharSequence)localObject1).show();
    }
  }
  
  private void o(long paramLong, View paramView)
  {
    Object localObject = U();
    if ((localObject != null) && (!((AVActivity)localObject).isFinishing()))
    {
      if (((AVActivity)localObject).isDestroyed()) {
        return;
      }
      localObject = ActionSheet.create((Context)localObject);
      ((ActionSheet)localObject).addButton(2131916050, 0);
      if (QAVConfigUtils.t())
      {
        ((ActionSheet)localObject).addButton(2131916049, 0);
        ((ActionSheet)localObject).addCancelButton(2131887648);
        ((ActionSheet)localObject).setOnButtonClickListener(new DoubleVideoCtrlUI.21(this, paramLong, paramView, (ActionSheet)localObject));
        ((ActionSheet)localObject).setOnBottomCancelListener(new DoubleVideoCtrlUI.22(this, (ActionSheet)localObject));
        ((ActionSheet)localObject).show();
        ScreenShareReportHelper.b("0X800B8A1");
        return;
      }
      f(paramLong, paramView);
      ScreenShareReportHelper.a("0X800AD8E", 1);
    }
  }
  
  private void p(long paramLong, View paramView)
  {
    if (this.al == null) {
      return;
    }
    paramView = new ControlUIObserver.CPreEventInfo(paramView);
    paramView.a(paramLong, "onClick_InviteMember");
    this.al.a(new Object[] { Integer.valueOf(9000), paramView });
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onClick_InviteMember block[");
      ((StringBuilder)localObject).append(paramView.d);
      ((StringBuilder)localObject).append("]");
      QLog.i("double_2_multi", 2, ((StringBuilder)localObject).toString());
    }
    if (paramView.d)
    {
      localObject = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClick_InviteMember, mBlockName[");
      localStringBuilder.append(paramView.e);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    else
    {
      DataReport.g(this.am);
      a(U(), this.al, false);
      if ((SmallScreenUtils.g()) && ((this.ak.get() instanceof AVActivity)))
      {
        paramView = (AVActivity)this.ak.get();
        if (paramView != null)
        {
          paramView = paramView.o();
          if (paramView != null) {
            paramView.d();
          }
        }
      }
    }
    i(paramLong, 2131893078);
  }
  
  private void v(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.bb)) {
      g(AudioHelper.c(), null);
    }
  }
  
  protected boolean B()
  {
    return this.am.k().H;
  }
  
  protected boolean C()
  {
    return QavUIABTestUtils.c(this.al.getCurrentAccountUin());
  }
  
  protected boolean D()
  {
    return QavUIABTestUtils.b(this.al.getCurrentAccountUin());
  }
  
  public void a() {}
  
  void a(int paramInt)
  {
    if ((paramInt != -1) && (paramInt != 0) && (paramInt != 1) && (paramInt != 2)) {}
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    long l1 = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      localObject1 = this.X;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onTerSwitchSyncStatus, cameraStatus[");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("], micStatus[");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    if (V()) {
      return;
    }
    if (paramInt1 == 1) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (paramInt1 == 0)
    {
      m(l1);
      this.al.a(new Object[] { Integer.valueOf(106), Long.valueOf(l1) });
    }
    else
    {
      l(l1);
      this.al.a(new Object[] { Integer.valueOf(105), Boolean.valueOf(false), Long.valueOf(l1) });
    }
    Object localObject1 = this.am.k();
    if ((paramInt1 == 0) && (!((SessionInfo)localObject1).I))
    {
      if (((SessionInfo)localObject1).g == 2)
      {
        ((SessionInfo)localObject1).a(l1, "onTerSwitchSyncStatus.2", 1);
        a("onTerSwitchSyncStatus.2", ((SessionInfo)localObject1).g);
      }
    }
    else if (((SessionInfo)localObject1).g == 1)
    {
      ((SessionInfo)localObject1).a(l1, "onTerSwitchSyncStatus.1", 2);
      a("onTerSwitchSyncStatus.1", ((SessionInfo)localObject1).g);
    }
    boolean bool;
    if (paramInt2 == 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((SessionInfo)localObject1).a("onTerSwitchSyncStatus", bool);
    if (paramInt2 == 0) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    ((SessionInfo)localObject1).c("onTerSwitchSyncStatus", paramInt1);
    Object localObject2 = ((SessionInfo)localObject1).s;
    if (((SessionInfo)localObject1).E)
    {
      super.m(2131441023);
      this.al.a(new Object[] { Integer.valueOf(109) });
      this.am.a(true, (String)localObject2);
      if ((this.ak.get() != null) && (this.aA != null)) {
        this.aA.a(2131441023, ((Context)this.ak.get()).getResources().getString(2131887103));
      }
    }
    else
    {
      super.n(2131441023);
      this.al.a(new Object[] { Integer.valueOf(108) });
      this.am.a(false, (String)localObject2);
      if ((this.ak.get() != null) && (this.aA != null)) {
        this.aA.a(2131441023, ((Context)this.ak.get()).getResources().getString(2131887090));
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.an != null)
    {
      View localView1 = this.an.findViewById(2131441298);
      View localView2 = this.an.getRootView().findViewById(2131441299);
      if (AudioHelper.a(0) == 1)
      {
        localView1.setBackgroundColor(2147460352);
        localView2.setBackgroundColor(2147460352);
      }
      if (localView1 != null)
      {
        RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)localView1.getLayoutParams();
        RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)localView2.getLayoutParams();
        if (localLayoutParams1 != null)
        {
          if (!paramBoolean)
          {
            localLayoutParams1.topMargin = (paramInt - ap() + AIOUtils.b(15.0F, this.aj));
            if (LiuHaiUtils.b()) {
              localLayoutParams1.topMargin += LiuHaiUtils.e((AVActivity)this.ak.get());
            }
          }
          else
          {
            localLayoutParams1.topMargin = AIOUtils.b(15.0F, this.aj);
          }
          localLayoutParams2.topMargin = localLayoutParams1.topMargin;
          localView1.setLayoutParams(localLayoutParams1);
          localView2.setLayoutParams(localLayoutParams2);
        }
      }
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (((paramInt1 == 2131441025) || (paramInt1 == 2131441026)) && (this.aA != null))
    {
      this.aA.c(paramBoolean, paramInt2);
      this.aA.b(2131441025, paramBoolean);
      this.aA.setViewEnable(2131441025, paramBoolean);
    }
  }
  
  public void a(long paramLong)
  {
    super.a(paramLong);
    if (this.am != null)
    {
      int i1;
      if (this.am.k().f())
      {
        if (AVReport.a().d)
        {
          VideoNodeManager.a(29);
          AVReport.a().n = SystemClock.elapsedRealtime();
        }
        else
        {
          AVReport.a().C = SystemClock.elapsedRealtime();
        }
        if (this.am.k().W >= 0)
        {
          if (this.am.k().p == 1011)
          {
            a_(-1015L, 2131893177);
            if (this.aO != null) {
              this.aO.b();
            }
          }
          else
          {
            a_(-1015L, 2131893108);
            long l1 = this.am.k().X;
            Object localObject = ColorRingManager.a(l1, 3);
            if (new File((String)localObject).exists())
            {
              if (!this.am.k().C) {
                TraeHelper.a().a(paramLong, this.al, 0, (String)localObject, -1, null);
              }
              i1 = this.am.k().Y;
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("");
              ((StringBuilder)localObject).append(i1);
              localObject = ((StringBuilder)localObject).toString();
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(l1);
              localStringBuilder.append("");
              ReportController.b(null, "CliOper", "", "", "0X8004A21", "0X8004A21", 0, 0, (String)localObject, localStringBuilder.toString(), "", "");
            }
            else if (!this.am.k().C)
            {
              TraeHelper.a().a(paramLong, this.al, 2131230815, null, -1, null);
            }
            if (this.aO != null)
            {
              this.aO.c();
              this.aO.d();
            }
          }
        }
        else if (this.aO != null) {
          this.aO.b();
        }
        if (!this.am.k().j()) {
          this.al.a().postDelayed(this.q, 20000L);
        }
      }
      if (this.am.k().j())
      {
        i1 = this.am.k().g;
        if ((i1 != 1) && (i1 != 3) && (this.am.k().ag))
        {
          this.am.k().af = false;
          e(false);
          return;
        }
        w();
      }
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.X;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onClose, type[");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    w();
    super.a(paramLong, paramInt);
    Object localObject1 = this.am.k();
    int i3 = ((SessionInfo)localObject1).p;
    int i1;
    if (((SessionInfo)localObject1).aq == 2L) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2;
    if (paramInt == 12) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    if (((((SessionInfo)localObject1).m()) && ((paramInt == 3) || ((i2 != 0) && (i1 == 0)) || (paramInt == 42))) || ((((SessionInfo)localObject1).n()) && (i2 != 0) && (i1 != 0) && ((i3 == 0) || (i3 == 1006) || (i3 == 25) || (i3 == 24) || (i3 == 22) || (i3 == 26) || (i3 == 1044))))
    {
      if (this.aA != null)
      {
        DataReport.p(this.am);
        this.aA.a(new DoubleVideoCtrlUI.13(this, paramLong));
        an();
        localObject2 = this.am.k().w;
        Object localObject3;
        if (QLog.isColorLevel())
        {
          localObject3 = this.X;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onClose phoneNumber is ");
          localStringBuilder.append((String)localObject2);
          QLog.w((String)localObject3, 1, localStringBuilder.toString());
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (paramInt != 3))
        {
          ReportController.b(null, "CliOper", "", "", "0X800A8D6", "0X800A8D6", 0, 0, "", "", "", "");
          this.aA.setViewEnable(2131441008, true);
        }
        else if (Build.VERSION.SDK_INT >= 17)
        {
          this.aA.setViewVisibility(2131441008, 8);
          localObject2 = (Button)this.aA.e(2131441022);
          localObject3 = (RelativeLayout.LayoutParams)((Button)localObject2).getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject3).rightMargin = 0;
          ((RelativeLayout.LayoutParams)localObject3).removeRule(11);
          ((RelativeLayout.LayoutParams)localObject3).addRule(14);
          ((Button)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        }
        else
        {
          this.aA.setViewEnable(2131441008, false);
        }
        if (paramInt == 3) {
          this.aA.setViewEnable(2131441310, false);
        }
        this.aA.setViewEnable(2131441022, true);
      }
      localObject2 = (EffectOperateManager)this.al.c(8);
      if (localObject2 != null) {
        ((EffectOperateManager)localObject2).b(false);
      }
    }
    if (this.aO != null)
    {
      this.aO.c();
      this.aO.e();
      this.aO.a();
      this.aO = null;
    }
    this.b = true;
    if ((((SessionInfo)localObject1).j()) && (((SessionInfo)localObject1).g == 2) && (!((SessionInfo)localObject1).H)) {
      DataReport.e();
    }
    ((SessionInfo)localObject1).a("onClose", false);
    ((SessionInfo)localObject1).c("onClose", 0);
    if (paramInt == 24)
    {
      this.aT = true;
      a_(paramLong, 2131893580);
    }
    if (paramInt == 42) {
      this.al.a().removeCallbacks(this.q);
    }
  }
  
  public void a(long paramLong, View paramView)
  {
    if (this.am == null)
    {
      QLog.d(this.X, 1, "onClick mVideoController == null");
      return;
    }
    if (this.aA == null)
    {
      QLog.d(this.X, 1, "onClick mQavPanel == null");
      return;
    }
    if (this.am.k().af)
    {
      QLog.d(this.X, 1, "onClick isChildLock");
      return;
    }
    if (this.ak != null)
    {
      if (!(this.ak.get() instanceof AVActivity)) {
        return;
      }
      Object localObject1 = this.am.k().s;
      Object localObject2 = U();
      int i1;
      switch (paramView.getId())
      {
      default: 
      case 2131893088: 
        c(paramLong, paramView);
        return;
      case 2131893086: 
        l(paramLong, paramView);
        return;
      case 2131893084: 
        if (this.am.k().g == 1) {
          i1 = 1;
        } else {
          i1 = 2;
        }
        int i2;
        if (this.am.k().i == 1) {
          i2 = 1;
        } else {
          i2 = 3;
        }
        ReportController.b(null, "CliOper", "", "", "0X8009ED9", "0X8009ED9", i1, i2, "", "", "", "");
        paramView = new Intent((Context)this.ak.get(), QQBrowserActivity.class);
        paramView.putExtra("url", "https://zb.vip.qq.com/v2/pages/funcallMall");
        ((Context)this.ak.get()).startActivity(paramView);
        i(paramLong, 2131893084);
        paramView = this.am.k();
        if ((paramView != null) && (paramView.p == 1044))
        {
          ReportController.b(null, "dc00898", "", "", "0X800AD96", "0X800AD96", 0, 0, "", "", "", "");
          return;
        }
        break;
      case 2131893083: 
        QLog.d(this.X, 1, "onClick LayoutDef.OperationMenuItemID.SharpnessButton");
        ReportController.b(null, "CliOper", "", "", "0X800A343", "0X800A343", this.am.k().ai + 1, 0, "", "", "", "");
        ((AVActivity)this.ak.get()).K.h("Sharpness");
        if (((AVActivity)this.ak.get()).L.B() == 1) {
          ((AVActivity)this.ak.get()).L.h(paramLong);
        }
        this.aA.a(paramLong, 0, false);
        ((AVActivity)this.ak.get()).af.b();
        return;
      case 2131893082: 
        i(paramLong, paramView);
        return;
      case 2131893080: 
        n(paramLong, paramView);
        return;
      case 2131893079: 
        g(paramLong);
        return;
      case 2131893078: 
        QLog.d(this.X, 1, "onClick QavPanel.ViewID.ADD_MEMBER");
        p(paramLong, paramView);
        return;
      case 2131893076: 
        m(paramLong, paramView);
        return;
      case 2131893074: 
        b(paramLong, paramView);
        paramView = this.am.k();
        if ((paramView != null) && (paramView.p == 1044))
        {
          ReportController.b(null, "dc00898", "", "", "0X800AD95", "0X800AD95", 0, 0, "", "", "", "");
          return;
        }
        break;
      case 2131893072: 
        h(paramLong);
        return;
      case 2131441323: 
      case 2131893077: 
        QLog.d(this.X, 1, "onClick QavPanel.ViewID.Effect");
        k(paramLong, paramView);
        return;
      case 2131441310: 
        paramView = this.X;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onClick, switch_camera, seq[");
        ((StringBuilder)localObject1).append(paramLong);
        ((StringBuilder)localObject1).append("]");
        QLog.w(paramView, 1, ((StringBuilder)localObject1).toString());
        AVTraceUtil.a("switch_camera", "switch_camera", 1, new Object[] { Long.valueOf(paramLong) });
        this.al.a(new Object[] { Integer.valueOf(107), Long.valueOf(paramLong) });
        this.am.k().L ^= true;
        if (this.am.k().L)
        {
          ReportController.b(null, "CliOper", "", "", "0X80053AC", "0X80053AC", 0, 0, "", "", "", "");
          i1 = 2131889950;
        }
        else
        {
          ReportController.b(null, "CliOper", "", "", "0X80053AB", "0X80053AB", 0, 0, "", "", "", "");
          i1 = 2131889949;
        }
        if (this.aA != null)
        {
          this.aA.a(2131441310, this.aj.getString(i1));
          return;
        }
        break;
      case 2131441308: 
        ReportController.b(null, "dc00898", "", "", "0X800BCE1", "0X800BCE1", 0, 0, "", "", "", "");
        i(paramLong, paramView);
        return;
      case 2131441306: 
        ReportController.b(null, "dc00898", "", "", "0X800BCE2", "0X800BCE2", 0, 0, "", "", "", "");
        g(paramLong);
        return;
      case 2131441305: 
        QLog.d(this.X, 1, "onClick qav_titlebar_quit_double_screen ");
        paramView = new StringBuilder();
        paramView.append(this.am.p(this.am.k().s));
        paramView.append("");
        MagicDataReport.f(paramView.toString());
        this.ao.update(null, new Object[] { Integer.valueOf(134) });
        return;
      case 2131441304: 
        h(paramLong, paramView);
        return;
      case 2131441301: 
        ReportController.b(null, "dc00898", "", "", "0X800BCE3", "0X800BCE3", 0, 0, "", "", "", "");
        g(paramLong, paramView);
        return;
      case 2131441300: 
      case 2131893073: 
        e(paramLong, paramView);
        return;
      case 2131441025: 
        QLog.d(this.X, 1, "onClick QavPanel.ViewID.OPEN_LOCK");
        this.am.a((String)localObject1, 1, 5, 1);
        a(2131893669, 0, this.aj.getDimensionPixelSize(2131299920));
        return;
      case 2131441023: 
        d(paramLong, paramView);
        return;
      case 2131441022: 
        QLog.d(this.X, 1, "onClick QavPanel.ViewID.LEAVE_MSG");
        if (this.am != null)
        {
          TraeHelper.a().b(paramLong);
          i1 = this.am.k().p;
          paramView = this.am.k().s;
          localObject2 = this.am.k().t;
          String str = this.am.k().u;
          this.am.a(i1, paramView, (String)localObject2, str, true);
        }
        DataReport.q(this.am);
        this.am.b((String)localObject1, this.am.k().ay);
        return;
      case 2131441020: 
        paramView = this.am.k();
        if ((paramView != null) && (paramView.p == 1044)) {
          ReportController.b(null, "dc00898", "", "", "0X800AD98", "0X800AD98", 0, 0, "", "", "", "");
        }
        QLog.d(this.X, 1, "onClick HIDE ");
        this.am.b("backgroundReason", "3");
        com.tencent.av.VideoConstants.ProcessInfo.a = "3";
        o();
        DataReport.b(this.am);
        return;
      case 2131441016: 
      case 2131441017: 
      case 2131441018: 
      case 2131441019: 
        QLog.d(this.X, 1, "onClick Hangup ");
        a(paramView);
        return;
      case 2131441014: 
        boolean bool = F();
        paramView = this.X;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onClick QavPanel.ViewID.HAND_FREE canClick:=");
        ((StringBuilder)localObject1).append(bool);
        QLog.d(paramView, 1, ((StringBuilder)localObject1).toString());
        if (bool)
        {
          bool = this.am.k().aG;
          DataReport.a(this.am, bool ^ true);
          if (this.aQ != null)
          {
            this.aQ.a(TraeHelper.l);
            return;
          }
        }
        break;
      case 2131441006: 
      case 2131441008: 
        i1 = this.am.k().g;
        DataReport.a(paramView.getId(), i1);
        a((AVActivity)localObject2, (String)localObject1);
        return;
      case 2131440994: 
      case 2131893087: 
        QLog.d(this.X, 1, "onClick QavPanel.ViewID.Voice");
        j(paramLong, paramView);
        paramView = this.am.k();
        if ((paramView != null) && (paramView.p == 1044))
        {
          ReportController.b(null, "dc00898", "", "", "0X800AD94", "0X800AD94", 0, 0, "", "", "", "");
          return;
        }
        break;
      case 2131428836: 
      case 2131431769: 
      case 2131441303: 
      case 2131449444: 
        at();
      }
    }
  }
  
  void a(long paramLong, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setTitleText, mRingAnimator[");
      localStringBuilder.append(this.aO.k);
      localStringBuilder.append("], startRingAnimator[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(paramString)) {
      d(paramLong, paramString);
    }
    if ((paramBoolean) && (this.aO != null))
    {
      this.aO.c();
      this.aO.d();
    }
  }
  
  void a(long paramLong, boolean paramBoolean)
  {
    int i1 = this.am.k().g;
    f(paramLong, 16777215);
    SessionInfo localSessionInfo = this.am.k();
    if ((i1 == 2) && (Utils.a(this.al.getApp()) == 1) && (paramBoolean) && (localSessionInfo.j()))
    {
      a(this.al);
      ReportController.b(null, "CliOper", "", "", "0X8004E92", "0X8004E92", 0, 0, "", "", "", "");
    }
    f();
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (V()) {
      return;
    }
    Object localObject = null;
    if (this.ak.get() != null) {
      localObject = (AVActivity)this.ak.get();
    }
    boolean bool;
    if ((localObject != null) && (((AVActivity)localObject).checkSelfPermission("android.permission.CAMERA") != 0)) {
      bool = false;
    } else {
      bool = true;
    }
    localObject = this.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAfterOpenCamera, success[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], preSessionType[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], isConnected[");
    localStringBuilder.append(this.am.k().i);
    localStringBuilder.append("], mCameraNum[");
    localStringBuilder.append(this.ac);
    localStringBuilder.append("], remoteHasVideo[");
    localStringBuilder.append(this.am.k().I);
    localStringBuilder.append("], checkCameraResult[");
    localStringBuilder.append(bool);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if (paramBoolean)
    {
      this.aA.setViewVisibility(2131441304, 0);
      localObject = U();
      if (localObject != null) {
        ((AVActivity)localObject).a(true);
      }
      this.am.k().N = true;
      DataReport.c();
      DataReport.m(this.am);
      if ((!this.am.k().I) && (this.am.k().j())) {
        a("onAfterOpenCamera", 2);
      }
      I(paramLong);
    }
    f(paramLong, 16777215);
  }
  
  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.bc = paramBoolean1;
    QavPanel localQavPanel = this.aA;
    int i2 = 8;
    if (paramBoolean2) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localQavPanel.setViewVisibility(2131441301, i1);
    localQavPanel = this.aA;
    if (this.bc) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localQavPanel.setViewVisibility(2131441308, i1);
    localQavPanel = this.aA;
    if (this.bc) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localQavPanel.setViewVisibility(2131441306, i1);
    localQavPanel = this.aA;
    int i1 = i2;
    if (!this.bc) {
      i1 = 0;
    }
    localQavPanel.setViewVisibility(2131441310, i1);
    b_(AudioHelper.c());
    d(paramBoolean1, true);
    if ((!paramBoolean1) && (this.bd)) {
      d(true, false);
    }
    J();
    if ((paramBoolean1) && (!this.am.k().L))
    {
      this.al.a(new Object[] { Integer.valueOf(107), Long.valueOf(paramLong) });
      this.am.k().L ^= true;
    }
  }
  
  public void a(Context paramContext, boolean paramBoolean, String paramString)
  {
    paramString = SharedPreUtils.K(paramContext, this.al.getCurrentAccountUin());
    if (paramString.getBoolean("is_first_open_avatar2d_tips", true))
    {
      paramString.edit().putBoolean("is_first_open_avatar2d_tips", false).commit();
      this.al.a().postDelayed(new DoubleVideoCtrlUI.29(this, paramContext, paramBoolean), 300L);
    }
  }
  
  void a(View paramView)
  {
    long l1 = AudioHelper.c();
    String str = this.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClick_Hangup, seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    int i1 = paramView.getId();
    if ((i1 != 2131441016) && (i1 != 2131441017))
    {
      if (i1 == 2131441019) {
        AVLog.printAllUserLog(this.X, "exit when click bottom bar hangup no answer");
      }
    }
    else {
      AVLog.printAllUserLog(this.X, "exit when click bottom bar hangup");
    }
    str = this.am.k().s;
    paramView = new ControlUIObserver.CPreEventInfo(paramView);
    this.al.a(new Object[] { Integer.valueOf(9002), paramView });
    if (paramView.d)
    {
      str = this.X;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClick_Hangup, mBlockName[");
      localStringBuilder.append(paramView.e);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
      return;
    }
    i(true);
    this.k.a(new DoubleVideoCtrlUI.27(this, l1, str));
  }
  
  void a(AVActivity paramAVActivity, String paramString)
  {
    if (paramAVActivity == null) {
      return;
    }
    int i1 = this.am.k().g;
    Object localObject = this.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClick QavPanel.ViewID.CALL_PHONE, type[");
    localStringBuilder.append(i1);
    localStringBuilder.append("], PhoneNum[");
    localStringBuilder.append(AudioHelper.a(this.am.k().w));
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("tel:");
    ((StringBuilder)localObject).append(this.am.k().w);
    paramAVActivity.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(((StringBuilder)localObject).toString())));
    ReportController.b(null, "CliOper", "", "", "0X800A8D7", "0X800A8D7", 0, 0, "", "", "", "");
    this.b = true;
    this.am.a(paramString, 236);
    this.am.b(236);
    this.am.b(paramString, 0);
  }
  
  public void a(String paramString)
  {
    if (this.am.k().p == 25)
    {
      this.am.k().t = paramString;
      if (QLog.isColorLevel()) {
        QLog.d(this.X, 2, "setQCallNickName");
      }
      TextView localTextView = this.f;
      if (localTextView != null) {
        localTextView.setText(paramString);
      }
    }
    super.a(paramString);
  }
  
  void a(String paramString, int paramInt)
  {
    long l1 = AudioHelper.c();
    Object localObject1 = this.X;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("avSwitch[");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("], sessionType[");
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append("], seq[");
    ((StringBuilder)localObject2).append(l1);
    ((StringBuilder)localObject2).append("]");
    localObject2 = ((StringBuilder)localObject2).toString();
    boolean bool2 = true;
    QLog.w((String)localObject1, 1, (String)localObject2);
    if (this.aQ != null) {
      this.aQ.b();
    }
    if ((paramInt == 1) && (!this.am.k().cw) && (!this.am.k().cv))
    {
      q();
      d(l1, false);
      f(l1, 16777215);
      f(0);
      new ControlUIObserver.ZimuRequest(l1, "avSwitch", 2, null).a(this.al);
    }
    else if (paramInt == 2)
    {
      d(l1, true);
    }
    localObject1 = this.aR;
    boolean bool1;
    if (this.am.k().g == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((SensorHelper)localObject1).c(bool1);
    localObject1 = this.aR;
    if (this.am.k().g == 1) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    ((SensorHelper)localObject1).b(bool1);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("_avSwitch");
    c(l1, ((StringBuilder)localObject1).toString());
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    Object localObject = this.am.k();
    if (((SessionInfo)localObject).p == 25)
    {
      if (QLog.isColorLevel())
      {
        String str = this.X;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setQCallHead uin = ");
        localStringBuilder.append(paramString);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      localObject = new AvatarParam(((SessionInfo)localObject).p, paramString, ((SessionInfo)localObject).u, true);
      this.m.a(this.al, this.g, (AvatarParam)localObject, paramBitmap);
    }
    super.a(paramString, paramBitmap);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.am == null) {
      return;
    }
    SessionInfo localSessionInfo = this.am.k();
    long l1 = AudioHelper.c();
    String str = this.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onInviteReached, peerUin[");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("], showMsg[");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("], remotePhoneState[");
    localStringBuilder.append(localSessionInfo.W);
    localStringBuilder.append("], remoteTerminal[");
    localStringBuilder.append(localSessionInfo.K);
    localStringBuilder.append("], phoneOnLine[");
    localStringBuilder.append(localSessionInfo.V);
    localStringBuilder.append("], pcOnLine[");
    localStringBuilder.append(localSessionInfo.U);
    localStringBuilder.append("], subState[");
    localStringBuilder.append(localSessionInfo.aq);
    localStringBuilder.append("], isPeerNetworkWell[");
    localStringBuilder.append(localSessionInfo.P);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if ((localSessionInfo.f()) && (!localSessionInfo.br))
    {
      if (localSessionInfo.p == 1011) {
        return;
      }
      if (localSessionInfo.s.contains(paramString1))
      {
        int i1 = localSessionInfo.W;
        if (i1 >= 0) {
          if (TextUtils.isEmpty(paramString2)) {
            a_(l1, 2131893108);
          } else {
            d(l1, paramString2);
          }
        }
        if ((localSessionInfo.aq != 0L) && (localSessionInfo.aq == 2L))
        {
          this.am.onCloseVideo(localSessionInfo.s, 8, 0L);
          if (!TextUtils.isEmpty(localSessionInfo.ar)) {
            TipsUtil.a(this.al, 3008, localSessionInfo.ar);
          }
          ReportController.b(null, "CliOper", "", "", "0X800515D", "0X800515D", 0, 0, "", "", "", "");
        }
        if (this.aO != null)
        {
          this.aO.c();
          this.aO.d();
        }
        if ((i1 > 0) && (i1 != 3))
        {
          a(i1);
          DataReport.e(this.am);
          return;
        }
        if (i1 == 4)
        {
          if ((localSessionInfo.U == 1) && (localSessionInfo.V == 0)) {
            a(i1);
          }
        }
        else if ((i1 == 0) && (localSessionInfo.P) && (localSessionInfo.K != 2) && (localSessionInfo.g == 1)) {
          TipsUtil.a(this.al, 1038);
        }
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    long l1 = AudioHelper.c();
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = this.X;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPeerSwitchTerminal, peerUin[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], bStartSwitch[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      TipsUtil.a(this.al, 1020);
    }
    else
    {
      TipsUtil.b(this.al, 1020);
      if ((!this.am.n()) && (this.am.k().h == 1) && (this.am.k().H))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.X, 2, "onPeerSwitchTerminal, local close camera");
        }
        m(l1);
        this.al.a(new Object[] { Integer.valueOf(106), Long.valueOf(l1) });
        TipsUtil.a(this.al, 1021);
      }
      this.al.a().postDelayed(this.p, 2000L);
      this.am.am();
    }
    f(l1, 16777215);
    paramString = DoodleLogic.b();
    if (paramBoolean)
    {
      paramString.k = false;
      paramString.l = 0;
      if (QLog.isColorLevel())
      {
        str = this.X;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("WL_DEBUG onPeerSwitchTerminal mPeerVersion = ");
        localStringBuilder.append(paramString.l);
        localStringBuilder.append(", mIsPeerSupport = ");
        localStringBuilder.append(paramString.k);
        QLog.e(str, 2, localStringBuilder.toString());
      }
      SmallScreenUtils.a();
      this.al.a(new Object[] { Integer.valueOf(127) });
      return;
    }
    paramString.e();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.an != null)
    {
      View localView = this.an.findViewById(2131429675);
      if (localView != null)
      {
        if ((paramBoolean) && (localView.getVisibility() != 0))
        {
          localView.setVisibility(0);
          return;
        }
        if ((!paramBoolean) && (localView.getVisibility() != 8)) {
          localView.setVisibility(8);
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    this.aA.a(paramBoolean, paramInt, false);
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this.h;
    int i2 = 0;
    int i1;
    if (paramBoolean1) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((TextView)localObject).setVisibility(i1);
    localObject = this.i;
    if (paramBoolean1) {
      i1 = i2;
    } else {
      i1 = 8;
    }
    ((RelativeLayout)localObject).setVisibility(i1);
    if ((this.an != null) && (paramBoolean2))
    {
      if (this.aA != null) {
        this.aA.e(paramBoolean1 ^ true);
      }
      new VideoControlUI.QavStatusBar(this.an).a(paramBoolean1);
    }
    c(-1035L, "changeToDoubleScreen");
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt != 24) && (paramInt != 25)) {
      return this.am.k().af;
    }
    this.aQ.b();
    return false;
  }
  
  public boolean a(long paramLong, boolean paramBoolean, String paramString)
  {
    return a(paramLong, "android.permission.CAMERA", null, new DoubleVideoCtrlUI.28(this, paramLong, paramBoolean, paramString));
  }
  
  public void az_()
  {
    this.al.a(new Object[] { Integer.valueOf(126), Boolean.valueOf(true), Integer.valueOf(9) });
  }
  
  protected int b()
  {
    return 2131625721;
  }
  
  public int b(int paramInt)
  {
    a(this.al, paramInt);
    return 0;
  }
  
  public void b(long paramLong)
  {
    super.b(paramLong);
    SessionInfo localSessionInfo = this.am.k();
    boolean bool1 = localSessionInfo.j();
    boolean bool2 = false;
    Object localObject;
    if (bool1)
    {
      if (localSessionInfo.aq != 1L) {
        super.G(paramLong);
      }
      localObject = this.aR;
      if (localSessionInfo.g == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((SensorHelper)localObject).b(bool1);
    }
    q();
    DataReport.a(this.am);
    this.e = false;
    if ((this.am != null) && (localSessionInfo.bR))
    {
      this.al.a().postDelayed(new DoubleVideoCtrlUI.12(this), 200L);
    }
    else
    {
      localObject = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume, AsyncReadDoubleGlassConfig, mVideoController[");
      if (this.am != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localStringBuilder.append(bool1);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      d();
    }
    if (localSessionInfo.cv)
    {
      bool1 = bool2;
      if (localSessionInfo.cv)
      {
        bool1 = bool2;
        if (localSessionInfo.cw) {
          bool1 = true;
        }
      }
      a(paramLong, true, bool1);
      return;
    }
    if (localSessionInfo.cw) {
      e(paramLong, true);
    }
  }
  
  @TargetApi(11)
  public void b(long paramLong, int paramInt)
  {
    if ((!this.am.k().H) && (!this.am.k().I)) {
      a(paramLong, 0.0F);
    } else {
      a(paramLong, 360 - paramInt);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.ak != null)
    {
      localObject1 = localObject2;
      if (this.ak.get() != null) {
        localObject1 = (ChildLockCircle)((Activity)this.ak.get()).findViewById(2131441036);
      }
    }
    if (localObject1 != null) {
      ((ChildLockCircle)localObject1).setRotation(360 - paramInt);
    }
  }
  
  public void b(long paramLong, View paramView)
  {
    this.aA.a(paramLong, 0, false);
    paramView = U();
    if (paramView != null) {
      if (paramView.ai.b()) {
        paramView.ai.c(3);
      } else {
        paramView.ai.a(0);
      }
    }
    ChatRoomUtil.b("0X800A8D0");
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    if (this.am.k().g == 1) {
      f(paramLong, 16777215);
    }
  }
  
  public void b(String paramString) {}
  
  void b(boolean paramBoolean)
  {
    if (this.aQ != null)
    {
      this.aQ.a(paramBoolean);
      this.aQ.b();
    }
    int i1 = 2;
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = false;
    Object localObject;
    if (paramBoolean)
    {
      if (this.aA != null) {
        if ((this.am.k().p == 9500) && (!this.am.ac))
        {
          localObject = this.aA;
          if (this.am.k().g == 2) {
            paramBoolean = bool1;
          } else {
            paramBoolean = false;
          }
          ((QavPanel)localObject).a(paramBoolean, 0, false);
        }
        else
        {
          paramBoolean = bool2;
          if (this.am.k().g == 2) {
            paramBoolean = true;
          }
          localObject = this.aA;
          if (!paramBoolean) {
            i1 = 1;
          }
          ((QavPanel)localObject).a(paramBoolean, i1, true);
        }
      }
      localObject = this.f;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(this.al.getApp().getResources().getColor(2131166789));
      }
    }
    else if (this.aA != null)
    {
      if ((this.am.k().p == 9500) && (!this.am.ac))
      {
        localObject = this.aA;
        if (this.am.k().g == 2) {
          paramBoolean = bool3;
        } else {
          paramBoolean = false;
        }
        ((QavPanel)localObject).a(paramBoolean, 0, false);
        return;
      }
      if (this.am.k().g == 2) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      localObject = this.aA;
      if (!paramBoolean) {
        i1 = 1;
      }
      ((QavPanel)localObject).a(paramBoolean, i1, false);
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    long l1 = AudioHelper.c();
    Object localObject = this.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPhoneCalling, isSelf[");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if (this.am == null) {
      return;
    }
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        TipsUtil.a(this.al, 1019);
        return;
      }
      TipsUtil.b(this.al, 1019);
      if ((this.ak.get() != null) && (this.al != null))
      {
        TipsUtil.a(this.al, 1018);
        ReportController.b(null, "CliOper", "", "", "0x80060EE", "0x80060EE", 0, 0, "", "", "", "");
      }
    }
    else
    {
      localObject = this.am.k().s;
      if (paramBoolean2)
      {
        if (!this.am.k().E) {
          this.am.a(true, (String)localObject);
        }
        localObject = (ITraeMediaPlayerApi)QRoute.api(ITraeMediaPlayerApi.class);
        ((ITraeMediaPlayerApi)localObject).init((Context)this.ak.get(), null);
        if (GAudioSoundUtil.a("qav_peer_phone_calling.mp3"))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(GAudioSoundUtil.a());
          localStringBuilder.append("qav_peer_phone_calling.mp3");
          ((ITraeMediaPlayerApi)localObject).playRing(l1, 2, 0, null, localStringBuilder.toString(), false, 1, false, true, 0);
        }
        else
        {
          ((ITraeMediaPlayerApi)localObject).playRing(l1, 0, 2131230809, null, null, false, 1, false, true, 0);
          GAudioSoundUtil.a(BaseApplicationImpl.getApplication());
        }
        if (this.am.k().aK)
        {
          ReportController.b(null, "CliOper", "", "", "0x80049AA", "0x80049AA", 0, 0, "", "", "", "");
          return;
        }
        ReportController.b(null, "CliOper", "", "", "0x80049BA", "0x80049BA", 0, 0, "", "", "", "");
        return;
      }
      if (!this.am.k().E) {
        this.am.a(false, (String)localObject);
      }
    }
  }
  
  void c()
  {
    super.c();
    long l1 = AudioHelper.c();
    if (this.aA != null)
    {
      QavPanel localQavPanel = this.aA;
      int i1 = LayoutDef.a(D());
      boolean bool;
      if (this.am.k().g == 2) {
        bool = true;
      } else {
        bool = false;
      }
      localQavPanel.a(i1, bool, BeautyToolbar.checkShowBeauty(this.am, this.al));
      this.aA.d();
      this.aA.a(this.aQ);
      if (this.am.k().p == 1044) {
        this.aA.setNoVideoAndShareBtnMode();
      }
    }
    d(l1, this.am.k().g);
    this.j = ((TextView)this.an.findViewById(2131439121));
    this.h = ((TextView)this.an.findViewById(2131441305));
    this.i = ((RelativeLayout)this.an.findViewById(2131441054));
    if (AudioHelper.a(0) == 1) {
      this.i.setBackgroundColor(2147483392);
    }
    if (Build.VERSION.SDK_INT <= 20)
    {
      QLog.d(this.X, 1, "need reset quit double screen listener");
      this.h.setOnClickListener(new DoubleVideoCtrlUI.7(this));
    }
    this.aN = ((ImageView)this.an.findViewById(2131441046));
    if (this.am.k().g == 1)
    {
      if (this.aA != null) {
        this.aA.a(2131441016, this.aj.getString(2131887101));
      }
      d(l1, false);
    }
    else
    {
      if (this.aA != null) {
        this.aA.a(2131441016, this.aj.getString(2131917854));
      }
      d(l1, true);
    }
    if ((!this.am.k().O) && (this.aA != null))
    {
      this.aA.setViewEnable(2131441023, false);
      this.aA.b(2131441023, false);
    }
    c(l1, "initUI");
    this.k = new QavInOutAnimation((Context)this.ak.get(), this.am, 2, this.aA, this.aB, null, this.an.findViewById(2131441065), this.f, this.an.findViewById(2131441196), null);
    GAudioSoundUtil.a(BaseApplicationImpl.getApplication());
    if ((this.am.k().g == 1) && ((this.am.k().i == 1) || (this.am.k().i == 0))) {
      ReportController.b(null, "CliOper", "", "", "0X8009ED8", "0X8009ED8", 1, 1, "", "", "", "");
    }
  }
  
  void c(int paramInt)
  {
    if ((this.am.k().p == 1011) && (paramInt != 2131893177) && (paramInt != 2131917846)) {
      return;
    }
    if (paramInt > 0) {
      a_(-1016L, paramInt);
    }
  }
  
  public void c(long paramLong)
  {
    if ((QLog.isDevelopLevel()) || (this.bw))
    {
      String str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStop, mRequestPermissionIng[");
      localStringBuilder.append(this.bw);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    super.c(paramLong);
    if ((this.am != null) && (this.am.k().j())) {
      super.H(paramLong);
    }
  }
  
  public void c(long paramLong, int paramInt)
  {
    if (this.am == null) {
      return;
    }
    if (paramInt == 2)
    {
      if (this.am.k().H)
      {
        m(paramLong);
        this.al.a(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
        if (QLog.isColorLevel())
        {
          String str = this.X;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onDetectNoDevicePermission local close camera, remote[");
          localStringBuilder.append(this.am.k().I);
          localStringBuilder.append("]");
          QLog.w(str, 1, localStringBuilder.toString());
        }
      }
      QLog.w(this.X, 1, "onDetectNoDevicePermission, set cameraPermission = false");
      this.am.k().N = false;
      f(paramLong, 16777215);
    }
    super.c(paramLong, paramInt);
  }
  
  protected void c(long paramLong, View paramView)
  {
    paramView = SessionMgr.a().b();
    if (!WTogetherUtil.b(paramView.s))
    {
      a(2131893767, 0, this.aj.getDimensionPixelSize(2131299920));
      AVUtil.a("0X800B61C", AVUtil.c(), 0, "", "", "", "");
      return;
    }
    WTogetherRealNameVideoProcessHelper localWTogetherRealNameVideoProcessHelper = this.al.B();
    localWTogetherRealNameVideoProcessHelper.b(new DoubleVideoCtrlUI.23(this, paramLong, paramView, localWTogetherRealNameVideoProcessHelper));
  }
  
  public void c(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAfterCloseCamera, success[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    f(paramLong, 16777215);
    if (paramBoolean)
    {
      l(true);
      DataReport.d();
      DataReport.n(this.am);
      if (!this.am.k().I) {
        a("onAfterCloseCamera", 1);
      }
      if (!this.am.k().I) {
        a(paramLong, 0.0F);
      }
    }
  }
  
  public void c(String paramString)
  {
    super.c(paramString);
    this.am.k().ag = false;
    w();
  }
  
  public void c(boolean paramBoolean)
  {
    long l1 = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      String str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNotRecvAudioData, bNotRecv[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (paramBoolean) {
      this.ad = 1;
    } else {
      this.ad = 2;
    }
    if (paramBoolean)
    {
      if (this.am.g(this.am.k().s) == 5) {
        return;
      }
      TipsUtil.a(this.al, 3005);
      return;
    }
    if (this.am.g(this.am.k().s) != 5) {
      TipsUtil.b(this.al, 3005);
    }
    this.o.b(l1);
    if (this.am.k().aq != 1L) {
      super.G(l1);
    }
  }
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    g(paramBoolean2);
  }
  
  public void d()
  {
    this.al.a().postDelayed(new DoubleVideoCtrlUI.9(this), 100L);
  }
  
  public void d(int paramInt)
  {
    long l1 = AudioHelper.c();
    if ((this.am.k().g == 2) && (!this.am.k().j()))
    {
      if (!this.af) {
        f(paramInt);
      }
      return;
    }
    f(paramInt);
    I(l1);
  }
  
  public void d(long paramLong)
  {
    Object localObject = this.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDestroy, seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    localObject = this.l;
    if (localObject != null)
    {
      ((Timer)localObject).cancel();
      this.l = null;
    }
    if (this.al != null)
    {
      if (this.n != null)
      {
        this.al.removeObserver(this.n);
        this.n = null;
      }
      this.al.e("DoubleVideoCtrlUI");
      this.al.a().removeCallbacks(this.v);
      this.al.a().removeCallbacks(this.p);
      this.al.a().removeCallbacks(this.q);
      this.o.b(paramLong);
      s(true);
    }
    if (this.an != null)
    {
      localObject = (RelativeLayout)this.an.findViewById(2131432075);
      if (localObject != null) {
        ((RelativeLayout)localObject).setVisibility(8);
      }
      this.an.removeAllViews();
    }
    this.ae = false;
    this.Z = 0;
    this.ai = null;
    this.aj = null;
    this.ao = null;
    this.ar = null;
    this.aN = null;
    this.f = null;
    this.g = null;
    this.aq = null;
    localObject = this.k;
    if (localObject != null)
    {
      ((QavInOutAnimation)localObject).b();
      this.k = null;
    }
    super.d(paramLong);
  }
  
  void d(long paramLong, int paramInt)
  {
    this.g = ((ImageView)this.an.findViewById(2131441066));
    this.f = ((TextView)this.an.findViewById(2131441067));
    f(paramLong, 16777215);
    f();
  }
  
  void d(long paramLong, View paramView)
  {
    boolean bool = F();
    String str = this.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClick_Mute, micPermission[");
    localStringBuilder.append(this.am.k().O);
    localStringBuilder.append("], localMute[");
    localStringBuilder.append(this.am.k().E);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], canClick[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if ((a(paramLong, "android.permission.RECORD_AUDIO", paramView)) && (bool)) {
      a(paramLong, this.am.k().s);
    }
    super.I(paramLong);
  }
  
  void d(long paramLong, boolean paramBoolean)
  {
    boolean bool = SessionMgr.a().b().r();
    int i1;
    if (paramBoolean)
    {
      if (bool) {
        i1 = 4;
      } else {
        i1 = 2;
      }
    }
    else if (bool) {
      i1 = 3;
    } else {
      i1 = 1;
    }
    e(paramLong, i1);
  }
  
  public void d(boolean paramBoolean)
  {
    String str;
    if (QLog.isColorLevel())
    {
      str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNotifyAIDenoiseTips, isFromlocal[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (U() != null)
    {
      if (paramBoolean)
      {
        TipsUtil.a(this.al, 3016);
        str = "0X800BC07";
      }
      else
      {
        TipsUtil.a(this.al, 3014);
        str = "0X800BC08";
      }
      ReportController.b(null, "CliOper", "", "", str, str, 2, 0, "", "", "", "");
    }
  }
  
  public void d(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.aA.d(8);
    } else {
      this.aA.d(0);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2131893077));
    localArrayList.add(Integer.valueOf(2131893087));
    localArrayList.add(Integer.valueOf(2131893079));
    localArrayList.add(Integer.valueOf(2131893084));
    localArrayList.add(Integer.valueOf(2131893074));
    localArrayList.add(Integer.valueOf(2131893082));
    localArrayList.add(Integer.valueOf(2131893072));
    if (!paramBoolean2) {
      localArrayList.add(Integer.valueOf(2131893073));
    }
    int i1 = 0;
    while (i1 < this.aA.getMenuItems().size())
    {
      OperationBtnItem localOperationBtnItem = (OperationBtnItem)this.aA.getMenuItems().get(i1);
      if (localOperationBtnItem != null)
      {
        int i2 = 0;
        while (i2 < localArrayList.size())
        {
          if (localOperationBtnItem.a() == ((Integer)localArrayList.get(i2)).intValue())
          {
            i2 = 1;
            break label225;
          }
          i2 += 1;
        }
        i2 = 0;
        label225:
        if (i2 == 0)
        {
          localOperationBtnItem.a(paramBoolean1 ^ true);
          localOperationBtnItem.b(paramBoolean1);
        }
      }
      i1 += 1;
    }
    this.aA.f();
  }
  
  public void e()
  {
    super.e();
    long l1 = AudioHelper.c();
    Object localObject1 = this.am.k();
    Object localObject2 = this.X;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("avideo onCreate, state[");
    ((StringBuilder)localObject3).append(((SessionInfo)localObject1).i);
    ((StringBuilder)localObject3).append("], seq[");
    ((StringBuilder)localObject3).append(l1);
    ((StringBuilder)localObject3).append("]");
    QLog.w((String)localObject2, 1, ((StringBuilder)localObject3).toString());
    c();
    this.aQ.f();
    if (((SessionInfo)localObject1).aQ == 0) {
      ((SessionInfo)localObject1).aQ = 3;
    }
    if ((!((SessionInfo)localObject1).e()) && (!((SessionInfo)localObject1).h())) {
      break label532;
    }
    int i3 = ((SessionInfo)localObject1).aK ^ true;
    int i1;
    if (!((SessionInfo)localObject1).as) {
      i1 = 4;
    } else {
      i1 = 1;
    }
    if (1008 == ((SessionInfo)localObject1).p) {}
    while (1044 == ((SessionInfo)localObject1).p)
    {
      i1 = 4;
      break;
    }
    if (((SessionInfo)localObject1).B)
    {
      i1 = this.am.a(l1, ((SessionInfo)localObject1).s, i3, i1);
    }
    else
    {
      localObject2 = this.am.aG();
      if (localObject2 != null)
      {
        int i2;
        if (i1 == 1) {
          i2 = 3;
        } else {
          i2 = 0;
        }
        localObject3 = ((SessionInfo)localObject1).s;
        if (((WTogetherMng)this.al.c(17)).b(i2, (String)localObject3)) {
          ((JniSimpleInfoMng)localObject2).a((String)localObject3, 1, false);
        } else {
          ((JniSimpleInfoMng)localObject2).a((String)localObject3, 0, false);
        }
      }
      i1 = this.am.a(l1, ((SessionInfo)localObject1).s, i3, i1, ((SessionInfo)localObject1).x, ((SessionInfo)localObject1).y, ((SessionInfo)localObject1).w, ((SessionInfo)localObject1).p, ((SessionInfo)localObject1).u, ((SessionInfo)localObject1).v, ((SessionInfo)localObject1).aH, null, null, 0, 0, null, null);
    }
    if (QLog.isColorLevel())
    {
      localObject2 = this.X;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("result = ");
      ((StringBuilder)localObject3).append(i1);
      QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
    }
    if (i1 != 0)
    {
      localObject2 = this.X;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("Video connect fail:");
      ((StringBuilder)localObject3).append(i1);
      AVLog.printAllUserLog((String)localObject2, ((StringBuilder)localObject3).toString());
      if (i1 == -2)
      {
        this.am.a(((SessionInfo)localObject1).s, 238);
        this.am.b(238);
        this.am.b(((SessionInfo)localObject1).s, 9);
      }
      this.b = true;
      if (this.ak.get() != null)
      {
        localObject1 = (Activity)this.ak.get();
        if (localObject1 != null) {
          ((Activity)localObject1).finish();
        }
      }
      return;
    }
    label532:
    if (QLog.isColorLevel())
    {
      localObject2 = this.X;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("onCreate, ofter Request, state[");
      ((StringBuilder)localObject3).append(((SessionInfo)localObject1).i);
      ((StringBuilder)localObject3).append("], SessionType[");
      ((StringBuilder)localObject3).append(((SessionInfo)localObject1).g);
      ((StringBuilder)localObject3).append("], deviceName[");
      ((StringBuilder)localObject3).append(((SessionInfo)localObject1).aD);
      ((StringBuilder)localObject3).append("], seq[");
      ((StringBuilder)localObject3).append(l1);
      ((StringBuilder)localObject3).append("]");
      QLog.w((String)localObject2, 1, ((StringBuilder)localObject3).toString());
    }
    if (((SessionInfo)localObject1).f())
    {
      if (((SessionInfo)localObject1).g == 1) {
        this.ah = "DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;";
      } else {
        this.ah = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;";
      }
      this.aQ.a(this.ah);
    }
    if (((SessionInfo)localObject1).j())
    {
      if ((!this.am.y()) && (this.am.z() >= 2L) && (!((SessionInfo)localObject1).F) && (this.am.g(((SessionInfo)localObject1).s) == 5)) {
        DataReport.f(this.am);
      }
      if (((SessionInfo)localObject1).g == 2) {
        d(l1, true);
      }
      i1 = ((SessionInfo)localObject1).p;
      localObject2 = ((SessionInfo)localObject1).s;
      this.al.b(i1, (String)localObject2);
    }
    else if (((SessionInfo)localObject1).i())
    {
      if (((SessionInfo)localObject1).aK) {
        i1 = 2131893262;
      } else {
        i1 = 2131917920;
      }
      c(i1);
    }
    else if (((SessionInfo)localObject1).f())
    {
      i1 = 2131893616;
      if (((SessionInfo)localObject1).br) {
        i1 = 2131893617;
      }
      if (((SessionInfo)localObject1).p == 1011) {
        i1 = 2131893177;
      }
      if (((SessionInfo)localObject1).aK)
      {
        localObject2 = this.X;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("Inviting, remotePhoneState[");
        ((StringBuilder)localObject3).append(((SessionInfo)localObject1).W);
        ((StringBuilder)localObject3).append("], isPeerNetworkWell[");
        ((StringBuilder)localObject3).append(((SessionInfo)localObject1).P);
        ((StringBuilder)localObject3).append("], remoteOnline[");
        ((StringBuilder)localObject3).append(((SessionInfo)localObject1).Q);
        ((StringBuilder)localObject3).append("], remoteTerminal[");
        ((StringBuilder)localObject3).append(((SessionInfo)localObject1).K);
        ((StringBuilder)localObject3).append("]");
        QLog.w((String)localObject2, 1, ((StringBuilder)localObject3).toString());
        if ((((SessionInfo)localObject1).W == 0) && (((SessionInfo)localObject1).P) && (((SessionInfo)localObject1).K != 2) && (((SessionInfo)localObject1).g == 1)) {
          TipsUtil.a(this.al, 1038);
        }
      }
      c(i1);
      i1 = ((SessionInfo)localObject1).p;
      localObject2 = ((SessionInfo)localObject1).s;
      this.al.b(i1, (String)localObject2);
      i1 = ((SessionInfo)localObject1).W;
      if ((i1 == 4) && (((SessionInfo)localObject1).U == 1) && (((SessionInfo)localObject1).V == 0)) {
        a(i1);
      }
      if ((i1 > 0) && (i1 != 3))
      {
        a(i1);
        DataReport.e(this.am);
      }
    }
    else if (((SessionInfo)localObject1).h())
    {
      c(2131893456);
    }
    else if ((((SessionInfo)localObject1).m()) || (((SessionInfo)localObject1).n()))
    {
      l(((SessionInfo)localObject1).ay);
      if (((SessionInfo)localObject1).p == 1011) {
        c(2131893587);
      }
      this.al.a().postDelayed(new DoubleVideoCtrlUI.10(this, l1), 150L);
    }
    if (this.n == null)
    {
      this.n = new DavWTogetherObserver(this);
      this.al.addObserver(this.n);
    }
    if (((SessionInfo)localObject1).M) {
      q();
    }
    if (((SessionInfo)localObject1).aK)
    {
      this.aR.c(true);
      this.aR.c(true);
    }
    if (((SessionInfo)localObject1).E)
    {
      super.m(2131441023);
      if ((this.ak.get() != null) && (this.aA != null)) {
        this.aA.a(2131441023, ((Context)this.ak.get()).getResources().getString(2131887103));
      }
    }
    else
    {
      super.n(2131441023);
      if ((this.ak.get() != null) && (this.aA != null)) {
        this.aA.a(2131441023, ((Context)this.ak.get()).getResources().getString(2131887090));
      }
    }
    a(l1, false);
    this.an.post(new DoubleVideoCtrlUI.11(this));
    localObject1 = this.k;
    if (localObject1 != null) {
      ((QavInOutAnimation)localObject1).a();
    }
  }
  
  public void e(int paramInt)
  {
    if (1 == paramInt)
    {
      if (!this.e)
      {
        t();
        this.al.a().removeCallbacks(this.t);
      }
    }
    else
    {
      if (paramInt == 0)
      {
        u();
        this.al.a().removeCallbacks(this.t);
        return;
      }
      if (2 == paramInt) {
        return;
      }
      Object localObject;
      if (3 == paramInt)
      {
        localObject = G();
        if ((this.am != null) && (this.am.k().ah == 2) && (localObject != null) && (((ChildLockSign)localObject).isEnabled()))
        {
          if (((ChildLockSign)localObject).getVisibility() != 0)
          {
            ((ChildLockSign)localObject).setLocked(true);
            ((ChildLockSign)localObject).setVisibility(0);
            v();
            return;
          }
          ((ChildLockSign)localObject).setVisibility(8);
          this.al.a().removeCallbacks(this.u);
        }
      }
      else if ((4 == paramInt) && (this.ak != null) && (this.ak.get() != null))
      {
        localObject = (ChildLockCircle)((Activity)this.ak.get()).findViewById(2131441036);
      }
    }
  }
  
  public void e(long paramLong)
  {
    SessionInfo localSessionInfo = this.am.k();
    long l1 = this.am.p(localSessionInfo.s);
    Object localObject1 = this.X;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onConnected, roomid[");
    ((StringBuilder)localObject2).append(l1);
    ((StringBuilder)localObject2).append("], mNeedRemoveAudioCallback[");
    ((StringBuilder)localObject2).append(this.d);
    ((StringBuilder)localObject2).append("], seq[");
    ((StringBuilder)localObject2).append(paramLong);
    ((StringBuilder)localObject2).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    super.e(paramLong);
    n(paramLong);
    if (l1 > 0L) {
      ((VideoNodeReporter)this.al.c(4)).a(l1, 26, l1);
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(l1);
    ((StringBuilder)localObject1).append("");
    localObject1 = ((StringBuilder)localObject1).toString();
    int i1 = localSessionInfo.g;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("");
    VoiceChangeDataReport.a(i1, ((StringBuilder)localObject2).toString());
    if (localSessionInfo.k != 4) {
      a_(paramLong, 2131893251);
    }
    TipsUtil.b(this.al, 1038);
    TipsUtil.b(this.al, 1050);
    TipsUtil.b(this.al, 1049);
    if (!localSessionInfo.B)
    {
      if (localSessionInfo.aG) {
        ReportController.b(null, "CliOper", "", "", "Two_call", "Two_launch_HF_result", 0, 0, "0", "", "", "");
      } else {
        ReportController.b(null, "CliOper", "", "", "Two_call", "Two_launch_HF_result", 0, 0, "1", "", "", "");
      }
      if (localSessionInfo.E) {
        ReportController.b(null, "CliOper", "", "", "Two_call", "Two_launch_mute_result", 0, 0, "0", "", "", "");
      } else {
        ReportController.b(null, "CliOper", "", "", "Two_call", "Two_launch_mute_result", 0, 0, "1", "", "", "");
      }
      DataReport.a(this.am);
    }
    if (localSessionInfo.g == 2) {
      d(paramLong, true);
    } else {
      l(true);
    }
    a(paramLong, true);
    localObject1 = localSessionInfo.s;
    i1 = this.am.g((String)localObject1);
    int i2 = this.am.i((String)localObject1);
    if (i1 == 5)
    {
      if (localSessionInfo.bw) {
        super.G(paramLong);
      } else {
        this.o.a(paramLong);
      }
    }
    else if (!this.am.m())
    {
      if (localSessionInfo.bw) {
        super.G(paramLong);
      } else {
        this.o.a(paramLong);
      }
    }
    else if (!localSessionInfo.j()) {
      this.o.a(paramLong);
    } else if (i2 > 18)
    {
      if ((localSessionInfo.bw) && (localSessionInfo.bx)) {
        super.G(paramLong);
      } else {
        this.o.a(paramLong);
      }
    }
    else if (localSessionInfo.bw) {
      super.G(paramLong);
    } else {
      this.o.a(paramLong);
    }
    localObject2 = this.aR;
    boolean bool;
    if (localSessionInfo.g == 1) {
      bool = true;
    } else {
      bool = false;
    }
    ((SensorHelper)localObject2).b(bool);
    i1 = localSessionInfo.p;
    this.al.b(i1, (String)localObject1);
    this.al.a(new Object[] { Integer.valueOf(102) });
    if (this.aO != null)
    {
      this.aO.c();
      this.aO.e();
      this.aO.a();
      this.aO = null;
    }
    if (localSessionInfo.M) {
      this.al.a().removeCallbacks(this.bg);
    }
    if (localSessionInfo.g == 2)
    {
      QLog.w(this.X, 1, "onConnected, CheckRemoteCameraRunnable");
      this.al.a().removeCallbacks(this.v);
      this.al.a().postDelayed(this.v, 5000L);
    }
    if ((localSessionInfo.M) && (!localSessionInfo.I)) {
      a("onConnected", 1);
    }
  }
  
  public void e(long paramLong, int paramInt)
  {
    if (V()) {
      return;
    }
    boolean bool = AVUtil.g(paramInt);
    Object localObject;
    if (this.x != paramInt)
    {
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("changeUIMode, [");
        ((StringBuilder)localObject).append(this.x);
        ((StringBuilder)localObject).append("-->");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("], isVideo[");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append("]");
        QLog.i("WTogether", 4, ((StringBuilder)localObject).toString());
      }
      this.x = paramInt;
    }
    if ((this.am.k().p == 9500) && (!this.am.ac))
    {
      this.aA.a(bool, 0, false);
      if (this.aQ != null) {
        this.aQ.b();
      }
    }
    else
    {
      f(-1014L, 16777215);
    }
    if ((this.ak.get() instanceof AVActivity))
    {
      localObject = (AVActivity)this.ak.get();
      ((AVActivity)localObject).b(bool ^ true);
      ((AVActivity)localObject).f(bool ^ true);
      ((AVActivity)localObject).c(bool);
    }
    if ((paramInt != 2) && (paramInt != 3) && (paramInt != 4))
    {
      if (paramInt == 1)
      {
        localObject = this.g;
        if (localObject != null) {
          ((ImageView)localObject).setVisibility(0);
        }
        localObject = this.f;
        if (localObject != null) {
          ((TextView)localObject).setVisibility(0);
        }
        if (this.aE != null) {
          this.aE.a(0);
        }
        g(paramLong, 0);
        h(paramLong, 8);
        this.az.setVisibility(8);
        this.ax.setVisibility(8);
      }
    }
    else
    {
      localObject = this.g;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
      localObject = this.f;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      if (this.aE != null) {
        this.aE.a(8);
      }
      g(paramLong, 8);
      if (paramInt == 2)
      {
        this.ax.setVisibility(0);
        h(paramLong, 0);
        this.az.setVisibility(0);
      }
      else
      {
        h(paramLong, 8);
        this.az.setVisibility(8);
      }
    }
    a(Boolean.valueOf(bool));
  }
  
  void e(long paramLong, View paramView)
  {
    Object localObject1 = new ControlUIObserver.CPreEventInfo(paramView);
    Boolean localBoolean = Boolean.valueOf(false);
    if (paramView != null) {
      this.al.a(new Object[] { Integer.valueOf(9001), localObject1 });
    }
    Object localObject2;
    if (((ControlUIObserver.CPreEventInfo)localObject1).d)
    {
      paramView = this.X;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onClick_Camera, mBlockName[");
      ((StringBuilder)localObject2).append(((ControlUIObserver.CPreEventInfo)localObject1).e);
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("]");
      QLog.w(paramView, 1, ((StringBuilder)localObject2).toString());
    }
    else if (a(paramLong, "android.permission.CAMERA", paramView))
    {
      localObject2 = this.am.k();
      DataReport.h(this.am);
      if (((SessionInfo)localObject2).g == 1)
      {
        VideoViewInfo localVideoViewInfo = new VideoViewInfo();
        localObject1 = ((SessionInfo)localObject2).s;
        paramView = (View)localObject1;
        if (((String)localObject1).startsWith("+")) {
          paramView = ((String)localObject1).substring(1);
        }
        localVideoViewInfo.a = CharacterUtil.b(paramView);
        localVideoViewInfo.b = 1;
        paramView = new ArrayList();
        paramView.add(localVideoViewInfo);
        if (!((SessionInfo)localObject2).cw) {
          this.al.a(new Object[] { Integer.valueOf(104), paramView });
        }
        l(paramLong);
        this.al.a(new Object[] { Integer.valueOf(105), localBoolean, Long.valueOf(paramLong) });
        if (QLog.isColorLevel())
        {
          paramView = this.X;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onClick_Camera, open1, seq[");
          ((StringBuilder)localObject1).append(paramLong);
          ((StringBuilder)localObject1).append("]");
          QLog.w(paramView, 1, ((StringBuilder)localObject1).toString());
        }
        ReportController.b(null, "CliOper", "", "", "0X8005611", "0X8005611", 0, 0, "", "", "", "");
        if (((SessionInfo)localObject2).ag) {
          this.al.a().postDelayed(new DoubleVideoCtrlUI.24(this), 500L);
        }
        if (((SessionInfo)localObject2).r()) {
          AVUtil.a("0X800B637", 0, 0, "", "", "", "");
        }
      }
      else if (((SessionInfo)localObject2).g == 2)
      {
        if (((SessionInfo)localObject2).H)
        {
          m(paramLong);
          this.al.a(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
          if (QLog.isColorLevel())
          {
            paramView = this.X;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("onClick_Camera, close, seq[");
            ((StringBuilder)localObject1).append(paramLong);
            ((StringBuilder)localObject1).append("]");
            QLog.w(paramView, 1, ((StringBuilder)localObject1).toString());
          }
          if (((SessionInfo)localObject2).r()) {
            AVUtil.a("0X800B638", 0, 0, "", "", "", "");
          }
        }
        else
        {
          l(paramLong);
          this.al.a(new Object[] { Integer.valueOf(105), localBoolean, Long.valueOf(paramLong) });
          if (QLog.isColorLevel())
          {
            paramView = this.X;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("onClick_Camera, open2, seq[");
            ((StringBuilder)localObject1).append(paramLong);
            ((StringBuilder)localObject1).append("]");
            QLog.w(paramView, 1, ((StringBuilder)localObject1).toString());
          }
          if (((SessionInfo)localObject2).r()) {
            AVUtil.a("0X800B637", 0, 0, "", "", "", "");
          }
        }
      }
    }
    i(paramLong, 2131893073);
  }
  
  public void e(long paramLong, boolean paramBoolean)
  {
    this.bd = paramBoolean;
    v(paramBoolean);
    int i1;
    if ((this.bd) && (this.bc)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    QavPanel localQavPanel = this.aA;
    if (i1 != 0) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localQavPanel.setViewVisibility(2131441301, i1);
    if (!this.bc)
    {
      d(paramBoolean, false);
      b_(AudioHelper.c());
    }
    J();
  }
  
  public void e(boolean paramBoolean)
  {
    if (!this.am.k().af)
    {
      this.am.k().af = true;
      if (this.af)
      {
        f(0);
        H();
      }
      this.al.a(new Object[] { Integer.valueOf(167), Boolean.valueOf(true) });
    }
  }
  
  void f()
  {
    if (((this.am.k().p == 21) || (this.am.k().p == 1011)) && (this.aA != null))
    {
      this.aA.setViewVisibility(2131441304, 8);
      this.aA.setViewVisibility(2131441310, 8);
      AVActivity localAVActivity = U();
      if (localAVActivity != null) {
        localAVActivity.a(false);
      }
    }
  }
  
  public void f(int paramInt)
  {
    super.f(paramInt);
  }
  
  public void f(long paramLong)
  {
    Object localObject2 = (Context)this.ak.get();
    OperationBtnItem localOperationBtnItem = a(2131893088, paramLong);
    if (localOperationBtnItem != null)
    {
      if (localObject2 == null) {
        return;
      }
      Object localObject1 = SessionMgr.a().b();
      if (!((SessionInfo)localObject1).j())
      {
        localOperationBtnItem.c(false);
        return;
      }
      boolean bool1 = QAVConfigUtils.r();
      localOperationBtnItem.c(bool1);
      if (bool1)
      {
        localObject1 = ((WTogetherMng)this.al.c(17)).b((SessionInfo)localObject1);
        if (localObject1 == null) {
          localObject1 = null;
        } else {
          localObject1 = ((WatchTogetherInfo)localObject1).g;
        }
        boolean bool3 = true;
        if ((localObject1 != null) && (((WTogetherRoom)localObject1).e() != 0)) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        boolean bool2 = bool3;
        if (bool1) {
          if (((WTogetherRoom)localObject1).i()) {
            bool2 = bool3;
          } else {
            bool2 = false;
          }
        }
        if (bool1) {
          localOperationBtnItem.a(((Context)localObject2).getResources().getString(2131893089));
        } else {
          localOperationBtnItem.a(((Context)localObject2).getResources().getString(2131893088));
        }
        localOperationBtnItem.a(bool2);
        localOperationBtnItem.b(bool2 ^ true);
        if (QLog.isColorLevel())
        {
          localObject1 = this.X;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("updateBtn_WatchTogether, watching[");
          ((StringBuilder)localObject2).append(bool1);
          ((StringBuilder)localObject2).append("], enable[");
          ((StringBuilder)localObject2).append(bool2);
          ((StringBuilder)localObject2).append("]");
          QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.i(this.X, 2, "updateBtn_WatchTogether, entry close.");
      }
    }
  }
  
  public void f(long paramLong, View paramView)
  {
    if (this.am != null)
    {
      if (Math.abs(SystemClock.elapsedRealtime() - this.s) < 1000L) {
        return;
      }
      paramView = this.am.aF();
      if (paramView == null) {
        return;
      }
      this.s = SystemClock.elapsedRealtime();
      i(paramLong, 2131893080);
      paramView.a(paramLong);
    }
  }
  
  public void g()
  {
    super.g();
    this.e = true;
    E();
    u();
  }
  
  protected void g(long paramLong)
  {
    if (a(paramLong, "android.permission.WRITE_EXTERNAL_STORAGE", null))
    {
      this.r.a(paramLong, this.al, U());
      f(paramLong, 16777215);
      i(paramLong, 2131893079);
      str = this.X;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClick_Record, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("] has Permission");
      QLog.w(str, 1, localStringBuilder.toString());
      return;
    }
    String str = this.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClick_Record, seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("] has not Permission");
    QLog.w(str, 1, localStringBuilder.toString());
  }
  
  public boolean g(int paramInt)
  {
    if (this.am == null) {
      return false;
    }
    Object localObject1 = this.am.k();
    if (localObject1 == null) {
      return false;
    }
    if (!((SessionInfo)localObject1).bR) {
      return false;
    }
    Object localObject2;
    if (!((SessionInfo)localObject1).I)
    {
      localObject1 = this.X;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("setGlassSwitch, Remote not has video, GlassSwitch[");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return false;
    }
    if ((QLog.isDevelopLevel()) || (((SessionInfo)localObject1).bS != paramInt))
    {
      localObject2 = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setGlassSwitch, GlassSwitch[");
      localStringBuilder.append(((SessionInfo)localObject1).bS);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.w((String)localObject2, 1, localStringBuilder.toString());
    }
    if (((SessionInfo)localObject1).bS == paramInt) {
      return false;
    }
    ((SessionInfo)localObject1).bS = paramInt;
    if (this.ak != null)
    {
      if (this.ak.get() == null) {
        return false;
      }
      localObject1 = (AVActivity)this.ak.get();
      if (localObject1 != null)
      {
        if (((AVActivity)localObject1).L == null) {
          return false;
        }
        if (paramInt != 0)
        {
          if (paramInt != 1)
          {
            if (paramInt != 2)
            {
              if (paramInt != 3) {
                return true;
              }
              ((AVActivity)localObject1).L.aa();
              TipsUtil.a(this.al, 1039);
              return true;
            }
            ((AVActivity)localObject1).L.ab();
            TipsUtil.b(this.al, 3011);
            return true;
          }
          ((AVActivity)localObject1).L.aa();
          TipsUtil.a(this.al, 3011);
          return true;
        }
        ((AVActivity)localObject1).L.ab();
        TipsUtil.b(this.al, 3011);
        return true;
      }
    }
    return false;
  }
  
  public void h()
  {
    if (this.am.k().f())
    {
      int i1 = this.am.k().p;
      String str = this.am.k().s;
      this.al.b(i1, str);
    }
  }
  
  public void h(int paramInt)
  {
    SessionInfo localSessionInfo = this.am.k();
    if (paramInt != localSessionInfo.bT)
    {
      String str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setGlassWaitTime, WaitTime[");
      localStringBuilder.append(localSessionInfo.bT);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    localSessionInfo.bT = paramInt;
  }
  
  protected void h(long paramLong)
  {
    String str = this.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClick_AIDenoise, seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    boolean bool = SharedPreUtils.c() ^ true;
    k(bool);
    SharedPreUtils.b(bool);
    this.am.l(bool);
    f(paramLong, 16777215);
    DataReport.b(this.am, bool);
  }
  
  @TargetApi(11)
  public void i()
  {
    long l1 = AudioHelper.c();
    String str = this.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPauseVideo, seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (!this.am.k().H)
    {
      a("onPauseVideo", 1);
      w();
    }
    else
    {
      this.am.k().bS = 0;
    }
    if ((!this.am.k().H) && (!this.bd))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.X, 2, "onResumeVideo setRotation");
      }
      a(l1, 0.0F);
    }
  }
  
  public void i(long paramLong)
  {
    if (V()) {
      return;
    }
    SessionInfo localSessionInfo = this.am.k();
    OperationBtnItem localOperationBtnItem = this.aA.c(2131893083);
    if (localOperationBtnItem == null) {
      return;
    }
    boolean bool2 = localSessionInfo.r();
    boolean bool1 = false;
    if (!bool2) {
      if ((QAVConfigUtils.e()) && (this.am.k().j()) && (this.am.k().H) && (this.am.k().I))
      {
        bool1 = true;
      }
      else
      {
        String str = this.X;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateBtn_Sharpness. no show. isDoubleVideoSharpnessEnable = ");
        localStringBuilder.append(QAVConfigUtils.e());
        QLog.d(str, 2, localStringBuilder.toString());
      }
    }
    if (localOperationBtnItem != null)
    {
      int i2 = localSessionInfo.ai;
      int i1 = 2130843310;
      if (i2 != 0) {
        if (localSessionInfo.ai == 1) {
          i1 = 2130843311;
        } else if (localSessionInfo.ai == 2) {
          i1 = 2130843313;
        } else if (localSessionInfo.ai == 3) {
          i1 = 2130843312;
        }
      }
      localOperationBtnItem.a(i1);
      localOperationBtnItem.c(bool1);
    }
  }
  
  public void j()
  {
    long l1 = AudioHelper.c();
    String str = this.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onResumeVideo, SessionType[");
    localStringBuilder.append(this.am.k().g);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.d(str, 1, localStringBuilder.toString());
    if (Utils.a(this.al.getApp()) == 1)
    {
      TipsUtil.a(this.al, 1012, this.al.getApp().getString(2131917890));
      ReportController.b(null, "CliOper", "", "", "0X8004E94", "0X8004E94", 0, 0, "", "", "", "");
      ReportController.b(null, "CliOper", "", "", "0X8005614", "0X8005614", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X8005613", "0X8005613", 0, 0, "", "", "", "");
    if (this.am.k().g == 1)
    {
      this.am.k().a(l1, "onResumeVideo", 2);
      a("onResumeVideo", 2);
      ThreadManager.excute(new DoubleVideoCtrlUI.14(this, l1), 16, null, false);
      if (this.am.k().ag) {
        e(true);
      }
    }
    else
    {
      f(l1, 16777215);
    }
    I(l1);
  }
  
  public void j(long paramLong)
  {
    if (V()) {
      return;
    }
    Object localObject1 = this.aA.c(2131893079);
    if (localObject1 == null)
    {
      if (bv)
      {
        localObject1 = this.X;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("updateBtn_Record, null, seq[");
        ((StringBuilder)localObject2).append(paramLong);
        ((StringBuilder)localObject2).append("]");
        QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      }
      return;
    }
    Object localObject2 = this.am.k();
    int i1 = ((SessionInfo)localObject2).g;
    boolean bool2 = false;
    Object localObject3;
    boolean bool1;
    if ((i1 != 3) && (((SessionInfo)localObject2).g != 4) && (((SessionInfo)localObject2).g != 1))
    {
      localObject3 = U();
      if (((AVActivity)localObject3).ad == null)
      {
        bool1 = bool2;
        if (bv)
        {
          localObject2 = this.X;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("updateBtn_Record, !mRecordUiCtrl, seq[");
          ((StringBuilder)localObject3).append(paramLong);
          ((StringBuilder)localObject3).append("]");
          QLog.w((String)localObject2, 1, ((StringBuilder)localObject3).toString());
          bool1 = bool2;
        }
      }
      else if (!((AVActivity)localObject3).ad.x())
      {
        bool1 = bool2;
        if (bv)
        {
          localObject2 = this.X;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("updateBtn_Record, !isEnableRecord, seq[");
          ((StringBuilder)localObject3).append(paramLong);
          ((StringBuilder)localObject3).append("]");
          QLog.w((String)localObject2, 1, ((StringBuilder)localObject3).toString());
          bool1 = bool2;
        }
      }
      else if (((((SessionInfo)localObject2).H) && (((SessionInfo)localObject2).I)) || ((((SessionInfo)localObject2).cv) && (!((SessionInfo)localObject2).cx)) || ((((SessionInfo)localObject2).cw) && (!((SessionInfo)localObject2).cy)))
      {
        if (((SessionInfo)localObject2).r())
        {
          bool1 = bool2;
          if (bv)
          {
            QLog.w(this.X, 2, "updateBtn_Record, in watch together mode.");
            bool1 = bool2;
          }
        }
        else
        {
          bool1 = true;
        }
      }
      else
      {
        bool1 = bool2;
        if (bv)
        {
          localObject3 = this.X;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("updateBtn_Record, sessionInfo.localHasVideo, seq[");
          localStringBuilder.append(((SessionInfo)localObject2).H);
          localStringBuilder.append("][sessionInfo.remoteHasVideo=");
          localStringBuilder.append(((SessionInfo)localObject2).I);
          localStringBuilder.append("]");
          QLog.w((String)localObject3, 1, localStringBuilder.toString());
          bool1 = bool2;
        }
      }
    }
    else
    {
      bool1 = bool2;
      if (bv)
      {
        localObject2 = this.X;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("updateBtn_Record, 场景不支持, seq[");
        ((StringBuilder)localObject3).append(paramLong);
        ((StringBuilder)localObject3).append("]");
        QLog.w((String)localObject2, 1, ((StringBuilder)localObject3).toString());
        bool1 = bool2;
      }
    }
    ((OperationBtnItem)localObject1).a(DoubleVideoCtrlUI.RecordInfo.a(this.r));
    ((OperationBtnItem)localObject1).c(bool1);
  }
  
  public void k() {}
  
  void k(long paramLong)
  {
    if (V()) {
      return;
    }
    QavPanel localQavPanel = this.aA;
    int i1;
    if (this.bc) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localQavPanel.setViewVisibility(2131441306, i1);
    if (!this.bc) {
      return;
    }
    if (DoubleVideoCtrlUI.RecordInfo.a(this.r) != 2130843215)
    {
      this.aA.setImgBtnDrawable(2131441306, DoubleVideoCtrlUI.RecordInfo.a(this.r));
      return;
    }
    this.aA.setImgBtnDrawable(2131441306, 2130843017);
  }
  
  public void l()
  {
    if (Utils.a(this.al.getApp()) == 1)
    {
      this.a = true;
      return;
    }
    long l1 = AudioHelper.c();
    String str = this.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNeedShowPeerVideo, CheckRemoteCameraRunnable stop, shutCameraAnswer[");
    localStringBuilder.append(this.am.k().M);
    localStringBuilder.append(", seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.d(str, 1, localStringBuilder.toString());
    this.al.a().removeCallbacks(this.v);
    if (this.am.k().M)
    {
      a("onNeedShowPeerVideo.1", 2);
      f(l1, 16777215);
    }
    if (this.am.k().g == 1)
    {
      this.am.k().a(l1, "onNeedShowPeerVideo.2", 2);
      a("onNeedShowPeerVideo.2", 2);
    }
    this.a = true;
  }
  
  public void l(long paramLong)
  {
    f(paramLong, 16777215);
  }
  
  void m()
  {
    aa();
    this.aA.a(this.ar);
  }
  
  public void m(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      String str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBeforeCloseCamera, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    f(paramLong, 16777215);
  }
  
  void n()
  {
    i(true);
    QavInOutAnimation localQavInOutAnimation = this.k;
    if (localQavInOutAnimation != null) {
      localQavInOutAnimation.a(new DoubleVideoCtrlUI.15(this));
    }
  }
  
  public void n(long paramLong)
  {
    if (!this.am.k().j())
    {
      OperationBtnItem localOperationBtnItem = this.aA.c(2131893080);
      if (localOperationBtnItem != null) {
        localOperationBtnItem.c(false);
      }
      return;
    }
    super.n(paramLong);
  }
  
  public boolean o()
  {
    long l1 = AudioHelper.c();
    Object localObject1 = this.am.k();
    Object localObject2 = this.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onBackPressed, seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("], isChildLock[");
    localStringBuilder.append(((SessionInfo)localObject1).af);
    localStringBuilder.append("]");
    QLog.w((String)localObject2, 1, localStringBuilder.toString());
    if (((SessionInfo)localObject1).af) {
      return true;
    }
    if (super.o())
    {
      localObject1 = this.X;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onBackPressed called return 2, seq[");
      ((StringBuilder)localObject2).append(l1);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return true;
    }
    E();
    localObject2 = ((SessionInfo)localObject1).s;
    this.al.a(new Object[] { Integer.valueOf(28), localObject2, Boolean.valueOf(false) });
    if ((!SmallScreenUtils.g()) && (((SessionInfo)localObject1).g == 2) && (((SessionInfo)localObject1).H)) {
      a(2131893252, 1, this.aj.getDimensionPixelSize(2131299920));
    }
    if ((((SessionInfo)localObject1).m()) || (((SessionInfo)localObject1).n()))
    {
      l(((SessionInfo)localObject1).ay);
      this.al.a().postDelayed(new DoubleVideoCtrlUI.16(this, l1), 150L);
    }
    if (SmallScreenUtils.g())
    {
      localObject1 = (Context)this.ak.get();
      if ((localObject1 != null) && ((localObject1 instanceof AVActivity)))
      {
        localObject1 = (AVActivity)localObject1;
        if (localObject1 != null)
        {
          localObject1 = ((AVActivity)localObject1).o();
          if (localObject1 != null) {
            ((SmallScreenActivityPlugin)localObject1).a();
          }
        }
      }
    }
    return false;
  }
  
  public boolean o(long paramLong)
  {
    if (D()) {
      return Y(paramLong);
    }
    return Z(paramLong);
  }
  
  public void p()
  {
    this.r.a();
    f(-1027L, 16777215);
  }
  
  public void q()
  {
    if (V()) {
      return;
    }
    Object localObject3 = this.am.k();
    long l1 = AudioHelper.c();
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = this.X;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("refreshUI, SessionType[");
      ((StringBuilder)localObject2).append(((SessionInfo)localObject3).g);
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(l1);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    int i1 = ((SessionInfo)localObject3).p;
    String str1 = ((SessionInfo)localObject3).s;
    String str2 = ((SessionInfo)localObject3).u;
    Object localObject2 = ((SessionInfo)localObject3).t;
    if (((SessionInfo)localObject3).B)
    {
      localObject2 = this.al.a(i1, str1, str2);
      ((SessionInfo)localObject3).t = ((String)localObject2);
    }
    if (this.g == null) {
      this.g = ((ImageView)this.an.findViewById(2131441066));
    }
    if (this.f == null) {
      this.f = ((TextView)this.an.findViewById(2131441067));
    }
    if (this.j == null)
    {
      this.j = ((TextView)this.an.findViewById(2131439121));
      if (((SessionInfo)localObject3).g == 2) {
        d(l1, true);
      } else {
        d(l1, false);
      }
    }
    if (((SessionInfo)localObject3).g == 2) {
      d(l1, true);
    } else if (((SessionInfo)localObject3).g == 1) {
      b(false);
    }
    Bitmap localBitmap = null;
    if (((SessionInfo)localObject3).p == 25)
    {
      localObject1 = ((SessionInfo)localObject3).w;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = ((SessionInfo)localObject3).u;
      }
      String str3 = this.al.a(i1, str1, (String)localObject2);
      localBitmap = this.al.a(i1, str1, (String)localObject2, true, true);
      if ((str3.equals(((SessionInfo)localObject3).s)) && (localObject2 != null))
      {
        localObject1 = this.f;
        if (localObject1 != null) {
          ((TextView)localObject1).setText((CharSequence)localObject2);
        }
        localObject3 = this.j;
        localObject1 = localBitmap;
        if (localObject3 != null)
        {
          ((TextView)localObject3).setText((CharSequence)localObject2);
          localObject1 = localBitmap;
        }
      }
      else
      {
        localObject1 = this.f;
        if (localObject1 != null) {
          ((TextView)localObject1).setText(str3);
        }
        localObject2 = this.j;
        localObject1 = localBitmap;
        if (localObject2 != null)
        {
          ((TextView)localObject2).setText(str3);
          localObject1 = localBitmap;
        }
      }
    }
    else
    {
      localObject1 = this.f;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)localObject2);
      }
      localObject3 = this.j;
      localObject1 = localBitmap;
      if (localObject3 != null)
      {
        ((TextView)localObject3).setText((CharSequence)localObject2);
        localObject1 = localBitmap;
      }
    }
    localObject2 = new AvatarParam(i1, str1, str2, true);
    this.m.a(this.al, this.g, (AvatarParam)localObject2, (Bitmap)localObject1);
    f(l1, 16777215);
  }
  
  protected boolean r()
  {
    if (this.am == null) {
      return false;
    }
    return this.am.k().j();
  }
  
  ChildLockCircle s()
  {
    Object localObject1;
    if ((this.ak != null) && (this.ak.get() != null))
    {
      Object localObject3 = (Activity)this.ak.get();
      Object localObject2 = (ChildLockCircle)((Activity)localObject3).findViewById(2131441036);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ChildLockCircle((Context)localObject3);
        localObject2 = (ViewGroup)((Activity)localObject3).findViewById(2131432075);
        localObject3 = ((ViewGroup)localObject2).getResources();
        int i1 = ((Resources)localObject3).getDimensionPixelOffset(2131298375);
        int i2 = ((Resources)localObject3).getDimensionPixelOffset(2131298374);
        int i3 = ((Resources)localObject3).getDimensionPixelOffset(2131298586);
        localObject3 = new RelativeLayout.LayoutParams(i1, i2);
        ((RelativeLayout.LayoutParams)localObject3).setMargins(0, i3, 0, 0);
        ((RelativeLayout.LayoutParams)localObject3).addRule(10);
        ((RelativeLayout.LayoutParams)localObject3).addRule(14);
        ((ViewGroup)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
        ((ChildLockCircle)localObject1).a();
        return localObject1;
      }
    }
    else
    {
      localObject1 = null;
    }
    return localObject1;
  }
  
  void t()
  {
    ChildLockCircle localChildLockCircle = s();
    if (localChildLockCircle != null)
    {
      boolean bool;
      if ((this.am != null) && (this.am.k().af)) {
        bool = false;
      } else {
        bool = true;
      }
      localChildLockCircle.a(bool);
    }
  }
  
  void u()
  {
    ChildLockCircle localChildLockCircle;
    if ((this.ak != null) && (this.ak.get() != null)) {
      localChildLockCircle = (ChildLockCircle)((Activity)this.ak.get()).findViewById(2131441036);
    } else {
      localChildLockCircle = null;
    }
    if (localChildLockCircle != null) {
      localChildLockCircle.b();
    }
  }
  
  void v()
  {
    this.al.a().removeCallbacks(this.u);
    this.al.a().postDelayed(this.u, 3000L);
  }
  
  public void w()
  {
    long l1 = AudioHelper.c();
    u();
    if (this.am.k().af)
    {
      this.am.k().af = false;
      this.al.a(new Object[] { Integer.valueOf(167), Boolean.valueOf(false) });
      this.al.a().postDelayed(new DoubleVideoCtrlUI.25(this, l1), 300L);
    }
  }
  
  public void x()
  {
    long l1 = AudioHelper.c();
    if (AudioHelper.e())
    {
      str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSelfAudioEngineReady, seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    String str = this.am.k().s;
    int i1 = this.am.g(str);
    int i2 = this.am.i(str);
    if ((i1 != 5) && (i1 != 0))
    {
      if (!this.am.m())
      {
        this.o.b(l1);
        if (this.am.k().aq != 1L) {
          super.G(l1);
        }
      }
      else
      {
        if (!this.am.k().j()) {
          return;
        }
        if (i2 > 18)
        {
          if (this.am.k().bx)
          {
            this.o.b(l1);
            if (this.am.k().aq != 1L) {
              super.G(l1);
            }
          }
        }
        else
        {
          this.o.b(l1);
          if (this.am.k().aq != 1L) {
            super.G(l1);
          }
        }
      }
    }
    else
    {
      this.o.b(l1);
      if (this.am.k().aq != 1L) {
        super.G(l1);
      }
    }
  }
  
  public void y()
  {
    long l1 = AudioHelper.c();
    if (AudioHelper.e())
    {
      str = this.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onOppositeAudioEngineReady, seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    String str = this.am.k().s;
    int i1 = this.am.g(str);
    int i2 = this.am.i(str);
    if (i1 != 5)
    {
      if (i1 == 0) {
        return;
      }
      if (this.am.m())
      {
        if (!this.am.k().j()) {
          return;
        }
        if ((i2 > 18) && (this.am.k().bw))
        {
          this.o.b(l1);
          super.G(l1);
        }
      }
    }
  }
  
  public int z()
  {
    return this.x;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI
 * JD-Core Version:    0.7.0.1
 */