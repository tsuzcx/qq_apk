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
    paramComponentName.jdField_a_of_type_Boolean = false;
    paramComponentName.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV = IQQServiceForAV.Stub.a(paramIBinder);
    try
    {
      this.a.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(this.a.jdField_a_of_type_ComTencentAvServiceIQQServiceCallback$Stub, "video_process_cookie");
      if (this.a.b) {
        this.a.e();
      }
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(10) });
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
      this.a.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.asBinder().linkToDeath(new QQServiceProxy.QQServiceForAVConnection.1(this), 0);
    }
    catch (Exception paramComponentName)
    {
      paramIBinder = new StringBuilder();
      paramIBinder.append("QQServiceForAV onServiceConnected Exception msg = ");
      paramIBinder.append(paramComponentName.getMessage());
      AVLog.printErrorLog("QQServiceProxy", paramIBinder.toString());
    }
    if ((this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a != null)) {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().E();
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceProxy", 2, "QQServiceForAV onServiceDisconnected");
    }
    try
    {
      if (this.a.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {
        this.a.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.a(this.a.jdField_a_of_type_ComTencentAvServiceIQQServiceCallback$Stub);
      }
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(11) });
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().deleteObservers();
    }
    catch (RemoteException paramComponentName)
    {
      QLog.e("QQServiceProxy", 2, "QQServiceForAV onServiceDisconnected RemoteException", paramComponentName);
    }
    this.a.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.QQServiceProxy.QQServiceForAVConnection
 * JD-Core Version:    0.7.0.1
 */