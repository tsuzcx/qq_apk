package com.tencent.av.service;

import android.app.Notification;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.av.AVLog;
import com.tencent.av.QavChannelProxy;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.GuildInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.filter.EffectFilterTools.DataReport;
import com.tencent.av.business.manager.pendant.EffectPendantTools.DataReport;
import com.tencent.av.business.manager.zimu.EffectZimuManager.DataReport;
import com.tencent.av.ui.BeautyToolbar.DataReport;
import com.tencent.av.ui.VoiceChangeDataReport;
import com.tencent.av.utils.TraeHelper;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class AVServiceForQQ$AVServiceForQQStub
  extends IAVServiceForQQ.Stub
{
  private AVServiceForQQ$AVServiceForQQStub(AVServiceForQQ paramAVServiceForQQ) {}
  
  public int a(long paramLong, int paramInt)
  {
    Object localObject;
    label72:
    int i;
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      localObject = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if ((localObject == null) || (!((VideoController)localObject).d) || (((VideoController)localObject).a().F != paramInt) || (((VideoController)localObject).a().jdField_g_of_type_Long != paramLong)) {
        break label117;
      }
      localObject = ((VideoController)localObject).c().iterator();
      paramInt = 0;
      i = paramInt;
      if (!((Iterator)localObject).hasNext()) {
        break label120;
      }
      if (((VideoController.GAudioFriends)((Iterator)localObject).next()).d != 1) {
        break label123;
      }
      paramInt += 1;
    }
    label117:
    label120:
    label123:
    for (;;)
    {
      break label72;
      localObject = VideoController.a();
      break;
      i = 0;
      return i;
    }
  }
  
  public AVPbInfo a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVServiceForQQ", 2, "processQCallPush in AVServiceForQQ");
    }
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
    for (VideoController localVideoController = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(); localVideoController != null; localVideoController = VideoController.a()) {
      return localVideoController.a(paramArrayOfByte);
    }
    return null;
  }
  
  public void a()
  {
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
    for (VideoController localVideoController = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();; localVideoController = VideoController.a())
    {
      int i = localVideoController.e();
      localVideoController.a("startSpeak", localVideoController.jdField_a_of_type_Long, true, true, -1);
      localVideoController.a(-1L, i, localVideoController.e());
      return;
    }
  }
  
  public void a(long paramLong)
  {
    b();
    VideoController localVideoController;
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      localVideoController = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (!localVideoController.d) {
        break label90;
      }
      if (paramLong == 0L) {
        paramLong = localVideoController.jdField_a_of_type_Long;
      }
      localVideoController.a(localVideoController.b, localVideoController.jdField_a_of_type_Long, 95);
    }
    for (;;)
    {
      localVideoController.a(0, 0, null);
      SessionMgr.a().a().a();
      SessionMgr.a().a().b();
      return;
      localVideoController = VideoController.a();
      break;
      label90:
      localVideoController.a(AVServiceForQQ.a(this.a), paramLong, 96);
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
    for (VideoController localVideoController = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(); (localVideoController.d) && (localVideoController.a().aE); localVideoController = VideoController.a()) {
      return;
    }
    long l = AudioHelper.b();
    QLog.w("AVServiceForQQ", 1, "enterRoom, groupId[" + paramLong + "], nickname[" + paramString + "], seq[" + l + "]");
    localVideoController.a().b("enterRoom", true);
    AVServiceForQQ.a(this.a, TraeHelper.a());
    AVServiceForQQ.a(this.a).a(null);
    AVServiceForQQ.a(this.a).c();
    AVServiceForQQ.a(this.a).d();
    if ((SessionMgr.a().a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Int == 3) && ((paramLong == -1L) || (paramLong == SessionMgr.a().a().jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Long)))
    {
      AVServiceForQQ.a(this.a, true);
      this.a.jdField_a_of_type_JavaLangString = SessionMgr.a().a().c;
      if ((!AVServiceForQQ.a(this.a)) && (localVideoController.d))
      {
        localVideoController.a(localVideoController.b, localVideoController.jdField_a_of_type_Long, 94);
        SessionMgr.a().a().b();
        SessionMgr.a().a().a();
      }
      SessionMgr.a().b(this.a.jdField_a_of_type_JavaLangString);
      if (AVServiceForQQ.a(this.a)) {
        break label447;
      }
      AVServiceForQQ.a(this.a).b();
      AVServiceForQQ.a(this.a).a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
      AVServiceForQQ.a(this.a).a();
      localVideoController.c(false);
      label339:
      if (!localVideoController.d) {
        break label598;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AVServiceForQQ", 2, "StartOrEnterGAudio already in room");
      }
    }
    for (;;)
    {
      localVideoController.a().a(l, "enterRoom", 3);
      localVideoController.a().jdField_a_of_type_ComTencentAvAppSessionInfo$Anychat_Info.b = paramString;
      localVideoController.a().aE = true;
      return;
      this.a.jdField_a_of_type_JavaLangString = SessionMgr.a(AVServiceForQQ.a(this.a), String.valueOf(paramLong), new int[0]);
      SessionMgr.a().a(this.a.jdField_a_of_type_JavaLangString, false);
      AVServiceForQQ.a(this.a, false);
      break;
      label447:
      if (QLog.isColorLevel()) {
        QLog.d("AVServiceForQQ", 2, "IsAccompanyReturn");
      }
      AVServiceForQQ.a(this.a).a();
      if (SessionMgr.a().c(this.a.jdField_a_of_type_JavaLangString).jdField_g_of_type_Boolean)
      {
        i = localVideoController.e();
        localVideoController.a("enterRoom", SessionMgr.a().c(this.a.jdField_a_of_type_JavaLangString).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Long, false, false, -1);
        localVideoController.a(-1L, i, localVideoController.e());
        break label339;
      }
      int i = localVideoController.e();
      localVideoController.a("enterRoom", SessionMgr.a().c(this.a.jdField_a_of_type_JavaLangString).jdField_a_of_type_ComTencentAvAppSessionInfo$GuildInfo.jdField_a_of_type_Long, true, false, -1);
      localVideoController.a(-1L, i, localVideoController.e());
      break label339;
      label598:
      i = localVideoController.a(AVServiceForQQ.a(this.a), paramLong, AVServiceForQQ.b(this.a), new long[] { this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin() }, false);
      if (QLog.isColorLevel()) {
        QLog.d("AVServiceForQQ", 2, "enterRoom result = " + i);
      }
      new Handler(Looper.getMainLooper()).post(new AVServiceForQQ.AVServiceForQQStub.2(this, i));
    }
  }
  
  public void a(IAVServiceCallback paramIAVServiceCallback) {}
  
  public void a(String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
    for (VideoController localVideoController = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();; localVideoController = VideoController.a())
    {
      if (localVideoController != null) {
        localVideoController.i(paramString);
      }
      return;
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
    for (VideoController localVideoController = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();; localVideoController = VideoController.a())
    {
      if (localVideoController != null) {
        localVideoController.a(paramString, paramBitmap);
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
    for (VideoController localVideoController = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();; localVideoController = VideoController.a())
    {
      localVideoController.b(paramBoolean);
      return;
    }
  }
  
  public void a(boolean paramBoolean, Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT < 18) {}
    for (;;)
    {
      return;
      if (!paramBoolean) {
        break;
      }
      if (paramNotification != null) {}
      for (this.a.jdField_a_of_type_AndroidAppNotification = paramNotification; this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null; this.a.jdField_a_of_type_AndroidAppNotification = new Notification())
      {
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new AVServiceForQQ.AVServiceForQQStub.1(this));
        return;
      }
    }
    try
    {
      this.a.stopForeground(true);
      QLog.d("AVServiceForQQ", 1, "setAvServiceForegroud stop foreground.");
      this.a.jdField_a_of_type_AndroidAppNotification = null;
      return;
    }
    catch (Throwable paramNotification)
    {
      for (;;)
      {
        QLog.d("AVServiceForQQ", 1, "setAvServiceForegroud stop foreground fail", paramNotification);
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
    for (VideoController localVideoController = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();; localVideoController = VideoController.a())
    {
      if (localVideoController != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putByteArray("buffer", paramArrayOfByte);
        localVideoController.jdField_a_of_type_ComTencentAvQavChannelProxy.receiveMultiVideoMsg(localBundle);
      }
      return;
    }
  }
  
  public void b()
  {
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
    for (VideoController localVideoController = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();; localVideoController = VideoController.a())
    {
      int i = localVideoController.e();
      localVideoController.a("stopSpeak", localVideoController.jdField_a_of_type_Long, false, true, -1);
      localVideoController.a(-1L, i, localVideoController.e());
      return;
    }
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
    for (VideoController localVideoController = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();; localVideoController = VideoController.a())
    {
      if (localVideoController != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putByteArray("buffer", paramArrayOfByte);
        localVideoController.jdField_a_of_type_ComTencentAvQavChannelProxy.receiveMultiVideoAck(localBundle);
      }
      return;
    }
  }
  
  public void c()
  {
    long l = AudioHelper.b();
    QLog.w("AVServiceForQQ", 1, "exitQQCall, seq[" + l + "]");
    VideoController localVideoController;
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      localVideoController = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      TraeHelper.a().b(l);
      localVideoController.a().f = false;
      localVideoController.a(localVideoController.a().d, 224);
      localVideoController.b(224);
      if (localVideoController.a().z == -1) {
        break label219;
      }
    }
    for (;;)
    {
      localVideoController.a().t = true;
      AVLog.printColorLog("AVServiceForQQ", "DataReport onClose: ");
      EffectFilterTools.DataReport.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      EffectZimuManager.DataReport.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      EffectPendantTools.DataReport.a("AVServiceForQQ", this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      BeautyToolbar.DataReport.b(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
      VoiceChangeDataReport.a(localVideoController.a());
      localVideoController.b(localVideoController.a().d, localVideoController.a().z);
      localVideoController.a().a("exitQQCall", false);
      localVideoController.a().b("exitQQCall", 0);
      return;
      localVideoController = VideoController.a();
      break;
      label219:
      localVideoController.a().z = 0;
    }
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
    for (VideoController localVideoController = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();; localVideoController = VideoController.a())
    {
      if (localVideoController != null) {
        localVideoController.jdField_a_of_type_ComTencentAvQavChannelProxy.a(paramArrayOfByte);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.service.AVServiceForQQ.AVServiceForQQStub
 * JD-Core Version:    0.7.0.1
 */