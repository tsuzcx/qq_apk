package com.tencent.imcore.message.facade.notify;

import com.tencent.imcore.message.facade.IMessageNotifyProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.List;

public class QQGameMessageNotifyProcessor
  implements IMessageNotifyProcessor<QQAppInterface>
{
  public void a(QQAppInterface paramQQAppInterface, List<MessageRecord> paramList)
  {
    ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).notiftyQQGameNewMsg(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.notify.QQGameMessageNotifyProcessor
 * JD-Core Version:    0.7.0.1
 */