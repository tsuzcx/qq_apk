package com.tencent.av.service;

import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.qphone.base.util.QLog;

class QQServiceForAV$QQServiceForAVBinder$1
  extends ProtoUtils.TroopProtocolObserver
{
  QQServiceForAV$QQServiceForAVBinder$1(QQServiceForAV.QQServiceForAVBinder paramQQServiceForAVBinder, String paramString, int paramInt) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle arg3)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ???.append("sendNearbyVideoChatPbReq, cmd ");
      ???.append(this.a);
      ???.append("==>onResult, errorCode:");
      ???.append(paramInt);
      QLog.d("QQServiceForAVQ.nearby.video_chat", 2, ???.toString());
    }
    synchronized (this.c.a.m)
    {
      int j = this.c.a.m.beginBroadcast();
      int i = 0;
      for (;;)
      {
        if (i < j) {
          try
          {
            ((IQQServiceCallback)this.c.a.m.getBroadcastItem(i)).a(this.a, this.b, paramInt, paramArrayOfByte);
            i += 1;
          }
          catch (RemoteException paramArrayOfByte)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQServiceForAVQ.nearby.video_chat", 2, "callBack RemoteException", paramArrayOfByte);
            }
          }
        }
      }
      this.c.a.m.finishBroadcast();
      return;
    }
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.service.QQServiceForAV.QQServiceForAVBinder.1
 * JD-Core Version:    0.7.0.1
 */