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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mBindVideoProcessConn onServiceConnected name=");
    localStringBuilder.append(paramComponentName);
    localStringBuilder.append(", service=");
    localStringBuilder.append(paramIBinder);
    QLog.i("QQServiceForAV", 1, localStringBuilder.toString());
    QQServiceForAV.b(this.a, true);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mBindVideoProcessConn onServiceDisconnected name=");
    localStringBuilder.append(paramComponentName);
    QLog.i("QQServiceForAV", 1, localStringBuilder.toString());
    QQServiceForAV.b(this.a, false);
    try
    {
      BaseApplicationImpl.getContext().unbindService(this);
      return;
    }
    catch (Throwable paramComponentName)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onServiceDisconnected disconnect exception:");
      localStringBuilder.append(paramComponentName);
      QLog.e("QQServiceForAV", 1, localStringBuilder.toString(), paramComponentName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.service.QQServiceForAV.5
 * JD-Core Version:    0.7.0.1
 */