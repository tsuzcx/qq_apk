package com.tencent.av.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class QQServiceForAV$5
  implements ServiceConnection
{
  QQServiceForAV$5(QQServiceForAV paramQQServiceForAV) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    QLog.i("QQServiceForAV", 1, "mBindVideoProcessConn onServiceConnected name=" + paramComponentName + ", service=" + paramIBinder);
    QQServiceForAV.b(this.a, true);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    QLog.i("QQServiceForAV", 1, "mBindVideoProcessConn onServiceDisconnected name=" + paramComponentName);
    QQServiceForAV.b(this.a, false);
    try
    {
      BaseApplicationImpl.getContext().unbindService(this);
      return;
    }
    catch (Throwable paramComponentName)
    {
      QLog.e("QQServiceForAV", 1, "onServiceDisconnected disconnect exception:" + paramComponentName, paramComponentName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.service.QQServiceForAV.5
 * JD-Core Version:    0.7.0.1
 */