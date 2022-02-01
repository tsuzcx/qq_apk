package com.tencent.av.service;

import android.content.Intent;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.tencent.mobileqq.app.GVideoObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class QQServiceForAV$8
  extends GVideoObserver
{
  QQServiceForAV$8(QQServiceForAV paramQQServiceForAV) {}
  
  protected void a(Object arg1)
  {
    ??? = (Object[])???;
    RecvGVideoLevelInfo[] arrayOfRecvGVideoLevelInfo = new RecvGVideoLevelInfo[???.length];
    int j = 0;
    int i = 0;
    while (i < arrayOfRecvGVideoLevelInfo.length)
    {
      arrayOfRecvGVideoLevelInfo[i] = ((RecvGVideoLevelInfo)???[i]);
      i += 1;
    }
    synchronized (this.a.m)
    {
      int k = this.a.m.beginBroadcast();
      i = j;
      for (;;)
      {
        if (i < k) {
          try
          {
            ((IQQServiceCallback)this.a.m.getBroadcastItem(i)).a(arrayOfRecvGVideoLevelInfo);
            i += 1;
          }
          catch (RemoteException localRemoteException)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQServiceForAV", 2, "callBack RemoteException", localRemoteException);
            }
          }
        }
      }
      this.a.m.finishBroadcast();
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4, int paramInt5, long paramLong)
  {
    paramString3 = (QQAppInterface)this.a.a();
    if (paramBoolean)
    {
      paramString4 = new Intent();
      paramString4.setAction("tencent.video.v2q.hide.webConfig");
      paramString4.putExtra("troopUin", paramString1);
      paramString4.putExtra("color", paramInt1);
      paramString4.putExtra("url", paramString2);
      paramString4.putExtra("grayFlag", paramInt2);
      paramString3.getApp().sendBroadcast(paramString4);
    }
    paramString3.removeObserver(this.a.r);
  }
  
  protected void a(boolean paramBoolean1, String paramString, int paramInt1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2, int paramInt3)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    String str = localQQAppInterface.getApp().getString(paramInt1);
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, String.format("onJoinOrExitOpenTroop --> success: %b, troopUin: %s, errorTips: %s isJoin: %b , visitorSpeakEnabled: %b, speakInterval: %d, startSpeakInterval: %d", new Object[] { Boolean.valueOf(paramBoolean1), paramString, str, Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    }
    if (paramBoolean2)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.video.q2v.JoinOpenGroup");
      localIntent.putExtra("troopUin", paramString);
      localIntent.putExtra("success", paramBoolean1);
      localIntent.putExtra("errorTips", str);
      localIntent.putExtra("visitorSpeakEnabled", paramBoolean3);
      localIntent.putExtra("speakInterval", paramInt2);
      localIntent.putExtra("startSpeakInterval", paramInt3);
      localQQAppInterface.getApp().sendBroadcast(localIntent);
    }
    localQQAppInterface.removeObserver(this.a.r);
  }
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QQServiceForAV, onGetFollowStatus:");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramBoolean2);
      QLog.d("nearby.video.follow", 2, ((StringBuilder)localObject).toString());
    }
    label222:
    synchronized (this.a.m)
    {
      int j = this.a.m.beginBroadcast();
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          if (!paramBoolean2) {
            break label222;
          }
          localObject = "1";
          try
          {
            ((IQQServiceCallback)this.a.m.getBroadcastItem(i)).a(paramBoolean1, paramString, (String)localObject, "getFollowStatus");
            i += 1;
          }
          catch (RemoteException paramString)
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("QQServiceForAV, onGetFollowStatus:");
              ((StringBuilder)localObject).append(paramString.toString());
              QLog.e("nearby.video.follow", 2, ((StringBuilder)localObject).toString());
            }
          }
        }
      }
      this.a.m.finishBroadcast();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.service.QQServiceForAV.8
 * JD-Core Version:    0.7.0.1
 */