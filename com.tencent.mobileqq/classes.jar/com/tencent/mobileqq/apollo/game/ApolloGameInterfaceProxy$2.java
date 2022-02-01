package com.tencent.mobileqq.apollo.game;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class ApolloGameInterfaceProxy$2
  implements EIPCResultCallback
{
  ApolloGameInterfaceProxy$2(ApolloGameInterfaceProxy paramApolloGameInterfaceProxy) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameInterfaceProxy", 2, "get_open_key_back");
      }
      paramEIPCResult = paramEIPCResult.data.getString("respData");
      ApolloGameInterfaceProxy.a(this.a, "cs.on_get_open_key.local", paramEIPCResult);
      return;
    }
    catch (Throwable paramEIPCResult)
    {
      QLog.e("ApolloGameInterfaceProxy", 1, paramEIPCResult, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameInterfaceProxy.2
 * JD-Core Version:    0.7.0.1
 */