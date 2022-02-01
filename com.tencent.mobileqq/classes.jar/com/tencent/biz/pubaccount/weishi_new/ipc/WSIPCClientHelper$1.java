package com.tencent.biz.pubaccount.weishi_new.ipc;

import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

class WSIPCClientHelper$1
  implements EIPClientConnectListener
{
  WSIPCClientHelper$1(WSIPCClientHelper paramWSIPCClientHelper) {}
  
  public void connectFailed()
  {
    WSIPCClientHelper.a(this.a, false);
    WSLog.e("WSIPCClientHelper", "connectFailed");
  }
  
  public void connectSuccess(EIPCConnection paramEIPCConnection)
  {
    WSIPCClientHelper.a(this.a, true);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("connectSuccess ");
    if (paramEIPCConnection == null) {
      paramEIPCConnection = null;
    } else {
      paramEIPCConnection = paramEIPCConnection.procName;
    }
    localStringBuilder.append(paramEIPCConnection);
    WSLog.e("WSIPCClientHelper", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.ipc.WSIPCClientHelper.1
 * JD-Core Version:    0.7.0.1
 */