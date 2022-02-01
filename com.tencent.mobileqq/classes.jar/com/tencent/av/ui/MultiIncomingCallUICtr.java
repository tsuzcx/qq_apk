package com.tencent.av.ui;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
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
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class MultiIncomingCallUICtr
  extends BaseInviteFloatBarUICtr
{
  public static boolean B = false;
  boolean A = false;
  QAVNotification C;
  VideoController D = null;
  String E = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;";
  GAudioUIObserver F = new MultiIncomingCallUICtr.3(this);
  VideoObserver G = new MultiIncomingCallUICtr.4(this);
  Runnable H = new MultiIncomingCallUICtr.5(this);
  private BroadcastReceiver I = new MultiIncomingCallUICtr.1(this);
  SessionMgr s = SessionMgr.a();
  boolean t = false;
  int u = 0;
  int v = -1;
  boolean w;
  String x = "";
  Runnable y = null;
  Intent z;
  
  public MultiIncomingCallUICtr(VideoController paramVideoController, VideoAppInterface paramVideoAppInterface, Intent paramIntent)
  {
    this.c = paramVideoAppInterface;
    this.D = paramVideoController;
    this.z = paramIntent;
  }
  
  public int a(Intent paramIntent)
  {
    long l = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStartCommand, seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w("MultiIncomingCallUICtr", 1, localStringBuilder.toString());
    }
    this.D = this.c.b();
    e();
    a(l, paramIntent);
    return 2;
  }
  
  public void a()
  {
    super.a();
    if (this.c != null)
    {
      try
      {
        this.c.getApplication().unregisterReceiver(this.I);
        this.c.b(this.F);
        this.c.b(this.G);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onDestroy error : ");
          localStringBuilder.append(localException);
          QLog.d("MultiIncomingCallUICtr", 2, localStringBuilder.toString());
        }
      }
      if (this.y != null)
      {
        this.c.a().removeCallbacks(this.y);
        this.y = null;
      }
      if (this.H != null)
      {
        this.c.a().removeCallbacks(this.H);
        this.H = null;
      }
    }
  }
  
  void a(long paramLong, int paramInt)
  {
    if (this.D == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("closeSession, reason[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.w("MultiIncomingCallUICtr", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = Long.valueOf(CharacterUtil.b(this.m));
    if (this.t)
    {
      if (paramInt == 1)
      {
        this.D.a(paramLong, ((Long)localObject).longValue(), 7);
        return;
      }
      if (paramInt == 2) {
        this.D.a(paramLong, ((Long)localObject).longValue(), 2);
      }
    }
    else
    {
      this.D.a(this.l.s, 243);
      this.D.b(243);
    }
  }
  
  void a(long paramLong1, int paramInt1, long paramLong2, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    VideoController localVideoController = this.D;
    if (localVideoController == null) {
      return;
    }
    if (!paramBoolean2) {
      localVideoController.a(paramLong1, paramInt1, paramLong2, 10, false);
    } else {
      localVideoController.a(paramLong1, paramInt1, paramLong2, paramInt2, false);
    }
    if ((paramBoolean1) && (this.c != null)) {
      this.c.a(new Object[] { Integer.valueOf(67), Long.valueOf(paramLong2), Integer.valueOf(3) });
    }
    ReportController.b(null, "CliOper", "", "", "0X8008B2C", "0X8008B2C", 0, 0, "", "", "", "");
    a();
  }
  
  void a(long paramLong, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    this.m = paramIntent.getStringExtra("peerUin");
    this.n = paramIntent.getStringExtra("extraUin");
    this.t = paramIntent.getBooleanExtra("isDoubleVideoMeeting", false);
    this.g = paramIntent.getIntExtra("uinType", 0);
    this.h = paramIntent.getIntExtra("relationType", 3);
    this.v = paramIntent.getIntExtra("memberType", -1);
    this.w = paramIntent.getBooleanExtra("hasGVideoJoined", false);
    this.k = paramIntent.getBooleanExtra("isAudioMode", false);
    this.u = paramIntent.getIntExtra("bindType", 0);
    Object localObject;
    if (AVUtil.e(this.g))
    {
      if (paramIntent.getIntExtra("MultiAVType", -1) == 2) {
        this.k = false;
      } else {
        this.k = true;
      }
      this.i = paramIntent.getLongExtra("friendUin", 0L);
      this.x = paramIntent.getStringExtra("inviteId");
      this.d = paramIntent.getLongExtra("discussId", 0L);
      localObject = SessionMgr.a(this.h, String.valueOf(this.d), new int[0]);
      this.l = this.s.d((String)localObject);
      this.j = paramIntent.getLongArrayExtra("memberList");
      this.c.a(this.F);
    }
    else if (this.t)
    {
      paramIntent = SessionMgr.a(100, this.m, new int[0]);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sessionId : ");
        ((StringBuilder)localObject).append(paramIntent);
        QLog.d("MultiIncomingCallUICtr", 2, ((StringBuilder)localObject).toString());
      }
      this.k = false;
      this.l = SessionMgr.a().d(paramIntent);
      this.l.a(paramLong, "processIntent.1", 4);
      this.l.f("processIntent", true);
      this.l.bz = true;
      this.l.B = true;
      this.l.as = this.c.c(this.m);
      this.c.a(this.F);
    }
    else
    {
      paramIntent = SessionMgr.a(3, this.m, new int[0]);
      this.l = SessionMgr.a().d(paramIntent);
      if (this.k)
      {
        this.l.a(paramLong, "processIntent.2", 1);
        this.l.b(paramLong, false);
      }
      else
      {
        this.l.a(paramLong, "processIntent.3", 2);
        this.l.b(paramLong, true);
      }
      this.l.B = true;
      this.l.as = this.c.c(this.m);
      this.c.a(this.G);
    }
    a(true);
    if ((this.l == null) && (this.g != 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiIncomingCallUICtr", 2, "session info null!");
      }
      a();
    }
  }
  
  void a(long paramLong, SessionInfo paramSessionInfo)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("acceptRequest, seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.w("MultiIncomingCallUICtr", 1, ((StringBuilder)localObject).toString());
    }
    this.A = true;
    Object localObject = SessionMgr.a().b();
    boolean bool = false;
    if ((paramSessionInfo != null) && (localObject == paramSessionInfo))
    {
      if (SessionMgr.a().c() >= 2)
      {
        if (paramSessionInfo.h())
        {
          a(paramLong, false, paramSessionInfo);
        }
        else
        {
          this.D.a(true, 201, new int[] { ((SessionInfo)localObject).o });
          this.D.b(201);
        }
        a(paramSessionInfo);
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("MultiIncomingCallUICtr", 2, "no need to close main session because there is only one session");
      }
    }
    else if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mainSession invalid when accept 3rd request, currMainSession == mainSessionInfo:");
      if (localObject == paramSessionInfo) {
        bool = true;
      }
      localStringBuilder.append(bool);
      QLog.d("MultiIncomingCallUICtr", 2, localStringBuilder.toString());
    }
    if (this.l != null)
    {
      if (!this.l.h())
      {
        if (QLog.isColorLevel())
        {
          paramSessionInfo = new StringBuilder();
          paramSessionInfo.append("Session already destroyed, id:");
          paramSessionInfo.append(this.l.f);
          paramSessionInfo.append(", status = ");
          paramSessionInfo.append(this.l.i);
          QLog.d("MultiIncomingCallUICtr", 2, paramSessionInfo.toString());
        }
      }
      else if (AVUtil.e(this.g))
      {
        this.D.a(paramLong, this.h, this.l.aN, this.j, false);
        ReportController.b(null, "CliOper", "", "", "0X8008B2B", "0X8008B2B", 0, 0, "", "", "", "");
      }
      else
      {
        int i = true ^ this.k;
        if (QLog.isColorLevel())
        {
          paramSessionInfo = new StringBuilder();
          paramSessionInfo.append("appType :");
          paramSessionInfo.append(i);
          QLog.d("MultiIncomingCallUICtr", 2, paramSessionInfo.toString());
        }
        if (this.t)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MultiIncomingCallUICtr", 2, "acceptVideoRequest isDoubleVideoMeeting");
          }
          this.D.a(paramLong, 3, Long.valueOf(this.l.s).longValue(), null, false);
          ReportController.b(null, "CliOper", "", "", "0X8008B2B", "0X8008B2B", 0, 0, "", "", "", "");
        }
        else
        {
          int j = UITools.d(this.h);
          this.D.a(paramLong, this.m, i, j);
          if (this.k) {
            ReportController.b(null, "CliOper", "", "", "0X8008B24", "0X8008B24", 0, 0, "", "", "", "");
          } else {
            ReportController.b(null, "CliOper", "", "", "0X8008B27", "0X8008B27", 0, 0, "", "", "", "");
          }
        }
        b();
      }
      if (this.o != null) {
        this.o.c(HardCodeUtil.a(2131904882));
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("MultiIncomingCallUICtr", 2, "session invalid when accept request");
    }
  }
  
  void a(long paramLong, boolean paramBoolean, SessionInfo paramSessionInfo)
  {
    a(paramLong, paramBoolean, paramSessionInfo, -1);
  }
  
  void a(long paramLong, boolean paramBoolean, SessionInfo paramSessionInfo, int paramInt)
  {
    if (paramBoolean) {
      this.A = false;
    }
    TraeHelper.b(this.c);
    Object localObject = this.m;
    boolean bool1 = this.t;
    int i = this.h;
    long l = this.d;
    if (!paramBoolean) {
      if (paramSessionInfo != null)
      {
        String str = paramSessionInfo.s;
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = paramSessionInfo.aW;
        }
        bool1 = paramSessionInfo.am;
        i = paramSessionInfo.aQ;
        l = paramSessionInfo.aN;
      }
      else
      {
        return;
      }
    }
    int j = UITools.c(i);
    boolean bool2;
    if ((!paramBoolean) && ((bool1) || (a(j)))) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if (AVUtil.e(j))
    {
      a(paramLong, i, l, bool2, paramInt, paramBoolean);
      return;
    }
    a(paramLong, bool1, (String)localObject, bool2, paramBoolean);
  }
  
  void a(long paramLong, boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.D == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refuseDoubleCall, isDoubleVideoMeeting[");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append("], peerUin[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], notifyDestroyUI[");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append("], refuse3rd[");
      localStringBuilder.append(paramBoolean3);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w("MultiIncomingCallUICtr", 1, localStringBuilder.toString());
    }
    if (this.l.aK) {
      ReportController.b(null, "CliOper", "", "", "0X8008B25", "0X8008B25", 0, 0, "", "", "", "");
    } else {
      ReportController.b(null, "CliOper", "", "", "0X8008B28", "0X8008B28", 0, 0, "", "", "", "");
    }
    if (paramBoolean1)
    {
      this.D.a(paramLong, paramString, 1, true);
      long l2 = -1L;
      long l1;
      try
      {
        l1 = CharacterUtil.b(paramString);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.d("MultiIncomingCallUICtr", 2, "", localNumberFormatException);
          l1 = l2;
        }
      }
      if (!paramBoolean3)
      {
        this.D.a(paramLong, 3, l1, 10, false);
        this.D.a(paramLong, l1, 23);
        a();
      }
      else
      {
        this.D.a(paramLong, 3, l1);
        this.D.a(paramLong, l1, 1);
        a();
      }
    }
    else
    {
      VideoController localVideoController = this.D;
      localVideoController.a(paramLong, paramString, 1, false, new MultiIncomingCallUICtr.2(this, localVideoController, paramString, paramBoolean3));
    }
    if ((paramBoolean2) && (this.c != null)) {
      this.c.a(new Object[] { Integer.valueOf(28), paramString, Boolean.valueOf(true) });
    }
  }
  
  void a(SessionInfo paramSessionInfo)
  {
    if ((this.D != null) && (paramSessionInfo != null))
    {
      Intent localIntent = new Intent();
      localIntent.setPackage(this.c.getApp().getPackageName());
      localIntent.setAction("tencent.av.v2q.StopVideoChat");
      localIntent.putExtra("stopReason3rd", 1);
      localIntent.putExtra("groupId", paramSessionInfo.aN);
      localIntent.putExtra("peerUin", paramSessionInfo.s);
      this.c.getApp().sendBroadcast(localIntent);
    }
  }
  
  boolean a(int paramInt)
  {
    return paramInt == 3000;
  }
  
  boolean b(int paramInt)
  {
    if ((this.g == 1) && (!TextUtils.isEmpty(this.x)))
    {
      Intent localIntent = new Intent("tencent.video.v2q.ACTION_DEAL_INVITE_TO_ENTER_GROUP_VEDIO");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.d);
      localStringBuilder.append("");
      localIntent.putExtra("relationId", localStringBuilder.toString());
      localIntent.putExtra("dealResult", paramInt);
      localIntent.putExtra("inviteId", this.x);
      localIntent.putExtra("friendUin", this.i);
      localIntent.setPackage(this.c.getApp().getPackageName());
      this.c.getApp().sendBroadcast(localIntent);
      if (QLog.isDevelopLevel()) {
        QLog.d("MultiIncomingCallUICtr", 2, "sendBroadcast, qav_gaudio_join");
      }
      return true;
    }
    return false;
  }
  
  void c()
  {
    if (!b(0)) {
      a(-1036L, true, null);
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiIncomingCallUICtr", 2, "onCreate start");
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.NEW_OUTGOING_CALL");
    localIntentFilter.addAction("tencent.video.invite.multiaccept");
    localIntentFilter.addAction("tencent.video.invite.multirefuse");
    localIntentFilter.addAction("tencent.av.EXIT_QZONE_LIVE_RSP_ACTION");
    localIntentFilter.addAction("tencent.video.destroyService");
    this.c.getApplication().registerReceiver(this.I, localIntentFilter);
  }
  
  boolean e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiIncomingCallUICtr", 2, "initEnvParam");
    }
    if (this.c != null)
    {
      this.D = this.c.b();
      VideoController localVideoController = this.D;
      if (localVideoController != null)
      {
        if ((localVideoController.k().m()) || (this.D.k().n()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MultiIncomingCallUICtr", 2, "initEnvParam closeSession");
          }
          localVideoController = this.D;
          localVideoController.b(localVideoController.k().s, 2);
        }
        return true;
      }
    }
    return false;
  }
  
  void f()
  {
    Intent localIntent = new Intent("tencent.video.v2q.ACTION_ENTER_GROUP_VEDIO");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d);
    localStringBuilder.append("");
    localIntent.putExtra("relationId", localStringBuilder.toString());
    localIntent.putExtra("enterType", 1);
    localIntent.setPackage(this.c.getApp().getPackageName());
    this.c.getApp().sendBroadcast(localIntent);
    if (QLog.isDevelopLevel()) {
      QLog.d("MultiIncomingCallUICtr.troopgroup_vedio.invite", 2, "sendBroadcast, qav_gaudio_answer");
    }
    this.c.a(new Object[] { Integer.valueOf(514), Long.valueOf(this.d) });
    b(1);
  }
  
  void g()
  {
    if (this.C == null) {
      this.C = QAVNotification.a(this.c);
    }
    if (!AVUtil.e(this.g))
    {
      localObject = this.c.a(this.g, this.m, this.n, true, true);
      if ((!this.k) && (!this.t))
      {
        this.C.a(this.l.f, this.e, (Bitmap)localObject, null, 56, this.g, 2);
        return;
      }
      this.C.a(this.l.f, this.e, (Bitmap)localObject, null, 55, this.g, 1);
      return;
    }
    Object localObject = String.valueOf(this.d);
    Bitmap localBitmap = this.c.a(this.g, (String)localObject, null, true, true);
    int i = AVUtil.c(this.g);
    String str = this.c.a(i, Long.toString(this.i), (String)localObject);
    if (this.l != null) {
      this.C.a(this.l.f, str, localBitmap, (String)localObject, 57, this.g, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallUICtr
 * JD-Core Version:    0.7.0.1
 */