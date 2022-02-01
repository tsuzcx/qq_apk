package com.tencent.mobileqq.activity.history;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;
import mqq.os.MqqHandler;

class ChatHistoryMediaBaseFragment$1$1
  implements Runnable
{
  ChatHistoryMediaBaseFragment$1$1(ChatHistoryMediaBaseFragment.1 param1, List paramList) {}
  
  public void run()
  {
    if (this.a.size() == 1) {
      this.b.b.a.getMessageFacade().a((MessageRecord)this.a.get(0), false);
    } else if (this.a.size() > 1) {
      this.b.b.a.getMessageFacade().a(this.a, false);
    }
    this.b.b.w.sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryMediaBaseFragment.1.1
 * JD-Core Version:    0.7.0.1
 */