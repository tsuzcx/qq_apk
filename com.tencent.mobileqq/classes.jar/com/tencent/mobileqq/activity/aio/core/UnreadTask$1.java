package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.activity.aio.core.msglist.IReadConfirmCallback;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.MsgListRegister;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.List;

class UnreadTask$1
  implements Runnable
{
  UnreadTask$1(UnreadTask paramUnreadTask) {}
  
  public void run()
  {
    Object localObject = this.this$0.a.a();
    this.this$0.a((QQAppInterface)localObject);
    localObject = this.this$0.a.e().a().b().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IReadConfirmCallback)((Iterator)localObject).next()).b(this.this$0.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.UnreadTask.1
 * JD-Core Version:    0.7.0.1
 */