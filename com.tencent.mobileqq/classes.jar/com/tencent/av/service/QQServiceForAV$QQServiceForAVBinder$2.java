package com.tencent.av.service;

import android.app.Application;
import android.content.Intent;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.VideoUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.av.utils.api.IVideoProcessMonitor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import java.io.Serializable;

class QQServiceForAV$QQServiceForAVBinder$2
  implements IBinder.DeathRecipient
{
  QQServiceForAV$QQServiceForAVBinder$2(QQServiceForAV.QQServiceForAVBinder paramQQServiceForAVBinder) {}
  
  public void binderDied()
  {
    AVLog.printAllUserLog("QQServiceForAV", "binderDied, video process died!");
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a.a();
    if (localQQAppInterface != null) {
      localQQAppInterface.mQQServiceRef = null;
    }
    try
    {
      this.a.a();
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("linkToDeath stopPumpMessage exception msg = ");
      ((StringBuilder)localObject2).append(localRemoteException.getMessage());
      AVLog.printErrorLog("QQServiceForAV", ((StringBuilder)localObject2).toString());
    }
    if ((TextUtils.isEmpty(this.a.a.e)) && (localQQAppInterface != null)) {
      this.a.a.e = localQQAppInterface.getCurrentAccountUin();
    }
    Object localObject3 = this.a.a.d;
    String str = this.a.a.e;
    Object localObject1;
    if ((this.a.a.a != 1004) && (this.a.a.a != 1000) && (this.a.a.a != 1020))
    {
      localObject1 = localObject3;
      localObject2 = str;
      if (this.a.a.a == 1006)
      {
        localObject1 = localObject3;
        localObject2 = str;
        if (!((String)localObject3).startsWith("+"))
        {
          localObject1 = this.a.a.f;
          localObject2 = str;
        }
      }
    }
    else
    {
      localObject2 = this.a.a.f;
      localObject1 = localObject3;
    }
    int i;
    if ((localQQAppInterface != null) && (localQQAppInterface.isVideoChatting()))
    {
      AVLog.printAllUserLog("QQServiceForAV", "video chatting!");
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("linkToVideoProcessDeath-->uinType=");
      ((StringBuilder)localObject3).append(this.a.a.a);
      ((StringBuilder)localObject3).append(" friendUin=");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(" senderUin=");
      ((StringBuilder)localObject3).append((String)localObject2);
      AVLog.printAllUserLog("QQServiceForAV", ((StringBuilder)localObject3).toString());
      if ((localObject1 != null) && (((String)localObject1).length() > 2)) {
        i = 1;
      } else {
        i = 0;
      }
      if ((this.a.a.o) && (i != 0)) {
        VideoMsgTools.a(localQQAppInterface, this.a.a.a, 45, true, (String)localObject1, (String)localObject2, true, null, true, new Object[0]);
      }
    }
    if (QQServiceForAV.a(this.a.a))
    {
      if (localQQAppInterface != null)
      {
        VideoUtils.a("MobileQQ:BootAction", 5000L);
        localObject1 = new Intent("com.tencent.av.ui.VChatActivity");
        ((Intent)localObject1).putExtra("uin", localQQAppInterface.getCurrentUin());
        ((Intent)localObject1).putExtra("type", 1);
        ((Intent)localObject1).putExtra("processExitTimestamp", System.currentTimeMillis());
        ((Intent)localObject1).putExtra("source", 1);
        ((Intent)localObject1).setPackage(this.a.a.getPackageName());
        ((Intent)localObject1).setFlags(32);
        this.a.a.sendBroadcast((Intent)localObject1);
      }
      QQServiceForAV.a(this.a.a, false);
    }
    Object localObject2 = new Intent();
    ((Intent)localObject2).setAction("tencent.av.v2q.StopVideoChat");
    ((Intent)localObject2).putExtra("uinType", this.a.a.a);
    ((Intent)localObject2).putExtra("bindType", this.a.a.b);
    ((Intent)localObject2).putExtra("bindId", this.a.a.c);
    ((Intent)localObject2).putExtra("peerUin", this.a.a.d);
    ((Intent)localObject2).putExtra("extraUin", this.a.a.f);
    ((Intent)localObject2).putExtra("stopReason", 0);
    if (localQQAppInterface == null) {
      localObject1 = Integer.valueOf(0);
    } else {
      localObject1 = localQQAppInterface.getCurrentUin();
    }
    ((Intent)localObject2).putExtra("selfUin", (Serializable)localObject1);
    ((Intent)localObject2).setPackage(this.a.a.getApplication().getPackageName());
    if ((this.a.a.d != null) && ((this.a.a.a != 1006) || (this.a.a.f != null)))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ACTION_STOP_VIDEO_CHAT, stopReason = VideoConstants.CLOSE_DOUBLE, mUinType = ");
      ((StringBuilder)localObject1).append(this.a.a.a);
      ((StringBuilder)localObject1).append(", peerUin = ");
      ((StringBuilder)localObject1).append(this.a.a.d);
      AVLog.printAllUserLog("QQServiceForAV", ((StringBuilder)localObject1).toString());
      this.a.a.sendBroadcast((Intent)localObject2);
    }
    if (localQQAppInterface != null)
    {
      long l1 = localQQAppInterface.getAVNotifyCenter().g();
      i = localQQAppInterface.getAVNotifyCenter().h();
      int j = (int)localQQAppInterface.getAVNotifyCenter().c(i, l1);
      if ((l1 > 0L) && (this.a.a.o))
      {
        long l2 = Long.valueOf(localQQAppInterface.getCurrentAccountUin()).longValue();
        localObject1 = new Intent();
        ((Intent)localObject1).setAction("tencent.av.v2q.MultiVideo");
        ((Intent)localObject1).putExtra("type", 23);
        ((Intent)localObject1).putExtra("friendUin", l2);
        ((Intent)localObject1).putExtra("relationType", i);
        ((Intent)localObject1).putExtra("relationId", l1);
        ((Intent)localObject1).putExtra("from", "QQServiceForAV");
        ((Intent)localObject1).putExtra("MultiAVType", localQQAppInterface.getAVNotifyCenter().e(l1));
        if (j > 1) {
          ((Intent)localObject1).putExtra("roomUserNum", j - 1);
        } else {
          ((Intent)localObject1).putExtra("roomUserNum", 0);
        }
        ((Intent)localObject1).setPackage(this.a.a.getApplication().getPackageName());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("linkToVideoProcessDeath MULTI_VIDEO_V2Q -->uinType=");
        ((StringBuilder)localObject2).append(this.a.a.a);
        ((StringBuilder)localObject2).append(" roomNum=");
        ((StringBuilder)localObject2).append(j);
        AVLog.printAllUserLog("QQServiceForAV", ((StringBuilder)localObject2).toString());
        this.a.a.sendBroadcast((Intent)localObject1);
      }
      this.a.a.o = false;
      localQQAppInterface.getAVNotifyCenter().a(0, 0);
    }
    QAVNotification.a(this.a.a.getApplicationContext());
    ((IVideoProcessMonitor)QRoute.api(IVideoProcessMonitor.class)).clearMonitorBinder();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.service.QQServiceForAV.QQServiceForAVBinder.2
 * JD-Core Version:    0.7.0.1
 */