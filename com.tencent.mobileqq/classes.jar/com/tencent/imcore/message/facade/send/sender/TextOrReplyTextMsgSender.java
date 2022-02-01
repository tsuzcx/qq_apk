package com.tencent.imcore.message.facade.send.sender;

import com.tencent.imcore.message.facade.IMessageSender;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;

class TextOrReplyTextMsgSender
  implements IMessageSender<QQAppInterface>
{
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    if (paramMessageRecord.istroop == 1001)
    {
      if (!paramQQAppInterface.isLBSFriendNewClient(paramMessageRecord.frienduin)) {
        ReportController.b(paramQQAppInterface, "dc00899", "grp_lbs", "", "nearby_chat", "nearby_use_old_channel", 0, 0, paramMessageRecord.frienduin, String.valueOf(paramMessageRecord.msgtype), String.valueOf(paramMessageRecord.istroop), "");
      }
    }
    else if (paramMessageRecord.istroop == 1003) {
      ReportController.b(paramQQAppInterface, "dc00899", "grp_lbs", "", "nearby_chat", "nearby_use_old_channel", 0, 0, paramMessageRecord.frienduin, String.valueOf(paramMessageRecord.msgtype), String.valueOf(paramMessageRecord.istroop), "");
    }
    paramQQAppInterface.getMsgHandler().a(paramMessageRecord, null, paramBoolean);
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    return (paramMessageRecord.msgtype == -1000) || (paramMessageRecord.msgtype == -1049);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.send.sender.TextOrReplyTextMsgSender
 * JD-Core Version:    0.7.0.1
 */