package com.tencent.av.smallscreen;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.WindowManager;
import bcef;
import bfyz;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.screenshare.ScreenShareCtrl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import ldz;
import lez;
import lfa;
import lyu;
import lyv;
import lyx;
import lyy;
import lzb;
import lzf;
import miz;

public class SmallScreenService
  extends BaseSmallScreenService
  implements lyv
{
  public static boolean g;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new lyx(this);
  WindowManager jdField_a_of_type_AndroidViewWindowManager = null;
  public VideoController a;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  public SmallScreenService.OnSelectMemberActivityIsResumeChangedRunnable a;
  private ldz jdField_a_of_type_Ldz = new lyy(this);
  public lzf a;
  final boolean[] jdField_a_of_type_ArrayOfBoolean = new boolean[3];
  final boolean[] b;
  Runnable c;
  boolean h = false;
  
  public SmallScreenService()
  {
    this.jdField_c_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService$OnSelectMemberActivityIsResumeChangedRunnable = null;
    this.jdField_a_of_type_Lzf = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_b_of_type_ArrayOfBoolean = new boolean[3];
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
        QLog.i("SmallScreenService", 2, "initSmallScreenVideoUI, shareScreen[" + bool + "], uiCtrl[" + this.jdField_a_of_type_Lzf + "], from[" + paramString + "]");
      }
      if ((bool) || (this.jdField_a_of_type_Lzf != null)) {
        break;
      }
      this.jdField_a_of_type_Lzf = new lzf(this);
      this.jdField_a_of_type_Lzf.a(this.app);
      this.jdField_a_of_type_Lzf.e();
      this.jdField_a_of_type_Lzf.f();
      return;
    }
  }
  
  public void a(int paramInt)
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
  
  public void a(long paramLong)
  {
    Object localObject;
    boolean bool4;
    boolean bool5;
    label50:
    boolean bool1;
    boolean bool2;
    boolean bool6;
    label128:
    label154:
    boolean bool7;
    int i;
    label189:
    boolean bool3;
    label211:
    int j;
    int k;
    if (!this.d)
    {
      localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if ((Build.VERSION.SDK_INT >= 21) && (this.jdField_a_of_type_ComTencentAvVideoController.a().c()))
      {
        bool4 = true;
        if (this.jdField_a_of_type_Int <= 0) {
          break label358;
        }
        bool5 = true;
        bool1 = false;
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
        {
          bool2 = lzb.c(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp());
          bool1 = bool2;
          if (((lez)localObject).J)
          {
            bool1 = bool2;
            if (((lez)localObject).g == 15) {
              bool1 = false;
            }
          }
        }
        this.f = a();
        if ((bool4) || (!bool5) || (!lzb.g())) {
          break label364;
        }
        bool6 = true;
        if ((bool4) || (bool5) || (!lzb.h()) || (!this.f)) {
          break label370;
        }
        bool2 = true;
        bool7 = this.jdField_a_of_type_ComTencentAvVideoController.p();
        if ((this.h) || (!bool1) || (bool7) || (this.jdField_c_of_type_Boolean)) {
          break label376;
        }
        i = 1;
        if ((i == 0) || ((!bool4) && (!bool6) && (!bool2))) {
          break label381;
        }
        bool3 = true;
        j = ((lez)localObject).d;
        k = ((lez)localObject).F;
        String str = ((lez)localObject).c;
        if ((str == null) || (!str.startsWith("10-")) || (((lez)localObject).J)) {
          break label387;
        }
        i = 1;
        label257:
        if ((k != 10) && (i == 0)) {
          break label1003;
        }
        bool3 = false;
        bool2 = false;
      }
    }
    label316:
    label358:
    label1003:
    for (;;)
    {
      if ((!bool4) && (bool3) && (this.jdField_a_of_type_Lzf == null)) {
        a("showHideToast");
      }
      if ((bool5) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_Boolean = false;
      }
      i = 0;
      if (i < 3)
      {
        if (this.jdField_a_of_type_ArrayOfLyu[i] != null) {
          this.jdField_a_of_type_ArrayOfBoolean[i] = this.jdField_a_of_type_ArrayOfLyu[i].a();
        }
        for (;;)
        {
          i += 1;
          break label316;
          bool4 = false;
          break;
          bool5 = false;
          break label50;
          label364:
          bool6 = false;
          break label128;
          label370:
          bool2 = false;
          break label154;
          label376:
          i = 0;
          break label189;
          label381:
          bool3 = false;
          break label211;
          i = 0;
          break label257;
          this.jdField_a_of_type_ArrayOfBoolean[i] = false;
        }
      }
      localObject = this.jdField_b_of_type_ArrayOfBoolean;
      int m;
      if ((bool2) && (bool3) && (!this.jdField_a_of_type_Boolean))
      {
        m = 1;
        localObject[0] = m;
        localObject = this.jdField_b_of_type_ArrayOfBoolean;
        if ((!bool6) || (!bool3)) {
          break label720;
        }
        m = 1;
        localObject[1] = m;
        localObject = this.jdField_b_of_type_ArrayOfBoolean;
        if ((!bool4) || (!bool3)) {
          break label726;
        }
        m = 1;
        localObject[2] = m;
        if (QLog.isColorLevel()) {
          QLog.w("SmallScreenService", 2, "showHideToast, hasVideo[" + bool5 + "], mIsInCall[" + this.h + "], isOpEnable[" + bool1 + "], isVideoToastCanShow[" + bool6 + "], isAudioToastCanShow[" + bool2 + "], isShareToastCanShow[" + bool4 + "], isToastShow[" + bool3 + "], mIsLock[" + this.jdField_c_of_type_Boolean + "], mIsInit[" + this.jdField_a_of_type_Boolean + "], mIsAppOnForeground[" + this.f + "], SessionType[" + j + "], relationType[" + k + "], isSelectMemberActivityIsResume[" + bool7 + "], mSmallScreenStateBroadcast[" + this.jdField_c_of_type_Int + "], seq[" + paramLong + "]");
        }
        i = 0;
        if (i >= 3) {
          break label770;
        }
        localObject = this.jdField_a_of_type_ArrayOfLyu[i];
        if ((localObject != null) && (((lyu)localObject).jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout != null) && (((lyu)localObject).jdField_a_of_type_Lza != null)) {
          break label732;
        }
      }
      for (;;)
      {
        i += 1;
        break label673;
        m = 0;
        break;
        m = 0;
        break label453;
        m = 0;
        break label478;
        ((lyu)localObject).a(this);
        if ((((lyu)localObject).a()) && (this.jdField_b_of_type_ArrayOfBoolean[i] == 0)) {
          this.jdField_b_of_type_Int = ((lyu)localObject).jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a();
        }
      }
      i = 0;
      if (i < 3)
      {
        localObject = this.jdField_a_of_type_ArrayOfLyu[i];
        if ((localObject == null) || (((lyu)localObject).jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout == null) || (((lyu)localObject).jdField_a_of_type_Lza == null)) {}
        for (;;)
        {
          i += 1;
          break;
          ((lyu)localObject).a(this.jdField_b_of_type_ArrayOfBoolean[i], this.jdField_b_of_type_Int);
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
        if ((!bool7) && (!this.jdField_c_of_type_Boolean) && (this.f) && (this.jdField_c_of_type_Int != 2)) {
          if ((bool3) && (this.jdField_b_of_type_ArrayOfBoolean[2] != 0))
          {
            a(paramLong, 2);
          }
          else if (this.jdField_c_of_type_Int == 1)
          {
            localObject = a();
            if (this.jdField_c_of_type_JavaLangRunnable == null) {
              this.jdField_c_of_type_JavaLangRunnable = new SmallScreenService.4(this, paramLong);
            }
            ((Handler)localObject).removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
            g = true;
            ((Handler)localObject).postDelayed(this.jdField_c_of_type_JavaLangRunnable, 1000L);
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
    if (lzb.a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt)) {
      this.jdField_c_of_type_Int = paramInt;
    }
  }
  
  public void a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    if (this.jdField_a_of_type_Lzf != null) {
      this.jdField_a_of_type_Lzf.c();
    }
  }
  
  protected void a(boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i = ((lez)localObject).d;
    int j = ((lez)localObject).F;
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
          bcef.b(null, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
        }
        if (paramArrayOfBoolean1 != null) {
          bcef.b(null, "CliOper", "", "", paramArrayOfBoolean1, paramArrayOfBoolean1, 0, 0, "", "", "", "");
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
        break label108;
      }
    }
    for (;;)
    {
      try
      {
        bool3 = GesturePWDUtils.isAppOnForegroundByTasks(this);
        if (!bool3) {
          continue;
        }
        bool1 = bool2;
        bool2 = bool1;
      }
      catch (Exception localException)
      {
        label108:
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
    if (this.jdField_a_of_type_Lzf != null) {
      this.jdField_a_of_type_Lzf.b();
    }
    for (;;)
    {
      return true;
      lzf.a(getApplicationContext(), this.jdField_a_of_type_ComTencentAvVideoController);
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
      bcef.b(null, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
      if (this.jdField_a_of_type_Int > 0) {
        if (!this.e) {
          break label153;
        }
      }
    }
    label153:
    for (String str = "0X80057DA";; str = "0X80057DC")
    {
      bcef.b(null, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
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
      lez locallez = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (locallez != null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("SmallScreenService", 1, "InitRunnable, SessionType[" + locallez.d + "], matchStatus[" + locallez.a.jdField_b_of_type_Int + "]");
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.f) {
          locallez.a(l, "doInitRunnable", 1);
        }
        if ((locallez.d == 1) || (locallez.d == 3) || (locallez.a.jdField_b_of_type_Int > 0))
        {
          this.jdField_a_of_type_Boolean = false;
          a(l);
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.w("SmallScreenService", 1, "doInitRunnable, end, seq[" + l + "]");
        return;
        if (locallez.d == 4)
        {
          if ((!NetworkUtil.isWifiConnected(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp())) && (!locallez.aq))
          {
            this.jdField_a_of_type_Boolean = false;
            a(l);
          }
        }
        else if ((locallez.d == 0) && (locallez.e) && ((locallez.g == 1) || (locallez.g == 2)))
        {
          int i = locallez.f;
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
      ((miz)localObject).a(2);
    }
  }
  
  public void onCreate()
  {
    long l = AudioHelper.b();
    QLog.w("SmallScreenService", 1, "avideo onCreate start, seq[" + l + "]");
    super.onCreate();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)this.app);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Ldz);
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    a(l, 1);
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)getSystemService("window"));
    SharedPreferences localSharedPreferences = bfyz.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp());
    if (this.jdField_a_of_type_ComTencentAvVideoController.b()) {}
    for (this.jdField_b_of_type_Int = localSharedPreferences.getInt("small_window_position_land", 12);; this.jdField_b_of_type_Int = ((lez)localObject).L)
    {
      ((lez)localObject).L = this.jdField_b_of_type_Int;
      int i = 0;
      while (i < 3)
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
    QLog.w("SmallScreenService", 1, "avideo onDestroy start, seq[" + l + "], sLastActionOnFrom[" + lzb.d + "]");
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
      if (this.jdField_a_of_type_Lzf != null)
      {
        this.jdField_a_of_type_Lzf.g();
        this.jdField_a_of_type_Lzf.h();
        this.jdField_a_of_type_Lzf.a(l);
      }
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService$OnSelectMemberActivityIsResumeChangedRunnable != null) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService$OnSelectMemberActivityIsResumeChangedRunnable);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Ldz);
      this.jdField_a_of_type_Ldz = null;
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService$OnSelectMemberActivityIsResumeChangedRunnable = null;
      this.jdField_a_of_type_Lzf = null;
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenService", 2, "onDestroy end");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenService
 * JD-Core Version:    0.7.0.1
 */