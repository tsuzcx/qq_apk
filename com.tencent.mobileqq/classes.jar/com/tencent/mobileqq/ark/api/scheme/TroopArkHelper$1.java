package com.tencent.mobileqq.ark.api.scheme;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopFileHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopBatchInfohandler;
import com.tencent.mobileqq.troop.plugin.TroopPluginCallback;

class TroopArkHelper$1
  implements TroopPluginCallback
{
  TroopArkHelper$1(TroopArkHelper paramTroopArkHelper, QQAppInterface paramQQAppInterface) {}
  
  public void onInstallFinish(int paramInt)
  {
    if (paramInt == 0)
    {
      this.a.addObserver(this.b.b);
      ((ITroopBatchInfohandler)this.a.getBusinessHandler(BusinessHandlerFactory.TROOP_BATCH_INFO_HANDLER)).a(TroopFileHandler.a(this.b.a), true, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.scheme.TroopArkHelper.1
 * JD-Core Version:    0.7.0.1
 */