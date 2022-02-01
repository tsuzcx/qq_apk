package com.tencent.biz.troop;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class TroopMemberApiClient$1
  implements ServiceConnection
{
  TroopMemberApiClient$1(TroopMemberApiClient paramTroopMemberApiClient) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder arg2)
  {
    try
    {
      paramComponentName = new Messenger(???);
      if (QLog.isColorLevel()) {
        QLog.i("com.tencent.biz.troop.TroopMemberApiClient", 2, "ServiceConnection Attached.");
      }
      ??? = Message.obtain(null, 1);
      ???.replyTo = this.a.b;
      Object localObject = new Bundle();
      ((Bundle)localObject).putString("processName", TroopMemberApiClient.d());
      ???.obj = localObject;
      paramComponentName.send(???);
      synchronized (this.a)
      {
        this.a.c = paramComponentName;
        localObject = new ArrayList(this.a.f);
        this.a.f.clear();
        if (((List)localObject).size() > 0)
        {
          ??? = ((List)localObject).iterator();
          if (???.hasNext()) {
            paramComponentName.send((Message)???.next());
          }
        }
      }
      return;
    }
    catch (Exception paramComponentName)
    {
      if (QLog.isColorLevel()) {
        QLog.e("com.tencent.biz.troop.TroopMemberApiClient", 2, paramComponentName.getMessage());
      }
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    paramComponentName = this.a;
    paramComponentName.c = null;
    paramComponentName.h.clear();
    if (QLog.isColorLevel()) {
      QLog.i("com.tencent.biz.troop.TroopMemberApiClient", 2, "Disconnected.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiClient.1
 * JD-Core Version:    0.7.0.1
 */