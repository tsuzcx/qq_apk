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
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class MultiIncomingCallUICtr
  extends BaseInviteFloatBarUICtr
{
  public static boolean e;
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
  String f = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
  
  static
  {
    jdField_e_of_type_Boolean = false;
  }
  
  public MultiIncomingCallUICtr(VideoController paramVideoController, VideoAppInterface paramVideoAppInterface, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  public int a(Intent paramIntent)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w("MultiIncomingCallUICtr", 1, "onStartCommand, seq[" + l + "]");
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    a();
    a(l, paramIntent);
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
  
  void a(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    Long localLong;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.w("MultiIncomingCallUICtr", 1, "closeSession, reason[" + paramInt + "], seq[" + paramLong + "]");
      }
      localLong = Long.valueOf(CharacterUtil.a(this.jdField_c_of_type_JavaLangString));
      if (!this.jdField_b_of_type_Boolean) {
        break;
      }
      if (paramInt == 1)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, localLong.longValue(), 7);
        return;
      }
    } while (paramInt != 2);
    this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, localLong.longValue(), 2);
    return;
    this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_d_of_type_JavaLangString, 243);
    this.jdField_a_of_type_ComTencentAvVideoController.b(243);
  }
  
  void a(long paramLong1, int paramInt1, long paramLong2, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    if (!paramBoolean2) {
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong1, paramInt1, paramLong2, 10, false);
    }
    for (;;)
    {
      if ((paramBoolean1) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(paramLong2), Integer.valueOf(3) });
      }
      ReportController.b(null, "CliOper", "", "", "0X8008B2C", "0X8008B2C", 0, 0, "", "", "", "");
      a();
      return;
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong1, paramInt1, paramLong2, paramInt2, false);
    }
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
    if (AVUtil.b(this.jdField_b_of_type_Int)) {
      if (paramIntent.getIntExtra("MultiAVType", -1) == 2)
      {
        this.jdField_a_of_type_Boolean = false;
        label134:
        this.jdField_b_of_type_Long = paramIntent.getLongExtra("friendUin", 0L);
        this.jdField_e_of_type_JavaLangString = paramIntent.getStringExtra("inviteId");
        this.jdField_a_of_type_Long = paramIntent.getLongExtra("discussId", 0L);
        String str = SessionMgr.a(this.jdField_c_of_type_Int, String.valueOf(this.jdField_a_of_type_Long), new int[0]);
        this.jdField_a_of_type_ComTencentAvAppSessionInfo = this.jdField_a_of_type_ComTencentAvSessionMgr.c(str);
        this.jdField_a_of_type_ArrayOfLong = paramIntent.getLongArrayExtra("memberList");
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
      }
    }
    for (;;)
    {
      a(true);
      if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo != null) || (this.jdField_b_of_type_Int == 1)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiIncomingCallUICtr", 2, "session info null!");
      }
      a();
      return;
      this.jdField_a_of_type_Boolean = true;
      break label134;
      if (!this.jdField_b_of_type_Boolean) {
        break label410;
      }
      paramIntent = SessionMgr.a(100, this.jdField_c_of_type_JavaLangString, new int[0]);
      if (QLog.isColorLevel()) {
        QLog.d("MultiIncomingCallUICtr", 2, "sessionId : " + paramIntent);
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo = SessionMgr.a().c(paramIntent);
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.a(paramLong, "processIntent.1", 4);
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.e("processIntent", true);
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.ar = true;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.N = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    }
    label410:
    paramIntent = SessionMgr.a(3, this.jdField_c_of_type_JavaLangString, new int[0]);
    this.jdField_a_of_type_ComTencentAvAppSessionInfo = SessionMgr.a().c(paramIntent);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.a(paramLong, "processIntent.2", 1);
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.a(paramLong, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.N = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
      break;
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.a(paramLong, "processIntent.3", 2);
      this.jdField_a_of_type_ComTencentAvAppSessionInfo.a(paramLong, true);
    }
  }
  
  void a(long paramLong, SessionInfo paramSessionInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.w("MultiIncomingCallUICtr", 1, "acceptRequest, seq[" + paramLong + "]");
    }
    this.jdField_d_of_type_Boolean = true;
    SessionInfo localSessionInfo = SessionMgr.a().a();
    if (this.jdField_a_of_type_ComTencentAvVideoController.f)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.e(true);
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo == null) {
        break label591;
      }
      if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.j()) {
        break label310;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiIncomingCallUICtr", 2, "Session already destroyed, id:" + this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString + ", status = " + this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_g_of_type_Int);
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar.c(HardCodeUtil.a(2131707020));
      }
    }
    label310:
    label374:
    while (!QLog.isColorLevel())
    {
      for (;;)
      {
        return;
        if ((paramSessionInfo != null) && (localSessionInfo == paramSessionInfo))
        {
          if (SessionMgr.a().a() >= 2)
          {
            if (paramSessionInfo.j()) {
              a(paramLong, false, paramSessionInfo);
            }
            for (;;)
            {
              a(paramSessionInfo);
              break;
              this.jdField_a_of_type_ComTencentAvVideoController.a(true, 201, new int[] { localSessionInfo.D });
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
        if (!AVUtil.b(this.jdField_b_of_type_Int)) {
          break label374;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_g_of_type_Long, this.jdField_a_of_type_ArrayOfLong, false);
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
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 3, Long.valueOf(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_d_of_type_JavaLangString).longValue(), null, false);
        ReportController.b(null, "CliOper", "", "", "0X8008B2B", "0X8008B2B", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        b();
        break;
        int j = UITools.d(this.jdField_c_of_type_Int);
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_c_of_type_JavaLangString, i, j);
        if (this.jdField_a_of_type_Boolean) {
          ReportController.b(null, "CliOper", "", "", "0X8008B24", "0X8008B24", 0, 0, "", "", "", "");
        } else {
          ReportController.b(null, "CliOper", "", "", "0X8008B27", "0X8008B27", 0, 0, "", "", "", "");
        }
      }
    }
    label591:
    QLog.d("MultiIncomingCallUICtr", 2, "session invalid when accept request");
  }
  
  void a(long paramLong, boolean paramBoolean, SessionInfo paramSessionInfo)
  {
    a(paramLong, paramBoolean, paramSessionInfo, -1);
  }
  
  void a(long paramLong, boolean paramBoolean, SessionInfo paramSessionInfo, int paramInt)
  {
    boolean bool3 = false;
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
        String str = paramSessionInfo.jdField_d_of_type_JavaLangString;
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = paramSessionInfo.s;
        }
        bool1 = paramSessionInfo.J;
        i = paramSessionInfo.F;
        l = paramSessionInfo.jdField_g_of_type_Long;
      }
    }
    for (;;)
    {
      int j = UITools.c(i);
      boolean bool2 = bool3;
      if (!paramBoolean) {
        if (!bool1)
        {
          bool2 = bool3;
          if (!a(j)) {}
        }
        else
        {
          bool2 = true;
        }
      }
      if (AVUtil.b(j))
      {
        a(paramLong, i, l, bool2, paramInt, paramBoolean);
        return;
      }
      a(paramLong, bool1, (String)localObject, bool2, paramBoolean);
      return;
    }
  }
  
  void a(long paramLong, boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("MultiIncomingCallUICtr", 1, "refuseDoubleCall, isDoubleVideoMeeting[" + paramBoolean1 + "], peerUin[" + paramString + "], notifyDestroyUI[" + paramBoolean2 + "], refuse3rd[" + paramBoolean3 + "], seq[" + paramLong + "]");
    }
    long l2;
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.S)
    {
      ReportController.b(null, "CliOper", "", "", "0X8008B25", "0X8008B25", 0, 0, "", "", "", "");
      if (!paramBoolean1) {
        break label317;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, paramString, 1, true);
      l2 = -1L;
    }
    for (;;)
    {
      try
      {
        l1 = CharacterUtil.a(paramString);
        if (!paramBoolean3)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 3, l1, 10, false);
          this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, l1, 23);
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
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 3, l1);
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, l1, 1);
        a();
        continue;
      }
      label317:
      VideoController localVideoController = this.jdField_a_of_type_ComTencentAvVideoController;
      localVideoController.a(paramLong, paramString, 1, false, new MultiIncomingCallUICtr.2(this, localVideoController, paramString, paramBoolean3));
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
      localIntent.putExtra("groupId", paramSessionInfo.jdField_g_of_type_Long);
      localIntent.putExtra("peerUin", paramSessionInfo.jdField_d_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(localIntent);
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
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().o()) || (this.jdField_a_of_type_ComTencentAvVideoController.a().p()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MultiIncomingCallUICtr", 2, "initEnvParam closeSession");
          }
          this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString, 2);
        }
        bool1 = true;
      }
    }
    return bool1;
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
    localIntent.putExtra("relationId", this.jdField_a_of_type_Long + "");
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
    Object localObject;
    if (!AVUtil.b(this.jdField_b_of_type_Int))
    {
      localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_b_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, true, true);
      if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, (Bitmap)localObject, null, 56, this.jdField_b_of_type_Int, 2);
      }
    }
    Bitmap localBitmap;
    String str;
    do
    {
      return;
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, (Bitmap)localObject, null, 55, this.jdField_b_of_type_Int, 1);
      return;
      localObject = String.valueOf(this.jdField_a_of_type_Long);
      localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_b_of_type_Int, (String)localObject, null, true, true);
      int i = AVUtil.b(this.jdField_b_of_type_Int);
      str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, Long.toString(this.jdField_b_of_type_Long), (String)localObject);
    } while (this.jdField_a_of_type_ComTencentAvAppSessionInfo == null);
    this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString, str, localBitmap, (String)localObject, 57, this.jdField_b_of_type_Int, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallUICtr
 * JD-Core Version:    0.7.0.1
 */