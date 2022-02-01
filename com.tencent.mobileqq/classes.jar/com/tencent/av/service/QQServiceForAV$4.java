package com.tencent.av.service;

import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

class QQServiceForAV$4
  implements BusinessObserver
{
  QQServiceForAV$4(QQServiceForAV paramQQServiceForAV, String paramString1, String paramString2) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle arg3)
  {
    paramInt = 0;
    String str = "";
    Object localObject2 = str;
    boolean bool = paramBoolean;
    int i;
    Object localObject3;
    if (paramBoolean)
    {
      try
      {
        localObject2 = ???.getByteArray("data");
        ??? = str;
        if (localObject2 != null)
        {
          ??? = new WebSsoBody.WebSsoResponseBody();
          ???.mergeFrom((byte[])localObject2);
          i = ???.ret.get();
          ??? = new JSONObject(???.data.get());
          if (i != 0)
          {
            ??? = ???.optString("msg");
          }
          else
          {
            ???.getJSONObject("result");
            i = ???.optInt("retcode");
            localObject2 = str;
            bool = paramBoolean;
            if (i == 0) {
              break label175;
            }
            ??? = str;
          }
        }
      }
      catch (Exception localException)
      {
        ??? = str;
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ???.append("QQServiceForAV, followUser 2:");
          ???.append(localException.toString());
          QLog.e("nearby.video.follow", 2, ???.toString());
          ??? = str;
        }
      }
      bool = false;
      localObject3 = ???;
    }
    label175:
    synchronized (this.c.m)
    {
      i = this.c.m.beginBroadcast();
      for (;;)
      {
        if (paramInt < i) {
          try
          {
            ((IQQServiceCallback)this.c.m.getBroadcastItem(paramInt)).a(bool, this.a, this.b, (String)localObject3);
            paramInt += 1;
          }
          catch (RemoteException localRemoteException)
          {
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("QQServiceForAV, followUser 3:");
              ((StringBuilder)localObject3).append(localRemoteException.toString());
              QLog.e("nearby.video.follow", 2, ((StringBuilder)localObject3).toString());
            }
          }
        }
      }
      this.c.m.finishBroadcast();
      return;
    }
    for (;;)
    {
      throw localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.service.QQServiceForAV.4
 * JD-Core Version:    0.7.0.1
 */