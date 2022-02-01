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
  public static boolean e = false;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new MultiIncomingCallUICtr.1(this);
  Intent jdField_a_of_type_AndroidContentIntent;
  SessionMgr jdField_a_of_type_ComTencentAvSessionMgr = SessionMgr.a();
  VideoController jdField_a_of_type_ComTencentAvVideoController = null;
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new MultiIncomingCallUICtr.3(this);
  VideoObserver jdField_a_of_type_ComTencentAvAppVideoObserver = new MultiIncomingCallUICtr.4(this);
  QAVNotification jdField_a_of_type_ComTencentAvUtilsQAVNotification;
  Runnable jdField_b_of_type_JavaLangRunnable = null;
  boolean jdField_b_of_type_Boolean = false;
  Runnable jdField_c_of_type_JavaLangRunnable = new MultiIncomingCallUICtr.5(this);
  boolean jdField_c_of_type_Boolean;
  int jdField_d_of_type_Int = 0;
  boolean jdField_d_of_type_Boolean = false;
  int jdField_e_of_type_Int = -1;
  String jdField_e_of_type_JavaLangString = "";
  String f = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;";
  
  public MultiIncomingCallUICtr(VideoController paramVideoController, VideoAppInterface paramVideoAppInterface, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  public int a(Intent paramIntent)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStartCommand, seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w("MultiIncomingCallUICtr", 1, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    a();
    a(l, paramIntent);
    return 2;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      try
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
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
      if (this.jdField_b_of_type_JavaLangRunnable != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
        this.jdField_b_of_type_JavaLangRunnable = null;
      }
      if (this.jdField_c_of_type_JavaLangRunnable != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
        this.jdField_c_of_type_JavaLangRunnable = null;
      }
    }
  }
  
  void a(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
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
    Object localObject = Long.valueOf(CharacterUtil.a(this.jdField_c_of_type_JavaLangString));
    if (this.jdField_b_of_type_Boolean)
    {
      if (paramInt == 1)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, ((Long)localObject).longValue(), 7);
        return;
      }
      if (paramInt == 2) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, ((Long)localObject).longValue(), 2);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString, 243);
      this.jdField_a_of_type_ComTencentAvVideoController.b(243);
    }
  }
  
  void a(long paramLong1, int paramInt1, long paramLong2, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    VideoController localVideoController = this.jdField_a_of_type_ComTencentAvVideoController;
    if (localVideoController == null) {
      return;
    }
    if (!paramBoolean2) {
      localVideoController.a(paramLong1, paramInt1, paramLong2, 10, false);
    } else {
      localVideoController.a(paramLong1, paramInt1, paramLong2, paramInt2, false);
    }
    if ((paramBoolean1) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(paramLong2), Integer.valueOf(3) });
    }
    ReportController.b(null, "CliOper", "", "", "0X8008B2C", "0X8008B2C", 0, 0, "", "", "", "");
    a();
  }
  
  void a(long paramLong, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("peerUin");
    this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("extraUin");
    this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("isDoubleVideoMeeting", false);
    this.jdField_b_of_type_Int = paramIntent.getIntExtra("uinType", 0);
    this.jdField_c_of_type_Int = paramIntent.getIntExtra("relationType", 3);
    this.jdField_e_of_type_Int = paramIntent.getIntExtra("memberType", -1);
    this.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("hasGVideoJoined", false);
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("isAudioMode", false);
    this.jdField_d_of_type_Int = paramIntent.getIntExtra("bindType", 0);
    Object localObject;
    if (AVUtil.b(this.jdField_b_of_type_Int))
    {
      if (paramIntent.getIntExtra("MultiAVType", -1) == 2) {
        this.jdField_a_of_type_Boolean = false;
      } else {
        this.jdField_a_of_type_Boolean = true;
      }
      this.jdField_b_of_type_Long = paramIntent.getLongExtra("friendUin", 0L);
      this.jdField_e_of_type_JavaLangString = paramIntent.getStringExtra("inviteId");
      this.jdField_a_of_type_Long = paramIntent.getLongExtra("discussId", 0L);
      localObject = SessionMgr.a(this.jdField_c_of_type_Int, String.valueOf(this.jdField_a_of_type_Long), new int[0]);
      this.jdField_a_of_type_ComTencentAvAppSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.c((String)localObject);
      this.jdField_a_of_type_ArrayOfLong = paramIntent.getLongArrayExtra("memberList");
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    }
    else if (this.jdField_b_of_type_Boolean)
    {
      paramIntent = SessionMgr.a(100, this.jdField_c_of_type_JavaLangString, new int[0]);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sessionId : ");
        ((StringBuilder)localObject).append(paramIntent);
        QLog.d("MultiIncomingCallUICtr", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo = SessionMgr.a().c(paramIntent);
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.a(paramLong, "processIntent.1", 4);
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.f("processIntent", true);
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.af = true;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.e = true;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.C = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    }
    else
    {
      paramIntent = SessionMgr.a(3, this.jdField_c_of_type_JavaLangString, new int[0]);
      this.jdField_a_of_type_ComTencentAvAppSessionInfo = SessionMgr.a().c(paramIntent);
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.a(paramLong, "processIntent.2", 1);
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.b(paramLong, false);
      }
      else
      {
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.a(paramLong, "processIntent.3", 2);
        this.jdField_a_of_type_ComTencentAvAppSessionInfo.b(paramLong, true);
      }
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.e = true;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.C = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
    }
    a(true);
    if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo == null) && (this.jdField_b_of_type_Int != 1))
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
    this.jdField_d_of_type_Boolean = true;
    Object localObject = SessionMgr.a().a();
    boolean bool = false;
    if ((paramSessionInfo != null) && (localObject == paramSessionInfo))
    {
      if (SessionMgr.a().a() >= 2)
      {
        if (paramSessionInfo.h())
        {
          a(paramLong, false, paramSessionInfo);
        }
        else
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a(true, 201, new int[] { ((SessionInfo)localObject).j });
          this.jdField_a_of_type_ComTencentAvVideoController.b(201);
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
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo != null)
    {
      if (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.h())
      {
        if (QLog.isColorLevel())
        {
          paramSessionInfo = new StringBuilder();
          paramSessionInfo.append("Session already destroyed, id:");
          paramSessionInfo.append(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString);
          paramSessionInfo.append(", status = ");
          paramSessionInfo.append(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_f_of_type_Int);
          QLog.d("MultiIncomingCallUICtr", 2, paramSessionInfo.toString());
        }
      }
      else if (AVUtil.b(this.jdField_b_of_type_Int))
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_f_of_type_Long, this.jdField_a_of_type_ArrayOfLong, false);
        ReportController.b(null, "CliOper", "", "", "0X8008B2B", "0X8008B2B", 0, 0, "", "", "", "");
      }
      else
      {
        int i = true ^ this.jdField_a_of_type_Boolean;
        if (QLog.isColorLevel())
        {
          paramSessionInfo = new StringBuilder();
          paramSessionInfo.append("appType :");
          paramSessionInfo.append(i);
          QLog.d("MultiIncomingCallUICtr", 2, paramSessionInfo.toString());
        }
        if (this.jdField_b_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MultiIncomingCallUICtr", 2, "acceptVideoRequest isDoubleVideoMeeting");
          }
          this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 3, Long.valueOf(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString).longValue(), null, false);
          ReportController.b(null, "CliOper", "", "", "0X8008B2B", "0X8008B2B", 0, 0, "", "", "", "");
        }
        else
        {
          int j = UITools.d(this.jdField_c_of_type_Int);
          this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_c_of_type_JavaLangString, i, j);
          if (this.jdField_a_of_type_Boolean) {
            ReportController.b(null, "CliOper", "", "", "0X8008B24", "0X8008B24", 0, 0, "", "", "", "");
          } else {
            ReportController.b(null, "CliOper", "", "", "0X8008B27", "0X8008B27", 0, 0, "", "", "", "");
          }
        }
        b();
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar.c(HardCodeUtil.a(2131707042));
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
      this.jdField_d_of_type_Boolean = false;
    }
    TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    Object localObject = this.jdField_c_of_type_JavaLangString;
    boolean bool1 = this.jdField_b_of_type_Boolean;
    int i = this.jdField_c_of_type_Int;
    long l = this.jdField_a_of_type_Long;
    if (!paramBoolean) {
      if (paramSessionInfo != null)
      {
        String str = paramSessionInfo.jdField_c_of_type_JavaLangString;
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = paramSessionInfo.r;
        }
        bool1 = paramSessionInfo.y;
        i = paramSessionInfo.E;
        l = paramSessionInfo.jdField_f_of_type_Long;
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
    if (AVUtil.b(j))
    {
      a(paramLong, i, l, bool2, paramInt, paramBoolean);
      return;
    }
    a(paramLong, bool1, (String)localObject, bool2, paramBoolean);
  }
  
  void a(long paramLong, boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
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
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.H) {
      ReportController.b(null, "CliOper", "", "", "0X8008B25", "0X8008B25", 0, 0, "", "", "", "");
    } else {
      ReportController.b(null, "CliOper", "", "", "0X8008B28", "0X8008B28", 0, 0, "", "", "", "");
    }
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, paramString, 1, true);
      long l2 = -1L;
      long l1;
      try
      {
        l1 = CharacterUtil.a(paramString);
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
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 3, l1, 10, false);
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, l1, 23);
        a();
      }
      else
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 3, l1);
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, l1, 1);
        a();
      }
    }
    else
    {
      VideoController localVideoController = this.jdField_a_of_type_ComTencentAvVideoController;
      localVideoController.a(paramLong, paramString, 1, false, new MultiIncomingCallUICtr.2(this, localVideoController, paramString, paramBoolean3));
    }
    if ((paramBoolean2) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), paramString, Boolean.valueOf(true) });
    }
  }
  
  void a(SessionInfo paramSessionInfo)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (paramSessionInfo != null))
    {
      Intent localIntent = new Intent();
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      localIntent.setAction("tencent.av.v2q.StopVideoChat");
      localIntent.putExtra("stopReason3rd", 1);
      localIntent.putExtra("groupId", paramSessionInfo.jdField_f_of_type_Long);
      localIntent.putExtra("peerUin", paramSessionInfo.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
    }
  }
  
  boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiIncomingCallUICtr", 2, "initEnvParam");
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      VideoController localVideoController = this.jdField_a_of_type_ComTencentAvVideoController;
      if (localVideoController != null)
      {
        if ((localVideoController.a().m()) || (this.jdField_a_of_type_ComTencentAvVideoController.a().n()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MultiIncomingCallUICtr", 2, "initEnvParam closeSession");
          }
          localVideoController = this.jdField_a_of_type_ComTencentAvVideoController;
          localVideoController.b(localVideoController.a().jdField_c_of_type_JavaLangString, 2);
        }
        return true;
      }
    }
    return false;
  }
  
  boolean a(int paramInt)
  {
    return paramInt == 3000;
  }
  
  boolean b(int paramInt)
  {
    if ((this.jdField_b_of_type_Int == 1) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)))
    {
      Intent localIntent = new Intent("tencent.video.v2q.ACTION_DEAL_INVITE_TO_ENTER_GROUP_VEDIO");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("");
      localIntent.putExtra("relationId", localStringBuilder.toString());
      localIntent.putExtra("dealResult", paramInt);
      localIntent.putExtra("inviteId", this.jdField_e_of_type_JavaLangString);
      localIntent.putExtra("friendUin", this.jdField_b_of_type_Long);
      localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
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
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  void e()
  {
    Intent localIntent = new Intent("tencent.video.v2q.ACTION_ENTER_GROUP_VEDIO");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("");
    localIntent.putExtra("relationId", localStringBuilder.toString());
    localIntent.putExtra("enterType", 1);
    localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
    if (QLog.isDevelopLevel()) {
      QLog.d("MultiIncomingCallUICtr.troopgroup_vedio.invite", 2, "sendBroadcast, qav_gaudio_answer");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(514), Long.valueOf(this.jdField_a_of_type_Long) });
    b(1);
  }
  
  void f()
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification == null) {
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    if (!AVUtil.b(this.jdField_b_of_type_Int))
    {
      localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_b_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, true, true);
      if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, (Bitmap)localObject, null, 56, this.jdField_b_of_type_Int, 2);
        return;
      }
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, (Bitmap)localObject, null, 55, this.jdField_b_of_type_Int, 1);
      return;
    }
    Object localObject = String.valueOf(this.jdField_a_of_type_Long);
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_b_of_type_Int, (String)localObject, null, true, true);
    int i = AVUtil.b(this.jdField_b_of_type_Int);
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, Long.toString(this.jdField_b_of_type_Long), (String)localObject);
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo != null) {
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString, str, localBitmap, (String)localObject, 57, this.jdField_b_of_type_Int, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallUICtr
 * JD-Core Version:    0.7.0.1
 */