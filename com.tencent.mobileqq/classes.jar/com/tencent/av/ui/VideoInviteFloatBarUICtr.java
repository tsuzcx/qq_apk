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
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.av.utils.VideoWifiLock;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kdo;
import kdp;
import kdq;
import kds;
import mqq.app.MobileQQ;

public class VideoInviteFloatBarUICtr
  extends BaseInviteFloatBarUICtr
{
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new kdo(this);
  Intent jdField_a_of_type_AndroidContentIntent;
  public VideoController a;
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new kdq(this);
  VideoObserver jdField_a_of_type_ComTencentAvAppVideoObserver = new kdp(this);
  VideoWifiLock jdField_a_of_type_ComTencentAvUtilsVideoWifiLock;
  public Runnable b;
  public boolean b;
  boolean c;
  int d;
  public String e = "";
  public String f = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
  
  public VideoInviteFloatBarUICtr(VideoController paramVideoController, VideoAppInterface paramVideoAppInterface, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Int = -1;
    this.jdField_b_of_type_JavaLangRunnable = new kds(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  private boolean b(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_c_of_type_Int == 1)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(this.e))
      {
        localObject = new Intent("tencent.video.v2q.ACTION_DEAL_INVITE_TO_ENTER_GROUP_VEDIO");
        ((Intent)localObject).putExtra("relationId", this.jdField_a_of_type_Long + "");
        ((Intent)localObject).putExtra("dealResult", paramInt);
        ((Intent)localObject).putExtra("inviteId", this.e);
        ((Intent)localObject).putExtra("friendUin", this.jdField_b_of_type_Long);
        ((Intent)localObject).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast((Intent)localObject);
        if (QLog.isDevelopLevel()) {
          QLog.d("VideoInviteFloatBarUICtr", 2, "sendBroadcast, qav_gaudio_join");
        }
        if (paramInt != 1) {
          break label205;
        }
      }
    }
    label205:
    for (Object localObject = "tip_in";; localObject = "tip_no")
    {
      ReportController.b(null, "dc00899", "Grp_video", "", "invite", (String)localObject, 0, 0, this.jdField_a_of_type_ComTencentAvVideoController.a().q, this.jdField_d_of_type_Int + "", "", "");
      bool1 = true;
      return bool1;
    }
  }
  
  public int a(Intent paramIntent)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteFloatBarUICtr", 2, "onStartCommand");
    }
    AudioHelper.a("VideoInviteFloatBarUICtr.onStartCommand", paramIntent.getExtras());
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    this.jdField_b_of_type_Int = paramIntent.getIntExtra("uinType", 0);
    this.jdField_c_of_type_Int = paramIntent.getIntExtra("relationType", 0);
    if (a(this.jdField_b_of_type_Int))
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
        this.jdField_a_of_type_ComTencentAvAppSessionInfo = SessionMgr.a().a(paramIntent);
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
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteFloatBarUICtr", 2, "onStartCommand  mIsAudioMode = " + this.jdField_a_of_type_Boolean + ", isDoubleVideoMeeting = " + this.jdField_c_of_type_Boolean);
    }
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("VideoInviteFloatBarUICtr", 2, "mPeerUin is empty!");
      }
      a();
    }
    while (this.jdField_c_of_type_Boolean)
    {
      paramIntent = SessionMgr.a(100, this.jdField_c_of_type_JavaLangString, new int[0]);
      if (QLog.isColorLevel()) {
        QLog.d("VideoInviteFloatBarUICtr", 2, "sessionId : " + paramIntent);
      }
      this.jdField_a_of_type_ComTencentAvAppSessionInfo = SessionMgr.a().a(paramIntent);
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_d_of_type_Int = 4;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.G = true;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.ar = true;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.J = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
      return 2;
      if (QLog.isColorLevel()) {
        QLog.d("VideoInviteFloatBarUICtr", 2, "mPeerUin : " + this.jdField_c_of_type_JavaLangString);
      }
    }
    paramIntent = SessionMgr.a(3, this.jdField_c_of_type_JavaLangString, new int[0]);
    this.jdField_a_of_type_ComTencentAvAppSessionInfo = SessionMgr.a().a(paramIntent);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_d_of_type_Int = 1;
    }
    for (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_f_of_type_Boolean = false;; paramIntent.jdField_f_of_type_Boolean = bool)
    {
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.J = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
      return 2;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_d_of_type_Int = 2;
      paramIntent = this.jdField_a_of_type_ComTencentAvAppSessionInfo;
      if (!this.jdField_b_of_type_Boolean) {
        bool = true;
      }
    }
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
      if (this.jdField_b_of_type_JavaLangRunnable != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
        this.jdField_b_of_type_JavaLangRunnable = null;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("VideoInviteFloatBarUICtr", 1, "onDestroy error : " + localException);
      }
    }
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock == null) {
      this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock = new VideoWifiLock(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationContext(), 1, "video wifi lock");
    }
    if ((PhoneStatusTools.e(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationContext())) && (this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock != null)) {
      this.jdField_a_of_type_ComTencentAvUtilsVideoWifiLock.a();
    }
    return true;
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_ComTencentAvVideoController.g();
  }
  
  void d()
  {
    h();
  }
  
  public void e()
  {
    QLog.d("VideoInviteFloatBarUICtr", 1, "onCreate start");
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.NEW_OUTGOING_CALL");
    localIntentFilter.addAction("tencent.video.invite.accept");
    localIntentFilter.addAction("tencent.video.invite.refuse");
    localIntentFilter.addAction("tencent.video.invite.gaaccept");
    localIntentFilter.addAction("tencent.video.invite.gaignore");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  public void f()
  {
    if (!a())
    {
      QLog.d("VideoInviteFloatBarUICtr", 1, "acceptVideoRequest return 1");
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      QLog.d("VideoInviteFloatBarUICtr", 1, "acceptVideoRequest return 2");
      return;
    }
    QLog.d("VideoInviteFloatBarUICtr", 1, "acceptVideoRequest");
    if ((SessionMgr.a().a() != null) && (SessionMgr.a().a().p)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(40), SessionMgr.a().a().jdField_c_of_type_JavaLangString, Boolean.valueOf(true) });
    }
    int j = 1;
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.Q) {
      j = 0;
    }
    int i = 1;
    if (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.J) {
      i = 4;
    }
    if (1008 == this.jdField_a_of_type_ComTencentAvAppSessionInfo.i) {
      i = 4;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      QLog.d("VideoInviteFloatBarUICtr", 1, "acceptVideoRequest isDoubleVideoMeeting");
      this.jdField_a_of_type_ComTencentAvVideoController.a(3, Long.valueOf(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString).longValue(), null, false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar.c("正在连接...");
      }
      if (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.Q) {
        break;
      }
      ReportController.b(null, "CliOper", "", "", "0X8008B24", "0X8008B24", 0, 0, "", "", "", "");
      return;
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString, j, i);
    }
    ReportController.b(null, "CliOper", "", "", "0X8008B27", "0X8008B27", 0, 0, "", "", "", "");
  }
  
  public void g()
  {
    QLog.d("VideoInviteFloatBarUICtr", 1, "refuseVideoRequest");
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.Q) {
      ReportController.b(null, "CliOper", "", "", "0X8008B25", "0X8008B25", 0, 0, "", "", "", "");
    }
    while (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_JavaLangString, 1, true);
      long l = CharacterUtil.a(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvVideoController.b(3, l);
      this.jdField_a_of_type_ComTencentAvVideoController.a(l, 1);
      a();
      return;
      ReportController.b(null, "CliOper", "", "", "0X8008B28", "0X8008B28", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_JavaLangString, 1, false);
    this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_JavaLangString, 0);
    this.jdField_a_of_type_ComTencentAvVideoController.b(252);
    this.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_c_of_type_JavaLangString, 1);
  }
  
  public void h()
  {
    QLog.d("VideoInviteFloatBarUICtr", 1, "ignoreGAInvite");
    ReportController.b(null, "CliOper", "", "", "0X8008B2C", "0X8008B2C", 0, 0, "", "", "", "");
    if (!b(0)) {
      this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_c_of_type_Int, this.jdField_a_of_type_Long);
    }
    a();
  }
  
  public void i()
  {
    QLog.d("VideoInviteFloatBarUICtr", 1, "acceptGAudioChat");
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar.c("正在连接...");
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_f_of_type_Long, this.jdField_a_of_type_ArrayOfLong, false);
    ReportController.b(null, "CliOper", "", "", "0X8008B2B", "0X8008B2B", 0, 0, "", "", "", "");
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteFloatBarUICtr
 * JD-Core Version:    0.7.0.1
 */