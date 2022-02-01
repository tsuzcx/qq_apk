package com.tencent.av.gaudio;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.VExtensionInfoManager;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;

public class GaInviteActivity
  extends BaseGaInvite
{
  AudioManager jdField_a_of_type_AndroidMediaAudioManager = null;
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new GaInviteActivity.2(this);
  SessionInfo jdField_a_of_type_ComTencentAvAppSessionInfo = null;
  QAVNotification jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
  VExtensionInfoManager jdField_a_of_type_ComTencentAvUtilsVExtensionInfoManager = null;
  boolean jdField_a_of_type_Boolean = true;
  boolean b;
  int jdField_c_of_type_Int = -1;
  long jdField_c_of_type_Long = -1L;
  String jdField_c_of_type_JavaLangString = "";
  boolean jdField_c_of_type_Boolean = false;
  final int jdField_d_of_type_Int = 0;
  boolean jdField_d_of_type_Boolean = false;
  final int jdField_e_of_type_Int = 1;
  boolean jdField_e_of_type_Boolean = false;
  final int f;
  protected boolean f;
  boolean g = false;
  
  public GaInviteActivity()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_f_of_type_Int = 2;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_b_of_type_Int, this.jdField_a_of_type_Long);
    super.finish();
  }
  
  public void a(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.jdField_b_of_type_Int, this.jdField_a_of_type_Long, paramInt, false);
    super.finish();
  }
  
  public void b()
  {
    if (this.jdField_c_of_type_Boolean) {
      ReportController.b(null, "CliOper", "", "", "Multi_call", "Lock_popup_timeout", 0, 0, "", "", "", "");
    } else {
      ReportController.b(null, "CliOper", "", "", "Multi_call", "Multi_call_timeout", 0, 0, "", "", "", "");
    }
    QAVNotification localQAVNotification = this.jdField_a_of_type_ComTencentAvUtilsQAVNotification;
    if (localQAVNotification != null) {
      localQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString);
    }
    a(-1041L, 8);
  }
  
  public void b(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stopRingAndShake seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], IsPlayingRing[");
      localStringBuilder.append(this.jdField_e_of_type_Boolean);
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = false;
      TraeHelper.a().b(paramLong);
    }
    TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
  }
  
  void b(Intent paramIntent) {}
  
  protected void c() {}
  
  public void d()
  {
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "startGActivity");
    b(AudioHelper.b());
    Intent localIntent = new Intent(this, AVActivity.class);
    localIntent.addFlags(262144);
    localIntent.addFlags(268435456);
    localIntent.putExtra("sessionType", 3);
    localIntent.putExtra("GroupId", String.valueOf(this.jdField_a_of_type_Long));
    localIntent.putExtra("Type", 1);
    localIntent.putExtra("DiscussUinList", this.jdField_a_of_type_ArrayOfLong);
    localIntent.putExtra("needStartTRAE", true);
    localIntent.putExtra("MultiAVType", this.jdField_a_of_type_ComTencentAvAppSessionInfo.j);
    localIntent.putExtra("uin", String.valueOf(this.jdField_a_of_type_Long));
    localIntent.putExtra("uinType", this.jdField_a_of_type_Int);
    localIntent.putExtra("isFromInviteDialog", true);
    b(localIntent);
    AudioHelper.a("GaInviteActivity.startGActivity", localIntent.getExtras());
    super.startActivity(localIntent);
    this.jdField_f_of_type_Boolean = true;
    super.finish();
    overridePendingTransition(2130772220, 0);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  void e()
  {
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "quitGAudioDialog");
    GaInviteActivity.DialogInterfaceOnClickListener localDialogInterfaceOnClickListener1 = new GaInviteActivity.DialogInterfaceOnClickListener(this, 0);
    GaInviteActivity.DialogInterfaceOnClickListener localDialogInterfaceOnClickListener2 = new GaInviteActivity.DialogInterfaceOnClickListener(this, 1);
    DialogUtil.a(this, 230, null, getString(2131695517), 2131720199, 2131695433, localDialogInterfaceOnClickListener1, localDialogInterfaceOnClickListener2).show();
  }
  
  void f()
  {
    finish();
  }
  
  public void g()
  {
    long l1 = AudioHelper.b();
    boolean bool = AVUtil.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startRingAndShake avCallBtnState[");
      localStringBuilder.append(bool);
      localStringBuilder.append("], Silent[");
      localStringBuilder.append(this.jdField_d_of_type_Boolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    if (!bool) {
      return;
    }
    if (!this.jdField_d_of_type_Boolean)
    {
      TraeHelper.a().a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;");
      if (!this.jdField_a_of_type_ComTencentAvVideoController.jdField_d_of_type_Boolean)
      {
        this.jdField_e_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentAvUtilsVExtensionInfoManager = new VExtensionInfoManager(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        localObject = this.jdField_a_of_type_ComTencentAvUtilsVExtensionInfoManager.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
        if (localObject != null) {
          this.jdField_c_of_type_Long = VipFunCallUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, ((ExtensionInfo)localObject).uin, 3, true, null);
        } else {
          this.jdField_c_of_type_Long = 0L;
        }
        long l2 = this.jdField_c_of_type_Long;
        if (l2 == 0L)
        {
          TraeHelper.a().a(l1, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230746, -1, null);
        }
        else
        {
          localObject = ColorRingManager.a(l2, 3);
          if (new File((String)localObject).exists())
          {
            TraeHelper.a().a(l1, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 0, (String)localObject, -1, null);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(this.jdField_c_of_type_Long);
            ((StringBuilder)localObject).append("");
            ReportController.b(null, "CliOper", "", "", "0X8005004", "0X8005004", 0, 0, "", ((StringBuilder)localObject).toString(), "", "");
          }
          else
          {
            TraeHelper.a().a(l1, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230746, -1, null);
            localObject = new Intent();
            ((Intent)localObject).setAction("tencent.video.v2q.commingRingDownload");
            ((Intent)localObject).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
            ((Intent)localObject).putExtra("comming_ring_down_key", this.jdField_c_of_type_Long);
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast((Intent)localObject);
          }
        }
      }
    }
    TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false, l1);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.getWindow().addFlags(2097152);
    paramBundle = getIntent();
    a(paramBundle);
    this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("inviteId");
    this.jdField_c_of_type_Int = paramBundle.getIntExtra("memberType", -1);
    boolean bool = paramBundle.getBooleanExtra("hasGVideoJoined", false);
    int i = paramBundle.getIntExtra("MultiAVType", -1);
    Object localObject1 = a(paramBundle);
    long l1 = AudioHelper.b();
    Object localObject2 = this.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreate[");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("], mInviterUin[");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append("], mInviteId[");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("], mGroupId[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("], mMemberType[");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append("], mRelationType[");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("], mHasGVideoJoined[");
    localStringBuilder.append(bool);
    localStringBuilder.append("], multiAVType[");
    localStringBuilder.append(i);
    localStringBuilder.append("], mMemberList[");
    if (this.jdField_a_of_type_ArrayOfLong != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("], mApp[");
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("], mVideoController[");
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w((String)localObject2, 1, localStringBuilder.toString());
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_b_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onCreate-from: ");
      ((StringBuilder)localObject2).append(paramBundle.getStringExtra("Fromwhere"));
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
    {
      super.finish();
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      super.finish();
      return;
    }
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)super.getSystemService("audio"));
    if ((this.jdField_a_of_type_AndroidMediaAudioManager.getRingerMode() == 0) || (this.jdField_a_of_type_AndroidMediaAudioManager.getRingerMode() == 1)) {
      this.jdField_d_of_type_Boolean = true;
    }
    paramBundle = SessionMgr.a(this.jdField_b_of_type_Int, String.valueOf(this.jdField_a_of_type_Long), new int[0]);
    if (SessionMgr.a().a(paramBundle)) {
      this.jdField_a_of_type_ComTencentAvAppSessionInfo = SessionMgr.a().c(paramBundle);
    } else {
      this.jdField_a_of_type_ComTencentAvAppSessionInfo = SessionMgr.a().a();
    }
    if ((this.jdField_a_of_type_ArrayOfLong == null) && (this.jdField_b_of_type_Int == 2))
    {
      super.finish();
      return;
    }
    if ((this.jdField_b_of_type_Long != 0L) && (this.jdField_a_of_type_Long != 0L))
    {
      long l2 = this.jdField_a_of_type_ComTencentAvVideoController.b();
      if (this.jdField_a_of_type_Long != l2)
      {
        paramBundle = this.jdField_b_of_type_JavaLangString;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onCreate, id不一致, currentInviteId[");
        ((StringBuilder)localObject1).append(l2);
        ((StringBuilder)localObject1).append("], mGroupId[");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_Long);
        ((StringBuilder)localObject1).append("], seq[");
        ((StringBuilder)localObject1).append(l1);
        ((StringBuilder)localObject1).append("]");
        QLog.w(paramBundle, 1, ((StringBuilder)localObject1).toString());
        a(l1);
        return;
      }
      c();
      if (this.jdField_a_of_type_Boolean) {
        a("onCreate");
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
      this.jdField_b_of_type_Boolean = true;
      if ((this instanceof GaInviteDialogActivity)) {
        this.jdField_c_of_type_Boolean = false;
      } else if ((this instanceof GaInviteLockActivity)) {
        this.jdField_c_of_type_Boolean = true;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Long, i);
      a(60000);
      return;
    }
    super.finish();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    }
    QAVNotification localQAVNotification = this.jdField_a_of_type_ComTencentAvUtilsQAVNotification;
    if (localQAVNotification != null)
    {
      localQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.l = false;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    long l = AudioHelper.b();
    paramKeyEvent = this.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onKeyDown, keyCode[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("]");
    QLog.w(paramKeyEvent, 1, localStringBuilder.toString());
    if (paramInt == 4) {
      a(l);
    } else if ((paramInt == 26) || (paramInt == 25) || (paramInt == 24)) {
      b(l);
    }
    return false;
  }
  
  protected void onPause()
  {
    long l = AudioHelper.b();
    String str = this.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPause, mSilent[");
    localStringBuilder.append(this.jdField_d_of_type_Boolean);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    b(l);
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(this, 2, true);
    this.jdField_b_of_type_Boolean = false;
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    g();
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(this, 2, false);
    Object localObject = this.jdField_a_of_type_ComTencentAvUtilsQAVNotification;
    if (localObject != null) {
      ((QAVNotification)localObject).a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString);
    }
    if (this.jdField_b_of_type_Boolean) {
      if (this.jdField_c_of_type_Boolean)
      {
        if (VideoController.a(this)) {
          localObject = "1";
        } else {
          localObject = "2";
        }
        ReportController.b(null, "CliOper", "", "", "0X8009E92", "0X8009E92", 0, 0, (String)localObject, "", "", "");
      }
      else
      {
        ReportController.b(null, "CliOper", "", "", "Multi_call", "Popup_force", 0, 0, "", "", "", "");
      }
    }
    if (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Long))
    {
      localObject = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume finish, mGroupId[");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentAvVideoController.p();
      this.jdField_a_of_type_ComTencentAvVideoController.onGAudioRoomDestroy(this.jdField_b_of_type_Int, this.jdField_a_of_type_Long);
      finish();
      return;
    }
    if (!this.g)
    {
      this.g = true;
      ChatActivityUtils.a(this, true, new GaInviteActivity.1(this));
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    if (!super.isFinishing())
    {
      if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification == null) {
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = QAVNotification.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      }
      String str1 = String.valueOf(this.jdField_a_of_type_Long);
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Int, str1, null, true, true);
      int i = AVUtil.c(this.jdField_b_of_type_Int);
      String str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, Long.toString(this.jdField_b_of_type_Long), str1);
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString, str2, localBitmap, str1, 43, this.jdField_a_of_type_Int, 3);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      long l = this.jdField_a_of_type_Long;
      int i = AVUtil.c(this.jdField_b_of_type_Int);
      String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, Long.toString(this.jdField_b_of_type_Long), String.valueOf(l));
      if ((this instanceof GaInviteLockActivity))
      {
        if (getApplicationContext().getString(2131692830).equalsIgnoreCase(this.jdField_a_of_type_AndroidWidgetTextView.getText().toString()))
        {
          str = a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Long, null, true, false);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(super.getApplicationContext().getString(2131692830));
        str = ((StringBuilder)localObject).toString();
      }
      Object localObject = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onWindowFocusChanged, uinType_Invite[");
      localStringBuilder.append(i);
      localStringBuilder.append("], inviteFriendName[");
      localStringBuilder.append(str);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      findViewById(2131373418).setContentDescription(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteActivity
 * JD-Core Version:    0.7.0.1
 */