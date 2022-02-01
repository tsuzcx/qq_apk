package com.tencent.avbiz;

import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;
import java.util.HashMap;

class AVBizServerQIPCModule$1
  implements EIPCOnGetConnectionListener
{
  AVBizServerQIPCModule$1(AVBizServerQIPCModule paramAVBizServerQIPCModule) {}
  
  public void onConnectBind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onConnectBind, [");
      localStringBuilder.append(paramEIPCConnection.procName);
      localStringBuilder.append("]");
      QLog.i("AVBizServerQIPCModule", 2, localStringBuilder.toString());
    }
  }
  
  public void onConnectUnbind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onConnectUnbind, [");
      localStringBuilder.append(paramEIPCConnection.procName);
      localStringBuilder.append("]");
      QLog.i("AVBizServerQIPCModule", 2, localStringBuilder.toString());
    }
    paramEIPCConnection = (String)Constants.b.get(paramEIPCConnection.procName);
    if (paramEIPCConnection != null) {
      AVBizPriorityManager.a().a(paramEIPCConnection);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avbiz.AVBizServerQIPCModule.1
 * JD-Core Version:    0.7.0.1
 */