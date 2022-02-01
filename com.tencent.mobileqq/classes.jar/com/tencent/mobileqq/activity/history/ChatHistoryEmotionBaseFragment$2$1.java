package com.tencent.mobileqq.activity.history;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;
import mqq.os.MqqHandler;

class ChatHistoryEmotionBaseFragment$2$1
  implements Runnable
{
  ChatHistoryEmotionBaseFragment$2$1(ChatHistoryEmotionBaseFragment.2 param2, List paramList) {}
  
  public void run()
  {
    if (this.a.size() == 1) {
      this.b.b.a.getMessageFacade().a((MessageRecord)this.a.get(0), false);
    } else if (this.a.size() > 1) {
      this.b.b.a.getMessageFacade().a(this.a, false);
    }
    this.b.b.t.sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryEmotionBaseFragment.2.1
 * JD-Core Version:    0.7.0.1
 */