package com.tencent.mobileqq.ark.API;

import apwe;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;

public class TroopArkHelper$3
  implements Runnable
{
  public TroopArkHelper$3(apwe paramapwe, TroopInfo paramTroopInfo) {}
  
  public void run()
  {
    ((TroopManager)this.this$0.a().getManager(QQManagerFactory.TROOP_MANAGER)).b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.TroopArkHelper.3
 * JD-Core Version:    0.7.0.1
 */