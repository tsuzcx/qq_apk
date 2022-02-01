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
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.filter.EffectFilterTools.DataReport;
import com.tencent.av.business.manager.pendant.EffectPendantTools.DataReport;
import com.tencent.av.business.manager.zimu.EffectZimuManager.DataReport;
import com.tencent.av.ui.BeautyToolbar.DataReport;
import com.tencent.av.ui.VoiceChangeDataReport;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.TraeHelper;
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
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      localObject = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    } else {
      localObject = VideoController.a();
    }
    int k = 0;
    int j = 0;
    int i = k;
    if (localObject != null)
    {
      i = k;
      if (((VideoController)localObject).d)
      {
        i = k;
        if (((VideoController)localObject).a().E == paramInt)
        {
          i = k;
          if (((VideoController)localObject).a().jdField_f_of_type_Long == paramLong)
          {
            localObject = ((VideoController)localObject).c().iterator();
            paramInt = j;
            for (;;)
            {
              i = paramInt;
              if (!((Iterator)localObject).hasNext()) {
                break;
              }
              if (((VideoController.GAudioFriends)((Iterator)localObject).next()).d == 1) {
                paramInt += 1;
              }
            }
          }
        }
      }
    }
    return i;
  }
  
  public AVPbInfo a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVServiceForQQ", 2, "processQCallPush in AVServiceForQQ");
    }
    VideoController localVideoController;
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      localVideoController = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    } else {
      localVideoController = VideoController.a();
    }
    if (localVideoController != null) {
      return localVideoController.a(paramArrayOfByte);
    }
    return null;
  }
  
  public void a()
  {
    VideoController localVideoController;
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      localVideoController = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    } else {
      localVideoController = VideoController.a();
    }
    int i = localVideoController.e();
    localVideoController.a("startSpeak", localVideoController.jdField_a_of_type_Long, true, true, -1);
    localVideoController.a(-1L, i, localVideoController.e());
  }
  
  public void a(long paramLong)
  {
    b();
    VideoController localVideoController;
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      localVideoController = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    } else {
      localVideoController = VideoController.a();
    }
    if (localVideoController.d)
    {
      if (paramLong == 0L) {
        paramLong = localVideoController.jdField_a_of_type_Long;
      }
      localVideoController.a(localVideoController.b, localVideoController.jdField_a_of_type_Long, 95);
      return;
    }
    localVideoController.a(AVServiceForQQ.a(this.a), paramLong, 96);
  }
  
  public void a(long paramLong, String paramString)
  {
    VideoController localVideoController;
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      localVideoController = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    } else {
      localVideoController = VideoController.a();
    }
    if ((localVideoController.d) && (localVideoController.a().as)) {
      return;
    }
    long l = AudioHelper.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enterRoom, groupId[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], nickname[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("]");
    QLog.w("AVServiceForQQ", 1, localStringBuilder.toString());
    localVideoController.a().b("enterRoom", true);
    AVServiceForQQ.a(this.a, TraeHelper.a());
    AVServiceForQQ.a(this.a).a(null);
    AVServiceForQQ.a(this.a).c();
    AVServiceForQQ.a(this.a).d();
    paramString = this.a;
    paramString.jdField_a_of_type_JavaLangString = SessionMgr.a(AVServiceForQQ.a(paramString), String.valueOf(paramLong), new int[0]);
    SessionMgr.a().a(this.a.jdField_a_of_type_JavaLangString, false);
    if (localVideoController.d) {
      localVideoController.a(localVideoController.b, localVideoController.jdField_a_of_type_Long, 94);
    }
    SessionMgr.a().b(this.a.jdField_a_of_type_JavaLangString);
    AVServiceForQQ.a(this.a).b();
    AVServiceForQQ.a(this.a).a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;");
    AVServiceForQQ.a(this.a).a();
    localVideoController.c(false);
    if (localVideoController.d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVServiceForQQ", 2, "StartOrEnterGAudio already in room");
      }
    }
    else
    {
      int i = localVideoController.a(AVServiceForQQ.a(this.a), paramLong, AVServiceForQQ.b(this.a), new long[] { this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin() }, false);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("enterRoom result = ");
        paramString.append(i);
        QLog.d("AVServiceForQQ", 2, paramString.toString());
      }
      new Handler(Looper.getMainLooper()).post(new AVServiceForQQ.AVServiceForQQStub.2(this, i));
    }
    localVideoController.a().a(l, "enterRoom", 3);
    localVideoController.a().as = true;
  }
  
  public void a(IAVServiceCallback paramIAVServiceCallback) {}
  
  public void a(String paramString)
  {
    VideoController localVideoController;
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      localVideoController = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    } else {
      localVideoController = VideoController.a();
    }
    if (localVideoController != null) {
      localVideoController.i(paramString);
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      return;
    }
    VideoController.a();
  }
  
  public void a(boolean paramBoolean)
  {
    VideoController localVideoController;
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      localVideoController = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    } else {
      localVideoController = VideoController.a();
    }
    localVideoController.b(paramBoolean);
  }
  
  public void a(boolean paramBoolean, Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT < 18) {
      return;
    }
    if (paramBoolean)
    {
      if (paramNotification != null) {
        this.a.jdField_a_of_type_AndroidAppNotification = paramNotification;
      } else {
        this.a.jdField_a_of_type_AndroidAppNotification = new Notification();
      }
      if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new AVServiceForQQ.AVServiceForQQStub.1(this));
      }
    }
    else
    {
      try
      {
        this.a.stopForeground(true);
        QLog.d("AVServiceForQQ", 1, "setAvServiceForegroud stop foreground.");
      }
      catch (Throwable paramNotification)
      {
        QLog.d("AVServiceForQQ", 1, "setAvServiceForegroud stop foreground fail", paramNotification);
      }
      this.a.jdField_a_of_type_AndroidAppNotification = null;
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    VideoController localVideoController;
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      localVideoController = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    } else {
      localVideoController = VideoController.a();
    }
    if (localVideoController != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putByteArray("buffer", paramArrayOfByte);
      localVideoController.jdField_a_of_type_ComTencentAvQavChannelProxy.receiveMultiVideoMsg(localBundle);
    }
  }
  
  public void b()
  {
    VideoController localVideoController;
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      localVideoController = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    } else {
      localVideoController = VideoController.a();
    }
    int i = localVideoController.e();
    localVideoController.a("stopSpeak", localVideoController.jdField_a_of_type_Long, false, true, -1);
    localVideoController.a(-1L, i, localVideoController.e());
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    VideoController localVideoController;
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      localVideoController = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    } else {
      localVideoController = VideoController.a();
    }
    if (localVideoController != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putByteArray("buffer", paramArrayOfByte);
      localVideoController.jdField_a_of_type_ComTencentAvQavChannelProxy.receiveMultiVideoAck(localBundle);
    }
  }
  
  public void c()
  {
    long l = AudioHelper.b();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("exitQQCall, seq[");
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append("]");
    QLog.w("AVServiceForQQ", 1, ((StringBuilder)localObject).toString());
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      localObject = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    } else {
      localObject = VideoController.a();
    }
    TraeHelper.a().b(l);
    ((VideoController)localObject).a().jdField_f_of_type_Boolean = false;
    ((VideoController)localObject).a(((VideoController)localObject).a().c, 224);
    ((VideoController)localObject).b(224);
    if (((VideoController)localObject).a().z == -1) {
      ((VideoController)localObject).a().z = 0;
    }
    ((VideoController)localObject).a().s = true;
    AVLog.printColorLog("AVServiceForQQ", "DataReport onClose: ");
    EffectFilterTools.DataReport.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    EffectZimuManager.DataReport.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    EffectPendantTools.DataReport.a("AVServiceForQQ", this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    BeautyToolbar.DataReport.b(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    VoiceChangeDataReport.a(((VideoController)localObject).a());
    ((VideoController)localObject).b(((VideoController)localObject).a().c, ((VideoController)localObject).a().z);
    ((VideoController)localObject).a().a("exitQQCall", false);
    ((VideoController)localObject).a().c("exitQQCall", 0);
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    VideoController localVideoController;
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      localVideoController = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    } else {
      localVideoController = VideoController.a();
    }
    if (localVideoController != null) {
      localVideoController.jdField_a_of_type_ComTencentAvQavChannelProxy.a(paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.service.AVServiceForQQ.AVServiceForQQStub
 * JD-Core Version:    0.7.0.1
 */