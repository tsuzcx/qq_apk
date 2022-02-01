package com.tencent.av.smallscreen;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.WindowManager;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.screenshare.ScreenShareCtrl;
import com.tencent.av.ui.ScreenRecordHelper;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;

public class SmallScreenService
  extends BaseSmallScreenService
  implements SmallScreenRelativeLayout.FloatListener
{
  public static boolean p = false;
  private GAudioUIObserver A = new SmallScreenService.2(this);
  boolean q = false;
  Runnable r = null;
  SmallScreenService.OnSelectMemberActivityIsResumeChangedRunnable s = null;
  SmallScreenVideoController t = null;
  VideoAppInterface u;
  VideoController v = null;
  WindowManager w = null;
  final boolean[] x = new boolean[4];
  final boolean[] y = new boolean[4];
  BroadcastReceiver z = new SmallScreenService.1(this);
  
  private void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if (paramBoolean1)
    {
      localObject = this.y;
      if ((localObject[0] != 0) || (localObject[1] != 0))
      {
        if (this.i == 3) {
          return;
        }
        a(paramLong, 3);
        return;
      }
    }
    if ((!paramBoolean2) && (!this.c))
    {
      if (!this.f) {
        return;
      }
      if (this.i != 2)
      {
        if ((paramBoolean1) && (this.y[2] != 0)) {
          a(paramLong, 2);
        }
        if ((paramBoolean1) && (this.y[3] != 0))
        {
          a(paramLong, 2);
          return;
        }
        if (this.i == 1)
        {
          localObject = b();
          if (this.r == null) {
            this.r = new SmallScreenService.4(this, paramLong);
          }
          ((Handler)localObject).removeCallbacks(this.r);
          p = true;
          ((Handler)localObject).postDelayed(this.r, 1000L);
          return;
        }
        a(paramLong, 2);
      }
    }
  }
  
  private void a(String paramString)
  {
    if ((!this.d) && (this.v != null))
    {
      boolean bool;
      if ((Build.VERSION.SDK_INT >= 21) && (this.v.aE().e())) {
        bool = true;
      } else {
        bool = false;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initSmallScreenVideoUI, shareScreen[");
        localStringBuilder.append(bool);
        localStringBuilder.append("], uiCtrl[");
        localStringBuilder.append(this.t);
        localStringBuilder.append("], from[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.i("SmallScreenService", 2, localStringBuilder.toString());
      }
      if ((!bool) && (this.t == null))
      {
        this.t = new SmallScreenVideoController(this);
        this.t.a(this.app);
        this.t.e();
        this.t.f();
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("SmallScreenService", 2, "initSmallScreenVideoUI, isDestroyed.");
    }
  }
  
  private boolean a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8)
  {
    Object localObject = this.v.k();
    int j = ((SessionInfo)localObject).g;
    int m = ((SessionInfo)localObject).aQ;
    String str = ((SessionInfo)localObject).f;
    boolean bool = true;
    int k = 0;
    if ((str != null) && (str.startsWith("10-")) && (!((SessionInfo)localObject).am)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((m != 10) && (i == 0)) {
      break label91;
    }
    paramBoolean1 = false;
    paramBoolean2 = false;
    label91:
    if ((!paramBoolean4) && (paramBoolean1) && (this.t == null)) {
      a("showHideToast");
    }
    if ((paramBoolean6) && (this.a)) {
      this.a = false;
    }
    int i = 0;
    while (i < 4)
    {
      if (this.j[i] != null) {
        this.x[i] = this.j[i].a();
      } else {
        this.x[i] = false;
      }
      i += 1;
    }
    localObject = this.y;
    int n;
    if ((paramBoolean2) && (paramBoolean1) && (!this.a)) {
      n = 1;
    } else {
      n = 0;
    }
    localObject[0] = n;
    localObject = this.y;
    if ((paramBoolean3) && (paramBoolean1)) {
      n = 1;
    } else {
      n = 0;
    }
    localObject[1] = n;
    localObject = this.y;
    if ((paramBoolean4) && (paramBoolean1)) {
      n = 1;
    } else {
      n = 0;
    }
    localObject[2] = n;
    localObject = this.y;
    if ((paramBoolean5) && (paramBoolean1)) {
      paramBoolean5 = bool;
    } else {
      paramBoolean5 = false;
    }
    localObject[3] = paramBoolean5;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showHideToast, hasVideo[");
      ((StringBuilder)localObject).append(paramBoolean6);
      ((StringBuilder)localObject).append("], mIsInCall[");
      ((StringBuilder)localObject).append(this.q);
      ((StringBuilder)localObject).append("], isOpEnable[");
      ((StringBuilder)localObject).append(paramBoolean7);
      ((StringBuilder)localObject).append("], isVideoToastCanShow[");
      ((StringBuilder)localObject).append(paramBoolean3);
      ((StringBuilder)localObject).append("], isAudioToastCanShow[");
      ((StringBuilder)localObject).append(paramBoolean2);
      ((StringBuilder)localObject).append("], isShareToastCanShow[");
      ((StringBuilder)localObject).append(paramBoolean4);
      ((StringBuilder)localObject).append("], isToastShow[");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append("], mIsLock[");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append("], mIsInit[");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append("], mIsAppOnForeground[");
      ((StringBuilder)localObject).append(this.f);
      ((StringBuilder)localObject).append("], SessionType[");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append("], relationType[");
      ((StringBuilder)localObject).append(m);
      ((StringBuilder)localObject).append("], isSelectMemberActivityIsResume[");
      ((StringBuilder)localObject).append(paramBoolean8);
      ((StringBuilder)localObject).append("], mSmallScreenStateBroadcast[");
      ((StringBuilder)localObject).append(this.i);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.w("SmallScreenService", 2, ((StringBuilder)localObject).toString());
    }
    i = 0;
    for (;;)
    {
      j = k;
      if (i >= 4) {
        break;
      }
      localObject = this.j[i];
      if ((localObject != null) && (((SmallScreenItemBase)localObject).m != null) && (((SmallScreenItemBase)localObject).n != null))
      {
        ((SmallScreenItemBase)localObject).a(this);
        if ((((SmallScreenItemBase)localObject).a()) && (this.y[i] == 0)) {
          this.h = ((SmallScreenItemBase)localObject).m.getCurPosition();
        }
      }
      i += 1;
    }
    while (j < 4)
    {
      localObject = this.j[j];
      if ((localObject != null) && (((SmallScreenItemBase)localObject).m != null) && (((SmallScreenItemBase)localObject).n != null)) {
        ((SmallScreenItemBase)localObject).a(this.y[j], this.h);
      }
      j += 1;
    }
    return paramBoolean1;
  }
  
  void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    long l = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doPhoneStateChange, state[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], incomingNumber[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], mIsInCall[");
      localStringBuilder.append(this.q);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w("SmallScreenService", 1, localStringBuilder.toString());
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2) {
          this.q = true;
        }
      }
      else {
        this.q = true;
      }
    }
    else {
      this.q = false;
    }
    a(l);
  }
  
  void a(long paramLong)
  {
    if (this.d) {
      return;
    }
    Object localObject = this.v.k();
    int i = this.g;
    boolean bool8 = false;
    boolean bool1;
    if (i > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    VideoAppInterface localVideoAppInterface = this.u;
    if (localVideoAppInterface != null)
    {
      bool2 = SmallScreenUtils.c(localVideoAppInterface.getApp());
      if ((!((SessionInfo)localObject).am) || (((SessionInfo)localObject).i != 15)) {
        break label86;
      }
    }
    boolean bool2 = false;
    label86:
    this.f = f();
    localObject = VideoController.f().aB();
    boolean bool3;
    if ((localObject != null) && (((WatchTogetherMediaPlayCtrl)localObject).q())) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    boolean bool4;
    if ((Build.VERSION.SDK_INT >= 21) && (this.v.aE().e())) {
      bool4 = true;
    } else {
      bool4 = false;
    }
    boolean bool5;
    if ((!bool3) && (!bool4) && (bool1) && (SmallScreenUtils.h())) {
      bool5 = true;
    } else {
      bool5 = false;
    }
    boolean bool6;
    if ((!bool3) && (!bool4) && (!bool1) && (SmallScreenUtils.i()) && (this.f)) {
      bool6 = true;
    } else {
      bool6 = false;
    }
    boolean bool9 = this.v.ah();
    if ((!this.q) && (bool2) && (!bool9) && (!this.c)) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool7 = bool8;
    if (i != 0) {
      if ((!bool3) && (!bool4) && (!bool5))
      {
        bool7 = bool8;
        if (!bool6) {}
      }
      else
      {
        bool7 = true;
      }
    }
    a(paramLong, a(paramLong, bool7, bool6, bool5, bool4, bool3, bool1, bool2, bool9), bool9);
    a(this.y, this.x);
  }
  
  void a(long paramLong, int paramInt)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendStateBroadcast, state[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], sCanSendStateDelayFlag[");
      localStringBuilder.append(p);
      localStringBuilder.append("]");
      QLog.i("SmallScreenService", 4, localStringBuilder.toString());
    }
    p = false;
    if (this.r != null) {
      b().removeCallbacks(this.r);
    }
    if (SmallScreenUtils.a(paramLong, this.u, paramInt)) {
      this.i = paramInt;
    }
  }
  
  protected void a(boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2)
  {
    Object localObject1 = this.v.k();
    int i = ((SessionInfo)localObject1).g;
    int j = ((SessionInfo)localObject1).aQ;
    if ((i != 1) && (i != 2)) {
      i = 0;
    } else {
      i = 1;
    }
    int k = paramArrayOfBoolean1[1];
    Object localObject2 = null;
    String str = null;
    if (k != 0)
    {
      if (paramArrayOfBoolean2[1] == 0)
      {
        localObject1 = str;
        if (paramArrayOfBoolean2[0] != 0) {
          if (i != 0)
          {
            localObject1 = "0X8005A4A";
          }
          else if (j == 1)
          {
            localObject1 = "0X8005A4C";
          }
          else
          {
            localObject1 = str;
            if (j == 2) {
              localObject1 = "0X8005A4B";
            }
          }
        }
        str = "0X80057E6";
        localObject2 = localObject1;
        break label144;
      }
    }
    else if (paramArrayOfBoolean2[1] != 0)
    {
      str = "0X80057E5";
      break label144;
    }
    str = null;
    label144:
    localObject1 = localObject2;
    if (paramArrayOfBoolean1[0] != 0)
    {
      localObject1 = localObject2;
      if (paramArrayOfBoolean2[0] == 0)
      {
        localObject1 = localObject2;
        if (paramArrayOfBoolean2[1] != 0) {
          if (i != 0)
          {
            localObject1 = "0X8005A4D";
          }
          else if (j == 1)
          {
            localObject1 = "0X8005A4F";
          }
          else
          {
            localObject1 = localObject2;
            if (j == 2) {
              localObject1 = "0X8005A4E";
            }
          }
        }
      }
    }
    if (str != null) {
      ReportController.b(null, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
    }
    if (localObject1 != null) {
      ReportController.b(null, "CliOper", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
    }
  }
  
  void c(int paramInt)
  {
    long l = AudioHelper.c();
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onVideoNumChanged, videoViewCount[");
      localStringBuilder.append(this.g);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w("SmallScreenService", 1, localStringBuilder.toString());
    }
    this.g = paramInt;
    a(l);
  }
  
  public void c(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    paramSmallScreenRelativeLayout = this.t;
    if (paramSmallScreenRelativeLayout != null) {
      paramSmallScreenRelativeLayout.c();
    }
  }
  
  void d()
  {
    long l = AudioHelper.c();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onOpChanged, mIsOpEnable[");
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("]");
      QLog.w("SmallScreenService", 1, ((StringBuilder)localObject).toString());
    }
    a(l);
    if (this.e) {
      localObject = "0X80057D9";
    } else {
      localObject = "0X80057DB";
    }
    ReportController.b(null, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
    if (this.g > 0)
    {
      if (this.e) {
        localObject = "0X80057DA";
      } else {
        localObject = "0X80057DC";
      }
      ReportController.b(null, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
    }
  }
  
  public boolean d(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    if (paramSmallScreenRelativeLayout == b(2)) {
      h();
    }
    paramSmallScreenRelativeLayout = this.t;
    if (paramSmallScreenRelativeLayout != null) {
      paramSmallScreenRelativeLayout.b();
    } else {
      SmallScreenVideoController.a(getApplicationContext(), this.v);
    }
    return true;
  }
  
  void e()
  {
    super.e();
    long l = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doInitRunnable, start, seq[");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("]");
      QLog.w("SmallScreenService", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.v;
    if (localObject != null)
    {
      if (((VideoController)localObject).ag())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doInitRunnable, AvActivityIsResume, seq[");
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append("]");
        QLog.w("SmallScreenService", 1, ((StringBuilder)localObject).toString());
        return;
      }
      localObject = this.v.k();
      if (localObject != null)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("InitRunnable, SessionType[");
          localStringBuilder.append(((SessionInfo)localObject).g);
          localStringBuilder.append("]");
          QLog.w("SmallScreenService", 1, localStringBuilder.toString());
        }
        if ((((SessionInfo)localObject).g != 1) && (((SessionInfo)localObject).g != 3))
        {
          if (((SessionInfo)localObject).g == 4)
          {
            if ((!NetworkUtil.isWifiConnected(this.u.getApp())) && (!((SessionInfo)localObject).bA))
            {
              this.a = false;
              a(l);
            }
          }
          else if ((((SessionInfo)localObject).g == 0) && (((SessionInfo)localObject).B) && ((((SessionInfo)localObject).i == 1) || (((SessionInfo)localObject).i == 2)))
          {
            int i = ((SessionInfo)localObject).h;
            if ((i == 1) || (i == 2))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("doInitRunnable, sessionInfo.BeginSessionType,[");
              ((StringBuilder)localObject).append(i);
              ((StringBuilder)localObject).append("]");
              QLog.w("SmallScreenService", 1, ((StringBuilder)localObject).toString());
              this.a = false;
              a(l);
            }
          }
        }
        else
        {
          this.a = false;
          a(l);
        }
      }
      else if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doInitRunnable, sessionInfo为空, seq[");
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append("]");
        QLog.w("SmallScreenService", 1, ((StringBuilder)localObject).toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doInitRunnable, VideoController为空, seq[");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("]");
      QLog.w("SmallScreenService", 1, ((StringBuilder)localObject).toString());
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doInitRunnable, end, seq[");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("]");
      QLog.w("SmallScreenService", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  protected boolean f()
  {
    boolean bool2 = this.u.l();
    boolean bool1;
    if ((bool2) && (this.u.isBackgroundPause)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("isAppOnForeground result = ");
      localStringBuilder1.append(bool1);
      localStringBuilder1.append(", isQQPaused = ");
      localStringBuilder1.append(bool2);
      localStringBuilder1.append(", isAVPaused = ");
      localStringBuilder1.append(this.u.isBackgroundPause);
      QLog.d("SmallScreenService", 2, localStringBuilder1.toString());
    }
    if (bool1)
    {
      try
      {
        bool2 = GesturePWDUtils.isAppOnForegroundByTasks(this, 0);
        if (!bool2) {
          break label167;
        }
        return true;
      }
      catch (Exception localException)
      {
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          return bool2;
        }
      }
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("isAppOnForeground e = ");
      localStringBuilder2.append(localException);
      QLog.e("SmallScreenService", 2, localStringBuilder2.toString());
      return bool1;
    }
    label167:
    bool2 = false;
    return bool2;
  }
  
  void g()
  {
    ThreadManager.excute(new SmallScreenService.3(this), 16, null, true);
  }
  
  @TargetApi(21)
  protected void h()
  {
    Object localObject = this.v.aF();
    if (localObject != null) {
      ((ScreenShareCtrl)localObject).a(2);
    }
    localObject = this.v.aE();
    if (localObject != null) {
      ((ScreenRecordHelper)localObject).b(2);
    }
  }
  
  public void onCreate()
  {
    long l = AudioHelper.c();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("avideo onCreate start, seq[");
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append("]");
    QLog.w("SmallScreenService", 1, ((StringBuilder)localObject).toString());
    super.onCreate();
    this.u = ((VideoAppInterface)this.app);
    this.u.a(this.A);
    this.v = this.u.b();
    localObject = this.v.k();
    a(l, 1);
    this.w = ((WindowManager)getSystemService("window"));
    SharedPreferences localSharedPreferences = SharedPreUtils.B(this.u.getApp());
    if (this.v.g()) {
      this.h = localSharedPreferences.getInt("small_window_position_land", 12);
    } else {
      this.h = ((SessionInfo)localObject).bB;
    }
    ((SessionInfo)localObject).bB = this.h;
    int i = 0;
    while (i < 4)
    {
      localObject = b(i);
      if (localObject != null) {
        ((SmallScreenRelativeLayout)localObject).setCurPosition(this.h);
      }
      i += 1;
    }
    if (this.s == null)
    {
      this.s = new SmallScreenService.OnSelectMemberActivityIsResumeChangedRunnable(this);
      this.s.a = l;
    }
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("android.intent.action.NEW_OUTGOING_CALL");
    ((IntentFilter)localObject).addAction("tencent.video.q2v.ACTION_SELECT_MEMBER_ACTIVITY_IS_RESUME_CHANGED");
    registerReceiver(this.z, (IntentFilter)localObject);
    this.q = this.u.m();
    a("onCreate");
    a(l);
    QLog.d("SmallScreenService", 1, "onCreate end");
  }
  
  public void onDestroy()
  {
    long l = AudioHelper.c();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("avideo onDestroy start, seq[");
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append("], sLastActionOnFrom[");
    ((StringBuilder)localObject).append(SmallScreenUtils.e);
    ((StringBuilder)localObject).append("]");
    QLog.w("SmallScreenService", 1, ((StringBuilder)localObject).toString());
    if (this.g > 0) {
      localObject = b(1);
    } else {
      localObject = b(0);
    }
    if (localObject != null) {
      this.v.k().bB = ((SmallScreenRelativeLayout)localObject).getCurPosition();
    }
    g();
    super.onDestroy();
    a(l, 0);
    this.r = null;
    localObject = this.t;
    if (localObject != null)
    {
      ((SmallScreenVideoController)localObject).g();
      this.t.h();
      this.t.a(l);
    }
    unregisterReceiver(this.z);
    if (this.s != null) {
      this.u.a().removeCallbacks(this.s);
    }
    this.u.b(this.A);
    this.A = null;
    this.s = null;
    this.t = null;
    this.z = null;
    this.u = null;
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenService", 2, "onDestroy end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenService
 * JD-Core Version:    0.7.0.1
 */