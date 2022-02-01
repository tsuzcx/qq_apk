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
  
  private void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if (paramBoolean1)
    {
      localObject = this.jdField_b_of_type_ArrayOfBoolean;
      if ((localObject[0] != 0) || (localObject[1] != 0))
      {
        if (this.jdField_c_of_type_Int == 3) {
          return;
        }
        a(paramLong, 3);
        return;
      }
    }
    if ((!paramBoolean2) && (!this.jdField_c_of_type_Boolean))
    {
      if (!this.f) {
        return;
      }
      if (this.jdField_c_of_type_Int != 2)
      {
        if ((paramBoolean1) && (this.jdField_b_of_type_ArrayOfBoolean[2] != 0)) {
          a(paramLong, 2);
        }
        if ((paramBoolean1) && (this.jdField_b_of_type_ArrayOfBoolean[3] != 0))
        {
          a(paramLong, 2);
          return;
        }
        if (this.jdField_c_of_type_Int == 1)
        {
          localObject = a();
          if (this.jdField_c_of_type_JavaLangRunnable == null) {
            this.jdField_c_of_type_JavaLangRunnable = new SmallScreenService.4(this, paramLong);
          }
          ((Handler)localObject).removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
          g = true;
          ((Handler)localObject).postDelayed(this.jdField_c_of_type_JavaLangRunnable, 1000L);
          return;
        }
        a(paramLong, 2);
      }
    }
  }
  
  private void a(String paramString)
  {
    if ((!this.d) && (this.jdField_a_of_type_ComTencentAvVideoController != null))
    {
      boolean bool;
      if ((Build.VERSION.SDK_INT >= 21) && (this.jdField_a_of_type_ComTencentAvVideoController.a().c())) {
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
        localStringBuilder.append(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController);
        localStringBuilder.append("], from[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.i("SmallScreenService", 2, localStringBuilder.toString());
      }
      if ((!bool) && (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController == null))
      {
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController = new SmallScreenVideoController(this);
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.a(this.app);
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.e();
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController.f();
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("SmallScreenService", 2, "initSmallScreenVideoUI, isDestroyed.");
    }
  }
  
  private boolean a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int j = ((SessionInfo)localObject).d;
    int m = ((SessionInfo)localObject).E;
    String str = ((SessionInfo)localObject).b;
    boolean bool = true;
    int k = 0;
    if ((str != null) && (str.startsWith("10-")) && (!((SessionInfo)localObject).y)) {
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
    if ((!paramBoolean4) && (paramBoolean1) && (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController == null)) {
      a("showHideToast");
    }
    if ((paramBoolean6) && (this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_Boolean = false;
    }
    int i = 0;
    while (i < 4)
    {
      if (this.jdField_a_of_type_ArrayOfComTencentAvSmallscreenSmallScreenItemBase[i] != null) {
        this.jdField_a_of_type_ArrayOfBoolean[i] = this.jdField_a_of_type_ArrayOfComTencentAvSmallscreenSmallScreenItemBase[i].a();
      } else {
        this.jdField_a_of_type_ArrayOfBoolean[i] = false;
      }
      i += 1;
    }
    localObject = this.jdField_b_of_type_ArrayOfBoolean;
    int n;
    if ((paramBoolean2) && (paramBoolean1) && (!this.jdField_a_of_type_Boolean)) {
      n = 1;
    } else {
      n = 0;
    }
    localObject[0] = n;
    localObject = this.jdField_b_of_type_ArrayOfBoolean;
    if ((paramBoolean3) && (paramBoolean1)) {
      n = 1;
    } else {
      n = 0;
    }
    localObject[1] = n;
    localObject = this.jdField_b_of_type_ArrayOfBoolean;
    if ((paramBoolean4) && (paramBoolean1)) {
      n = 1;
    } else {
      n = 0;
    }
    localObject[2] = n;
    localObject = this.jdField_b_of_type_ArrayOfBoolean;
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
      ((StringBuilder)localObject).append(this.h);
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
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Boolean);
      ((StringBuilder)localObject).append("], mIsInit[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append("], mIsAppOnForeground[");
      ((StringBuilder)localObject).append(this.f);
      ((StringBuilder)localObject).append("], SessionType[");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append("], relationType[");
      ((StringBuilder)localObject).append(m);
      ((StringBuilder)localObject).append("], isSelectMemberActivityIsResume[");
      ((StringBuilder)localObject).append(paramBoolean8);
      ((StringBuilder)localObject).append("], mSmallScreenStateBroadcast[");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
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
      localObject = this.jdField_a_of_type_ArrayOfComTencentAvSmallscreenSmallScreenItemBase[i];
      if ((localObject != null) && (((SmallScreenItemBase)localObject).jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout != null) && (((SmallScreenItemBase)localObject).jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast != null))
      {
        ((SmallScreenItemBase)localObject).a(this);
        if ((((SmallScreenItemBase)localObject).a()) && (this.jdField_b_of_type_ArrayOfBoolean[i] == 0)) {
          this.jdField_b_of_type_Int = ((SmallScreenItemBase)localObject).jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a();
        }
      }
      i += 1;
    }
    while (j < 4)
    {
      localObject = this.jdField_a_of_type_ArrayOfComTencentAvSmallscreenSmallScreenItemBase[j];
      if ((localObject != null) && (((SmallScreenItemBase)localObject).jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout != null) && (((SmallScreenItemBase)localObject).jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast != null)) {
        ((SmallScreenItemBase)localObject).a(this.jdField_b_of_type_ArrayOfBoolean[j], this.jdField_b_of_type_Int);
      }
      j += 1;
    }
    return paramBoolean1;
  }
  
  void a(int paramInt)
  {
    long l = AudioHelper.b();
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onVideoNumChanged, videoViewCount[");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w("SmallScreenService", 1, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Int = paramInt;
    a(l);
  }
  
  void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    long l = AudioHelper.b();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doPhoneStateChange, state[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], incomingNumber[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], mIsInCall[");
      localStringBuilder.append(this.h);
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
          this.h = true;
        }
      }
      else {
        this.h = true;
      }
    }
    else {
      this.h = false;
    }
    a(l);
  }
  
  void a(long paramLong)
  {
    if (this.d) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i = this.jdField_a_of_type_Int;
    boolean bool8 = false;
    boolean bool1;
    if (i > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    VideoAppInterface localVideoAppInterface = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (localVideoAppInterface != null)
    {
      bool2 = SmallScreenUtils.c(localVideoAppInterface.getApp());
      if ((!((SessionInfo)localObject).y) || (((SessionInfo)localObject).f != 15)) {
        break label86;
      }
    }
    boolean bool2 = false;
    label86:
    this.f = a();
    localObject = VideoController.a().b();
    boolean bool3;
    if ((localObject != null) && (((WatchTogetherMediaPlayCtrl)localObject).h())) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    boolean bool4;
    if ((Build.VERSION.SDK_INT >= 21) && (this.jdField_a_of_type_ComTencentAvVideoController.a().c())) {
      bool4 = true;
    } else {
      bool4 = false;
    }
    boolean bool5;
    if ((!bool3) && (!bool4) && (bool1) && (SmallScreenUtils.g())) {
      bool5 = true;
    } else {
      bool5 = false;
    }
    boolean bool6;
    if ((!bool3) && (!bool4) && (!bool1) && (SmallScreenUtils.h()) && (this.f)) {
      bool6 = true;
    } else {
      bool6 = false;
    }
    boolean bool9 = this.jdField_a_of_type_ComTencentAvVideoController.o();
    if ((!this.h) && (bool2) && (!bool9) && (!this.jdField_c_of_type_Boolean)) {
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
    a(this.jdField_b_of_type_ArrayOfBoolean, this.jdField_a_of_type_ArrayOfBoolean);
  }
  
  void a(long paramLong, int paramInt)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendStateBroadcast, state[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], sCanSendStateDelayFlag[");
      localStringBuilder.append(g);
      localStringBuilder.append("]");
      QLog.i("SmallScreenService", 4, localStringBuilder.toString());
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
    paramSmallScreenRelativeLayout = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController;
    if (paramSmallScreenRelativeLayout != null) {
      paramSmallScreenRelativeLayout.c();
    }
  }
  
  protected void a(boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int i = ((SessionInfo)localObject1).d;
    int j = ((SessionInfo)localObject1).E;
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
  
  protected boolean a()
  {
    boolean bool2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    boolean bool1;
    if ((bool2) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause)) {
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
      localStringBuilder1.append(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackgroundPause);
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
  
  public boolean a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    if (paramSmallScreenRelativeLayout == a(2)) {
      f();
    }
    paramSmallScreenRelativeLayout = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController;
    if (paramSmallScreenRelativeLayout != null) {
      paramSmallScreenRelativeLayout.b();
    } else {
      SmallScreenVideoController.a(getApplicationContext(), this.jdField_a_of_type_ComTencentAvVideoController);
    }
    return true;
  }
  
  void c()
  {
    long l = AudioHelper.b();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onOpChanged, mIsOpEnable[");
      ((StringBuilder)localObject).append(this.jdField_e_of_type_Boolean);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("]");
      QLog.w("SmallScreenService", 1, ((StringBuilder)localObject).toString());
    }
    a(l);
    if (this.jdField_e_of_type_Boolean) {
      localObject = "0X80057D9";
    } else {
      localObject = "0X80057DB";
    }
    ReportController.b(null, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_Int > 0)
    {
      if (this.jdField_e_of_type_Boolean) {
        localObject = "0X80057DA";
      } else {
        localObject = "0X80057DC";
      }
      ReportController.b(null, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
    }
  }
  
  void d()
  {
    super.d();
    long l = AudioHelper.b();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doInitRunnable, start, seq[");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("]");
      QLog.w("SmallScreenService", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController;
    if (localObject != null)
    {
      if (((VideoController)localObject).n())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doInitRunnable, AvActivityIsResume, seq[");
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append("]");
        QLog.w("SmallScreenService", 1, ((StringBuilder)localObject).toString());
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (localObject != null)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("InitRunnable, SessionType[");
          localStringBuilder.append(((SessionInfo)localObject).d);
          localStringBuilder.append("]");
          QLog.w("SmallScreenService", 1, localStringBuilder.toString());
        }
        if ((((SessionInfo)localObject).d != 1) && (((SessionInfo)localObject).d != 3))
        {
          if (((SessionInfo)localObject).d == 4)
          {
            if ((!NetworkUtil.isWifiConnected(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp())) && (!((SessionInfo)localObject).ag))
            {
              this.jdField_a_of_type_Boolean = false;
              a(l);
            }
          }
          else if ((((SessionInfo)localObject).d == 0) && (((SessionInfo)localObject).jdField_e_of_type_Boolean) && ((((SessionInfo)localObject).f == 1) || (((SessionInfo)localObject).f == 2)))
          {
            int i = ((SessionInfo)localObject).jdField_e_of_type_Int;
            if ((i == 1) || (i == 2))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("doInitRunnable, sessionInfo.BeginSessionType,[");
              ((StringBuilder)localObject).append(i);
              ((StringBuilder)localObject).append("]");
              QLog.w("SmallScreenService", 1, ((StringBuilder)localObject).toString());
              this.jdField_a_of_type_Boolean = false;
              a(l);
            }
          }
        }
        else
        {
          this.jdField_a_of_type_Boolean = false;
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("avideo onCreate start, seq[");
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append("]");
    QLog.w("SmallScreenService", 1, ((StringBuilder)localObject).toString());
    super.onCreate();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)this.app);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    a(l, 1);
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)getSystemService("window"));
    SharedPreferences localSharedPreferences = SharedPreUtils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp());
    if (this.jdField_a_of_type_ComTencentAvVideoController.c()) {
      this.jdField_b_of_type_Int = localSharedPreferences.getInt("small_window_position_land", 12);
    } else {
      this.jdField_b_of_type_Int = ((SessionInfo)localObject).K;
    }
    ((SessionInfo)localObject).K = this.jdField_b_of_type_Int;
    int i = 0;
    while (i < 4)
    {
      localObject = a(i);
      if (localObject != null) {
        ((SmallScreenRelativeLayout)localObject).setCurPosition(this.jdField_b_of_type_Int);
      }
      i += 1;
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
    this.h = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b();
    a("onCreate");
    a(l);
    QLog.d("SmallScreenService", 1, "onCreate end");
  }
  
  public void onDestroy()
  {
    long l = AudioHelper.b();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("avideo onDestroy start, seq[");
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append("], sLastActionOnFrom[");
    ((StringBuilder)localObject).append(SmallScreenUtils.d);
    ((StringBuilder)localObject).append("]");
    QLog.w("SmallScreenService", 1, ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_Int > 0) {
      localObject = a(1);
    } else {
      localObject = a(0);
    }
    if (localObject != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.a().K = ((SmallScreenRelativeLayout)localObject).a();
    }
    e();
    super.onDestroy();
    a(l, 0);
    this.jdField_c_of_type_JavaLangRunnable = null;
    localObject = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoController;
    if (localObject != null)
    {
      ((SmallScreenVideoController)localObject).g();
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenService
 * JD-Core Version:    0.7.0.1
 */