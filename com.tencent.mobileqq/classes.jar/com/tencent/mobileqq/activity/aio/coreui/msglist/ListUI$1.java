package com.tencent.mobileqq.activity.aio.coreui.msglist;

import com.tencent.imcore.message.RefreshMessageContext;
import com.tencent.mobileqq.activity.aio.core.AIOContext;

class ListUI$1
  implements Runnable
{
  ListUI$1(ListUI paramListUI, RefreshMessageContext paramRefreshMessageContext) {}
  
  public void run()
  {
    if (this.a.g)
    {
      if (this.a.i)
      {
        this.this$0.b.c(131080);
        return;
      }
      this.this$0.b.c(131079);
      return;
    }
    if (this.a.k)
    {
      this.this$0.b.c(131077);
      return;
    }
    this.this$0.b.c(131076);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI.1
 * JD-Core Version:    0.7.0.1
 */