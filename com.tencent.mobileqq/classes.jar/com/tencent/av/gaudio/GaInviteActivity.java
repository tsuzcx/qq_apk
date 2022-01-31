package com.tencent.av.gaudio;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.UITools;
import com.tencent.av.utils.VExtensionInfoManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import jii;
import jij;

public class GaInviteActivity
  extends BaseGaInvite
{
  AudioManager jdField_a_of_type_AndroidMediaAudioManager = null;
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new jii(this);
  SessionInfo jdField_a_of_type_ComTencentAvAppSessionInfo = null;
  QAVNotification jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
  VExtensionInfoManager jdField_a_of_type_ComTencentAvUtilsVExtensionInfoManager = null;
  boolean jdField_a_of_type_Boolean = false;
  boolean b;
  int jdField_c_of_type_Int = 0;
  long jdField_c_of_type_Long = -1L;
  public String c;
  boolean jdField_c_of_type_Boolean = false;
  int d = 0;
  int e = -1;
  final int f = 0;
  final int g = 1;
  final int h = 2;
  
  public GaInviteActivity()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Boolean) {
      ReportController.b(null, "CliOper", "", "", "Multi_call", "Lock_popup_timeout", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null) {
        this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString);
      }
      b(8);
      return;
      ReportController.b(null, "CliOper", "", "", "Multi_call", "Multi_call_timeout", 0, 0, "", "", "", "");
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Long, paramInt, false);
    super.finish();
  }
  
  void b(Intent paramIntent) {}
  
  protected void c() {}
  
  public void d()
  {
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "startGActivity, beautySetting[" + this.jdField_a_of_type_ComTencentAvAppSessionInfo.p + "]");
    if (this.jdField_a_of_type_ComTencentAvAppSessionInfo.p) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(40), this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_c_of_type_JavaLangString, Boolean.valueOf(true) });
    }
    Intent localIntent = new Intent(this, AVActivity.class);
    localIntent.addFlags(262144);
    localIntent.addFlags(268435456);
    localIntent.putExtra("sessionType", 3);
    localIntent.putExtra("GroupId", String.valueOf(this.jdField_a_of_type_Long));
    localIntent.putExtra("Type", 1);
    localIntent.putExtra("DiscussUinList", this.jdField_a_of_type_ArrayOfLong);
    localIntent.putExtra("needStartTRAE", true);
    localIntent.putExtra("MultiAVType", this.jdField_a_of_type_ComTencentAvAppSessionInfo.D);
    localIntent.putExtra("uin", String.valueOf(this.jdField_a_of_type_Long));
    localIntent.putExtra("uinType", this.jdField_a_of_type_Int);
    localIntent.putExtra("isFromInviteDialog", true);
    b(localIntent);
    AudioHelper.a("GaInviteActivity.startGActivity", localIntent.getExtras());
    super.startActivity(localIntent);
    super.finish();
    overridePendingTransition(2131034270, 0);
    if ((this.jdField_a_of_type_ComTencentAvAppSessionInfo.Y) && (this.jdField_a_of_type_ComTencentAvAppSessionInfo.W)) {
      ReportController.b(null, "CliOper", "", "", "0X800667F", "0X800667F", 0, 0, "", "", "", "");
    }
    while ((!this.jdField_a_of_type_ComTencentAvAppSessionInfo.X) || (!this.jdField_a_of_type_ComTencentAvAppSessionInfo.W)) {
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X8006418", "0X8006418", 0, 0, "", "", "", "");
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_b_of_type_Int, this.jdField_a_of_type_Long);
    super.finish();
  }
  
  public void f()
  {
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "quitGAudioDialog");
    jij localjij1 = new jij(this, 0);
    jij localjij2 = new jij(this, 1);
    DialogUtil.b(this, 230, null, getString(2131428983), 2131428675, 2131429053, localjij1, localjij2).show();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.getWindow().addFlags(2097152);
    paramBundle = getIntent();
    a(paramBundle);
    this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("inviteId");
    this.e = paramBundle.getIntExtra("memberType", -1);
    boolean bool = paramBundle.getBooleanExtra("hasGVideoJoined", false);
    this.jdField_a_of_type_ArrayOfLong = paramBundle.getLongArrayExtra("memberList");
    int i = paramBundle.getIntExtra("MultiAVType", -1);
    Object localObject = a(paramBundle);
    paramBundle = this.jdField_b_of_type_JavaLangString;
    localObject = new StringBuilder().append("onCreate[").append((String)localObject).append("], mInviterUin[").append(this.jdField_b_of_type_Long).append("], mInviteId[").append(this.jdField_c_of_type_JavaLangString).append("], mGroupId[").append(this.jdField_a_of_type_Long).append("], mMemberType[").append(this.e).append("], mRelationType[").append(this.jdField_b_of_type_Int).append("], mHasGVideoJoined[").append(bool).append("], multiAVType[").append(i).append("], mMemberList[");
    if (this.jdField_a_of_type_ArrayOfLong != null)
    {
      bool = true;
      localObject = ((StringBuilder)localObject).append(bool).append("], mApp[");
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
        break label289;
      }
      bool = true;
      label230:
      localObject = ((StringBuilder)localObject).append(bool).append("], mVideoController[");
      if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
        break label294;
      }
    }
    label289:
    label294:
    for (bool = true;; bool = false)
    {
      QLog.w(paramBundle, 1, bool + "]");
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        break label299;
      }
      super.finish();
      return;
      bool = false;
      break;
      bool = false;
      break label230;
    }
    label299:
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      super.finish();
      return;
    }
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)super.getSystemService("audio"));
    if ((this.jdField_a_of_type_AndroidMediaAudioManager.getRingerMode() == 0) || (this.jdField_a_of_type_AndroidMediaAudioManager.getRingerMode() == 1)) {
      this.jdField_c_of_type_Boolean = true;
    }
    paramBundle = SessionMgr.a(this.jdField_b_of_type_Int, String.valueOf(this.jdField_a_of_type_Long), new int[0]);
    if (SessionMgr.a().a(paramBundle)) {}
    for (this.jdField_a_of_type_ComTencentAvAppSessionInfo = SessionMgr.a().a(paramBundle); (this.jdField_a_of_type_ArrayOfLong == null) && (this.jdField_b_of_type_Int == 2); this.jdField_a_of_type_ComTencentAvAppSessionInfo = SessionMgr.a().a())
    {
      super.finish();
      return;
    }
    if ((this.jdField_b_of_type_Long == 0L) || (this.jdField_a_of_type_Long == 0L))
    {
      super.finish();
      return;
    }
    long l = this.jdField_a_of_type_ComTencentAvVideoController.b();
    if (this.jdField_a_of_type_Long != l)
    {
      QLog.w(this.jdField_b_of_type_JavaLangString, 1, "onCreate, id不一致, currentInviteId[" + l + "], mGroupId[" + this.jdField_a_of_type_Long + "]");
      e();
      return;
    }
    c();
    a("onCreate");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    this.jdField_a_of_type_Boolean = true;
    if ((this instanceof GaInviteDialogActivity)) {
      this.jdField_b_of_type_Boolean = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Long, 0);
      a(60000);
      return;
      if ((this instanceof GaInviteLockActivity)) {
        this.jdField_b_of_type_Boolean = true;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null)
    {
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification = null;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.q = false;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      e();
    }
    for (;;)
    {
      return false;
      if ((paramInt == 26) || (paramInt == 25) || (paramInt == 24))
      {
        TraeHelper.a().a("GaInviteActivity.onKeyDown");
        TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      }
    }
  }
  
  protected void onPause()
  {
    if (!this.jdField_c_of_type_Boolean) {
      TraeHelper.a().a("GaInviteActivity.onPause");
    }
    TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    this.jdField_a_of_type_Boolean = false;
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    Object localObject;
    if (!this.jdField_c_of_type_Boolean)
    {
      TraeHelper.a().a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      if (!this.jdField_a_of_type_ComTencentAvVideoController.e)
      {
        this.jdField_a_of_type_ComTencentAvUtilsVExtensionInfoManager = new VExtensionInfoManager(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        localObject = this.jdField_a_of_type_ComTencentAvUtilsVExtensionInfoManager.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
        if (localObject != null)
        {
          this.jdField_c_of_type_Long = VipFunCallManager.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, ((ExtensionInfo)localObject).uin, 3, true, null);
          if (this.jdField_c_of_type_Long != 0L) {
            break label269;
          }
          TraeHelper.a().a("GaInviteActivity.onResume.1", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230741, -1, null);
        }
      }
      else
      {
        label112:
        TraeHelper.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false);
        if (this.jdField_a_of_type_ComTencentAvUtilsQAVNotification != null) {
          this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString);
        }
        if (this.jdField_a_of_type_Boolean)
        {
          if (!this.jdField_b_of_type_Boolean) {
            break label445;
          }
          ReportController.b(null, "CliOper", "", "", "Multi_call", "Lock_popup", 0, 0, "", "", "", "");
        }
      }
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Long))
      {
        QLog.w(this.jdField_b_of_type_JavaLangString, 1, "onResume finish, mGroupId[" + this.jdField_a_of_type_Long + "]");
        this.jdField_a_of_type_ComTencentAvVideoController.t();
        this.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_b_of_type_Int, this.jdField_a_of_type_Long);
        finish();
      }
      return;
      this.jdField_c_of_type_Long = 0L;
      break;
      label269:
      localObject = ColorRingManager.a(this.jdField_c_of_type_Long, 3);
      if (new File((String)localObject).exists())
      {
        TraeHelper.a().a("GaInviteActivity.onResume", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 0, (String)localObject, -1, null);
        ReportController.b(null, "CliOper", "", "", "0X8005004", "0X8005004", 0, 0, "", this.jdField_c_of_type_Long + "", "", "");
        break label112;
      }
      TraeHelper.a().a("GaInviteActivity.onResume.2", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230741, -1, null);
      localObject = new Intent();
      ((Intent)localObject).setAction("tencent.video.v2q.commingRingDownload");
      ((Intent)localObject).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
      ((Intent)localObject).putExtra("comming_ring_down_key", this.jdField_c_of_type_Long);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast((Intent)localObject);
      break label112;
      if (!PhoneStatusTools.a(this)) {
        break label112;
      }
      break label112;
      label445:
      ReportController.b(null, "CliOper", "", "", "Multi_call", "Popup_force", 0, 0, "", "", "", "");
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
      int i = a(this.jdField_b_of_type_Int);
      String str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i, Long.toString(this.jdField_b_of_type_Long), str1);
      this.jdField_a_of_type_ComTencentAvUtilsQAVNotification.a(this.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_b_of_type_JavaLangString, str2, localBitmap, str1, 43, this.jdField_a_of_type_Int, 3);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    int i;
    String str;
    if (paramBoolean)
    {
      long l = this.jdField_a_of_type_Long;
      i = a(this.jdField_b_of_type_Int);
      str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i, Long.toString(this.jdField_b_of_type_Long), String.valueOf(l));
      if (!(this instanceof GaInviteLockActivity)) {
        break label176;
      }
      float f1 = super.getResources().getDimensionPixelSize(2131559833);
      str = UITools.a(super.getApplicationContext(), str, this.jdField_a_of_type_AndroidWidgetTextView, f1);
      str = str + super.getApplicationContext().getString(2131428907);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    }
    for (;;)
    {
      QLog.w(this.jdField_b_of_type_JavaLangString, 1, "onWindowFocusChanged, uinType_Invite[" + i + "], inviteFriendName[" + str + "]");
      findViewById(2131365959).setContentDescription(str);
      return;
      label176:
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      str = str + super.getApplicationContext().getString(2131428907);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteActivity
 * JD-Core Version:    0.7.0.1
 */