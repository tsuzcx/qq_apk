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
    WadlQIPCConnector.a(this.jdField_a_of_type_ComTencentGamecenterWadlBizIpcWadlQIPCConnector, false);
    WadlQIPCConnector.b(this.jdField_a_of_type_ComTencentGamecenterWadlBizIpcWadlQIPCConnector, false);
    synchronized (WadlQIPCConnector.a(this.jdField_a_of_type_ComTencentGamecenterWadlBizIpcWadlQIPCConnector))
    {
      WadlQIPCConnector.a(this.jdField_a_of_type_ComTencentGamecenterWadlBizIpcWadlQIPCConnector).notifyAll();
      ??? = new StringBuilder();
      ((StringBuilder)???).append("connectFailed:");
      ((StringBuilder)???).append(WadlQIPCConnector.a(this.jdField_a_of_type_ComTencentGamecenterWadlBizIpcWadlQIPCConnector));
      QLog.d("Wadl_QIPCConnector", 1, ((StringBuilder)???).toString());
      return;
    }
  }
  
  public void connectSuccess(EIPCConnection arg1)
  {
    long l = System.currentTimeMillis();
    if (??? != null) {
      WadlQIPCConnector.a(this.jdField_a_of_type_ComTencentGamecenterWadlBizIpcWadlQIPCConnector, ???.procName);
    }
    WadlQIPCConnector.a(this.jdField_a_of_type_ComTencentGamecenterWadlBizIpcWadlQIPCConnector, true);
    WadlQIPCConnector.b(this.jdField_a_of_type_ComTencentGamecenterWadlBizIpcWadlQIPCConnector, false);
    synchronized (WadlQIPCConnector.a(this.jdField_a_of_type_ComTencentGamecenterWadlBizIpcWadlQIPCConnector))
    {
      WadlQIPCConnector.a(this.jdField_a_of_type_ComTencentGamecenterWadlBizIpcWadlQIPCConnector).notifyAll();
      ??? = new StringBuilder();
      ???.append("connectSuccess:");
      ???.append(WadlQIPCConnector.a(this.jdField_a_of_type_ComTencentGamecenterWadlBizIpcWadlQIPCConnector));
      ???.append("|");
      ???.append(l - this.jdField_a_of_type_Long);
      QLog.d("Wadl_QIPCConnector", 1, ???.toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.ipc.WadlQIPCConnector.2
 * JD-Core Version:    0.7.0.1
 */