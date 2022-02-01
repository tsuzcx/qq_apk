package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.api.IPicFlash;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AccountNotMatchException;

class AIOImageProviderService$5
  implements Runnable
{
  AIOImageProviderService$5(AIOImageProviderService paramAIOImageProviderService, long paramLong) {}
  
  public void run()
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.this$0.a);
      ChatMessage localChatMessage = this.this$0.a(this.a);
      if (localChatMessage != null)
      {
        Object localObject = localQQAppInterface.getMessageFacade();
        if (HotChatHelper.a(localChatMessage))
        {
          HotChatHelper.a(localChatMessage);
        }
        else
        {
          ((IPicFlash)QRoute.api(IPicFlash.class)).setFlashPicMsgReaded(localChatMessage);
          Iterator localIterator = ((QQMessageFacade)localObject).a(localChatMessage.frienduin, localChatMessage.msgtype).iterator();
          while (localIterator.hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
            if (localMessageRecord.uniseq == this.a) {
              ((IPicFlash)QRoute.api(IPicFlash.class)).setFlashPicMsgReaded(localMessageRecord);
            }
          }
        }
        ((QQMessageFacade)localObject).a(localChatMessage.frienduin, localChatMessage.istroop, localChatMessage.uniseq, "extStr", localChatMessage.extStr);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("makeFlashPicReaded,uin:");
          ((StringBuilder)localObject).append(this.this$0.b);
          ((StringBuilder)localObject).append(",type:");
          ((StringBuilder)localObject).append(localChatMessage.istroop);
          ((StringBuilder)localObject).append(",extStr");
          ((StringBuilder)localObject).append(localChatMessage.extStr);
          QLog.d("Q.hotchat", 2, ((StringBuilder)localObject).toString());
        }
      }
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8005979", "0X8005979", 0, 0, "", "", "", "");
      return;
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      label257:
      break label257;
    }
    QLog.d("Q.hotchat", 2, "setFlashPicReaded，account no match exception");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService.5
 * JD-Core Version:    0.7.0.1
 */