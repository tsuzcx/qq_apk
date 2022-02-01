package com.tencent.imcore.message;

import aczu;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

public class C2CMessageManager$1
  implements Runnable
{
  public C2CMessageManager$1(aczu paramaczu, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "doMsgRevokeRequest " + this.a.getLogColorContent());
    }
    this.this$0.a.a().a(this.a, 15000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.imcore.message.C2CMessageManager.1
 * JD-Core Version:    0.7.0.1
 */