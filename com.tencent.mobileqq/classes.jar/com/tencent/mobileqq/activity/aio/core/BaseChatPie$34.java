package com.tencent.mobileqq.activity.aio.core;

import com.tencent.imcore.message.QQMessageFacade.RefreshMessageContext;

class BaseChatPie$34
  implements Runnable
{
  BaseChatPie$34(BaseChatPie paramBaseChatPie, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext) {}
  
  public void run()
  {
    if (this.val$refreshMessageContext.needAutoNavigateTop)
    {
      if (this.val$refreshMessageContext.isSuccess)
      {
        this.this$0.refresh(131079);
        return;
      }
      this.this$0.refresh(131078);
      return;
    }
    this.this$0.refresh(131076);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.34
 * JD-Core Version:    0.7.0.1
 */