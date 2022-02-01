package com.tencent.av.screenshare;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.VideoRecoveryMonitor;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.ScreenRecordHelper;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.PopupDialog;
import com.tencent.avcore.data.RecordParam;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class ScreenShareCtrl
{
  private final VideoController a;
  private ScreenShareCtrl.ScreenShareListener b = null;
  private ScreenShareCtrl.ShareOpsTimeOutTask c = null;
  private final RecordParam d = new RecordParam();
  private int e = 0;
  private int f = 0;
  private WeakReference<AVActivity> g = null;
  private Runnable h = null;
  private ScreenShareCtrl.DoubleMeetingInviteTimeOutTask i = null;
  
  public ScreenShareCtrl(VideoController paramVideoController)
  {
    this.a = paramVideoController;
  }
  
  private int a(SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    QQGAudioCtrl localQQGAudioCtrl = this.a.F();
    VideoAppInterface localVideoAppInterface = this.a.e;
    boolean bool = false;
    if (localQQGAudioCtrl != null)
    {
      if (localVideoAppInterface == null) {
        return 0;
      }
      int j = 4;
      if (paramInt1 == 1) {
        paramSessionInfo.a("executeShareScreenOps", 1, paramInt2);
      } else if (paramInt1 == 2) {
        paramSessionInfo.a("executeShareScreenOps", 4, paramInt2);
      }
      if (paramInt1 == 2) {
        bool = true;
      }
      if (!localQQGAudioCtrl.startOrStopShareSend(bool, paramInt2))
      {
        if (paramInt1 == 1)
        {
          paramSessionInfo.a("executeShareScreenOps", 3, paramInt2);
          return 4;
        }
        if (paramInt1 == 2)
        {
          paramSessionInfo.a("executeShareScreenOps", 6, paramInt2);
          return 4;
        }
      }
      else
      {
        if (this.c != null)
        {
          localVideoAppInterface.a().removeCallbacks(this.c);
          this.c = null;
        }
        this.c = new ScreenShareCtrl.ShareOpsTimeOutTask(this.a, paramSessionInfo, paramInt1, paramInt2);
        localVideoAppInterface.a().postDelayed(this.c, 30000L);
        j = 1;
      }
      return j;
    }
    return 0;
  }
  
  private boolean a(QQGAudioCtrl paramQQGAudioCtrl)
  {
    return (paramQQGAudioCtrl != null) && (this.a.k().cj == 2);
  }
  
  private void b()
  {
    if (this.h == null) {
      this.h = new ScreenShareCtrl.2(this);
    }
    if ((this.a.e != null) && (this.h != null)) {
      this.a.e.a().postDelayed(this.h, 20000L);
    }
  }
  
  public static void b(int paramInt)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    Object localObject = localBaseApplication.getResources();
    if (paramInt != 1)
    {
      if (paramInt != 7)
      {
        if (paramInt != 8) {
          localObject = null;
        } else {
          localObject = ((Resources)localObject).getString(2131893611);
        }
      }
      else {
        localObject = ((Resources)localObject).getString(2131893608);
      }
    }
    else {
      localObject = ((Resources)localObject).getString(2131893610);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      QQToast.makeText(localBaseApplication, -1, (CharSequence)localObject, 0).show();
    }
  }
  
  @TargetApi(21)
  private void b(AVActivity paramAVActivity, long paramLong)
  {
    if ((paramAVActivity != null) && (!paramAVActivity.isFinishing()) && (!paramAVActivity.isDestroyed()))
    {
      int j = ScreenShareTipsHelper.a();
      PopupDialog.a(paramAVActivity, 230, null, ScreenShareTipsHelper.b(), 2131893377, 2131893377, null, new ScreenShareCtrl.1(this, paramAVActivity, paramLong));
      ReportController.b(null, "dc00898", "", "", "0X800B48D", "0X800B48D", j, 0, "", "", "", "");
      return;
    }
  }
  
  public static boolean b(SessionInfo paramSessionInfo)
  {
    boolean bool = true;
    if (paramSessionInfo != null)
    {
      if (paramSessionInfo.cj == 2) {
        return bool;
      }
      if (paramSessionInfo.cj == 1) {
        return true;
      }
    }
    bool = false;
    return bool;
  }
  
  private void c(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("stopShareScreen, from[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("]");
      QLog.i("AVShare", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.g;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (AVActivity)((WeakReference)localObject).get();
    }
    SessionInfo localSessionInfo = this.a.k();
    if (b(localSessionInfo))
    {
      a((AVActivity)localObject, 1L);
      if (localObject != null) {
        ((AVActivity)localObject).runOnUiThread(new ScreenShareCtrl.3(this, (AVActivity)localObject, localSessionInfo));
      }
    }
  }
  
  public int a(int paramInt)
  {
    if (this.a.F() == null) {
      return 2;
    }
    SessionInfo localSessionInfo = this.a.k();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestShareScreenOps, emShareOps[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], cur[");
      localStringBuilder.append(localSessionInfo.cj);
      localStringBuilder.append(",");
      localStringBuilder.append(localSessionInfo.ck);
      localStringBuilder.append("]");
      QLog.i("AVShare", 2, localStringBuilder.toString());
    }
    int k = localSessionInfo.ck;
    int j = 1;
    if ((k != 1) && (localSessionInfo.ck != 0)) {
      return 3;
    }
    if (paramInt != 1) {
      if (paramInt != 2) {}
    }
    switch (localSessionInfo.cj)
    {
    default: 
      break;
    case 1: 
    case 2: 
    case 3: 
    case 6: 
      return a(localSessionInfo, paramInt, 1);
      for (;;)
      {
        return 0;
        switch (localSessionInfo.cj)
        {
        }
      }
      j = a(localSessionInfo, paramInt, 1);
    }
    return j;
  }
  
  public ScreenShareCtrl.ScreenShareListener a()
  {
    if (this.b == null) {
      this.b = new ScreenShareCtrl.ScreenShareListener(this);
    }
    return this.b;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, int paramInt5)
  {
    Object localObject = this.a.e;
    if (localObject == null) {
      return;
    }
    SessionInfo localSessionInfo = this.a.k();
    if ((localSessionInfo.aQ == paramInt3) && (localSessionInfo.aN == paramLong))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onShareOpsCallback, session[");
        localStringBuilder.append(localSessionInfo);
        localStringBuilder.append("], [");
        localStringBuilder.append(paramInt3);
        localStringBuilder.append(",");
        localStringBuilder.append(paramLong);
        localStringBuilder.append(",");
        localStringBuilder.append(paramInt4);
        localStringBuilder.append(",");
        localStringBuilder.append(paramInt5);
        localStringBuilder.append("], actionResult[");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append("], shareType[");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append("]");
        QLog.i("AVShare", 2, localStringBuilder.toString());
      }
      if (this.c != null)
      {
        ((VideoAppInterface)localObject).a().removeCallbacks(this.c);
        this.c = null;
      }
      paramInt5 = localSessionInfo.cj;
      switch (paramInt1)
      {
      default: 
        paramInt1 = paramInt5;
        break;
      case 88: 
      case 89: 
        paramInt1 = paramInt5;
        if (localSessionInfo.cj == 4) {
          paramInt1 = 6;
        }
        ScreenShareReportHelper.b(localSessionInfo.f, "onShareOpsCallback");
        break;
      case 87: 
        paramInt1 = paramInt5;
        if (localSessionInfo.cj == 4) {
          paramInt1 = 5;
        }
        ScreenShareReportHelper.b(localSessionInfo.f, "onShareOpsCallback");
        break;
      case 85: 
      case 86: 
        paramInt1 = paramInt5;
        if (localSessionInfo.cj == 1) {
          paramInt1 = 3;
        }
        break;
      case 84: 
        paramInt1 = paramInt5;
        if (localSessionInfo.cj == 1) {
          paramInt1 = 2;
        }
        ScreenShareReportHelper.a(localSessionInfo.f, "onShareOpsCallback");
      }
      if (paramInt1 != localSessionInfo.cj)
      {
        localSessionInfo.a("onShareOpsCallback", paramInt1, paramInt2);
        ((VideoAppInterface)localObject).a(new Object[] { Integer.valueOf(519), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong), Integer.valueOf(paramInt4) });
      }
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onShareOpsCallback, error session, session[");
    ((StringBuilder)localObject).append(localSessionInfo);
    ((StringBuilder)localObject).append("], [");
    ((StringBuilder)localObject).append(paramInt3);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(paramInt4);
    ((StringBuilder)localObject).append(",");
    ((StringBuilder)localObject).append(paramInt5);
    ((StringBuilder)localObject).append("], actionResult[");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("], shareType[");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("]");
    QLog.i("AVShare", 1, ((StringBuilder)localObject).toString());
  }
  
  @TargetApi(21)
  public void a(int paramInt, long paramLong, RecordParam paramRecordParam)
  {
    if (paramRecordParam == null) {
      return;
    }
    Object localObject = this.a.k();
    if (((SessionInfo)localObject).aQ == paramInt)
    {
      if (((SessionInfo)localObject).aN != paramLong) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onRecSharePushEncParam, param[");
        localStringBuilder.append(paramRecordParam);
        localStringBuilder.append("], session[");
        localStringBuilder.append(localObject);
        localStringBuilder.append("]");
        QLog.i("AVShare", 2, localStringBuilder.toString());
      }
      if (((SessionInfo)localObject).cj == 2)
      {
        localObject = this.a.aE();
        if (localObject != null) {
          ((ScreenRecordHelper)localObject).a(paramRecordParam.width, paramRecordParam.height, paramRecordParam.fps);
        }
      }
    }
  }
  
  public void a(long paramLong)
  {
    Object localObject1 = this.a.k();
    long l1;
    try
    {
      l1 = Long.parseLong(((SessionInfo)localObject1).s);
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      l1 = 0L;
    }
    long l2 = l1;
    if (l1 == 0L)
    {
      l2 = l1;
      if (((SessionInfo)localObject1).aN != 0L) {
        l2 = ((SessionInfo)localObject1).aN;
      }
    }
    if (l2 == 0L)
    {
      QLog.i("normal_2_meeting", 1, "switchToDoubleMeeting relationId illegal.");
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("switchToDoubleMeeting, session[");
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append("]");
      QLog.i("normal_2_meeting", 2, ((StringBuilder)localObject2).toString());
    }
    SessionMgr localSessionMgr = SessionMgr.a();
    int j = ((SessionInfo)localObject1).g;
    String str2 = ((SessionInfo)localObject1).f;
    String str1 = SessionMgr.a(100, String.valueOf(l2), new int[0]);
    Object localObject2 = localSessionMgr.a(str1, false);
    ((SessionInfo)localObject2).b(paramLong, ((SessionInfo)localObject1).H);
    ((SessionInfo)localObject2).E = ((SessionInfo)localObject1).E;
    ((SessionInfo)localObject2).cn = ((SessionInfo)localObject1).H;
    ((SessionInfo)localObject2).b("switchToDoubleMeeting", ((SessionInfo)localObject1).aG);
    ((SessionInfo)localObject2).b("switchToDoubleMeeting", ((SessionInfo)localObject1).aD);
    ((SessionInfo)localObject2).s = ((SessionInfo)localObject1).s;
    if (TextUtils.isEmpty(((SessionInfo)localObject2).s)) {
      ((SessionInfo)localObject2).s = String.valueOf(l2);
    }
    ((SessionInfo)localObject2).t = ((SessionInfo)localObject1).t;
    ((SessionInfo)localObject2).o = 8;
    ((SessionInfo)localObject2).ch = true;
    ((SessionInfo)localObject2).aQ = 3;
    ((SessionInfo)localObject2).aN = l2;
    ((SessionInfo)localObject2).p = 0;
    ((SessionInfo)localObject2).d("switchToDoubleMeeting", true);
    ((SessionInfo)localObject2).c(((SessionInfo)localObject1).cp);
    ((SessionInfo)localObject2).d(((SessionInfo)localObject1).cq);
    ((SessionInfo)localObject2).ci = 5;
    this.a.r(true);
    this.a.a(((SessionInfo)localObject1).s, 8);
    this.a.b(262);
    this.a.b(((SessionInfo)localObject1).s, 72);
    this.a.r = 3;
    if (localSessionMgr.a(str2))
    {
      boolean bool = localSessionMgr.a(paramLong, str2);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("switchToDoubleMeeting, need double remove. ret[");
      ((StringBuilder)localObject1).append(bool);
      ((StringBuilder)localObject1).append("]");
      QLog.i("AVShare", 2, ((StringBuilder)localObject1).toString());
    }
    if (localSessionMgr.b() != localObject2) {
      localSessionMgr.e(str1);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("switchToDoubleMeeting, after close pre one. cur[");
      ((StringBuilder)localObject1).append(this.a.k());
      ((StringBuilder)localObject1).append("]");
      QLog.i("normal_2_meeting", 2, ((StringBuilder)localObject1).toString());
    }
    ((SessionInfo)localObject2).ay = -1;
    if (j == 1) {
      ((SessionInfo)localObject2).a(paramLong, "switchToDoubleMeeting.1", 3);
    } else if (j == 2) {
      ((SessionInfo)localObject2).a(paramLong, "switchToDoubleMeeting.2", 4);
    }
    ((SessionInfo)localObject2).p = 0;
    ((SessionInfo)localObject2).aN = l2;
    ((SessionInfo)localObject2).d("switchToDoubleMeeting", 0);
    this.a.e.a(new Object[] { Integer.valueOf(174), Long.valueOf(paramLong) });
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onSwitch2DoubleMeeting, seq[");
      ((StringBuilder)localObject1).append(paramLong1);
      ((StringBuilder)localObject1).append("], uin[");
      ((StringBuilder)localObject1).append(paramLong2);
      ((StringBuilder)localObject1).append("], avtype[");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append("], subType[");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append("]");
      QLog.i("normal_2_meeting", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.h != null)
    {
      this.a.e.a().removeCallbacks(this.h);
      this.h = null;
    }
    Object localObject2 = SessionMgr.a(100, String.valueOf(paramLong2), new int[0]);
    Object localObject1 = this.a.k();
    localObject2 = SessionMgr.a().d((String)localObject2);
    ((SessionInfo)localObject2).aK = true;
    ((SessionInfo)localObject2).h = 2;
    ((SessionInfo)localObject2).u = null;
    ((SessionInfo)localObject2).B = true;
    ((SessionInfo)localObject2).aW = String.valueOf(paramLong2);
    ((SessionInfo)localObject2).s = ((SessionInfo)localObject1).s;
    ((SessionInfo)localObject2).t = ((SessionInfo)localObject1).t;
    ((SessionInfo)localObject2).cn = ((SessionInfo)localObject1).H;
    ((SessionInfo)localObject2).b(paramLong1, false);
    ((SessionInfo)localObject2).E = ((SessionInfo)localObject1).E;
    ((SessionInfo)localObject2).b("onSwitch2DoubleMeeting", ((SessionInfo)localObject1).aG);
    ((SessionInfo)localObject2).b("onSwitch2DoubleMeeting", ((SessionInfo)localObject1).aD);
    ((SessionInfo)localObject2).ch = true;
    if (((SessionInfo)localObject1).g == 1) {
      ((SessionInfo)localObject2).a(paramLong1, "onSwitch2DoubleMeeting.1", 3);
    } else {
      ((SessionInfo)localObject2).a(paramLong1, "onSwitch2DoubleMeeting.2", 4);
    }
    ((SessionInfo)localObject2).p = ((SessionInfo)localObject1).p;
    ((SessionInfo)localObject2).aN = paramLong2;
    ((SessionInfo)localObject2).aQ = 3;
    ((SessionInfo)localObject2).o = 8;
    ((SessionInfo)localObject2).f("onSwitch2DoubleMeeting", true);
    ((SessionInfo)localObject2).d("onSwitch2DoubleMeeting", true);
    ((SessionInfo)localObject2).b("onSwitch2DoubleMeeting", 17);
    ((SessionInfo)localObject2).a("onSwitch2DoubleMeeting", 2);
    SessionMgr localSessionMgr = SessionMgr.a();
    VideoRecoveryMonitor localVideoRecoveryMonitor = this.a.e.d();
    if (localVideoRecoveryMonitor != null) {
      localVideoRecoveryMonitor.a(262);
    }
    this.a.b(((SessionInfo)localObject1).s, 72);
    if ((!TextUtils.isEmpty(((SessionInfo)localObject1).f)) && (localSessionMgr.a(((SessionInfo)localObject1).f)))
    {
      boolean bool = localSessionMgr.a(paramLong1, ((SessionInfo)localObject1).f);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onSwitch2DoubleMeeting, need double remove ret[");
        ((StringBuilder)localObject1).append(bool);
        ((StringBuilder)localObject1).append("]");
        QLog.i("AVShare", 2, ((StringBuilder)localObject1).toString());
      }
    }
    if (this.a.k() != localObject2)
    {
      localSessionMgr.e(((SessionInfo)localObject2).f);
      if (QLog.isColorLevel()) {
        QLog.i("AVShare", 2, "onSwitch2DoubleMeeting, need double set main session. ");
      }
    }
    ((SessionInfo)localObject2).d("onSwitch2DoubleMeeting", 1);
    if (this.a.e.f() > 0) {
      this.a.e.a(new Object[] { Integer.valueOf(174), Long.valueOf(paramLong1) });
    } else if (this.a.e.isBackgroundStop) {
      this.a.a(paramLong1, 3, paramLong2, new long[] { paramLong2 }, false);
    }
    this.a.a(((SessionInfo)localObject2).f, ((SessionInfo)localObject2).g, false, false, true);
  }
  
  public void a(Bitmap paramBitmap, RecordParam paramRecordParam)
  {
    if (paramRecordParam == null) {
      return;
    }
    QQGAudioCtrl localQQGAudioCtrl = this.a.F();
    if (a(localQQGAudioCtrl))
    {
      if (!this.d.equals(paramRecordParam))
      {
        this.d.update(paramRecordParam);
        localQQGAudioCtrl.setShareEncParam(this.d, this.e, this.f, 1);
      }
      if (localQQGAudioCtrl.sendShareFrame(paramBitmap, paramRecordParam.width, paramRecordParam.height) != 0) {
        c(2);
      }
    }
    else if (localQQGAudioCtrl == null)
    {
      c(1);
    }
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startDoubleMeetingTimeOutTask, info[");
      localStringBuilder.append(paramSessionInfo);
      localStringBuilder.append("]");
      QLog.i("AVShare", 2, localStringBuilder.toString());
    }
    if (this.i != null) {
      this.a.e.a().removeCallbacks(this.i);
    }
    this.i = new ScreenShareCtrl.DoubleMeetingInviteTimeOutTask(this.a, paramSessionInfo);
    this.a.e.a().postDelayed(this.i, 15000L);
  }
  
  @TargetApi(21)
  public void a(AVActivity paramAVActivity, long paramLong)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    if (paramAVActivity != null) {
      this.g = new WeakReference(paramAVActivity);
    }
    SessionInfo localSessionInfo = this.a.k();
    boolean bool = QLog.isColorLevel();
    int j = 2;
    if (bool)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startOrStopScreenShare, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.i("AVShare", 2, localStringBuilder.toString());
    }
    int k = localSessionInfo.cj;
    Object localObject = null;
    StringBuilder localStringBuilder = null;
    if ((k != 2) && (localSessionInfo.cj != 1))
    {
      if (localSessionInfo.b(this.a.e.getCurrentAccountUin()))
      {
        b(1);
        return;
      }
      if (localSessionInfo.s())
      {
        b(8);
        return;
      }
      if ((paramAVActivity != null) && ((ScreenShareTipsHelper.a() == 1) || (ScreenShareTipsHelper.a() == 2)))
      {
        b(paramAVActivity, paramLong);
        return;
      }
      if (paramAVActivity == null) {
        paramAVActivity = localStringBuilder;
      } else {
        paramAVActivity = paramAVActivity.v();
      }
      if (paramAVActivity != null)
      {
        paramAVActivity.a(a());
        paramAVActivity.a(a());
        paramAVActivity.a();
      }
    }
    else
    {
      if (a(2) != 1) {
        j = 3;
      }
      b(j);
      if (paramAVActivity == null) {
        paramAVActivity = localObject;
      } else {
        paramAVActivity = paramAVActivity.v();
      }
      if (paramAVActivity != null) {
        paramAVActivity.b(1);
      }
    }
  }
  
  public void a(RecordParam paramRecordParam, int paramInt1, int paramInt2)
  {
    QQGAudioCtrl localQQGAudioCtrl = this.a.F();
    if (localQQGAudioCtrl != null)
    {
      if (paramRecordParam == null) {
        return;
      }
      this.d.update(paramRecordParam);
      if (paramInt1 != 0) {
        this.e = paramInt1;
      }
      if (paramInt2 != 0) {
        this.f = paramInt2;
      }
      localQQGAudioCtrl.setShareEncParam(this.d, this.e, this.f, 0);
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    long l = AudioHelper.c();
    paramArrayOfByte = this.a.k();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSwitchMeeting, fromUin[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], flag[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], session[");
      localStringBuilder.append(paramArrayOfByte);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w("normal_2_meeting", 2, localStringBuilder.toString());
    }
    if (paramArrayOfByte.am) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (!paramString.equalsIgnoreCase(paramArrayOfByte.s)) {
      return;
    }
    paramArrayOfByte.d("onSwitchMeeting", true);
    paramArrayOfByte.aN = 0L;
    paramArrayOfByte.b("onSwitchMeeting", 16);
    this.a.e.a(new Object[] { Integer.valueOf(174), Long.valueOf(l) });
    b();
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, RecordParam paramRecordParam)
  {
    if (paramRecordParam == null) {
      return;
    }
    QQGAudioCtrl localQQGAudioCtrl = this.a.F();
    if (a(localQQGAudioCtrl))
    {
      if (!this.d.equals(paramRecordParam))
      {
        this.d.update(paramRecordParam);
        localQQGAudioCtrl.setShareEncParam(this.d, this.e, this.f, 1);
      }
      if (localQQGAudioCtrl.sendShareFrame(paramArrayOfByte, paramInt1, paramRecordParam.width, paramRecordParam.height, paramInt2) != 0) {
        c(2);
      }
    }
    else if (localQQGAudioCtrl == null)
    {
      c(1);
    }
  }
  
  public void b(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("removeDoubleMeetingTimeOutTask, info[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.i("AVShare", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.i;
    if ((localObject != null) && (((ScreenShareCtrl.DoubleMeetingInviteTimeOutTask)localObject).a.aN == paramLong))
    {
      this.a.e.a().removeCallbacks(this.i);
      this.i = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.screenshare.ScreenShareCtrl
 * JD-Core Version:    0.7.0.1
 */