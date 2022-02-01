package com.tencent.imcore.message.facade.notify;

import com.tencent.imcore.message.facade.IMessageNotifyProcessor;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

public class CommonMessageNotifyProcessor
  implements IMessageNotifyProcessor<QQAppInterface>
{
  public void a(QQAppInterface paramQQAppInterface, List<MessageRecord> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      paramQQAppInterface.getMsgHandler().notifyUI(8020, true, paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.facade.notify.CommonMessageNotifyProcessor
 * JD-Core Version:    0.7.0.1
 */