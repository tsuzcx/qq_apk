package com.tencent.mobileqq.activity.aio.photo;

import ajhz;
import ajke;
import awqx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AccountNotMatchException;

class AIOImageProviderService$7
  implements Runnable
{
  AIOImageProviderService$7(AIOImageProviderService paramAIOImageProviderService, long paramLong) {}
  
  public void run()
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.this$0.a);
      ChatMessage localChatMessage = this.this$0.a(this.a);
      QQMessageFacade localQQMessageFacade;
      if (localChatMessage != null)
      {
        localQQMessageFacade = localQQAppInterface.a();
        if (!ajke.a(localChatMessage)) {
          break label157;
        }
        ajke.a(localChatMessage);
        break label180;
      }
      for (;;)
      {
        localQQMessageFacade.a(localChatMessage.frienduin, localChatMessage.istroop, localChatMessage.uniseq, "extStr", localChatMessage.extStr);
        if (QLog.isColorLevel()) {
          QLog.d("Q.hotchat", 2, "makeFlashPicReaded,uin:" + this.this$0.b + ",type:" + localChatMessage.istroop + ",extStr" + localChatMessage.extStr);
        }
        awqx.b(localQQAppInterface, "CliOper", "", "", "0X8005979", "0X8005979", 0, 0, "", "", "", "");
        return;
        label157:
        ajhz.a(localChatMessage);
        Iterator localIterator = localQQMessageFacade.b(localChatMessage.frienduin, localChatMessage.msgtype).iterator();
        label180:
        if (localIterator.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
          if (localMessageRecord.uniseq != this.a) {
            break;
          }
          ajhz.a(localMessageRecord);
        }
      }
      return;
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      QLog.d("Q.hotchat", 2, "setFlashPicReaded，account no match exception");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService.7
 * JD-Core Version:    0.7.0.1
 */