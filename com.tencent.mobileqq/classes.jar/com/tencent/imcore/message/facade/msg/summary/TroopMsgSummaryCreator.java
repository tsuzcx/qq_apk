package com.tencent.imcore.message.facade.msg.summary;

import android.content.Context;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.facade.IMsgSummaryCreator;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

public class TroopMsgSummaryCreator
  implements IMsgSummaryCreator<QQMessageFacade, QQAppInterface>
{
  public String a(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade, Context paramContext, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    return MsgSummaryProvider.a(paramQQAppInterface, paramQQMessageFacade, paramContext, paramMessageRecord, paramBoolean).a(paramContext).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.facade.msg.summary.TroopMsgSummaryCreator
 * JD-Core Version:    0.7.0.1
 */