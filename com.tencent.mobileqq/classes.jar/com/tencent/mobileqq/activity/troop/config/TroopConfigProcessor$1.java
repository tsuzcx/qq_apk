package com.tencent.mobileqq.activity.troop.config;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.troop.data.TroopAioKeywordHelper;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.AioKeyword;

class TroopConfigProcessor$1
  implements Runnable
{
  TroopConfigProcessor$1(TroopConfigProcessor paramTroopConfigProcessor, QQAppInterface paramQQAppInterface, oidb_0x496.AioKeyword paramAioKeyword) {}
  
  public void run()
  {
    ((TroopAioKeywordTipManager)this.a.getManager(QQManagerFactory.TROOP_AIO_KEYWORD_TIP_MANAGER)).a(TroopAioKeywordHelper.a(this.b), TroopAioKeywordHelper.b(this.b));
    TroopAioKeywordHelper.a(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.config.TroopConfigProcessor.1
 * JD-Core Version:    0.7.0.1
 */