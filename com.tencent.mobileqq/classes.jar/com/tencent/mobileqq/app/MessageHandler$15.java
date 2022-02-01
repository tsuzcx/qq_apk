package com.tencent.mobileqq.app;

import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.qphone.base.util.QLog;

class MessageHandler$15
  implements Runnable
{
  MessageHandler$15(MessageHandler paramMessageHandler, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      ConfessMsgUtil.b(this.this$0.n, false);
      ConfessMsgUtil.a(this.this$0.n, false);
      this.this$0.g(this.a);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.e("Q.msg.MessageHandler", 1, "sendMsgReadedReportInAll error :", localRuntimeException);
      throw localRuntimeException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandler.15
 * JD-Core Version:    0.7.0.1
 */