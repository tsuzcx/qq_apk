package com.tencent.av.app;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.av.service.IAVServiceForQQ.Stub;
import com.tencent.qphone.base.util.QLog;

class AVServiceProxy$AVServiceForQQConnection
  implements ServiceConnection
{
  AVServiceProxy$AVServiceForQQConnection(AVServiceProxy paramAVServiceProxy) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.d(AVServiceProxy.c(), 2, "AVServiceForQQ onServiceConnected");
    }
    this.a.b = IAVServiceForQQ.Stub.a(paramIBinder);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.d(AVServiceProxy.c(), 2, "AVServiceForQQ onServiceDisconnected");
    }
    this.a.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.AVServiceProxy.AVServiceForQQConnection
 * JD-Core Version:    0.7.0.1
 */