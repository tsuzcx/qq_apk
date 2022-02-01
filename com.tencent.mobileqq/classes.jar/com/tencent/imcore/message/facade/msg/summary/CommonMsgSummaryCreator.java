package com.tencent.imcore.message.facade.msg.summary;

import android.content.Context;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.facade.IMsgSummaryCreator;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.MsgUtils;

class CommonMsgSummaryCreator
  implements IMsgSummaryCreator<QQMessageFacade, QQAppInterface>
{
  public String a(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade, Context paramContext, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    Message localMessage = new Message();
    MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
    localMessage.emoRecentMsg = null;
    localMessage.fileType = -1;
    paramQQMessageFacade.a(localMessage);
    paramQQMessageFacade = new MsgSummary();
    MsgUtils.a(paramContext, paramQQAppInterface, localMessage, localMessage.istroop, paramQQMessageFacade, localMessage.nickName, false, paramBoolean);
    return paramQQMessageFacade.a(paramContext).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.msg.summary.CommonMsgSummaryCreator
 * JD-Core Version:    0.7.0.1
 */