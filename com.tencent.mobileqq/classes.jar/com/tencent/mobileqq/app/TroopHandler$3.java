package com.tencent.mobileqq.app;

import com.tencent.mobileqq.troop.data.TroopAioKeywordHelper;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.AioKeyword;

class TroopHandler$3
  implements Runnable
{
  TroopHandler$3(TroopHandler paramTroopHandler, oidb_0x496.AioKeyword paramAioKeyword) {}
  
  public void run()
  {
    ((TroopAioKeywordTipManager)TroopHandler.a(this.this$0).getManager(QQManagerFactory.TROOP_AIO_KEYWORD_TIP_MANAGER)).a(TroopAioKeywordHelper.a(this.a), TroopAioKeywordHelper.b(this.a));
    TroopAioKeywordHelper.a(TroopHandler.a(this.this$0), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopHandler.3
 * JD-Core Version:    0.7.0.1
 */