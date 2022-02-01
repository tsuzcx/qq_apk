package com.tencent.av.ui;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.av.utils.VideoWifiLock;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class VideoInviteFloatBarUICtr
  extends BaseInviteFloatBarUICtr
{
  String A = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;";
  BroadcastReceiver B = new VideoInviteFloatBarUICtr.1(this);
  VideoObserver C = new VideoInviteFloatBarUICtr.2(this);
  GAudioUIObserver D = new VideoInviteFloatBarUICtr.3(this);
  Runnable E = new VideoInviteFloatBarUICtr.4(this);
  VideoController s = null;
  public boolean t = false;
  boolean u = false;
  VideoWifiLock v;
  int w = -1;
  public boolean x = false;
  String y = "";
  Intent z;
  
  public VideoInviteFloatBarUICtr(VideoController paramVideoController, VideoAppInterface paramVideoAppInterface, Intent paramIntent)
  {
    this.c = paramVideoAppInterface;
    this.s = paramVideoController;
    this.z = paramIntent;
  }
  
  private boolean a(int paramInt)
  {
    if ((this.h == 1) && (!TextUtils.isEmpty(this.y)))
    {
      Object localObject = new Intent("tencent.video.v2q.ACTION_DEAL_INVITE_TO_ENTER_GROUP_VEDIO");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.d);
      localStringBuilder.append("");
      ((Intent)localObject).putExtra("relationId", localStringBuilder.toString());
      ((Intent)localObject).putExtra("dealResult", paramInt);
      ((Intent)localObject).putExtra("inviteId", this.y);
      ((Intent)localObject).putExtra("friendUin", this.i);
      ((Intent)localObject).setPackage(this.c.getApp().getPackageName());
      this.c.getApp().sendBroadcast((Intent)localObject);
      if (QLog.isDevelopLevel()) {
        QLog.d("VideoInviteFloatBarUICtr", 2, "sendBroadcast, qav_gaudio_join");
      }
      if (paramInt == 1) {
        localObject = "tip_in";
      } else {
        localObject = "tip_no";
      }
      long l = this.s.k().aN;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.w);
      localStringBuilder.append("");
      ReportController.b(null, "dc00899", "Grp_video", "", "invite", (String)localObject, 0, 0, String.valueOf(l), localStringBuilder.toString(), "", "");
      return true;
    }
    return false;
  }
  
  public int a(long paramLong, Intent paramIntent)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStartCommand, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w("VideoInviteFloatBarUICtr", 1, localStringBuilder.toString());
      AudioHelper.a("VideoInviteFloatBarUICtr.onStartCommand", paramIntent.getExtras());
    }
    this.s = this.c.b();
    this.g = paramIntent.getIntExtra("uinType", 0);
    this.h = paramIntent.getIntExtra("relationType", 0);
    if (AVUtil.e(this.g))
    {
      this.i = paramIntent.getLongExtra("friendUin", 0L);
      this.y = paramIntent.getStringExtra("inviteId");
      this.d = paramIntent.getLongExtra("discussId", 0L);
      this.w = paramIntent.getIntExtra("memberType", -1);
      this.j = paramIntent.getLongArrayExtra("memberList");
      this.c.a(this.D);
      paramIntent = SessionMgr.a(this.h, String.valueOf(this.d), new int[0]);
      if (SessionMgr.a().a(paramIntent))
      {
        this.l = SessionMgr.a().d(paramIntent);
        return 2;
      }
      this.l = SessionMgr.a().b();
      return 2;
    }
    this.m = paramIntent.getStringExtra("peerUin");
    this.n = paramIntent.getStringExtra("extraUin");
    this.k = paramIntent.getBooleanExtra("isAudioMode", false);
    this.t = paramIntent.getBooleanExtra("shutCamera", false);
    this.u = paramIntent.getBooleanExtra("isDoubleVideoMeeting", false);
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onStartCommand  mIsAudioMode = ");
      paramIntent.append(this.k);
      paramIntent.append(", isDoubleVideoMeeting = ");
      paramIntent.append(this.u);
      QLog.d("VideoInviteFloatBarUICtr", 2, paramIntent.toString());
    }
    if (TextUtils.isEmpty(this.m))
    {
      if (QLog.isColorLevel()) {
        QLog.e("VideoInviteFloatBarUICtr", 2, "mPeerUin is empty!");
      }
      a();
    }
    else if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("mPeerUin : ");
      paramIntent.append(this.m);
      QLog.d("VideoInviteFloatBarUICtr", 2, paramIntent.toString());
    }
    if (this.u)
    {
      paramIntent = SessionMgr.a(100, this.m, new int[0]);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("sessionId : ");
        localStringBuilder.append(paramIntent);
        QLog.d("VideoInviteFloatBarUICtr", 2, localStringBuilder.toString());
      }
      this.l = SessionMgr.a().d(paramIntent);
      this.l.a(paramLong, "onStartCommand.1", 4);
      this.l.f("onStartCommand", true);
      this.l.bz = true;
      this.l.B = true;
      this.l.as = this.c.c(this.m);
      this.c.a(this.D);
      return 2;
    }
    paramIntent = SessionMgr.a(3, this.m, new int[0]);
    this.l = SessionMgr.a().d(paramIntent);
    if (this.k)
    {
      this.l.a(paramLong, "onStartCommand.2", 1);
      this.l.b(paramLong, false);
    }
    else
    {
      this.l.a(paramLong, "onStartCommand.3", 2);
      this.l.b(paramLong, this.t ^ true);
    }
    this.l.B = true;
    this.l.as = this.c.c(this.m);
    this.c.a(this.C);
    return 2;
  }
  
  public void a()
  {
    super.a();
    if (this.c != null)
    {
      try
      {
        this.c.getApplication().unregisterReceiver(this.B);
        this.c.b(this.D);
        this.c.b(this.C);
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onDestroy error : ");
        localStringBuilder.append(localException);
        QLog.d("VideoInviteFloatBarUICtr", 1, localStringBuilder.toString());
      }
      if (this.E != null)
      {
        this.c.a().removeCallbacks(this.E);
        this.E = null;
      }
    }
  }
  
  public void a(long paramLong)
  {
    boolean bool = e();
    int i = 1;
    if (!bool)
    {
      QLog.d("VideoInviteFloatBarUICtr", 1, "acceptVideoRequest return 1");
      return;
    }
    if (this.s == null)
    {
      QLog.d("VideoInviteFloatBarUICtr", 1, "acceptVideoRequest return 2");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("acceptVideoRequest, seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], mIsDoubleVideoMeeting[");
    localStringBuilder.append(this.u);
    localStringBuilder.append("]");
    QLog.w("VideoInviteFloatBarUICtr", 1, localStringBuilder.toString());
    bool = this.l.aK;
    if (!this.l.as) {
      i = 4;
    }
    if (1008 == this.l.p) {
      i = 4;
    }
    if (this.u) {
      this.s.a(paramLong, 3, Long.valueOf(this.l.s).longValue(), null, false);
    } else {
      this.s.a(paramLong, this.l.s, bool ^ true, i);
    }
    if (this.o != null) {
      this.o.c(HardCodeUtil.a(2131913486));
    }
    if (this.l.aK)
    {
      ReportController.b(null, "CliOper", "", "", "0X8008B24", "0X8008B24", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X8008B27", "0X8008B27", 0, 0, "", "", "", "");
  }
  
  void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.s.p();
  }
  
  public void b(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("refuseVideoRequest, seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w("VideoInviteFloatBarUICtr", 1, localStringBuilder.toString());
    if (this.l.aK) {
      ReportController.b(null, "CliOper", "", "", "0X8008B25", "0X8008B25", 0, 0, "", "", "", "");
    } else {
      ReportController.b(null, "CliOper", "", "", "0X8008B28", "0X8008B28", 0, 0, "", "", "", "");
    }
    if (this.u)
    {
      this.s.a(paramLong, this.m, 1, true);
      long l = CharacterUtil.b(this.m);
      this.s.a(paramLong, 3, l);
      this.s.a(paramLong, l, 1);
      a();
      return;
    }
    this.s.a(paramLong, this.m, 1, false);
    this.s.a(this.m, 252);
    this.s.b(252);
    this.s.b(this.m, 1);
  }
  
  void c()
  {
    c(-1039L);
  }
  
  public void c(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ignoreGAInvite, seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w("VideoInviteFloatBarUICtr", 1, localStringBuilder.toString());
    ReportController.b(null, "CliOper", "", "", "0X8008B2C", "0X8008B2C", 0, 0, "", "", "", "");
    if (!a(0)) {
      this.s.a(paramLong, this.h, this.d);
    }
    a();
  }
  
  public void d()
  {
    QLog.d("VideoInviteFloatBarUICtr", 1, "onCreate start");
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.NEW_OUTGOING_CALL");
    localIntentFilter.addAction("tencent.video.invite.accept");
    localIntentFilter.addAction("tencent.video.invite.refuse");
    localIntentFilter.addAction("tencent.video.invite.gaaccept");
    localIntentFilter.addAction("tencent.video.invite.gaignore");
    localIntentFilter.addAction("tencent.video.q2v.sdk.onRequestVideo");
    this.c.getApplication().registerReceiver(this.B, localIntentFilter);
  }
  
  public void d(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("acceptGAudioChat, seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w("VideoInviteFloatBarUICtr", 1, localStringBuilder.toString());
    if (this.o != null) {
      this.o.c(HardCodeUtil.a(2131913487));
    }
    this.s.a(paramLong, this.h, this.l.aN, this.j, false);
    ReportController.b(null, "CliOper", "", "", "0X8008B2B", "0X8008B2B", 0, 0, "", "", "", "");
    b();
  }
  
  protected boolean e()
  {
    if (this.v == null) {
      this.v = new VideoWifiLock(this.c.getApplication().getApplicationContext(), 1, "video wifi lock");
    }
    if (PhoneStatusTools.f(this.c.getApplication().getApplicationContext()))
    {
      VideoWifiLock localVideoWifiLock = this.v;
      if (localVideoWifiLock != null) {
        localVideoWifiLock.a();
      }
    }
    return true;
  }
  
  protected boolean f()
  {
    if (this.s == null)
    {
      QLog.d("VideoInviteFloatBarUICtr", 1, "VideoInviteFloatBarUICtr_quaReport mVideoController = null, return !");
      return false;
    }
    if (this.m == null)
    {
      QLog.d("VideoInviteFloatBarUICtr", 1, "VideoInviteFloatBarUICtr_quaReport mPeerUin = null, return !");
      return false;
    }
    return this.s.t(this.m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteFloatBarUICtr
 * JD-Core Version:    0.7.0.1
 */