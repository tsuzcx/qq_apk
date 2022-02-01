package com.tencent.mobileqq.ark.api.scheme;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;

class TroopArkHelper$3
  implements Runnable
{
  TroopArkHelper$3(TroopArkHelper paramTroopArkHelper, TroopInfo paramTroopInfo) {}
  
  public void run()
  {
    ((TroopManager)this.this$0.a().getManager(QQManagerFactory.TROOP_MANAGER)).b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.scheme.TroopArkHelper.3
 * JD-Core Version:    0.7.0.1
 */