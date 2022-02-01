package com.tencent.av.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qphone.base.util.QLog;

class QavWrapper$QavServiceConnection
  implements ServiceConnection
{
  QavWrapper$QavServiceConnection(QavWrapper paramQavWrapper) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavWrapper", 2, "Qav Service connected!");
    }
    this.a.a = IAVServiceForQQ.Stub.a(paramIBinder);
    if ((this.a.a != null) && (this.a.c != null))
    {
      this.a.c.a(this.a);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QavWrapper", 2, "mQavProxy == null or mOnReadyListener == null");
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavWrapper", 2, "Qav Service disconnected!");
    }
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.service.QavWrapper.QavServiceConnection
 * JD-Core Version:    0.7.0.1
 */