package com.tencent.av.gaudio;

import Override;
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
import aqfv;
import bcst;
import bglp;
import bgpa;
import bgxe;
import bhjt;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import lbu;
import ldy;
import ley;
import lmt;
import lmv;
import lmw;
import mqo;
import msp;
import mts;
import mug;

public class GaInviteActivity
  extends BaseGaInvite
{
  AudioManager jdField_a_of_type_AndroidMediaAudioManager = null;
  ldy jdField_a_of_type_Ldy = new lmv(this);
  ley jdField_a_of_type_Ley = null;
  msp jdField_a_of_type_Msp = null;
  mug jdField_a_of_type_Mug = null;
  public boolean a;
  boolean b;
  int jdField_c_of_type_Int = -1;
  long jdField_c_of_type_Long = -1L;
  public String c;
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
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangString = "";
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
      bcst.b(null, "CliOper", "", "", "Multi_call", "Lock_popup_timeout", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Msp != null) {
        this.jdField_a_of_type_Msp.a(this.jdField_a_of_type_Ley.jdField_c_of_type_JavaLangString);
      }
      a(-1041L, 8);
      return;
      bcst.b(null, "CliOper", "", "", "Multi_call", "Multi_call_timeout", 0, 0, "", "", "", "");
    }
  }
  
  public void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_b_of_type_JavaLangString, 2, "stopRingAndShake seq[" + paramLong + "], IsPlayingRing[" + this.jdField_e_of_type_Boolean + "]");
    }
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = false;
      mts.a().b(paramLong);
    }
    mts.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
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
    localIntent.putExtra("MultiAVType", this.jdField_a_of_type_Ley.D);
    localIntent.putExtra("uin", String.valueOf(this.jdField_a_of_type_Long));
    localIntent.putExtra("uinType", this.jdField_a_of_type_Int);
    localIntent.putExtra("isFromInviteDialog", true);
    b(localIntent);
    AudioHelper.a("GaInviteActivity.startGActivity", localIntent.getExtras());
    super.startActivity(localIntent);
    this.jdField_f_of_type_Boolean = true;
    super.finish();
    overridePendingTransition(2130772170, 0);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void e()
  {
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "quitGAudioDialog");
    lmw locallmw1 = new lmw(this, 0);
    lmw locallmw2 = new lmw(this, 1);
    bglp.a(this, 230, null, getString(2131694870), 2131719004, 2131694784, locallmw1, locallmw2).show();
  }
  
  public void f()
  {
    finish();
  }
  
  public void g()
  {
    long l = AudioHelper.b();
    boolean bool = mqo.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_b_of_type_JavaLangString, 2, "startRingAndShake avCallBtnState[" + bool + "], Silent[" + this.jdField_d_of_type_Boolean + "], seq[" + l + "]");
    }
    if (!bool) {
      return;
    }
    Object localObject;
    if (!this.jdField_d_of_type_Boolean)
    {
      mts.a().a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      if (!this.jdField_a_of_type_ComTencentAvVideoController.jdField_e_of_type_Boolean)
      {
        this.jdField_e_of_type_Boolean = true;
        this.jdField_a_of_type_Mug = new mug(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        localObject = this.jdField_a_of_type_Mug.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
        if (localObject == null) {
          break label206;
        }
        this.jdField_c_of_type_Long = bhjt.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, ((ExtensionInfo)localObject).uin, 3, true, null);
        if (this.jdField_c_of_type_Long != 0L) {
          break label214;
        }
        mts.a().a(l, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230742, -1, null);
      }
    }
    for (;;)
    {
      mts.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false, l);
      return;
      label206:
      this.jdField_c_of_type_Long = 0L;
      break;
      label214:
      localObject = bgxe.a(this.jdField_c_of_type_Long, 3);
      if (new File((String)localObject).exists())
      {
        mts.a().a(l, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 0, (String)localObject, -1, null);
        bcst.b(null, "CliOper", "", "", "0X8005004", "0X8005004", 0, 0, "", this.jdField_c_of_type_Long + "", "", "");
      }
      else
      {
        mts.a().a(l, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 2131230742, -1, null);
        localObject = new Intent();
        ((Intent)localObject).setAction("tencent.video.v2q.commingRingDownload");
        ((Intent)localObject).setPackage(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getPackageName());
        ((Intent)localObject).putExtra("comming_ring_down_key", this.jdField_c_of_type_Long);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast((Intent)localObject);
      }
    }
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
    Object localObject = a(paramBundle);
    long l1 = AudioHelper.b();
    String str = this.jdField_b_of_type_JavaLangString;
    localObject = new StringBuilder().append("onCreate[").append((String)localObject).append("], mInviterUin[").append(this.jdField_b_of_type_Long).append("], mInviteId[").append(this.jdField_c_of_type_JavaLangString).append("], mGroupId[").append(this.jdField_a_of_type_Long).append("], mMemberType[").append(this.jdField_c_of_type_Int).append("], mRelationType[").append(this.jdField_b_of_type_Int).append("], mHasGVideoJoined[").append(bool).append("], multiAVType[").append(i).append("], mMemberList[");
    if (this.jdField_a_of_type_ArrayOfLong != null)
    {
      bool = true;
      localObject = ((StringBuilder)localObject).append(bool).append("], mApp[");
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
        break label336;
      }
      bool = true;
      label225:
      localObject = ((StringBuilder)localObject).append(bool).append("], mVideoController[");
      if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
        break label341;
      }
    }
    label336:
    label341:
    for (bool = true;; bool = false)
    {
      QLog.w(str, 1, bool + "], seq[" + l1 + "]");
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_b_of_type_JavaLangString, 2, "onCreate-from: " + paramBundle.getStringExtra("Fromwhere"));
      }
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        break label346;
      }
      super.finish();
      return;
      bool = false;
      break;
      bool = false;
      break label225;
    }
    label346:
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      super.finish();
      return;
    }
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)super.getSystemService("audio"));
    if ((this.jdField_a_of_type_AndroidMediaAudioManager.getRingerMode() == 0) || (this.jdField_a_of_type_AndroidMediaAudioManager.getRingerMode() == 1)) {
      this.jdField_d_of_type_Boolean = true;
    }
    paramBundle = lbu.a(this.jdField_b_of_type_Int, String.valueOf(this.jdField_a_of_type_Long), new int[0]);
    if (lbu.a().a(paramBundle)) {}
    for (this.jdField_a_of_type_Ley = lbu.a().c(paramBundle); (this.jdField_a_of_type_ArrayOfLong == null) && (this.jdField_b_of_type_Int == 2); this.jdField_a_of_type_Ley = lbu.a().a())
    {
      super.finish();
      return;
    }
    if ((this.jdField_b_of_type_Long == 0L) || (this.jdField_a_of_type_Long == 0L))
    {
      super.finish();
      return;
    }
    long l2 = this.jdField_a_of_type_ComTencentAvVideoController.b();
    if (this.jdField_a_of_type_Long != l2)
    {
      QLog.w(this.jdField_b_of_type_JavaLangString, 1, "onCreate, id不一致, currentInviteId[" + l2 + "], mGroupId[" + this.jdField_a_of_type_Long + "], seq[" + l1 + "]");
      a(l1);
      return;
    }
    c();
    if (this.jdField_a_of_type_Boolean) {
      a("onCreate");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Ldy);
    this.jdField_b_of_type_Boolean = true;
    if ((this instanceof GaInviteDialogActivity)) {
      this.jdField_c_of_type_Boolean = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Long, i);
      a(60000);
      return;
      if ((this instanceof GaInviteLockActivity)) {
        this.jdField_c_of_type_Boolean = true;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Ldy);
    }
    if (this.jdField_a_of_type_Msp != null)
    {
      this.jdField_a_of_type_Msp.a(this.jdField_a_of_type_Ley.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_Msp = null;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_ComTencentAvVideoController.m = false;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    long l = AudioHelper.b();
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "onKeyDown, keyCode[" + paramInt + "], seq[" + l + "]");
    if (paramInt == 4) {
      a(l);
    }
    for (;;)
    {
      return false;
      if ((paramInt == 26) || (paramInt == 25) || (paramInt == 24)) {
        b(l);
      }
    }
  }
  
  public void onPause()
  {
    long l = AudioHelper.b();
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "onPause, mSilent[" + this.jdField_d_of_type_Boolean + "], seq[" + l + "]");
    b(l);
    aqfv.a(this, 2, true);
    this.jdField_b_of_type_Boolean = false;
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    g();
    aqfv.a(this, 2, false);
    if (this.jdField_a_of_type_Msp != null) {
      this.jdField_a_of_type_Msp.a(this.jdField_a_of_type_Ley.jdField_c_of_type_JavaLangString);
    }
    String str;
    if (this.jdField_b_of_type_Boolean)
    {
      if (!this.jdField_c_of_type_Boolean) {
        break label173;
      }
      if (VideoController.a(this))
      {
        str = "1";
        bcst.b(null, "CliOper", "", "", "0X8009E92", "0X8009E92", 0, 0, str, "", "", "");
      }
    }
    else
    {
      label85:
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Long)) {
        break label201;
      }
      QLog.w(this.jdField_b_of_type_JavaLangString, 1, "onResume finish, mGroupId[" + this.jdField_a_of_type_Long + "]");
      this.jdField_a_of_type_ComTencentAvVideoController.o();
      this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_b_of_type_Int, this.jdField_a_of_type_Long);
      finish();
    }
    label173:
    label201:
    while (this.g)
    {
      return;
      str = "2";
      break;
      bcst.b(null, "CliOper", "", "", "Multi_call", "Popup_force", 0, 0, "", "", "", "");
      break label85;
    }
    this.g = true;
    ChatActivityUtils.a(this, true, new lmt(this));
  }
  
  public void onStop()
  {
    super.onStop();
    if (!super.isFinishing())
    {
      if (this.jdField_a_of_type_Msp == null) {
        this.jdField_a_of_type_Msp = msp.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      }
      String str1 = String.valueOf(this.jdField_a_of_type_Long);
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Int, str1, null, true, true);
      int i = mqo.c(this.jdField_b_of_type_Int);
      String str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i, Long.toString(this.jdField_b_of_type_Long), str1);
      this.jdField_a_of_type_Msp.a(this.jdField_a_of_type_Ley.jdField_c_of_type_JavaLangString, str2, localBitmap, str1, 43, this.jdField_a_of_type_Int, 3);
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
      i = mqo.c(this.jdField_b_of_type_Int);
      str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(i, Long.toString(this.jdField_b_of_type_Long), String.valueOf(l));
      if (!(this instanceof GaInviteLockActivity)) {
        break label161;
      }
      if (getApplicationContext().getString(2131692576).equalsIgnoreCase(this.jdField_a_of_type_AndroidWidgetTextView.getText().toString()))
      {
        str = a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Long, null, true, false);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      }
    }
    for (;;)
    {
      QLog.w(this.jdField_b_of_type_JavaLangString, 1, "onWindowFocusChanged, uinType_Invite[" + i + "], inviteFriendName[" + str + "]");
      findViewById(2131373280).setContentDescription(str);
      return;
      label161:
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      str = str + super.getApplicationContext().getString(2131692576);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteActivity
 * JD-Core Version:    0.7.0.1
 */