package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import alaq;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.qphone.base.util.QLog;

public class ScribbleBaseOperator$1
  implements Runnable
{
  public void run()
  {
    this.this$0.a.getMessageFacade().addMessage(this.a, this.this$0.a.getCurrentAccountUin());
    this.this$0.a(this.a, this.a.localFildPath, null);
    QLog.i("SCRIBBLEMSG", 2, "!!!addMessage uniseq:" + this.a.uniseq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.ScribbleBaseOperator.1
 * JD-Core Version:    0.7.0.1
 */