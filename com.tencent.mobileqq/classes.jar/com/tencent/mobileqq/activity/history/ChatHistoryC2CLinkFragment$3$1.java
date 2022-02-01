package com.tencent.mobileqq.activity.history;

import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;
import mqq.os.MqqHandler;

class ChatHistoryC2CLinkFragment$3$1
  implements Runnable
{
  ChatHistoryC2CLinkFragment$3$1(ChatHistoryC2CLinkFragment.3 param3, List paramList) {}
  
  public void run()
  {
    if (this.a.size() == 1) {
      this.b.b.u.getMessageFacade().a((MessageRecord)this.a.get(0), false);
    } else if (this.a.size() > 1) {
      this.b.b.u.getMessageFacade().a(this.a, false);
    }
    Message localMessage = this.b.b.K.obtainMessage(2);
    localMessage.obj = this.a;
    this.b.b.K.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CLinkFragment.3.1
 * JD-Core Version:    0.7.0.1
 */