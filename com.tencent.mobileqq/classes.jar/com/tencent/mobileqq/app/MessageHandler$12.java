package com.tencent.mobileqq.app;

import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;

class MessageHandler$12
  implements Runnable
{
  MessageHandler$12(MessageHandler paramMessageHandler, long paramLong1, String paramString1, String paramString2, byte paramByte, String paramString3, long paramLong2, long paramLong3) {}
  
  public void run()
  {
    long l2 = this.a;
    long l3 = 3L - l2;
    long l1 = 480000L;
    if (l2 != 0L) {
      l1 = 480000L * l3 / 3L - l3 * 2000L;
    }
    boolean bool = this.this$0.n.getMessageFacade().getLastMessage(this.b, 1001).hasReply;
    MessageHandler.a(this.this$0, this.b, this.c, this.d, bool ^ true, this.e, this.f, this.g, l1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandler.12
 * JD-Core Version:    0.7.0.1
 */