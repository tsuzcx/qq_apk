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
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import jvr;
import jvt;
import jvu;
import jvw;
import jvx;
import mqq.app.MobileQQ;

public class MultiIncomingCallUICtr
  extends BaseInviteFloatBarUICtr
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new jvr(this);
  Intent jdField_a_of_type_AndroidContentIntent;
  SessionMgr jdField_a_of_type_ComTencentAvSessionMgr = SessionMgr.a();
  public VideoController a;
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new jvu(this);
  VideoObserver jdField_a_of_type_ComTencentAvAppVideoObserver = new jvw(this);
  QAVNotification jdField_a_of_type_ComTencentAvUtilsQAVNotification;
  Runnable b;
  public boolean b;
  public Runnable c;
  boolean c;
  int jdField_d_of_type_Int = 0;
  boolean jdField_d_of_type_Boolean = false;
  int e;
  public String e;
  public String f = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
  
  public MultiIncomingCallUICtr(VideoController paramVideoController, VideoAppInterface paramVideoAppInterface, Intent paramIntent)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_e_of_type_Int = -1;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_c_of_type_JavaLangRunnable = new jvx(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  public int a(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiIncomingCallUICtr", 2, "onStartCommand");
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    a();
    a(paramIntent);
    return 2;
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
      if (this.jdField_c_of_type_JavaLangRunnable != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
        this.jdField_c_of_type_JavaLangRunnable = null;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiIncomingCallUICtr", 2, "onDestroy error : " + localException);
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    Long localLong;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MultiIncomingCallUICtr", 2, "closeSession reason = " + paramInt);
      }
      localLong = Long.valueOf(CharacterUtil.a(this.jdField_c_of_type_JavaLangString));
      if (!this.jdField_b_of_type_Boolean) {
        break;
      }
      if (paramInt == 1)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a(localLong.longValue(), 7);
        return;
      }
    } while (paramInt != 2);
    this.jdField_a_of_type_ComTencentAvVideoController.a(localLong.longValue(), 2);
    return;
    this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString, 0);
    this.jdField_a_of_type_ComTencentAvVideoController.b(243);
  }
  
  void a(int paramInt1, long paramLong, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    if (!paramBoolean2) {
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramInt1, paramLong, 10, false);
    }
    for (;;)
    {
      if ((paramBoolean1) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(paramLong), Integer.valueOf(3) });
      }
      ReportController.b(null, "CliOper", "", "", "0X8008B2C", "0X8008B2C", 0, 0, "", "", "", "");
      a();
      return;
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramInt1, paramLong, paramInt2, false);
    }
  }
  
  void a(Intent paramIntent)
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
    if (a(this.jdField_b_of_type_Int)) {
      if (paramIntent.getIntExtra("MultiAVType", -1) == 2)
      {
        this.jdField_a_of_type_Boolean = false;
        label130:
        this.jdField_b_of_type_Long = paramIntent.getLongExtra("friendUin", 0L);
        this.jdField_e_of_type_JavaLangString = paramIntent.getStringExtra("inviteId");
        this.jdField_a_of_type_Long = paramIntent.getLongExtra("discussId", 0L);
        String str = SessionMgr.a(this.jdField_c_of_type_Int, String.valueOf(this.jdField_a_of_type_Long), new int[0]);
        this.jdField_a_of_type_ComTencentAvAppSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.a(str);
        this.jdField_a_of_type_ArrayOfLong = paramIntent.getLongArrayExtra("memberList");
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
      }
    }
    for (;;)
    {
      c();
      if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo != null) || (this.jdField_b_of_type_Int == 1)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiIncomingCallUICtr", 2, "session info null!");
      }
      a();
      return;
      this.jdField_a_of_type_Boolean = true;
      break label130;
      if (!this.jdField_b_of_type_Boolean) {
        break label396;
      }
      paramIntent = SessionMgr.a(100, this.jdField_c_of_type_JavaLangString, new int[0]);
      if (QLog.isColorLevel()) {
        QLog.d("MultiIncomingCallUICtr", 2, "sessionId : " + paramIntent);
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo = SessionMgr.a().a(paramIntent);
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_d_of_type_Int = 4;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.G = true;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.ar = true;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.J = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    }
    label396:
    paramIntent = SessionMgr.a(3, this.jdField_c_of_type_JavaLangString, new int[0]);
    this.jdField_a_of_type_ComTencentAvAppSessionInfo = SessionMgr.a().a(paramIntent);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_d_of_type_Int = 1;
    }
    for (this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_f_of_type_Boolean = false;; this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_f_of_type_Boolean = true)
    {
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.J = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
      break;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_d_of_type_Int = 2;
    }
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiIncomingCallUICtr", 2, "acceptRequest");
    }
    this.jdField_d_of_type_Boolean = true;
    SessionInfo localSessionInfo = SessionMgr.a().a();
    if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_f_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.h(true);
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo == null) {
        break label548;
      }
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.d()) {
        break label280;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiIncomingCallUICtr", 2, "Session already destroyed, id:" + this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString + ", status = " + this.jdField_a_of_type_ComTencentAvAppSessionInfo.g);
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar.c("正在连接...");
      }
    }
    label280:
    label344:
    while (!QLog.isColorLevel())
    {
      for (;;)
      {
        return;
        if ((paramSessionInfo != null) && (localSessionInfo == paramSessionInfo))
        {
          if (SessionMgr.a().a() >= 2)
          {
            if (paramSessionInfo.d()) {
              a(false, paramSessionInfo);
            }
            for (;;)
            {
              b(paramSessionInfo);
              break;
              this.jdField_a_of_type_ComTencentAvVideoController.a(true, 7, new int[] { localSessionInfo.D });
              this.jdField_a_of_type_ComTencentAvVideoController.b(201);
            }
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MultiIncomingCallUICtr", 2, "no need to close main session because there is only one session");
          break;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        StringBuilder localStringBuilder = new StringBuilder().append("mainSession invalid when accept 3rd request, currMainSession == mainSessionInfo:");
        if (localSessionInfo == paramSessionInfo) {}
        for (boolean bool = true;; bool = false)
        {
          QLog.d("MultiIncomingCallUICtr", 2, bool);
          break;
        }
        if (!a(this.jdField_b_of_type_Int)) {
          break label344;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_f_of_type_Long, this.jdField_a_of_type_ArrayOfLong, false);
        ReportController.b(null, "CliOper", "", "", "0X8008B2B", "0X8008B2B", 0, 0, "", "", "", "");
      }
      int i = 1;
      if (this.jdField_a_of_type_Boolean) {
        i = 0;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiIncomingCallUICtr", 2, "appType :" + i);
      }
      if (this.jdField_b_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiIncomingCallUICtr", 2, "acceptVideoRequest isDoubleVideoMeeting");
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(3, Long.valueOf(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString).longValue(), null, false);
        ReportController.b(null, "CliOper", "", "", "0X8008B2B", "0X8008B2B", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        b();
        break;
        this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_c_of_type_JavaLangString, i, this.jdField_c_of_type_Int);
        if (this.jdField_a_of_type_Boolean) {
          ReportController.b(null, "CliOper", "", "", "0X8008B24", "0X8008B24", 0, 0, "", "", "", "");
        } else {
          ReportController.b(null, "CliOper", "", "", "0X8008B27", "0X8008B27", 0, 0, "", "", "", "");
        }
      }
    }
    label548:
    QLog.d("MultiIncomingCallUICtr", 2, "session invalid when accept request");
  }
  
  public void a(boolean paramBoolean, SessionInfo paramSessionInfo)
  {
    a(paramBoolean, paramSessionInfo, -1);
  }
  
  void a(boolean paramBoolean, SessionInfo paramSessionInfo, int paramInt)
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
        bool1 = paramSessionInfo.G;
        i = paramSessionInfo.F;
        l = paramSessionInfo.jdField_f_of_type_Long;
      }
    }
    for (;;)
    {
      int j = UITools.b(i);
      if ((!paramBoolean) && ((bool1) || (b(j)))) {}
      for (boolean bool2 = true; a(j); bool2 = false)
      {
        a(i, l, bool2, paramInt, paramBoolean);
        return;
      }
      a(bool1, (String)localObject, bool2, paramBoolean);
      return;
    }
  }
  
  void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiIncomingCallUICtr", 2, new Object[] { "refuseDoubleCall ", Boolean.valueOf(paramBoolean1), paramString, Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3) });
    }
    long l2;
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.Q)
    {
      ReportController.b(null, "CliOper", "", "", "0X8008B25", "0X8008B25", 0, 0, "", "", "", "");
      if (!paramBoolean1) {
        break label277;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramString, 1, true);
      l2 = -1L;
    }
    for (;;)
    {
      try
      {
        l1 = CharacterUtil.a(paramString);
        if (!paramBoolean3)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a(3, l1, 10, false);
          this.jdField_a_of_type_ComTencentAvVideoController.a(l1, 23);
          a();
          if ((!paramBoolean2) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)) {
            break;
          }
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(28), paramString, Boolean.valueOf(true) });
          return;
          ReportController.b(null, "CliOper", "", "", "0X8008B28", "0X8008B28", 0, 0, "", "", "", "");
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        long l1 = l2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MultiIncomingCallUICtr", 2, "", localNumberFormatException);
        l1 = l2;
        continue;
        this.jdField_a_of_type_ComTencentAvVideoController.b(3, l1);
        this.jdField_a_of_type_ComTencentAvVideoController.a(l1, 1);
        a();
        continue;
      }
      label277:
      VideoController localVideoController = this.jdField_a_of_type_ComTencentAvVideoController;
      localVideoController.a(paramString, 1, false, new jvt(this, localVideoController, paramString, paramBoolean3));
    }
  }
  
  boolean a()
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("MultiIncomingCallUICtr", 2, "initEnvParam");
    }
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().g()) || (this.jdField_a_of_type_ComTencentAvVideoController.a().h()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MultiIncomingCallUICtr", 2, "initEnvParam closeSession");
          }
          this.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString, 2);
        }
        bool1 = true;
      }
    }
    return bool1;
  }
  
  void b(SessionInfo paramSessionInfo)
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
  
  boolean b(int paramInt)
  {
    return paramInt == 3000;
  }
  
  public boolean c(int paramInt)
  {
    if ((this.jdField_b_of_type_Int == 1) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)))
    {
      Intent localIntent = new Intent("tencent.video.v2q.ACTION_DEAL_INVITE_TO_ENTER_GROUP_VEDIO");
      localIntent.putExtra("relationId", this.jdField_a_of_type_Long + "");
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
  
  void d()
  {
    if (!c(0)) {
      a(true, null);
    }
  }
  
  public void e()
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
  
  public void f()
  {
    Intent localIntent = new Intent("tencent.video.v2q.ACTION_ENTER_GROUP_VEDIO");
    localIntent.putExtra("relationId", this.jdField_a_of_type_Long + "");
    localIntent.putExtra("enterType", 1);
    localIntent.setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
    if (QLog.isDevelopLevel()) {
      QLog.d("MultiIncomingCallUICtr.troopgroup_vedio.invite", 2, "sendBroadcast, qav_gaudio_answer");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(514), Long.valueOf(this.jdField_a_of_type_Long) });
    c(1);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification == null) {
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    Object localObject;
    if (!a(this.jdField_b_of_type_Int))
    {
      localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_b_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, true, true);
      if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, (Bitmap)localObject, null, 56, this.jdField_b_of_type_Int, 2);
      }
    }
    Bitmap localBitmap;
    String str;
    do
    {
      return;
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, (Bitmap)localObject, null, 55, this.jdField_b_of_type_Int, 1);
      return;
      localObject = String.valueOf(this.jdField_a_of_type_Long);
      localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3000, (String)localObject, null, true, true);
      str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(1004, Long.toString(this.jdField_b_of_type_Long), (String)localObject);
    } while (this.jdField_a_of_type_ComTencentAvAppSessionInfo == null);
    this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString, str, localBitmap, (String)localObject, 57, 3000, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallUICtr
 * JD-Core Version:    0.7.0.1
 */