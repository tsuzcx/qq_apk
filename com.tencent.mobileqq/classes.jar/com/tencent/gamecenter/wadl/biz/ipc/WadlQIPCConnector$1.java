package com.tencent.gamecenter.wadl.biz.ipc;

import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;

class WadlQIPCConnector$1
  implements EIPCOnGetConnectionListener
{
  WadlQIPCConnector$1(WadlQIPCConnector paramWadlQIPCConnector) {}
  
  public void onConnectBind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      WadlQIPCConnector.a(this.a, paramEIPCConnection.procName);
    }
    WadlQIPCConnector.a(this.a, true);
    if (QLog.isColorLevel()) {
      QLog.d("WadlQIPCConnector", 2, "onConnectBind");
    }
  }
  
  public void onConnectUnbind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      WadlQIPCConnector.a(this.a, paramEIPCConnection.procName);
    }
    WadlQIPCConnector.a(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.d("WadlQIPCConnector", 2, "onConnectUnbind");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.ipc.WadlQIPCConnector.1
 * JD-Core Version:    0.7.0.1
 */