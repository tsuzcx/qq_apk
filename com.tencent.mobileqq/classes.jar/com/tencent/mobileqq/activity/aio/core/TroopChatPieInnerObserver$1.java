package com.tencent.mobileqq.activity.aio.core;

import agbv;
import mqq.os.MqqHandler;
import nty;
import nud;

public class TroopChatPieInnerObserver$1
  implements Runnable
{
  public TroopChatPieInnerObserver$1(agbv paramagbv) {}
  
  public void run()
  {
    if (agbv.a(this.this$0).a != null) {
      agbv.a(this.this$0).a.dismiss();
    }
    agbv.a(this.this$0).c(true);
    agbv.a(this.this$0).uiHandler.postDelayed(new TroopChatPieInnerObserver.1.1(this), 100L);
    if (!nty.a(agbv.a(this.this$0), agbv.a(this.this$0))) {
      agbv.a(this.this$0).uiHandler.postDelayed(new TroopChatPieInnerObserver.1.2(this), 200L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPieInnerObserver.1
 * JD-Core Version:    0.7.0.1
 */