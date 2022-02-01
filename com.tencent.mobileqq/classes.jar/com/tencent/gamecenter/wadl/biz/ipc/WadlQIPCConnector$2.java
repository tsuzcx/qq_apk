package com.tencent.gamecenter.wadl.biz.ipc;

import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class WadlQIPCConnector$2
  implements EIPClientConnectListener
{
  WadlQIPCConnector$2(WadlQIPCConnector paramWadlQIPCConnector, long paramLong) {}
  
  public void connectFailed()
  {
    WadlQIPCConnector.a(this.b, false);
    WadlQIPCConnector.b(this.b, false);
    synchronized (WadlQIPCConnector.a(this.b))
    {
      WadlQIPCConnector.a(this.b).notifyAll();
      ??? = new StringBuilder();
      ((StringBuilder)???).append("connectFailed:");
      ((StringBuilder)???).append(WadlQIPCConnector.b(this.b));
      QLog.d("Wadl_QIPCConnector", 1, ((StringBuilder)???).toString());
      return;
    }
  }
  
  public void connectSuccess(EIPCConnection arg1)
  {
    long l = System.currentTimeMillis();
    if (??? != null) {
      WadlQIPCConnector.a(this.b, ???.procName);
    }
    WadlQIPCConnector.a(this.b, true);
    WadlQIPCConnector.b(this.b, false);
    synchronized (WadlQIPCConnector.a(this.b))
    {
      WadlQIPCConnector.a(this.b).notifyAll();
      ??? = new StringBuilder();
      ???.append("connectSuccess:");
      ???.append(WadlQIPCConnector.b(this.b));
      ???.append("|");
      ???.append(l - this.a);
      QLog.d("Wadl_QIPCConnector", 1, ???.toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.ipc.WadlQIPCConnector.2
 * JD-Core Version:    0.7.0.1
 */