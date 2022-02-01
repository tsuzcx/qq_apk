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
  boolean A = false;
  String B = "";
  protected boolean C = false;
  boolean D = false;
  final int E = 0;
  final int F = 1;
  final int G = 2;
  GAudioUIObserver H = new GaInviteActivity.2(this);
  VExtensionInfoManager q = null;
  long r = -1L;
  QAVNotification s = null;
  AudioManager t = null;
  boolean u = true;
  SessionInfo v = null;
  int w = -1;
  boolean x = false;
  boolean y = false;
  boolean z = false;
  
  public void a(long paramLong)
  {
    this.f.a(paramLong, this.d, this.b);
    super.finish();
  }
  
  public void a(long paramLong, int paramInt)
  {
    this.f.a(paramLong, this.d, this.b, paramInt, false);
    super.finish();
  }
  
  public void b(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      String str = this.l;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stopRingAndShake seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], IsPlayingRing[");
      localStringBuilder.append(this.A);
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    if (this.A)
    {
      this.A = false;
      TraeHelper.a().b(paramLong);
    }
    TraeHelper.b(this.e);
  }
  
  void c(Intent paramIntent) {}
  
  public void d()
  {
    if (this.y) {
      ReportController.b(null, "CliOper", "", "", "Multi_call", "Lock_popup_timeout", 0, 0, "", "", "", "");
    } else {
      ReportController.b(null, "CliOper", "", "", "Multi_call", "Multi_call_timeout", 0, 0, "", "", "", "");
    }
    QAVNotification localQAVNotification = this.s;
    if (localQAVNotification != null) {
      localQAVNotification.a(this.v.f);
    }
    a(-1041L, 8);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void f() {}
  
  public void g()
  {
    QLog.w(this.l, 1, "startGActivity");
    b(AudioHelper.c());
    Intent localIntent = new Intent(this, AVActivity.class);
    localIntent.addFlags(262144);
    localIntent.addFlags(268435456);
    localIntent.putExtra("sessionType", 3);
    localIntent.putExtra("GroupId", String.valueOf(this.b));
    localIntent.putExtra("Type", 1);
    localIntent.putExtra("DiscussUinList", this.i);
    localIntent.putExtra("needStartTRAE", true);
    localIntent.putExtra("MultiAVType", this.v.o);
    localIntent.putExtra("uin", String.valueOf(this.b));
    localIntent.putExtra("uinType", this.a);
    localIntent.putExtra("isFromInviteDialog", true);
    c(localIntent);
    AudioHelper.a("GaInviteActivity.startGActivity", localIntent.getExtras());
    super.startActivity(localIntent);
    this.C = true;
    super.finish();
    overridePendingTransition(2130772286, 0);
  }
  
  void h()
  {
    QLog.w(this.l, 1, "quitGAudioDialog");
    GaInviteActivity.DialogInterfaceOnClickListener localDialogInterfaceOnClickListener1 = new GaInviteActivity.DialogInterfaceOnClickListener(this, 0);
    GaInviteActivity.DialogInterfaceOnClickListener localDialogInterfaceOnClickListener2 = new GaInviteActivity.DialogInterfaceOnClickListener(this, 1);
    DialogUtil.a(this, 230, null, getString(2131893276), 2131917829, 2131893180, localDialogInterfaceOnClickListener1, localDialogInterfaceOnClickListener2).show();
  }
  
  void i()
  {
    finish();
  }
  
  public void j()
  {
    long l1 = AudioHelper.c();
    boolean bool = AVUtil.b(this.e.getCurrentAccountUin());
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.l;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startRingAndShake avCallBtnState[");
      localStringBuilder.append(bool);
      localStringBuilder.append("], Silent[");
      localStringBuilder.append(this.z);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    if (!bool) {
      return;
    }
    if (!this.z)
    {
      TraeHelper.a().a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;");
      if (!this.f.j)
      {
        this.A = true;
        this.q = new VExtensionInfoManager(this.e);
        localObject = this.q.a(this.e.getCurrentAccountUin());
        if (localObject != null) {
          this.r = VipFunCallUtil.a(this.e, ((ExtensionInfo)localObject).uin, 3, true, null);
        } else {
          this.r = 0L;
        }
        long l2 = this.r;
        if (l2 == 0L)
        {
          TraeHelper.a().a(l1, this.e, 2131230814, -1, null);
        }
        else
        {
          localObject = ColorRingManager.a(l2, 3);
          if (new File((String)localObject).exists())
          {
            TraeHelper.a().a(l1, this.e, 0, (String)localObject, -1, null);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(this.r);
            ((StringBuilder)localObject).append("");
            ReportController.b(null, "CliOper", "", "", "0X8005004", "0X8005004", 0, 0, "", ((StringBuilder)localObject).toString(), "", "");
          }
          else
          {
            TraeHelper.a().a(l1, this.e, 2131230814, -1, null);
            localObject = new Intent();
            ((Intent)localObject).setAction("tencent.video.v2q.commingRingDownload");
            ((Intent)localObject).setPackage(this.e.getApp().getPackageName());
            ((Intent)localObject).putExtra("comming_ring_down_key", this.r);
            this.e.getApp().sendBroadcast((Intent)localObject);
          }
        }
      }
    }
    TraeHelper.a(this.e, false, l1);
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
    b(paramBundle);
    this.B = paramBundle.getStringExtra("inviteId");
    this.w = paramBundle.getIntExtra("memberType", -1);
    boolean bool = paramBundle.getBooleanExtra("hasGVideoJoined", false);
    int i = paramBundle.getIntExtra("MultiAVType", -1);
    Object localObject1 = a(paramBundle);
    long l1 = AudioHelper.c();
    Object localObject2 = this.l;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreate[");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("], mInviterUin[");
    localStringBuilder.append(this.c);
    localStringBuilder.append("], mInviteId[");
    localStringBuilder.append(this.B);
    localStringBuilder.append("], mGroupId[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("], mMemberType[");
    localStringBuilder.append(this.w);
    localStringBuilder.append("], mRelationType[");
    localStringBuilder.append(this.d);
    localStringBuilder.append("], mHasGVideoJoined[");
    localStringBuilder.append(bool);
    localStringBuilder.append("], multiAVType[");
    localStringBuilder.append(i);
    localStringBuilder.append("], mMemberList[");
    if (this.i != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("], mApp[");
    if (this.e != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("], mVideoController[");
    if (this.f != null) {
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
      localObject1 = this.l;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onCreate-from: ");
      ((StringBuilder)localObject2).append(paramBundle.getStringExtra("Fromwhere"));
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (this.e == null)
    {
      super.finish();
      return;
    }
    if (this.f == null)
    {
      super.finish();
      return;
    }
    this.t = ((AudioManager)super.getSystemService("audio"));
    if ((this.t.getRingerMode() == 0) || (this.t.getRingerMode() == 1)) {
      this.z = true;
    }
    paramBundle = SessionMgr.a(this.d, String.valueOf(this.b), new int[0]);
    if (SessionMgr.a().a(paramBundle)) {
      this.v = SessionMgr.a().d(paramBundle);
    } else {
      this.v = SessionMgr.a().b();
    }
    if ((this.i == null) && (this.d == 2))
    {
      super.finish();
      return;
    }
    if ((this.c != 0L) && (this.b != 0L))
    {
      long l2 = this.f.O();
      if (this.b != l2)
      {
        paramBundle = this.l;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onCreate, id不一致, currentInviteId[");
        ((StringBuilder)localObject1).append(l2);
        ((StringBuilder)localObject1).append("], mGroupId[");
        ((StringBuilder)localObject1).append(this.b);
        ((StringBuilder)localObject1).append("], seq[");
        ((StringBuilder)localObject1).append(l1);
        ((StringBuilder)localObject1).append("]");
        QLog.w(paramBundle, 1, ((StringBuilder)localObject1).toString());
        a(l1);
        return;
      }
      f();
      if (this.u) {
        a("onCreate");
      }
      this.e.a(this.H);
      this.x = true;
      if ((this instanceof GaInviteDialogActivity)) {
        this.y = false;
      } else if ((this instanceof GaInviteLockActivity)) {
        this.y = true;
      }
      this.f.b(this.d, this.b, i);
      b(60000);
      return;
    }
    super.finish();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.e != null) {
      this.e.b(this.H);
    }
    QAVNotification localQAVNotification = this.s;
    if (localQAVNotification != null)
    {
      localQAVNotification.a(this.v.f);
      this.s = null;
    }
    if (this.f != null) {
      this.f.X = false;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    long l = AudioHelper.c();
    paramKeyEvent = this.l;
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
    long l = AudioHelper.c();
    String str = this.l;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPause, mSilent[");
    localStringBuilder.append(this.z);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    b(l);
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(this, 2, true);
    this.x = false;
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    j();
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(this, 2, false);
    Object localObject = this.s;
    if (localObject != null) {
      ((QAVNotification)localObject).a(this.v.f);
    }
    if (this.x) {
      if (this.y)
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
    if (!this.e.a(this.d, this.b))
    {
      localObject = this.l;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume finish, mGroupId[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      this.f.J();
      this.f.onGAudioRoomDestroy(this.d, this.b);
      finish();
      return;
    }
    if (!this.D)
    {
      this.D = true;
      ChatActivityUtils.b(this, true, new GaInviteActivity.1(this));
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    if (!super.isFinishing())
    {
      if (this.s == null) {
        this.s = QAVNotification.a(this.e);
      }
      String str1 = String.valueOf(this.b);
      Bitmap localBitmap = this.e.a(this.a, str1, null, true, true);
      int i = AVUtil.d(this.d);
      String str2 = this.e.a(i, Long.toString(this.c), str1);
      this.s.a(this.v.f, str2, localBitmap, str1, 43, this.a, 3);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      long l = this.b;
      int i = AVUtil.d(this.d);
      String str = this.e.a(i, Long.toString(this.c), String.valueOf(l));
      Object localObject;
      if ((this instanceof GaInviteLockActivity))
      {
        if (getApplicationContext().getString(2131889938).equalsIgnoreCase(this.h.getText().toString()))
        {
          str = a(this.d, this.b, null, true, false);
          this.h.setText(str);
        }
      }
      else
      {
        this.h.setText(str);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(super.getApplicationContext().getString(2131889938));
        str = ((StringBuilder)localObject).toString();
      }
      if (QLog.isDebugVersion())
      {
        localObject = this.l;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onWindowFocusChanged, uinType_Invite[");
        localStringBuilder.append(i);
        localStringBuilder.append("], inviteFriendName[");
        localStringBuilder.append(str);
        localStringBuilder.append("]");
        QLog.w((String)localObject, 1, localStringBuilder.toString());
      }
      findViewById(2131441092).setContentDescription(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteActivity
 * JD-Core Version:    0.7.0.1
 */