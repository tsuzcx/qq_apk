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
import com.tencent.av.utils.PopupDialog;
import com.tencent.avcore.data.RecordParam;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class ScreenShareCtrl
{
  private int jdField_a_of_type_Int = 0;
  private final VideoController jdField_a_of_type_ComTencentAvVideoController;
  private ScreenShareCtrl.DoubleMeetingInviteTimeOutTask jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask = null;
  private ScreenShareCtrl.ScreenShareListener jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ScreenShareListener = null;
  private ScreenShareCtrl.ShareOpsTimeOutTask jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask = null;
  private final RecordParam jdField_a_of_type_ComTencentAvcoreDataRecordParam = new RecordParam();
  private Runnable jdField_a_of_type_JavaLangRunnable = null;
  private WeakReference<AVActivity> jdField_a_of_type_MqqUtilWeakReference = null;
  private int b = 0;
  
  public ScreenShareCtrl(VideoController paramVideoController)
  {
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
  }
  
  private int a(SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    QQGAudioCtrl localQQGAudioCtrl = this.jdField_a_of_type_ComTencentAvVideoController.a();
    VideoAppInterface localVideoAppInterface = this.jdField_a_of_type_ComTencentAvVideoController.a;
    if ((localQQGAudioCtrl == null) || (localVideoAppInterface == null)) {
      return 0;
    }
    if (paramInt1 == 1) {
      paramSessionInfo.a("executeShareScreenOps", 1, paramInt2);
    }
    for (;;)
    {
      if (paramInt1 == 2) {
        bool = true;
      }
      if (localQQGAudioCtrl.startOrStopShareSend(bool, paramInt2)) {
        break label112;
      }
      if (paramInt1 != 1) {
        break;
      }
      paramSessionInfo.a("executeShareScreenOps", 3, paramInt2);
      return 4;
      if (paramInt1 == 2) {
        paramSessionInfo.a("executeShareScreenOps", 4, paramInt2);
      }
    }
    if (paramInt1 == 2)
    {
      paramSessionInfo.a("executeShareScreenOps", 6, paramInt2);
      return 4;
      label112:
      if (this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask != null)
      {
        localVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask);
        this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask = null;
      }
      this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask = new ScreenShareCtrl.ShareOpsTimeOutTask(this.jdField_a_of_type_ComTencentAvVideoController, paramSessionInfo, paramInt1, paramInt2);
      localVideoAppInterface.a().postDelayed(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask, 30000L);
      return 1;
    }
    return 4;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new ScreenShareCtrl.2(this);
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a != null) && (this.jdField_a_of_type_JavaLangRunnable != null)) {
      this.jdField_a_of_type_ComTencentAvVideoController.a.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 20000L);
    }
  }
  
  public static void a(int paramInt)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    Resources localResources = localBaseApplication.getResources();
    Object localObject = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        QQToast.a(localBaseApplication, -1, (CharSequence)localObject, 0).a();
      }
      return;
      localObject = localResources.getString(2131695837);
      continue;
      localObject = localResources.getString(2131695835);
      continue;
      localObject = localResources.getString(2131695838);
    }
  }
  
  public static boolean a(SessionInfo paramSessionInfo)
  {
    return (paramSessionInfo != null) && ((paramSessionInfo.ae == 2) || (paramSessionInfo.ae == 1));
  }
  
  private boolean a(QQGAudioCtrl paramQQGAudioCtrl)
  {
    return (paramQQGAudioCtrl != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().ae == 2);
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVShare", 2, "stopShareScreen, from[" + paramInt + "]");
    }
    if (this.jdField_a_of_type_MqqUtilWeakReference == null) {}
    for (AVActivity localAVActivity = null;; localAVActivity = (AVActivity)this.jdField_a_of_type_MqqUtilWeakReference.get())
    {
      SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (a(localSessionInfo))
      {
        a(localAVActivity, 1L);
        if (localAVActivity != null) {
          localAVActivity.runOnUiThread(new ScreenShareCtrl.3(this, localAVActivity, localSessionInfo));
        }
      }
      return;
    }
  }
  
  @TargetApi(21)
  private void b(AVActivity paramAVActivity, long paramLong)
  {
    if ((paramAVActivity == null) || (paramAVActivity.isFinishing()) || (paramAVActivity.isDestroyed())) {
      return;
    }
    int i = ScreenShareTipsHelper.a();
    PopupDialog.a(paramAVActivity, 230, null, ScreenShareTipsHelper.a(), 2131695607, 2131695607, null, new ScreenShareCtrl.1(this, paramAVActivity, paramLong));
    ReportController.b(null, "dc00898", "", "", "0X800B48D", "0X800B48D", i, 0, "", "", "", "");
  }
  
  public int a(int paramInt)
  {
    int i = 1;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a() == null)
    {
      i = 2;
      return i;
    }
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (QLog.isColorLevel()) {
      QLog.i("AVShare", 2, "requestShareScreenOps, emShareOps[" + paramInt + "], cur[" + localSessionInfo.ae + "," + localSessionInfo.af + "]");
    }
    if ((localSessionInfo.af != 1) && (localSessionInfo.af != 0)) {
      return 3;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      switch (localSessionInfo.ae)
      {
      case 1: 
      case 2: 
      default: 
        break;
      case 0: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
        return a(localSessionInfo, paramInt, 1);
        switch (localSessionInfo.ae)
        {
        }
        break;
      }
    }
    return a(localSessionInfo, paramInt, 1);
  }
  
  public ScreenShareCtrl.ScreenShareListener a()
  {
    if (this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ScreenShareListener == null) {
      this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ScreenShareListener = new ScreenShareCtrl.ScreenShareListener(this);
    }
    return this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ScreenShareListener;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, int paramInt5)
  {
    VideoAppInterface localVideoAppInterface = this.jdField_a_of_type_ComTencentAvVideoController.a;
    if (localVideoAppInterface == null) {
      return;
    }
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if ((localSessionInfo.F != paramInt3) || (localSessionInfo.jdField_g_of_type_Long != paramLong))
    {
      QLog.i("AVShare", 1, "onShareOpsCallback, error session, session[" + localSessionInfo + "], [" + paramInt3 + "," + paramLong + "," + paramInt4 + "," + paramInt5 + "], actionResult[" + paramInt1 + "], shareType[" + paramInt2 + "]");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AVShare", 2, "onShareOpsCallback, session[" + localSessionInfo + "], [" + paramInt3 + "," + paramLong + "," + paramInt4 + "," + paramInt5 + "], actionResult[" + paramInt1 + "], shareType[" + paramInt2 + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask != null)
    {
      localVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask);
      this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask = null;
    }
    paramInt5 = localSessionInfo.ae;
    switch (paramInt1)
    {
    default: 
      paramInt1 = paramInt5;
    }
    while (paramInt1 != localSessionInfo.ae)
    {
      localSessionInfo.a("onShareOpsCallback", paramInt1, paramInt2);
      localVideoAppInterface.a(new Object[] { Integer.valueOf(519), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong), Integer.valueOf(paramInt4) });
      return;
      paramInt1 = paramInt5;
      if (localSessionInfo.ae == 1) {
        paramInt1 = 2;
      }
      ScreenShareReportHelper.a(localSessionInfo.c, "onShareOpsCallback");
      continue;
      paramInt1 = paramInt5;
      if (localSessionInfo.ae == 1)
      {
        paramInt1 = 3;
        continue;
        paramInt1 = paramInt5;
        if (localSessionInfo.ae == 4) {
          paramInt1 = 5;
        }
        ScreenShareReportHelper.b(localSessionInfo.c, "onShareOpsCallback");
        continue;
        paramInt1 = paramInt5;
        if (localSessionInfo.ae == 4) {
          paramInt1 = 6;
        }
        ScreenShareReportHelper.b(localSessionInfo.c, "onShareOpsCallback");
      }
    }
  }
  
  @TargetApi(21)
  public void a(int paramInt, long paramLong, RecordParam paramRecordParam)
  {
    if (paramRecordParam == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
        } while ((((SessionInfo)localObject).F != paramInt) || (((SessionInfo)localObject).jdField_g_of_type_Long != paramLong));
        if (QLog.isColorLevel()) {
          QLog.i("AVShare", 2, "onRecSharePushEncParam, param[" + paramRecordParam + "], session[" + localObject + "]");
        }
      } while (((SessionInfo)localObject).ae != 2);
      localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    } while (localObject == null);
    ((ScreenRecordHelper)localObject).a(paramRecordParam.width, paramRecordParam.height, paramRecordParam.fps);
  }
  
  public void a(long paramLong)
  {
    SessionInfo localSessionInfo1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    long l2;
    int i;
    SessionInfo localSessionInfo2;
    try
    {
      l1 = Long.parseLong(localSessionInfo1.jdField_d_of_type_JavaLangString);
      l2 = l1;
      if (l1 == 0L)
      {
        l2 = l1;
        if (localSessionInfo1.jdField_g_of_type_Long != 0L) {
          l2 = localSessionInfo1.jdField_g_of_type_Long;
        }
      }
      if (l2 == 0L)
      {
        QLog.i("normal_2_meeting", 1, "switchToDoubleMeeting relationId illegal.");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        long l1 = 0L;
      }
      if (QLog.isColorLevel()) {
        QLog.i("normal_2_meeting", 2, "switchToDoubleMeeting, session[" + localSessionInfo1 + "]");
      }
      SessionMgr localSessionMgr = SessionMgr.a();
      i = localSessionInfo1.jdField_d_of_type_Int;
      String str1 = localSessionInfo1.c;
      String str2 = SessionMgr.a(100, String.valueOf(l2), new int[0]);
      localSessionInfo2 = localSessionMgr.a(str2, false);
      localSessionInfo2.a(paramLong, localSessionInfo1.jdField_j_of_type_Boolean);
      localSessionInfo2.jdField_g_of_type_Boolean = localSessionInfo1.jdField_g_of_type_Boolean;
      localSessionInfo2.aJ = localSessionInfo1.jdField_j_of_type_Boolean;
      localSessionInfo2.b("switchToDoubleMeeting", localSessionInfo1.P);
      localSessionInfo2.b("switchToDoubleMeeting", localSessionInfo1.q);
      localSessionInfo2.jdField_d_of_type_JavaLangString = localSessionInfo1.jdField_d_of_type_JavaLangString;
      if (TextUtils.isEmpty(localSessionInfo2.jdField_d_of_type_JavaLangString)) {
        localSessionInfo2.jdField_d_of_type_JavaLangString = String.valueOf(l2);
      }
      localSessionInfo2.jdField_e_of_type_JavaLangString = localSessionInfo1.jdField_e_of_type_JavaLangString;
      localSessionInfo2.D = 8;
      localSessionInfo2.aH = true;
      localSessionInfo2.F = 3;
      localSessionInfo2.jdField_g_of_type_Long = l2;
      localSessionInfo2.jdField_j_of_type_Int = 0;
      localSessionInfo2.f("switchToDoubleMeeting", true);
      localSessionInfo2.b(localSessionInfo1.c());
      localSessionInfo2.c(localSessionInfo1.d());
      localSessionInfo2.ad = 5;
      this.jdField_a_of_type_ComTencentAvVideoController.l(true);
      this.jdField_a_of_type_ComTencentAvVideoController.a(localSessionInfo1.jdField_d_of_type_JavaLangString, 8);
      this.jdField_a_of_type_ComTencentAvVideoController.b(262);
      this.jdField_a_of_type_ComTencentAvVideoController.b(localSessionInfo1.jdField_d_of_type_JavaLangString, 72);
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_d_of_type_Int = 3;
      if (localSessionMgr.a(str1))
      {
        boolean bool = localSessionMgr.a(paramLong, str1);
        QLog.i("AVShare", 2, "switchToDoubleMeeting, need double remove. ret[" + bool + "]");
      }
      if (localSessionMgr.a() != localSessionInfo2) {
        localSessionMgr.b(str2);
      }
      if (QLog.isColorLevel()) {
        QLog.i("normal_2_meeting", 2, "switchToDoubleMeeting, after close pre one. cur[" + this.jdField_a_of_type_ComTencentAvVideoController.a() + "]");
      }
      localSessionInfo2.z = -1;
      if (i != 1) {
        break label571;
      }
    }
    localSessionInfo2.a(paramLong, "switchToDoubleMeeting.1", 3);
    for (;;)
    {
      localSessionInfo2.jdField_j_of_type_Int = 0;
      localSessionInfo2.jdField_g_of_type_Long = l2;
      localSessionInfo2.c("switchToDoubleMeeting", 0);
      this.jdField_a_of_type_ComTencentAvVideoController.a.a(new Object[] { Integer.valueOf(174), Long.valueOf(paramLong) });
      return;
      label571:
      if (i == 2) {
        localSessionInfo2.a(paramLong, "switchToDoubleMeeting.2", 4);
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("normal_2_meeting", 2, "onSwitch2DoubleMeeting, seq[" + paramLong1 + "], uin[" + paramLong2 + "], avtype[" + paramInt1 + "], subType[" + paramInt2 + "]");
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    Object localObject = SessionMgr.a(100, String.valueOf(paramLong2), new int[0]);
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    localObject = SessionMgr.a().c((String)localObject);
    ((SessionInfo)localObject).S = true;
    ((SessionInfo)localObject).jdField_f_of_type_Int = 2;
    ((SessionInfo)localObject).jdField_f_of_type_JavaLangString = null;
    ((SessionInfo)localObject).jdField_e_of_type_Boolean = true;
    ((SessionInfo)localObject).s = String.valueOf(paramLong2);
    ((SessionInfo)localObject).jdField_d_of_type_JavaLangString = localSessionInfo.jdField_d_of_type_JavaLangString;
    ((SessionInfo)localObject).jdField_e_of_type_JavaLangString = localSessionInfo.jdField_e_of_type_JavaLangString;
    ((SessionInfo)localObject).aJ = localSessionInfo.jdField_j_of_type_Boolean;
    ((SessionInfo)localObject).a(paramLong1, false);
    ((SessionInfo)localObject).jdField_g_of_type_Boolean = localSessionInfo.jdField_g_of_type_Boolean;
    ((SessionInfo)localObject).b("onSwitch2DoubleMeeting", localSessionInfo.P);
    ((SessionInfo)localObject).b("onSwitch2DoubleMeeting", localSessionInfo.q);
    ((SessionInfo)localObject).aH = true;
    if (localSessionInfo.jdField_d_of_type_Int == 1)
    {
      ((SessionInfo)localObject).a(paramLong1, "onSwitch2DoubleMeeting.1", 3);
      ((SessionInfo)localObject).jdField_j_of_type_Int = localSessionInfo.jdField_j_of_type_Int;
      ((SessionInfo)localObject).jdField_g_of_type_Long = paramLong2;
      ((SessionInfo)localObject).F = 3;
      ((SessionInfo)localObject).D = 8;
      ((SessionInfo)localObject).e("onSwitch2DoubleMeeting", true);
      ((SessionInfo)localObject).f("onSwitch2DoubleMeeting", true);
      ((SessionInfo)localObject).a(5, 17);
      ((SessionInfo)localObject).a("onSwitch2DoubleMeeting", 2);
      SessionMgr localSessionMgr = SessionMgr.a();
      VideoRecoveryMonitor localVideoRecoveryMonitor = this.jdField_a_of_type_ComTencentAvVideoController.a.a();
      if (localVideoRecoveryMonitor != null) {
        localVideoRecoveryMonitor.a(262);
      }
      this.jdField_a_of_type_ComTencentAvVideoController.b(localSessionInfo.jdField_d_of_type_JavaLangString, 72);
      if ((!TextUtils.isEmpty(localSessionInfo.c)) && (localSessionMgr.a(localSessionInfo.c)))
      {
        boolean bool = localSessionMgr.a(paramLong1, localSessionInfo.c);
        if (QLog.isColorLevel()) {
          QLog.i("AVShare", 2, "onSwitch2DoubleMeeting, need double remove ret[" + bool + "]");
        }
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a() != localObject)
      {
        localSessionMgr.b(((SessionInfo)localObject).c);
        if (QLog.isColorLevel()) {
          QLog.i("AVShare", 2, "onSwitch2DoubleMeeting, need double set main session. ");
        }
      }
      ((SessionInfo)localObject).c("onSwitch2DoubleMeeting", 1);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a.a() <= 0) {
        break label570;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a.a(new Object[] { Integer.valueOf(174), Long.valueOf(paramLong1) });
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(((SessionInfo)localObject).c, ((SessionInfo)localObject).jdField_d_of_type_Int, false, false, true);
      return;
      ((SessionInfo)localObject).a(paramLong1, "onSwitch2DoubleMeeting.2", 4);
      break;
      label570:
      if (this.jdField_a_of_type_ComTencentAvVideoController.a.isBackgroundStop) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong1, 3, paramLong2, new long[] { paramLong2 }, false);
      }
    }
  }
  
  public void a(Bitmap paramBitmap, RecordParam paramRecordParam)
  {
    if (paramRecordParam == null) {}
    QQGAudioCtrl localQQGAudioCtrl;
    do
    {
      do
      {
        return;
        localQQGAudioCtrl = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if (!a(localQQGAudioCtrl)) {
          break;
        }
        if (!this.jdField_a_of_type_ComTencentAvcoreDataRecordParam.equals(paramRecordParam))
        {
          this.jdField_a_of_type_ComTencentAvcoreDataRecordParam.update(paramRecordParam);
          localQQGAudioCtrl.setShareEncParam(this.jdField_a_of_type_ComTencentAvcoreDataRecordParam, this.jdField_a_of_type_Int, this.b, 1);
        }
      } while (localQQGAudioCtrl.sendShareFrame(paramBitmap, paramRecordParam.width, paramRecordParam.height) == 0);
      b(2);
      return;
    } while (localQQGAudioCtrl != null);
    b(1);
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AVShare", 2, "startDoubleMeetingTimeOutTask, info[" + paramSessionInfo + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.a.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask);
    }
    this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask = new ScreenShareCtrl.DoubleMeetingInviteTimeOutTask(this.jdField_a_of_type_ComTencentAvVideoController, paramSessionInfo);
    this.jdField_a_of_type_ComTencentAvVideoController.a.a().postDelayed(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask, 15000L);
  }
  
  @TargetApi(21)
  public void a(AVActivity paramAVActivity, long paramLong)
  {
    Object localObject = null;
    int i = 2;
    if (Build.VERSION.SDK_INT < 21) {}
    for (;;)
    {
      return;
      if (paramAVActivity != null) {
        this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAVActivity);
      }
      SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (QLog.isColorLevel()) {
        QLog.i("AVShare", 2, "startOrStopScreenShare, seq[" + paramLong + "]");
      }
      if ((localSessionInfo.ae == 2) || (localSessionInfo.ae == 1))
      {
        if (a(2) == 1)
        {
          a(i);
          if (paramAVActivity != null) {
            break label132;
          }
        }
        label132:
        for (paramAVActivity = localObject;; paramAVActivity = paramAVActivity.a())
        {
          if (paramAVActivity == null) {
            break label138;
          }
          paramAVActivity.a(1);
          return;
          i = 3;
          break;
        }
      }
      else
      {
        label138:
        if (localSessionInfo.a(this.jdField_a_of_type_ComTencentAvVideoController.a.getCurrentAccountUin()))
        {
          a(1);
          return;
        }
        if (localSessionInfo.y())
        {
          a(8);
          return;
        }
        if ((paramAVActivity != null) && ((ScreenShareTipsHelper.a() == 1) || (ScreenShareTipsHelper.a() == 2)))
        {
          b(paramAVActivity, paramLong);
          return;
        }
        if (paramAVActivity == null) {}
        for (paramAVActivity = null; paramAVActivity != null; paramAVActivity = paramAVActivity.a())
        {
          paramAVActivity.a(a());
          paramAVActivity.a(a());
          paramAVActivity.a();
          return;
        }
      }
    }
  }
  
  public void a(RecordParam paramRecordParam, int paramInt1, int paramInt2)
  {
    QQGAudioCtrl localQQGAudioCtrl = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if ((localQQGAudioCtrl == null) || (paramRecordParam == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvcoreDataRecordParam.update(paramRecordParam);
    if (paramInt1 != 0) {
      this.jdField_a_of_type_Int = paramInt1;
    }
    if (paramInt2 != 0) {
      this.b = paramInt2;
    }
    localQQGAudioCtrl.setShareEncParam(this.jdField_a_of_type_ComTencentAvcoreDataRecordParam, this.jdField_a_of_type_Int, this.b, 0);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    long l = AudioHelper.b();
    paramArrayOfByte = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (QLog.isColorLevel()) {
      QLog.w("normal_2_meeting", 2, "onSwitchMeeting, fromUin[" + paramString + "], flag[" + paramLong + "], session[" + paramArrayOfByte + "], seq[" + l + "]");
    }
    if (paramArrayOfByte.J) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equalsIgnoreCase(paramArrayOfByte.jdField_d_of_type_JavaLangString))) {
      return;
    }
    paramArrayOfByte.f("onSwitchMeeting", true);
    paramArrayOfByte.jdField_g_of_type_Long = 0L;
    paramArrayOfByte.a(6, 16);
    this.jdField_a_of_type_ComTencentAvVideoController.a.a(new Object[] { Integer.valueOf(174), Long.valueOf(l) });
    a();
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, RecordParam paramRecordParam)
  {
    if (paramRecordParam == null) {}
    QQGAudioCtrl localQQGAudioCtrl;
    do
    {
      do
      {
        return;
        localQQGAudioCtrl = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if (!a(localQQGAudioCtrl)) {
          break;
        }
        if (!this.jdField_a_of_type_ComTencentAvcoreDataRecordParam.equals(paramRecordParam))
        {
          this.jdField_a_of_type_ComTencentAvcoreDataRecordParam.update(paramRecordParam);
          localQQGAudioCtrl.setShareEncParam(this.jdField_a_of_type_ComTencentAvcoreDataRecordParam, this.jdField_a_of_type_Int, this.b, 1);
        }
      } while (localQQGAudioCtrl.sendShareFrame(paramArrayOfByte, paramInt1, paramRecordParam.width, paramRecordParam.height, paramInt2) == 0);
      b(2);
      return;
    } while (localQQGAudioCtrl != null);
    b(1);
  }
  
  public void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVShare", 2, "removeDoubleMeetingTimeOutTask, info[" + paramLong + "]");
    }
    if ((this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask != null) && (this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask.a.jdField_g_of_type_Long == paramLong))
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask);
      this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.screenshare.ScreenShareCtrl
 * JD-Core Version:    0.7.0.1
 */