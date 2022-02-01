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
import com.tencent.av.ui.VoiceChangeDataReport;
import com.tencent.av.ui.effect.toolbar.oldversion.BeautyToolbar.DataReport;
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
    if (this.a.a != null) {
      localObject = this.a.a.b();
    } else {
      localObject = VideoController.f();
    }
    int k = 0;
    int j = 0;
    int i = k;
    if (localObject != null)
    {
      i = k;
      if (((VideoController)localObject).j)
      {
        i = k;
        if (((VideoController)localObject).k().aQ == paramInt)
        {
          i = k;
          if (((VideoController)localObject).k().aN == paramLong)
          {
            localObject = ((VideoController)localObject).U().iterator();
            paramInt = j;
            for (;;)
            {
              i = paramInt;
              if (!((Iterator)localObject).hasNext()) {
                break;
              }
              if (((VideoController.GAudioFriends)((Iterator)localObject).next()).n == 1) {
                paramInt += 1;
              }
            }
          }
        }
      }
    }
    return i;
  }
  
  public void a()
  {
    VideoController localVideoController;
    if (this.a.a != null) {
      localVideoController = this.a.a.b();
    } else {
      localVideoController = VideoController.f();
    }
    int i = localVideoController.D();
    localVideoController.a("startSpeak", localVideoController.k, true, true, -1);
    localVideoController.a(-1L, i, localVideoController.D());
  }
  
  public void a(long paramLong)
  {
    b();
    VideoController localVideoController;
    if (this.a.a != null) {
      localVideoController = this.a.a.b();
    } else {
      localVideoController = VideoController.f();
    }
    if (localVideoController.j)
    {
      if (paramLong == 0L) {
        paramLong = localVideoController.k;
      }
      localVideoController.a(localVideoController.l, localVideoController.k, 95);
      return;
    }
    localVideoController.a(AVServiceForQQ.b(this.a), paramLong, 96);
  }
  
  public void a(long paramLong, String paramString)
  {
    VideoController localVideoController;
    if (this.a.a != null) {
      localVideoController = this.a.a.b();
    } else {
      localVideoController = VideoController.f();
    }
    if ((localVideoController.j) && (localVideoController.k().ca)) {
      return;
    }
    long l = AudioHelper.c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enterRoom, groupId[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], nickname[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("]");
    QLog.w("AVServiceForQQ", 1, localStringBuilder.toString());
    localVideoController.k().b("enterRoom", true);
    AVServiceForQQ.a(this.a, TraeHelper.a());
    AVServiceForQQ.a(this.a).a(null);
    AVServiceForQQ.a(this.a).f();
    AVServiceForQQ.a(this.a).g();
    paramString = this.a;
    paramString.c = SessionMgr.a(AVServiceForQQ.b(paramString), String.valueOf(paramLong), new int[0]);
    SessionMgr.a().a(this.a.c, false);
    if (localVideoController.j) {
      localVideoController.a(localVideoController.l, localVideoController.k, 94);
    }
    SessionMgr.a().e(this.a.c);
    AVServiceForQQ.a(this.a).d();
    AVServiceForQQ.a(this.a).a("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTH_HEADSET;DEVICE_WIRED_HEADSET;");
    AVServiceForQQ.a(this.a).b();
    localVideoController.e(false);
    if (localVideoController.j)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVServiceForQQ", 2, "StartOrEnterGAudio already in room");
      }
    }
    else
    {
      int i = localVideoController.a(AVServiceForQQ.b(this.a), paramLong, AVServiceForQQ.c(this.a), new long[] { this.a.a.getLongAccountUin() }, false);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("enterRoom result = ");
        paramString.append(i);
        QLog.d("AVServiceForQQ", 2, paramString.toString());
      }
      new Handler(Looper.getMainLooper()).post(new AVServiceForQQ.AVServiceForQQStub.2(this, i));
    }
    localVideoController.k().a(l, "enterRoom", 3);
    localVideoController.k().ca = true;
  }
  
  public void a(IAVServiceCallback paramIAVServiceCallback) {}
  
  public void a(String paramString)
  {
    VideoController localVideoController;
    if (this.a.a != null) {
      localVideoController = this.a.a.b();
    } else {
      localVideoController = VideoController.f();
    }
    if (localVideoController != null) {
      localVideoController.r(paramString);
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (this.a.a != null)
    {
      this.a.a.b();
      return;
    }
    VideoController.f();
  }
  
  public void a(boolean paramBoolean)
  {
    VideoController localVideoController;
    if (this.a.a != null) {
      localVideoController = this.a.a.b();
    } else {
      localVideoController = VideoController.f();
    }
    localVideoController.d(paramBoolean);
  }
  
  public void a(boolean paramBoolean, Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT < 18) {
      return;
    }
    if (paramBoolean)
    {
      if (paramNotification != null) {
        this.a.b = paramNotification;
      } else {
        this.a.b = new Notification();
      }
      if (this.a.a != null) {
        this.a.a.a().post(new AVServiceForQQ.AVServiceForQQStub.1(this));
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
      this.a.b = null;
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    VideoController localVideoController;
    if (this.a.a != null) {
      localVideoController = this.a.a.b();
    } else {
      localVideoController = VideoController.f();
    }
    if (localVideoController != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putByteArray("buffer", paramArrayOfByte);
      localVideoController.n.receiveMultiVideoMsg(localBundle);
    }
  }
  
  public void b()
  {
    VideoController localVideoController;
    if (this.a.a != null) {
      localVideoController = this.a.a.b();
    } else {
      localVideoController = VideoController.f();
    }
    int i = localVideoController.D();
    localVideoController.a("stopSpeak", localVideoController.k, false, true, -1);
    localVideoController.a(-1L, i, localVideoController.D());
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    VideoController localVideoController;
    if (this.a.a != null) {
      localVideoController = this.a.a.b();
    } else {
      localVideoController = VideoController.f();
    }
    if (localVideoController != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putByteArray("buffer", paramArrayOfByte);
      localVideoController.n.receiveMultiVideoAck(localBundle);
    }
  }
  
  public void c()
  {
    long l = AudioHelper.c();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("exitQQCall, seq[");
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append("]");
    QLog.w("AVServiceForQQ", 1, ((StringBuilder)localObject).toString());
    if (this.a.a != null) {
      localObject = this.a.a.b();
    } else {
      localObject = VideoController.f();
    }
    TraeHelper.a().b(l);
    ((VideoController)localObject).k().C = false;
    ((VideoController)localObject).a(((VideoController)localObject).k().s, 224);
    ((VideoController)localObject).b(224);
    if (((VideoController)localObject).k().ay == -1) {
      ((VideoController)localObject).k().ay = 0;
    }
    ((VideoController)localObject).k().R = true;
    AVLog.printColorLog("AVServiceForQQ", "DataReport onClose: ");
    EffectFilterTools.DataReport.a(this.a.a);
    EffectZimuManager.DataReport.a(this.a.a);
    EffectPendantTools.DataReport.a("AVServiceForQQ", this.a.a);
    BeautyToolbar.DataReport.b(this.a.a.getCurrentAccountUin());
    VoiceChangeDataReport.a(((VideoController)localObject).k());
    ((VideoController)localObject).b(((VideoController)localObject).k().s, ((VideoController)localObject).k().ay);
    ((VideoController)localObject).k().a("exitQQCall", false);
    ((VideoController)localObject).k().c("exitQQCall", 0);
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    VideoController localVideoController;
    if (this.a.a != null) {
      localVideoController = this.a.a.b();
    } else {
      localVideoController = VideoController.f();
    }
    if (localVideoController != null) {
      localVideoController.n.a(paramArrayOfByte);
    }
  }
  
  public AVPbInfo d(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVServiceForQQ", 2, "processQCallPush in AVServiceForQQ");
    }
    VideoController localVideoController;
    if (this.a.a != null) {
      localVideoController = this.a.a.b();
    } else {
      localVideoController = VideoController.f();
    }
    if (localVideoController != null) {
      return localVideoController.c(paramArrayOfByte);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.service.AVServiceForQQ.AVServiceForQQStub
 * JD-Core Version:    0.7.0.1
 */