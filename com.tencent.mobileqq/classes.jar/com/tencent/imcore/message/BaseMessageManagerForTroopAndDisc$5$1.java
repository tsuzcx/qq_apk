package com.tencent.imcore.message;

import com.tencent.mobileqq.msg.api.IMessageFacade;
import java.util.Map;

class BaseMessageManagerForTroopAndDisc$5$1
  implements Runnable
{
  BaseMessageManagerForTroopAndDisc$5$1(BaseMessageManagerForTroopAndDisc.5 param5) {}
  
  public void run()
  {
    if (this.a.this$0.b.getRefreshActionMap().containsKey(UinTypeUtil.a(this.a.b, this.a.c))) {
      this.a.this$0.b.getRefreshActionMap().remove(UinTypeUtil.a(this.a.b, this.a.c));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc.5.1
 * JD-Core Version:    0.7.0.1
 */