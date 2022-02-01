package com.tencent.avbiz;

import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onConnectUnbind, [");
      ((StringBuilder)localObject).append(paramEIPCConnection.procName);
      ((StringBuilder)localObject).append("]");
      QLog.i("AVBizServerQIPCModule", 2, ((StringBuilder)localObject).toString());
    }
    paramEIPCConnection = (Set)Constants.PROCESS_BIZ_NAME_MAP.get(paramEIPCConnection.procName);
    if (paramEIPCConnection != null)
    {
      paramEIPCConnection = paramEIPCConnection.iterator();
      while (paramEIPCConnection.hasNext())
      {
        localObject = (String)paramEIPCConnection.next();
        AVBizPriorityManager.getInstance().abandonAVFocus((String)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avbiz.AVBizServerQIPCModule.1
 * JD-Core Version:    0.7.0.1
 */