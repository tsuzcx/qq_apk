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
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new VideoInviteFloatBarUICtr.1(this);
  Intent jdField_a_of_type_AndroidContentIntent;
  VideoController jdField_a_of_type_ComTencentAvVideoController = null;
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new VideoInviteFloatBarUICtr.3(this);
  VideoObserver jdField_a_of_type_ComTencentAvAppVideoObserver = new VideoInviteFloatBarUICtr.2(this);
  VideoWifiLock jdField_a_of_type_ComTencentAvUtilsVideoWifiLock;
  Runnable b;
  public boolean b;
  boolean c;
  int d;
  public boolean d;
  String e = "";
  String f = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;";
  
  public VideoInviteFloatBarUICtr(VideoController paramVideoController, VideoAppInterface paramVideoAppInterface, Intent paramIntent)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Int = -1;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangRunnable = new VideoInviteFloatBarUICtr.4(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  private boolean a(int paramInt)
  {
    if ((this.jdField_c_of_type_Int == 1) && (!TextUtils.isEmpty(this.e)))
    {
      Object localObject = new Intent("tencent.video.v2q.ACTION_DEAL_INVITE_TO_ENTER_GROUP_VEDIO");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("");
      ((Intent)localObject).putExtra("relationId", localStringBuilder.toString());
      ((Intent)localObject).putExtra("dealResult", paramInt);
      ((Intent)localObject).putExtra("inviteId", this.e);
      ((Intent)localObject).putExtra("friendUin", this.jdField_b_of_type_Long);
      ((Intent)localObject).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast((Intent)localObject);
      if (QLog.isDevelopLevel()) {
        QLog.d("VideoInviteFloatBarUICtr", 2, "sendBroadcast, qav_gaudio_join");
      }
      if (paramInt == 1) {
        localObject = "tip_in";
      } else {
        localObject = "tip_no";
      }
      long l = this.jdField_a_of_type_ComTencentAvVideoController.a().f;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_d_of_type_Int);
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
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    this.jdField_b_of_type_Int = paramIntent.getIntExtra("uinType", 0);
    this.jdField_c_of_type_Int = paramIntent.getIntExtra("relationType", 0);
    if (AVUtil.b(this.jdField_b_of_type_Int))
    {
      this.jdField_b_of_type_Long = paramIntent.getLongExtra("friendUin", 0L);
      this.e = paramIntent.getStringExtra("inviteId");
      this.jdField_a_of_type_Long = paramIntent.getLongExtra("discussId", 0L);
      this.jdField_d_of_type_Int = paramIntent.getIntExtra("memberType", -1);
      this.jdField_a_of_type_ArrayOfLong = paramIntent.getLongArrayExtra("memberList");
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
      paramIntent = SessionMgr.a(this.jdField_c_of_type_Int, String.valueOf(this.jdField_a_of_type_Long), new int[0]);
      if (SessionMgr.a().a(paramIntent))
      {
        this.jdField_a_of_type_ComTencentAvAppSessionInfo = SessionMgr.a().c(paramIntent);
        return 2;
      }
      this.jdField_a_of_type_ComTencentAvAppSessionInfo = SessionMgr.a().a();
      return 2;
    }
    this.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("peerUin");
    this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("extraUin");
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("isAudioMode", false);
    this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("shutCamera", false);
    this.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("isDoubleVideoMeeting", false);
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onStartCommand  mIsAudioMode = ");
      paramIntent.append(this.jdField_a_of_type_Boolean);
      paramIntent.append(", isDoubleVideoMeeting = ");
      paramIntent.append(this.jdField_c_of_type_Boolean);
      QLog.d("VideoInviteFloatBarUICtr", 2, paramIntent.toString());
    }
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
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
      paramIntent.append(this.jdField_c_of_type_JavaLangString);
      QLog.d("VideoInviteFloatBarUICtr", 2, paramIntent.toString());
    }
    if (this.jdField_c_of_type_Boolean)
    {
      paramIntent = SessionMgr.a(100, this.jdField_c_of_type_JavaLangString, new int[0]);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("sessionId : ");
        localStringBuilder.append(paramIntent);
        QLog.d("VideoInviteFloatBarUICtr", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentAvAppSessionInfo = SessionMgr.a().c(paramIntent);
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.a(paramLong, "onStartCommand.1", 4);
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.f("onStartCommand", true);
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.af = true;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.e = true;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.C = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
      return 2;
    }
    paramIntent = SessionMgr.a(3, this.jdField_c_of_type_JavaLangString, new int[0]);
    this.jdField_a_of_type_ComTencentAvAppSessionInfo = SessionMgr.a().c(paramIntent);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.a(paramLong, "onStartCommand.2", 1);
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.b(paramLong, false);
    }
    else
    {
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.a(paramLong, "onStartCommand.3", 2);
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.b(paramLong, this.jdField_b_of_type_Boolean ^ true);
    }
    this.jdField_a_of_type_ComTencentAvAppSessionInfo.e = true;
    this.jdField_a_of_type_ComTencentAvAppSessionInfo.C = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_c_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onDestroy error : ");
        localStringBuilder.append(localException);
        QLog.d("VideoInviteFloatBarUICtr", 1, localStringBuilder.toString());
      }
      if (this.jdField_b_of_type_JavaLangRunnable != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
        this.jdField_b_of_type_JavaLangRunnable = null;
      }
    }
  }
  
  public void a(long paramLong)
  {
    boolean bool = a();
    int i = 1;
    if (!bool)
    {
      QLog.d("VideoInviteFloatBarUICtr", 1, "acceptVideoRequest return 1");
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      QLog.d("VideoInviteFloatBarUICtr", 1, "acceptVideoRequest return 2");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("acceptVideoRequest, seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], mIsDoubleVideoMeeting[");
    localStringBuilder.append(this.jdField_c_of_type_Boolean);
    localStringBuilder.append("]");
    QLog.w("VideoInviteFloatBarUICtr", 1, localStringBuilder.toString());
    bool = this.jdField_a_of_type_ComTencentAvAppSessionInfo.H;
    if (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.C) {
      i = 4;
    }
    if (1008 == this.jdField_a_of_type_ComTencentAvAppSessionInfo.k) {
      i = 4;
    }
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 3, Long.valueOf(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString).longValue(), null, false);
    } else {
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString, bool ^ true, i);
    }
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar.c(HardCodeUtil.a(2131716035));
    }
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.H)
    {
      ReportController.b(null, "CliOper", "", "", "0X8008B24", "0X8008B24", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X8008B27", "0X8008B27", 0, 0, "", "", "", "");
  }
  
  void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.jdField_a_of_type_ComTencentAvVideoController.d();
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock == null) {
      this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock = new VideoWifiLock(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationContext(), 1, "video wifi lock");
    }
    if (PhoneStatusTools.f(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationContext()))
    {
      VideoWifiLock localVideoWifiLock = this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock;
      if (localVideoWifiLock != null) {
        localVideoWifiLock.a();
      }
    }
    return true;
  }
  
  public void b(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("refuseVideoRequest, seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w("VideoInviteFloatBarUICtr", 1, localStringBuilder.toString());
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.H) {
      ReportController.b(null, "CliOper", "", "", "0X8008B25", "0X8008B25", 0, 0, "", "", "", "");
    } else {
      ReportController.b(null, "CliOper", "", "", "0X8008B28", "0X8008B28", 0, 0, "", "", "", "");
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_c_of_type_JavaLangString, 1, true);
      long l = CharacterUtil.a(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 3, l);
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, l, 1);
      a();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_c_of_type_JavaLangString, 1, false);
    this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_JavaLangString, 252);
    this.jdField_a_of_type_ComTencentAvVideoController.b(252);
    this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_c_of_type_JavaLangString, 1);
  }
  
  protected boolean b()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      QLog.d("VideoInviteFloatBarUICtr", 1, "VideoInviteFloatBarUICtr_quaReport mVideoController = null, return !");
      return false;
    }
    if (this.jdField_c_of_type_JavaLangString == null)
    {
      QLog.d("VideoInviteFloatBarUICtr", 1, "VideoInviteFloatBarUICtr_quaReport mPeerUin = null, return !");
      return false;
    }
    return this.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_c_of_type_JavaLangString);
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
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_c_of_type_Int, this.jdField_a_of_type_Long);
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
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  public void d(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("acceptGAudioChat, seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w("VideoInviteFloatBarUICtr", 1, localStringBuilder.toString());
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar.c(HardCodeUtil.a(2131716036));
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentAvAppSessionInfo.f, this.jdField_a_of_type_ArrayOfLong, false);
    ReportController.b(null, "CliOper", "", "", "0X8008B2B", "0X8008B2B", 0, 0, "", "", "", "");
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteFloatBarUICtr
 * JD-Core Version:    0.7.0.1
 */