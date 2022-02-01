package com.tencent.aelight.camera.aioeditor.editipc;

import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class PeakIpcModuleClient$1
  implements EIPClientConnectListener
{
  PeakIpcModuleClient$1(PeakIpcModuleClient paramPeakIpcModuleClient) {}
  
  public void connectFailed()
  {
    PeakIpcModuleClient.a(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.d("PeakIpcModuleClient", 2, "connectFailed!");
    }
  }
  
  public void connectSuccess(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection != null) {
      PeakIpcModuleClient.a(this.a, paramEIPCConnection.procName);
    }
    PeakIpcModuleClient.a(this.a, true);
    if (QLog.isColorLevel())
    {
      paramEIPCConnection = new StringBuilder();
      paramEIPCConnection.append("connectSuccess:");
      paramEIPCConnection.append(PeakIpcModuleClient.a(this.a));
      QLog.d("PeakIpcModuleClient", 2, paramEIPCConnection.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.editipc.PeakIpcModuleClient.1
 * JD-Core Version:    0.7.0.1
 */