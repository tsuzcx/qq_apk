package com.tencent.av.app;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.service.IQQServiceForAV;
import com.tencent.av.service.IQQServiceForAV.Stub;
import com.tencent.qphone.base.util.QLog;

class QQServiceProxy$QQServiceForAVConnection
  implements ServiceConnection
{
  QQServiceProxy$QQServiceForAVConnection(QQServiceProxy paramQQServiceProxy) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQServiceForAV onServiceConnected, name[");
    localStringBuilder.append(paramComponentName);
    localStringBuilder.append("]");
    QLog.w("QQServiceProxy", 1, localStringBuilder.toString());
    paramComponentName = this.a;
    paramComponentName.b = false;
    paramComponentName.c = IQQServiceForAV.Stub.a(paramIBinder);
    try
    {
      this.a.c.a(this.a.e, "video_process_cookie");
      if (this.a.f) {
        this.a.k();
      }
      this.a.a.a(new Object[] { Integer.valueOf(10) });
    }
    catch (RemoteException paramComponentName)
    {
      paramIBinder = new StringBuilder();
      paramIBinder.append("QQServiceForAV onServiceConnected Exception msg = ");
      paramIBinder.append(paramComponentName.getMessage());
      AVLog.printErrorLog("QQServiceProxy", paramIBinder.toString());
    }
    try
    {
      this.a.c.asBinder().linkToDeath(new QQServiceProxy.QQServiceForAVConnection.1(this), 0);
    }
    catch (Exception paramComponentName)
    {
      paramIBinder = new StringBuilder();
      paramIBinder.append("QQServiceForAV onServiceConnected Exception msg = ");
      paramIBinder.append(paramComponentName.getMessage());
      AVLog.printErrorLog("QQServiceProxy", paramIBinder.toString());
    }
    if ((this.a.a != null) && (this.a.a.c != null)) {
      this.a.a.b().ax();
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceProxy", 2, "QQServiceForAV onServiceDisconnected");
    }
    try
    {
      if (this.a.c != null) {
        this.a.c.a(this.a.e);
      }
      this.a.a.a(new Object[] { Integer.valueOf(11) });
      this.a.a.e().deleteObservers();
    }
    catch (RemoteException paramComponentName)
    {
      QLog.e("QQServiceProxy", 2, "QQServiceForAV onServiceDisconnected RemoteException", paramComponentName);
    }
    this.a.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.QQServiceProxy.QQServiceForAVConnection
 * JD-Core Version:    0.7.0.1
 */