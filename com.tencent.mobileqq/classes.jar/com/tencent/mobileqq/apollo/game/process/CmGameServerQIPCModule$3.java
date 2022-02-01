package com.tencent.mobileqq.apollo.game.process;

import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class CmGameServerQIPCModule$3
  implements EIPCResultCallback
{
  CmGameServerQIPCModule$3(CmGameServerQIPCModule paramCmGameServerQIPCModule) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    QLog.i("cmgame_process.CmGameServerQIPCModule", 1, "CmShow onDressChanged send!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.CmGameServerQIPCModule.3
 * JD-Core Version:    0.7.0.1
 */