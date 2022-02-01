package com.tencent.imcore.message;

import com.tencent.mobileqq.msg.api.IMessageFacade;
import java.util.Map;

class RandomGetMessageLoader$1$1
  implements Runnable
{
  RandomGetMessageLoader$1$1(RandomGetMessageLoader.1 param1) {}
  
  public void run()
  {
    if (this.a.this$0.a.b.getRefreshActionMap().containsKey(UinTypeUtil.a(this.a.c, this.a.d))) {
      this.a.this$0.a.b.getRefreshActionMap().remove(UinTypeUtil.a(this.a.c, this.a.d));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.RandomGetMessageLoader.1.1
 * JD-Core Version:    0.7.0.1
 */