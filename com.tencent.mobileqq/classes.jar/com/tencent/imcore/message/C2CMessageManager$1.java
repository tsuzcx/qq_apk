package com.tencent.imcore.message;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class C2CMessageManager$1
  implements Runnable
{
  C2CMessageManager$1(C2CMessageManager paramC2CMessageManager, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doMsgRevokeRequest ");
      localStringBuilder.append(this.a.getLogColorContent());
      QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
    }
    BaseMessageManager.a.a(this.this$0.a, this.a, 15000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.C2CMessageManager.1
 * JD-Core Version:    0.7.0.1
 */