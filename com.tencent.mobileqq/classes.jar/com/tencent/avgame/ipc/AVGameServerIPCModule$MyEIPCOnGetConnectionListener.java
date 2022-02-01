package com.tencent.avgame.ipc;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;

class AVGameServerIPCModule$MyEIPCOnGetConnectionListener
  implements EIPCOnGetConnectionListener
{
  public void onConnectBind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection == null) {}
    do
    {
      return;
      if (QLog.isDevelopLevel()) {
        QLog.i("AVGameServerIPCModule", 4, "onConnectBind, [" + paramEIPCConnection.procName + "]");
      }
    } while (!TextUtils.equals(paramEIPCConnection.procName, "com.tencent.mobileqq:avgame"));
    AVGameServerIPCModule.a(1);
  }
  
  public void onConnectUnbind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection == null) {}
    do
    {
      return;
      if (QLog.isDevelopLevel()) {
        QLog.i("AVGameServerIPCModule", 4, "onConnectUnbind, [" + paramEIPCConnection.procName + "]");
      }
    } while (!TextUtils.equals(paramEIPCConnection.procName, "com.tencent.mobileqq:avgame"));
    AVGameServerIPCModule.a(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ipc.AVGameServerIPCModule.MyEIPCOnGetConnectionListener
 * JD-Core Version:    0.7.0.1
 */