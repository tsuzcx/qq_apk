package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoConstants.ProcessInfo;
import com.tencent.av.VideoController;
import com.tencent.av.VideoRecoveryReporter;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.avatar.QavUpdateAvatarViewHelper;
import com.tencent.av.business.manager.report.VideoBeaconReporter;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.av.business.manager.report.VideoNodeReporter;
import com.tencent.av.compat.AVCallCompactHelper;
import com.tencent.av.compat.AVCallCompactJob;
import com.tencent.av.core.JniSimpleInfoMng;
import com.tencent.av.screenshare.ScreenShareReportHelper;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.tips.AvTipsView;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.ui.avatar.AvatarParam;
import com.tencent.av.ui.funcall.FunCallUtil;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.BitmapTools;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.QAVNotificationUtil;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.av.utils.VideoWifiLock;
import com.tencent.av.wtogether.WTogetherMng;
import com.tencent.av.wtogether.data.WatchTogetherInfo;
import com.tencent.av.wtogether.util.WTogetherUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQLSUnlockActivity;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.mobileqq.vas.vipav.VipFullScreenVideoView;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.app.BaseActivity;

public class VideoInviteActivity
  extends BaseActivity
{
  public static int c = 60000;
  public static int d = 50000;
  TextView A;
  ImageButton B;
  ImageButton C;
  AudioManager D = null;
  final QavUpdateAvatarViewHelper E = new QavUpdateAvatarViewHelper();
  boolean F = false;
  boolean G = false;
  VideoAppInterface H = null;
  long I = -1L;
  RelativeLayout J = null;
  int K = 0;
  String L;
  int M = 0;
  VipFullScreenVideoView N;
  WeakReference<Activity> O = new WeakReference(this);
  BroadcastReceiver P = null;
  QavPanel Q = null;
  QavInOutAnimation R = null;
  boolean S = false;
  long T = -1L;
  AvTipsView U;
  TextView V = null;
  VideoInviteUIBase W;
  long X;
  boolean Y = false;
  boolean Z = false;
  final String a;
  boolean aa = false;
  int ab = 0;
  boolean ac = false;
  Runnable ad = new VideoInviteActivity.7(this);
  Runnable ae = new VideoInviteActivity.8(this);
  VideoObserver af = new VideoInviteActivity.9(this);
  GAudioUIObserver ag = new VideoInviteActivity.10(this);
  final int ah = 0;
  final int ai = 1;
  private AVCallCompactJob aj = new AVCallCompactJob();
  int b;
  SessionInfo e = null;
  public boolean f = false;
  boolean g = false;
  boolean h = false;
  int i = 0;
  int j = 0;
  int k = 0;
  byte[] l = null;
  int m = 0;
  String n = null;
  String o = null;
  String p = null;
  String q = null;
  boolean r = false;
  boolean s = false;
  boolean t = false;
  boolean u = true;
  long v = 0L;
  VideoWifiLock w;
  QAVNotification x = null;
  ImageView y = null;
  TextView z = null;
  
  public VideoInviteActivity()
  {
    long l1 = AudioHelper.c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append("_");
    localStringBuilder.append(l1);
    this.a = localStringBuilder.toString();
    this.X = l1;
    b("VideoInviteActivity");
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    if (VipFunCallUtil.a(this, this.N, paramString, paramInt1, null, paramInt2, false))
    {
      a(true);
      ImmersiveUtils.setStatusTextColor(false, getWindow());
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendIsResumeBroadcast isResume = ");
      localStringBuilder.append(paramBoolean);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), paramBoolean);
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.x == null) {
      this.x = QAVNotification.a(this.H);
    }
    boolean bool = true;
    if (AVUtil.b()) {
      bool = paramBoolean;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateInviteNotification show[");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append("], mIsAudioMode[");
      ((StringBuilder)localObject).append(this.g);
      ((StringBuilder)localObject).append("], isOnlyAudio[");
      ((StringBuilder)localObject).append(this.e.aK);
      ((StringBuilder)localObject).append("], session[");
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append("]");
      QLog.i("QAVNotification", 2, ((StringBuilder)localObject).toString());
    }
    if (bool)
    {
      localObject = this.H.a(this.j, this.o, this.q, true, true);
      this.p = this.H.a(this.j, this.o, this.q);
      if (this.e.aK)
      {
        this.x.a(true, this.e.f, this.p, (Bitmap)localObject, null, 45, this.j, 1);
        return;
      }
      this.x.a(true, this.e.f, this.p, (Bitmap)localObject, null, 40, this.j, 2);
      return;
    }
    this.x.a(this.e.f);
  }
  
  public void BtnOnClick(View paramView)
  {
    VideoInviteUIBase localVideoInviteUIBase = this.W;
    if (localVideoInviteUIBase != null) {
      localVideoInviteUIBase.BtnOnClick(paramView);
    }
  }
  
  ActionSheet a(Context paramContext)
  {
    paramContext = new VideoInviteActivity.LockScreenActionSheet(this, paramContext);
    paramContext.getWindow().setWindowAnimations(2131952166);
    return paramContext;
  }
  
  public void a()
  {
    if ((this.e != null) && (this.J != null))
    {
      if (this.aa) {
        return;
      }
      Object localObject = this.H;
      String str = this.o;
      boolean bool = this.g;
      int i1 = 0;
      int i2 = FunCallUtil.a((AppRuntime)localObject, str, false, bool);
      if (i2 != 0)
      {
        int i3 = NetworkUtil.getSystemNetwork(BaseApplicationImpl.getContext());
        if ((i3 == 4) || (i3 == 1)) {
          i1 = 1;
        }
        i3 = VipFunCallUtil.c();
        localObject = VipFunCallUtil.a(this.H, i2, VipFunCallUtil.c(), null);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return;
        }
        this.N = VipFunCallManager.a(this, this.J, true);
        if (new File((String)localObject).exists())
        {
          a((String)localObject, i3, i2);
          return;
        }
        if (i1 != 0)
        {
          this.ab = i2;
          FunCallUtil.a(this.H, i2);
        }
      }
    }
  }
  
  void a(int paramInt)
  {
    if (this.b == paramInt) {
      return;
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2) {
          TipsUtil.a(this.H, 1040, 2131893709);
        }
      }
      else {
        TipsUtil.a(this.H, 1040, 2131893711);
      }
    }
    else {
      TipsUtil.a(this.H, 1040, 2131893714);
    }
    this.b = paramInt;
  }
  
  public void a(long paramLong)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stopRing, mLastPlayRingTime[");
    localStringBuilder.append(this.v);
    localStringBuilder.append("->");
    localStringBuilder.append(0);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    this.v = 0L;
    if (TraeHelper.a() != null) {
      TraeHelper.a().b(paramLong);
    }
  }
  
  void a(long paramLong, Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramContext = a(paramContext);
    } else {
      paramContext = ActionSheet.create(paramContext);
    }
    paramContext.addButton(2131893420);
    paramContext.addButton(2131893422);
    paramContext.addButton(2131893421);
    if (h()) {
      paramContext.addButton(2131893419);
    }
    paramContext.addCancelButton(2131887648);
    paramContext.setOnDismissListener(new VideoInviteActivity.2(this, paramBoolean));
    paramContext.setOnButtonClickListener(new VideoInviteActivity.3(this, paramContext, paramBoolean, paramLong));
    paramContext.show();
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.a, 2, "refuseVideoRequest", new Throwable("refuseVideoRequest"));
    }
    this.r = false;
    TraeHelper.b(this.H);
    if (this.Z)
    {
      QavInOutAnimation localQavInOutAnimation = this.R;
      if ((localQavInOutAnimation != null) && (!this.S))
      {
        localQavInOutAnimation.a(new VideoInviteActivity.4(this, paramLong, paramBoolean));
        return;
      }
    }
    if (this.G)
    {
      d().a(paramLong, this.o, 1, true);
      long l1 = CharacterUtil.b(this.o);
      d().a(paramLong, 3, l1);
      this.F = true;
      d().a(paramLong, l1, 1);
      this.s = true;
      super.finish();
      return;
    }
    d().a(paramLong, this.o, 1, false);
    d().a(this.o, 249);
    d().b(249);
    if (paramBoolean) {
      d().b(this.o, 1);
    }
  }
  
  public void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    if (QAVNotificationUtil.a(paramIntent)) {
      ReportController.b(null, "dc00898", "", "", "0X800A2C5", "0X800A2C5", 0, 0, "", "", "", "");
    }
    long l1 = AudioHelper.c();
    String str1 = paramIntent.getAction();
    Object localObject;
    if ("com.tencent.qav.notify.accept".equals(str1))
    {
      localObject = paramIntent.getStringExtra("session_id");
      paramIntent = this.e;
      if (paramIntent == null) {
        paramIntent = null;
      } else {
        paramIntent = paramIntent.f;
      }
      if (TextUtils.equals((CharSequence)localObject, paramIntent))
      {
        c(l1);
      }
      else if (QLog.isColorLevel())
      {
        String str2 = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkParamAndDoAction not same , coming[");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("], cur[");
        localStringBuilder.append(paramIntent);
        localStringBuilder.append("]");
        QLog.i(str2, 2, localStringBuilder.toString());
      }
      ReportController.b(null, "dc00898", "", "", "0X800A2C6", "0X800A2C6", 0, 0, "", "", "", "");
    }
    else if ("com.tencent.qav.notify.refuse".equals(str1))
    {
      a(l1, true);
    }
    if (QLog.isColorLevel())
    {
      paramIntent = this.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkParamAndDoAction action[");
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append("]");
      QLog.i(paramIntent, 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(String paramString)
  {
    boolean bool = VideoController.a(this);
    int i1;
    if (bool) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    if (QLog.isColorLevel())
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkAndSwitchMode isLocked[");
      localStringBuilder.append(bool);
      localStringBuilder.append("], mode[");
      localStringBuilder.append(i1);
      localStringBuilder.append("], cur[");
      Object localObject = this.W;
      if (localObject == null) {
        localObject = "null";
      } else {
        localObject = Integer.valueOf(((VideoInviteUIBase)localObject).a());
      }
      localStringBuilder.append(localObject);
      localStringBuilder.append("], destroy[");
      localStringBuilder.append(this.aa);
      localStringBuilder.append("], from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    b("checkAndSwitchMode");
    if (this.aa) {
      return;
    }
    paramString = this.W;
    if (paramString == null)
    {
      b(bool);
      return;
    }
    if (i1 != paramString.a())
    {
      paramString = this.W;
      paramString.l();
      b(bool);
      this.W.a(paramString);
      if (this.Y)
      {
        this.W.f();
        this.W.c();
      }
      if (this.Z) {
        this.W.i();
      }
    }
  }
  
  void a(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = this.V;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(-1);
      }
      localObject = this.z;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(-1);
      }
      localObject = this.A;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(-1);
      }
      localObject = this.U;
      if (localObject != null)
      {
        ((AvTipsView)localObject).a(super.getResources().getColor(2131166789));
        this.U.b(-1291845633);
      }
    }
    else
    {
      localObject = this.V;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(-11113603);
      }
      localObject = this.z;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(Color.parseColor("#566B7D"));
      }
      localObject = this.A;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(Color.parseColor("#566B7D"));
      }
      localObject = this.U;
      if (localObject != null)
      {
        ((AvTipsView)localObject).a(-11113603);
        this.U.b(-11113603);
      }
    }
  }
  
  protected void b()
  {
    q();
    this.U = new AvTipsView();
    this.U.a(this.H, this.J);
    this.b = 1;
    if ((!NetworkUtil.isWifiConnected(super.getApplicationContext())) && (!NetworkUtil.isBluetoothSharedNetwork(super.getApplicationContext()))) {
      this.b = 2;
    }
    this.A = ((TextView)super.findViewById(2131428984));
    this.V = ((TextView)super.findViewById(2131428974));
    if ((this.V != null) && (!TextUtils.isEmpty(this.L)))
    {
      this.V.setVisibility(0);
      this.V.setText(this.L);
      UITools.a(this.V, this.L);
      if (this.G) {
        this.A.setVisibility(4);
      }
    }
  }
  
  public void b(long paramLong)
  {
    Object localObject = this.H;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((VideoAppInterface)localObject).getCurrentAccountUin();
    }
    boolean bool = AVUtil.b((String)localObject);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localObject = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("playRing avCallBtnState[");
      localStringBuilder.append(bool);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    if (!bool) {
      return;
    }
    if (PhoneStatusTools.c(this))
    {
      if ((!this.h) && (this.u))
      {
        long l1 = System.currentTimeMillis();
        localObject = this.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("playRing, mIsRingPlaying[");
        localStringBuilder.append(this.v);
        localStringBuilder.append("->");
        localStringBuilder.append(l1);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w((String)localObject, 1, localStringBuilder.toString());
        if (this.v != 0L) {
          return;
        }
        this.v = l1;
        TraeHelper.a().b(paramLong);
        localObject = this.H;
        if ((localObject != null) && (((VideoAppInterface)localObject).getApp() != null))
        {
          localObject = this.H;
          this.I = VipFunCallUtil.a((AppRuntime)localObject, ((VideoAppInterface)localObject).getAccount(), 3, false, this.o);
        }
        else
        {
          this.I = 0L;
        }
        l1 = this.I;
        if (l1 == 0L)
        {
          TraeHelper.a().a(paramLong, this.H, 2131230814, -1, null);
        }
        else
        {
          localObject = ColorRingManager.a(l1, 3);
          if (new File((String)localObject).exists())
          {
            TraeHelper.a().b(paramLong, this.H, 0, (String)localObject, -1, null);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(this.I);
            ((StringBuilder)localObject).append("");
            ReportController.b(null, "CliOper", "", "", "0X8005004", "0X8005004", 0, 0, "", ((StringBuilder)localObject).toString(), "", "");
          }
          else
          {
            TraeHelper.a().a(paramLong, this.H, 2131230814, -1, null);
            localObject = this.H;
            if ((localObject != null) && (((VideoAppInterface)localObject).getApp() != null))
            {
              localObject = new Intent();
              ((Intent)localObject).setAction("tencent.video.v2q.commingRingDownload");
              ((Intent)localObject).setPackage(this.H.getApp().getPackageName());
              ((Intent)localObject).putExtra("comming_ring_down_key", this.I);
              this.H.getApp().sendBroadcast((Intent)localObject);
            }
          }
        }
      }
      TraeHelper.a(this.H, false, paramLong);
      return;
    }
    if (PhoneStatusTools.b(this)) {
      TraeHelper.a(this.H, false, paramLong);
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("traceLog from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(this.X);
      localStringBuilder.append("], mode[");
      localStringBuilder.append(this.W);
      localStringBuilder.append("]");
      QLog.i("TraceLogForAV", 2, localStringBuilder.toString());
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.W = new VideoInviteUILock(this);
    } else {
      this.W = new VideoInviteUIFull(this);
    }
    if (QLog.isColorLevel())
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initVideoInviteUI isLocked[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
  }
  
  public void c(long paramLong)
  {
    if (!f()) {
      return;
    }
    boolean bool;
    if ((!this.g) && (!this.f)) {
      bool = false;
    } else {
      bool = true;
    }
    if (!ChatActivityUtils.b(this, bool, new VideoInviteActivity.5(this, paramLong, bool))) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i(this.a, 2, "acceptVideoRequest");
    }
    i();
    sendBroadcast(new Intent("tencent.video.v2g.exitAVGame"));
    if (d().j) {
      n();
    } else {
      j();
    }
    TraeHelper.b(this.H);
    a(paramLong);
  }
  
  boolean c()
  {
    Object localObject = super.getIntent();
    boolean bool2 = true;
    boolean bool1 = true;
    StringBuilder localStringBuilder;
    if ((localObject != null) && (!QAVNotificationUtil.a((Intent)localObject)))
    {
      this.o = ((Intent)localObject).getStringExtra("peerUin");
      if (TextUtils.isEmpty(this.o))
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.a, 2, "initVideoParam uin is empty!");
        }
        bool1 = false;
      }
      else
      {
        this.j = ((Intent)localObject).getIntExtra("uinType", 0);
        this.q = ((Intent)localObject).getStringExtra("extraUin");
        this.i = ((Intent)localObject).getIntExtra("curUserStatus", 0);
        this.g = ((Intent)localObject).getBooleanExtra("isAudioMode", false);
        this.h = ((Intent)localObject).getBooleanExtra("powerKey", false);
        this.u = ((Intent)localObject).getBooleanExtra("isPlayRing", true);
        this.G = ((Intent)localObject).getBooleanExtra("isDoubleVideoMeeting", false);
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        localObject = this.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("initVideoParam fromIntent peer[");
        localStringBuilder.append(this.o);
        localStringBuilder.append("], uinType[");
        localStringBuilder.append(this.j);
        localStringBuilder.append("], audioMode[");
        localStringBuilder.append(this.g);
        localStringBuilder.append("], ret[");
        localStringBuilder.append(bool1);
        localStringBuilder.append("]");
        QLog.i((String)localObject, 2, localStringBuilder.toString());
        return bool1;
      }
    }
    else
    {
      localObject = SessionMgr.a().b();
      if (localObject != null)
      {
        this.j = ((SessionInfo)localObject).p;
        this.o = ((SessionInfo)localObject).s;
        if (TextUtils.isEmpty(this.o))
        {
          if (QLog.isColorLevel()) {
            QLog.e(this.a, 2, "initVideoParam uin is empty!");
          }
        }
        else
        {
          this.j = ((SessionInfo)localObject).p;
          this.q = ((SessionInfo)localObject).u;
          this.i = d().o();
          this.g = ((SessionInfo)localObject).aK;
          this.G = ((SessionInfo)localObject).am;
          bool1 = bool2;
          break label369;
        }
      }
      bool1 = false;
      label369:
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        localObject = this.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("initVideoParam from Session peer[");
        localStringBuilder.append(this.o);
        localStringBuilder.append("], uinType[");
        localStringBuilder.append(this.j);
        localStringBuilder.append("], audioMode[");
        localStringBuilder.append(this.g);
        localStringBuilder.append("], ret[");
        localStringBuilder.append(bool1);
        localStringBuilder.append("]");
        QLog.i((String)localObject, 2, localStringBuilder.toString());
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  VideoController d()
  {
    return this.H.b();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  boolean e()
  {
    this.H = ((VideoAppInterface)super.getAppRuntime());
    if (this.H != null)
    {
      this.w = new VideoWifiLock(super.getApplicationContext(), 1, "video wifi lock");
      return true;
    }
    return false;
  }
  
  protected boolean f()
  {
    if (this.w == null) {
      this.w = new VideoWifiLock(super.getApplicationContext(), 1, "video wifi lock");
    }
    if (PhoneStatusTools.f(super.getApplicationContext()))
    {
      VideoWifiLock localVideoWifiLock = this.w;
      if (localVideoWifiLock != null) {
        localVideoWifiLock.a();
      }
    }
    return true;
  }
  
  public void finish()
  {
    QLog.w(this.a, 1, "finish", new Throwable());
    super.finish();
  }
  
  @TargetApi(16)
  void g()
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    try
    {
      KeyguardManager localKeyguardManager = (KeyguardManager)super.getSystemService("keyguard");
      if ((localKeyguardManager != null) && (localKeyguardManager.isKeyguardLocked()))
      {
        boolean bool = localKeyguardManager.isKeyguardSecure();
        if (bool) {
          return;
        }
      }
      super.startActivity(new Intent(super.getApplicationContext(), QQLSUnlockActivity.class));
      return;
    }
    catch (SecurityException localSecurityException) {}
  }
  
  boolean h()
  {
    if (QQUtils.a(super.getApplicationContext())) {
      return Build.VERSION.SDK_INT >= 16;
    }
    return true;
  }
  
  public void i()
  {
    sendBroadcast(new Intent("tencent.video.v2nearbyV.exit"));
    if (QLog.isColorLevel()) {
      QLog.d("nearby.video.multiMsg", 2, "exitNearbyVideo");
    }
  }
  
  void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, "startVideoChatActivity");
    }
    TraeHelper.a().c();
    this.H.a().removeCallbacks(this.ad);
    this.H.a().removeCallbacks(this.ae);
    if (d().X) {
      this.H.a(new Object[] { Integer.valueOf(113) });
    }
    Intent localIntent = new Intent(super.getApplicationContext(), AVActivity.class);
    localIntent.addFlags(262144);
    String str;
    if (this.G)
    {
      str = this.o;
      localIntent.putExtra("sessionType", 3);
      localIntent.putExtra("Type", 1);
      localIntent.putExtra("uin", str);
      localIntent.putExtra("uinType", 0);
      localIntent.putExtra("isDoubleVideoMeeting", true);
      localIntent.putExtra("inviteUin", str);
      localIntent.putExtra("sessionType", 1);
      localIntent.putExtra("isSender", false);
      localIntent.putExtra("isEnter", true);
      localIntent.putExtra("name", this.p);
    }
    else
    {
      localIntent.putExtra("uinType", this.j);
      localIntent.putExtra("bindType", this.k);
      localIntent.putExtra("bindId", this.n);
      localIntent.putExtra("uin", this.o);
      localIntent.putExtra("name", this.p);
      localIntent.putExtra("extraUin", this.q);
      localIntent.putExtra("receive", true);
      localIntent.putExtra("isAudioMode", this.g);
      localIntent.putExtra("sig", this.l);
      localIntent.putExtra("subServiceType", this.m);
      if (QLog.isColorLevel())
      {
        str = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("startVideoChatActivity: mBindType = ");
        localStringBuilder.append(this.k);
        localStringBuilder.append(",mBindId = ");
        localStringBuilder.append(this.n);
        localStringBuilder.append(",BindType = ");
        localStringBuilder.append(this.e.az);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      if (this.j == 0) {
        localIntent.putExtra("isFriend", this.H.c(this.o));
      }
      if (this.g) {
        localIntent.putExtra("sessionType", 1);
      } else {
        localIntent.putExtra("sessionType", 2);
      }
      localIntent.putExtra("shutCamera", this.f);
      localIntent.putExtra("isSender", false);
    }
    super.startActivity(localIntent);
    this.s = false;
    this.t = true;
    super.finish();
    super.overridePendingTransition(2130772286, 2130772285);
  }
  
  void k()
  {
    long l1 = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onVideoRequestTimeout, seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("], state[");
      SessionInfo localSessionInfo = this.e;
      int i1;
      if (localSessionInfo == null) {
        i1 = -1;
      } else {
        i1 = localSessionInfo.i;
      }
      localStringBuilder.append(i1);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = this.e;
    if ((localObject != null) && ((((SessionInfo)localObject).i()) || (this.e.j())))
    {
      localObject = this.o;
      if ((localObject != null) && (((String)localObject).equals(this.e.s)))
      {
        finish();
        return;
      }
    }
    TraeHelper.b(this.H);
    a(l1);
    if (this.Z)
    {
      localObject = this.R;
      if (localObject != null)
      {
        ((QavInOutAnimation)localObject).a(new VideoInviteActivity.6(this, l1));
        return;
      }
    }
    this.r = false;
    if (this.G)
    {
      long l2 = CharacterUtil.b(this.o);
      d().a(l1, 3, l2);
      if (!this.F)
      {
        this.F = true;
        d().a(l1, l2, 2);
      }
      this.s = true;
      finish();
      return;
    }
    d().a(this.o, 247);
    d().b(247);
    d().b(this.o, 0);
  }
  
  protected void l()
  {
    VideoInviteUIBase localVideoInviteUIBase = this.W;
    if (localVideoInviteUIBase != null) {
      localVideoInviteUIBase.d();
    }
  }
  
  void m()
  {
    Object localObject3 = this.e;
    if (localObject3 == null) {
      return;
    }
    Object localObject2 = this.o;
    int i2 = this.j;
    Object localObject1 = localObject2;
    int i1 = i2;
    if (((SessionInfo)localObject3).az == 1)
    {
      localObject1 = localObject2;
      i1 = i2;
      if (this.j == 9500)
      {
        localObject1 = localObject2;
        i1 = i2;
        if (!TextUtils.isEmpty(this.e.aB))
        {
          localObject1 = this.e.aB;
          i1 = 0;
        }
      }
    }
    localObject2 = new AvatarParam(i1, (String)localObject1, this.q, true);
    this.E.a(this.H, this.y, (AvatarParam)localObject2, null);
    if (this.J != null)
    {
      localObject2 = UITools.a(super.getApplicationContext(), 2130843118);
      if (localObject2 != null)
      {
        long l1 = System.currentTimeMillis();
        localObject2 = new BitmapDrawable((Bitmap)localObject2);
        this.J.setBackgroundDrawable((Drawable)localObject2);
        if (QLog.isColorLevel())
        {
          localObject2 = this.a;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("blur time = ");
          ((StringBuilder)localObject3).append(System.currentTimeMillis() - l1);
          ((StringBuilder)localObject3).append("ms");
          QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
        }
      }
      else
      {
        localObject2 = BitmapTools.a(super.getApplicationContext(), 2130843118);
        if (localObject2 != null) {
          this.J.setBackgroundDrawable((Drawable)localObject2);
        } else {
          this.J.setBackgroundResource(2130843118);
        }
      }
    }
    if (this.z != null)
    {
      this.p = this.H.a(i1, (String)localObject1, this.q);
      if ((this.j == 25) && (this.p.equals(this.o)))
      {
        this.p = this.e.w;
        if (QLog.isColorLevel())
        {
          localObject1 = this.a;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("mPeerName = ");
          ((StringBuilder)localObject2).append(this.p);
          QLog.w((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
      }
      this.z.setText(this.p);
    }
  }
  
  void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, "showGAudioDialog");
    }
    VideoInviteActivity.DialogInterfaceOnClickListener localDialogInterfaceOnClickListener1 = new VideoInviteActivity.DialogInterfaceOnClickListener(this, 0);
    VideoInviteActivity.DialogInterfaceOnClickListener localDialogInterfaceOnClickListener2 = new VideoInviteActivity.DialogInterfaceOnClickListener(this, 1);
    DialogUtil.a(this, 230, null, super.getString(2131893276), 2131917829, 2131893180, localDialogInterfaceOnClickListener1, localDialogInterfaceOnClickListener2).show();
  }
  
  void o()
  {
    int i1;
    if (d() != null)
    {
      i1 = this.e.p;
      str = this.e.u;
    }
    else
    {
      str = null;
      i1 = 0;
    }
    if (i1 != 0)
    {
      StringBuilder localStringBuilder;
      if (i1 != 1004)
      {
        if (i1 != 1006)
        {
          if (i1 != 1010)
          {
            if (i1 != 1021)
            {
              if (i1 != 10002)
              {
                if (i1 != 1000)
                {
                  if (i1 != 1001)
                  {
                    this.M = 99;
                  }
                  else
                  {
                    str = super.getString(2131893412);
                    this.M = 5;
                    break label319;
                  }
                }
                else
                {
                  localStringBuilder = new StringBuilder();
                  localStringBuilder.append(super.getString(2131893411));
                  localStringBuilder.append(this.H.a(1, str, null));
                  str = localStringBuilder.toString();
                  this.M = 1;
                  break label319;
                }
              }
              else
              {
                str = super.getString(2131891943);
                this.M = 7;
                break label319;
              }
            }
            else
            {
              str = super.getString(2131893407);
              this.M = 4;
              break label319;
            }
          }
          else
          {
            str = super.getString(2131893409);
            this.M = 6;
            break label319;
          }
        }
        else
        {
          str = super.getString(2131893408);
          this.M = 3;
          break label319;
        }
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(super.getString(2131893411));
        localStringBuilder.append(this.H.a(3000, str, null));
        str = localStringBuilder.toString();
        this.M = 2;
        break label319;
      }
    }
    else
    {
      if (this.G)
      {
        this.M = 7;
        str = super.getString(2131893410);
        ScreenShareReportHelper.a(this.e.f, 1, "getComeFromInfo");
        break label319;
      }
      this.M = 0;
    }
    String str = "";
    label319:
    this.L = str;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    LiuHaiUtils.f(this);
    if ((LiuHaiUtils.b()) && (LiuHaiUtils.enableNotch(this)) && (QLog.isDevelopLevel())) {
      QLog.w(this.a, 1, "onAttachedToWindow");
    }
  }
  
  public void onBackPressed()
  {
    VideoInviteUIBase localVideoInviteUIBase = this.W;
    if (localVideoInviteUIBase != null) {
      localVideoInviteUIBase.e();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    long l4 = AudioHelper.c();
    Object localObject1 = this.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("avideo onCreate, seq[");
    ((StringBuilder)localObject2).append(l4);
    ((StringBuilder)localObject2).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    b("onCreate");
    if (this.W == null) {
      b(VideoController.a(getApplicationContext()));
    }
    localObject1 = this.W;
    if (localObject1 != null) {
      ((VideoInviteUIBase)localObject1).a(true);
    }
    VideoNodeManager.a(29);
    this.T = System.currentTimeMillis();
    super.onCreate(paramBundle);
    super.overridePendingTransition(2130772286, 0);
    AVActivity.a(getWindow(), true);
    ImmersiveUtils.setStatusTextColor(true, getWindow());
    AVActivity.a(super.getWindow());
    if ((e()) && (c()))
    {
      paramBundle = this.o;
      if (this.G) {
        paramBundle = SessionMgr.a(100, paramBundle, new int[0]);
      } else {
        paramBundle = SessionMgr.a(3, paramBundle, new int[0]);
      }
      this.D = ((AudioManager)super.getSystemService("audio"));
      this.e = SessionMgr.a().d(paramBundle);
      paramBundle = d();
      localObject1 = null;
      if (paramBundle == null) {
        paramBundle = null;
      } else {
        paramBundle = paramBundle.az();
      }
      if (paramBundle != null) {
        paramBundle.a(getClass().getName(), getIntent());
      }
      paramBundle = this.e;
      Object localObject3;
      if ((paramBundle == null) || (!paramBundle.h()))
      {
        if (QLog.isColorLevel())
        {
          paramBundle = this.a;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("session state error! ");
          localObject3 = this.e;
          if (localObject3 != null) {
            i1 = ((SessionInfo)localObject3).i;
          } else {
            i1 = -1;
          }
          ((StringBuilder)localObject2).append(i1);
          QLog.w(paramBundle, 2, ((StringBuilder)localObject2).toString());
        }
        paramBundle = this.e;
        if ((paramBundle != null) && (paramBundle.f()))
        {
          paramBundle = this.o;
          if ((paramBundle != null) && (paramBundle.equals(this.e.s)))
          {
            if (!QLog.isColorLevel()) {
              break label605;
            }
            paramBundle = this.a;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("onCreate state[");
            ((StringBuilder)localObject2).append(this.e.i);
            ((StringBuilder)localObject2).append("], peerUin[");
            ((StringBuilder)localObject2).append(this.o);
            ((StringBuilder)localObject2).append("]");
            QLog.w(paramBundle, 2, ((StringBuilder)localObject2).toString());
            break label605;
          }
        }
        paramBundle = this.e;
        if ((paramBundle == null) || ((!paramBundle.i()) && (!this.e.j()))) {
          break label1317;
        }
        paramBundle = this.o;
        if ((paramBundle == null) || (!paramBundle.equals(this.e.s))) {
          break label1317;
        }
        if (QLog.isColorLevel())
        {
          paramBundle = this.a;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onCreate state[");
          ((StringBuilder)localObject2).append(this.e.i);
          ((StringBuilder)localObject2).append("], peerUin[");
          ((StringBuilder)localObject2).append(this.o);
          ((StringBuilder)localObject2).append("]");
          QLog.w(paramBundle, 2, ((StringBuilder)localObject2).toString());
        }
        finish();
      }
      label605:
      a(getIntent());
      if (d().j != true)
      {
        TraeHelper.a(this.H.getApp().getApplicationContext(), d());
        a(l4);
        if (this.e.h == 1) {
          TraeHelper.a().a("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;");
        } else {
          TraeHelper.a().a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;");
        }
      }
      this.H.a(this.af);
      this.H.a(this.ag);
      long l3 = System.currentTimeMillis();
      long l2 = this.e.cc;
      if (l2 > 0L)
      {
        long l5 = l3 - l2;
        if (l5 < c)
        {
          l1 = l2;
          if (l5 < d) {
            break label766;
          }
          i1 = 1;
          l1 = l2;
          break label768;
        }
      }
      long l1 = l3;
      label766:
      int i1 = 0;
      label768:
      this.H.a().postDelayed(this.ad, c + l1 - l3);
      if (i1 != 0) {
        l();
      } else {
        this.H.a().postDelayed(this.ae, l1 + d - l3);
      }
      if (d().A() > 0) {
        d().a(203, this.o);
      } else {
        d().a(202, this.o);
      }
      this.K = PhoneStatusTools.g(this);
      this.n = this.e.aB;
      this.k = this.e.az;
      this.l = this.e.aH;
      this.m = this.e.Z;
      paramBundle = new IntentFilter();
      paramBundle.addAction("tencent.video.q2v.ACTION_ON_UPDATE_FRIEND_INFO");
      paramBundle.addAction("tencent.video.q2v.sdk.onRequestVideo");
      paramBundle.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
      paramBundle.addAction("android.intent.action.SCREEN_OFF");
      paramBundle.addAction("android.intent.action.SCREEN_ON");
      paramBundle.addAction("android.intent.action.USER_PRESENT");
      this.P = new VideoInviteActivity.MyBroadCastReceiver(this);
      super.registerReceiver(this.P, paramBundle);
      o();
      if (this.j == 25)
      {
        localObject2 = (IPhoneContactService)this.H.getRuntimeService(IPhoneContactService.class, "");
        paramBundle = (Bundle)localObject1;
        if (localObject2 != null)
        {
          localObject3 = this.q;
          paramBundle = (Bundle)localObject1;
          if (localObject3 != null) {
            paramBundle = ((IPhoneContactService)localObject2).queryContactByCodeNumber((String)localObject3);
          }
        }
        if (paramBundle != null)
        {
          paramBundle = ((IPhoneContactService)localObject2).getUinByPhoneNum(this.q);
          if ((paramBundle != null) && (this.H.c(paramBundle))) {
            ReportController.b(null, "CliOper", "", "", "0X800624D", "0X800624D", 1, 0, "", "", "", "");
          } else {
            ReportController.b(null, "CliOper", "", "", "0X800624D", "0X800624D", 0, 0, "", "", "", "");
          }
        }
        else
        {
          ReportController.b(null, "CliOper", "", "", "0X800624D", "0X800624D", 2, 0, "", "", "", "");
        }
      }
      if ((!this.s) && (this.e.h())) {
        d(false);
      }
      paramBundle = getIntent();
      if ((paramBundle != null) && (paramBundle.getBooleanExtra("fullscreen", false))) {
        VideoRecoveryReporter.b();
      }
      paramBundle = this.W;
      if (paramBundle != null) {
        paramBundle.f();
      }
      if ((this.e.p == 21) || (this.e.p == 1011))
      {
        this.r = true;
        c(l4);
        paramBundle = this.W;
        if (paramBundle != null) {
          paramBundle.c();
        }
      }
      paramBundle = this.R;
      if (paramBundle != null) {
        paramBundle.a();
      }
      this.Y = true;
      return;
      label1317:
      d().a(this.o, 245);
      d().b(245);
      d().b(this.o, 2);
      this.s = true;
      super.finish();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w(this.a, 2, "init param failure.");
    }
    this.s = true;
    super.finish();
  }
  
  protected void onDestroy()
  {
    long l1 = AudioHelper.c();
    Object localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("avideo onDestroy, seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    super.onDestroy();
    localObject = this.U;
    if (localObject != null) {
      ((AvTipsView)localObject).a(this.H);
    }
    VideoBeaconReporter.a(this.T);
    this.T = -1L;
    this.H.a().removeCallbacks(this.ad);
    this.H.a().removeCallbacks(this.ae);
    localObject = this.w;
    if (localObject != null)
    {
      ((VideoWifiLock)localObject).b();
      this.w = null;
    }
    this.H.b(this.af);
    this.H.b(this.ag);
    localObject = this.P;
    if (localObject != null)
    {
      super.unregisterReceiver((BroadcastReceiver)localObject);
      this.P = null;
    }
    a(l1);
    TraeHelper.b(this.H);
    this.V = null;
    this.w = null;
    this.x = null;
    this.y = null;
    this.z = null;
    this.A = null;
    this.B = null;
    this.C = null;
    this.D = null;
    this.af = null;
    this.ag = null;
    localObject = this.W;
    if (localObject != null) {
      ((VideoInviteUIBase)localObject).l();
    }
    try
    {
      if (this.N == null) {
        break label332;
      }
      this.N.stopPlayback();
      if (this.J != null)
      {
        this.J.removeAllViews();
        this.J = null;
      }
      this.N = null;
    }
    catch (Throwable localThrowable)
    {
      label296:
      break label296;
    }
    localObject = this.N;
    if (localObject != null)
    {
      ((VipFullScreenVideoView)localObject).suspend();
      localObject = this.J;
      if (localObject != null)
      {
        ((RelativeLayout)localObject).removeAllViews();
        this.J = null;
      }
      this.N = null;
    }
    label332:
    this.e = null;
    this.aa = true;
    AVUtil.a(this);
    AVUtil.a(this);
    b("onDestroy");
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    Object localObject = this.W;
    if (localObject != null) {
      ((VideoInviteUIBase)localObject).a(paramInt, paramKeyEvent);
    }
    if (!this.r)
    {
      long l1 = AudioHelper.c();
      localObject = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onKeyDown, seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      if ((paramInt != 25) && (paramInt != 24))
      {
        if (paramInt == 26) {
          a(l1);
        }
      }
      else
      {
        TraeHelper.b(this.H);
        a(l1);
      }
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    return true;
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    QLog.d(this.a, 1, "onNewIntent()");
    b("onNewIntent");
    a(paramIntent);
  }
  
  protected void onPause()
  {
    QLog.d(this.a, 1, "onPause");
    super.onPause();
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(this, 2, true);
    c(false);
    d().b("state", "0");
    if ("0".equals(VideoConstants.ProcessInfo.a)) {
      d().b("backgroundReason", "5");
    }
    if (!this.t) {
      ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), true, 50, 1);
    }
    Object localObject = this.U;
    if (localObject != null) {
      ((AvTipsView)localObject).b(this.H);
    }
    localObject = this.W;
    if (localObject != null) {
      ((VideoInviteUIBase)localObject).j();
    }
    this.Z = false;
    this.aj.a(this.H, d());
  }
  
  protected void onRestart()
  {
    QLog.d(this.a, 1, "onRestart");
    super.onRestart();
    VideoInviteUIBase localVideoInviteUIBase = this.W;
    if (localVideoInviteUIBase != null) {
      localVideoInviteUIBase.h();
    }
  }
  
  protected void onResume()
  {
    a("onResume");
    long l1 = AudioHelper.c();
    Object localObject1 = this.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onResume, mCheckQAVPermission[");
    ((StringBuilder)localObject2).append(this.ac);
    ((StringBuilder)localObject2).append("], isInLockMode[");
    ((StringBuilder)localObject2).append(r());
    ((StringBuilder)localObject2).append("], seq[");
    ((StringBuilder)localObject2).append(l1);
    ((StringBuilder)localObject2).append("]");
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    super.onResume();
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(this, 2, false);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowClosedBroadcast(BaseApplicationImpl.getContext(), 50, 0);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), false, 50, 1);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowClosedBroadcast(BaseApplicationImpl.getContext(), 50, 2);
    p();
    this.h = false;
    c(true);
    localObject1 = SessionMgr.a().b();
    localObject2 = (VideoNodeReporter)this.H.c(4);
    if ((localObject2 != null) && (localObject1 != null))
    {
      long l2 = System.currentTimeMillis();
      long l3 = this.H.y;
      ((VideoNodeReporter)localObject2).a(((SessionInfo)localObject1).D(), 24, l2 - l3);
    }
    d().a(VideoInviteActivity.class);
    d().b("state", "1");
    VideoConstants.ProcessInfo.a = "0";
    localObject2 = this.U;
    if (localObject2 != null) {
      ((AvTipsView)localObject2).c(this.H);
    }
    if (!this.ac)
    {
      this.ac = true;
      ChatActivityUtils.b(this, true, new VideoInviteActivity.1(this, l1));
    }
    localObject2 = this.W;
    if (localObject2 != null) {
      ((VideoInviteUIBase)localObject2).i();
    }
    if (!r()) {
      b(l1);
    }
    this.Z = true;
    this.aj.a(this, this.H, d());
    localObject2 = d().aG();
    if ((localObject2 != null) && (localObject1 != null) && (((JniSimpleInfoMng)localObject2).a(AVUtil.c(((SessionInfo)localObject1).s), false, true) == 1) && (WTogetherUtil.c()))
    {
      localObject1 = ((WTogetherMng)this.H.c(17)).a((SessionInfo)localObject1);
      if (!((WatchTogetherInfo)localObject1).e)
      {
        ((WatchTogetherInfo)localObject1).e = true;
        WTogetherUtil.a(this, getString(2131893760));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("WTogether", 2, "showNetTip, have shown. 1");
      }
    }
  }
  
  protected void onStart()
  {
    QLog.d(this.a, 1, "onStart");
    super.onStart();
    VideoInviteUIBase localVideoInviteUIBase = this.W;
    if (localVideoInviteUIBase != null) {
      localVideoInviteUIBase.g();
    }
    if (r())
    {
      long l1 = AudioHelper.c();
      if (VideoController.b(this)) {
        b(l1);
      }
    }
  }
  
  protected void onStop()
  {
    long l1 = AudioHelper.c();
    boolean bool = PhoneStatusTools.c(this);
    Object localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("avideo onStop, isRingerNormal[");
    localStringBuilder.append(bool);
    localStringBuilder.append("], mIsAccepted[");
    localStringBuilder.append(this.r);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    super.onStop();
    if ((bool) && (!this.r)) {
      a(l1);
    }
    if (this.e == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w(this.a, 2, "onStop mSessionInfo is null ");
      }
      return;
    }
    localObject = this.W;
    if (localObject != null) {
      ((VideoInviteUIBase)localObject).k();
    }
    this.Z = false;
    if ((!this.s) && (this.e.h())) {
      d(true);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    VideoInviteUIBase localVideoInviteUIBase = this.W;
    if (localVideoInviteUIBase != null) {
      localVideoInviteUIBase.a(false);
    }
  }
  
  protected boolean p()
  {
    return d().t(this.o);
  }
  
  void q()
  {
    this.J = ((RelativeLayout)super.findViewById(2131445148));
    Drawable localDrawable = BitmapTools.a(super.getApplicationContext(), 2130843118);
    if (localDrawable != null)
    {
      this.J.setBackgroundDrawable(localDrawable);
      return;
    }
    this.J.setBackgroundResource(2130843118);
  }
  
  public boolean r()
  {
    return this.W instanceof VideoInviteUILock;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteActivity
 * JD-Core Version:    0.7.0.1
 */