package com.tencent.mobileqq.app;

import amns;
import com.tencent.qphone.base.util.QLog;

class MessageHandler$16
  implements Runnable
{
  MessageHandler$16(MessageHandler paramMessageHandler, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      amns.b(this.this$0.app, false);
      amns.a(this.this$0.app, false);
      this.this$0.e(this.a);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.e("Q.msg.MessageHandler", 1, "sendMsgReadedReportInAll error :", localRuntimeException);
      throw localRuntimeException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandler.16
 * JD-Core Version:    0.7.0.1
 */