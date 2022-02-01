package com.tencent.imcore.message;

import acmw;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;

public class ConversationFacade$1
  implements Runnable
{
  public ConversationFacade$1(acmw paramacmw) {}
  
  public void run()
  {
    acmw.a(this.this$0);
    acmw.a(this.this$0).getMsgHandler().notifyUI(8023, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.imcore.message.ConversationFacade.1
 * JD-Core Version:    0.7.0.1
 */