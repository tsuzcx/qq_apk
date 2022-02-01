package com.tencent.av.wtogether.util;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.av.service.IQQServiceForAV.Stub;
import com.tencent.qphone.base.util.QLog;

class CallStatusClient$1
  implements ServiceConnection
{
  CallStatusClient$1(CallStatusClient paramCallStatusClient) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.d(CallStatusClient.f(), 2, String.format("onServiceConnected name=%s service=%s", new Object[] { paramComponentName, paramIBinder }));
    }
    CallStatusClient.a(this.a, IQQServiceForAV.Stub.a(paramIBinder));
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.d(CallStatusClient.f(), 2, String.format("onServiceDisconnected name=%s", new Object[] { paramComponentName }));
    }
    CallStatusClient.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.util.CallStatusClient.1
 * JD-Core Version:    0.7.0.1
 */