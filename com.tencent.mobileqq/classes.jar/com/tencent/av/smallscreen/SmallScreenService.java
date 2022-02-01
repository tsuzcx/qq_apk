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
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.screenshare.ScreenShareCtrl;
import com.tencent.av.ui.ScreenRecordHelper;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;

public class SmallScreenService
  extends BaseSmallScreenService
  implements SmallScreenRelativeLayout.FloatListener
{
  public static boolean g = false;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new SmallScreenService.1(this);
  WindowManager jdField_a_of_type_AndroidViewWindowManager = null;
  VideoController jdField_a_of_type_ComTencentAvVideoController = null;
  private GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new SmallScreenService.2(this);
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  SmallScreenService.OnSelectMemberActivityIsResumeChangedRunnable jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService$OnSelectMemberActivityIsResumeChangedRunnable = null;
  SmallScreenVideoController jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController = null;
  final boolean[] jdField_a_of_type_ArrayOfBoolean = new boolean[4];
  final boolean[] b;
  Runnable c;
  boolean h = false;
  
  public SmallScreenService()
  {
    this.jdField_c_of_type_JavaLangRunnable = null;
    this.jdField_b_of_type_ArrayOfBoolean = new boolean[4];
  }
  
  private void a(String paramString)
  {
    if ((this.d) || (this.jdField_a_of_type_ComTencentAvVideoController == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SmallScreenService", 2, "initSmallScreenVideoUI, isDestroyed.");
      }
      return;
    }
    if ((Build.VERSION.SDK_INT >= 21) && (this.jdField_a_of_type_ComTencentAvVideoController.a().c())) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SmallScreenService", 2, "initSmallScreenVideoUI, shareScreen[" + bool + "], uiCtrl[" + this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController + "], from[" + paramString + "]");
      }
      if ((bool) || (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController != null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController = new SmallScreenVideoController(this);
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.a(this.app);
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.e();
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.f();
      return;
    }
  }
  
  void a(int paramInt)
  {
    long l = AudioHelper.b();
    if (QLog.isDevelopLevel()) {
      QLog.w("SmallScreenService", 1, "onVideoNumChanged, videoViewCount[" + this.jdField_a_of_type_Int + "->" + paramInt + "], seq[" + l + "]");
    }
    this.jdField_a_of_type_Int = paramInt;
    a(l);
  }
  
  void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenService", 1, "doPhoneStateChange, state[" + paramInt + "], incomingNumber[" + paramString + "], mIsInCall[" + this.h + "], seq[" + l + "]");
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      a(l);
      return;
      this.h = false;
      continue;
      this.h = true;
      continue;
      this.h = true;
    }
  }
  
  void a(long paramLong)
  {
    Object localObject1;
    boolean bool4;
    int i;
    label63:
    boolean bool5;
    label73:
    boolean bool1;
    boolean bool2;
    boolean bool6;
    label155:
    label185:
    boolean bool7;
    int j;
    label221:
    boolean bool3;
    label248:
    int k;
    int m;
    if (!this.d)
    {
      localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if ((Build.VERSION.SDK_INT >= 21) && (this.jdField_a_of_type_ComTencentAvVideoController.a().c()))
      {
        bool4 = true;
        Object localObject2 = VideoController.a().b();
        if ((localObject2 == null) || (!((WatchTogetherMediaPlayCtrl)localObject2).h())) {
          break label404;
        }
        i = 1;
        if (this.jdField_a_of_type_Int <= 0) {
          break label409;
        }
        bool5 = true;
        bool1 = false;
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
        {
          bool2 = SmallScreenUtils.c(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp());
          bool1 = bool2;
          if (((SessionInfo)localObject1).J)
          {
            bool1 = bool2;
            if (((SessionInfo)localObject1).g == 15) {
              bool1 = false;
            }
          }
        }
        this.f = a();
        if ((i != 0) || (bool4) || (!bool5) || (!SmallScreenUtils.g())) {
          break label415;
        }
        bool6 = true;
        if ((i != 0) || (bool4) || (bool5) || (!SmallScreenUtils.h()) || (!this.f)) {
          break label421;
        }
        bool2 = true;
        bool7 = this.jdField_a_of_type_ComTencentAvVideoController.p();
        if ((this.h) || (!bool1) || (bool7) || (this.jdField_c_of_type_Boolean)) {
          break label427;
        }
        j = 1;
        if ((j == 0) || ((i == 0) && (!bool4) && (!bool6) && (!bool2))) {
          break label433;
        }
        bool3 = true;
        k = ((SessionInfo)localObject1).d;
        m = ((SessionInfo)localObject1).F;
        localObject2 = ((SessionInfo)localObject1).c;
        if ((localObject2 == null) || (!((String)localObject2).startsWith("10-")) || (((SessionInfo)localObject1).J)) {
          break label439;
        }
        j = 1;
        label295:
        if ((m != 10) && (j == 0)) {
          break label1113;
        }
        bool3 = false;
        bool2 = false;
      }
    }
    label404:
    label409:
    label415:
    label421:
    label427:
    label433:
    label439:
    label1113:
    for (;;)
    {
      if ((!bool4) && (bool3) && (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController == null)) {
        a("showHideToast");
      }
      if ((bool5) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_Boolean = false;
      }
      j = 0;
      label356:
      if (j < 4)
      {
        if (this.jdField_a_of_type_ArrayOfComTencentAvSmallscreenSmallScreenItemBase[j] != null) {
          this.jdField_a_of_type_ArrayOfBoolean[j] = this.jdField_a_of_type_ArrayOfComTencentAvSmallscreenSmallScreenItemBase[j].a();
        }
        for (;;)
        {
          j += 1;
          break label356;
          bool4 = false;
          break;
          i = 0;
          break label63;
          bool5 = false;
          break label73;
          bool6 = false;
          break label155;
          bool2 = false;
          break label185;
          j = 0;
          break label221;
          bool3 = false;
          break label248;
          j = 0;
          break label295;
          this.jdField_a_of_type_ArrayOfBoolean[j] = false;
        }
      }
      localObject1 = this.jdField_b_of_type_ArrayOfBoolean;
      int n;
      if ((bool2) && (bool3) && (!this.jdField_a_of_type_Boolean))
      {
        n = 1;
        localObject1[0] = n;
        localObject1 = this.jdField_b_of_type_ArrayOfBoolean;
        if ((!bool6) || (!bool3)) {
          break label804;
        }
        n = 1;
        label507:
        localObject1[1] = n;
        localObject1 = this.jdField_b_of_type_ArrayOfBoolean;
        if ((!bool4) || (!bool3)) {
          break label810;
        }
        n = 1;
        localObject1[2] = n;
        localObject1 = this.jdField_b_of_type_ArrayOfBoolean;
        if ((i == 0) || (!bool3)) {
          break label816;
        }
        n = 1;
        localObject1[3] = n;
        if (QLog.isColorLevel()) {
          QLog.w("SmallScreenService", 2, "showHideToast, hasVideo[" + bool5 + "], mIsInCall[" + this.h + "], isOpEnable[" + bool1 + "], isVideoToastCanShow[" + bool6 + "], isAudioToastCanShow[" + bool2 + "], isShareToastCanShow[" + bool4 + "], isToastShow[" + bool3 + "], mIsLock[" + this.jdField_c_of_type_Boolean + "], mIsInit[" + this.jdField_a_of_type_Boolean + "], mIsAppOnForeground[" + this.f + "], SessionType[" + k + "], relationType[" + m + "], isSelectMemberActivityIsResume[" + bool7 + "], mSmallScreenStateBroadcast[" + this.jdField_c_of_type_Int + "], seq[" + paramLong + "]");
        }
        i = 0;
        label757:
        if (i >= 4) {
          break label860;
        }
        localObject1 = this.jdField_a_of_type_ArrayOfComTencentAvSmallscreenSmallScreenItemBase[i];
        if ((localObject1 != null) && (((SmallScreenItemBase)localObject1).jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout != null) && (((SmallScreenItemBase)localObject1).jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast != null)) {
          break label822;
        }
      }
      for (;;)
      {
        i += 1;
        break label757;
        n = 0;
        break;
        n = 0;
        break label507;
        n = 0;
        break label532;
        n = 0;
        break label556;
        ((SmallScreenItemBase)localObject1).a(this);
        if ((((SmallScreenItemBase)localObject1).a()) && (this.jdField_b_of_type_ArrayOfBoolean[i] == 0)) {
          this.jdField_b_of_type_Int = ((SmallScreenItemBase)localObject1).jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a();
        }
      }
      label860:
      i = 0;
      if (i < 4)
      {
        localObject1 = this.jdField_a_of_type_ArrayOfComTencentAvSmallscreenSmallScreenItemBase[i];
        if ((localObject1 == null) || (((SmallScreenItemBase)localObject1).jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout == null) || (((SmallScreenItemBase)localObject1).jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast == null)) {}
        for (;;)
        {
          i += 1;
          break;
          ((SmallScreenItemBase)localObject1).a(this.jdField_b_of_type_ArrayOfBoolean[i], this.jdField_b_of_type_Int);
        }
      }
      if ((bool3) && ((this.jdField_b_of_type_ArrayOfBoolean[0] != 0) || (this.jdField_b_of_type_ArrayOfBoolean[1] != 0))) {
        if (this.jdField_c_of_type_Int != 3) {
          a(paramLong, 3);
        }
      }
      for (;;)
      {
        a(this.jdField_b_of_type_ArrayOfBoolean, this.jdField_a_of_type_ArrayOfBoolean);
        return;
        if ((!bool7) && (!this.jdField_c_of_type_Boolean) && (this.f) && (this.jdField_c_of_type_Int != 2))
        {
          if ((bool3) && (this.jdField_b_of_type_ArrayOfBoolean[2] != 0)) {
            a(paramLong, 2);
          }
          if ((bool3) && (this.jdField_b_of_type_ArrayOfBoolean[3] != 0))
          {
            a(paramLong, 2);
          }
          else if (this.jdField_c_of_type_Int == 1)
          {
            localObject1 = a();
            if (this.jdField_c_of_type_JavaLangRunnable == null) {
              this.jdField_c_of_type_JavaLangRunnable = new SmallScreenService.4(this, paramLong);
            }
            ((Handler)localObject1).removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
            g = true;
            ((Handler)localObject1).postDelayed(this.jdField_c_of_type_JavaLangRunnable, 1000L);
          }
          else
          {
            a(paramLong, 2);
          }
        }
      }
    }
  }
  
  void a(long paramLong, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("SmallScreenService", 4, "sendStateBroadcast, state[" + paramInt + "], sCanSendStateDelayFlag[" + g + "]");
    }
    g = false;
    if (this.jdField_c_of_type_JavaLangRunnable != null) {
      a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    }
    if (SmallScreenUtils.a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt)) {
      this.jdField_c_of_type_Int = paramInt;
    }
  }
  
  public void a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.c();
    }
  }
  
  protected void a(boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i = ((SessionInfo)localObject).d;
    int j = ((SessionInfo)localObject).F;
    String str;
    if ((i == 1) || (i == 2))
    {
      i = 1;
      if (paramArrayOfBoolean1[1] == 0) {
        break label195;
      }
      if (paramArrayOfBoolean2[1] != 0) {
        break label244;
      }
      str = "0X80057E6";
      if (paramArrayOfBoolean2[0] == 0) {
        break label253;
      }
      if (i == 0) {
        break label167;
      }
      localObject = "0X8005A4A";
    }
    for (;;)
    {
      label66:
      if ((paramArrayOfBoolean1[0] != 0) && (paramArrayOfBoolean2[0] == 0) && (paramArrayOfBoolean2[1] != 0)) {
        if (i != 0) {
          paramArrayOfBoolean1 = "0X8005A4D";
        }
      }
      for (;;)
      {
        if (str != null) {
          ReportController.b(null, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
        }
        if (paramArrayOfBoolean1 != null) {
          ReportController.b(null, "CliOper", "", "", paramArrayOfBoolean1, paramArrayOfBoolean1, 0, 0, "", "", "", "");
        }
        return;
        i = 0;
        break;
        label167:
        if (j == 1)
        {
          localObject = "0X8005A4C";
          break label66;
        }
        if (j != 2) {
          break label253;
        }
        localObject = "0X8005A4B";
        break label66;
        label195:
        if (paramArrayOfBoolean2[1] == 0) {
          break label244;
        }
        str = "0X80057E5";
        localObject = null;
        break label66;
        if (j == 1) {
          paramArrayOfBoolean1 = "0X8005A4F";
        } else if (j == 2) {
          paramArrayOfBoolean1 = "0X8005A4E";
        } else {
          paramArrayOfBoolean1 = (boolean[])localObject;
        }
      }
      label244:
      localObject = null;
      str = null;
      continue;
      label253:
      localObject = null;
    }
  }
  
  protected boolean a()
  {
    boolean bool2 = true;
    boolean bool3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b();
    boolean bool1;
    if ((!bool3) || (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenService", 2, "isAppOnForeground result = " + bool1 + ", isQQPaused = " + bool3 + ", isAVPaused = " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause);
      }
      if (!bool1) {
        break label109;
      }
    }
    for (;;)
    {
      try
      {
        bool3 = GesturePWDUtils.isAppOnForegroundByTasks(this, 0);
        if (!bool3) {
          continue;
        }
        bool1 = bool2;
        bool2 = bool1;
      }
      catch (Exception localException)
      {
        label109:
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SmallScreenService", 2, "isAppOnForeground e = " + localException);
      }
      return bool2;
      bool1 = false;
      break;
      bool1 = false;
    }
    return bool1;
  }
  
  public boolean a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    if (paramSmallScreenRelativeLayout == a(2)) {
      f();
    }
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.b();
    }
    for (;;)
    {
      return true;
      SmallScreenVideoController.a(getApplicationContext(), this.jdField_a_of_type_ComTencentAvVideoController);
    }
  }
  
  void c()
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenService", 1, "onOpChanged, mIsOpEnable[" + this.e + "], seq[" + l + "]");
    }
    a(l);
    if (this.e)
    {
      str = "0X80057D9";
      ReportController.b(null, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
      if (this.jdField_a_of_type_Int > 0) {
        if (!this.e) {
          break label153;
        }
      }
    }
    label153:
    for (String str = "0X80057DA";; str = "0X80057DC")
    {
      ReportController.b(null, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
      return;
      str = "0X80057DB";
      break;
    }
  }
  
  void d()
  {
    super.d();
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenService", 1, "doInitRunnable, start, seq[" + l + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      if (this.jdField_a_of_type_ComTencentAvVideoController.o()) {
        QLog.w("SmallScreenService", 1, "doInitRunnable, AvActivityIsResume, seq[" + l + "]");
      }
    }
    for (;;)
    {
      return;
      SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (localSessionInfo != null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("SmallScreenService", 1, "InitRunnable, SessionType[" + localSessionInfo.d + "], matchStatus[" + localSessionInfo.a.jdField_b_of_type_Int + "]");
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.f) {
          localSessionInfo.a(l, "doInitRunnable", 1);
        }
        if ((localSessionInfo.d == 1) || (localSessionInfo.d == 3) || (localSessionInfo.a.jdField_b_of_type_Int > 0))
        {
          this.jdField_a_of_type_Boolean = false;
          a(l);
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.w("SmallScreenService", 1, "doInitRunnable, end, seq[" + l + "]");
        return;
        if (localSessionInfo.d == 4)
        {
          if ((!NetworkUtil.h(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp())) && (!localSessionInfo.as))
          {
            this.jdField_a_of_type_Boolean = false;
            a(l);
          }
        }
        else if ((localSessionInfo.d == 0) && (localSessionInfo.e) && ((localSessionInfo.g == 1) || (localSessionInfo.g == 2)))
        {
          int i = localSessionInfo.f;
          if ((i == 1) || (i == 2))
          {
            QLog.w("SmallScreenService", 1, "doInitRunnable, sessionInfo.BeginSessionType,[" + i + "]");
            this.jdField_a_of_type_Boolean = false;
            a(l);
            continue;
            if (QLog.isColorLevel())
            {
              QLog.w("SmallScreenService", 1, "doInitRunnable, sessionInfo为空, seq[" + l + "]");
              continue;
              if (QLog.isColorLevel()) {
                QLog.w("SmallScreenService", 1, "doInitRunnable, VideoController为空, seq[" + l + "]");
              }
            }
          }
        }
      }
    }
  }
  
  void e()
  {
    ThreadManager.excute(new SmallScreenService.3(this), 16, null, true);
  }
  
  @TargetApi(21)
  protected void f()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (localObject != null) {
      ((ScreenShareCtrl)localObject).a(2);
    }
    localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (localObject != null) {
      ((ScreenRecordHelper)localObject).a(2);
    }
  }
  
  public void onCreate()
  {
    long l = AudioHelper.b();
    QLog.w("SmallScreenService", 1, "avideo onCreate start, seq[" + l + "]");
    super.onCreate();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)this.app);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    a(l, 1);
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)getSystemService("window"));
    SharedPreferences localSharedPreferences = SharedPreUtils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp());
    if (this.jdField_a_of_type_ComTencentAvVideoController.b()) {}
    for (this.jdField_b_of_type_Int = localSharedPreferences.getInt("small_window_position_land", 12);; this.jdField_b_of_type_Int = ((SessionInfo)localObject).L)
    {
      ((SessionInfo)localObject).L = this.jdField_b_of_type_Int;
      int i = 0;
      while (i < 4)
      {
        localObject = a(i);
        if (localObject != null) {
          ((SmallScreenRelativeLayout)localObject).setCurPosition(this.jdField_b_of_type_Int);
        }
        i += 1;
      }
    }
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService$OnSelectMemberActivityIsResumeChangedRunnable == null)
    {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService$OnSelectMemberActivityIsResumeChangedRunnable = new SmallScreenService.OnSelectMemberActivityIsResumeChangedRunnable(this);
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService$OnSelectMemberActivityIsResumeChangedRunnable.a = l;
    }
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("android.intent.action.NEW_OUTGOING_CALL");
    ((IntentFilter)localObject).addAction("tencent.video.q2v.ACTION_SELECT_MEMBER_ACTIVITY_IS_RESUME_CHANGED");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
    this.h = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c();
    a("onCreate");
    a(l);
    QLog.d("SmallScreenService", 1, "onCreate end");
  }
  
  public void onDestroy()
  {
    long l = AudioHelper.b();
    QLog.w("SmallScreenService", 1, "avideo onDestroy start, seq[" + l + "], sLastActionOnFrom[" + SmallScreenUtils.d + "]");
    if (this.jdField_a_of_type_Int > 0) {}
    for (SmallScreenRelativeLayout localSmallScreenRelativeLayout = a(1);; localSmallScreenRelativeLayout = a(0))
    {
      if (localSmallScreenRelativeLayout != null) {
        this.jdField_a_of_type_ComTencentAvVideoController.a().L = localSmallScreenRelativeLayout.a();
      }
      e();
      super.onDestroy();
      a(l, 0);
      this.jdField_c_of_type_JavaLangRunnable = null;
      if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController != null)
      {
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.g();
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.h();
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.a(l);
      }
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService$OnSelectMemberActivityIsResumeChangedRunnable != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService$OnSelectMemberActivityIsResumeChangedRunnable);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
      this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver = null;
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService$OnSelectMemberActivityIsResumeChangedRunnable = null;
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController = null;
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenService", 2, "onDestroy end");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenService
 * JD-Core Version:    0.7.0.1
 */