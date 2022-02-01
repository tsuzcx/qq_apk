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
    QQGAudioCtrl localQQGAudioCtrl = this.jdField_a_of_type_ComTencentAvVideoController.a();
    VideoAppInterface localVideoAppInterface = this.jdField_a_of_type_ComTencentAvVideoController.a;
    boolean bool = false;
    if (localQQGAudioCtrl != null)
    {
      if (localVideoAppInterface == null) {
        return 0;
      }
      int i = 4;
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
        if (this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask != null)
        {
          localVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask);
          this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask = null;
        }
        this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask = new ScreenShareCtrl.ShareOpsTimeOutTask(this.jdField_a_of_type_ComTencentAvVideoController, paramSessionInfo, paramInt1, paramInt2);
        localVideoAppInterface.a().postDelayed(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask, 30000L);
        i = 1;
      }
      return i;
    }
    return 0;
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
    Object localObject = localBaseApplication.getResources();
    if (paramInt != 1)
    {
      if (paramInt != 7)
      {
        if (paramInt != 8) {
          localObject = null;
        } else {
          localObject = ((Resources)localObject).getString(2131695852);
        }
      }
      else {
        localObject = ((Resources)localObject).getString(2131695849);
      }
    }
    else {
      localObject = ((Resources)localObject).getString(2131695851);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      QQToast.a(localBaseApplication, -1, (CharSequence)localObject, 0).a();
    }
  }
  
  public static boolean a(SessionInfo paramSessionInfo)
  {
    boolean bool = true;
    if (paramSessionInfo != null)
    {
      if (paramSessionInfo.X == 2) {
        return bool;
      }
      if (paramSessionInfo.X == 1) {
        return true;
      }
    }
    bool = false;
    return bool;
  }
  
  private boolean a(QQGAudioCtrl paramQQGAudioCtrl)
  {
    return (paramQQGAudioCtrl != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().X == 2);
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("stopShareScreen, from[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("]");
      QLog.i("AVShare", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_MqqUtilWeakReference;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (AVActivity)((WeakReference)localObject).get();
    }
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (a(localSessionInfo))
    {
      a((AVActivity)localObject, 1L);
      if (localObject != null) {
        ((AVActivity)localObject).runOnUiThread(new ScreenShareCtrl.3(this, (AVActivity)localObject, localSessionInfo));
      }
    }
  }
  
  @TargetApi(21)
  private void b(AVActivity paramAVActivity, long paramLong)
  {
    if ((paramAVActivity != null) && (!paramAVActivity.isFinishing()) && (!paramAVActivity.isDestroyed()))
    {
      int i = ScreenShareTipsHelper.a();
      PopupDialog.a(paramAVActivity, 230, null, ScreenShareTipsHelper.a(), 2131695618, 2131695618, null, new ScreenShareCtrl.1(this, paramAVActivity, paramLong));
      ReportController.b(null, "dc00898", "", "", "0X800B48D", "0X800B48D", i, 0, "", "", "", "");
      return;
    }
  }
  
  public int a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a() == null) {
      return 2;
    }
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestShareScreenOps, emShareOps[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], cur[");
      localStringBuilder.append(localSessionInfo.X);
      localStringBuilder.append(",");
      localStringBuilder.append(localSessionInfo.Y);
      localStringBuilder.append("]");
      QLog.i("AVShare", 2, localStringBuilder.toString());
    }
    int j = localSessionInfo.Y;
    int i = 1;
    if ((j != 1) && (localSessionInfo.Y != 0)) {
      return 3;
    }
    if (paramInt != 1) {
      if (paramInt != 2) {}
    }
    switch (localSessionInfo.X)
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
        switch (localSessionInfo.X)
        {
        }
      }
      i = a(localSessionInfo, paramInt, 1);
    }
    return i;
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
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a;
    if (localObject == null) {
      return;
    }
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if ((localSessionInfo.jdField_E_of_type_Int == paramInt3) && (localSessionInfo.f == paramLong))
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
      if (this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask != null)
      {
        ((VideoAppInterface)localObject).a().removeCallbacks(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask);
        this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask = null;
      }
      paramInt5 = localSessionInfo.X;
      switch (paramInt1)
      {
      default: 
        paramInt1 = paramInt5;
        break;
      case 88: 
      case 89: 
        paramInt1 = paramInt5;
        if (localSessionInfo.X == 4) {
          paramInt1 = 6;
        }
        ScreenShareReportHelper.b(localSessionInfo.b, "onShareOpsCallback");
        break;
      case 87: 
        paramInt1 = paramInt5;
        if (localSessionInfo.X == 4) {
          paramInt1 = 5;
        }
        ScreenShareReportHelper.b(localSessionInfo.b, "onShareOpsCallback");
        break;
      case 85: 
      case 86: 
        paramInt1 = paramInt5;
        if (localSessionInfo.X == 1) {
          paramInt1 = 3;
        }
        break;
      case 84: 
        paramInt1 = paramInt5;
        if (localSessionInfo.X == 1) {
          paramInt1 = 2;
        }
        ScreenShareReportHelper.a(localSessionInfo.b, "onShareOpsCallback");
      }
      if (paramInt1 != localSessionInfo.X)
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
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (((SessionInfo)localObject).jdField_E_of_type_Int == paramInt)
    {
      if (((SessionInfo)localObject).f != paramLong) {
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
      if (((SessionInfo)localObject).X == 2)
      {
        localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if (localObject != null) {
          ((ScreenRecordHelper)localObject).a(paramRecordParam.width, paramRecordParam.height, paramRecordParam.fps);
        }
      }
    }
  }
  
  public void a(long paramLong)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    long l1;
    try
    {
      l1 = Long.parseLong(((SessionInfo)localObject1).c);
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
      if (((SessionInfo)localObject1).f != 0L) {
        l2 = ((SessionInfo)localObject1).f;
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
    int i = ((SessionInfo)localObject1).jdField_d_of_type_Int;
    String str2 = ((SessionInfo)localObject1).b;
    String str1 = SessionMgr.a(100, String.valueOf(l2), new int[0]);
    Object localObject2 = localSessionMgr.a(str1, false);
    ((SessionInfo)localObject2).b(paramLong, ((SessionInfo)localObject1).jdField_j_of_type_Boolean);
    ((SessionInfo)localObject2).g = ((SessionInfo)localObject1).g;
    ((SessionInfo)localObject2).aw = ((SessionInfo)localObject1).jdField_j_of_type_Boolean;
    ((SessionInfo)localObject2).b("switchToDoubleMeeting", ((SessionInfo)localObject1).jdField_E_of_type_Boolean);
    ((SessionInfo)localObject2).b("switchToDoubleMeeting", ((SessionInfo)localObject1).p);
    ((SessionInfo)localObject2).c = ((SessionInfo)localObject1).c;
    if (TextUtils.isEmpty(((SessionInfo)localObject2).c)) {
      ((SessionInfo)localObject2).c = String.valueOf(l2);
    }
    ((SessionInfo)localObject2).jdField_d_of_type_JavaLangString = ((SessionInfo)localObject1).jdField_d_of_type_JavaLangString;
    ((SessionInfo)localObject2).jdField_j_of_type_Int = 8;
    ((SessionInfo)localObject2).av = true;
    ((SessionInfo)localObject2).jdField_E_of_type_Int = 3;
    ((SessionInfo)localObject2).f = l2;
    ((SessionInfo)localObject2).k = 0;
    ((SessionInfo)localObject2).d("switchToDoubleMeeting", true);
    ((SessionInfo)localObject2).c(((SessionInfo)localObject1).ab);
    ((SessionInfo)localObject2).d(((SessionInfo)localObject1).ac);
    ((SessionInfo)localObject2).W = 5;
    this.jdField_a_of_type_ComTencentAvVideoController.k(true);
    this.jdField_a_of_type_ComTencentAvVideoController.a(((SessionInfo)localObject1).c, 8);
    this.jdField_a_of_type_ComTencentAvVideoController.b(262);
    this.jdField_a_of_type_ComTencentAvVideoController.b(((SessionInfo)localObject1).c, 72);
    this.jdField_a_of_type_ComTencentAvVideoController.jdField_d_of_type_Int = 3;
    if (localSessionMgr.a(str2))
    {
      boolean bool = localSessionMgr.a(paramLong, str2);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("switchToDoubleMeeting, need double remove. ret[");
      ((StringBuilder)localObject1).append(bool);
      ((StringBuilder)localObject1).append("]");
      QLog.i("AVShare", 2, ((StringBuilder)localObject1).toString());
    }
    if (localSessionMgr.a() != localObject2) {
      localSessionMgr.b(str1);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("switchToDoubleMeeting, after close pre one. cur[");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentAvVideoController.a());
      ((StringBuilder)localObject1).append("]");
      QLog.i("normal_2_meeting", 2, ((StringBuilder)localObject1).toString());
    }
    ((SessionInfo)localObject2).z = -1;
    if (i == 1) {
      ((SessionInfo)localObject2).a(paramLong, "switchToDoubleMeeting.1", 3);
    } else if (i == 2) {
      ((SessionInfo)localObject2).a(paramLong, "switchToDoubleMeeting.2", 4);
    }
    ((SessionInfo)localObject2).k = 0;
    ((SessionInfo)localObject2).f = l2;
    ((SessionInfo)localObject2).d("switchToDoubleMeeting", 0);
    this.jdField_a_of_type_ComTencentAvVideoController.a.a(new Object[] { Integer.valueOf(174), Long.valueOf(paramLong) });
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
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    Object localObject2 = SessionMgr.a(100, String.valueOf(paramLong2), new int[0]);
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    localObject2 = SessionMgr.a().c((String)localObject2);
    ((SessionInfo)localObject2).H = true;
    ((SessionInfo)localObject2).jdField_e_of_type_Int = 2;
    ((SessionInfo)localObject2).jdField_e_of_type_JavaLangString = null;
    ((SessionInfo)localObject2).jdField_e_of_type_Boolean = true;
    ((SessionInfo)localObject2).r = String.valueOf(paramLong2);
    ((SessionInfo)localObject2).c = ((SessionInfo)localObject1).c;
    ((SessionInfo)localObject2).jdField_d_of_type_JavaLangString = ((SessionInfo)localObject1).jdField_d_of_type_JavaLangString;
    ((SessionInfo)localObject2).aw = ((SessionInfo)localObject1).jdField_j_of_type_Boolean;
    ((SessionInfo)localObject2).b(paramLong1, false);
    ((SessionInfo)localObject2).g = ((SessionInfo)localObject1).g;
    ((SessionInfo)localObject2).b("onSwitch2DoubleMeeting", ((SessionInfo)localObject1).jdField_E_of_type_Boolean);
    ((SessionInfo)localObject2).b("onSwitch2DoubleMeeting", ((SessionInfo)localObject1).p);
    ((SessionInfo)localObject2).av = true;
    if (((SessionInfo)localObject1).jdField_d_of_type_Int == 1) {
      ((SessionInfo)localObject2).a(paramLong1, "onSwitch2DoubleMeeting.1", 3);
    } else {
      ((SessionInfo)localObject2).a(paramLong1, "onSwitch2DoubleMeeting.2", 4);
    }
    ((SessionInfo)localObject2).k = ((SessionInfo)localObject1).k;
    ((SessionInfo)localObject2).f = paramLong2;
    ((SessionInfo)localObject2).jdField_E_of_type_Int = 3;
    ((SessionInfo)localObject2).jdField_j_of_type_Int = 8;
    ((SessionInfo)localObject2).f("onSwitch2DoubleMeeting", true);
    ((SessionInfo)localObject2).d("onSwitch2DoubleMeeting", true);
    ((SessionInfo)localObject2).b("onSwitch2DoubleMeeting", 17);
    ((SessionInfo)localObject2).a("onSwitch2DoubleMeeting", 2);
    SessionMgr localSessionMgr = SessionMgr.a();
    VideoRecoveryMonitor localVideoRecoveryMonitor = this.jdField_a_of_type_ComTencentAvVideoController.a.a();
    if (localVideoRecoveryMonitor != null) {
      localVideoRecoveryMonitor.a(262);
    }
    this.jdField_a_of_type_ComTencentAvVideoController.b(((SessionInfo)localObject1).c, 72);
    if ((!TextUtils.isEmpty(((SessionInfo)localObject1).b)) && (localSessionMgr.a(((SessionInfo)localObject1).b)))
    {
      boolean bool = localSessionMgr.a(paramLong1, ((SessionInfo)localObject1).b);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onSwitch2DoubleMeeting, need double remove ret[");
        ((StringBuilder)localObject1).append(bool);
        ((StringBuilder)localObject1).append("]");
        QLog.i("AVShare", 2, ((StringBuilder)localObject1).toString());
      }
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a() != localObject2)
    {
      localSessionMgr.b(((SessionInfo)localObject2).b);
      if (QLog.isColorLevel()) {
        QLog.i("AVShare", 2, "onSwitch2DoubleMeeting, need double set main session. ");
      }
    }
    ((SessionInfo)localObject2).d("onSwitch2DoubleMeeting", 1);
    if (this.jdField_a_of_type_ComTencentAvVideoController.a.a() > 0) {
      this.jdField_a_of_type_ComTencentAvVideoController.a.a(new Object[] { Integer.valueOf(174), Long.valueOf(paramLong1) });
    } else if (this.jdField_a_of_type_ComTencentAvVideoController.a.isBackgroundStop) {
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong1, 3, paramLong2, new long[] { paramLong2 }, false);
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a(((SessionInfo)localObject2).b, ((SessionInfo)localObject2).jdField_d_of_type_Int, false, false, true);
  }
  
  public void a(Bitmap paramBitmap, RecordParam paramRecordParam)
  {
    if (paramRecordParam == null) {
      return;
    }
    QQGAudioCtrl localQQGAudioCtrl = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (a(localQQGAudioCtrl))
    {
      if (!this.jdField_a_of_type_ComTencentAvcoreDataRecordParam.equals(paramRecordParam))
      {
        this.jdField_a_of_type_ComTencentAvcoreDataRecordParam.update(paramRecordParam);
        localQQGAudioCtrl.setShareEncParam(this.jdField_a_of_type_ComTencentAvcoreDataRecordParam, this.jdField_a_of_type_Int, this.b, 1);
      }
      if (localQQGAudioCtrl.sendShareFrame(paramBitmap, paramRecordParam.width, paramRecordParam.height) != 0) {
        b(2);
      }
    }
    else if (localQQGAudioCtrl == null)
    {
      b(1);
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
    if (this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.a.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask);
    }
    this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask = new ScreenShareCtrl.DoubleMeetingInviteTimeOutTask(this.jdField_a_of_type_ComTencentAvVideoController, paramSessionInfo);
    this.jdField_a_of_type_ComTencentAvVideoController.a.a().postDelayed(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask, 15000L);
  }
  
  @TargetApi(21)
  public void a(AVActivity paramAVActivity, long paramLong)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    if (paramAVActivity != null) {
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAVActivity);
    }
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if (bool)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("startOrStopScreenShare, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.i("AVShare", 2, localStringBuilder.toString());
    }
    int j = localSessionInfo.X;
    Object localObject = null;
    StringBuilder localStringBuilder = null;
    if ((j != 2) && (localSessionInfo.X != 1))
    {
      if (localSessionInfo.a(this.jdField_a_of_type_ComTencentAvVideoController.a.getCurrentAccountUin()))
      {
        a(1);
        return;
      }
      if (localSessionInfo.s())
      {
        a(8);
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
        paramAVActivity = paramAVActivity.a();
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
        i = 3;
      }
      a(i);
      if (paramAVActivity == null) {
        paramAVActivity = localObject;
      } else {
        paramAVActivity = paramAVActivity.a();
      }
      if (paramAVActivity != null) {
        paramAVActivity.a(1);
      }
    }
  }
  
  public void a(RecordParam paramRecordParam, int paramInt1, int paramInt2)
  {
    QQGAudioCtrl localQQGAudioCtrl = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (localQQGAudioCtrl != null)
    {
      if (paramRecordParam == null) {
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
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    long l = AudioHelper.b();
    paramArrayOfByte = this.jdField_a_of_type_ComTencentAvVideoController.a();
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
    if (paramArrayOfByte.y) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (!paramString.equalsIgnoreCase(paramArrayOfByte.c)) {
      return;
    }
    paramArrayOfByte.d("onSwitchMeeting", true);
    paramArrayOfByte.f = 0L;
    paramArrayOfByte.b("onSwitchMeeting", 16);
    this.jdField_a_of_type_ComTencentAvVideoController.a.a(new Object[] { Integer.valueOf(174), Long.valueOf(l) });
    a();
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, RecordParam paramRecordParam)
  {
    if (paramRecordParam == null) {
      return;
    }
    QQGAudioCtrl localQQGAudioCtrl = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (a(localQQGAudioCtrl))
    {
      if (!this.jdField_a_of_type_ComTencentAvcoreDataRecordParam.equals(paramRecordParam))
      {
        this.jdField_a_of_type_ComTencentAvcoreDataRecordParam.update(paramRecordParam);
        localQQGAudioCtrl.setShareEncParam(this.jdField_a_of_type_ComTencentAvcoreDataRecordParam, this.jdField_a_of_type_Int, this.b, 1);
      }
      if (localQQGAudioCtrl.sendShareFrame(paramArrayOfByte, paramInt1, paramRecordParam.width, paramRecordParam.height, paramInt2) != 0) {
        b(2);
      }
    }
    else if (localQQGAudioCtrl == null)
    {
      b(1);
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
    Object localObject = this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask;
    if ((localObject != null) && (((ScreenShareCtrl.DoubleMeetingInviteTimeOutTask)localObject).a.f == paramLong))
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a.a().removeCallbacks(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask);
      this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.screenshare.ScreenShareCtrl
 * JD-Core Version:    0.7.0.1
 */